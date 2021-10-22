package edu.hawaii.its.casdemo.access;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UhCasAttributes implements UhAttributes {

    private final String username; // CAS login username.
    private final Map<?, ?> map; // Original CAS results.
    private Map<String, List<String>> attributes =
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    // Constructor.
    public UhCasAttributes() {
        this(new TreeMap<>());
    }

    // Constructor.
    public UhCasAttributes(Map<?, ?> map) {
        this("", map);
    }

    // Constructor.
    public UhCasAttributes(String username, Map<?, ?> map) {
        this.username = username != null ? username : "";
        this.map = map;
        if (map != null) {
            for (Object key : map.keySet()) {
                if (key != null && key instanceof String) {
                    String k = (String) key;
                    Object v = map.get(key);
                    if (v != null) {
                        if (v instanceof String) {
                            attributes.put(k, Arrays.asList((String) v));
                        } else if (v instanceof List) {
                            List<String> lst = new ArrayList<>();
                            for (Object o : (List<?>) v) {
                                if (o instanceof String) {
                                    lst.add((String) o);
                                }
                            }
                            attributes.put(k, lst);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getName() {
        return getValue("cn");
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getUid() {
        List<String> values = attributes.get("uid");
        if (values != null) {
            // Check expected case first.
            if (values.size() == 1) {
                return values.get(0); // We are done.
            }

            if (values.size() > 1) {
                // More than one uid in the results.
                // Try to match up with the username.
                for (String s : values) {
                    if (s.equals(getUsername())) {
                        return s;
                    }
                }

                // Couldn't match up username with uid,
                // so just return first value.
                return values.get(0); // We are done.
            }
        }

        return ""; // Didn't find anything.
    }

    @Override
    public String getUhUuid() {
        return getValue("uhUuid");
    }

    @Override
    public List<String> getMail() {
        return getValues("mail");
    }

    @Override
    public List<String> getAffiliation() {
        return getValues("eduPersonAffiliation");
    }

    @Override
    public List<String> getValues(String name) {
        if (name != null) {
            List<String> results = attributes.get(name);
            if (results != null) {
                return Collections.unmodifiableList(results);
            }
        }

        return Collections.emptyList();
    }

    @Override
    public String getValue(String name) {
        List<String> results = getValues(name);
        return results.isEmpty() ? "" : results.get(0);
    }

    @Override
    public Map<String, List<String>> getMap() {
        return Collections.unmodifiableMap(attributes);
    }

    @Override
    public Map<?, ?> getRawMap() {
        return Collections.unmodifiableMap(map);
    }

    @Override
    public String toString() {
        return "UhCasAttributes [username=" + username
                + ", attributes=" + attributes
                + ", map=" + map + "]";
    }

}
