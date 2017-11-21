package com.hr.framework.repo;

import com.hr.framework.po.Account;

import java.util.Optional;


public interface AccountRepository extends CustomRepository<Account, Long> {

  Optional<Account> findByAccount(String account);
}
