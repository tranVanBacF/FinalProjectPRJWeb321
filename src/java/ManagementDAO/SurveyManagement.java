/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementDAO;

import DAO.SurveyDAO;
import Entity.Survey;
import Exception.MyException;
import java.util.List;

/**
 *
 * @author bactv
 */
public class SurveyManagement {
    public static boolean insertSurvey(Survey survey) throws MyException{
        return SurveyDAO.insertSurvey(survey);
    }
    
    public static List<Survey> getSurveysByUsername(String username) {
        return SurveyDAO.getSurveyByUsername(username);
    }

    public static boolean setStatusBySurveyId(int surveyID, int status) {
        return SurveyDAO.setStatusBySurveyId(surveyID, status);
    }

    public static Survey getSurveyById(int surveyID) {
        return SurveyDAO.getSurveyById(surveyID);
    }

    
}