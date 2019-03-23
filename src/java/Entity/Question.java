package Entity;

import java.sql.Date;

/**
 *
 * @author DxG
 */
public class Question {
    private int orderDisplay;// dung de hien thi thu tu câu hỏi trên form answer
    private int id;
    private int survey;
    private String content;
    private Date craetedDate;

    public Question() {
    }

    // constructor is used when get question from database
    public Question(int id, int survey, String content, Date craetedDate) {
        this.id = id;
        this.survey = survey;
        this.content = content;
        this.craetedDate = craetedDate;
        // 
        this.orderDisplay=0;
    }
// constructor is used when insert question from database
    public Question(int survey, String content, Date craetedDate) {
        this.id =0;
        this.survey = survey;
        this.content = content;
        this.craetedDate = craetedDate;
        this.orderDisplay=0;
    }
    // constructor is used when update question from database


    public int getSurvey() {
        return survey;
    }

    public void setSurvey(int survey) {
        this.survey = survey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCraetedDate() {
        return craetedDate;
    }

    public void setCraetedDate(Date craetedDate) {
        this.craetedDate = craetedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderDisplay() {
        return orderDisplay;
    }

    public void setOrderDisplay(int orderDisplay) {
        this.orderDisplay = orderDisplay;
    }
    
}
