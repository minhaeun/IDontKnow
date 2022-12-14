package com.idk.api.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.idk.api.comment.domain.entity.Comment;
import com.idk.api.vote.domain.entity.Vote;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentResponse {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class OnlyId {
        private Long commentId;

        public static CommentResponse.OnlyId build(Comment comment) {
            return OnlyId.builder()
                    .commentId(comment.getId())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class GetOne {
        private Long commentId;
        private Long userId;
        private String name;
        private String content;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd hh:mm", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;
        private boolean checkAuthor;

        public static CommentResponse.GetOne build(Long voteUserId, Comment comment) {
            return GetOne.builder()
                    .commentId(comment.getId())
                    .userId(comment.getUser().getId())
                    .name(comment.getUser().getName())
                    .content(comment.getContent())
                    .createdAt(comment.getCreatedAt())
                    .checkAuthor(Objects.equals(voteUserId, comment.getUser().getId()))
                    .build();
        }
    }
}
