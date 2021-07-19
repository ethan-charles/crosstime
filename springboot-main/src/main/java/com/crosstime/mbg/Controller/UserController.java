package com.crosstime.mbg.Controller;

import com.crosstime.mbg.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Resource
    private UserService userService;

    @PostMapping ("/login")
    @ResponseBody
    public boolean login(@RequestParam(value = "user_name") String user_name,
                         @RequestParam(value = "user_encryptedData") String user_encryptedData,
                         @RequestParam(value = "user_IV") String user_iv,
                         @RequestParam(value = "user_avatar") String user_avatar,
                         @RequestParam(value = "user_gender") Byte user_gender) {
        boolean login = this.userService.login(user_name, user_encryptedData, user_iv, user_avatar, user_gender);
        if (login){
            return true;
        }
        return false;
    }

}
