package com.example.demo.module.component;

public class Component {

    public ComponentType componentType;
    public ComponentModifier componentModifier;
    public String componentReturnType;
    public String componentName;


    public enum ComponentModifier {
        PUBLIC,
        PROTECTED,
        PRIVATE;

    }

    public enum ComponentType {
        FIELD,
        METHOD;
    }

    public Component() {}

}
