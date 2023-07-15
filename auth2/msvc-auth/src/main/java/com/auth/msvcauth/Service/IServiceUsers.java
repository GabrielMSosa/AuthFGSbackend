package com.auth.msvcauth.Service;

import com.auth.msvcauth.entity.UserMaster;

import java.util.List;

public interface IServiceUsers {


    public  List<UserMaster> GetAllUser();

    public UserMaster GetUsexId(Long id);

    public  UserMaster EditUserxId(UserMaster data);

    public UserMaster CreateNewUser(UserMaster data);


}
