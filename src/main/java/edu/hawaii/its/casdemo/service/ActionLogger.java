package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Action;
import java.util.List;

public interface ActionLogger {
    public List<Action> findActions();
}
