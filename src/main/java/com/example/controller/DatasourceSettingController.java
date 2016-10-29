package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datasource.SchemaType;

@RestController
@RequestMapping("datasource/")
public class DatasourceSettingController {

	@RequestMapping("set")
	public String setDatasource(HttpServletRequest request, @RequestParam("ds") String ds){
		SchemaType type;
		switch(ds){
		case "ds1":
			type = SchemaType.DATA1;
			break;
		case "ds2":
			type = SchemaType.DATA2;
			break;
		default:
			type = SchemaType.DATA1;
		}
		
		request.getSession().setAttribute("datasource", type);
		
		return "OK";
	}
}
