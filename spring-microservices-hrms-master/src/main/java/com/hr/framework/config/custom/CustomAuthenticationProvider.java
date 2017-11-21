package com.hr.framework.config.custom;

import com.hr.framework.component.CustomPasswordEncoder;
import com.hr.framework.component.LogHelper;
import com.hr.framework.domain.UserDomain;
import com.hr.framework.enums.ErrorType;
import com.hr.framework.exception.IllegalTokenTypeException;
import com.hr.framework.po.OauthAccessToken;
import com.hr.framework.po.OauthRefreshToken;
import com.hr.framework.po.User;
import com.hr.framework.repo.OauthAccessTokenRepository;
import com.hr.framework.repo.OauthRefreshTokenRepository;
import com.hr.framework.repo.UserRepository;
import com.hr.framework.tools.Assert;
import com.hr.framework.tools.LogUtils;
import com.hr.framework.tools.LoginUtils;
import com.hr.framework.tools.RemoteAddressUtils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Override public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
    String clientId;
    try {
      clientId = LoginUtils.getClientId(request);
    } catch (IllegalTokenTypeException e) {
      throw new BadCredentialsException(ErrorType.LOG0007.name());
    }
    // Find user.
    String username = token.getName();
    User user = userDomain.findByAccount(username);
    if (user == null) {
      throw new BadCredentialsException(ErrorType.LOG0001.name());
    }
    // Get token object
    OauthAccessToken oauthAccessToken = accessTokenRepository.findByUserName(username).orElse(null);
    // Compare password and credentials of authentication.
    if (!customPasswordEncoder.matches(token.getCredentials().toString(), user.getPwd())) {
      throw new BadCredentialsException(ErrorType.LOG0002.name());
    }
    // Valid account.
    if (!user.isEnabled()) {
      throw new BadCredentialsException(ErrorType.LOG0003.name());
    } else if (!user.isAccountNonExpired()) {
      throw new BadCredentialsException(ErrorType.LOG0004.name());
    } else if (!user.isAccountNonLocked()) {
      throw new BadCredentialsException(ErrorType.LOG0005.name());
    } else if (!user.isCredentialsNonExpired()) {
      throw new BadCredentialsException(ErrorType.LOG0006.name());
    }
    // Get client ip address.
    String ip = RemoteAddressUtils.getRealIp(request);
    // Delete token if repeat login.
    if (user.getIp() != null) {
      if (!user.getIp().equals(ip) && oauthAccessToken != null) {
        accessTokenRepository.delete(oauthAccessToken);
        OauthRefreshToken refreshToken = refreshTokenRepository
            .findByTokenId(oauthAccessToken.getTokenId()).orElse(null);
        if (refreshToken != null) {
          refreshTokenRepository.delete(refreshToken);
        }
      }
    }
    // Save user login info.
    user.setIp(ip);
    user.setLastLoginAt(System.currentTimeMillis());
    userRepository.save(user);
    // Save to log.
    try {
      final String LOGIN = "login";
      logHelper.log(HttpMethod.POST, username, ip, clientId, LOGIN);
    } catch (Exception e) {
      final String errMsg = "Log user login failed.";
      LogUtils.traceError(logger, e, errMsg);
    }
    //Authorize.
    return new UsernamePasswordAuthenticationToken(user, user.getPwd(), user.getAuthorities());
  }

  @Override public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }

  private final UserRepository userRepository;
  private final OauthAccessTokenRepository accessTokenRepository;
  private final OauthRefreshTokenRepository refreshTokenRepository;
  private final HttpServletRequest request;
  private final UserDomain userDomain;
  private final LogHelper logHelper;
  private final CustomPasswordEncoder customPasswordEncoder;
  private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

  @Autowired public CustomAuthenticationProvider(UserRepository userRepository,
      OauthAccessTokenRepository accessTokenRepository,
      OauthRefreshTokenRepository refreshTokenRepository, HttpServletRequest request,
      UserDomain userDomain, LogHelper logHelper, CustomPasswordEncoder customPasswordEncoder) {
    Assert.defaultNotNull(userRepository);
    Assert.defaultNotNull(accessTokenRepository);
    Assert.defaultNotNull(refreshTokenRepository);
    Assert.defaultNotNull(request);
    Assert.defaultNotNull(userDomain);
    Assert.defaultNotNull(logHelper);
    Assert.defaultNotNull(customPasswordEncoder);
    this.userRepository = userRepository;
    this.accessTokenRepository = accessTokenRepository;
    this.refreshTokenRepository = refreshTokenRepository;
    this.request = request;
    this.userDomain = userDomain;
    this.logHelper = logHelper;
    this.customPasswordEncoder = customPasswordEncoder;
  }
}
