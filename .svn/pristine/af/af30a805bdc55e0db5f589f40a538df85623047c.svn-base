package pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pet.dao.PetDAO;
import pet.dto.PetDTO;

@Service
public class PetServiceImpl implements PetService {
	@Autowired PetDAO dao;
	@Override
	public String insert_pet(PetDTO dto) {
		return dao.insert_pet(dto);
	}

	@Override
	public String update_pet(PetDTO dto) {
		return dao.update_pet(dto);
	}


	@Override
	public List<PetDTO> list_pet(String owner) {
		return dao.list_pet(owner);
	}

	@Override
	public String delete_pet(int id) {
		return dao.delete_pet(id);
	}

	@Override
	public boolean insert_webpet(PetDTO dto) {
		// TODO Auto-generated method stub
		return dao.insert_webpet(dto);
	}
}
