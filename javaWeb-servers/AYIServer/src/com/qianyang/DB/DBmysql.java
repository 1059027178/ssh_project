package com.qianyang.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBmysql {

	private static String url = "jdbc:mysql://localhost:3306/dashulai?useUnicode=true&characterEncoding=utf-8"; // 本地环境
	private static String username = "dsl"; 
	private static String password = "dsl"; 

	private DBmysql() {

	}
	static {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("加载驱动成功!");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败!");
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void free(ResultSet rs, PreparedStatement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
