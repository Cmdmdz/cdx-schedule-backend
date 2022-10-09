package com.cdx.schedulebackend.repository;


import com.cdx.schedulebackend.repository.dao.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CommonRepository<Account,Long>{

    Boolean existsByUsernameAndPassword(String username,String password);
    Boolean existsByUsername(String username);
}
