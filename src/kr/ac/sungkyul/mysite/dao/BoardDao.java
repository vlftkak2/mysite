package kr.ac.sungkyul.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.mysite.vo.guestbookVo;

public class BoardDao {

	private Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("error : " + e);
		}
		return conn;
	}
	
	public boolean delete(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count=0;
		try {
			conn=getConnection();
		
			String sql="delete from boards where no=? ";
			pstmt=conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setLong(1, vo.getNo());
			
			
			// 5. sql 실행
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("연결 오류 : " + e);
		} finally {
			try {

				if (conn != null) {
					conn.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return (count==1);
	}

	public BoardVo get(Long userno) {

		BoardVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getConnection();

			String sql = "select title,content from boards where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, userno);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString(1);
				String content = rs.getString(2);

				vo = new BoardVo();
				vo.setTitle(title);
				vo.setContent(content);

			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		}

		return vo;

	}

	public List<BoardVo> getList() {

		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			stmt = conn.createStatement();
			String sql = "select b.no"
					+ ",b.title"
					+ ",(a.FIRST_NAME || ' ' ||a.LAST_NAME) name"
					+ ",b.VIEW_COUNT,to_char(b.REG_DATE,'yyyy-mm-dd hh:mm:ss') from emaillist a, BOARDS"
					+ " b where a.NO=b.USER_NO order by b.GROUP_NO desc,b.ORDER_NO";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				Integer count = rs.getInt(4);
				String date = rs.getString(5);

				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setName(name);
				vo.setCount(count);
				vo.setDate(date);

				list.add(vo);

			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return list;

	}

	public void update(BoardVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			String sql = null;

			sql = "update boards set title=?, content=? where no=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {

			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
	}

}
