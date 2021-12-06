package com.example.illustrated_guide.mapper;

import com.example.illustrated_guide.bean.Users;

public interface UsersMapper {
    Users searchUser(String account, String passwd);
}
