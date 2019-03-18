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
    
    public MyException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
