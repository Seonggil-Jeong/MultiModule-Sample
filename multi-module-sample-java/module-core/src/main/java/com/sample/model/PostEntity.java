package com.sample.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postSeq;

    @NotNull
    @Column(name = "post_content", nullable = false)
    private String postContent;

    @NotNull
    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;
}
