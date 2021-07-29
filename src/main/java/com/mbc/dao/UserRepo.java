package com.mbc.dao;

import com.mvc.entity.UserEntity;

public interface UserRepo {

	UserEntity findUserByUserName(String username);
}
