package com.sample.service;

import com.sample.dto.PostDto;
import com.sample.model.PostEntity;
import com.sample.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    public List<PostDto> findAllPost() {
        return postRepository.findAll().stream().map(PostDto::ofEntity).collect(Collectors.toList());
    }

    public PostDto findPostByPostId(final long postSeq) {
        PostEntity result = postRepository.findById(postSeq).orElseThrow(()
                -> new NoSuchElementException("cannot found post with postId : " + postSeq));

        return PostDto.ofEntity(result);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createPost(final String postContent) {
        postRepository.save(PostEntity.builder()
                .postContent(postContent)
                .createAt(LocalDate.now()).build());
    }
}
