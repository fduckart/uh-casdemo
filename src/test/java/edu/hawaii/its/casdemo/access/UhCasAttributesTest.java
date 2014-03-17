package edu.hawaii.its.casdemo.access;

import static org.junit.Assert.assertEquals;
import edu.hawaii.its.casdemo.type.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class UhCasAttributesTest {

    @Test
    public void loadNullMap() {
        UhCasAttributes attributes = new UhCasAttributes(null);
        assertEquals("", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
        assertEquals("", attributes.getValue("not-a-key"));
    }

    @Test
    public void loadMapValid() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uhuuid", "666666");
        map.put("uid", "duckart");

        UhCasAttributes attributes = new UhCasAttributes(map);

        assertEquals("666666", attributes.getValue("uhuuid"));
        assertEquals("duckart", attributes.getValue("uid"));
        assertEquals("", attributes.getValue("not-a-key"));
        assertEquals("", attributes.getValue(null));
    }

    @Test
    public void loadMapInvalidValueType() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uhuuid", "666666");
        map.put("uid", new Integer(666));
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("666666", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid")); // Internal error.
        assertEquals("", attributes.getValue("not-a-key"));
    }

    @Test
    public void loadMapInvalidKeyType() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uhuuid", "666666");
        map.put(new Integer(666), new Integer(666));
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("666666", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
        assertEquals("", attributes.getValue("not-a-key"));
    }

    @Test
    public void loadMapInvalidTypes() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put(new Integer(666), new Integer(666));
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
        assertEquals("", attributes.getValue("not-a-key"));
    }

    @Test
    public void loadMapWithArrayList() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uHuuid", "10967714");
        List<Object> uids = new ArrayList<Object>();
        uids.add("cahana");
        uids.add("mjrules");
        map.put("uid", uids);
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("10967714", attributes.getValue("uhuuid"));
        assertEquals("cahana", attributes.getValue("uid"));
    }

    @Test
    public void loadMapWithArrayListWithNullEntries() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uHuuid", "10967714");
        List<Object> uids = new ArrayList<Object>();
        uids.add(null);
        uids.add(null);
        map.put("uid", uids);
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uid"));
        assertEquals("10967714", attributes.getValue("uhuuid"));
    }

    @Test
    public void loadMapWithArrayListWithEmptyEntries() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uHuuid", "10967714");
        List<Object> uids = new ArrayList<Object>();
        uids.add("");
        uids.add("");
        map.put("uid", uids);
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uid"));
        assertEquals("10967714", attributes.getValue("uhuuid"));
    }

    @Test
    public void loadMapWithArrayListWithManyEntries() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uHuuid", "10967714");
        List<Object> uids = new ArrayList<Object>();
        for (int i = 0; i < 50; i++) {
            uids.add("");
        }
        uids.add("cahana");
        map.put("uid", uids);
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uid")); // Note this result.
        assertEquals("10967714", attributes.getValue("uhuuid"));
    }

    @Test
    public void loadMapWithNullMap() {
        Map<Object, Object> map = null;
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
    }

    @Test
    public void loadMapWithNullMapEntry() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uid", null);
        map.put("uHuuid", null);
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
    }

    @Test
    public void loadMapWithEmptyMapEntry() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uid", new ArrayList());
        map.put("uhuuid", new ArrayList(0));
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid"));
    }

    @Test
    public void loadMapWithNullKey() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uhuuid", "10967714");
        map.put(null, "cahana");
        UhCasAttributes attributes = new UhCasAttributes(map);
        assertEquals("10967714", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid")); // Note this result.
    }

    @Test
    public void loadMapWithUnexpectedType() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("uhuuid", "666666");

        Map<Long, Action> uidMap = new HashMap<Long, Action>();
        uidMap.put(new Long(666), new Action());
        map.put("uid", uidMap);

        UhCasAttributes attributes = new UhCasAttributes(map);

        assertEquals("666666", attributes.getValue("uhuuid"));
        assertEquals("", attributes.getValue("uid")); // Note result.
    }
}
