package com.hr.framework.component;

import com.hr.framework.constant.SignatureConstant;
import com.hr.framework.enums.ErrorType;
import com.hr.framework.exception.CommonsException;
import com.hr.framework.param.BaseParam;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class SignHelper {


  public boolean signCheck(String publicKey, BaseParam params)
      throws UnsupportedEncodingException, CommonsException {
    // Prepare to validateWithOutSignCheck signature.
    if (StringUtils.isEmpty(params.getSign())) {
      throw new CommonsException(ErrorType.SYS0002);
    }
    // Transform encode.
    params.setSign(URLDecoder
        .decode(new String(Base64.decodeBase64(params.getSign())), SignatureConstant.CHARSET_UTF8));
    // Signature
    return params.isSignValid(publicKey);
  }
}
