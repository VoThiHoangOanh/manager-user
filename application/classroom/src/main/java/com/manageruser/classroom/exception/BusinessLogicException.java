package com.manageruser.classroom.exception;

import com.manageruser.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Builder
public class BusinessLogicException extends Exception{
    private ErrorMessage errorMessage;

    private List<String> params;
}
