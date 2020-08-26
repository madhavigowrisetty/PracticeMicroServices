package com.udemy.rest.webservices.udemywebservices.HelloWorld;

public class HelloWorldObj {

    private String message;

    public HelloWorldObj(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldObj{" +
                "message='" + message + '\'' +
                '}';
    }
}
