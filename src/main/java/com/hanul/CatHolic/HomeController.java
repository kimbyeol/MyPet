package com.hanul.CatHolic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import board.dto.BoardDTO;
import notice.dto.NoticeDTO;
import notice.service.NoticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired NoticeService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		ArrayList<BoardDTO> dto= new ArrayList<BoardDTO>();
		ArrayList<NoticeDTO> nto= new ArrayList<NoticeDTO>();
		nto=(ArrayList<NoticeDTO>) service.fivelist();
		if(nto!=null) {
			  for(int i=0;i<nto.size();i++) {
				  
				  String st2 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(nto.get(i).getWritedate());
					nto.get(i).setDatestring(st2);
			  }
			}
		model.addAttribute("fino",nto);
		dto=(ArrayList<BoardDTO>) service.fiveboard();
		if(dto!=null) {
			  for(int i=0;i<dto.size();i++) {
				  
				  String st2 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(dto.get(i).getWritedate());
					dto.get(i).setDatestring(st2);
			  }
			}
		model.addAttribute("fibo",dto);
		
		
		
		return "home";
	}
}
