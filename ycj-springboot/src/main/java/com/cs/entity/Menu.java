package com.cs.entity;

import java.util.Date;

import javax.persistence.Table;

import com.cs.common.enums.ClientTypeEnum;
import com.cs.common.enums.MenuTypeEnum;
import com.cs.mvc.BaseEntity;

@Table(name = "Y_MENU")
public class Menu extends BaseEntity{
    
	private static final long serialVersionUID = 3699384585693685276L;

    private String name;

    private String icon;

    private Integer orderNumber;

    private String page;

    private MenuTypeEnum menuType;

    private ClientTypeEnum clientType;
    
    private Integer isDefault;
    
    private Date createDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public MenuTypeEnum getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuTypeEnum menuType) {
		this.menuType = menuType;
	}

	public ClientTypeEnum getClientType() {
		return clientType;
	}

	public void setClientType(ClientTypeEnum clientType) {
		this.clientType = clientType;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    

}