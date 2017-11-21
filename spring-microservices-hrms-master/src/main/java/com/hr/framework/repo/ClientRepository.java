package com.hr.framework.repo;

import com.hr.framework.po.Client;

import java.util.Optional;


public interface ClientRepository extends CustomRepository<Client, Long> {

  Optional<Client> findByClientIdAlias(String clientIdAlias);
}
