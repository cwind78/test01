package com.org.app.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.mapper.BoardDao;
import com.org.app.vo.Board;
import com.org.app.vo.Comments;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	public Integer setBoard(Board board, HttpServletRequest request) throws Exception {
		Integer return_value = -1;
		HttpSession session = request.getSession();

		if (board.getId() != null && "".equals(board.getId())) {
			board.setUpdate_id(session.getAttribute("USER_ID").toString());
			return_value = dao.updateBoard(board);
		} else {
			board.setInsert_id(session.getAttribute("USER_ID").toString());
			return_value = dao.insertBoard(board);
		}
		
		return return_value;
	}
	
	public Integer setReply(Board board, HttpServletRequest request) throws Exception {
		Integer return_value = -1;
		Board origin_board = dao.getBoardDataList(board).get(0);
		board.setGroup_id(origin_board.getGroup_id());
		board.setSort(origin_board.getSort());
		board.setLv(origin_board.getLv());
		
		if (dao.updateSort(board) > 0) {
			return_value = dao.insertReply(board);
		}
		
		return return_value;
	}
	
	public Integer setComments(Comments comments, HttpServletRequest request) throws Exception {
		Integer return_value = -1;
		HttpSession session = request.getSession();

		if (comments.getId() != null && "".equals(comments.getId())) {
			comments.setUpdate_id(session.getAttribute("USER_ID").toString());
			return_value = dao.updateComments(comments);
		} else {
			comments.setInsert_id(session.getAttribute("USER_ID").toString());
			return_value = dao.insertComments(comments);
		}
		
		return return_value;
	}
}
