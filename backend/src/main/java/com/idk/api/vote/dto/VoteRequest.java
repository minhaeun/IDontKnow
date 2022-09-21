package com.idk.api.vote.dto;

import com.idk.api.common.category.Category;
import com.idk.api.common.category.SubCategory;
import lombok.*;

public class VoteRequest {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Create {
        private String title;
        private Category category;
        private SubCategory subCategory;
        private String optionA;
        private String optionB;
    }
}
