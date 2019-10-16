package com.lankeren.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class LogOutController {


    @RequestMapping(value = "/stuLogout")
    public String stuLogout(HttpServletRequest request){

        request.getSession().removeAttribute("map");
        return "redirect:/";
    }



}
