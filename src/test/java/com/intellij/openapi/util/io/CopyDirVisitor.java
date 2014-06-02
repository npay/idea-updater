package com.intellij.openapi.util.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// https://github.com/bbejeck/Java-7/blob/master/src/main/java/bbejeck/nio/files/visitor/CopyDirVisitor.java
public class CopyDirVisitor extends SimpleFileVisitor<Path> {
    private final Path source;
    private final Path target;

    public CopyDirVisitor(Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetPath = targetPath(dir);
        if (!Files.exists(targetPath)) {
            Files.createDirectory(targetPath);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, targetPath(file));
        return FileVisitResult.CONTINUE;
    }

    private Path targetPath(Path pathInSource) {
        return target.resolve(source.relativize(pathInSource));
    }
}
