package com.wuhongyu.service.impl;


import com.wuhongyu.entity.Salary;
import com.wuhongyu.mapper.SalaryMapper;
import com.wuhongyu.mapper.UserMapper;
import com.wuhongyu.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Salary> selectAll() {
        return salaryMapper.selectAll();
    }

    @Override
    public void insert(Salary salary) {
        salaryMapper.insertSelective(salary);
    }

    @Override
    public void update(Salary salary) {
        salaryMapper.updateByPrimaryKeySelective(salary);
    }

    @Override
    public void delete(Integer id) {
        salaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBath(Integer[] ids) {
        for(Integer id: ids){
            this.delete(id);
        }
    }

    @Override
    public Salary queryById(Integer id) {
        Salary salary = salaryMapper.selectByPrimaryKey(id);
        salary.setUsername(userMapper.selectByPrimaryKey(salary.getUid()).getName());
        return salary;
    }
}