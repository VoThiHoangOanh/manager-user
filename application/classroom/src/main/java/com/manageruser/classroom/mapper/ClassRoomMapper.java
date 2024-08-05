package com.manageruser.classroom.mapper;

import com.manageruser.classroom.document.ClassRoom;
import com.manageruser.classroom.dto.payload.ClassRoomDTO;
import com.manageruser.classroom.dto.response.CreateClassRoomResponseDTO;
import org.mapstruct.*;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassRoomMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClassRoomDTO toDTO(ClassRoom entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(CreateClassRoomResponseDTO dto, @MappingTarget ClassRoom entity);
}
