package me.maiz.ds.multimodule.emallassemble.web.thymeleaf;

import me.maiz.ds.multimodule.emallassemble.web.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @RequestMapping("home")
    public String toHome(ModelMap mm){
        mm.put("user",new User("Lucas","http://maiz.me"));
        List<User> users = new ArrayList<>();
        users.add(new User("A","http://a.b.com"));
        users.add(new User("B","http://cc.com"));
        users.add(new User("C","http://aa.com"));
        users.add(new User("D","http://aa.ff.com"));
        mm.put("list",users);

        return "home";
    }

}
