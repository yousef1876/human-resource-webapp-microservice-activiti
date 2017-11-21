package com.hr.framework.repo;

import com.hr.framework.po.OauthRefreshToken;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OauthRefreshTokenRepository extends JpaRepository<OauthRefreshToken, String> {

  Optional<OauthRefreshToken> findByTokenId(String tokenId);
}
