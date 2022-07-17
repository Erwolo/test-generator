public class ${fileName} {

    private Long id;

    public ${fileName}(){
    }

<#list fields as field>
    private ${field.type} ${field.name};
</#list>

<#list fields as field>
    public ${field.type} get${field.name}() {
        return this.${field.name};
    }

</#list>
<#list fields as field>
    public void set${field.name}(${field.type} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}