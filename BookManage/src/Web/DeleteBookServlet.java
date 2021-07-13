package Web;

import Service.BookServiceImpl;
import Util.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String id=request.getParameter("id");//获取要删除书籍的id号

        //业务逻辑
        BookServiceImpl bookService=new BookServiceImpl();
        bookService.deleteBook(id);

        //跳转页面
        request.getRequestDispatcher("/servlet/bookListServlet").forward(request,response);//跳转到书籍显示servlet
    }
}
