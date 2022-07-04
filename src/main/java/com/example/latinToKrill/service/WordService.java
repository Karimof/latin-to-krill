package com.example.latinToKrill.service;

import com.example.latinToKrill.entity.Word;
import com.example.latinToKrill.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    WordRepo wordRepo;

    public void addWordsFromList(String stringWords) {
        String[] words = stringWords.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!wordRepo.existsByOneWord(words[i])) {
                Word word = new Word();
                word.setOneWord(words[i]);
                wordRepo.save(word);
            }
        }
    }
}
