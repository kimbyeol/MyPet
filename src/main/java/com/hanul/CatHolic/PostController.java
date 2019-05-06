package com.hanul.CatHolic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import post.dto.PostDTO;
import post.service.PostService;

@Controller
public class PostController {
	@Autowired PostService service;
	Gson gson= new Gson();
 @RequestMapping("/list.post")
 public String list(Model model,@RequestParam String nickname) {
	 model.addAttribute("nickname",nickname);
	 return "post/postmain";
 }
 @RequestMapping("/postinsert")
 public String move(Model model,@RequestParam(required=false) String receiver) {
	 model.addAttribute("receiver",receiver);
	 return "post/postinsert";
 }
 
 @RequestMapping(value="/insert.post")
// , produces="application/json; charset=utf-8"
 public String insert(PostDTO dto) {
	 service.insert_post(dto);
	 return "redirect:list.post?nickname="+dto.getSender();
 }
 @ResponseBody
 @RequestMapping(value="/senderlist.post", produces="application/json; charset=utf-8")
 public String slist(@RequestParam String sender) {
	 String VV=gson.toJson(service.senderlist_post(sender));
	 System.out.println("sender");
	 return VV;
 }
 @ResponseBody
 @RequestMapping(value="/receiverlist.post", produces="application/json; charset=utf-8")
 public String relist(@RequestParam String receiver) {
	 String VV= gson.toJson(service.receiverlist_post(receiver));
	 System.out.println("receiver");
	 return VV;
 }
 @RequestMapping("/post.detail")
 public String detail(Model model,@RequestParam String po_id,@RequestParam String flag) {
	 model.addAttribute("flag",flag);
	 model.addAttribute("dto",service.detail_post(Integer.parseInt(po_id)));
	 model.addAttribute("crlf","\r\n");
	 return "post/postdetail"; 
 }
 @RequestMapping("/delete.post")
 public String delete(@RequestParam String po_id,@RequestParam String flag,@RequestParam String nickname) {
	 service.delete_post(Integer.parseInt(po_id), flag);
	 return "redirect:list.post?nickname="+nickname;
 }
 @ResponseBody
 @RequestMapping("/Allpostdelete.post")
 public void Alldelete() {
	 service.delete_all();
 }
}
