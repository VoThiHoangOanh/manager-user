package com.manageruser.user.controller.external;

import com.manageruser.sharedmodel.dto.UserDTO;
import com.manageruser.user.consts.ProjectConst;
import com.manageruser.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(ProjectConst.BASE_EXTERNAL_URL)
@AllArgsConstructor
public class ExternalUserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable String id) {
        return userService.byUserId(id);
    }
}
