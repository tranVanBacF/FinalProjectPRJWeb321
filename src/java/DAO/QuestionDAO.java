/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import Entity.Question;
import Entity.User;
import Exception.MyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bactv
 */
public class QuestionDAO {

    public static boolean insertQuestion(Question question) throws MyException {
        // create connection 
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            String sql = "insert into Questions values (?,?,?) ";

            //
            ptml = conn.prepareStatement(sql);

            ptml.setInt(1, question.getSurvey());
            ptml.setString(2, question.getContent());
            ptml.setDate(3, question.getCraetedDate());

            int kt = ptml.executeUpdate();
            if (kt != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(4001, ex);
        }
        return false;
    }

    public static List<Question> getQuestion(int surveyID) throws MyException {
        // create list to save Question
        List<Question> listQuestion = new ArrayList<>();
        // create connection
        Connection conn = DBConnection.createConnection();
        // select statement to take all Question in  Questions table
        String sql = "select * from Questions\n"
                + "where Survey = ? ";
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            ptml.setInt(1, surveyID);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                listQuestion.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(4002, ex);
        }
        return listQuestion;
    }
//    // test
//       public static void main(String[] args) {
//          List<Question> listQuestion = getQuestion(1);
//           for (Question question : listQuestion) {
//               System.out.println( question.getId() + "  " +  question.getSurvey()+ " " + question.getContent());
//           }
//           System.out.println("insert ");
//          // System.out.println(insertQuestion(new Question(1, "hai", ConvertStringToDateDAO.StringToSqlDate("2019-22-12"))));
//    }

    public static List<Question> getQuestionsBySurvey(int surveyID) throws MyException {   
        // create list to save Question
        List<Question> questions = new ArrayList<>();
        // create connections
        Connection conn = DBConnection.createConnection();
        //Statement to get all questions of a survey
        String sql = "SELECT q.* " +
            "FROM Questions q, Surveys s " +
            "WHERE q.Survey = s.Id AND s.Id = ?";
        
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            ptml.setInt(1, surveyID);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                questions.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(4003, ex);
        }
        return questions;
    }
}
