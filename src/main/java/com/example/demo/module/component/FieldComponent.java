package com.example.demo.module.component;

public class FieldComponent extends Component {

    public FieldComponent(String name, String returns) {
        componentName = name;
        componentReturnType = returns;
        componentType = ComponentType.FIELD;
        componentModifier = ComponentModifier.PRIVATE;
    }

    public FieldComponent(String name, String returns, ComponentModifier modifier) {
        componentType = ComponentType.FIELD;
        componentName = name;
        componentReturnType = returns;
        componentModifier = modifier;
    }

    public FieldComponent() {
        componentType = ComponentType.FIELD;
        componentModifier = ComponentModifier.PRIVATE;
    }

}
