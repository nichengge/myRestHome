package com.wuhongyu.service;

import com.wuhongyu.entity.Salary;

import java.util.List;

public interface SalaryService {

    public List<Salary> selectAll();

    public void insert(Salary salary);

    public void update(Salary salary);

    public void delete(Integer id);

    public void deleteBath(Integer[] ids);

    public Salary queryById(Integer id);
}
