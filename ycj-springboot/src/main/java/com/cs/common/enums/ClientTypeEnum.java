package com.cs.common.enums;

import java.util.Arrays;
import java.util.List;

import com.cs.common.utils.EnumUtils;
import com.cs.mvc.mybatis.enumhandler.Identifiable;

/**
 * h5页面首页菜单类型
 * @author Administrator
 *
 */
public enum ClientTypeEnum implements Identifiable<Integer>{
    WECHAT(1,"微信"),
    ALIPAY(2,"支付宝");
	/** 顺序 */
	private int id;

	/** 描述 */
	private String description;
	

	private ClientTypeEnum(int index, String description) {
		this.id = index;
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
