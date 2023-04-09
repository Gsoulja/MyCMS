package com.glodyfigueiredo.MyCMS.Repo.User;


import com.glodyfigueiredo.MyCMS.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository <User,Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);

}
