package com.example.addresslist.base;

import com.example.addresslist.entity.User;
import com.example.addresslist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class StartBean implements ApplicationRunner {

    @Autowired
    private IUserService iUserService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
