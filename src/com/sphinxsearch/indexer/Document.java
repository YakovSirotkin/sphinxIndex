package com.sphinxsearch.indexer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Document {

    private final int id;

    private final List<DocumentProperty> documentProperties = new ArrayList<DocumentProperty>();

    public Document(final int id, final DocumentProperty... documentProperties ) {
        this.id = id;
        addProperties(documentProperties);
    }

    public Document addProperties(final DocumentProperty... documentProperties) {
        this.documentProperties.addAll(Arrays.asList(documentProperties));
        return this;
    }

    public Document addProperty(final String name, final Object value) {
        addProperties(new DocumentProperty(name, value.toString()));
        return this;
    }

    public Document setMVA(final String name, final int... values) {
        final StringBuilder list = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                list.append(", ");
            }
            list.append(values[i]);
        }

        addProperties(new DocumentProperty(name, list.toString()));
        return this;
    }

    public Document setFlag(final String name) {
        addProperties(new DocumentProperty(name, "1"));
        return this;
    }

    public String getXmlpipe2Tag() {
        final StringBuilder sb = new StringBuilder("<sphinx:document id=\"").append(id).append("\">\n");
        for (final DocumentProperty property : documentProperties) {
            sb.append(property.getXmlpipe2Tag());
        }
        sb.append("</sphinx:document>");
        return sb.toString();
    }
}
