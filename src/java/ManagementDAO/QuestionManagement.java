/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementDAO;

import DAO.QuestionDAO;
import DAO.SurveyDAO;
import Entity.Answer;
import Entity.Question;
import Exception.MyException;
import java.util.List;

/**
 *
 * @author bactv
 */
public class QuestionManagement {

    public static boolean insertQuestion(Question question) throws MyException {
        return QuestionDAO.insertQuestion(question);
    }

    public static List<Question> getQuestion(int surveyID) throws MyException {
        return QuestionDAO.getQuestion(surveyID);
    }

    public static List<Question> getQuestionsBySurvey(int surveyID) throws MyException {
        return QuestionDAO.getQuestionsBySurvey(surveyID);
    }

    public static boolean updateQuestion(Question question) throws MyException {
        return QuestionDAO.updateQuestion(question);
    }

    public static Question getQuestionByID(int id) throws MyException {
        return QuestionDAO.getQuestionByID(id);
    }
    public static boolean deleteQuestion(int id) throws MyException {
        return QuestionDAO.deleteQuestion(id);
    }

}
