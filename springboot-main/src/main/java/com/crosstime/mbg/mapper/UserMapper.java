package com.crosstime.mbg.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select user_id from user where user_name = #{userName}")
    Integer findAllUser(@Param("userName") String userName);

    @Insert("insert into user (user_name, user_encryptedData, user_IV, user_avatar, user_gender) values (#{userName}, #{userencryptedData}, #{userIv}, #{userAvatar}, #{userGender})")
    void saveUser(@Param("userName") String userName,
                  @Param("userencryptedData") String userencryptedData,
                  @Param("userIv") String userIv,
                  @Param("userAvatar") String userAvatar,
                  @Param("userGender") Byte userGender
    );
}
