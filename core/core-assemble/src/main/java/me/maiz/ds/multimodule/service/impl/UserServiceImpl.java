package me.maiz.ds.multimodule.service.impl;

import me.maiz.ds.multimodule.UserService;
import me.maiz.ds.multimodule.dto.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean isUserExist(String username) {
        return false;
    }

    @Override
    public List<UserInfo> find(int ageMax, int ageMin) {
        return new ArrayList<>();
    }
}
