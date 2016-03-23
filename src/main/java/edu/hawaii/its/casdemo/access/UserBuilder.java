package edu.hawaii.its.casdemo.access;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.hawaii.its.casdemo.service.AdministratorService;
import edu.hawaii.its.casdemo.service.EmployeeService;

@Service
public final class UserBuilder {

	private static final Logger logger = LoggerFactory.getLogger(UserBuilder.class);

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private EmployeeService employeeService;

	public final User make(Map<String, ?> map) {
		return make(new UhCasAttributes(map));
	}

	public final User make(UhAttributes attributes) {

		String uid = attributes.getValue("uid");
		if (isEmpty(uid)) {
			throw new UsernameNotFoundException("uid is empty");
		}

		logger.info("Adding roles; uid: " + uid);
		RoleHolder roleHolder = new RoleHolder();
		roleHolder.add(Role.ANONYMOUS);
		roleHolder.add(Role.UH);

		String uhuuid = attributes.getValue("uhuuid");
		if (employeeService.exists(uhuuid)) {
			logger.info("Adding " + Role.EMPLOYEE + "; uid: " + uid);
			roleHolder.add(Role.EMPLOYEE);
		}

		if (administratorService.exists(uhuuid)) {
			logger.info("Adding " + Role.ADMIN + "; uid: " + uid);
			roleHolder.add(Role.ADMIN);
		}

		User user = new User(uid, roleHolder.getAuthorites());

		// Convert the uhuuid to a Long and record it.
		// Don't move this statement above the exists call
		// above because exists implicitly checks that the
		// Long data type conversion will work okay.
		user.setUhuuid(Long.valueOf(uhuuid));

		logger.info("Done adding roles; uhuuid: " + uhuuid);

		// Put all the attributes into the user
		// object just for the demonstration.
		// Above is what might commonly occur.
		user.setAttributes(attributes);

		return user;
	}

	private boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

}
