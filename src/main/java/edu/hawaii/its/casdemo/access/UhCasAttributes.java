package edu.hawaii.its.casdemo.access;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UhCasAttributes implements UhAttributes {

    private Map<String, String> attributes = new HashMap<String, String>();

    public UhCasAttributes(Map<Object, Object> map) {
        if (map != null) {
            for (Object key : map.keySet()) {
                if (key instanceof String) {
                    if (map.containsKey(key)) {
                        Object value = map.get(key);
                        if (value instanceof String) {
                            String attKey = String.valueOf(key).toLowerCase();
                            attributes.put(attKey, (String) value);
                        } else if (value instanceof ArrayList) {
                            ArrayList al = (ArrayList<String>) value;
                            if (!al.isEmpty()) {
                                String attValue = ((ArrayList<String>) value).get(0);
                                if (attValue != null) {
                                    String attKey = String.valueOf(key);
                                    attributes.put(attKey.toLowerCase(), attValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final String getValue(String key) {
        if (key == null) {
            return "";
        }
        String value = attributes.get(key.toLowerCase());
        return value != null ? value.trim() : "";
    }

    public Map<String, String> getMap() {
        return Collections.unmodifiableMap(attributes);
    }
    
    public String toString() {
        return "Attributes[map=" + attributes + "]";
    }
}
