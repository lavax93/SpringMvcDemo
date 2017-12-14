package com.lavax.controller;

import com.lavax.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by LAVAX on 2017/12/14.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;


    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentDisplay");
        mav.addObject("time", new Date());
        mav.addObject("students", studentService.getAllStudent());
        return mav;
    }
}
