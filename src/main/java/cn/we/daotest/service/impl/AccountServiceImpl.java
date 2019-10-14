package cn.we.daotest.service.impl;

import cn.we.daotest.dao.IAccountDao;
import cn.we.daotest.dao.factory.BeanFactory;
import cn.we.daotest.dao.impl.AccountDaoImpl;
import cn.we.daotest.service.IAccountService;

/**
 * @author gradyzhou
 * @version 1.0, on 21:34 2019/9/19.
 */
/*
账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    private int i = 1;

    public void saveAccount() {
        //业务层调持久层
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
