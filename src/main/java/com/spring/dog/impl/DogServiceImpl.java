package com.spring.dog.impl;

import com.spring.dog.service.DogDo;
import com.spring.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dogService")
public class DogServiceImpl implements DogService {
    @Autowired
    private DogInfoDao ddao;

    @Override
    public void insertDogInfo(DogDo ddo) {
        ddao.insertDogInfo(ddo);
    }

    @Override
    public void getAllDogInfo() {
        ddao.getAllDogInfo();
    }
}
