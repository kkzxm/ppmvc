package com.learn.treeEn.util;

import java.util.Objects;

public class Path {
    public static String getFilePath(Class cl, String fileName) {
        return Objects.requireNonNull(cl.getResource("")).getPath() + fileName;
    }
}
