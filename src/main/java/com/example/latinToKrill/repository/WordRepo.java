package com.example.latinToKrill.repository;

import com.example.latinToKrill.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Integer> {
    boolean existsByOneWord(String word);
}
