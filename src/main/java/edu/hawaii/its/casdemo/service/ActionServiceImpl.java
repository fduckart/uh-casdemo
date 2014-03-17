package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Action;
import edu.hawaii.its.casdemo.type.ActionLog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * A JPA-based implementation of the Action Service. Delegates to a JPA entity
 * manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Service("actionService")
@Repository
public class ActionServiceImpl implements ActionService {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional(readOnly = true)
    public List<Action> findActions() {
        String qlString = "select a from Action a order by a.id";
        return em.createQuery(qlString).getResultList();
    }

    public Action findAction(Long id) {
        return em.find(Action.class, id);
    }

    @Transactional
    public void record(ActionLog actionLog) {
        em.persist(actionLog);
    }

    @Override
    public int logCount() {
        String qlString = "select a from ActionLog a";
        List<ActionLog> actionLogEntries = em.createQuery(qlString).getResultList();
        return actionLogEntries.size();
    }

}