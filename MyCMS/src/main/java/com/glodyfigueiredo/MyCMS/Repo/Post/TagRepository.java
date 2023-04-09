package com.glodyfigueiredo.MyCMS.Repo.Post;

import com.glodyfigueiredo.MyCMS.Model.Post.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByTitle(String title);
}
