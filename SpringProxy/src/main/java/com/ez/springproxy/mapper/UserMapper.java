package com.ez.springproxy.mapper;

import com.ez.springproxy.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
@Mapper
public interface UserMapper {

	@Select("SELECT id, username, password FROM user WHERE username = #{username} AND password = #{password}")
	User selectUserByUsernamePassword(String username, String password);

}
