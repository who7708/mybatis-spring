package org.mybatis.my;

import org.junit.After;
import org.junit.Test;
import org.mybatis.my.mapper.UserMapper;
import org.mybatis.my.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023.09.22 022
 */
public class TestMybatisSpring {

    ApplicationContext ac = null;

    @After
    public void after() throws Exception {
        System.out.println("===== after =====");
        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println(bean);
        }
    }

    @Test
    public void test1() throws Exception {
        System.out.println("===== test1 =====");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

    }

    @Test
    public void testMapper() {
        ac = new ClassPathXmlApplicationContext("mybatis-spring.xml");
        // UserMapper 是在 org.mybatis.spring.mapper.MapperFactoryBean.checkDaoConfig()
        // 中创建中 configuration.addMapper(this.mapperInterface); 然后交由 Spring 进行管理
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User u1 = userMapper.find("hehe");
        User u2 = userMapper.login("hehe", "123");
        System.out.println(u1.getName().equals(u2.getName()));
    }
}
