package com.lavax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LAVAX on 2017/12/14.
 */
@Controller
public class IndexController {
    private static final String LIST_PAGE = "index";

    @RequestMapping("/index")
    public String toIndex() {
        return "/index";
    }
}
