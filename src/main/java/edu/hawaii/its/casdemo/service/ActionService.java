package edu.hawaii.its.casdemo.service;

import java.util.List;

import edu.hawaii.its.casdemo.type.Action;
import edu.hawaii.its.casdemo.type.ActionLog;

public interface ActionService {
    public List<Action> findActions();

    public void record(ActionLog actionLog);

    public long logCount();
}
