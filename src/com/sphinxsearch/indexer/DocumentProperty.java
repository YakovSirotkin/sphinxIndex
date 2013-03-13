package com.sphinxsearch.indexer;

public class DocumentProperty {
    private String name;
    private String value;

    public DocumentProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getXmlpipe2Tag() {
        String value = this.value;
        value = value.replaceAll("&", "&amp;");
        value = value.replaceAll("<", "&lt;");
        value = value.replaceAll(">", "&gt;");
        return "<" + name + ">" + value + "</" + name + ">";
    }
}
