package com.sphinxsearch.indexer.test;

import com.sphinxsearch.indexer.Index;
import com.sphinxsearch.indexer.IndexDescription;
import com.sphinxsearch.indexer.Document;

public class TestCreateIndex {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String QUANTITY = "quantity";
    private static final String CATEGORY = "category";
    private static final String BRAND = "brand";
    private static final String START = "start";
    private static final String IS_NEW = "is_new";
    private static final String PRICE = "price";

    public static void main(String[] args) {
        IndexDescription desc = IndexDescription.createIndexDescription(TITLE, DESCRIPTION);
        desc.addBooleanAttribute(IS_NEW)
                .addFloatAttribute(PRICE)
                .addIntegerAttribute(QUANTITY)
                .addMultiValueAttribute(CATEGORY)
                .addStr2OrdinalAttribute(BRAND)
                .addTimestampAttribute(START);
        Index index = Index.createIndex(desc);
        Document doc = new Document(239);
        doc.addProperty(TITLE, "Black Diamond Sphynx 32")
                .addProperty(DESCRIPTION, "Black Diamond Mustard Low volume ice and alpine climbing pack.Material: 420D Nylon Backpacking Packs,Backpacks for Multiple Day Trips,Black Diamond,Hiking")
                .addProperty(PRICE, 135.36)
                .addProperty(QUANTITY, 1)
                .setMVA(CATEGORY, 3, 7)
                .addProperty(BRAND, "Black Diamond")
                .addProperty(START, (System.currentTimeMillis() / 1000) - 10000);
        index.addDocuments(doc);
        doc = new Document(566);
        doc.addProperty(TITLE, "Cat-opoly")
                .addProperty(DESCRIPTION, "Cat-Opoly Kitty Cat Breed Monopoly Board Game Educational Toy Featuring: Egyptian Mau, Somali, Chartreux, Tonkinese, Ocicat, Persian, Main Coon, Siamese, Abyssinian, Birman, Scottish Fold, American Shorthair, Norwegian Forest Cat, Burmese, Sphynx, Ragdoll, Russian Blue, British Shorthair, Manx, Himalayan, Turkish Van")
                .addProperty(PRICE, 21.95)
                .setFlag(IS_NEW)
                .addProperty(QUANTITY, 5)
                .setMVA(CATEGORY, 17)
                .addProperty(BRAND, "Late for the Sky")
                .addProperty(START, (System.currentTimeMillis() / 1000));
        index.addDocuments(doc);
        index.close();
    }
}
