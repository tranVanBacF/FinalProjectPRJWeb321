/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author TranViet
 */
public class MyException extends Exception {
    
    //Error code start with 1 is DBConnection error
    //Error code start with 2 is UserDAO error
    //Error code start with 3 is SurveyDAO error
    //Error code start with 4 is QuestionDAO error
    //Error code start with 5 is AnswerDAO error
    private final int errorCode;
    private final String message;
    
    public MyException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        switch (errorCode ){
            case 1001 :{
            }
            case 1002 :{
                message = "You can't init connection to database!!!";
                break;
            }
            case 2006 :{
                message = "Can't get information of this user, try again!!!";
                break;
            }
            case 2007 :{
                message = "Can't create this user, try again!!!";
                break;
            }
            case 2008 :{
                message = "Can't get information of this user, try again!!!";
                break;
            }
            case 3001 :{
                message = "Can't insert this survey, try again!!!";
                break;
            }
            case 3002 :{
                message = "Can't get surveys of this user, try again!!!";
                break;
            }
            case 3003 :{
                message = "Can't set status of this survey, try again!!!";
                break;
            }
            case 3004 :{
                message = "Can't get information this survey, try again!!!";
                break;
            }
            case 4001 :{
                message = "Can't insert this question, try again!!!";
                break;
            }
            case 4002 :{
            }
            case 4003 :{
                message = "Can't get questions of the survey, try again!!!";
                break;
            }
            case 5001 :{
                message = "Can't get submitters of survey, try again!!!";
                break;
            }
            case 5002 :{
                message = "Can't get answers of survey, try again!!!";
                break;
            }
            case 5003:{
                message ="Can't insert  answer of submitter, try again!!!";
                break;
            }
            default: 
                message = "There are some problem";
        }
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return message;
    }
    
    
}
