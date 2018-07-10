package com.cs.mvc.mybatis;

import java.util.UUID;

import tk.mybatis.mapper.genid.GenId;

/**
 * @package: com.cs.mvc.mybatis 
 * @Title: UUIdGenId 
 * @Description: 生成UUID
 * @Company: 诚是创新科技
 * @author llz
 * @date 2018年7月6日 下午6:05:17
 */
public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}