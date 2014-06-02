package com.intellij.updater.log;

import java.text.MessageFormat;

abstract public class AbstractLogger {
    abstract public void info(String message, Object... params);

    abstract public void error(String message, Object... params);

    abstract public void error(String message, Throwable throwable);

    protected String formatMessage(String message, Object... params) {
        if (0 == params.length) {
            return message;
        }
        return MessageFormat.format(message, params);
    }
}
