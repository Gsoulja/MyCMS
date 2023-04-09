package com.glodyfigueiredo.MyCMS.Service.Post;

import com.glodyfigueiredo.MyCMS.Model.Post.Post;
import com.glodyfigueiredo.MyCMS.Model.Post.Tag;
import com.glodyfigueiredo.MyCMS.Model.PostModel;
import com.glodyfigueiredo.MyCMS.Repo.Post.PostRepository;
import com.glodyfigueiredo.MyCMS.Repo.Post.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public Post createPost(PostModel postModel) {
        List<Tag> postTags = new ArrayList<>(postModel.getPostTags().size());
        for (Tag tag : postModel.getPostTags()) {

            Tag byTitle = tagRepository.findByTitle(tag.getTitle());
            if (byTitle != null) {
                postTags.add(byTitle);
            } else {
                postTags.add(tag);
            }
        }

        var post = Post.builder().title(postModel.getTitle()).metaTitle(postModel.getMetaTitle()).slug(postModel.getSlug()).summary(postModel.getSummary()).published(postModel.isPublished())
                .updateAt(postModel.getUpdateAt()).publishedAt(postModel.getPublishedAt()).content(postModel.getContent()).postTags(postTags).build();
        postRepository.save(post);

        return postRepository.findByTitle(postModel.getTitle());

    }

    public Post updatePost(PostModel postModel) {
        Optional<Post> post = postRepository.findById(postModel.getId());
        if(!post.isEmpty()) {
            post.get().setTitle(postModel.getTitle());
            post.get().setMetaTitle(postModel.getMetaTitle());
            post.get().setSummary(postModel.getSummary());
            post.get().setSlug(postModel.getSlug());
            post.get().setUpdateAt(java.time.LocalDate.now());
            post.get().setPublished(postModel.isPublished());
            post.get().setContent(postModel.getContent());
            post.get().setPostTags(postModel.getPostTags());

            postRepository.save(post.get());
        }
        return post.get();

    }

    public Post deletePost(PostModel postModel) {
        Optional<Post> post = postRepository.findById(postModel.getId());
        if(post != null)
        {
            postRepository.delete(post.get());
        }


        return post.get();

    }

    public List<Post> getPost() {
        List<Post> post = postRepository.findAll();



        return post;

    }
}
