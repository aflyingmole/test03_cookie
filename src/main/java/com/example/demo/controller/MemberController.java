package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MemberController {
    @GetMapping("/member/item")
    public String item(Model model, HttpServletRequest req) {

        ArrayList<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        model.addAttribute("list", list);

        // 쿠키에 id가 존재하는지 검사
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    model.addAttribute("id", cookie.getValue());
                    return "member/item";
                }
            }
        }
        return "redirect:/member/login";
    }

}
