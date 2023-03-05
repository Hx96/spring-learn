package com.hx.dao;

import org.apache.ibatis.annotations.Mapper;

/**
* @author kyle
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-02-18 11:36:50
* @Entity com.hx.dao.TUser
*/
@Mapper
public interface TUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

}
