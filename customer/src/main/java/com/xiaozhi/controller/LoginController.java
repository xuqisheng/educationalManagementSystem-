package com.xiaozhi.controller;

import com.google.gson.Gson;
import com.xiaozhi.model.StudentVo;
import com.xiaozhi.service.LoginService;
import com.xiaozhi.utils.JsonUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 小智 on 2017/4/18 0018.
 */
@Controller
@RequestMapping("login")
public class LoginController{
    @Resource
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/studentLogin", method = RequestMethod.GET)
    public StudentVo studentLogin(@RequestParam String studentId, @RequestParam String password,
                                  HttpServletResponse response, HttpServletRequest request){
        StudentVo studentVo = loginService.studentLogin(studentId, password);
        request.getSession().setAttribute("student", studentVo);
        Cookie cookie = new Cookie("student", JsonUtils.object2json(studentVo));
        response.addCookie(cookie);
        return studentVo;
    }
}