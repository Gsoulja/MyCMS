package com.glodyfigueiredo.MyCMS.Controller.Post;

import com.glodyfigueiredo.MyCMS.Model.PostModel;
import com.glodyfigueiredo.MyCMS.Model.Response;
import com.glodyfigueiredo.MyCMS.Service.Post.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/mycms/post")
@RequiredArgsConstructor
public class postControle {
    private final PostService postService;
    @PostMapping("/create")
    public ResponseEntity<Response> createPost(@RequestBody @Valid PostModel postModel)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Post",postService.createPost(postModel)))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
    @GetMapping()
    public ResponseEntity<Response> createPost()
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Posts",postService.getPost()))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
    @PatchMapping("/update")
    public ResponseEntity<Response> updatePost(@RequestBody @Valid PostModel postModel)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Post",postService.updatePost(postModel)))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
    @PostMapping("/delete")
    public ResponseEntity<Response> deletePost(@RequestBody @Valid PostModel postModel)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Post",postService.deletePost(postModel)))
                        .status(HttpStatus.GONE)
                        .statusCode(HttpStatus.GONE.value())
                        .build());
    }
}
