package com.auth.msvcauth.userrepository;

import com.auth.msvcauth.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoUserMaster extends JpaRepository<UserMaster,Long> {

}
