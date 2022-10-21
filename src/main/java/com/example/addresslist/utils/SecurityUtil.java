package com.example.addresslist.utils;

import com.example.addresslist.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    @ApiOperation(value = "查询当前Token的用户对象")
    public User getCurrUser() {
        // todo
        return null;
    }
}
