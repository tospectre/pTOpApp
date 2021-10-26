package com.jnesis.jap.peartopear.bookmark;

/**
 * Interface defining a collection of bookmarks
 */
public interface BookmarkCollection {
    /**
     * Adds a bookmark location to the collection.
     * @param s a bookmark location
     */
    public void addBookmark(String s);

    /**
     * Adds all bookmarks of the given collection to the current one.
     * @param collection a bookmark collection
     * @return the current collection with the bookmarks from <code>collection</code> added
     */
    public BookmarkCollection addAll(BookmarkCollection collection);
}
