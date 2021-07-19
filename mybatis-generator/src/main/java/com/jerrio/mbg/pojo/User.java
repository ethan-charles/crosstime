package com.jerrio.mbg.pojo;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_encryptedData")
    private String userEncrypteddata;

    private Byte gender;

    @Column(name = "IV")
    private String iv;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_encryptedData
     */
    public String getUserEncrypteddata() {
        return userEncrypteddata;
    }

    /**
     * @param userEncrypteddata
     */
    public void setUserEncrypteddata(String userEncrypteddata) {
        this.userEncrypteddata = userEncrypteddata;
    }

    /**
     * @return gender
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * @return IV
     */
    public String getIv() {
        return iv;
    }

    /**
     * @param iv
     */
    public void setIv(String iv) {
        this.iv = iv;
    }
}