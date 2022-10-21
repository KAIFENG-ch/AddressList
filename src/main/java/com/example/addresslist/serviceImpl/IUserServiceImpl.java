package com.example.addresslist.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.addresslist.dao.mapper.UserMapper;
import com.example.addresslist.entity.User;
import com.example.addresslist.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
