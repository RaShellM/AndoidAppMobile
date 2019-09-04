package com.example.appandroidrachou.Model;

import java.util.List;

public class Question {
//les variables
    private String mQuestionText;
    private List<String> mChoiceList;
    private int mAnswerIndex;
//le constructeur
    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestionText = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }
//get et set de v Question
    public String getQuestionText() {
        return mQuestionText;
    }
    public void setQuestionText(String questionText) {
        mQuestionText = questionText;
    }

    //set et get de la v ChoiceList
    public void setChoiceList(List<String> choiceList) { mChoiceList = choiceList; }
    public List<String> getChoiceList() {
                return mChoiceList;
            }
//get et set de v AnswerIndex
    public int getAnswerIndex() {
                return mAnswerIndex;
            }
    public void setAnswerIndex(int answerIndex) {
        if (answerIndex<0 || answerIndex >= mChoiceList.size()){
            throw new IllegalArgumentException("Answer index is out of bound");
        }
                mAnswerIndex = answerIndex;
            }
}
