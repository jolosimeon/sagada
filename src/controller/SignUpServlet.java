package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet({ "/SignUpServlet", "/signup" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
        String fname = request.getParameter("first_name");
        String lname = request.getParameter("last_name");
        String cell = request.getParameter("cell_no");
        String address = request.getParameter("address");
        String pwd = request.getParameter("pw");

        Model.signUpUser(email, fname, lname, cell, address, pwd);
        response.sendRedirect("index.html");
    }
}
