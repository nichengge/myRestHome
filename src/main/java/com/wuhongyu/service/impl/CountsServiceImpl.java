package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Counts;
import com.wuhongyu.entity.Leaves;
import com.wuhongyu.mapper.CountsMapper;
import com.wuhongyu.mapper.LeavesMapper;
import com.wuhongyu.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("countsService")
public class CountsServiceImpl implements CountService {

    @Autowired
    private CountsMapper countsMapper;
    @Autowired
    private LeavesMapper leavesMapper;

    @Override
    public List<Counts> count() {
        List<Counts> countsList = countsMapper.selectAll();
        for(Counts c: countsList){
            List<Leaves> leaveList = leavesMapper.selectAll(c.getUid());
            Integer absence =0;
            for (Leaves l: leaveList){
                absence += l.getDeduct().intValue();
            }
            c.setAbsence(absence);
            c.setWage(new BigDecimal(c.getSalary()-absence));
            c.setCreatetime(new Date());
        }
        return countsList;
    }
}