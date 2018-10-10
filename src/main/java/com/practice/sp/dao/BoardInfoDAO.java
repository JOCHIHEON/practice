package com.practice.sp.dao;

import java.util.List;

import com.practice.sp.vo.BoardInfo;

public interface BoardInfoDAO {
	
	public List<BoardInfo> getBoardInfoList(BoardInfo bi);
	public int deleteBoardInfo(int binum);
	public int updateBoardInfo(BoardInfo bi);
	public BoardInfo getBoardInfo(int binum);
	public String insertBoardInfo(BoardInfo bi);
}
