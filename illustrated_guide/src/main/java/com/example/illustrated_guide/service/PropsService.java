package com.example.illustrated_guide.service;

import com.example.illustrated_guide.bean.Props;

import java.util.List;

public interface PropsService {
    List<Props> showAll();

    Props getProp(int id);

    void addProp(Props props);

    void deleteProp(int id);

    void changeProp(Props props);
}
