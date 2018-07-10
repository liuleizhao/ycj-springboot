package com.cs.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cs.mvc.mybatis.BaseDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * BaseService泛型基类
 * @author vincent
 *
 * @param <T>
 * @param <PK>
 */
@Transactional
public abstract class BaseServiceSupport<T> implements BaseService<T>{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/** 当前页 */
    protected Integer pageNum = 1;
    /** 每页显示的记录数 */
    protected Integer pageSize = 12;
    
    @Autowired
    protected BaseDao<T> baseDao;
    
    protected  BaseDao<T> getBaseDao() throws Exception{
    	return baseDao;
    }

	@Override
	public List<T> selectAll() throws Exception {
		return baseDao.selectAll();
	}

	@Override
	public List<T> select(T record) throws Exception {
		return baseDao.select(record);
	}
	
	@Override
	public T selectByPrimaryKey(Object id) throws Exception {
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public T selectOne(T record) throws Exception {
		return baseDao.selectOne(record);
	}

	@Override
	public Integer selectCount(T record) throws Exception {
		return baseDao.selectCount(record);
	}

	@Override
	public Integer insert(T record) throws Exception {
		return baseDao.insert(record);
	}

	@Override
	public Integer insertSelective(T record) throws Exception {
		return baseDao.insertSelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object id) throws Exception {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public Integer delete(T record) throws Exception {
		return baseDao.delete(record);
	}

	@Override
	public Integer updateByPrimaryKey(T record) throws Exception {
		return baseDao.updateByPrimaryKey(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(T record) throws Exception {
		return baseDao.updateByPrimaryKeySelective(record);
	}
    
	@Override
	public PageInfo<T> select(T record,Integer pageNum) throws Exception{
		//设置页码
		if(pageNum ==null || pageNum <1){
			pageNum = this.pageNum;
		}
		//设置每页数据量
//		if(pageSize == null || pageSize <1){
//			pageSize = this.pageSize;
//		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = this.select(record);
		PageInfo<T> page = new PageInfo<T>(list);
		return page;
	};
	
	@Override
	public List<T> selectByExample(Object example) throws Exception {
		return baseDao.selectByExample(example);
	}
	
	@Override
	public PageInfo<T> selectByExample(Object example,Integer pageNum) throws Exception {
		//设置页码
		if(pageNum ==null || pageNum <1){
			pageNum = this.pageNum;
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = this.selectByExample(example);
		PageInfo<T> page = new PageInfo<T>(list);
		return page;
	}
    
}
