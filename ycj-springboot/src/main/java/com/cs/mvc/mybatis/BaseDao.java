package com.cs.mvc.mybatis;


import tk.mybatis.mapper.common.Mapper;

/**
 * 继承自己的MyMapper
 *
 * @author liuzh_3nofxnp
 * @since 2015-09-06 21:53
 */
//public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
//
//}

@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseDao<T> extends Mapper<T> {

}
