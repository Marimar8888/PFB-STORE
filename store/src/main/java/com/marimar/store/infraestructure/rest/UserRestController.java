package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.LoginDTO;
import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping(value = "/users", produces = "application/json")
    ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO userDTO){
        boolean UserNameExist = this.userService.UserNameExist(userDTO.getUserName());
        if (UserNameExist) {
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }else{
            userDTO = this.userService.saveUser(userDTO);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/users/login", produces = "application/json", consumes = "application/json")
    ResponseEntity<LoginDTO> logintUser(@RequestBody LoginDTO loginDTO) {

        boolean UserNameExist = this.userService.UserNameExist(loginDTO.getUserName());

        if (UserNameExist) {
            UserDTO loginExist = this.userService.loginAuthentication(loginDTO);
            if (loginExist == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
