package com.org.app.service;

import javax.servlet.http.HttpServletRequest;

import com.org.app.vo.Board;
import com.org.app.vo.Comments;

public interface BoardService {
	public Integer setBoard(Board board, HttpServletRequest request) throws Exception;
	public Integer setReply(Board board, HttpServletRequest request) throws Exception;
	public Integer setComments(Comments comments, HttpServletRequest request) throws Exception;

}
