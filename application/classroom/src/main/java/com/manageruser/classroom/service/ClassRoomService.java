package com.manageruser.classroom.service;

import com.manageruser.classroom.dto.payload.ClassRoomDTO;
import com.manageruser.classroom.dto.response.AddToClassRoomResponseDTO;
import com.manageruser.classroom.dto.response.CreateClassRoomResponseDTO;
import com.manageruser.classroom.exception.BusinessLogicException;

public interface ClassRoomService {
    ClassRoomDTO createClassRoom(CreateClassRoomResponseDTO response);
    ClassRoomDTO addToClassRoom(AddToClassRoomResponseDTO response) throws BusinessLogicException;
    void deleteStudentToClassRoom(String classRoomId, String studentId) throws BusinessLogicException;
    void deleteTeacherToClassRoom(String id) throws BusinessLogicException;
}
