/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
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
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author bactv
 */
public class UserDAO {

    public static List<User> getUser() throws MyException {
        // create list to save users
        List<User> listUser = new ArrayList<>();
        // create connection
        Connection conn = DBConnection.createConnection();
        // select statement to take all users in  users table
        String sql = "select * from Users ";
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();
            while (rs.next()) {// check if rs has element
                listUser.add(new User(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(2006, ex);
        }
        return listUser;
    }

    public static boolean insertUser(User user) throws MyException {
        // create connection
        Connection conn = DBConnection.createConnection();
        try {
            PreparedStatement ptml = null;
            // insert statement to Users table
            String sql = "insert into Users values (?,?,?,?,?,?) ";

            //
            ptml = conn.prepareStatement(sql);

            ptml.setString(1, user.getName());
            ptml.setString(2, user.getEmail());
            ptml.setDate(3, user.getBirthday());
            ptml.setDate(4, user.getRegistrationDate());
            ptml.setString(5, user.getUsername());
            ptml.setString(6, user.getPassword());

            int kt = ptml.executeUpdate();
            // check if insert successfully return true
            if (kt != 0) {
                return true;
            }
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(2007, ex);
        }
        return false;
    }

    public static User getOneUser(String userName) throws MyException {
        // create list to save users

        // create connection
        Connection conn = DBConnection.createConnection();
        // select statement to take all users in  users table
        String sql = "select * from Users "
                + " where userName=?";
        PreparedStatement ptml;
        try {
            ptml = conn.prepareStatement(sql);
            ptml.setString(1, userName);

            // user ResultSet Object to save all rows after select
            ResultSet rs = ptml.executeQuery();

            while (rs.next()) {// check if rs has element
                return new User(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6));
            }

            rs.close();
            // close connection
            conn.close();
        } catch (SQLException ex) {
            throw new MyException(2008, ex);
        }
        return null;
    }

    // test
//    public static void main(String[] args) {
//        List<User> listUser = UserDAO.getUser();
//        for (User user : listUser) {
//            System.out.println(user.getName());
//        }
//        User user = new User("dung", "daung@f", ConvertStringToDateDAO.StringToSqlDate("2019-02-12"), ConvertStringToDateDAO.StringToSqlDate("2019-02-12"), "dungnv", "dungnv");
//        System.out.println(UserDAO.insertUser(new User("dung", "daung@f", ConvertStringToDateDAO.StringToSqlDate("2019-02-12"), ConvertStringToDateDAO.StringToSqlDate("2019-02-12"), "dungnv", "dungnv")));
//    }
}
