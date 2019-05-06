package petsitter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petsitter.dto.PetSitterDTO;

@Repository
public class PetSitterDAOImpl implements PetSitterDAO{
@Autowired SqlSession sql;
	@Override
	public List<PetSitterDTO> list() {
		// TODO Auto-generated method stub
		return sql.selectList("sitter.mapper.list");
	}
	@Override
	public boolean insert_siiter(PetSitterDTO dto) {
		// TODO Auto-generated method stub
		return sql.insert("sitter.mapper.insert",dto)>0?true:false;
	}
	@Override
	public boolean delete_sitter(int si_id) {
		// TODO Auto-generated method stub
		return sql.delete("sitter.mapper.delete",si_id)>0?true:false;
	}

}
