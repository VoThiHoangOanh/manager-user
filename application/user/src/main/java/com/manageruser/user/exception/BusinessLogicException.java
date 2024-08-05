package com.manageruser.user.exception;

import com.manageruser.sharedmodel.enums.ErrorMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BusinessLogicException extends Exception {

    private ErrorMessage errorMessage;

    private List<String> params;

}
