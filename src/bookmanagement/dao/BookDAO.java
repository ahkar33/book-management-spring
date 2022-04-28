package bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import bookmanagement.dto.BookRequestDTO;
import bookmanagement.dto.BookResponseDTO;

@Service("bookDao")
public class BookDAO {

	public static Connection con = null;
	static {
		try {
			con = MyConnection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean checkId(String id) {

		String sql = "select * from book where book_code=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public int insertData(BookRequestDTO dto) {
		String sql = "insert into book values(?, ?, ?, ?)";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getAuthor());
			ps.setDouble(4, dto.getPrice());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int updateData(BookRequestDTO dto) {
		String sql = "update book set title=?, author=?, price=? where book_code=?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getAuthor());
			ps.setDouble(3, dto.getPrice());
			ps.setString(4, dto.getCode());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int deleteData(BookRequestDTO dto) {
		String sql = "delete from book where book_code=?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public BookResponseDTO selectOne(BookRequestDTO dto) {
		String sql = "select * from book where book_code=?";
		BookResponseDTO res = new BookResponseDTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setCode(rs.getString("book_code"));
				res.setTitle(rs.getString("title"));
				res.setAuthor(rs.getString("author"));
				res.setPrice(rs.getDouble("price"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	public ArrayList<BookResponseDTO> selectAll() {
		ArrayList<BookResponseDTO> list = new ArrayList<>();
		String sql = "select * from book";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookResponseDTO res = new BookResponseDTO();
				res.setCode(rs.getString("book_code"));
				res.setTitle(rs.getString("title"));
				res.setAuthor(rs.getString("author"));
				res.setPrice(rs.getDouble("price"));
				list.add(res);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
