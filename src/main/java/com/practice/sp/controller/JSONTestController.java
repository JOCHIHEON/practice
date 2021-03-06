package com.practice.sp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.sp.vo.BoardInfo;
import com.practice.sp.vo.Japan;

@Controller
public class JSONTestController {
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody List<Japan> getTest(@ModelAttribute List<Japan> j, @RequestParam(required=false) String str) {
		System.out.println("str : " + str);
		return j;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public @ResponseBody BoardInfo postTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.PUT)
	public @ResponseBody BoardInfo putTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.DELETE)
	public @ResponseBody BoardInfo deleteTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
	
//	@RequestMapping(value="/test/{str2}",method=RequestMethod.GET)
//	public @ResponseBody String getTest(@RequestParam("a") String str, @PathVariable String str2) {
//		System.out.println("str : " + str);
//		System.out.println("str2 : " + str2);
//		return str + "," + str2;
//	}
}
