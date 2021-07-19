package com.crosstime.mbg.Service;

import com.crosstime.mbg.pojo.User;
import com.crosstime.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String userencryptedData, String userIv, String userAvatar, Byte userGender) {

        User user = new User();
        user.setUserName(userName);
        user.setUserEncrypteddata(userencryptedData);
        user.setUserIv(userIv);
        user.setUserAvatar(userAvatar);
        user.setUserGender(userGender);
        Integer allUsers = this.userMapper.findAllUser(userName);
        if (allUsers == null || allUsers == 0){
            return enroll(userName, userencryptedData, userIv, userAvatar, userGender);
        }else {
            return true;
        }
    }

    public boolean enroll(String userName, String userencryptedData, String userIv, String userAvatar, Byte userGender) {
        User user = new User();
        user.setUserName(userName);
        user.setUserEncrypteddata(userencryptedData);
        user.setUserIv(userIv);
        user.setUserAvatar(userAvatar);
        user.setUserGender(userGender);
        this.userMapper.saveUser(userName, userencryptedData, userIv, userAvatar, userGender);
        return true;
    }

}