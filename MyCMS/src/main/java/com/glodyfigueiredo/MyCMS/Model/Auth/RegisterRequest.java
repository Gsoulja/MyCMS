package com.glodyfigueiredo.MyCMS.Model.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterRequest {
    private String name;
    private  String lastName;
    private String email;
    private  String password;
}
