package com.example.latinToKrill.controller;

import com.example.latinToKrill.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WordController {

    @Autowired
    WordService wordService;

    @GetMapping({"index", "", "/"})
    public String index() {
        return "index";
    }

    @PostMapping({"index", "", "/"})
    public String addWords(@ModelAttribute(name = "input1") String input1, @ModelAttribute(name = "input2") String input2, Model model) {
//        String stringWords = "baxt baxtsiz baxtli shahar olim";
//        wordService.addWordsFromList(stringWords);
//        model.addAttribute("");
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
        model.addAttribute("text1", input1);
        model.addAttribute("text2", result);
        return "index";
    }

    // This method for checking from definite URL
//    @PostMapping({"index", "", "/"})
//    public String indexPost(@ModelAttribute(name = "input1") String input1,
//                            @ModelAttribute(name = "input2") String input2) throws IOException {
//        URL url = new URL("https://imlo.uz/words/asdasdasd");
//
//        URLConnection urlConnection = null;
//        try {
//            urlConnection = url.openConnection();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        InputStream inputStream = urlConnection.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        if (reader != null) {
//            String line = "";
//            String s[];
//            while (true) {
//                try {
//                    if ((line = reader.readLine()) == null) break;
//                } catch (IOException e) {
//                }
////            s = line.split("\"");
////            int i = 0;
////
//                System.out.println(line);
////            while (i < s.length) {
////                if (s[i].equals("https://imlo.uz/words/" + input1.trim() + "/")) {
////                    r = s[i];
////                    break;
////                }
////                i++;
////            }
//            }
//        }
//        return "index";
//    }
}
