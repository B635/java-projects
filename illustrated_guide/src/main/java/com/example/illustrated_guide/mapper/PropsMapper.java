package com.example.illustrated_guide.mapper;

import com.example.illustrated_guide.bean.Props;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PropsMapper {
    Props searchProp(int id);

    List<Props> showAllProp();

    void addProp(@Param("props") Props props);

    void deleteProp(int id);

    void changeProp(@Param("props") Props props);
}
