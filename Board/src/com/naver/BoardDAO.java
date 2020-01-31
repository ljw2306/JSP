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

	public BoardDTO read(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt")+1;
				String author = rs.getString("author");
				
				dto = new BoardDTO(num, author, title, content, writeday, readcnt, 0, 0, 0);
			}
			
			
			increaseReadcnt(num, conn);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return dto;
	}

	private void increaseReadcnt(int num, Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
	}

	public BoardDTO delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		return null;
	}

	public BoardDTO updateui(int num) {

		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt")+1;
				String author = rs.getString("author");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				dto = new BoardDTO(num, author, title, content, writeday, readcnt, repRoot, repStep, repIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	public BoardDTO update(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set title=?, content=? where num=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
		return null;
	}

	public void reply(int orinum, String author, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, title, author, content, repRoot, repStep, repIndent)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			BoardDTO dto = updateui(orinum);
			increaseReplyStep(conn, dto);
			
			int num = createNum(conn);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, content);
			pstmt.setInt(5, dto.getRepRoot());
			pstmt.setInt(6, dto.getRepStep()+1);
			pstmt.setInt(7, dto.getRepIndent()+1);
			
			pstmt.executeUpdate();
			
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
		
	}
	
	
	private void increaseReplyStep(Connection conn, BoardDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "update board set repStep = repStep+1 where repRoot=? and repStep>?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRepRoot());
			pstmt.setInt(2, dto.getRepStep());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
	}
	
	
}
