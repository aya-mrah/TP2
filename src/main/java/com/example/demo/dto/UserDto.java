package com.example.demo.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    /*
    public long getId() {
        return id;
    }
    public void setId(long id) {
       this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username ) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
*/
}