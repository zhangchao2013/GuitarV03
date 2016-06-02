package cumt.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumt.dao.GuitarDao;
import cumt.pojo.Guitar;

public class GuitarServlet extends HttpServlet {
	private GuitarDao guitar=new GuitarDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String str=request.getParameter("pageNo");
		List<Guitar> list=guitar.search(str);
		request.setAttribute("str",str);//作用域
		request.setAttribute("list",list);//作用域
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
