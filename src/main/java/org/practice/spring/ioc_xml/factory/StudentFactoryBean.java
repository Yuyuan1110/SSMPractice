package org.practice.spring.ioc_xml.factory;

import org.practice.spring.ioc_xml.Student;
import org.springframework.beans.factory.FactoryBean;

public class StudentFactoryBean implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
