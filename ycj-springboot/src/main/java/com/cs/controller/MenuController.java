package com.cs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.common.enums.ClientTypeEnum;
import com.cs.common.utils.EnumUtils;
import com.cs.entity.Menu;
import com.cs.mvc.BaseController;
import com.cs.service.MenuService;

import tk.mybatis.mapper.entity.Example;


@RestController
@RequestMapping(value="/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping(value="/all")
	public List<Menu> findAll(Menu menu) throws Exception{
		Example example = new Example(Menu.class);
		example.setOrderByClause("MENU_TYPE,ORDER_NUMBER ASC");
		example.createCriteria().andEqualTo(menu);
		return menuService.selectByExample(example);
	} 
	
	@GetMapping(value="/get/{id}")
	public Menu findOne(HttpServletRequest request,@PathVariable(name="id")String id) throws Exception{
		return menuService.selectByPrimaryKey(id);
	}
	
	@PostMapping(value="/add")
	public Menu add(Menu menu) throws Exception{
		menuService.insert(menu);
		return menu;
	}
	
	@PutMapping(value="/edit")
	public Menu edit(Menu menu) throws Exception{
		menuService.updateByPrimaryKeySelective(menu);
		return menu;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(String id) throws Exception{
		menuService.deleteByPrimaryKey(id);
		return;
	}
	

}
