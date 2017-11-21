package com.hr.framework.repo;

import com.hr.framework.po.OauthAccessToken;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OauthAccessTokenRepository extends JpaRepository<OauthAccessToken, String> {

  Optional<OauthAccessToken> findByUserName(String userName);
}
