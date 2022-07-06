package com.example.demo.module.component;

import com.example.demo.module.rest.components.Field;

public class FieldComponent extends Component {

    public FieldComponent(String name) {
        componentName = name;
        componentType = ComponentType.FIELD;
    }
}
