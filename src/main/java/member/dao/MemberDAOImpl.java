package member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.dto.BoardDTO;
import member.dto.MemberDTO;
import pet.dto.PetDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired SqlSession sql;
	
	@Override
	public boolean insert(MemberDTO dto) {
		return sql.insert("imember.mapper.insert",dto)>0?true:false;
	}

	@Override
	public MemberDTO select(MemberDTO dto) {
		return sql.selectOne("imember.mapper.selectone",dto);
	}

	@Override
	public int check(String userid) {
		return sql.selectOne("imember.mapper.check", userid);
	}


	@Override
	public List<MemberDTO> list_member() {
		return sql.selectList("imember.mapper.list");
	}

	@Override
	public int select2(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectOne("imember.mapper.kakaocheck",dto);
	}

	@Override
	public String update(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sql.insert("imember.mapper.update",dto)>0? "true":"false";

	}
	
	//web
	@Override
	public MemberDTO login(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		return sql.selectOne("imember.mapper.login",map);
	}

	@Override
	public MemberDTO check_me(String nickname) {
		// TODO Auto-generated method stub
		return sql.selectOne("imember.mapper.check_me",nickname);
	}

	@Override
	public MemberDTO check_memid(String userid) {
		// TODO Auto-generated method stub
		return sql.selectOne("imember.mapper.check_id",userid);
	}

	@Override
	public String delete_mem(String userid) {
		// TODO Auto-generated method stub
		return sql.delete("imember.mapper.delete_mem",userid)>0?"succ":"fail";
	}

	@Override
	public String update_mem(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sql.update("imember.mapper.update_web",dto)>0?"succ":"fail";
			
	}

	@Override
	public List<BoardDTO> list_userpop(String nickname) {
		// TODO Auto-generated method stub
		return sql.selectList("board.mapper.popuser",nickname);
	}

	@Override
	public List<PetDTO> list_mypet(String owner) {
		// TODO Auto-generated method stub
		return sql.selectList("pet.mapper.all_list",owner);
	}

	
	
	

}
