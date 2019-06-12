package com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Model;

public class QuestionWrong {
    private String Question_Wrong;
    private String User;
    private String Wrong;

    public QuestionWrong(){
    }

    public QuestionWrong(String question_Wrong, String user, String wrong) {
        Question_Wrong = question_Wrong;
        User = user;
        Wrong = wrong;
    }

    public String getQuestion_Wrong() {
        return Question_Wrong;
    }

    public void setQuestion_Wrong(String question_Wrong) {
        Question_Wrong = question_Wrong;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getWrong() {
        return Wrong;
    }

    public void setWrong(String wrong) {
        Wrong = wrong;
    }
}
