package com.jnesis.jap.peartopear.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class Indexer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Indexer.class);

    public static void Index(String path, Index index) {
        if(path == null || path.length() == 0 || index == null) {
            LOGGER.debug("Skipping path {}", path);
            return;
        }
        File f = new File(path);
        if(f.exists() && f.isDirectory()) {
            LOGGER.debug("Indexing {}", path);
            File[] childs = f.listFiles();
            for(File fl : childs) {
                index.addToIndex(fl);
            }
//            for(int i = 0; i < childs.length; i++) {
//                index.addToIndex(childs[i]);
//            }
        } else {
            LOGGER.error("The path {} doesn't exist. Please provide a good path", path);
        }
    }
}
