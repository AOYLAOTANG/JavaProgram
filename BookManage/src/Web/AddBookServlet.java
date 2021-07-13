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
import java.util.UUID;

@WebServlet(name = "AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置编码格式
        //获取数据
        Book book=new Book();
        try {
            BeanUtils.populate(book,request.getParameterMap());//从request对象中获取到书籍信息，并封装到book对象中
            book.setId(UUID.randomUUID().toString());//给书籍设置随机ID
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        BookServiceImpl bookService=new BookServiceImpl();
        bookService.addBook(book);

        request.getRequestDispatcher("/servlet/bookListServlet").forward(request,response);//转发到显示的servlet
    }
}
