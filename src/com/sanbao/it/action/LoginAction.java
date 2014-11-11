package com.sanbao.it.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.ORM.User;
import com.sanbao.it.service.UserService;
import com.sanbao.it.service.impl.UserServiceImpl;


public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String pwd;
	private String msg;

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		
		UserService userservice = new UserServiceImpl();
		User user = userservice.getUser(user_id);
		if (user == null) {
			setMsg("用户不存在");
			return ERROR;
		}

		if (user.getPassword().equals(pwd)) {
			session.setAttribute("user", user);
			return SUCCESS;
		} else {
			setMsg("密码错误");
			return ERROR;
		}

	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
