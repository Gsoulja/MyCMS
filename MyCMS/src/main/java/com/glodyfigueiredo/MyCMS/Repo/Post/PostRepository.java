package com.glodyfigueiredo.MyCMS.Repo.Post;

import com.glodyfigueiredo.MyCMS.Model.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository  extends JpaRepository<Post,Long > {

    Post findByTitle(String title);
    Optional<Post> findById(Long id);


}
