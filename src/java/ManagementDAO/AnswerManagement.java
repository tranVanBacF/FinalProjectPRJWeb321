/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementDAO;

import DAO.AnswerDAO;
import Entity.Answer;
import Exception.MyException;
import java.util.List;

/**
 *
 * @author bactv
 */
public class AnswerManagement {
    public static List<String> getAllSubmittersBySurveyId(int surveyID) throws MyException {
        return AnswerDAO.getAllSubmittersBySurveyId(surveyID);
    }

    public static List<Answer> getAnswerOfSubmitterInSurvey(int surveyID, String submitter) throws MyException {
        return AnswerDAO.getAnswerOfSubmitterInSurvey(surveyID, submitter);
    }
}
