${filePackage};

@Entity
@Table(name = "${fileName}")
public class ${fileName} {

<#list databaseFields as field>
    ${field.componentModifier} ${field.componentReturnType} ${field.componentName};
</#list>

<#list databaseMethods as method>
    ${method.componentModifier} ${method.componentReturnType} ${method.componentName} {
<#--        ${method.content}-->
    }
</#list>

}