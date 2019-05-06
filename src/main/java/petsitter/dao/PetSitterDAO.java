package petsitter.dao;

import java.util.List;

import petsitter.dto.PetSitterDTO;

public interface PetSitterDAO {
	List<PetSitterDTO> list();
	boolean insert_siiter(PetSitterDTO dto);
	boolean delete_sitter(int si_id);
}
