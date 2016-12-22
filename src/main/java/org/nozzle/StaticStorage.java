package org.nozzle;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class StaticStorage {

    private static final Map<Integer, String> storage = new HashMap<>();

    public String getValue() {
        return storage.get(Collections.max(storage.keySet()));
    }

    public void store(final int id, final String value) {
        storage.put(id, value);
    }

}
