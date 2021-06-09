package com.java.quiz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.quiz.dao.QuizQuestionsdao;
import com.java.quiz.model.QuizQuestions;

/**
 * Servlet implementation class QuizQuestionsServlet
 */
@WebServlet("/addQuizQuestions")
public class QuizQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private QuizQuestionsdao quizquestionsdao = new QuizQuestionsdao();

	    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizQuestionsServlet() {
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
		String quizname = request.getParameter("quizname");
		System.out.println(quizname);
		String question = request.getParameter("question");
        String OptA = request.getParameter("OptA");
        System.out.println(OptA);
        String OptB = request.getParameter("OptB");
        String OptC = request.getParameter("OptC");
        String OptD = request.getParameter("OptD");
        String answer = request.getParameter("answer");

        QuizQuestions quizquestions = new QuizQuestions();
        quizquestions.setQuizName(quizname);
        quizquestions.setQuestion(question);
        quizquestions.setOptA(OptA);
        quizquestions.setOptB(OptB);
        quizquestions.setOptC(OptC);
        quizquestions.setOptD(OptD);
        quizquestions.setAnswer(answer);

        try {
        	quizquestionsdao.registerQuestions(quizquestions);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("quizname", quizname);
        request.getRequestDispatcher("/quizregistered.jsp").forward(request, response);
        
    }
	}


