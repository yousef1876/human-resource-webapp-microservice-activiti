package com.hr.framework.controller.open;

import com.hr.framework.component.ResultHelper;
import com.hr.framework.constant.ResourcePath;
import com.hr.framework.enums.ErrorType;
import com.hr.framework.exception.IllegalTokenTypeException;
import com.hr.framework.param.LoginParam;
import com.hr.framework.service.LoginService;
import com.hr.framework.tools.Assert;
import com.hr.framework.vo.ErrorVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;


@Api("refresh token")
@RestController
@RequestMapping(ResourcePath.API + ResourcePath.V1 + ResourcePath.OPEN + ResourcePath.REFRESH)
public class RefreshController {

  @RequestMapping(method = RequestMethod.PUT)
  @ApiOperation(value = "refresh token", httpMethod = "POST", response = OAuth2AccessToken.class)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", dataType = "string", required = true),
      @ApiImplicitParam(name = "Limit-Key", value = "limit key", paramType = "header", dataType = "string")
  })
  public ResponseEntity refresh(@RequestBody LoginParam param,
      @ApiIgnore HttpServletRequest request) {
    try {
      return loginService.refresh(param, request);
    } catch (IllegalTokenTypeException e) {
      return new ResponseEntity<>(
          new ErrorVO(e.getErrorType().name(), e.getErrorType().description()),
          HttpStatus.UNAUTHORIZED);
    } catch (Exception e) {
      // Return unknown error and log the exception.
      return resultHelper.errorResp(logger, e, ErrorType.UNKNOWN, e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private static final Logger logger = LoggerFactory.getLogger(RefreshController.class);
  private final LoginService loginService;
  private final ResultHelper resultHelper;

  public RefreshController(LoginService loginService, ResultHelper resultHelper) {
    Assert.defaultNotNull(loginService);
    Assert.defaultNotNull(resultHelper);
    this.loginService = loginService;
    this.resultHelper = resultHelper;
  }
}
