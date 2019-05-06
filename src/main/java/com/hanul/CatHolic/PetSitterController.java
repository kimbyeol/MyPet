package com.hanul.CatHolic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import petsitter.dto.PetSitterDTO;
import petsitter.service.PetSitterService;

@Controller
public class PetSitterController {
@Autowired PetSitterService service;
	
	@RequestMapping("/main.sitter")
	public String listsit(Model model){
		
		return "map/petsitter";
		
	}
	@RequestMapping("/insert.petsitter")
	public String insert() {
		return "";
	}
	
	@RequestMapping("/delete.petsitter")
	public String delete() {
		return "";
	}
	@ResponseBody
	@RequestMapping("/list.petsitter")
	public String  list(){
		System.out.println(service.list().size());
		Gson gson= new Gson();
		String VV = gson.toJson(service.list());
		return VV; 
	}
	@RequestMapping("/insert.petsiiter")
	public String insert_sitter(PetSitterDTO dto) {
		service.insert_siiter(dto);
		System.out.println(dto.getContent());
		return "redirect:main.sitter";
	}
	@ResponseBody
	@RequestMapping("/delete.sitter")
	public  String delete_sitter(@RequestParam String si_id) {
		boolean f=service.delete_sitter(Integer.parseInt(si_id));
		return f==true?"true":"false";
	}
}
