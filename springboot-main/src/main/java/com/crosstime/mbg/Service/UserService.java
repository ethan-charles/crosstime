package com.crosstime.mbg.Service;

public interface UserService {

    boolean login(String userName, String userencryptedData, String userIv, String userAvatar, Byte userGender);

}
