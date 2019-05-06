package post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import post.dto.PostDTO;

@Repository
public class PostDAOImpl implements PostDAO{
@Autowired SqlSession sql;

@Override
public boolean insert_post(PostDTO dto) {
	// TODO Auto-generated method stub
	return sql.insert("post.mapper.insert",dto)>0?true:false;
}

@Override
public List<PostDTO> senderlist_post(String sender) {
	// TODO Auto-generated method stub
	return sql.selectList("post.mapper.senderlist",sender);
}

@Override
public List<PostDTO> receiverlist_post(String receiver) {
	// TODO Auto-generated method stub
	return sql.selectList("post.mapper.receiverlist",receiver);
}

@Override
public PostDTO detail_post(int bo_id) {
	// TODO Auto-generated method stub
	return sql.selectOne("post.mapper.detail",bo_id);
}
boolean result=false;
@Override
public boolean delete_post(int po_id, String flag) {
	
	if(flag.equals("0")) {
		result= sql.update("post.mapper.senddelete",po_id)>0?true:false;
	}else if(flag.equals("1")) {
		result= sql.update("post.mapper.recedelete",po_id)>0?true:false;
	}
	System.out.println(result);
	return result;
}

@Override
public boolean delete_all() {
	// TODO Auto-generated method stub
	return sql.delete("post.mapper.alldelete")>0?true:false;
}
}
