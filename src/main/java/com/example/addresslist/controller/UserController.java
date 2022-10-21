package com.example.addresslist.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.addresslist.baseVo.Result;
import com.example.addresslist.entity.User;
import com.example.addresslist.service.IUserService;
import com.example.addresslist.utils.ResultUtil;
import com.example.addresslist.utils.SecurityUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/User")
@CacheConfig(cacheNames = "user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private SecurityUtil securityUtil;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前登录用户")
    public Result<User> getUserInfo() {
        User u = securityUtil.getCurrUser();
        // todo entityManager.clear()
        u.setPassword(null);
        return new ResultUtil<User>().setData(u);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户")
    public Result<Object> register(@Valid User u) {
        QueryWrapper<User> userQw = new QueryWrapper<>();
        userQw.and(wrapper -> wrapper.eq("username", u.getUsername()));
        if(iUserService.count(userQw) > 0L) {
            return ResultUtil.error("登陆账号/手机号重复");
        }
        String encryptPass = new BCryptPasswordEncoder().encode(u.getPassword());
        iUserService.saveOrUpdate(u);
        return ResultUtil.data(u);
    }

    @RequestMapping(value = "/resetPass", method = RequestMethod.POST)
    @ApiOperation(value = "重置密码")
    public Result<Object> resetPass(@RequestParam String[] ids){
        for(String id : ids){
            User userForReset = iUserService.getById(id);
            if(userForReset == null) {
                return ResultUtil.error("不存在");
            }
            userForReset.setPassword(new BCryptPasswordEncoder().encode("123456"));
            iUserService.saveOrUpdate(userForReset);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户资料",notes = "用户名密码不会修改 需要username更新缓存")
    @CacheEvict(key = "#u.username")
    public Result<Object> editOwn(User u){
        User old = securityUtil.getCurrUser();
        u.setUsername(old.getUsername());
        u.setPassword(old.getPassword());
        iUserService.saveOrUpdate(u);
        return ResultUtil.success("修改成功");
    }

    @RequestMapping(value = "/modifyPass", method = RequestMethod.POST)
    @ApiOperation(value = "修改密码")
    public Result<Object> modifyPass(@RequestParam String password,@RequestParam String newPass,@RequestParam String passStrength){
        User user = securityUtil.getCurrUser();
        if(!new BCryptPasswordEncoder().matches(password, user.getPassword())){
            return ResultUtil.error("原密码不正确");
        }
        String newEncryptPass= new BCryptPasswordEncoder().encode(newPass);
        user.setPassword(newEncryptPass);
        iUserService.saveOrUpdate(user);
        return ResultUtil.success();
    }

}
