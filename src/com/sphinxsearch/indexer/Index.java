package com.sphinxsearch.indexer;

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class Index {
    private PrintWriter out;

    private Index() {
    }

    public static Index createIndex(final IndexDescription desc) {
        final Index index = new Index();
        try {
            index.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Not possible exception", e);
        }
        index.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        index.out.println("<sphinx:docset>");
        index.out.println(desc.getXmlpipe2Tag());
        return index;
    }

    public void addDocuments(final Document... docs) {
        for (final Document doc : docs) {
            out.println(doc.getXmlpipe2Tag());
        }
    }

    public void close() {
        out.println("</sphinx:docset>");
        out.flush();
        out.close();
    }
}
