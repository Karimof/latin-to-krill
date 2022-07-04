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
        for (String s : words) {
            if (!wordRepo.existsByOneWord(s)) {
                Word word = new Word();
                word.setOneWord(s);
                wordRepo.save(word);
            }
        }
    }

    public String convert(String input1) {
        String stringWords = "baxt baxtsiz aksiya reaksiya shahar olim mo'l xona hon";
        addWordsFromList(stringWords);
        input1 = input1.replace("\r\n", " ");

        String[] s = input1.split(" ");

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].replace("ksio", "кцио");
            s[i] = s[i].replace("ksiya", "кция");
            // 's' bor yo'qligini aniqlash
            if (s[i].startsWith("s")) {
                // so'z 's' bilan boshlansa
                if (s[i].startsWith("si") || s[i].startsWith("se")) {
                    s[i] = s[i].replace("seziy", "цезий");
                    s[i] = s[i].replace("seytnot", "цейтнот");
                    s[i] = s[i].replace("sellofan", "целлофан");
                    s[i] = s[i].replace("selsiy", "цельсий");
                    s[i] = s[i].replace("sement", "цемент");
                    s[i] = s[i].replace("senzor", "цензор");
                    s[i] = s[i].replace("senzura", "цензура");
                    s[i] = s[i].replace("sentner", "центнер");
                    s[i] = s[i].replace("sex", "цех");
                    s[i] = s[i].replace("sivilizatsiya", "цивилизация");
                    s[i] = s[i].replace("sikl", "цикл");
                    s[i] = s[i].replace("silindr", "цилиндр");
                    s[i] = s[i].replace("sirkul", "циркуль");
                    if (!s[i].contains("sirka")) s[i] = s[i].replace("sirk", "цирк");
                    s[i] = s[i].replace("sisterna", "цистерна");
                    s[i] = s[i].replace("sitrus", "цитрус");

                    // 'ts' bor yo'qligini tekshirish
                }
            } else if (s[i].contains("ts")) {
                if (s[i].length() > 2) {
                    String[] word = s[i].split("");
                    // TODO this for loop
                    for (int j = 1; j < word.length - 1; j++) {

                        // element index ini topish uchun
                        if (word[j].equals("t") && word[j + 1].equals("s")) {
                            if (word[j - 1].equals("e") || word[j - 1].equals("u") || word[j - 1].equals("i") || word[j - 1].equals("a")) {
                                s[i] = s[i].replace("ts", "ц");
                            } else {
                                s[i] = s[i].replace("ts", "тс");
                            }
                        }
                    }
                }
            }
            s[i] = s[i].replace("ng", "нг");
            s[i] = s[i].replace("sh", "ш");
            s[i] = s[i].replace("ch", "ч");
            s[i] = s[i].replace("o'", "ў");
            s[i] = s[i].replace("g'", "ғ");
            s[i] = s[i].replace("'", "ъ");
            s[i] = s[i].replace("ye", "е");
            s[i] = s[i].replace("yu", "ю");
            s[i] = s[i].replace("ya", "я");
            s[i] = s[i].replace("yo", "ё");
            s[i] = s[i].replace("ts", "ц");

            s[i] = s[i].replace("q", "қ");
            s[i] = s[i].replace("e", "е");
            s[i] = s[i].replace("r", "р");
            s[i] = s[i].replace("t", "т");
            s[i] = s[i].replace("y", "й");
            s[i] = s[i].replace("u", "у");
            s[i] = s[i].replace("i", "и");
            s[i] = s[i].replace("o", "о");
            s[i] = s[i].replace("p", "п");
            s[i] = s[i].replace("a", "а");
            s[i] = s[i].replace("s", "с");
            s[i] = s[i].replace("d", "д");
            s[i] = s[i].replace("f", "ф");
            s[i] = s[i].replace("g", "г");
            s[i] = s[i].replace("h", "ҳ");
            s[i] = s[i].replace("j", "ж");
            s[i] = s[i].replace("k", "к");
            s[i] = s[i].replace("l", "л");
            s[i] = s[i].replace("z", "з");
            s[i] = s[i].replace("x", "х");
            s[i] = s[i].replace("v", "в");
            s[i] = s[i].replace("b", "б");
            s[i] = s[i].replace("n", "н");
            s[i] = s[i].replace("m", "м");
        }
        String result = "";
        for (String s1 : s) {
            result = result.concat(s1 + " ");
        }
        return result;
    }
}
