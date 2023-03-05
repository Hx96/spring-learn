package com.hx.adpter;

import com.hx.dao.TUser;
import com.hx.dao.TUserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author kyle
 * @date 2023/02/18
 */
@RestController
public class UserController {

    @Resource
    TUserMapper tUserMapper;


    @GetMapping("/user")
    public TUser getUser(@RequestParam Long id) {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        return tUser;
    }
}
