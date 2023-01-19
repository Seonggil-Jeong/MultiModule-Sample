package com.sample.app.controller.res;

import com.sample.dto.PostDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class PostRes {
    private final long postSeq;
    private final String postContent;
    private final LocalDate createAt;

    public static PostRes ofDto(PostDto dto) {
        return PostRes.builder()
                .postSeq(dto.getPostSeq())
                .postContent(dto.getPostContent())
                .createAt(dto.getCreateAt()).build();
    }
}
