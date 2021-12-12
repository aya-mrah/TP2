package com.example.demo.controller;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping(" ")
    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


    @PostMapping(" ")
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        userRepository.save(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);

        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(value = "id") Long Id,@Valid @RequestBody User u) {

      User  user =userRepository.findById(Id).orElseThrow(()->new IllegalStateException("User with id" + Id+"does exist"));


        user.setUsername(u.getUsername());
        user.setEmail(u.getEmail());
        user.setAge(u.getAge());
        user.setPassword(u.getPassword());
        User update =userRepository.save(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDto> getbyid(@PathVariable Long id){
        User user=userRepository.getById(id);

        if(user!=null){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long Id) {
        userRepository.findById(Id);
        boolean exist = userRepository.existsById(Id);
        if (!exist) {


            return "User :"+Id+"does not exist";
        } else {
            userRepository.deleteById(Id);
            return "User deleted";
        }
    }

}





























