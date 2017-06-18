package com.neon.rpc.gen.grpc.model;

public class ServiceMethod {

    private String name;

    private Message message;

    private Message result;

    public ServiceMethod() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getResult() {
        return result;
    }

    public void setResult(Message result) {
        this.result = result;
    }
}
