package pl.coderslab.mvcjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.mvc.Book;

public class BookDao {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static final String INSERT_BOOK = "INSERT INTO modul3.Book(author,title,isbn)VALUES(?,?,?)";
	private static final String DELETE_BOOK = "DELETE FROM modul3.Book WHERE id = ?";
	private static final String ALL_BOOKS = "SELECT * FROM modul3.Book";

	public boolean insertBook(Book book) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_BOOK);
			preparedStatement.setString(1, book.getAuthor());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getIsbn());
			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBook(Long id) {
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BOOK);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Book> allBook() {
		List<Book> bookList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)) {
			PreparedStatement preparedStatement = conn.prepareStatement(ALL_BOOKS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book2 = new Book();
				book2.setId(resultSet.getLong("id"));
				book2.setAuthor(resultSet.getString("author"));
				book2.setTitle(resultSet.getString("title"));
				book2.setIsbn(resultSet.getString("isbn"));
				bookList.add(book2);
			}

			return bookList;
		} catch (SQLException e) {
			e.printStackTrace();
			return bookList;
		}
	}
}