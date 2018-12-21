package com.connext.ssm.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.connext.ssm.pojo.User;
import com.connext.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * 用户登录
     *
     * @param req
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model, HttpSession httpSession) {
        Integer count = redisTemplate.opsForValue().get(req.getParameter("telephone"));
        if(count != null && count >= 3){
            model.addAttribute("message", "您已连续连续输错三次密码，请等待120s");
            redisTemplate.expire(req.getParameter("telephone"),120 , TimeUnit.SECONDS);//设置过期时间
            return "login";
        }
        String password = MD5Utils.encode(req.getParameter("password"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("telephone", req.getParameter("telephone"));
        map.put("password", password);
        User user = userService.login(map);
        if (user != null) {// 登录成功进入消息页面
            httpSession.setAttribute("telephone",map.get("telephone"));
            redisTemplate.delete(req.getParameter("telephone"));
            return "redirect: /info/queryAll";
        } else {// 登录失败回到登录页面
            Integer failCount = redisTemplate.opsForValue().get(req.getParameter("telephone"));
            redisTemplate.opsForValue().set(req.getParameter("telephone"), failCount == null ? 0 : failCount + 1);
            model.addAttribute("message", "用户名或密码输入错误,请重新输入");
            return "login";
        }

    }

    @RequestMapping("/goRegister")
    public String goRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String regist(User user,Model model,@RequestParam("tel_code") String tel_code,@RequestParam("telephone")String telephone) {
        boolean flag = userService.queryByTelephone(user);
        if(!flag) {
            Integer phoneCode = redisTemplate.opsForValue().get(telephone + "RE");
            if (phoneCode != null && phoneCode.toString().equals(tel_code)) {
                userService.regist(user);
                return "login";
            } else{
                model.addAttribute("message","验证码输入错误！");
                return "register";
            }

        }else{
            model.addAttribute("message","该手机号已注册，请重新注册");
            return "register";
        }
    }
    @RequestMapping(value = "/getCode/{telephone}",method = RequestMethod.GET)
    @ResponseBody
    public String getCode(@PathVariable String telephone) {
        // 存入redis
        Integer oldCode = redisTemplate.opsForValue().get(telephone + "RE");
        if (oldCode == null) {
            Integer verifyCode = new Random().nextInt(899999) + 100000;
            redisTemplate.opsForValue().set(telephone + "RE", verifyCode);
            System.out.println(String.valueOf(verifyCode));
        }
        return "okay";
    }
}
