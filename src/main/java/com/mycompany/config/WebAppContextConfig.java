/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.config;

import com.cloudinary.Cloudinary;
import com.company.formatter.LoaiThuocFormatter;
import com.company.formatter.NguoiDungFormatter;
import com.company.formatter.PhieuKhamFormatter;
import com.company.formatter.ThuocFormatter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.eclipse.persistence.platform.database.CloudscapePlatform;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import static org.springframework.test.web.servlet.MockMvcExtensionsKt.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author ADMIN
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.mycompany.config",
    "com.mycompany.repository",
    "com.mycompany.controller",
    "com.mycompany.service"
})

public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new NguoiDungFormatter());
        registry.addFormatter(new LoaiThuocFormatter());
        registry.addFormatter(new PhieuKhamFormatter());
        registry.addFormatter(new ThuocFormatter());

    }

    @Override
    public Validator getValidator() {
        return WebMvcConfigurer.super.getValidator();
    }

    @Bean
    public LocalValidatorFactoryBean Validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        
        return v;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource r = new ResourceBundleMessageSource();
        r.setBasenames("messages");
 
        return r;
    }

    @Bean
    public InternalResourceViewResolver viewRosource() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();
        r.setPrefix("/WEB-INF/jsp/");
        r.setSuffix(".jsp");
        r.setViewClass(JstlView.class);
        return r;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }
//       @Bean
//    public JavaMailSender getMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("tongthuydy2703@gmail.com");
//        mailSender.setPassword("tongthuyvy");
//        Properties javaMailProperties = new Properties();
//        javaMailProperties.put("mail.smtp.starttls.enable", "true");
//        javaMailProperties.put("mail.smtp.auth", "true");
//        javaMailProperties.put("mail.transport.protocol", "smtp");
//        javaMailProperties.put("mail.debug", "true");
//        mailSender.setJavaMailProperties(javaMailProperties);
//        return mailSender;
//    }
//    

}
