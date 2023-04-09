package com.glodyfigueiredo.MyCMS.Controller.Auth;

import com.glodyfigueiredo.MyCMS.Model.Auth.AuthenticationRequest;
import com.glodyfigueiredo.MyCMS.Model.Auth.RegisterRequest;
import com.glodyfigueiredo.MyCMS.Model.Auth.AuthenticationResponse;
import com.glodyfigueiredo.MyCMS.Model.Response;
import com.glodyfigueiredo.MyCMS.Service.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private Response response;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        ResponseEntity<AuthenticationResponse> result;
        if (service.CheckUser(request.getEmail())) {
            result = ResponseEntity.ok(service.register(request));

        } else {
            result = ResponseEntity.status(HttpStatusCode.valueOf(409)).body(AuthenticationResponse.builder().token("User já  existe").build());
        }

        return result;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}