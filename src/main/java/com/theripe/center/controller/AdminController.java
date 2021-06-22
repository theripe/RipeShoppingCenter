package com.theripe.center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author TheRipe
 * @create 2021/6/22 20:52
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }
}
