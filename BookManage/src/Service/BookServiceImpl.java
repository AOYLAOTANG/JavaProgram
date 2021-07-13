package Service;

import Dao.BookDaoImpl;
import Util.Book;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl {
    BookDaoImpl bookDao=new BookDaoImpl();

    //显示图书列表
    public List<Book> findAllBooks(){
        try {
            return bookDao.findAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加图书
    public void addBook(Book book){
        try {
            bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据书id来查找书
    public Book findBookByIdServlet(String id) {
        Book book=null;
        try {
            book=bookDao.findBookByIdServlet(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    //更新书籍信息
    public void updateBook(Book book) {
        try {
            bookDao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据id删除书籍
    public void deleteBook(String id){
        try {
            bookDao.deleteBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
