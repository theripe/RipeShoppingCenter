package com.theripe.center.controller.admin;

import com.theripe.center.bean.AdminUser;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.dao.AdminUsersMapper;
import com.theripe.center.service.AdminUserService;
import com.theripe.center.utils.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @RequestMapping("/zhuce")
    public String zhuec(@RequestParam("userName") String userName, @RequestParam("password") String password,@RequestParam("nickName") String nickName) {
        AdminUser user = new AdminUser();
        user.setLoginUserName(userName);
        String s = MD5Util.MD5Encode(password, "UTF-8");
        user.setLoginPassword(s);
        user.setNickName(nickName);
        int i = adminUserService.insertAdmin(user);
        return i + ":";
    }

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

    @GetMapping("/test")
    public String test(){
        return "admin/test";
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        Integer loginUserId = (Integer) request.getSession().getAttribute("loginUserId");
        AdminUser adminUser = adminUserService.getUserById(loginUserId);
        if(adminUser == null) {
            return "admin/login";
        }
        request.setAttribute("path","profile");
        request.setAttribute("loginUserName",adminUser.getLoginUserName());
        request.setAttribute("nickName",adminUser.getNickName());
        return "admin/profile";

    }
    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request, @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (StringUtils.isEmpty(originalPassword) || StringUtils.isEmpty(newPassword)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updatePassword(loginUserId, originalPassword, newPassword)) {
            //修改成功后清空session中的数据，前端控制跳转至登录页
            request.getSession().removeAttribute("loginUserId");
            request.getSession().removeAttribute("loginUser");
            request.getSession().removeAttribute("errorMsg");
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request, @RequestParam("loginUserName") String loginUserName,
                             @RequestParam("nickName") String nickName) {
        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(nickName)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updateName(loginUserId, loginUserName, nickName)) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUserId");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}




