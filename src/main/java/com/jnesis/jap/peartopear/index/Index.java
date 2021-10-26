package com.jnesis.jap.peartopear.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Index {
    private Map<File, IndexEntry> index;
    private IndexEntry indexEntry;
    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);

    public static class IndexEntry {
        private String pathName;
        private String nameOfSharedFile;
        private Long sizeOfSharedFile;

        private IndexEntry(File f) {
            try {
                this.nameOfSharedFile = f.getName();
                this.pathName = f.getCanonicalPath();
                this.sizeOfSharedFile = f.getTotalSpace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static IndexEntry createIndexEntry(File f) {
            return new IndexEntry(f);
        }

        public String toString() {
            return super.toString();
        }
    }

    public Map<File, IndexEntry> getIndex() {
        return index;
    }

    public Index() {
        index = new HashMap();
        LOGGER.info("A new index has been created !");
    }

    public void addToIndex(File file) {
        if (file.exists()) {
            indexEntry = IndexEntry.createIndexEntry(file);
            index.put(file, indexEntry);
            LOGGER.debug("File : {} exist. IndexEntry has correctly been created.", file.getAbsolutePath());
        } else {
            LOGGER.error("The file provided does not exist !");
            System.exit(-1);
        }
    }

    public int size() {
        return index.size();
    }

    /**
     * @param c a search criteria
     * @return the index entries that match the given criteria
     */
    public Collection<IndexEntry> find(Criteria c) {
        List<IndexEntry> goodCriteriasIndexEntryList = new ArrayList<>();

        for(Map.Entry<File, IndexEntry> entry : index.entrySet()) {
            if (c.matches(entry.getKey().getName())) {
                goodCriteriasIndexEntryList.add(entry.getValue());
            }
        }
        return  goodCriteriasIndexEntryList;
    }
}