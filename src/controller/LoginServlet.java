package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        //get request parameters for userID and password
        String email = request.getParameter("email");
        String pwd = request.getParameter("pw");
        User account = Model.getUser(email, pwd);
       
        if (email.equals("") || pwd.equals(""))
        {
            
        }
        
        else if (account != null)
        {
            Cookie idCookie = new Cookie("email", String.valueOf(account.getEmail()));
            Cookie nameCookie = new Cookie("name", String.valueOf(account.getFullName()));
            //setting cookie to expiry in 30 mins
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", account);
            idCookie.setMaxAge(30 * 60);
            nameCookie.setMaxAge(30 * 60);
            response.addCookie(idCookie);
            response.addCookie(nameCookie);
            response.sendRedirect("index.html");
        }
        
        else
        {
        	response.sendRedirect("login.html?error=pwd");
        	/*
            RequestDispatcher rd
                    = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            //out.println("<font color = red>Either username or password is wrong.</font>");
            rd.include(request, response);
            
            rd.forward(request, response);*/
        }
    }

}
