package com.demo.knowledge.demo.service.interf;

import com.demo.knowledge.demo.DTO.user.UserRequestDTO;
import com.demo.knowledge.demo.DTO.user.UserResponseDTO;

import java.util.List;

public interface IUserService {

    UserResponseDTO getUser(int idUser);
    UserResponseDTO getAllUser();
    UserResponseDTO createUser(UserRequestDTO requestDTO);

}
