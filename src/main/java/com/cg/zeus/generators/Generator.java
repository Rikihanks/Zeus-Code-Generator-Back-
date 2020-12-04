package com.cg.zeus.generators;

import java.util.HashMap;
import java.util.Map;

public abstract class Generator {

    public abstract String generate(String entityName, HashMap<String, String> entityFields, String idFieldName);


    public HashMap<String, String> copyTypes(HashMap<String, String> map) {
        HashMap<String,String> fields = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            fields.put(entry.getKey(), entry.getValue());
        }
        return fields;
    }

}
