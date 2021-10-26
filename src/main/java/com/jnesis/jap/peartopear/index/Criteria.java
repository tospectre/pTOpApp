package com.jnesis.jap.peartopear.index;

/**
 * Interface defining a simple way to filter an Index
 */
public interface Criteria {
    /**
     * @param filename a file name
     * @return <code>true</code> if filename matches the required criterias
     */
    public boolean matches(String filename);
}
