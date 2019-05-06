package member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BoardDTO;
import member.dao.MemberDAO;
import member.dto.MemberDTO;
import pet.dto.PetDTO;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDAO dao;

	@Override
	public boolean insert(MemberDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public MemberDTO select(MemberDTO dto) {
		return dao.select(dto);
	}

	@Override
	public int check(String userid) {
		return dao.check(userid);
	}

	@Override
	public List<MemberDTO> list_member() {
		return dao.list_member();
	}

	@Override
	public int select2(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.select2(dto);
	}
	@Override
	public String update(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}
	

	//À¥ºÎºÐ
	@Override
	public MemberDTO login(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		return dao.login(map);
	}

	@Override
	public MemberDTO check_me(String nickname) {
		// TODO Auto-generated method stub
		return dao.check_me(nickname);
	}

	@Override
	public MemberDTO check_memid(String userid) {
		// TODO Auto-generated method stub
		return dao.check_memid(userid);
	}

	@Override
	public String delete_mem(String userid) {
		// TODO Auto-generated method stub
		return dao.delete_mem(userid);
	}

	@Override
	public String update_mem(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.update_mem(dto);
	}

	@Override
	public List<BoardDTO> list_userpop(String nickname) {
		// TODO Auto-generated method stub
		return dao.list_userpop(nickname);
	}

	@Override
	public List<PetDTO> list_mypet(String nickname) {
		// TODO Auto-generated method stub
		return dao.list_mypet(nickname);
	}


}
