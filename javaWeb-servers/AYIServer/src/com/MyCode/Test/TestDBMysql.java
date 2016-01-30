package com.MyCode.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.qianyang.DB.DBmysql;

public class TestDBMysql {
	public static void main(String[] args) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select count(*) from dsl_orders";
		String flag = null;
		try {
			connection = DBmysql.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				flag = rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
		
	}
}
