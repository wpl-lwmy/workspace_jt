package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.service.BaseService;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;

@Service
public class ItemCatServiceImpl extends BaseService<ItemCat> implements ItemCatService{
	//关联ItemCatmapper
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	public List<ItemCat> findAll(Integer page,Integer rows){
		//List<ItemCat> itemCatList = itemCatService.findAll();
		//分页支持,startPage方法是静态
		//内部是调用连接器，startPage相当于begin，开启分页操作。
		PageHelper.startPage(page, rows);
		List<ItemCat> itemCatList =itemCatMapper.findAll();
		//返回值不能直接返回，必须放在PageInfo对象中
		PageInfo <ItemCat> pageInfo= new PageInfo(itemCatList);
		return pageInfo.getList();
	}
}