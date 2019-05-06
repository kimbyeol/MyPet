package board.service;

import java.util.HashMap;
import java.util.List;

import board.dto.BoardCommentDTO;
import board.dto.BoardDTO;
import board.dto.BoardPage;
import member.dto.MemberDTO;

public interface BoardService {
	List<BoardDTO> board_list();
	List<BoardDTO> board_list_class(int classfy);
	String board_insert(BoardDTO dto);
	String board_update(BoardDTO dto);
	String board_delete(int bo_id);
	BoardDTO board_modify(int bo_id);
	void read_board(int bo_id);
	List<BoardDTO> board_list_pop();	
	String board_comment_insert(BoardCommentDTO dto);
	String board_comment_delete(int comm_id);
	String board_comment_update(BoardCommentDTO dto);
	List<BoardCommentDTO> board_comment_list(int p_id);

	//Web
	List<BoardDTO> list();
	BoardDTO select(int bo_id);
	boolean insert(BoardDTO dto);
	boolean update(BoardDTO dto);
	boolean delete(int bo_id);
	void read(int bo_id);
	List<BoardDTO> weblist(int classfy);
	//board comment
	boolean insert(HashMap<String, Object> map);
	List<BoardCommentDTO> comment_list(int p_id);
	BoardCommentDTO comment_select(int bo_id);
	boolean comment_update(BoardCommentDTO dto);
	boolean comment_delete(int comm_id);
}
