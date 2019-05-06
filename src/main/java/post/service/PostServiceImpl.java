package post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import post.dao.PostDAO;
import post.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {
@Autowired PostDAO dao;

@Override
public boolean insert_post(PostDTO dto) {
	// TODO Auto-generated method stub
	return dao.insert_post(dto);
}

@Override
public List<PostDTO> senderlist_post(String sender) {
	// TODO Auto-generated method stub
	return dao.senderlist_post(sender);
}

@Override
public List<PostDTO> receiverlist_post(String receiver) {
	// TODO Auto-generated method stub
	return dao.receiverlist_post(receiver);
}

@Override
public PostDTO detail_post(int bo_id) {
	// TODO Auto-generated method stub
	return dao.detail_post(bo_id);
}

@Override
public boolean delete_post(int po_id, String flag) {
	// TODO Auto-generated method stub
	return dao.delete_post(po_id, flag);
}

@Override
public boolean delete_all() {
	// TODO Auto-generated method stub
	return dao.delete_all();
}
}
