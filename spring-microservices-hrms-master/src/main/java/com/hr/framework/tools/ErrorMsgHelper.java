package com.hr.framework.tools;

import com.hr.framework.enums.ErrorType;


public class ErrorMsgHelper {

  /**
   * Get return error message.
   *
   * @param msg  error type
   * @param args args
   * @return return error message
   */
  public static String getReturnMsg(ErrorType msg, String... args) {
    final String COLON = ": ";
    final String PREFIX = String.join("", msg.name(), COLON);
    if (args != null) {
      return String.join("", PREFIX, String.format(msg.description(), (Object) args));
    } else {
      return String.join("", PREFIX, msg.description());
    }
  }

}
