package ${modulePackage};

@Entity
@Table(name = "${moduleName}")
public class ${moduleName} {

<#list databaseFields as field>
    ${field.componentModifier} ${field.componentReturnType} ${field.componentName};
</#list>

<#list databaseMethods as method>
    ${method.componentModifier} ${method.componentReturnType} ${method.componentName} {
<#--        ${method.content}-->
    }
</#list>

}