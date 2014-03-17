package edu.hawaii.its.casdemo.action;

import org.springframework.context.ApplicationListener;

public interface ActionListener extends ApplicationListener<ActionEvent> {
    public int mapSize();
}
