package org.practice.spring.ioc_xml.controller;

import org.practice.spring.ioc_xml.Student;
import org.practice.spring.ioc_xml.service.StudentService;
import org.practice.spring.ioc_xml.service.impl.StudentServiceImpl;

public class StudentController {

    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void saveStudent() {
        studentService.saveStudent();
    }
}
