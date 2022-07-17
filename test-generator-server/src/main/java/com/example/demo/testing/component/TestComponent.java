package com.example.demo.testing.component;

public class TestComponent {

    public String name;
    private String nick;

    @Override
    public String toString() {
        return "TestComponent{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
