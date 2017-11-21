package com.hr.framework.component;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomPasswordEncoder implements PasswordEncoder {


  @Override public String encode(CharSequence rawPassword) {
    String rawPwd = (String) rawPassword;
    return BCrypt.hashpw(rawPwd, BCrypt.gensalt());
  }


  @Override public boolean matches(CharSequence rawPassword, String encodedPassword) {
    String rawPwd = (String) rawPassword;
    return BCrypt.checkpw(rawPwd, encodedPassword);
  }
}
