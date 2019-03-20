/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import Entity.Answer;
import Entity.Answer;
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
public class AnswerDAO {

    public static List<String> getAllSubmittersBySurveyId(int surveyID) throws MyException {
        // create connection
        Connection conn = DBConnection.createConnection();

        String getAllSubmittersBySurveyIdStatement = "SELECT DISTINCT(a.Submitter)\n"
                + "FROM Surveys s, Answers q, Answers a\n"
                + "WHERE s.Id = q.Survey AND a.Answer = q.Id AND s.Id = ?";
        List<String> submitters = new ArrayList<String>();

        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(getAllSubmittersBySurveyIdStatement);
            ptml.setInt(1, surveyID);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                submitters.add(rs.getString(1));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(5001, ex);
        }
        return submitters;
    }

    public static List<Answer> getAnswerOfSubmitterInSurvey(int surveyID, String submitter) throws MyException {
        // create connection
        Connection conn = DBConnection.createConnection();

        String getAnswerOfSubmitterInSurveyStatement = "SELECT a.*\n"
                + "FROM Surveys s, Answers q, Answers a\n"
                + "WHERE s.Id = q.Survey AND q.Id = a.Id AND s.Id = ? AND a.Submitter like ?";
        List<Answer> answers = new ArrayList<Answer>();

        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(getAnswerOfSubmitterInSurveyStatement);
            ptml.setInt(1, surveyID);
            ptml.setString(2, submitter);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                answers.add(new Answer(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(5002, ex);
        }
        return answers;
    }

    public static boolean insertAnswer(Answer answer) throws MyException {
        // create connection 
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            String sql = "insert into Answers values (?,?,?,?) ";

            //
            ptml = conn.prepareStatement(sql);

            ptml.setInt(1, answer.getQuestion());
            ptml.setString(2, answer.getAnswer());
            ptml.setString(3, answer.getSubmitter());
            ptml.setDate(4, answer.getSubmitDate());

            int kt = ptml.executeUpdate();
            if (kt != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(5003, ex);
        }
        return false;
    }

}
