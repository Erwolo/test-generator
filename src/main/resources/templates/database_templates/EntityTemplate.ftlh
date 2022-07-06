@Entity
@Table(name = "${tableName}")
public class ${tableName} {

<#list entityFields as field>
    ${field.modifier} ${field.returnType} ${field.name};
</#list>

<#list entityMethods as method>
    ${method.modifier} ${method.returnType} ${field} {
        ${method.content}
    }
</#list>

}