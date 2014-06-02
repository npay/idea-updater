package com.intellij.openapi.util.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtil {
    public static void copy(File source, File target) throws IOException {
        Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyDir(File myOlderDir, File myNewerDir) throws IOException {
        // https://github.com/bbejeck/Java-7/blob/master/src/main/java/bbejeck/nio/util/DirUtils.java
        Files.walkFileTree(myOlderDir.toPath(), new CopyDirVisitor(myOlderDir.toPath(), myNewerDir.toPath()));
    }

    public static boolean delete(File file) throws IOException {
        try {
            Files.delete(file.toPath());
            return true;
        } catch (NoSuchFileException|DirectoryNotEmptyException e) {
            return false;
        }
    }

    public static void deleteDir(Path path) throws IOException {
        Files.walkFileTree(path, new DeleteDirVisitor());
    }

    public static void writeToFile(File file, byte[] bytes) throws IOException {
        Files.write(file.toPath(), bytes);
    }

    public static void rename(File source, File target) throws IOException {
        Files.move(source.toPath(), target.toPath());
    }

    public static String loadFile(File newFile) throws IOException {
        return new String(Files.readAllBytes(newFile.toPath()), StandardCharsets.UTF_8);
    }
}
