package com.intellij.updater;

import com.intellij.updater.patch.Patch;
import com.intellij.updater.patch.action.PatchAction;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Sandbox for researching structure of patch file.
 */
public class PatchSandbox {
    public static void main(String[] args) throws IOException {
        try (FileInputStream patchFileStream = new FileInputStream("C:/Tmp/.patch-info")) {
            Patch patch = new Patch(patchFileStream);
            dumpPatch(patch);
        }
    }

    private static void dumpPatch(Patch patch) {
        for (PatchAction patchAction : patch.getActions()) {
            System.out.println(patchAction);
        }
    }
}
