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

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardDTO insert(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, author, title, content, repRoot, repStep, repIndent) values(?,?,?,?,?,0,0)";
		
		try {
			conn = dataFactory.getConnection();
			int num = createNum(conn);
			
			
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, num);
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		return null;
	
	}

	private int createNum(Connection conn) {
		int num = 1;
		
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1)+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		return num;
	}
	
	
	public List<BoardDTO> list(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select num, title, author, to_char(writeday, 'yyyy/mm/dd') writeday,"
				+ " readcnt, repRoot, repStep, repIndent"
				+ " from board order by repRoot desc, repStep asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String writeday = rs.getString(4);
				int readcnt = rs.getInt(5);
				int repRoot = rs.getInt(6);
				int repStep = rs.getInt(7);
				int repIndent = rs.getInt(8);
				
				list.add(new BoardDTO(num, author, title, null,
						writeday, readcnt, repRoot, repStep, repIndent));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	
	
	
	
	

}
