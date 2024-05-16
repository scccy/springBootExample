package com.scccy.springbootexample01.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scccy.springbootexample01.domain.User;
import com.scccy.springbootexample01.mapper.UserMapper;
import com.scccy.springbootexample01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
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
