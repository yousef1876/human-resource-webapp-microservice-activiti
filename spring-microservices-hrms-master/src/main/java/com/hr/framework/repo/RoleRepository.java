package com.hr.framework.repo;

import com.hr.framework.enums.ValidFlag;
import com.hr.framework.po.Role;

import java.util.Optional;


public interface RoleRepository extends CustomRepository<Role, Long> {

  Optional<Role> findByNameAndValidFlag(String name, ValidFlag validFlag);

}
