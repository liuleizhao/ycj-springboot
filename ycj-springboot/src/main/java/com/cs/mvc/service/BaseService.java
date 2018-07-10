package com.cs.mvc.service;


import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * Service通用接口
 * @author vincent
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseService <T>{

	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<T> selectAll() throws Exception;
	
	
	/**
	 * 根据实体查询
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public List<T> select(T record) throws Exception;
	
	/**
	 * 根据分页查询
	 * @param pageNum
	 * @return
	 * @throws Exception
	 */
	public PageInfo<T> select(T record,Integer pageNum) throws Exception;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T selectByPrimaryKey(Object id) throws Exception;
	
	/**
	 * 根据属性查询一个
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public T selectOne(T record) throws Exception;
	
	/**
	 * 根据实体查询数量
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer selectCount(T record) throws Exception;
	
	
	public List<T> selectByExample(Object example) throws Exception;
	
	
	public PageInfo<T> selectByExample(Object example,Integer pageNum) throws Exception;
	/**
	 * 插入实体
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer insert(T record) throws Exception;

	/**
	 * 插入实体，为null属性不插入
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer insertSelective(T record) throws Exception;
	
	/**
	 * 根据主键删除
	 * @param 主键
	 * @return
	 * @throws Exception
	 */
	public Integer deleteByPrimaryKey(Object id) throws Exception;
	
	/**
	 * 根据对象属性删除
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer delete(T record) throws Exception;
	
	
	/**
	 * 根据主键更新对象
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer updateByPrimaryKey(T record) throws Exception;

	/**
	 * 根据主键更新对象，为null属性不更新
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer updateByPrimaryKeySelective(T record) throws Exception;

}

