package org.practice.spring.ioc_xml.service.impl;

import org.practice.spring.ioc_xml.Dao.StudentDao;
import org.practice.spring.ioc_xml.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent() {
        studentDao.saveStudent();
    }
}
