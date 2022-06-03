@Entity
@Table(name = "${tableName})
public class ${tableName} {

<#list tableFields as field>
    private String ${field};
</#list>

}