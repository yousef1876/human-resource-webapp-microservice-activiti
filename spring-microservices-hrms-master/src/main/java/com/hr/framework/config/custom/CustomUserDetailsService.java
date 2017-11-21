package com.hr.framework.config.custom;

import com.hr.framework.enums.ValidFlag;
import com.hr.framework.po.User;
import com.hr.framework.repo.UserRepository;
import com.hr.framework.tools.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Override public UserDetails loadUserByUsername(String usr) throws UsernameNotFoundException {
    return userRepository.findByUsrAndValidFlag(usr, ValidFlag.VALID).orElseThrow(
        // Throw cannot find any user by this usr param.
        () -> new UsernameNotFoundException(String.format("User %s does not exist!", usr)));
  }

  private final UserRepository userRepository;

  @Autowired public CustomUserDetailsService(UserRepository userRepository) {
    Assert.defaultNotNull(userRepository);
    this.userRepository = userRepository;
  }
}
