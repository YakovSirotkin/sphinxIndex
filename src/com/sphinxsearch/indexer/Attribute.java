package com.sphinxsearch.indexer;

public class Attribute {
    private String name;
    private AttributeType type;
    private String defaultValue = "";

    private Attribute() {
    }

    private Attribute(AttributeType type, String name) {
        this.name = name;
        this.type = type;
    }

    private Attribute(AttributeType type, String name, String defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getXmlpipe2Tag() {
        return String.format(
                "<sphinx:attr name=\"%s\" type=\"%s\" default=\"%s\"/>",
                name, type.getTypeName(), defaultValue);
    }
    public static Attribute createIntegerAttribute(String name) {
        return new Attribute(AttributeType.INTEGER, name, "0");
    }
    public static Attribute createTimestampAttribute(String name) {
        return new Attribute(AttributeType.TIMESTAMP, name);
    }
    public static Attribute createStr2OrdinalAttribute(String name) {
        return new Attribute(AttributeType.STR2ORDINAL, name);
    }
    public static Attribute createBooleanAttribute(String name) {
        return new Attribute(AttributeType.BOOLEAN, name, "0");
    }
    public static Attribute createFloatAttribute(String name) {
        return new Attribute(AttributeType.FLOAT, name, "0");
    }

    public static Attribute createMultiValueAttribute(String name) {
        return new Attribute(AttributeType.MULTI, name);
    }

    public static enum AttributeType {
        INTEGER("int"), TIMESTAMP("timestamp"), STR2ORDINAL("str2ordinal"), BOOLEAN("bool"), FLOAT("float"), MULTI("multi");

        private String typeName;

        AttributeType(String type) {
            this.typeName = type;
        }

        public String getTypeName() {
            return typeName;
        }
    }
}
