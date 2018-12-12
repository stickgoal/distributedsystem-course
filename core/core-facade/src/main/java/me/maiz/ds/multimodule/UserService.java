package me.maiz.ds.multimodule;

import me.maiz.ds.multimodule.common.Result;
import me.maiz.ds.multimodule.dto.UserInfo;

public interface UserService {

    Result<UserInfo> login(String username,String password);

}
