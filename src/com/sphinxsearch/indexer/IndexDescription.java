package com.sphinxsearch.indexer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IndexDescription {

    private IndexDescription() {
    }

    private final List<String> fields = new ArrayList<String>();

    private final List<Attribute> attributes = new ArrayList<Attribute>();

    public static IndexDescription createIndexDescription(final String... fields) {
        final IndexDescription indexDescription = new IndexDescription();
        indexDescription.fields.addAll(Arrays.asList(fields));
        return indexDescription;
    }

    public IndexDescription addFields(final String... fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    public IndexDescription addAttribute(final Attribute attr) {
        attributes.add(attr);
        return this;
    }

    public IndexDescription addBooleanAttribute(final String name) {
        addAttribute(Attribute.createBooleanAttribute(name));
        return this;
    }

    public IndexDescription addFloatAttribute(final String name) {
        addAttribute(Attribute.createFloatAttribute(name));
        return this;
    }

    public IndexDescription addIntegerAttribute(final String name) {
        addAttribute(Attribute.createIntegerAttribute(name));
        return this;
    }

    public IndexDescription addMultiValueAttribute(final String name) {
        addAttribute(Attribute.createMultiValueAttribute(name));
        return this;
    }

    public IndexDescription addStr2OrdinalAttribute(String name) {
        addAttribute(Attribute.createStr2OrdinalAttribute(name));
        return this;
    }

    public IndexDescription addTimestampAttribute(final String name) {
        addAttribute(Attribute.createTimestampAttribute(name));
        return this;
    }

    public String getXmlpipe2Tag() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<sphinx:schema>\n");
        for (final String field : fields) {
            sb.append(String.format("<sphinx:field name=\"%s\"/>\n", field));
        }
        for (final Attribute attribute : attributes) {
            sb.append(attribute.getXmlpipe2Tag()).append("\n");
        }
        sb.append("</sphinx:schema>\n");
        return sb.toString();
    }
}
