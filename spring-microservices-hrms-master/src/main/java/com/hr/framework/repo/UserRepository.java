package com.hr.framework.repo;

import com.hr.framework.enums.ValidFlag;
import com.hr.framework.po.User;

import java.util.Optional;



public interface UserRepository extends CustomRepository<User, Long> {

  Optional<User> findByIdAndValidFlag(Long id, ValidFlag validFlag);

  Optional<User> findByUsrAndValidFlag(String usr, ValidFlag validFlag);


    User findOneByUsername(String username);

}
