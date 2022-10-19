package com.solog.api.service;

import com.solog.api.domain.Posts;
import com.solog.api.repository.PostRepository;
import com.solog.api.request.PostDto.PostCreate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createPost(PostCreate postCreate) {
        Posts entity = Posts.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(entity);
    }
}
