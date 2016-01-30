package com.MyCode.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyCode.Service.JsonService;
import com.MyCode.Tools.JsonTools;
import com.MyCode.Tools.JsonToolsGetData;
import com.qianyang.Operation.SelectDBdao;
import com.qianyang.model.Users;

/**
 * 用来处理Android客户端发来的json数据
 * 
 * @author Fanff
 * 
 */
public class JsonAction extends HttpServlet {
	private JsonService service;
	private Users users;

	public JsonAction() {
		super();
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		SimpleDateFormat df123 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ymd123 = df123.format(new Date());
		SelectDBdao dao = new SelectDBdao();

		PrintWriter out = response.getWriter();
		System.out.println("++++++++++++++++++++连接成功");
		String jsonString = "";
		String action_flag = request.getParameter("action_flag");
		/*测试*/
		if (action_flag.equals("person")) {
			jsonString = JsonTools.createJsonString("person",
					service.getPerson());
		} else if (action_flag.equals("persons")) {
			jsonString = JsonTools.createJsonString("persons",
					service.getlistPerson());
		} else if (action_flag.equals("liststring")) {
			jsonString = JsonTools.createJsonString("liststring",
					service.getListString());
		} else if (action_flag.equals("listmap")) {
			jsonString = JsonTools.createJsonString("listmap",
					service.getListMaps());
		}
		/***********用户名验证*****/
		else if (action_flag.equals("desideName")) {
			String userName1 = request.getParameter("userName");
			String userName = new String(userName1.getBytes("ISO8859-1"),"UTF-8");
			int flag = dao.desideUserNameOnly(userName);
			if (flag == 1) {// 已被注册
				jsonString = "YES";
				System.out.println("++++++++++用户名为：" + userName + " 已注册！jsonString="+jsonString);
			} else if(flag == 0){
				jsonString = "NOO";
				System.out.println("++++++++++用户名为：" + userName + " 未注册jsonString="+jsonString);
			}
		}
		/******手机号码验证********/
		else if (action_flag.equals("desidePhone")) {
			String userPhone1 = request.getParameter("userPhone");
			String userPhone = new String(userPhone1.getBytes("ISO8859-1"),"UTF-8");
			int flag = dao.desideUserPhoneOnly(userPhone);
			if (flag == 1) {// 已被注册
				jsonString = "YES";
				System.out.println("++++++++++用户手机号为：" + userPhone + " 已注册！jsonString="+jsonString);
			} else if(flag == 0){
				jsonString = "NOO";
				System.out.println("++++++++++用户手机号为：" + userPhone + " 未注册jsonString="+jsonString);
			}
		} 
		/************注册事件*********/
		else if (action_flag.equals("regedit")) {
			String userName1 = request.getParameter("userName");
			String userPaswd1 = request.getParameter("userPwd");
			String userPhone1 = request.getParameter("userPhone");

			String userName  = new String(userName1.getBytes("ISO8859-1") ,"UTF-8");
			String userPaswd = new String(userPaswd1.getBytes("ISO8859-1"),"UTF-8");
			String userPhone = new String(userPhone1.getBytes("ISO8859-1"),"UTF-8");
			System.out.println("<<<<<<<<<<<<用户:" + userName + "|操作："
					+ action_flag + "|上传信息：userPaswd:" + userPaswd
					+ "userPhone:" + userPhone);
			// 保存本地
			int flag = dao.AddLoginUser(userName, userPaswd, userPhone, ymd123);
			if (flag == 1) {
				jsonString = "YES";// 返回成功
				System.out.println("++++++++++用户:" + userName
						+ "|操作：注册|状态：成功|jsonString=" + jsonString);
			} else {
				jsonString = "NOO";// 返回失败
				System.out.println("++++++++++用户:" + userName
						+ "|操作：注册|状态：失败|jsonString=" + jsonString);
			}
		} 
		/*********登陆事件*************/
		else if (action_flag.equals("login")) {
			String loginName1 = request.getParameter("userName");
			String loginPassword1 = request.getParameter("userPwd");
			String loginName = new String(loginName1.getBytes("ISO8859-1"),"UTF-8");
			String loginPassword = new String(loginPassword1.getBytes("ISO8859-1"), "UTF-8");
			// 查询本地
			int flag = dao.QueryByNameLogin(loginName, loginPassword);
			if (flag == 1) {
				jsonString = "YES";// 返回成功
				System.out.println("++++++++++用户：" + loginName + "|操作：登陆|状态：成功！");
			} else {
				int flag1 = dao.QueryByPhoneLogin(loginName, loginPassword);
				if (flag1 == 1) {
					jsonString = "YES";// 返回成功
					System.out.println("++++++++++用户：" + loginName + "|操作：登陆|状态：成功！");
				}else {
					jsonString = "NOO";// 返回失败
					System.out.println("++++++++++用户：" + loginName + "|操作：登陆|状态：失败！");
				}
			}
		}
		/********忘记密码********/
		else if (action_flag.equals("forgetPwd")) {// 
			String userPhone1 = request.getParameter("userPhone");
			String userNewPwd1 = request.getParameter("userNewPwd");
			String userPhone = new String(userPhone1.getBytes("ISO8859-1"));
			String userNewPwd = new String(userNewPwd1.getBytes("ISO8859-1"));
			System.out.println("++++++忘记密码:userPhone:"+userPhone+"|userNewPwd："+userNewPwd);
			int flag = dao.reSetPwd(userPhone, userNewPwd);
			if (flag == 1) {
				jsonString = "YES";// 返回成功
				System.out.println("++++++++++用户手机号：" + userPhone + "|操作：重置密码|状态：成功！");
			} else {
				jsonString = "NOO";// 返回失败
				System.out.println("++++++++++用户手机号：" + userPhone + "|操作：重置密码|状态：失败！");
			}
		}
		/*****登陆后查询数据*******/
		else if(action_flag.equals("queryOrder")){
			
			
		}
		out.println(jsonString);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// 初始化JsonService
		service = new JsonService();
	}
}
