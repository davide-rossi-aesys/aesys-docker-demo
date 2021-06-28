package aesys.docker.demobackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import aesys.docker.demobackend.entity.DemoUser;

@RestController()
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private JpaRepository<DemoUser, Long> userRepository;

    @GetMapping(value = "" )
    public ResponseEntity<List<DemoUser>> getAllUsers(){
        try{
            return new ResponseEntity<>(this.userRepository.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
        }
    }

    @PostMapping(value = "") 
    public ResponseEntity<String> createNewUser(@RequestBody @Valid DemoUser demoUser) {
        try{
            this.userRepository.save(demoUser);
            return new ResponseEntity<>(
                String.format("{ \"message\":\"Il nuovo utente %s è stato creato\"}",demoUser.getUsername()),
                HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
        }

    }


}
