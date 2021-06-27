package aesys.docker.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import aesys.entity.DemoUser;

@RestController("/user")
public class UserController {

    private JpaRepository<DemoUser, Long> userRepository;
    
    public UserController(JpaRepository<DemoUser, Long> userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<DemoUser> getAllUsers(){
        try{
            return this.userRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
        }
    }

    @PostMapping() 
    public String createNewUser(@RequestBody DemoUser demoUser) {
        try{
            this.userRepository.save(demoUser);
            return String.format(
                "Il nuovo utente %s è stato creato", 
                demoUser.getUsername());
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
        }

    }


}
