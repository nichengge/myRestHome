package com.wuhongyu.service.impl;

import java.util.List;

import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.*;
import com.wuhongyu.mapper.*;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuhongyu.service.OldmanService;

@Service("oldmanService")
public class OldmanServiceImpl implements OldmanService{

	
	@Autowired
	private OldmanMapper oldmanMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LelveMapper lelveMapper;
	@Autowired
	private ContactsMapper contactsMapper;
	@Autowired
	private MalfunctionMapper malfunctionMapper;


	@Override
	public List<Oldman> selectAll(Oldman oldman) {
		List<Oldman> oldmanList = oldmanMapper.selectAll(oldman);
		return oldmanList;
	}

	@Override
	public void addOldman(Oldman oldman) {
		OldmanExample example = new OldmanExample();
		example.createCriteria();
		List<Oldman> oldmanList = oldmanMapper.selectByExample(example);
		oldman.setId(oldmanList.get(oldmanList.size()-1).getId()+1);
		oldmanMapper.insertSelective(oldman);
		Lelve lelve = MyCommon.LELVE;
		lelve.setOldid(oldman.getId());
		lelveMapper.insertSelective(lelve);
	}

	@Override
	public void deleteById(Integer id) {
		Oldman oldman = oldmanMapper.selectByPrimaryKey(id);
		if(oldman.getPic()!=null){
			MyUtil.deleteNullPic(oldman.getPic());
		}
		//删除老人之前把等级表删了
		Lelve lelve = lelveMapper.queryByOldid(id);
		if(lelve != null){
			lelveMapper.deleteByPrimaryKey(lelve.getId());
		}
		//联系人表
		ContactsExample cexample = new ContactsExample();
		cexample.createCriteria().andOldidEqualTo(id);
		contactsMapper.deleteByExample(cexample);
		//事故表
		MalfunctionExample mexample = new MalfunctionExample();
		mexample.createCriteria().andOldidEqualTo(id);
		malfunctionMapper.deleteByExample(mexample);
		oldmanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		for (Integer id: ids) {
			this.deleteById(id);
		}
	}

	@Override
	public Oldman queryById(Integer id) {
		Oldman oldman = oldmanMapper.selectByPrimaryKey(id);
		oldman.setUsername(userMapper.selectByPrimaryKey(oldman.getUid()).getName());
		return oldman;
	}

	@Override
	public void updateOldman(Oldman oldman) {
		oldmanMapper.updateByPrimaryKeySelective(oldman);
	}


	@Override
	public List<Oldman> selectFreeOldman(Integer uid) {
		List<Oldman> oldmanList = oldmanMapper.selectFreeOldman(uid);
		return oldmanList;
	}


}
