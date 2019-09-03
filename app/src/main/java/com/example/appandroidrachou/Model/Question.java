package com.example.appandroidrachou.Model;

import java.util.List;

public class Question {

    private String mQuestion;

            public Question(String question) {
                mQuestion = question;
            }

            public String getQuestion() {
                return mQuestion;
            }

            public void setQuestion(String question) {
                mQuestion = question;
            }

    private List<String> mChoiceList;

            public Question(List<String> choiceList) {
                mChoiceList = choiceList;
            }

            public void setChoiceList(List<String> choiceList) {
                mChoiceList = choiceList;
            }
            public List<String> getChoiceList() {
                return mChoiceList;
            }

    private int mAnswerIndex;

            public Question(int answerIndex) {
                mAnswerIndex = answerIndex;
            }

            public int getAnswerIndex() {
                return mAnswerIndex;
            }

            public void setAnswerIndex(int answerIndex) {
                mAnswerIndex = answerIndex;
            }
}
