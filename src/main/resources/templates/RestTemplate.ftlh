import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/${name}")
public class ${name}RestController {
private List<${name}Dto> list;


    @GetMapping
    public ${name}Dto greeting(@RequestParam Integer id) {
        return list.get(id);
    }



    @PostMapping
    public ${name}Dto greeting(@RequestBody ${name}Dto dto) {
        return list.add(id);
    }
}