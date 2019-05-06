package post.dao;

import java.util.List;

import post.dto.PostDTO;

public interface PostDAO {
	boolean insert_post(PostDTO dto);
	List<PostDTO> senderlist_post(String sender);
	List<PostDTO> receiverlist_post(String receiver);
	PostDTO detail_post(int bo_id);
	boolean delete_post(int po_id,String flag);
	boolean delete_all();
}
