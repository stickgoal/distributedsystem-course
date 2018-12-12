package me.maiz.ds.multimodule.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import me.maiz.ds.multimodule.UserService;
import me.maiz.ds.multimodule.common.Result;
import me.maiz.ds.multimodule.dal.UserRepo;
import me.maiz.ds.multimodule.domain.User;
import me.maiz.ds.multimodule.dto.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Result<UserInfo> login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Example<User> userExample = Example.of(user);
        Optional<User> userOptional = userRepo.findOne(userExample);
        if(userOptional.isPresent()){
            User u = userOptional.get();
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(u,userInfo);
            return Result.success(userInfo);
        }else{
            return Result.fail("10001","您的用户名或密码不匹配");
        }
    }


}
