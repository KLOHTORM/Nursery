package org.example.Data;

public abstract class Pack extends Animal {
    private String type = "Вьючные животные";

    public Pack(String name) {
        super(name);
    }

    public String getType() {
        return type;
    }
}
