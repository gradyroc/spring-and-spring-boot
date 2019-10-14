package cn.we.daotest.dao.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author gradyzhou
 * @version 1.0, on 21:58 2019/9/19.
 */
/*
创建Bean 对象的工厂
Bean：可重用组件的含义
javaBean：java 语言创建的可重用组件实体
 */
public class BeanFactory {
    private static Properties properties;

    //存放我们要创建的对象，容器
    private static Map<String,Object>beans;




    static {
        try {
            //实例化对象
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            //实例化容器
            beans = new HashMap<String, Object>();

            //取出配置文件中所有的key
            Enumeration keys = properties.keys();

            while (keys.hasMoreElements()){

                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();

                beans.put(key,value);
            }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("init failed ");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    *@Author: zhoup
    *@Description:根据beanname huoqu duixiang
    *@Params:
    *@Date:
    *@return:
    */
    public static Object getBean(String beanName){
//        Object bean = null ;
//        try {
//
//            String beanPath = properties.getProperty(beanName);
//            System.out.println(beanPath);
//            bean = Class.forName(beanPath).newInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return  bean;
        //变成单例模式
        return beans.get(beanName);
    }
}
