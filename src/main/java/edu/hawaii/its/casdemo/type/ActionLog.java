package edu.hawaii.its.casdemo.type;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIONLOG", schema = "UHAPP_DB")
public class ActionLog implements Serializable {

    private Long id;
    private Long actionId;
    private Long userUhuuid; // Logged in user.
    private Long viewUhuuid; // User viewed.

    public ActionLog() {
        // Empty. Required for JPA.
    }

    public ActionLog(Long actionId, Long userUhuuid) {
        this.actionId = actionId;
        this.userUhuuid = userUhuuid;
    }

    @Id
    @Column(name = "ACTLOG_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actionlog_seq_gen")
    @SequenceGenerator(name = "actionlog_seq_gen", sequenceName = "UHAPP_DB.ACTIONLOG_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "ACTION_ID")
    public Long getActionId() {
        return actionId;
    }

    @Column(name = "ACTLOG_USER_UHNUMBER")
    public Long getUserUhuuid() {
        return userUhuuid;
    }

    @Column(name = "ACTLOG_VIEW_UHNUMBER")
    public Long getViewUhuuid() {
        return viewUhuuid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public void setUserUhuuid(Long userUhuuid) {
        this.userUhuuid = userUhuuid;
    }

    public void setViewUhuuid(Long viewUhuuid) {
        this.viewUhuuid = viewUhuuid;
    }

    @Override
    public String toString() {
        return "ActionLog [id=" + id
                + ", actionId=" + actionId
                + ", userUhuuid=" + userUhuuid
                + ", viewUhuuid=" + viewUhuuid
                + "]";
    }

}
