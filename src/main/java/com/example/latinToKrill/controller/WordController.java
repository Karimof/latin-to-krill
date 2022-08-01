package com.example.latinToKrill.controller;

import com.example.latinToKrill.model.ConvertDTO;
import com.example.latinToKrill.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class WordController {

    final
    WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping({"index", "", "/"})
    public String index() {
        return "index";
    }

    @PostMapping({"index", "", "/"})
    public String addWords(@ModelAttribute(name = "input1") String input1, @ModelAttribute(name = "input2") String input2, Model model) {
        ConvertDTO convertDTO = wordService.convert(input1);
        String result = convertDTO.getResult();
        HashMap<Integer, String[]> wordMistake = convertDTO.getWordMistake();
        model.addAttribute("text1", input1);
        model.addAttribute("text2", result);
        model.addAttribute("wordMistake", wordMistake);
        return "index";
    }
}
