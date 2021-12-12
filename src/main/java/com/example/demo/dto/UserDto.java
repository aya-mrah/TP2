package com.example.demo.dto;
import javax.validation.constraints.Email;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private long id;
    private String username;
    @Email
    private String email;

}