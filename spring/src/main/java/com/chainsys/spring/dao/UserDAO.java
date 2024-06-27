package com.chainsys.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.spring.mapping.UserMapper;
import com.chainsys.spring.model.UserInfo;

@Repository
public class UserDAO implements UserImpl {
	private static JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(UserInfo u) {
		String insert = "insert into registerform (username,password,email) values(?,?,?)";
		Object[] val = { u.getUsername(), u.getPassword(), u.getEmail() };
		System.out.println(u.getUsername());

		int row = jdbcTemplate.update(insert, val);
		System.out.println("the no of row" + row);

	}

	public List<UserInfo> listusers() {
		String read = "select * from registerform";
		List<UserInfo> listusers = jdbcTemplate.query(read, new UserMapper());
		return listusers;
	}

	public static void delete(int userid) {
		String delete = "delete from registerform where userid=?";

		try {
			jdbcTemplate.update(delete, userid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void update(UserInfo u) {
		String update = "update registerform set username=?,password=?,email=? where userid=?";
		Object[] val = { u.getUsername(), u.getPassword(), u.getEmail(), u.getUserid() };
		jdbcTemplate.update(update, val);

	}

	@Override
	public List<UserInfo> searchByName(String name) {
		String searchQuery = "SELECT * FROM registerform WHERE username LIKE ? OR email LIKE ?";
		Object[]val = {"%" + name + "%", "%" + name + "%"};
		List<UserInfo> users = jdbcTemplate.query(searchQuery, new UserMapper(), val);
		return users;
	}

}
