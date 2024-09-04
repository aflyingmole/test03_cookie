package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }
    @PostMapping("/member/login")
    public String login(@RequestParam("id")String id, @RequestParam("pwd")String pwd,HttpServletResponse resp) {
        if(id.equals("1") && pwd.equals("1")) {
            Cookie cookie = new Cookie("id", id); //쿠키 생성
            cookie.setMaxAge(60*3); //쿠키 유지시간 (초단위)
            resp.addCookie(cookie); // 쿠키를 응답객체에 담기
            return "redirect:/";
        }
        return "member/login";
    }
    @GetMapping("/member/logout")
    public String logout(HttpServletResponse resp){
        // 쿠키 삭제 -> 쿠키유지시간을 0으로 설정해서 응답객체에 담아보낸다
        Cookie cookie = new Cookie("id", null);
        cookie.setMaxAge(0); //쿠키유지시간을 0으로 설정
        resp.addCookie(cookie);
        return "redirect:/";
    }
}
