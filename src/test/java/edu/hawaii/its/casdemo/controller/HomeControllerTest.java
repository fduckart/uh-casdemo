package edu.hawaii.its.casdemo.controller;

import edu.hawaii.its.casdemo.access.Role;
import edu.hawaii.its.casdemo.access.User;
import edu.hawaii.its.casdemo.action.ActionRecorder;
import edu.hawaii.its.casdemo.security.UserContextServiceImpl;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class HomeControllerTest {

    private HomeController controller;

    @Before
    public void setUp() {
        controller = new HomeController();
        controller.setUserContextService(new UserContextServiceImpl() {
            private User user;

            private synchronized void populate() {
                if (user == null) {
                    Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
                    authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
                    user = new User("duckart", authorities);
                    user.setUhuuid(Long.valueOf(89999999));
                }
            }

            public User getCurrentUser() {
                populate();
                return user;
            }

            public String getCurrentUsername() {
                populate();
                return user.getUsername();
            }

            public Long getCurrentUhuuid() {
                populate();
                return user.getUhuuid();
            }

        });

        controller.setActionRecorder(new ActionRecorder() {
            public void publish(String code, Long uhuuid) {
                // Do nothing.
            }
        });
    }
}
