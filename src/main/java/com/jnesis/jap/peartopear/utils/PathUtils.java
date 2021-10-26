package com.jnesis.jap.peartopear.utils;

import java.io.File;

public class PathUtils {

    public static String combine(String... path) {
        String combinedPath = "";

        for(String p : path) {
            combinedPath = combinedPath.concat(p + File.separator);
        }

        return combinedPath;
    }
}
