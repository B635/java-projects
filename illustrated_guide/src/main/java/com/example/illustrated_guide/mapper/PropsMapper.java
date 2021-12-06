package com.example.illustrated_guide.mapper;

import com.example.illustrated_guide.bean.Props;
import com.example.illustrated_guide.bean.propList;

import java.util.List;


public interface PropsMapper {
    Props searchProp(int id);

    List<propList> showAllProp();

    void addProp(Props props);

    void deleteProp(int id);

    void changeProp(Props props);
}
