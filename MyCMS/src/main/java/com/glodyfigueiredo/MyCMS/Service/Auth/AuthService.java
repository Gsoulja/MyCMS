package com.glodyfigueiredo.MyCMS.Service.Auth;

import com.glodyfigueiredo.MyCMS.Model.Auth.AuthenticationRequest;
import com.glodyfigueiredo.MyCMS.Model.Auth.AuthenticationResponse;
import com.glodyfigueiredo.MyCMS.Model.Auth.RegisterRequest;
import com.glodyfigueiredo.MyCMS.Enum.Role;
import com.glodyfigueiredo.MyCMS.Model.User.User;
import com.glodyfigueiredo.MyCMS.Repo.User.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {

        System.out.println(request);
        var user = User.builder().name(request.getName()).lastName(request.getLastName()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        user.setToken(jwtToken);
        userRepository.saveAndFlush(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    public boolean CheckUser(String email)
    {
        var user = userRepository.findByEmail(email);
        if(user.isEmpty())
        {
            return true;
        }
        return false;
    }
}
