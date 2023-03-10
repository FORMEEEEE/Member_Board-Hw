package edu.kh.jdbc.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;
import static edu.kh.jdbc.common.JDBCTemplate.*;

public class BoardDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public BoardDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("board-query.xml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public List<Board> selectAllBoard(Connection conn) throws Exception{
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectAllBoard");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				String createDate = rs.getString("CREATE_DT");
				int readCount = rs.getInt("READ_COUNT");
				
			
				
				
			}
		} finally {
			rs.close();
			stmt.close();
		}
		
		return boardList;
	}



	public Board selectBoard(Connection conn, int boardNo) throws Exception{
		return null;
		
	}



	public List<Integer> commentCount(Connection conn) throws Exception{
		return null;
		
	}

}
