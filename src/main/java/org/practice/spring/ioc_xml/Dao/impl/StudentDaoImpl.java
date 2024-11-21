package org.practice.spring.ioc_xml.Dao.impl;

import org.practice.spring.ioc_xml.Dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void saveStudent() {
        System.out.println("save student success");
    }
}
