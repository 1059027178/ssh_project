package com.qianyang.Operation;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.qianyang.DB.DBmysql;

public class QuerySQL {

	/**
	 * 查询表数据是否存在sql操作
	 * @param sql
	 * @return
	 */
	public int countSql(String sql){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		int countFlag = 0;
		try {
			conn = com.qianyang.DB.DBorale.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println(">>>>>>>>sql："+sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				countFlag = rs.getInt(1);
			}
			if (countFlag > 0) return 1;
			else return 0;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			com.qianyang.DB.DBorale.free(rs, ps, conn);
		}
	}
	/**
	 * updata修改表sql操作
	 * @param sql
	 * @return
	 */
	public int upDataInfoSql(String sql){
		int flag = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = com.qianyang.DB.DBorale.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			com.qianyang.DB.DBorale.free(null, ps, conn);
		}
		return flag;
	}
	/*查询sql所有记录*/
	/**
	 * 查询表记录
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ArrayList DBSelect(String sql) throws Exception {
		Connection conn = DBmysql.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rst = stmt.executeQuery(sql);
		ArrayList list = ResultSetToList(rst);
		rst.close();
		stmt.close();
		conn.close();
		return list;
	}
	private static ArrayList ResultSetToList(ResultSet rs) throws Exception {
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		ArrayList list = new ArrayList();
		Map rowData;
		while (rs.next()) {
			rowData = new HashMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				Object v = rs.getObject(i);

				if (v != null
						&& (v.getClass() == Date.class || v.getClass() == java.sql.Date.class)) {
					Timestamp ts = rs.getTimestamp(i);
					v = new java.util.Date(ts.getTime());
					// v = ts;
				} else if (v != null && v.getClass() == Clob.class) {
					v = clob2String((Clob) v);
				}
				rowData.put(md.getColumnName(i), v);
			}
			list.add(rowData);
		}
		return list;
	}
	private static String clob2String(Clob clob) throws Exception {
		return (clob != null ? clob.getSubString(1, (int) clob.length()) : null);
	}
	/*查询sql所有记录*/
}




