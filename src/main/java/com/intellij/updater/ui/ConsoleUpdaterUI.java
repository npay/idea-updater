package com.intellij.updater.ui;

import com.intellij.updater.Runner;
import com.intellij.updater.patch.OperationCancelledException;
import com.intellij.updater.patch.ValidationResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"UseOfSystemOutOrSystemErr", "CallToPrintStackTrace"})
public class ConsoleUpdaterUI implements UpdaterUI {
    private String myStatus;

    public void startProcess(String title) {
        System.out.println(title);
        Runner.logger.info("title: {0}", title);
    }

    public void setProgress(int percentage) {
    }

    public void setProgressIndeterminate() {
    }

    public void setStatus(String status) {
        System.out.println(myStatus = status);
        Runner.logger.info("status: {0}", status);
    }

    public void showError(Throwable e) {
        e.printStackTrace();
    }

    public void checkCancelled() throws OperationCancelledException {
    }

    public Map<String, ValidationResult.Option> askUser(List<ValidationResult> validationResults) {
        return Collections.emptyMap();
    }

    @Override
    public String toString() {
        return "Status: '" + myStatus + '\'';
    }
}
