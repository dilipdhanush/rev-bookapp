package com.revature.booksweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;// = ConnectionUtil.getJdbcTemplate();

	@PostMapping("/login")
	public String login(@RequestParam("mail") String mail, @RequestParam("password") String password) {
		
		String sql="select password from user where email='"+mail+"'";
		jdbcTemplate.query(sql, (rs,rowNum)->{
			if(password.equals(rs.getString(1))) {
				return "redirect:../home.jsp";
			}
			else{
			return "redirect:../books.jsp";	
			}
			});
		
	return "redirect:../books.jsp";

	}

	@PostMapping("/signup")
	public String signUp(@RequestParam("name") String name,@RequestParam("mail") String mail, @RequestParam("password") String password) {
		String sql = "insert into user (username,email,password) values(?,?,?);";
		Object[] params = { name,mail, password };
		jdbcTemplate.update(sql, params);
	
		return "redirect:../index.jsp";

	}
}
