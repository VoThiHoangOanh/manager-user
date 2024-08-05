package com.manageruser.common.response.builder;

import com.manageruser.common.response.BaseResponseEntity;
import com.manageruser.common.response.BaseResponseError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
public class BaseResponseBuilder {

    private int status;


    public static com.manageruser.common.response.builder.BaseResponseBuilder ok() {
        return status(HttpStatus.OK);
    }


    public static com.manageruser.common.response.builder.BaseResponseBuilder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }


    public <T> BaseResponseEntity<T> body(T response) {
        return this.buildEntityResponse(response);
    }


    public <T extends BaseResponseError.Error> BaseResponseError body(BaseResponseError.Error error) {
        return this.okWithError(error);
    }

    private static com.manageruser.common.response.builder.BaseResponseBuilder status(HttpStatus status) {
        return new com.manageruser.common.response.builder.BaseResponseBuilder(status.value());
    }

    private <T> BaseResponseEntity<T> buildEntityResponse(T response) {
        return BaseResponseEntity
                .<T>builder()
                .status(this.status)
                .data(response)
                .build();
    }

    private BaseResponseError okWithError(BaseResponseError.Error error) {
        return BaseResponseError
                .builder()
                .status(this.status)
                .data(error)
                .build();
    }
}

