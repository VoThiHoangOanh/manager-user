package com.manageruser.sharedmodel.exception.bad_request;

import com.manageruser.sharedmodel.exception.GeneralException;

public class BadRequestException extends GeneralException {

  public BadRequestException(String errorCode) {
    super(errorCode);
    this.setHttpStatus(400);
  }
}
