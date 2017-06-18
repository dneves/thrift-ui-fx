package com.neon.rpc.gen.grpc.model;

import java.util.LinkedList;
import java.util.List;

public class Message {

    private String name;

    private List< Field > fields;

    public Message() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField( Field field ) {
        if ( fields == null ) {
            fields = new LinkedList<>();
        }
        fields.add( field );
    }

}
