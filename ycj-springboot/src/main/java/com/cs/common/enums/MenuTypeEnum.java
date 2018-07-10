package com.cs.common.enums;

import java.util.List;

import com.cs.mvc.mybatis.enumhandler.Identifiable;

/**
 * h5页面首页菜单类型
 * @author Administrator
 *
 */
public enum MenuTypeEnum implements Identifiable<Integer>{
	
    RECOMMEND(1,"推荐菜单"),
    NORMAL(2,"正常菜单");
	
	private int id;

	private String description;
	
	private MenuTypeEnum(int id,String description) {
		this.id = id;
		this.description = description;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

}
