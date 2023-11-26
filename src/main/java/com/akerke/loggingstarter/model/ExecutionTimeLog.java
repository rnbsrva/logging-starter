package com.akerke.loggingstarter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a log entry for method execution time.
 * This class is typically used to capture and log the execution time of methods in the application.
 */
@Getter
@Setter
@Builder
public class ExecutionTimeLog {
    /**
     * The name of the class where the method is defined.
     */
    private String className;
    /**
     * The name of the method for which the execution time is recorded.
     */
    private String method;

    /**
     * The execution time of the method in milliseconds.
     */
    private long execution;

    /**
     * Returns a string representation of the ExecutionTimeLog.
     *
     * @return a string representation of the ExecutionTimeLog.
     */
    @Override
    public String toString() {
        return "class_name='" + className + '\'' +
                ", method='" + method + '\'' +
                ", execution=" + execution + " ms";
    }
}
