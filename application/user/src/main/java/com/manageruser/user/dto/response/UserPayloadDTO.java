package com.manageruser.user.dto.response;

import com.manageruser.sharedmodel.dto.UserDTO;
import com.manageruser.user.dto.IRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserPayloadDTO extends UserDTO implements IRequest {
}
