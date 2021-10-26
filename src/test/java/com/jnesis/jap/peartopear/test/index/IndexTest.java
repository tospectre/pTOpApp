package com.jnesis.jap.peartopear.test.index;

import com.jnesis.jap.peartopear.index.Criteria;
import com.jnesis.jap.peartopear.index.Index;
import static org.junit.Assert.assertEquals;
import com.jnesis.jap.peartopear.index.Indexer;
import com.jnesis.jap.peartopear.utils.PathUtils;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.util.Collection;

public class IndexTest {
    Index indexObject;

    @Test
    public void testIndexNonExistingFile() {
        File f=new File("C:\\Users\\spectre\\Desktop\\tmps\\inexistant_file.txt");

        Index i = new Index();
        i.addToIndex(f);
        assertThat(i.size(), is(0));
    }

    @Test
    public void testIndexValidFile() {
        File f = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest.txt");

        Index index = new Index();
        index.addToIndex(f);
        assertThat(index.size(), is(1));
    }

    @Test
    public void testPathUtils() {
        File f1 = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest.txt");
        File f2 = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest2.txt");
        File f3 = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest3.txt");
        File f4 = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest4.txt");

        PathUtils.combine(f1.getName(), f2.getName(), f3.getName(), f4.getName());
//        assertThat();

    }

    @Test
    public void testFindMatchesCriteriaOnIndexCollection() {
        indexObject = new Index();
        Index indexTemp = new Index();

        Collection<Index.IndexEntry> matchesCriteriaIndexList;
        Collection<Index.IndexEntry> expectedCriteriaIndexList;

        String path = "C:\\Users\\spectre\\Desktop\\tmps\\";
        String path2 = "C:\\Users\\spectre\\Desktop\\tmps2\\";
        String pathExpected = "C:\\Users\\spectre\\Desktop\\expected\\";
        String pathExpected2 = "C:\\Users\\spectre\\Desktop\\expected2\\";

        Indexer.Index(pathExpected, indexTemp);
        Indexer.Index(pathExpected2, indexTemp);

        Indexer.Index(path, indexObject);
        Indexer.Index(path2, indexObject);

        expectedCriteriaIndexList = indexTemp.find(new Criteria() {
            @Override
            public boolean matches(String filename) {
                return false;
            }
        });

        matchesCriteriaIndexList = indexObject.find(new Criteria() {
            @Override
            public boolean matches(String filename) {
                return false;
            }
        });

        assertEquals(expectedCriteriaIndexList, matchesCriteriaIndexList);
    }

}
