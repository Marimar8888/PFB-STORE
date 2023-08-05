package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.ClientDTO;
import com.marimar.store.application.dto.LoginDTO;
import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.application.service.UserService;
import com.marimar.store.utils.JwtConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class UserRestController {

   private final UserService userService;
   private final JwtConfig jwtConfig;

    public UserRestController(UserService userService, JwtConfig jwtConfig) {
        this.userService = userService;
        this.jwtConfig = jwtConfig;
    }

    @CrossOrigin
    @GetMapping(value="/users/{userName}/favorites")
    public ResponseEntity<List<Long>> getFavoritesByUserName(@PathVariable String userName){
        List<Long> favoritesList = this.userService.getFavoritesByUserName(userName);
        return new ResponseEntity<>(favoritesList, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsers(HttpServletRequest request) {

        String username = (String) request.getAttribute("username");

        if (username == null) {
            // El token no es válido o ha expirado, deniega el acceso
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
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
    ResponseEntity<ClientDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        boolean userNameExists = this.userService.UserNameExist(loginDTO.getUserName());
        if (!userNameExists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LoginDTO loginExist = this.userService.loginAuthentication(loginDTO);
        if (loginExist == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        UserDTO user = this.userService.getUserByUserName(loginDTO.getUserName());
        // Autenticación exitosa, genera el token JWT y devuélvelo en la respuesta
        String token = jwtConfig.generateToken(loginDTO.getUserName());
        ClientDTO clientDTO = new ClientDTO(user.getId(), user.getUserName(), token);
        return ResponseEntity.ok(clientDTO);
    }

    @CrossOrigin
    @PutMapping(value= "/users/{userName}/favorites/{itemId}")
    public ResponseEntity<List<Long>> insertItemsInUsers(@PathVariable Long itemId, @PathVariable String userName){

       boolean insertOk = userService.insertFavoriteByUserIdAndByItemid(userName, itemId);

       if(insertOk){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
    @CrossOrigin
    @DeleteMapping(value="/users/{userName}/favorites/remove/{itemId}")
    public ResponseEntity<Void> deleteFavoriteByUserNameAndByItemId(@PathVariable String userName, @PathVariable Long itemId){

        boolean deleteOk = userService.deleteFavoriteByItemId(userName, itemId);
        if(deleteOk){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
