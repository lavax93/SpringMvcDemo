package com.lavax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LAVAX on 2017/12/14.
 */
@Controller
public class IndexController {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerNames.LOGISTICS_COMPONENT);

    private static final String LIST_PAGE = "index";

    @RequestMapping("/index")
    public String toIndex() {
//        logger.info("日志打印");
        return "/index";
    }
}
