package me.maiz.ds.multimodule.emallassemble.web;

import com.alibaba.dubbo.config.annotation.Reference;
import me.maiz.ds.multimodule.UserService;
import me.maiz.ds.multimodule.common.Result;
import me.maiz.ds.multimodule.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Reference
    private UserService userService;

    @PostMapping("login")
    public String login(String username, String password, HttpSession session){
        Result<UserInfo> loginResult = userService.login(username, password);
        if(loginResult.isSuccess()){
            return "redirect:home.html";
        }else{
            return "redirect:error.html";
        }
    }
}
