package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	//返回值是一个Json字符串
	@RequestMapping("/all/{page}/{rows}")
	@ResponseBody
	public List<ItemCat> findAll(@PathVariable Integer page,@PathVariable Integer rows){
		//List<ItemCat> itemCatList = itemCatService.findAll();
		//分页支持,startPage方法是静态
		//内部是调用连接器，startPage相当于begin，开启分页操作。
		List<ItemCat> itemCatList =itemCatService.findAll(page, rows);
		return itemCatList;
	}
}
