package com.example.appandroidrachou.Model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

//constructeur qui produit un shuffle de la collection, et que instancie le nextQuestionIndex.
   public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        Collections.shuffle(mQuestionList);
        mNextQuestionIndex=0;
    }

    //pour aller chercher une nouvelle question (boucle sur les questions)
    public Question getQuestion(){
        if(mNextQuestionIndex == mQuestionList.size()){
            mNextQuestionIndex=0;
        }
        return mQuestionList.get(mNextQuestionIndex++);
    }

//getter and setter
    public List<Question> getQuesionList() {
        return mQuestionList;
    }
    public void setQuesionList(List<Question> quesionList) {
        mQuestionList = quesionList;
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }
    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }
}
