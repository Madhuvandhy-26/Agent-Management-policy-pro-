package com.agentmanagement.exception;

public class AgentException extends RuntimeException{
    private String errorMessage;

    public AgentException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {

        return this.errorMessage;
    }
}
