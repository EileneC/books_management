package com.java.dao;
/**
 * ����Ա��¼��֤
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.java.model.Admin;


public class AdminDao{
	public Admin login(Connection con,Admin admin) throws Exception{//��¼������Ϣ
		Admin resultUser = null;
		String sql = "select * from admin where admin_name=? and admin_password=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,admin.getAdmin_name());//��ָ����������Ϊ���� Java String ֵ
		pstmt.setString(2,admin.getAdmin_password());
		ResultSet rs = pstmt.executeQuery();//�ڴ� PreparedStatement ������ִ�� SQL ��ѯ�������ظò�ѯ���ɵ� ResultSet ����
		if(rs.next()) {
			resultUser = new Admin();
			resultUser.setAdmin_id(rs.getInt("admin_id"));
			resultUser.setAdmin_name(rs.getString("admin_name"));
			resultUser.setAdmin_phone(rs.getString("admin_phone"));
			resultUser.setAdmin_password(rs.getString("admin_password"));
		}
		return resultUser; 
	}
}
