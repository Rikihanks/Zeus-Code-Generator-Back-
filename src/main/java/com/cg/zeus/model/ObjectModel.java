package com.cg.zeus.model;

import java.util.Map;

public class ObjectModel {

    private String idParamName;
    private String entityName;
    private Map<String, String> properties;

    public ObjectModel(String idParamName, String entityName, Map<String, String> properties) {
        this.entityName = entityName;
        this.idParamName = idParamName;
        this.properties = properties;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getIdParamName() {
        return idParamName;
    }

    public void setIdParamName(String idParamName) {
        this.idParamName = idParamName;
    }
}
