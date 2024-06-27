package com.chainsys.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.spring.dao.UserDAO;
import com.chainsys.spring.model.UserInfo;

@Controller
public class MyController {
	@Autowired
	UserDAO userdao;

	@RequestMapping("/")
	public String home() {
		return "welcome.jsp";
	}

	@RequestMapping("/hello")
	public String hello() {

		return "hello.jsp";

	}

	@GetMapping("/Register")
	public String register(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("email") String email, Model model) {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername(name);
		userinfo.setPassword(password);
		userinfo.setEmail(email);
		userdao.insert(userinfo);
		List<UserInfo> user = userdao.listusers();

		model.addAttribute("userdetails", user);

		return "UserDetails.jsp";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("deleteid") int userid, Model model) {
		UserDAO.delete(userid);
		List<UserInfo> user = userdao.listusers();
		model.addAttribute("userdetails", user);
		return "UserDetails.jsp";

	}

	@GetMapping("/update")
	public String update(@RequestParam("id") int updateid, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("email") String email, Model model) {
		UserInfo userinfo = new UserInfo();
		userinfo.setUserid(updateid);
		userinfo.setUsername(name);
		userinfo.setPassword(password);
		userinfo.setEmail(email);
		userdao.update(userinfo);
		List<UserInfo> user = userdao.listusers();
		model.addAttribute("userdetails", user);
		return "UserDetails.jsp";

	}
	@GetMapping("/search")
	public String search(@RequestParam("name") String name ,Model model) {	
		 List<UserInfo> users = userdao.searchByName(name);
		    model.addAttribute("userdetails", users);
		    return "UserDetails.jsp";
		
	}
}
