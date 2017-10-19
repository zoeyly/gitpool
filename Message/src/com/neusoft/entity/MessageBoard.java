package com.neusoft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言实体类
 * @author Administrator
 *
 */
public class MessageBoard implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2001177368351166724L;
	
	private int id;	//id
	private String nickname;	//昵称
	private String email;	//邮箱
	private String title;	//标题
	private String content;		//内容
	private String ip;	//ip地址
	private Date messagetime;	//留言时间
	
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
