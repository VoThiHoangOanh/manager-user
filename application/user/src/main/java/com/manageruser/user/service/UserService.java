package com.manageruser.user.service;

import com.manageruser.sharedmodel.dto.UserDTO;
import com.manageruser.user.dto.response.UserPayloadDTO;
import com.manageruser.user.exception.BusinessLogicException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createOrUpdateUser(UserPayloadDTO payloadDTO) throws BusinessLogicException;

    List<UserDTO> getAllUser();

    Page<UserDTO> getPaged(String search, Pageable pageable) throws BusinessLogicException;

    UserDTO byId(String id) throws BusinessLogicException;

    Optional<UserDTO> byUserId(String id);

    void deleteById(String id) throws BusinessLogicException;

    void init();
}