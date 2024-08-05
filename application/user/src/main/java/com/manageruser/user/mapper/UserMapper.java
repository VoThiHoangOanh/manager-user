package com.manageruser.user.mapper;

import com.manageruser.sharedmodel.dto.UserDTO;
import com.manageruser.user.document.User;
import com.manageruser.user.dto.response.UserPayloadDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserDTO toDTO(User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(UserPayloadDTO dto, @MappingTarget User entity);

//    @Mapping(target = "userId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updated(UserPayloadDTO dto, @MappingTarget User entity);



    List<UserDTO> toDTOs(List<User> entities);

}
