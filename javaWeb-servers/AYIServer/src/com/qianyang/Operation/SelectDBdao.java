package com.qianyang.Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SelectDBdao {
	private QuerySQL querySQL = new QuerySQL();
	/*****************数据存在性验证*******************/
	/**
	 * 通过用户名登陆
	 * @param loginName
	 * @param loginPassword
	 * @return int
	 */
	public int QueryByNameLogin(String loginName,String loginPassword){
		String sql = "select count(*) from CLIENT_USER where 1=1 "
				+ "and USERNAME = '" + loginName + "' and userPwd = '"+loginPassword+"'";
		int flag = querySQL.countSql(sql);
		return flag;
	}
	/**
	 * 通过手机号登陆
	 * @param userphone
	 * @param usePwd
	 * @return
	 */
	public int QueryByPhoneLogin(String loginPhone,String loginPassword){
		String sql = "select count(*) from CLIENT_USER where 1=1 "
				+ "and USERPHONE = '" + loginPhone + "' and userpwd = '"+loginPassword+"'";
		int flag = querySQL.countSql(sql);
		return flag;
	}
	
	/**
	 * 通过手机号修改用户密码
	 * @param userPhone
	 * @param userNewPwd
	 * @return
	 */
	public int reSetPwd(String userPhone,String userNewPwd){
		String sql = "update CLIENT_USER set userpwd = '"+ userNewPwd +"' where userPhone = '"+userPhone+"'";
		int flag = 0;
		flag = querySQL.upDataInfoSql(sql);
		return flag;
	}
	
	/*****************数据存在性验证*******************/
	/*****************唯一性验证**********************/
	/**
	 * 验证手机号唯一性
	 * @param userPhone
	 * @return
	 */
	public int desideUserPhoneOnly(String userPhone){
		String sql = "select count(*) from CLIENT_USER where userPhone = '"+userPhone+"'";
		int flag = querySQL.countSql(sql);
		return flag;
	}
	/**
	 * 验证用户名的唯一性
	 * @param userName
	 * @return
	 */
	public int desideUserNameOnly(String userName){
		int flag = 0;
		String sql = "select count(*) from CLIENT_USER where userName = '"+ userName +"'";
		flag = querySQL.countSql(sql);
		return flag;
	}
	/*****************唯一性验证**********************/
	/**
	 * 用户注册
	 * @param username
	 * @param userPwd
	 * @param userPhone
	 * @param zhucedate
	 * @return 1 =success reutrn 0 =defeat
	 */
	public int AddLoginUser(String userName,String userPwd,String userPhone,String zhucedate){
		String sql = "insert into CLIENT_USER (username,userpwd,pername,percard,sex,geraddress,userphone,zhucedate,kuzzd1,kuzzd2,kuzzd3)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = com.qianyang.DB.DBorale.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPwd);
			ps.setString(3, null);
			ps.setString(4, null);
			ps.setString(5, null);
			ps.setString(6, null);
			ps.setString(7, userPhone);
			ps.setString(8, zhucedate);
			ps.setString(9, null);
			ps.setString(10,null);
			ps.setString(11,null);
//			System.out.println("+++用户注册sql=="+sql);
			ps.executeUpdate();
			ps.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			com.qianyang.DB.DBorale.free(null, ps, conn);
		}
		return 0;
	}
	
}


















