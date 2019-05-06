package com.hanul.CatHolic;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import member.dto.MemberDTO;
import notice.dto.NoticeDTO;
import notice.dto.NoticePage;
import notice.service.NoticeService;


@Controller @SessionAttributes("category")
public class NoticeController {
	@Autowired NoticeService service;
	
	
	@ResponseBody
	@RequestMapping("/minsert.no")
	public String insert(NoticeDTO dto,@RequestBody NoticeDTO vo) {
		dto=vo;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("succ", service.Notice_insert(dto));
		Gson gson= new Gson();
		String RR=gson.toJson(map);
		
		return RR;
	}
	@ResponseBody
	@RequestMapping("/mdelete.no")
	public String delete(@RequestParam String no_id) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("succ", service.Notice_delete(Integer.parseInt(no_id)));
		Gson gson= new Gson();
		String RR=gson.toJson(map);
		return RR;
	}
	
	//안드로이드
	@ResponseBody
	@RequestMapping("/mupdate.no")
	public String update(NoticeDTO dto,@RequestBody NoticeDTO vo) {
		dto=vo;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("succ", service.Notice_update(dto));
		Gson gson= new Gson();
		String RR=gson.toJson(map);
		return RR;
	}
	
	@ResponseBody
	@RequestMapping("/mlist.no")
	public String list() throws ParseException {
		Gson gson = new Gson();
		List<NoticeDTO> no= service.Notice_list();
		if(no.size()==0) {
			no=null;
		}else {
		for(int i=0;i<no.size();i++) {
		Date dateSt = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(no.get(i).getWritedate().toString());
		String st2 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA).format(dateSt);
		
		no.get(i).setWritedate(null);
		no.get(i).setDatestring(st2);
		}
		}
		String VV=gson.toJson(no);
		System.out.println(VV);
		return VV;
	}
	
	@ResponseBody
	@RequestMapping("/mdetail.no")
	public String detail(@RequestParam String no_id) {
		Gson gson= new Gson();
		String VV=gson.toJson(service.Notice_modify(Integer.parseInt(no_id)));
		System.out.println("공지상세보기");
		return VV;
	}
	
	
	
	
	//Web
	@RequestMapping("/detail.no")
	public String detail(Model model,@RequestParam int no_id) {
		model.addAttribute("vo",service.select(no_id));
		//상세화면에서 목록으로 연결시 페이지관련정보를 알고 있어야만 함
				model.addAttribute("page", page);
				model.addAttribute("crlf","\r\n");
		return "notice/detail";
	}
	
	@Autowired private NoticePage page;
	@RequestMapping("/list.no")
	public String list(Model model, @RequestParam (defaultValue="1") int curPage) {
		model.addAttribute("category","no");
		page.setCurPage(curPage);
		model.addAttribute("page", service.list(page));
		//System.out.println("no"+page.getList().get(curPage).getNo());
		return "notice/list";
	}
	
	
		@RequestMapping("/insert.no")
		public String insert(NoticeDTO dto, HttpSession session) {
			dto.setWriter(((MemberDTO)session.getAttribute("login_info")).getNickname());
			service.insert(dto);
			return "redirect:list.no";
		}
		
	@RequestMapping("/new.no")
	public String notice() {
		return "notice/new";
	}
	
	@RequestMapping("/modify.no")
	public String modify(Model model, @RequestParam int no_id) {
		model.addAttribute("vo",service.select(no_id));
		return "notice/modify";
	}
	
	@RequestMapping("/update.no")
	public String update(NoticeDTO dto, HttpSession session){
		//화면에서 변경입력한 정보를 DB에 저장한 후
		service.update(dto);
		//System.out.println("Update"+dto.getNo_id());
		//상세화면으로 연결한다.
		return "redirect:detail.no?no_id="+dto.getNo_id();
	}
	
	@RequestMapping("/delete.no")
	public String delete(@RequestParam int no_id, HttpSession session) {
		
		//선택한 공지글을 DB에서 삭제한 후
		service.delete(no_id);
		//목록화면으로 연결한다.
		return "redirect:list.no";
	}
	
	
	
}
