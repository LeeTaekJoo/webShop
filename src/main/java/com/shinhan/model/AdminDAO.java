package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shinhan.util.OracleUtil;
import com.shinhan.vo.AdminVO;

public class AdminDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	// 회원가입
	public int registerAdmin(AdminVO admin) {
		int result = 0;
		String sql = "insert into admins(emails, pass, manager_name) values(?,?,?)";
		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, admin.getEmails());
			st.setString(2, admin.getPass());
			st.setString(3, admin.getManager_name());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, st, conn);			
		}		
		return result;
	}
	
	// 로그인 체크
	public AdminVO loginCheck(String emails, String pass) {
		AdminVO admin = null;
		String sql = "select manager_name from admins where emails =? and pass =? ";

		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, emails);
			st.setString(2, pass);

			rs = st.executeQuery();
			while (rs.next()) {
				admin = new AdminVO(emails, rs.getString(1), pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return admin;
	}
	
	// 이메일 중복체크
	public int dupCheck(String emails) {
		int count = 0;
		String sql = "select count(*) from admins where emails =? ";

		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, emails);
			
			rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return count;

	}
	

}
