package Dao;

import Util.Book;
import Util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl {
    /**
     * 从数据库中查找所有的图书
     * @return
     * @throws SQLException
     */
    public List<Book> findAllBooks() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
        List<Book> bookList = queryRunner.query("select * from book", new BeanListHandler<Book>(Book.class));
        return bookList;
    }

    /**
     * 添加书籍信息到数据库中
     * @param book
     * @throws SQLException
     */
    public void addBook(Book book) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("insert into book values(?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription());
    }

    /**
     * 根据书籍id从数据库中获取书籍信息
     * @param id
     * @return 书籍对象
     */
    public Book findBookByIdServlet(String id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
        Book book = queryRunner.query("select * from book where id=?", new BeanHandler<Book>(Book.class), id);
        return book;
    }

    /**
     * 更新书籍信息并写入数据库
     * @param book
     */
    public void updateBook(Book book) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
                book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
    }

    /**
     * 根据id删除数据库中的书籍
     * @param id
     * @throws SQLException
     */
    public void deleteBook(String id) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("delete from book where id=?",id);//通过id删除书籍
    }
}

//interface BookDao{
//
//}