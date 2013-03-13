package com.sphinxsearch.indexer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IndexDescription {

    private IndexDescription() {
    }

    private List<String> fields = new ArrayList<String>();

    private List<Attribute> attributes = new ArrayList<Attribute>();

    public static IndexDescription createIndexDescription(String... fields) {
        IndexDescription indexDescription = new IndexDescription();
        indexDescription.fields.addAll(Arrays.asList(fields));
        return indexDescription;
    }

    public IndexDescription addFields(String... fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    public IndexDescription addAttribute(Attribute attr) {
        attributes.add(attr);
        return this;
    }

    public IndexDescription addBooleanAttribute(String name) {
        addAttribute(Attribute.createBooleanAttribute(name));
        return this;
    }

    public IndexDescription addFloatAttribute(String name) {
        addAttribute(Attribute.createFloatAttribute(name));
        return this;
    }

    public IndexDescription addIntegerAttribute(String name) {
        addAttribute(Attribute.createIntegerAttribute(name));
        return this;
    }

    public IndexDescription addMultiValueAttribute(String name) {
        addAttribute(Attribute.createMultiValueAttribute(name));
        return this;
    }

    public IndexDescription addStr2OrdinalAttribute(String name) {
        addAttribute(Attribute.createStr2OrdinalAttribute(name));
        return this;
    }

    public IndexDescription addTimestampAttribute(String name) {
        addAttribute(Attribute.createTimestampAttribute(name));
        return this;
    }

    public String getXmlpipe2Tag() {
        StringBuilder sb = new StringBuilder();
        sb.append("<sphinx:schema>\n");
        for (String field : fields) {
            sb.append(String.format("<sphinx:field name=\"%s\"/>\n", field));
        }
        for (Attribute attribute : attributes) {
            sb.append(attribute.getXmlpipe2Tag()).append("\n");
        }
        sb.append("</sphinx:schema>\n");
        return sb.toString();
    }
}
