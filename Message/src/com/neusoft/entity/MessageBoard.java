package com.neusoft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class MessageBoard implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2001177368351166724L;
	
	private int id;	//id
	private String nickname;	//�ǳ�
	private String email;	//����
	private String title;	//����
	private String content;		//����
	private String ip;	//ip��ַ
	private Date messagetime;	//����ʱ��
	
	public MessageBoard(){
	}
	
	public MessageBoard(String nickname, String email, String title,String content){
		this.nickname = nickname;
		this.email = email;
		this.title = title;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getMessagetime() {
		return messagetime;
	}
	public void setMessagetime(Date messagetime) {
		this.messagetime = messagetime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Override
	public String toString() {
		return "MessageBoard [id=" + id + ", nickname=" + nickname + ", email=" + email + ", title=" + title
				+ ", content=" + content + ", messagetime=" + messagetime + ",ip" + ip + "]";
	}
	 
}
