package com.sample.dto;

import com.sample.model.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long postSeq;
    private String postContent;
    private LocalDate createAt;


    public static PostDto ofEntity(PostEntity entity) {
        return PostDto.builder()
                .postSeq(entity.getPostSeq())
                .postContent(entity.getPostContent())
                .createAt(entity.getCreateAt()).build();
    }
}
