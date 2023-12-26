package ua.com.alevel.service.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoggingLevel {

    INFO("infoLogger"),
    ERROR("errorLogger");

    private final String level;
}
