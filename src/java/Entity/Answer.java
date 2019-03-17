package Entity;

import java.sql.Date;

/**
 *
 * @author DxG
 */
public class Answer {
    private int id;
    private int question;
    private String answer;
    private String submitter;
    private Date submitDate;
// constructor is used when insert answer to database
    public Answer(int question, String answer, String submitter, Date submitDate) {
        this.question = question;
        this.answer = answer;
        this.submitter = submitter;
        this.submitDate = submitDate;
    }

// constructor is used when get answer from database

    public Answer(int id, int question, String answer, String submitter, Date submitDate) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.submitter = submitter;
        this.submitDate = submitDate;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
