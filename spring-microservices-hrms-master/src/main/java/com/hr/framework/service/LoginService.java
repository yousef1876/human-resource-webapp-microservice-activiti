package com.hr.framework.service;

import com.hr.framework.param.LoginParam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;


public interface LoginService {

  ResponseEntity login(LoginParam param, HttpServletRequest request) throws Exception;

  ResponseEntity refresh(LoginParam param, HttpServletRequest request) throws Exception;
}
