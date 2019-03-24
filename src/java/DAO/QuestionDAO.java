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
import java.sql.Timestamp;
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
            ptml.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
//            ptml.setDate(3, question.getCraetedDate());

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

    public static Question getQuestionByID(int id) throws MyException {
        // create list to save Question
        //List<Question> listQuestion = new ArrayList<>();
        // create connection
        Connection conn = DBConnection.createConnection();
        // select statement to take all Question in  Questions table
        String sql = "select * from Questions\n"
                + "where id = ? ";
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            ptml.setInt(1, id);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                return (new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(4003, ex);
        }
        return null;
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
        String sql = "SELECT q.* "
                + "FROM Questions q "
                + "WHERE q.Survey = ?";

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
            throw new MyException(4004, ex);
        }
        return questions;
    }

    public static boolean updateQuestion(Question que) throws MyException {
        // create connection 
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            String sql = "UPDATE Questions \n"
                    + "set Content =? , CreatedDate = ?\n"
                    + "where id = ?";
            //
            ptml = conn.prepareStatement(sql);

            ptml.setString(1, que.getContent());
            ptml.setDate(2, que.getCraetedDate());
            ptml.setInt(3, que.getId());

            int kt = ptml.executeUpdate();
            if (kt != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(4005, ex);
        }
        return false;
    }

    public static boolean deleteQuestion(int id) throws MyException {
        Connection conn = DBConnection.createConnection();
        String sql = "delete from Questions where id = " + id;// cau lenh delete trong sql(chu y: neu truyen thang id kieu nay de bị hacker khai thac loi ịnjection)
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);// ket noi voi sql
            int kt = preparedStatement.executeUpdate();// thuc hien cau lenh va update database(executeUpdate() su dung khi thuc hien cac cau lenh sql dong nhu delete,insert,update)
            if (kt != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            // nem ra thang exception la 1002 neu gap loi
            throw new MyException(4006, ex);
        }
        return false;
    }
}
