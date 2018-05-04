package com.wuhongyu.common;

import com.wuhongyu.entity.Lelve;
import com.wuhongyu.entity.Salary;

import java.math.BigDecimal;
import java.util.HashMap;

//自定义常量
public class MyCommon {
	public static final Integer PAGESIZE = 10;

	public static final String FILEPATH = "E:\\myimage\\";

	public static Lelve LELVE = new Lelve();
	static {
		LELVE.setLelve("A");
		LELVE.setPrice(new BigDecimal(300));
	}

	public static Salary SALARY = new Salary();
	static {
		SALARY.setSalary(new BigDecimal(3000));
	}

	public static final HashMap<Integer,BigDecimal> DEDUCT = new HashMap<>();
	static {
		DEDUCT.put(1,new BigDecimal(100));
		DEDUCT.put(2,new BigDecimal(150));
		DEDUCT.put(3,new BigDecimal(200));
	}

	
}
