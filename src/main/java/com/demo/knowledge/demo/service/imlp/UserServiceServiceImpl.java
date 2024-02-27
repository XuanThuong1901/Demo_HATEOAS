package com.demo.knowledge.demo.service.imlp;

import com.demo.knowledge.demo.DTO.user.UserRequestDTO;
import com.demo.knowledge.demo.DTO.user.UserResponseDTO;
import com.demo.knowledge.demo.controller.StudentController;
import com.demo.knowledge.demo.controller.UserController;
import com.demo.knowledge.demo.entity.User;
import com.demo.knowledge.demo.repository.UserRepository;
import com.demo.knowledge.demo.service.interf.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
@RequiredArgsConstructor
public class UserServiceServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO getUser(int idUser) {

        User user = userRepository.findById(idUser).orElse(null);
        if(user == null)
            return null;
        Link linkUser = linkTo(StudentController.class).slash(idUser).withRel("detail student");
        user.add(linkUser);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return new UserResponseDTO(userList);
    }

    @Override
    public UserResponseDTO getAllUser() {

        List<User> userList = userRepository.findAll();
        for (User user : userList){
//            int idUser = user.getIdUser();
            Link userLink = linkTo(UserController.class).slash(user.getIdUser()).withRel("detail user");
            user.add(userLink);
        }


        return new UserResponseDTO(userList);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        return null;
    }
}
