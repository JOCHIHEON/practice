package com.practice.sp.dao;

import java.util.List;

import com.practice.sp.vo.Japan;

public interface JapanDAO {
	
	public List<Japan> getJapanList(Japan j);
	public int deleteJapan(int jpnum);
	public int updateJapan(Japan j);
	public Japan getjapan(int jpnum);
	public String insertJapan(Japan jp);
}
