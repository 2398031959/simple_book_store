package com.lei.service;

import java.util.List;

import com.lei.po.Dict_bus;

public interface Dict_busService {
	public List<Dict_bus> dictList(Integer userid);

	public Integer addDict(Dict_bus dict_bus);

	public Integer deleteDict(Integer did);
}
