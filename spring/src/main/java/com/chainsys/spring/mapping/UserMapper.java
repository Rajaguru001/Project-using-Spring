package com.chainsys.spring.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.spring.model.UserInfo;

public class UserMapper implements RowMapper<UserInfo>{

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	  UserInfo userinfo=new UserInfo();
	  int userid=rs.getInt("userid");
	  String username=rs.getString("username");
	  String password=rs.getString("password");
	  String email=rs.getString("email");
	  
	  userinfo.setUserid(userid);
	  userinfo.setUsername(username);
	  userinfo.setPassword(password);
	  userinfo.setEmail(email);
	  
		
		return userinfo;
	}

}
