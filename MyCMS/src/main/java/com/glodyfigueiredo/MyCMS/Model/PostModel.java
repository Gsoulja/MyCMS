package com.glodyfigueiredo.MyCMS.Model;

import com.glodyfigueiredo.MyCMS.Enum.Role;
import com.glodyfigueiredo.MyCMS.Model.Post.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostModel {
    private long id;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private boolean published;
    private Timestamp CreateAt;
    private LocalDate updateAt;
    private Date publishedAt;
    private String content;

    private List<Tag> postTags;

    private Role role;
}
