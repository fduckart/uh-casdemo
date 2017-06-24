package edu.hawaii.its.casdemo.type;

public interface PersonIdentifiable {
    default String getUhUuid() {
        return "";
    }
}
