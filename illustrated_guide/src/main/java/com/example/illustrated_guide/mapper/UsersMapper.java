package com.example.illustrated_guide.mapper;

import com.example.illustrated_guide.bean.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    Users searchUser(String account, String passwd);

    void addUser(@Param("users") Users users);

    Users searchUserByAccount(String account);
}
