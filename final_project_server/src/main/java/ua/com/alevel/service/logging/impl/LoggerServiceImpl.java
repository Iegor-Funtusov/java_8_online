package ua.com.alevel.service.logging.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.com.alevel.service.logging.LoggerService;
import ua.com.alevel.service.logging.LoggingLevel;

@Service
public class LoggerServiceImpl implements LoggerService {

    private static final Logger LOGGER_INGO = LoggerFactory.getLogger(LoggingLevel.INFO.getLevel());
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(LoggingLevel.ERROR.getLevel());

    @Override
    public void log(LoggingLevel level, String msg) {
        switch (level) {
            case INFO -> LOGGER_INGO.info(msg);
            case ERROR -> LOGGER_ERROR.error(msg);
        }
    }
}
