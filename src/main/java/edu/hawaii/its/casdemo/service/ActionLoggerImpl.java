package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Action;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A JPA-based implementation of the ActionLogger Service. Delegates to a JPA entity
 * manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Repository
public class ActionLoggerImpl implements ActionLogger {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Action> findActions() {
        String qlString = "select a from Action a order by a.id";
        return em.createQuery(qlString).getResultList();
    }
}