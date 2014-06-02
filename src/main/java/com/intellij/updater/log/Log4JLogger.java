package com.intellij.updater.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import static java.util.Objects.requireNonNull;

public class Log4JLogger extends AbstractLogger {
    private final Logger logger;

    public Log4JLogger(Logger logger) {
        this.logger = requireNonNull(logger);
    }

    @Override
    public void info(String message, Object... params) {
        if (!logger.isInfoEnabled()) {
            return;
        }
        logger.info(formatMessage(message, params));
    }

    @Override
    public void error(String message, Object... params) {
        if (!logger.isEnabledFor(Level.ERROR)) {
            return;
        }
        logger.error(formatMessage(message, params));
    }

    @Override
    public void error(String message, Throwable throwable) {
        if (!logger.isEnabledFor(Level.ERROR)) {
            return;
        }
        logger.error(message, throwable);
    }
}
