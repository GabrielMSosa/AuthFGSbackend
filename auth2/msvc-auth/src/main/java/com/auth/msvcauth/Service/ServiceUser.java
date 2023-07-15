package com.auth.msvcauth.Service;

import com.auth.msvcauth.entity.UserMaster;
import com.auth.msvcauth.userrepository.IRepoUserMaster;
import com.auth.msvcauth.userrepository.IRepoUserSun;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceUser implements IServiceUsers{

    @Autowired
    private IRepoUserMaster repoUserMaster;

    @Autowired
    private IRepoUserSun repoUserSun;

    @Override
    public List<UserMaster> GetAllUser() {
        return repoUserMaster.findAll();
    }

    @Override
    public UserMaster GetUsexId(Long id) {
        return null;
    }

    @Override
    public UserMaster EditUserxId(UserMaster data) {
        return null;
    }

    @Override
    public UserMaster CreateNewUser(UserMaster data) {
        return null;
    }
}
