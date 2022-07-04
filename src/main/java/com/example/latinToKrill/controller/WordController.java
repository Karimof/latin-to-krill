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
        String result = wordService.convert(input1);
        model.addAttribute("text1", input1);
        model.addAttribute("text2", result);
        return "index";
    }
}
