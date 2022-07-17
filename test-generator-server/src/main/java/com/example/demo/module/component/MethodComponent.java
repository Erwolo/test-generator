package com.example.demo.module.component;

public class MethodComponent extends Component {

    public MethodComponent(String name, String returns) {
        componentName = name;
        componentReturnType = returns;
        componentType = ComponentType.FIELD;
        componentModifier = ComponentModifier.PUBLIC;
    }

    public MethodComponent(String name, String returns, ComponentModifier modifier) {
        componentType = ComponentType.FIELD;
        componentName = name;
        componentReturnType = returns;
        componentModifier = modifier;
    }

    public MethodComponent() {
        componentType = ComponentType.FIELD;
        componentModifier = ComponentModifier.PUBLIC;
    }

}
