package com.example.latinToKrill.repository;

import com.example.latinToKrill.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordRepo extends JpaRepository<Word, Integer> {
    boolean existsByOneWord(String word);

    @Query("select w from Word w where " +
            "length(w.oneWord) <= ((length(:part1)*2)) and " +
            "length(w.oneWord) >= ((length(:part1)*2)-2) and " +
            "w.oneWord like :part1%")
    List<Word> findAllByOneWordLikeIgnoreCasePart1(@Param("part1") String part1);

    @Query("select w from Word w where " +
            "length(w.oneWord) <= ((length(:part2)*2)) and " +
            "length(w.oneWord) >= ((length(:part2)*2)-2) and " +
            "w.oneWord like %:part2")
    List<Word> findAllByOneWordLikeIgnoreCasePart2(@Param("part2") String part2);
}
