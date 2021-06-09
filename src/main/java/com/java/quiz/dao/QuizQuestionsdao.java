package com.java.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.java.quiz.model.QuizQuestions;

public class QuizQuestionsdao {
	public int registerQuestions(QuizQuestions quizquestions) throws ClassNotFoundException {
        String INSERT_QUESTIONS = "INSERT INTO " +quizquestions.getQuizName()+
            "  (question, OptA, OptB, OptC, OptD, answer) VALUES " +
            " (?, ?, ?, ?, ?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/quizquestions?useSSL=false", "root", "Writerdillz123@");

            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTIONS)) {
            
            preparedStatement.setString(1, quizquestions.getQuestion());
            preparedStatement.setString(2, quizquestions.getOptA());
            preparedStatement.setString(3, quizquestions.getOptB());
            preparedStatement.setString(4, quizquestions.getOptC());
            preparedStatement.setString(5, quizquestions.getOptD());
            preparedStatement.setString(6, quizquestions.getAnswer());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
