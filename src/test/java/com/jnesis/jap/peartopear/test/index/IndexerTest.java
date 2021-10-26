package com.jnesis.jap.peartopear.test.index;

import com.jnesis.jap.peartopear.index.Index;
import com.jnesis.jap.peartopear.index.Indexer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IndexerTest {
    Index indexObject;

@Test
    public void testIndexerNonGoodPath() {
        String path = "~\\Tmp\\djskhfi\\";
        String retValue = "The path " + path + " doesn't exist. Please provide a good path";
        indexObject = new Index();
        Indexer.Index(path, indexObject);
        assertEquals("The path " + path + " doesn't exist. Please provide a good path", retValue);
    }

@Test
    public void testIndexerGoodPath() {
        String path = "~\\Tmp\\";
        String retValue = "Indexing " + path;
        indexObject = new Index();
        Indexer.Index(path, indexObject);
        assertEquals("Indexing " + path, retValue);
    }
}
