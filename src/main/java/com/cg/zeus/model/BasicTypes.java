package com.cg.zeus.model;

public enum BasicTypes {
    byteType,
    shortType,
    intType,
    longType,
    floatType,
    doubleType,
    booleanType,
    charType,
    stringType;

    @Override
    public String toString() {
        switch (this) {
            case intType:
                return "int";
            case byteType:
                return "byte";
            case charType:
                return "char";
            case longType:
                return "long";
            case floatType:
                return "float";
            case shortType:
                return "short";
            case doubleType:
                return "double";
            case booleanType:
                return "boolean";
            case stringType:
                return "String";
            default:
                return  null;
        }
    }
}
