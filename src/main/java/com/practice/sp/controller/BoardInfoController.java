package com.practice.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.sp.dao.BoardInfoDAO;
import com.practice.sp.vo.BoardInfo;

@Controller
public class BoardInfoController {
	@Autowired
	private BoardInfoDAO bdao;
	
	@RequestMapping(value="/board",method=RequestMethod.GET)
	public @ResponseBody List<BoardInfo> BoardInfoList(@ModelAttribute BoardInfo bi) {
		return bdao.getBoardInfoList(bi);
	}
	
	@RequestMapping(value="/board/{binum}",method=RequestMethod.GET)
	public @ResponseBody BoardInfo bi(@PathVariable int binum) {
		return bdao.getBoardInfo(binum);
	}
	
	@RequestMapping(value="/board",method=RequestMethod.POST)
	public @ResponseBody String insertBoardInfo(@RequestBody BoardInfo bi) {
		return bdao.insertBoardInfo(bi) + "";
	}
	
	@RequestMapping(value="/board",method=RequestMethod.PUT)
	public @ResponseBody String updateBoardInfo(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bdao.updateBoardInfo(bi) + "";
	}
	
	@RequestMapping(value="/board/{binum}",method=RequestMethod.DELETE)
	public @ResponseBody String deleteBoardInfo(@PathVariable int binum) {
		return bdao.deleteBoardInfo(binum) + "";
	}
}
