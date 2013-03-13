package com.sphinxsearch.indexer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Document {

    private int id;

    private List<DocumentProperty> documentProperties = new ArrayList<DocumentProperty>();

    public Document(int id, DocumentProperty... documentProperties ) {
        this.id = id;
        addProperties(documentProperties);
    }

    public Document addProperties(DocumentProperty... documentProperties) {
        this.documentProperties.addAll(Arrays.asList(documentProperties));
        return this; 
    }

    public Document addProperty(String name, Object value){
        addProperties(new DocumentProperty(name, value.toString()));
        return this;
    }

    public Document setMVA(String name, int... values){
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                list.append(", ");
            }
            list.append(values[i]);
        }

        addProperties(new DocumentProperty(name, list.toString()));
        return this;
    }

    public Document setFlag(String name){
        addProperties(new DocumentProperty(name, "1"));
        return this;
    }

    public String getXmlpipe2Tag() {
        StringBuilder sb = new StringBuilder("<sphinx:document id=\"" + id + "\">\n");
        for (DocumentProperty property : documentProperties) {
            sb.append(property.getXmlpipe2Tag());
        }
        sb.append("</sphinx:document>");
        return sb.toString();
    }
}
