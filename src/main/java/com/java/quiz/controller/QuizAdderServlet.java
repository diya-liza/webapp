package com.java.quiz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.quiz.dao.QuizCreatordao;
import com.java.quiz.model.QuizCreator;

/**
 * Servlet implementation class QuizAdderServlet
 */
@WebServlet("/register")
public class QuizAdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private QuizCreatordao quizcredao = new QuizCreatordao ();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizAdderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String quizname = request.getParameter("quizName");
	        String quizmastername = request.getParameter("quizMasterName");
	        
	        
	        
	       QuizCreator qc = new QuizCreator();
	       qc.setQuizName(quizname);
	       qc.setQuizMasterName(quizmastername);
	       
	       try {
	    	   quizcredao.registerquiz(qc);
	    	   
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       String destination = "quizregistered.jsp";
	       RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
	       request.setAttribute("quizname", quizname);
	       requestDispatcher.forward(request, response);
	       
	       
	}

}
