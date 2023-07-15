package com.auth.msvcauth.userrepository;

import com.auth.msvcauth.entity.Usersun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoUserSun extends JpaRepository<Usersun,Long> {
}
