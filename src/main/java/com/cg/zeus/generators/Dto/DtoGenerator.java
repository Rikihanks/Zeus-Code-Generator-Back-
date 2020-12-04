package com.cg.zeus.generators.Dto;


import com.cg.zeus.generators.Generator;
import com.cg.zeus.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class DtoGenerator extends Generator {


    @Override
    public String generate(String entityName, HashMap<String, String> entityFields, String idFieldName) {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.AUTOM_GENERATED_MESSAGE);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateHeader(entityName));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.TABS);
        sb.append(generatePrivateFields(entityFields));
        sb.append((generateEmptyConstructor(entityName)));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.TABS);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.TABS);
        sb.append(generateConstructorWithFields(entityName, entityFields));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(generateGettersAndSetters(entityFields));
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append(StringUtils.LINE_SEPARATOR);
        sb.append("}");
        return sb.toString();
    }

    private String generateGettersAndSetters(HashMap<String, String> entityFields) {
        String body = "";
        for (Map.Entry<String, String> entry : entityFields.entrySet()) {
            body+= StringUtils.LINE_SEPARATOR;
            body+=StringUtils.TABS;
            body+= "public "+entry.getValue()+ " get" + StringUtils.capitalize(entry.getKey()) + "() { return "+entry.getKey() +"; }\n";
            body+= StringUtils.LINE_SEPARATOR;
            body+=StringUtils.TABS;
            body+= "public void set"+StringUtils.capitalize(entry.getKey())+"("+entry.getValue()+" "+entry.getKey()+")";
            body+= " { this."+entry.getKey()+ " = "+entry.getKey() + "; }";
            body+= StringUtils.LINE_SEPARATOR;
        }

        return body;
    }

    private String generateConstructorWithFields(String entityName, HashMap<String, String> entityFields) {
       String hConstructor = generateEmptyConstructor(entityName);
        hConstructor = hConstructor.replace("){}", "");
        for (Map.Entry<String, String> entry : entityFields.entrySet()) {
            hConstructor+= entry.getValue()+ " " + entry.getKey() + ", ";
        }
        hConstructor = hConstructor.substring(0, hConstructor.length() - 2);
        hConstructor += "){"+StringUtils.LINE_SEPARATOR;

        for (Map.Entry<String, String> entry : entityFields.entrySet()) {
            hConstructor+=StringUtils.TABS+StringUtils.TABS;
            hConstructor+= "this."+entry.getKey()+ " = " + entry.getKey() + ";\n";
        }
        hConstructor+=StringUtils.TABS+"}";

        return  hConstructor;
    }

    private String generateEmptyConstructor(String entityName) {
        return "public "+entityName+"Dto(){}";
    }

    private String generateHeader(String entityName) {
        return StringUtils.DTO_HEADER.replace("#entity", entityName+"Dto {");
    }

    private String generatePrivateFields(HashMap<String, String> fields) {
        String result = "";

        for (Map.Entry<String, String> entry : fields.entrySet()) {
            result+= StringUtils.DTO_FIELD.replace("#fieldType",entry.getValue())
                                           .replace("#fieldName", entry.getKey() + ";\n");
            result+= StringUtils.LINE_SEPARATOR;
            result+=StringUtils.TABS;
        }

        return result;
    }

    public String generateDtoName(String entity) {
        return entity+"Dto";
    }
}
