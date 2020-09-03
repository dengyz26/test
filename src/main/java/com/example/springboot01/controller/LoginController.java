package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        if(!StringUtils.isEmpty(email) && "123456".equals(password)) {
            session.setAttribute("loginUser", email);
            return "redirect:/main";
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            return "/";
        }
    }

    @RequestMapping("/user/signout")
    public String signOut(Model model, HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/";
    }
}
