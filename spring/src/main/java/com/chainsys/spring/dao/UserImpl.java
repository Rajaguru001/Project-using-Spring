package com.chainsys.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.spring.model.UserInfo;

@Repository
public interface UserImpl {
	public void insert(UserInfo u);
	public List<UserInfo> listusers();
	List<UserInfo> searchByName(String name);
	

}
