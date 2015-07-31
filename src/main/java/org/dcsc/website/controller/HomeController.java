package org.dcsc.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tktong on 7/7/2015.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {
        return "main/home";
    }
}
