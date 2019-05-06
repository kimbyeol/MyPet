package pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pet.dto.PetDTO;

@Repository
public class PetDAOImpl implements PetDAO {
	@Autowired SqlSession sql;

	@Override
	public String insert_pet(PetDTO dto) {
		return sql.insert("pet.mapper.insert_pet",dto)>0?"succ":"fail";
	}

	@Override
	public String update_pet(PetDTO dto) {
		return sql.update("pet.mapper.update_pet",dto)>0?"succ":"fail";
	}


	@Override
	public List<PetDTO> list_pet(String owner) {
		return sql.selectList("pet.mapper.list_pet",owner);
	}

	@Override
	public String delete_pet(int id) {
		return sql.delete("pet.mapper.delete_pet",id)>0?"succ":"fail";
	}

	@Override
	public boolean insert_webpet(PetDTO dto) {
		// TODO Auto-generated method stub
		return sql.insert("pet.mapper.insert_web",dto)>0?true:false;
	}


	
}
