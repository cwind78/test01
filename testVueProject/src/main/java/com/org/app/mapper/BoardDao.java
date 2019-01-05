package com.org.app.mapper;

import java.util.List;

import com.org.app.vo.Board;
import com.org.app.vo.Comments;

public interface BoardDao {
	public List<Board> getBoardDataList(Board board) throws Exception;
	public Integer insertBoard(Board board) throws Exception;
	public Integer updateBoard(Board board) throws Exception;
	public Integer updateSort(Board board) throws Exception;
	public Integer insertReply(Board board) throws Exception;
	public List<Comments> getCommentsDataList(Comments comments) throws Exception;
	public Integer insertComments(Comments comments) throws Exception;
	public Integer updateComments(Comments comments) throws Exception;
}
