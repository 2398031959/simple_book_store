package com.lei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lei.dao.Dict_busMapper;
import com.lei.po.Dict_bus;
import com.lei.po.Dict_busExample;
import com.lei.po.Dict_busExample.Criteria;
import com.lei.service.Dict_busService;
@Service
public class Dict_busServiceImpl implements Dict_busService {
	@Resource
	private Dict_busMapper mapper;
	@Override
	public List<Dict_bus> dictList(Integer userid) {
		Dict_busExample dict_busExample = new Dict_busExample();
		Criteria createCriteria = dict_busExample.createCriteria();
		createCriteria.andUseridEqualTo(userid);
		return mapper.selectByExample(dict_busExample);
	}
	@Override
	public Integer addDict(Dict_bus dict_bus) {
		return mapper.insertSelective(dict_bus);
	}
	@Override
	public Integer deleteDict(Integer did) {
		return mapper.deleteByPrimaryKey(did);
	}
}
