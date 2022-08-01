package com.example.latinToKrill.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikelyWordsDTO {
    private int likelyRate;
    private String word;
}
