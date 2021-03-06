package com.hanul.CatHolic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalController {
	private String baseUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc";
	private String serviceKey = "HKy%2FdQCXgbNMSRNmCkolUQDDAfFefYssBdZcWWmTlVqXLynEZL%2FFrSp3iRlDannHvt4wWmzuCUMP3R8u%2FnDK3A%3D%3D";

	private String base(StringBuilder urlBuilder){
		String result = urlBuilder.toString();
		try {
			URL url = new URL(result);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return result;
	}
	

	
	@ResponseBody
	@RequestMapping(value = "/api/abandonment/care",
					produces= "application/text; charset=utf-8")
	public String abandonment_care(@RequestParam String sido, @RequestParam String sigungu) {
		StringBuilder urlBuilder = new StringBuilder(baseUrl+"/shelter");
		try {
			urlBuilder.append("?&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + "20");
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);	
			urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + sido);	
			urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + sigungu);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base(urlBuilder);
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/abandonment/sigungu",
					produces= "application/text; charset=utf-8")
	public String abandonment_sigungu(@RequestParam String sido) {
		StringBuilder urlBuilder = new StringBuilder(baseUrl+"/sigungu");
		try {
			urlBuilder.append("?&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + "20");
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);	
			urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + sido);	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base(urlBuilder);
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/abandonment/sido",
					produces= "application/text; charset=utf-8")
	public String abandonment_sido() {
		StringBuilder urlBuilder = new StringBuilder(baseUrl+"/sido");
		try {
			urlBuilder.append("?&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + "20");
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base(urlBuilder);
	}
	
	@ResponseBody
	@RequestMapping(value = "api/abandonment/list",
					produces= "application/text; charset=utf-8")
	public String abandonment_list(@RequestParam String sido, @RequestParam String sigungu, 
									@RequestParam String shelter) {
		StringBuilder urlBuilder = new StringBuilder(baseUrl+"/abandonmentPublic");
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + sido);
			urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + sigungu);
			urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + shelter);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base(urlBuilder);	
	}
	
	@RequestMapping("/list.ani")
	public String list(Model model) {
		//날짜조회
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)-1;
		int date = cal.get(Calendar.DATE);
		cal.set(year, month, date);
		String startDate = sdf.format(cal.getTime());
		Calendar today = Calendar.getInstance();
		String todayDate = sdf.format(today.getTime());
		
		model.addAttribute("startDate", startDate);
		model.addAttribute("todayDate", todayDate);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("date", date);
			
		return "abandonmentAPI/list";	
	}	
	
}