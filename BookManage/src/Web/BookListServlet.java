package Web;

import Service.BookServiceImpl;
import Util.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用业务逻辑
        BookServiceImpl bookService=new BookServiceImpl();
        List<Book> bookList = bookService.findAllBooks();//获取所有书籍

        //跳转页面
        if (bookList!=null){
            request.setAttribute("books",bookList);//把所有书籍放入到request对象中
            request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);//跳转到list.jsp中
        }
    }
}
