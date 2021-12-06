package com.example.illustrated_guide.service.impl;

import com.example.illustrated_guide.bean.Props;
import com.example.illustrated_guide.bean.propList;
import com.example.illustrated_guide.mapper.PropsMapper;
import com.example.illustrated_guide.service.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropsServiceImpl implements PropsService {
    @Autowired
    PropsMapper propsMapper;

    @Override
    public List<propList> showAll() {
        return propsMapper.showAllProp();
    }

    @Override
    public Props getProp(int id) {
        return propsMapper.searchProp(id);
    }

    @Override
    public void addProp(Props props) {
        propsMapper.addProp(props);
    }

    @Override
    public void deleteProp(int id) {
        propsMapper.deleteProp(id);
    }

    @Override
    public void changeProp(Props props) {
        propsMapper.changeProp(props);
    }
}
