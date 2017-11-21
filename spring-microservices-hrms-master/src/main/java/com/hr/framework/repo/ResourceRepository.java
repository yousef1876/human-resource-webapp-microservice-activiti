package com.hr.framework.repo;

import com.hr.framework.enums.ValidFlag;
import com.hr.framework.po.Resource;

import java.util.Optional;


public interface ResourceRepository extends CustomRepository<Resource, Long> {

  Optional<Resource> findByNameAndValidFlag(String name, ValidFlag validFlag);

}
