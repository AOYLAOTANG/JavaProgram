package Web;

import Service.BookServiceImpl;
import Util.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindBookByIdServlet")
public class FindBookByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String id=request.getParameter("id");//获取request中存储的id信息

        //业务处理
        BookServiceImpl bookService=new BookServiceImpl();
        Book book = bookService.findBookByIdServlet(id);

        //分发转向
        if (book!=null){
            request.setAttribute("book",book);//将书籍信息写到request对象中
            request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);//将书本信息转发到编辑界面
        }
    }
}
