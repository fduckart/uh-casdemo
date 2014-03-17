package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Action;
import edu.hawaii.its.casdemo.type.ActionLog;
import java.util.List;

public interface ActionService {
    public List<Action> findActions();

    public void record(ActionLog actionLog);

    public int logCount();
}
