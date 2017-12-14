package com.lavax.dao;

import com.lavax.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAVAX on 2017/12/14.
 */
@Repository("studentDao")
public class StudentDao {
    public List<Student> findAll() {
        List<Student> all = new ArrayList<Student>();
        all.add(new Student("1", "tom", 18, true));
        all.add(new Student("2", "cat", 28, true));
        all.add(new Student("3", "lxk", 18, true));
        all.add(new Student("4", "cms", 18, true));
        return all;
    }
}
