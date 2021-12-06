package com.example.illustrated_guide.service;

import com.example.illustrated_guide.bean.Users;

public interface UsersService {
    Users loginIn(String account, String passwd);
}
