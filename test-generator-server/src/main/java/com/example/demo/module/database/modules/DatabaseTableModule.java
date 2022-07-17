package com.example.demo.module.database.modules;

import com.example.demo.module.Module;
import com.example.demo.module.ModuleData;
import com.example.demo.module.component.FieldComponent;
import com.example.demo.module.component.MethodComponent;

import java.util.List;

public class DatabaseTableModule extends Module {

    public List<FieldComponent> databaseFields;
    public List<MethodComponent> databaseMethods;

    public DatabaseTableModule() {
        setTemplateLocation("database/EntityTemplate.ftlh");
    }

}
