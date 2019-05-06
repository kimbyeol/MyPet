package post.dto;

import java.util.Date;

public class PostDTO {
 String sender,receiver,title,content,senderdel,receiverdel;
 int po_id;
 Date writedate;
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getSenderdel() {
	return senderdel;
}
public void setSenderdel(String senderdel) {
	this.senderdel = senderdel;
}
public String getReceiverdel() {
	return receiverdel;
}
public void setReceiverdel(String receiverdel) {
	this.receiverdel = receiverdel;
}
public int getPo_id() {
	return po_id;
}
public void setPo_id(int po_id) {
	this.po_id = po_id;
}
public Date getWritedate() {
	return writedate;
}
public void setWritedate(Date writedate) {
	this.writedate = writedate;
}
 
 
}
