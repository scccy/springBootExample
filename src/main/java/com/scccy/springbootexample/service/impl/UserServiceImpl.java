package com.scccy.springbootexample.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scccy.springbootexample.domain.User;
import com.scccy.springbootexample.mapper.UserMapper;
import com.scccy.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
/*
 * 表明该类（class）或方法（method）受事务控制
 * @param propagation  设置隔离级别
 * @param isolation 设置传播行为
 * @param rollbackFor 设置需要回滚的异常类，默认为RuntimeException
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> allData = userMapper.getall();

        PageInfo<User> pageInfo = new PageInfo<>(allData);
        return pageInfo.getList();
    }
}
