package com.sphinxsearch.indexer;

public class Attribute {
    private final String name;
    private final AttributeType type;
    private final String defaultValue;

    private Attribute(final AttributeType type, final String name) {
        this(type, name, "");
    }

    private Attribute(final AttributeType type, final String name, final String defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getXmlpipe2Tag() {
        return String.format(
                "<sphinx:attr name=\"%s\" type=\"%s\" default=\"%s\"/>",
                name, type.getTypeName(), defaultValue);
    }
    public static Attribute createIntegerAttribute(final String name) {
        return new Attribute(AttributeType.INTEGER, name, "0");
    }
    public static Attribute createTimestampAttribute(final String name) {
        return new Attribute(AttributeType.TIMESTAMP, name);
    }
    public static Attribute createStr2OrdinalAttribute(final String name) {
        return new Attribute(AttributeType.STR2ORDINAL, name);
    }
    public static Attribute createBooleanAttribute(final String name) {
        return new Attribute(AttributeType.BOOLEAN, name, "0");
    }
    public static Attribute createFloatAttribute(final String name) {
        return new Attribute(AttributeType.FLOAT, name, "0");
    }

    public static Attribute createMultiValueAttribute(final String name) {
        return new Attribute(AttributeType.MULTI, name);
    }

    public static enum AttributeType {
        INTEGER("int"), TIMESTAMP("timestamp"), STR2ORDINAL("str2ordinal"), BOOLEAN("bool"), FLOAT("float"), MULTI("multi");

        private final String typeName;

        AttributeType(final String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }
}
