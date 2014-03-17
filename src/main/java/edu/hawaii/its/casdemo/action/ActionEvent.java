package edu.hawaii.its.casdemo.action;

import org.springframework.context.ApplicationEvent;

public class ActionEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5308299518665062983L;
    private Long uhuuid;
    private Long viewUhuuid;
    private String code;

    public ActionEvent(Object source, String code, Long uhuuid, Long viewUhuuid) {
        super(source);
        this.code = code;
        this.uhuuid = uhuuid;
        this.viewUhuuid = viewUhuuid;
    }

    public Long getUhuuid() {
        return uhuuid;
    }

    public Long getViewUhuuid() {
        return viewUhuuid;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return "ActionEvent ["
                + ", uhuuid=" + uhuuid
                + ", viewUhuuid=" + viewUhuuid
                + ", code=" + code + "]";
    }
}
