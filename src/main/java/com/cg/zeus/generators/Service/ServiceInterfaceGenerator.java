package com.cg.zeus.generators.Service;

import com.cg.zeus.generators.Generator;
import com.cg.zeus.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ServiceInterfaceGenerator extends Generator {

    @Override
    public String generate(String entityName, HashMap<String, String> entityFields, String idFieldName) {

        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.AUTOM_GENERATED_MESSAGE);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.INTERFACE_SERVICE_HEADER+ generateServiceName(entityName) +" {");
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateFind(entityName, entityFields, idFieldName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateAdd(entityName, copyTypes(entityFields), idFieldName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateUpdate(entityName, copyTypes(entityFields), idFieldName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateDelete(entityName, entityFields, idFieldName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateFindAll(entityName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append("}");
        return sb.toString();
    }

    public String generateServiceName(String entityName) {
        return StringUtils.INTERFACE_SERVICE_NAME.replace("#entity", entityName);
    }

    private String generateFindAll(String entityName) {
        return StringUtils.TABS +  StringUtils.LIST_OF.replace("#of", entityName)+ " findAll();";
    }

    private String generateDelete(String entityName, HashMap<String, String> entityFields, String idFieldName) {
        String tipoId = entityFields.get(idFieldName);
        return StringUtils.TABS + entityName + " delete("+ tipoId.toString() + " "  + idFieldName + ");";
    }

    private String generateUpdate(String entityName, Map<String, String> entityFields, String idFieldName) {
        String addResult = "";
        addResult+= StringUtils.TABS + entityName + " update(";

        for (Map.Entry<String, String> entry : entityFields.entrySet()) {
            addResult+= entry.getValue() + " " + entry.getKey() + ", ";
        }

        addResult = addResult.substring(0, addResult.length() - 2);
        addResult+= ");";
        return addResult;
    }

    private String generateAdd(String entityName, Map<String, String> entityFields, String idFieldName) {
        entityFields.remove(idFieldName);
        String addResult = "";
        addResult+= StringUtils.TABS + entityName + " add(";

        for (Map.Entry<String, String> entry : entityFields.entrySet()) {
            addResult+= entry.getValue() + " " + entry.getKey() + ", ";
        }

        addResult = addResult.substring(0, addResult.length() - 2);
        addResult+= ");";
        return addResult;

    }

    private String generateFind(String entityName, Map<String, String> entityFields, String idFieldName) {
        String tipoId = entityFields.get(idFieldName);
        return StringUtils.TABS + entityName + " find("+ tipoId.toString() + " "  + idFieldName + ");";
    }




}
