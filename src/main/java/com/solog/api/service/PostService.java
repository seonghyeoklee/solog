package com.solog.api.service;

import com.solog.api.request.PostDto;

public interface PostService {

    void createPost(PostDto.PostCreate postCreate);

}
