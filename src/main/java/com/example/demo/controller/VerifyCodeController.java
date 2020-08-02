package com.example.demo.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@RestController
@Slf4j
public class VerifyCodeController extends BaseController {
    @Autowired
    DefaultKaptcha kaptcha;

    @GetMapping("/code")
    public void refreshVerifyCode(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String capText = kaptcha.createText();
        HttpSession session = req.getSession();
        session.setAttribute("KAPTCHA_SESSION_KEY", capText);
        session.setAttribute("KAPTCHA_SESSION_DATE", Long.valueOf(System.currentTimeMillis()));
        log.info("session 创建成功，id:{}；图片校验码:{}", session.getId(),capText);

        BufferedImage bi = kaptcha.createImage(capText);
        res.setHeader("Cache-Control", "no-store, no-cache");
        res.setContentType("image/png");
        OutputStream os = res.getOutputStream();
        ImageIO.write(bi, "png", os);
    }

    private boolean checkVerifyCode(String verifyCode, HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session == null){
            log.info("session 已销毁，验证码校验无效");
            return false;
        }

        String kaptcheExpected = (String)session.getAttribute("KAPTCHA_SESSION_KEY");
        String kaptcheCreateTime = (String)session.getAttribute("KAPTCHA_SESSION_DATE");
        log.info("session id:{}；图片校验码期望值:{}；提交值:{}", session.getId(), kaptcheExpected, verifyCode);
        if (verifyCode == null || kaptcheExpected == null || !verifyCode.equalsIgnoreCase(kaptcheExpected))
            return false;
        session.removeAttribute("KAPTCHA_SESSION_KEY");
        session.removeAttribute("KAPTCHA_SESSION_DATE");
        return true;
    }
}
