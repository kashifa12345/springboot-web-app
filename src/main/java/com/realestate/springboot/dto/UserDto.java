

package com.realestate.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int userId;

    private String firstName;

    private String lastName;

    private String contact;

    private String email;

    private String password;

}
