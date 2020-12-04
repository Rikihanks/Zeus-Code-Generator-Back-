package com.cg.zeus.util;

public class StringUtils {
    //Common
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    public static String AUTOM_GENERATED_MESSAGE = "/*\nThis class has been generated automatically by Zeus Code Generator.\n*/";
    public static String TABS = "    ";
    public static String LIST_OF = "List <#of>";
    public static String OVERRIDE = "@Override";
    //Interfaces
    public static String INTERFACE_SERVICE_HEADER = "public interface ";
    public static String IMPLEMENTATION_SERVICE_HEADER = "public class #entityServiceImp implements I#entityService ";
    public static String INTERFACE_SERVICE_NAME = "I#entityService";
    public static String IMPLEMENTATION_SERVICE_NAME = "#entityService";
    //Dto
    public static String DTO_HEADER = "public class #entity";
    public static String DTO_FIELD = "private #fieldType #fieldName";
    public static String DTO_GETTER = "public #fieldType get#fieldName";


    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
