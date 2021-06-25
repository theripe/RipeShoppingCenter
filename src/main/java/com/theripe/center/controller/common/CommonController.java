package com.theripe.center.controller.common;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author TheRipe
 * @create 2021/6/24 10:50
 */
@Controller
public class CommonController {

    @RequestMapping("/common/kaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");
        //验证码设置
        SpecCaptcha captcha = new SpecCaptcha(150,40,4);
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        captcha.setCharType(Captcha.FONT_9);
        request.getSession().setAttribute("verifyCode",captcha.text().toLowerCase());
        System.out.println(captcha.text().toLowerCase());
        captcha.out(response.getOutputStream());

    }

}
