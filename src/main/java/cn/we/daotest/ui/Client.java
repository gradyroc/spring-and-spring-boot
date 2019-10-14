package cn.we.daotest.ui;

import cn.we.daotest.dao.factory.BeanFactory;
import cn.we.daotest.service.IAccountService;
import cn.we.daotest.service.impl.AccountServiceImpl;

/**
 * @author gradyzhou
 * @version 1.0, on 21:55 2019/9/19.
 */
/*
模拟表现层，调用业务层
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        IAccountService as = (IAccountService) BeanFactory.getBean("accoutService");
        as.saveAccount();
    }
}
