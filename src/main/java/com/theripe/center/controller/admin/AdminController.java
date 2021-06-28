package com.theripe.center.controller.admin;

import com.theripe.center.bean.AdminUser;
import com.theripe.center.dao.AdminUsersMapper;
import com.theripe.center.service.AdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author TheRipe
 * @create 2021/6/22 20:52
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminUserService adminUserService;
    @Resource
    AdminUsersMapper mapper;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
    @RequestMapping({"","/","/index","index.html"})
    public String index() { return "admin/index";}
    @PostMapping("/login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password") String password, @RequestParam("verifyCode") String verifyCode, HttpSession session) {
     if (StringUtils.isEmpty(verifyCode)) {
         session.setAttribute("errorMsg", "验证码不能为空");
         return "admin/login";
     }
     if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
         session.setAttribute("errorMsg","用户名或密码不能为空");
         return "admin/login";
     }
     String Code = session.getAttribute("verifyCode") + "";
     if (StringUtils.isEmpty(verifyCode) || !verifyCode.toLowerCase().equals(Code)) {
         session.setAttribute("errorMsg","验证码不正确");
         return "admin/login";
     }
     AdminUser adminUser = adminUserService.login(userName,password);
     if(adminUser != null) {
         session.setAttribute("loginUser", adminUser.getNickName());
         session.setAttribute("loginUserId",adminUser.getAdminUserId());
         return "redirect:/admin/index";
     } else {
         session.setAttribute("errorMsg","登录失败");
         return "admin/login";
     }

    }
}
