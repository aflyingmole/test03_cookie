package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BoardController {
    @GetMapping("member/board")
    public String board(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("post1");
        list.add("post2");
        list.add("post3");
        model.addAttribute("list", list);
        return "member/board";
    }
}
