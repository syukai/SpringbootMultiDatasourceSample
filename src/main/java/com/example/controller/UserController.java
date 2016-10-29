package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datasource.SchemaContextHolder;
import com.example.datasource.SchemaType;
import com.example.domain.User;
import com.example.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("findall")
	public List<User> findall(@RequestParam("ds") String ds){
		if(ds.equals("ds1")){
			SchemaContextHolder.setSchemaType(SchemaType.DATA1);
		}else{
			SchemaContextHolder.setSchemaType(SchemaType.DATA2);
		}
		return userService.findAll();
	}
}
