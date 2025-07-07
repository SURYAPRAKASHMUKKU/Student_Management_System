package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // method to display empty form
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    // method to save student form data
    @GetMapping("/saveStudent")
    public ModelAndView handleSubmitBtn(Student s) {
        ModelAndView mav = new ModelAndView();
        boolean isSaved = service.saveStudent(s);
        if (isSaved) {
            mav.addObject("smsg", "Student Saved");
        } else {
            mav.addObject("emsg", "Failed To Save");
        }
        mav.setViewName("index");
        return mav;
    }

    // method to get all students data
    @GetMapping("/getData")
    public ModelAndView getAllStudents() {
        List<Student> stuList = service.getAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", stuList);
        mav.setViewName("data");
        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView deleteRecord(@RequestParam Integer stuId)
    {
        service.delete(stuId);
        List<Student> stuList = service.getAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", stuList);
        mav.addObject("msg", "Deleted Successfully");
        mav.setViewName("data");
        return mav;
    }

}
