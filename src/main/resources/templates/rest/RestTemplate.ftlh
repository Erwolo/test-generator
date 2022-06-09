import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/${endpoint}")
public class ${fileName} {

    private List<${usedClass}> list;

<#if get>
    @GetMapping
    public ${usedClass} get(@RequestParam Integer id) {
        return list.get(id);
    }
</#if>

<#if insert>
    @PostMapping
    public ${usedClass} insert(@RequestBody ${usedClass} dto){
        return list.add(dto);
    }
</#if>

<#if update>
    @PostMapping("update")
    public ${usedClass} update(@RequestBody ${usedClass} dto) {
        return list.set(dto.id, dto);
    }
</#if>

<#if delete>
    @DeleteMapping("delete/{id}")
    public void delete(@RequestParam Integer id) {
        return list.remove(id);
    }
</#if>

}