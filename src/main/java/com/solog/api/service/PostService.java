package com.solog.api.service;

import com.solog.api.domain.Posts;
import com.solog.api.repository.PostRepository;
import com.solog.api.request.PostDto.PostCreate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostCreate postCreate) {
        postRepository.save(Posts.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build());
    }
}
