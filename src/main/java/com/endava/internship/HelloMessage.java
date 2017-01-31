package com.endava.internship;

public class HelloMessage
{
    private String message;

    public HelloMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Hello " + message + "!";
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
