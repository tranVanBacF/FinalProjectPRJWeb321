/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import Entity.Survey;
import Entity.Survey;
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
public class SurveyDAO {

    public static boolean insertSurvey(Survey survey) throws MyException {
        // create connection 
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            // insert statement into Surveys table 
            String sql = "insert into Surveys values (?,?,?,?,?,?) ";

            //
            ptml = conn.prepareStatement(sql);

            ptml.setString(1, survey.getName());
            ptml.setString(2, survey.getDescription());
            ptml.setString(3, survey.getUser());
            ptml.setInt(4, survey.getStatus());
            ptml.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
            // ptml.setDate(5, survey.getCreatedDate());
            ptml.setString(6, survey.getLink());

            int kt = ptml.executeUpdate();
            // check if excutre succesful return true
            if (kt != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(3001, ex);
        }
        return false;
    }

    public static List<Survey> getSurveyByUsername(String username) throws MyException {
        // create list to save Survey
        List<Survey> listSurvey = new ArrayList<>();
        // create connection
        Connection conn = DBConnection.createConnection();
        // select statement to take all Survey in  Surveys table
        String sql = "select * from Surveys\n"
                + "where [User] =  ?";
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            ptml.setString(1, username);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                listSurvey.add(new Survey(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(3002, ex);
        }
        return listSurvey;

    }

//    public static void main(String[] args) {
//        // insert
//        System.out.println(insertSurvey(new Survey("hai", "adfsfd", "dungnv", ConvertStringToDateDAO.StringToSqlDate("2019-02-22"), "adsfd")));
//        List<Survey> listSurvey = getSurvey("dungnv");
//        
//        for (Survey survey : listSurvey) {
//            System.out.println(survey);
//            System.out.println(survey.getLink());
//            System.out.println(survey.getUser());
//            System.out.println(survey.getCreatedDate());
//            System.out.println(survey.getStatus());
//
//        }
//    }
    public static boolean setStatusBySurveyId(int surveyID, int status) throws MyException {
        //Create connection to database
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            //Statement to set status by survey id
            String sql = "UPDATE Surveys "
                    + "SET Status = ? "
                    + "WHERE id = ?";
            ptml = conn.prepareStatement(sql);

            ptml.setInt(1, status);
            ptml.setInt(2, surveyID);

            int check = ptml.executeUpdate();
            // check if excutre succesful return true
            if (check != 0) {
                return true;
            }
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(3003, ex);
        }
        return false;
    }

    public static Survey getSurveyById(int surveyID) throws MyException {

        // create connection
        Connection conn = DBConnection.createConnection();

        String getSurveyByIdStatement = "SELECT *\n"
                + "FROM Surveys\n"
                + "WHERE Id = ?";

        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(getSurveyByIdStatement);
            ptml.setInt(1, surveyID);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                return new Survey(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(3004, ex);
        }
        return null;

    }

}
