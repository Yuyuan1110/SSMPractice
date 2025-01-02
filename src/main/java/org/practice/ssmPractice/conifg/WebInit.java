package org.practice.ssmPractice.conifg;

import jakarta.servlet.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class, WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        jakarta.servlet.ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setMultipartConfig(new MultipartConfigElement(null, 1048576, 1048576, 0));

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        servletContext.addListener(new MyListener());
    }
}


//public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
////    replace spring config
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{SpringConfig.class};
//    }
//
//    @Override
////    replace springMVC config
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{WebConfig.class};
//    }
//
//    @Override
////    setup Springmvc url-pattern of front end controller DispatcherServlet
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
////    Setup filter
//    protected Filter[] getServletFilters() {
////        encoding filter
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
//
//        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
//        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setMultipartConfig(new MultipartConfigElement(null, 1048576, 1048576, 0));
//    }
//}
