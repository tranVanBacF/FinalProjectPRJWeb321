/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bactv
 */
public class ConvertStringToDateDAO {

    public static Date StringToSqlDate(String date) {
        try {
            return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        } catch (ParseException ex) {
            return null;
        }

    }
     public static java.util.Date  StringToSqlDate1(String date) {
        try {
            return new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        } catch (ParseException ex) {
            return null;
        }

    }

//    public static Date StringToSqlDate2() {
//        try {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            java.util.Date date1 = new java.util.Date();
//            //  System.out.println(dateFormat.format(date1)); //2016/11/16 12:08:43
//            String date = dateFormat.format(date1);
//            return new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date).getTime());
//        } catch (ParseException ex) {
//            return null;
//        }
//
//    }
//public static void main(String[] args) {
//        System.out.println( new Timestamp( new java.util.Date().getTime()));
//    }
}
