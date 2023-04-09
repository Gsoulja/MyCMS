package com.glodyfigueiredo.MyCMS.Service.User;


import com.glodyfigueiredo.MyCMS.Model.User.User;
import com.glodyfigueiredo.MyCMS.Repo.User.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String token) {

        Optional<User> byToken = userRepository.findByToken(token);
        if (byToken.isPresent())
            return byToken.get();

        return null;
    }
}
