package me.maiz.ds.multimodule;

import me.maiz.ds.multimodule.dto.UserInfo;

import java.util.List;

public interface UserService {

    boolean isUserExist(String username);

    List<UserInfo> find(int ageMax, int ageMin);


}
