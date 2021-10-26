package com.jnesis.jap.peartopear.test.index;

import com.jnesis.jap.peartopear.utils.PathUtils;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PathUtilsTest {

    @Test
    public void combinePathTest() {
        String pth1 = "patate";
        String pth2 = "toto";
        String pth3 = "titi";
        String result = PathUtils.combine(pth1, pth2, pth3);
        String expected = "patate\\toto\\titi\\";

        assertThat(result, is(expected));
    }
}
