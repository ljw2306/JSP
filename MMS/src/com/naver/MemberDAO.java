package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<MemberDTO> list(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member2";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new MemberDTO(id, name, age));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public MemberDTO login(String id, int age) {
		MemberDTO login = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select name from member2 where id=? and age=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, age);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				login = new MemberDTO(id, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return login;
	}

	public MemberDTO read(String id) {
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member2 where id=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, name, age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	public MemberDTO updateui(String id) {
		
		return read(id);
	}

	public MemberDTO update(MemberDTO memberDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member2 set name=?, age=? where id=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setInt(2, memberDTO.getAge());
			pstmt.setString(3, memberDTO.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		return null;
		
	}

	public MemberDTO insert(MemberDTO memberDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member2 (id, name, age) values ?, ?, ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setInt(3, memberDTO.getAge());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		return null;
		
	}

	public MemberDTO delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member2 where id=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		return null;
		
	}

}


























