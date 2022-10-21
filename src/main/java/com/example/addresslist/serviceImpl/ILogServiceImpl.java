package com.example.addresslist.serviceImpl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.addresslist.dao.mapper.LogMapper;
import com.example.addresslist.service.ILogService;
import org.springframework.stereotype.Service;

@Service
public class ILogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
