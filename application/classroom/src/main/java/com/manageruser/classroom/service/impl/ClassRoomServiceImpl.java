package com.manageruser.classroom.service.impl;

import com.manageruser.classroom.document.ClassRoom;
import com.manageruser.classroom.dto.payload.ClassRoomDTO;
import com.manageruser.classroom.dto.response.AddToClassRoomResponseDTO;
import com.manageruser.classroom.dto.response.CreateClassRoomResponseDTO;
import com.manageruser.classroom.enums.RoleClassRoom;
import com.manageruser.classroom.exception.BusinessLogicException;
import com.manageruser.classroom.mapper.ClassRoomMapper;
import com.manageruser.classroom.repository.ClassRoomRepository;
import com.manageruser.classroom.service.ClassRoomService;
import com.manageruser.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.manageruser.classroom.enums.RoleClassRoom.STUDENT;

@Service
@AllArgsConstructor
@Slf4j
public class ClassRoomServiceImpl implements ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final ClassRoomMapper classRoomMapper;
    private final RoleClassRoom role = STUDENT;

    @Override
    public ClassRoomDTO createClassRoom(CreateClassRoomResponseDTO response) {
        ClassRoom classroom = new ClassRoom();
        this.classRoomMapper.create(response, classroom);
        classroom.replaceName(response.getClassName());
        this.classRoomRepository.save(classroom);

        return this.classRoomMapper.toDTO(classroom);
    }

    @Override
    public ClassRoomDTO addToClassRoom(AddToClassRoomResponseDTO response) throws BusinessLogicException {
        ClassRoom classRoom = this.classRoomRepository.findById(response.getClassId())
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(response.getClassId()))
                        .build());
        if (RoleClassRoom.STUDENT.equals(response.getRole())) {
            if (classRoom.getStudentIds() == null) {
                classRoom.setStudentIds(new HashSet<>());
            }
            classRoom.getStudentIds().add(response.getUserId());
        } else if (RoleClassRoom.TEACHER.equals(response.getRole())) {
            classRoom.setTeacherId(response.getUserId());
        } else {
            throw new BusinessLogicException(ErrorMessage.USER_ALREADY_EXISTS, List.of(response.getUserId()));
        }
        this.classRoomRepository.save(classRoom);

        return this.classRoomMapper.toDTO(classRoom);
    }

    @Override
    public void deleteStudentToClassRoom(String classRoomId, String studentId) throws BusinessLogicException {
        ClassRoom classroom = this.classRoomRepository.findById(classRoomId)
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(classRoomId))
                        .build());
        if (classroom.getStudentIds() == null || !classroom.getStudentIds().contains(studentId)) {
            throw new BusinessLogicException(ErrorMessage.USER_NOT_FOUND, List.of(studentId));
        } else {
            Set<String> studentIds = classroom.getStudentIds();
            studentIds.removeIf(item -> item.equals(studentId));
            this.classRoomRepository.save(classroom);
        }
    }

    @Override
    public void deleteTeacherToClassRoom(String id) throws BusinessLogicException {
        ClassRoom classroom = this.classRoomRepository.findById(id)
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(id))
                        .build());
        if (classroom.getStudentIds().isEmpty() || classroom.getStudentIds().size() < 10) {
            classroom.setTeacherId(null);
            classroom.setStudentIds(null);
            this.classRoomRepository.save(classroom);
        }
    }

}
