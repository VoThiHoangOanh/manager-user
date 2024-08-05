package com.manageruser.classroom.dto.response;

import com.manageruser.classroom.dto.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassRoomResponseDTO implements IRequest {
    private String id;
    private String className;
    private int quantityMaxStudent;
}