package com.example.latinToKrill.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@AllArgsConstructor
@Data
public class ConvertDTO {
    private String result;
    private HashMap<Integer, String[]> wordMistake;
}
