package com.lavax.service;

import com.lavax.dao.StudentDao;
import com.lavax.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LAVAX on 2017/12/14.
 */
@Service("studentService")
public class StudentService {
    @Resource(name = "studentDao")
    private StudentDao dao;

    public List<Student> getAllStudent() {
        return dao.findAll();
    }
}
