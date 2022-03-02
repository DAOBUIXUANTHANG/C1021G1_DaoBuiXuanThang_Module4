package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Controller
public class SimpleDictionaryController {
    @GetMapping({"","/dictionary"})
    public String dictionary() {
        return "index";
    }

    @PostMapping({"","/dictionary"})
    public String simpleDictionary(@RequestParam String search, Model model) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "xin chao");
        stringMap.put("hi", "xin chao");
        stringMap.put("book", "quyen vo");
        stringMap.put("computer", "may tinh");
        stringMap.put("telephone","dien thoai");
        stringMap.put("street","duong");

        for (Map.Entry<String,String> entry: stringMap.entrySet()) {
//            return entry.getKey() +""+ entry.getValue();
            if(search.equals(entry.getKey())){
                model.addAttribute("result", entry.getValue());

            }
        }
        return "index";
    }
}
