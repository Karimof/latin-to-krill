package com.example.latinToKrill.service;

import com.example.latinToKrill.entity.Word;
import com.example.latinToKrill.model.ConvertDTO;
import com.example.latinToKrill.repository.WordRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WordService {

    final WordRepo wordRepo;
    List<Word> recommendedWords = new ArrayList<>();
    HashMap<Integer, String[]> map = new HashMap<>();

    public WordService(WordRepo wordRepo) {
        this.wordRepo = wordRepo;
    }

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

    public ConvertDTO convert(String input1) {
        recommendedWords = new ArrayList<>();
        map = new HashMap<Integer, String[]>();

        input1 = input1.replace("&nbsp;", " ");
        input1 = input1.replace("<div>", "\n");
        input1 = input1.replace("</div>", "");
        input1 = input1.replace("<br>", " ");
        input1 = input1.trim().replace("\r\n", " ");
        //for adding to db
        {
//        input1 = input1.replace("\uE014", "o'");
//        input1 = input1.replace("_", "");
//        input1 = input1.replace("*", "");
//        input1 = input1.replace("\"", "");
//        input1 = input1.replace("”", "");
//        input1 = input1.replace("“", "");
//        input1 = input1.replace(",", "");
//        input1 = input1.replace(".", "");
//        input1 = input1.replace(":", "");
//        input1 = input1.replace(";", "");
//        input1 = input1.replace("«", "");
//        input1 = input1.replace("»", "");
//        input1 = input1.replace("?", "");
//        input1 = input1.replace("!", "");
//        input1 = input1.replace("\u0002", "");
        }
        input1 = input1.toLowerCase();
        String[] s = input1.split(" ");
//        List<String> temp = new ArrayList<>(Arrays.asList(s));
//        String r = "";

        //for adding to db
//        for (String s1 : s) {
//            if (s1.contains("(") || s1.contains("{") || s1.contains(")") || s1.contains("}") || s1.contains("/") ||
//                    s1.contains("0") ||
//                    s1.contains("1") ||
//                    s1.contains("2") ||
//                    s1.contains("3") ||
//                    s1.contains("4") ||
//                    s1.contains("5") ||
//                    s1.contains("6") ||
//                    s1.contains("7") ||
//                    s1.contains("8") ||
//                    s1.contains("9")
//            ) {
//                temp.remove(s1);
//            }
//        }

//        for (String s1 : temp) {
//            r += s1 + " ";
//        }

//        addWordsFromList(r);
        boolean hasError = false;
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
            String hasSymbol = "";
            if (s[i].endsWith(",") || s[i].endsWith(".") || s[i].endsWith(";") || s[i].endsWith(":") || s[i].endsWith("?")) {
                hasSymbol = s[i].split("")[s[i].length() - 1];
                s[i] = s[i].substring(0, s[i].length() - 1);

            }
            if (!wordRepo.existsByOneWord(s[i])) {
                hasError = true;
                if (s[i].endsWith("larnikidanda") || s[i].endsWith("larnikigacha")) {
                    String notFountWord = saveNewWord(s[i], 12);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("larnikidan")) {
                    String notFountWord = saveNewWord(s[i], 10);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("larnikiga") || s[i].endsWith("langandan")) {
                    String notFountWord = saveNewWord(s[i], 9);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("largacha") || s[i].endsWith("tirilgan") || s[i].endsWith("langanda") || s[i].endsWith("lanuvchi") || s[i].endsWith("inadigan")) {
                    String notFountWord = saveNewWord(s[i], 8);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("larniki") || s[i].endsWith("laridan") || s[i].endsWith("nikidan") || s[i].endsWith("ganidan")
                        || s[i].endsWith("ganlari") || s[i].endsWith("mizning") || s[i].endsWith("ladigan")) {
                    String notFountWord = saveNewWord(s[i], 7);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("lardan") || s[i].endsWith("lariga") || s[i].endsWith("sizlar") || s[i].endsWith("gandan") || s[i].endsWith("nikiga") || s[i].endsWith("nikida") || s[i].endsWith("ganini") || s[i].endsWith("ganlar") || s[i].endsWith("mizdan") || s[i].endsWith("dagina")) {
                    String notFountWord = saveNewWord(s[i], 6);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("laqol") || s[i].endsWith("larga") || s[i].endsWith("larni") || s[i].endsWith("larda") || s[i].endsWith("ingiz") || s[i].endsWith("dilar") || s[i].endsWith("kidan") || s[i].endsWith("magan") || s[i].endsWith("ganda") || s[i].endsWith("ganga") || s[i].endsWith("nidan") || s[i].endsWith("mizga") || s[i].endsWith("mizni") || s[i].endsWith("misiz") || s[i].endsWith("misan")) {
                    String notFountWord = saveNewWord(s[i], 5);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("niki") || s[i].endsWith("lari") || s[i].endsWith("aman") || s[i].endsWith("ning") || s[i].endsWith("dosh") || s[i].endsWith("gani") || s[i].endsWith("ligi") || s[i].endsWith("idan") || s[i].endsWith("gina")) {
                    String notFountWord = saveNewWord(s[i], 4);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("dan") || s[i].endsWith("lar") || s[i].endsWith("lik") || s[i].endsWith("dir") || s[i].endsWith("cha") || s[i].endsWith("kor") || s[i].endsWith("zor") || s[i].endsWith("giz") || s[i].endsWith("san") || s[i].endsWith("siz") || s[i].endsWith("roq") || s[i].endsWith("iga") || s[i].endsWith("adi") || s[i].endsWith("miz") || s[i].endsWith("xon") || s[i].endsWith("jon") || s[i].endsWith("bek")) {
                    String notFountWord = saveNewWord(s[i], 3);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("ni") || s[i].endsWith("ga") || s[i].endsWith("da") || s[i].endsWith("ki") || s[i].endsWith("yu") || s[i].endsWith("ma") || s[i].endsWith("li") || s[i].endsWith("la") || s[i].endsWith("im") || s[i].endsWith("gi") || s[i].endsWith("ng") || s[i].endsWith("mi") || s[i].endsWith("si")) {
                    String notFountWord = saveNewWord(s[i], 2);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }
                if (s[i].endsWith("i")) {
                    String notFountWord = saveNewWord(s[i], 1);
                    if (notFountWord != null) {
                        forRecommend(notFountWord, i);
                    }
                }

                //TODO minda shunchaki listga qo'shadi
                String mistake = s[i];
                forRecommend(mistake, i);

            } else {
                // word exceptions (istisnolar)
                s[i] = s[i].replace("ksio", "кцио");
                s[i] = s[i].replace("ksiya", "кция");
                // Months
                s[i] = s[i].replace("sentabr", "сентябрь");
                s[i] = s[i].replace("oktabr", "октябрь");
                s[i] = s[i].replace("noyabr", "ноябрь");
                s[i] = s[i].replace("dekabr", "декабрь");

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

                    }
                } else if (s[i].contains("ts") && s[i].length() > 2) {
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
                s[i] = s[i].replace("o‘", "ў");
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
            s[i] = s[i] + hasSymbol;
        }
        String result = "";
        for (String s1 : s) {
            result = result.concat(s1 + " ");
        }
        return new ConvertDTO(result, map);
    }

    public String saveNewWord(String word, int adLength) {
        String subs = word.substring(0, word.length() - adLength);
        if (wordRepo.existsByOneWord(subs) && !wordRepo.existsByOneWord(word)) {
            wordRepo.save(new Word(word));
            return null;
        }
        return subs;
    }

    public void forRecommend(String mistaken, int i) {
        String part1 = mistaken.substring(0, (int) (mistaken.length() * 0.5));
        String part2 = mistaken.substring((int) (mistaken.length() * 0.5));
        recommendedWords = wordRepo.findAllByOneWordLikeIgnoreCasePart1(part1);
        recommendedWords.addAll(wordRepo.findAllByOneWordLikeIgnoreCasePart2(part2));
        int index = 0;
        String recWordByIndex = "";
        List<String> likely = new ArrayList<>();
        List<String> likely80 = new ArrayList<>();
        List<String> likely90 = new ArrayList<>();

        while (index < recommendedWords.size() && index < 100) {
            recWordByIndex = recommendedWords.get(index).getOneWord();
            if (recWordByIndex.length() <= mistaken.length() + 1 && (recWordByIndex.startsWith(part1) || recWordByIndex.endsWith(part2)) && recWordByIndex.length() >= mistaken.length() - 1) {
                String[] letters = recWordByIndex.split("");

                int countLikelySimilar = 0;
                int length = letters.length;

                if (length > mistaken.length()) {
                    length = mistaken.length();
                }
                for (int j = 0; j < length; j++) {
                    if (letters[j].equals(mistaken.split("")[j])) {
                        countLikelySimilar++;
                    }
                }
                float efficient = 0.9f;
                if (mistaken.length() < 5) {
                    efficient = 0.75f;
                }
                if ((float) countLikelySimilar / mistaken.length() >= efficient) {
                    likely90.add(recWordByIndex);
                } else if ((float) countLikelySimilar / mistaken.length() >= efficient - 0.1) {
                    likely80.add(recWordByIndex);
                } else if ((float) countLikelySimilar / mistaken.length() > efficient - 0.2) {
                    likely.add(recWordByIndex);
                }
                index++;
            } else {
                recommendedWords.remove(index);
            }
        }
        likely.removeAll(likely90);
        likely.removeAll(likely80);
        likely.addAll(0, likely80);
        likely.addAll(0, likely90);

        String[] strLikely;
        if (likely.size() < 10) {
            strLikely = likely.toArray(new String[likely.size()]);
        } else {
            strLikely = likely.toArray(new String[10]);
        }

        map.put(i, strLikely);
    }
}
