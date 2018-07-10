package com.cs.mvc;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cs.common.utils.DateUtils;


/**
 * Controller基类
 * 
 * @author vincent
 * 
 */
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 重定向
	 * @param uri
	 * @return
	 */
	protected String redirect(String uri) {
		return "redirect:" + uri;
	}

	/**
	 * 请求转发
	 * @param uri
	 * @return
	 */
	protected String forward(String uri) {
		return "forward:" + uri;
	}

	
	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? DateUtils.formatDateTime((Date)value) : "";
			}
		});
	}

}
