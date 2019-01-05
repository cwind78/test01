package com.org.app.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.app.mapper.BoardDao;
import com.org.app.service.BoardService;
import com.org.app.vo.Board;
import com.org.app.vo.Comments;
import com.org.app.vo.Result;

@Controller
public class BoardCtrl {
	@Autowired
	BoardDao dao;
	@Autowired
	BoardService service;
	
	@GetMapping("/board")
	public String boardPop(HttpServletRequest request) {
		return "board/board";
	}
	
	/*
	 * mast_id로 글 목록 읽어오기
	 * 
	 */
	@GetMapping("/board/list/{mast_id}")
	@ResponseBody
	public List<Board> getBoardDataList(HttpServletRequest request, @PathVariable("mast_id") String mast_id) throws Exception {
		Board board = new Board();
		board.setMast_id(mast_id);
		System.out.println(mast_id);
		return dao.getBoardDataList(board);
	}
	
	/*
	 * id로 board 단건 읽어오기
	 */
	@GetMapping("/board/one/{id}")
	@ResponseBody
	public List<Board> getBoardData(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		Board board = new Board();
		board.setId(id);
		return dao.getBoardDataList(board);
	}
	
	/*
	 * 새글쓰기(수정하기)
	 */
	@PostMapping("/board/new/")
	@ResponseBody
	public List<Result> setBoard(HttpServletRequest request, @RequestBody Board board) throws Exception {
		Result result = new Result();
		List<Result> list = new ArrayList<Result>();
		result.setResult(String.valueOf(service.setBoard(board, request)));
		list.add(result);
		
		return list;
	}
	
	/*
	 * 답글쓰기
	 */
	@PostMapping("/board/reply/")
	@ResponseBody
	public List<Result> setReply(HttpServletRequest request, @RequestBody Board board) throws Exception {
		Result result = new Result();
		List<Result> list = new ArrayList<Result>();
		result.setResult(String.valueOf(service.setReply(board, request)));
		list.add(result);
		
		return list;
	}
	
	/*
	 * board_id로 코멘트 목록 읽어오기
	 * 
	 */
	@GetMapping("/comments/list/{board_id}")
	@ResponseBody
	public List<Comments> getCommentsDataList(HttpServletRequest request, @PathVariable("board_id") String board_id) throws Exception {
		Comments comments = new Comments();
		comments.setBoard_id(board_id);
		return dao.getCommentsDataList(comments);
	}
	
	/*
	 * id로 comments 단건 읽어오기
	 */
	@GetMapping("/comments/one/{id}")
	@ResponseBody
	public List<Comments> getCommentsData(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		Comments comments = new Comments();
		comments.setId(id);
		return dao.getCommentsDataList(comments);
	}
	
	/*
	 * 새코멘트쓰기(수정하기)
	 */
	@PostMapping("/comments/new/")
	@ResponseBody
	public List<Result> setComments(HttpServletRequest request, @RequestBody Comments comments) throws Exception {
		Result result = new Result();
		List<Result> list = new ArrayList<Result>();
		result.setResult(String.valueOf(service.setComments(comments, request)));
		list.add(result);
		
		return list;
	}
}
