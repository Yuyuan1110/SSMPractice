package org.practice.spring.test.anno;

import org.junit.jupiter.api.Test;
import org.practice.spring.ioc_annotation.controller.UserController;
import org.practice.spring.ioc_annotation.controller.impl.UserControllerImpl;
import org.practice.spring.ioc_annotation.dao.UserDao;
import org.practice.spring.ioc_annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
//      default ID is lower letter of class name
        UserControllerImpl bean = ioc.getBean("userControllerImpl", UserControllerImpl.class);
        System.out.println(bean);
        UserService bean1 = ioc.getBean(UserService.class);
        System.out.println(bean1);
//      ID set from @Component("ID"), In this case is @Repository("dao")
        UserDao bean2 = ioc.getBean("dao",UserDao.class);
        System.out.println(bean2);

//      @Autowired can annotate on the Instance variables and set method, set method include setter and constructor
//      @Qualifier("ID") can specific the id from the bean to value the attribute of bean.
        bean.saveUser();
    }
}
