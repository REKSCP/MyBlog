package com.gugu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gugu.dao.LeacotDao;
import com.gugu.pojo.Ggcom;


@WebServlet("/LeacotsServlet")
public class LeacotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LeacotsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("userName");	
		String comcontent = request.getParameter("content");
		System.out.print(comcontent);
		Ggcom com = new Ggcom();
        com.setComContent(comcontent);
        com.setUserName(username);

        LeacotDao add=new LeacotDao();
        add.addLeacot(com);
        
        response.sendRedirect("leacots.jsp");
	}

}
