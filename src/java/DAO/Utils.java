/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bactv
 */
public class Utils {

    public static Date StringToSqlDate(String date) {
        try {
            return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());  
        } catch (ParseException ex) {
            return null;
        }
       

    }
//    public static void main(String[] args) {
//        System.out.println(StringToSqlDate("2019-02-19"));
//    }
}
