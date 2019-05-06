package com.hanul.CatHolic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import board.dto.BoardDTO;
import common.service.CommonService;
import member.dto.MemberDTO;
import member.service.MemberService;
import pet.dto.PetDTO;

@SessionAttributes("login_info")
@Controller
public class MemberController {

	@Autowired MemberService service;
	@Autowired CommonService comm;

	//�ȵ���̵�κ� m*****;
	@RequestMapping("/minsert.me")
	public @ResponseBody String insert(MemberDTO dto, @RequestBody JSONObject dd ){
		
		System.out.println(dd.toString());
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		/*Gson json = new Gson();
		JsonObject object=new JsonObject((json.toJson(dd)).toString());*/
		System.out.println(dd.get("nickname").toString());
		dto.setNickname(dd.get("nickname").toString());
		if(dd.get("mail")!=null) {
		dto.setMail(dd.get("mail").toString());}else {
			dto.setMail("");
		}
		if(dd.get("pwd")!=null) {
		dto.setPwd(dd.get("pwd").toString());}else {
			dto.setPwd("");
		}
		dto.setUserid(dd.get("userid").toString());
		dto.setAdmin(dd.get("admin").toString());
		
		if(service.insert(dto)==true) {
			map.put("succ", "success");
			//aa="yes";
		}else{
			map.put("succ","fail");
			//aa="no";
		}
		/*String oo="";
		if(service.insert(dto)==true){
			oo="success";
		}else {
			oo="fail";
		}
		HashMap<String, String> os= new HashMap<String, String>();
		os.put("trueornot",oo);
		JSONObject son = new JSONObject(os);
		System.out.println(son.toString());*/
		/*dto.setUserid(request.getParameter("userid"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setMail(request.getParameter("mail"));
		dto.setAdmin(request.getParameter("admin"));*/
		Gson gson = new Gson();
		String Va=gson.toJson(map);
		
		JSONObject json= new JSONObject(map);
		System.out.println(map.toString());
		System.out.println(json.toString());
		return Va;

	}

	@RequestMapping("/mselect.me")
	public @ResponseBody String select(MemberDTO dto,@RequestBody JSONObject dd){
		/*dto.setUserid(request.getParameter("userid"));
		dto.setPwd(request.getParameter("pwd"));*/
		System.out.println(dd.get("userid").toString());
		dto.setUserid(dd.get("userid").toString());
		dto.setPwd(dd.get("pwd").toString());
		MemberDTO vo= new MemberDTO();
		vo=service.select(dto);
		System.out.println("���ƾӾƾƳ���");
		Gson gson= new Gson();
		String Ra=gson.toJson(vo);
		System.out.println(Ra);
		return Ra;
	}
	@ResponseBody
	@RequestMapping("/mcheck.me")
	public String check(@RequestParam String userid) {
		
		HashMap<String, String> map= new HashMap<String, String>();
		
		if(service.check(userid)>0) {
			map.put("succ", "fail");
		}else {
		map.put("succ", "success");
		}
		Gson gson = new Gson();
		String Ca=gson.toJson(map);
		System.out.println("�ߺ�üũ");
		return Ca;
	}
	@RequestMapping("/mselect2.me" )
	public @ResponseBody String select2(MemberDTO dto,@RequestBody MemberDTO vo){
		/*dto.setUserid(request.getParameter("userid"));
		dto.setPwd(request.getParameter("pwd"));*/
		System.out.println(vo.getPwd().toString());
		MemberDTO bo= new MemberDTO();
		bo=service.select(vo);
		System.out.println(bo.getNickname());
		Gson gson= new Gson();
		String Ra=gson.toJson(bo);
		
		return Ra;
	}
	@ResponseBody
	@RequestMapping("/mmemlist")
	public String list_mem() {
		Gson gson= new Gson();
		String Ma=gson.toJson(service.list_member());
		
		return Ma;
	}

	@ResponseBody
	@RequestMapping("/kakaocheck.me")
	public String kakaocheck(MemberDTO dto,@RequestBody HashMap<String, String> map) {
		dto.setNickname(map.get("nickname").toString());
		dto.setUserid(map.get("userid").toString());
		System.out.println("����� īī���Դϴ�.");
		
HashMap<String, String> map2= new HashMap<String, String>();
		
		if(service.select2(dto)>0) {
			map2.put("succ", "fail");
		}else {
		map.put("succ", "success");
		}
		System.out.println("��������� ����������");
		Gson gson = new Gson();
		String Ca=gson.toJson(map2);
		
		return Ca;
	}
	@RequestMapping("/mmemupdate")
	@ResponseBody
	public String mmemupdate(@RequestPart(required=false) MultipartFile image,String userid,String nickname,String pwd,String mail,HttpSession session) {
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setNickname(nickname);
		dto.setPwd(pwd);
		dto.setMail(mail);
		dto.setProfilepath("");
		System.out.println("�� �������� ����");
		if(image!=null) {
			System.out.println(image.getName());
			System.out.println(image.getSize());
			System.out.println(image.getOriginalFilename());
			if(image.getSize()>0) {
				dto.setProfilepath(comm.upload("board", image, session));
				
			}
		}
		
		return service.update(dto);
	}

	
	
	
	//���κ�
	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestParam String userid,@RequestParam String pwd,Model model) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("pwd", pwd);
		
		
		MemberDTO dto=service.login(map);
		model.addAttribute("login_info",dto);
		
		return dto==null?"false":"true";
	}
	@RequestMapping("/login.ready")
	public String ready() {
		return "member/login";
	}
	@RequestMapping("/join.ready")
	public String ready2() {
		return "member/join";
	}
	@ResponseBody
	@RequestMapping("/logout")
	public void logout(SessionStatus session){
		session.setComplete();
	}
	@RequestMapping("/info_change")
	public String change(){
		
		return "mypage/mypage";
	}
	@ResponseBody
	@RequestMapping("/check.mem")
	public String check_mem(String nickname) {
		
		return service.check_me(nickname)==null?"fail":"succ";
	}
	@ResponseBody
	@RequestMapping("/check.memid")
	public String chck_memid(String userid) {
				
		return service.check_memid(userid)==null?"fail":"succ";
	}
	@ResponseBody
	@RequestMapping(value="/insert.mem", produces="text/html; charset=utf-8")
	public String insert_mem(MemberDTO dto) {
		System.out.println("���Ӹ�");
		String msg = "<script type='text/javascript'>"; 
				
		if( service.insert(dto) ) {
			msg += "alert('ȸ�����ԿϷ�!'); history.go(-1);";
		}else
			msg += "alert('ȸ�����Խ���!');";
		msg += "</script>";
		return msg;
	}
	@RequestMapping("/admin.mem")
	public String admin_mem(Model model) {
		model.addAttribute("admin",service.list_member());
		return "mypage/admin";
	}
	@RequestMapping("/delete_mem")
	public String delete_mem(String userid) {
		
		return service.delete_mem(userid);
	}
	@RequestMapping("/update_mem")
	public String upadate_mem(MemberDTO dto) {
		service.update_mem(dto);
		///////////////////////////////////////
		return "redirect:mypage.mem";
	}
	@RequestMapping("/mypage.mem")
	public String testest(Model model,HttpSession session) {
		String nickname=((MemberDTO)session.getAttribute("login_info")).getNickname();
		ArrayList<BoardDTO> board= (ArrayList<BoardDTO>) service.list_userpop(nickname);
		if(board!=null) {
			for(int i=0;i<board.size();i++) {
				  
				  String st2 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(board.get(i).getWritedate());
					board.get(i).setDatestring(st2);
			  }
		}
		model.addAttribute("mybo",board);
		
		
		
		ArrayList<PetDTO> pet=(ArrayList<PetDTO>) service.list_mypet(nickname);
		if(pet!=null) {
		  for(int i=0;i<pet.size();i++) {
			  
			  String st2 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(pet.get(i).getPet_birth());
				pet.get(i).setDatestring(st2);
		  }
		}
			
			model.addAttribute("petmy",pet);
		System.out.println(service.list_mypet(nickname).size());
		return "mypage/main";
	}
	
	
}
