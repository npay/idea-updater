package com.intellij.updater.ui;

import com.intellij.updater.patch.OperationCancelledException;
import com.intellij.updater.patch.ValidationResult;

import java.util.List;
import java.util.Map;

public interface UpdaterUI {
    void startProcess(String title);

    void setProgress(int percentage);

    void setProgressIndeterminate();

    void setStatus(String status);

    void showError(Throwable e);

    void checkCancelled() throws OperationCancelledException;

    Map<String, ValidationResult.Option> askUser(List<ValidationResult> validationResults) throws OperationCancelledException;
}
