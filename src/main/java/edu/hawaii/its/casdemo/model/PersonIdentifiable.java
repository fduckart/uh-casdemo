package edu.hawaii.its.casdemo.model;

public interface PersonIdentifiable {

    default String getUhUuid() {
        return "";
    }
}
