package com.hr.framework.component;

import com.hr.framework.enums.ErrorType;
import com.hr.framework.tools.LogUtils;
import com.hr.framework.vo.ErrorVO;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResultHelper {


  @SuppressWarnings("unchecked")
  public ResponseEntity successResp(Object object, HttpStatus httpStatus) {
    return new ResponseEntity(object, httpStatus);
  }


  public ResponseEntity infoResp(ErrorType errorType, HttpStatus httpStatus) {
    return infoResp(errorType, errorType.description(), httpStatus);
  }



  public ResponseEntity infoResp(ErrorType errorType, String msg, HttpStatus httpStatus) {
    return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
  }


  public ResponseEntity infoResp(Logger logger, ErrorType errorType, String msg,
      HttpStatus httpStatus) {
    LogUtils.trackInfo(logger, msg);
    return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
  }


  public ResponseEntity errorResp(Logger logger, Throwable e, ErrorType errorType,
      HttpStatus httpStatus) {
    return errorResp(logger, e, errorType, errorType.description(), httpStatus);
  }


  public ResponseEntity errorResp(Logger logger, Throwable e, ErrorType errorType, String msg,
      HttpStatus httpStatus) {
    LogUtils.traceError(logger, e, errorType.description());
    return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
  }
}
