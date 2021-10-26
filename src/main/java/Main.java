
import com.jnesis.jap.peartopear.index.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        File f = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest.txt");
        File f2 = new File("C:\\Users\\spectre\\Desktop\\tmps\\fileTest2.txt");

        Index index = new Index();
        index.addToIndex(f);
        index.addToIndex(f2);
        LOGGER.debug("Actual size of index : {}", index.size());
    }
}