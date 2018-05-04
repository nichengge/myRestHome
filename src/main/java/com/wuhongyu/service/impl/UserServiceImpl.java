package com.wuhongyu.service.impl;

import java.util.List;

import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.*;
import com.wuhongyu.mapper.CountsMapper;
import com.wuhongyu.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuhongyu.entity.UserExample.Criteria;
import com.wuhongyu.mapper.UserMapper;
import com.wuhongyu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SalaryMapper salaryMapper;
	@Autowired
	private CountsMapper countsMapper;

	@Override
	public List<User> selectAll(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(user != null) {
			if(user.getName() != null) {
				criteria.andNameLike("%"+user.getName()+"%");
			}
		}
		List<User> userList = userMapper.selectByExample(example);
		return userList;
	}

	@Override
	public void addUser(User user) {
		userMapper.insertSelective(user);
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> userList = userMapper.selectByExample(example);
		User user2 = userList.get(0);
		//增加相应的工资表
		Salary salary = MyCommon.SALARY;
		salary.setUid(user2.getId());
		salaryMapper.insertSelective(salary);
		SalaryExample salaryExample = new SalaryExample();
		salaryExample.createCriteria().andUidEqualTo(user2.getId());
		List<Salary> salaryList = salaryMapper.selectByExample(salaryExample);
		salary = salaryList.get(0);
		//添加相应的统计表
		Counts counts = new Counts();
		counts.setUid(user2.getId());
		counts.setSid(salary.getId());
		countsMapper.insertSelective(counts);
	}

	@Override
	public void deleteById(Integer id) {
		//删除相应的统计表
		CountsExample countsExample = new CountsExample();
		countsExample.createCriteria().andUidEqualTo(id);
		countsMapper.deleteByExample(countsExample);
		SalaryExample salaryExample = new SalaryExample();
		salaryExample.createCriteria().andUidEqualTo(id);
		salaryMapper.deleteByExample(salaryExample);
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		for (Integer integer : ids) {
			userMapper.deleteByPrimaryKey(integer);
		}
	}

	@Override
	public User queryById(Integer id) {
		User user1 = userMapper.selectByPrimaryKey(id);
		return user1;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

}
