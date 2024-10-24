package org.example.Data;

public abstract class Domestic extends Animal {
    private final String type = "Домашние животные";

    public Domestic(String name) {
        super(name);
    }


    public String getType() {
        return type;
    }
}
