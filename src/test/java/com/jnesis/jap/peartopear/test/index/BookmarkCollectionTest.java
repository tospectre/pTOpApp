package com.jnesis.jap.peartopear.test.index;

import com.jnesis.jap.peartopear.bookmark.BookmarkCollection;
import com.jnesis.jap.peartopear.bookmark.DatabaseBookmarkCollection;
import com.jnesis.jap.peartopear.bookmark.FileBookmarkCollection;
import org.junit.Test;

public class BookmarkCollectionTest {

    @Test
    public void testBookmark() {
        BookmarkCollection db = new DatabaseBookmarkCollection();
        FileBookmarkCollection f = new FileBookmarkCollection();
        db = f.addAll(db);
    }

}
