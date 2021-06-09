package com.java.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.java.quiz.model.QuizCreator;

public class QuizCreatordao {

    public int registerquiz(QuizCreator quizcreator) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO quizcreator" +
            "  (quizName, quizMasterName) VALUES " +
            " (?, ?);";
        
        String CREATE_NEW_QUIZ = "CREATE TABLE "+quizcreator.getQuizName()+"("
        		+ " id int NOT NULL AUTO_INCREMENT,"
        		+ " question VARCHAR(100),"
        		+ " OptA VARCHAR(50),"
        		+ " OptB VARCHAR(50),"
        		+ " OptC VARCHAR(50),"
        		+ " OptD VARCHAR(50),"
        		+ " Answer VARCHAR(4),"
        		+ " PRIMARY KEY(id)"
        		+ ");";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/quizquestions?allowPublicKeyRetrieval=true&useSSL=false", "root", "Writerdillz123@");

            //insert into quizmaker table
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
        //	PreparedStatement ps = connection.prepareStatement(CREATE_NEW_QUIZ)) 
        
        	
            preparedStatement.setString(1, quizcreator.getQuizName());
            preparedStatement.setString(2, quizcreator.getQuizMasterName());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
            //creating sql table for each quiz
//            ps.setString(1, quizcreator.getQuizName());
//            System.out.println(ps);
//            result = ps.executeUpdate();
            System.out.println(CREATE_NEW_QUIZ);
            result = connection.createStatement().executeUpdate(CREATE_NEW_QUIZ);

        } catch (SQLException e) {
           
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