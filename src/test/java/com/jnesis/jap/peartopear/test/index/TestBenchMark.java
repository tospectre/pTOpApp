package com.jnesis.jap.peartopear.test.index;

import com.jnesis.jap.peartopear.utils.Benchmark;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestBenchMark {

    @Test
    public void testBench() throws InterruptedException {
        Benchmark benchmark = new Benchmark();

        benchmark.start();
        Thread.sleep(100);
        benchmark.start();
        Thread.sleep(100);
        benchmark.bookmark("test1");
        assertThat(benchmark.toString(), is("test1"));
    }
}
