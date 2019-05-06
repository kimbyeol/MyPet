package calender.dto;

import java.util.Date;

public class CalenderDTO {
	private int s_id;
	private Date s_date;
	private String s_title,s_content,s_name,s_datestring;
	
	
	public String getS_datestring() {
		return s_datestring;
	}
	public void setS_datestring(String s_datestring) {
		this.s_datestring = s_datestring;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public String getS_title() {
		return s_title;
	}
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	
}
