package com.example.appandroidrachou.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appandroidrachou.Model.Question;
import com.example.appandroidrachou.Model.QuestionBank;
import com.example.appandroidrachou.R;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mQuestionTextView;
//les v des vues
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;
//les v du modele
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    //v du score jouer
    private int mScore;
    private int mNumberOfQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //genere toutes la liste des questions
        mQuestionBank = this.genererQuestions();

        //initialisation du SCORE JEU
        mScore = 0;
        mNumberOfQuestion = 5;

        //Widgets (connection des v aux elements de la vue)
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);
        // information type tag additionné au bouton
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);
//enregistrer les boutons comme element du listener
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

//methode appelée qqsoit le bouton appuyé (controle des réponse)
    @Override
    public void onClick(View view) {
        //recupérer l'identifiant du bouton
        int responseIndex = (int)view.getTag();

        //si l'index du bouton (tag) correspond à l'index de la question
        if (responseIndex == mCurrentQuestion.getAnswerIndex()){
            //bonne réponse
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        }else{
            //mauvaise réponse
            Toast.makeText(this, "FAUX", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestion == 0) {
            // No question left, end the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }

    }
    private void endGame(){
        //instanciation d'un objet de la sous classe builder de class boite de dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bravo")
                .setMessage("Score final"+ mScore +"/5")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //termine l'activité courante
                        finish();
                    }
                })
                .create()
                .show();
    }

    //methode pour montrer la question en cours d'appel
    private void displayQuestion(final Question question){
        mQuestionTextView.setText(question.getQuestionText());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    //methode pour générer la liste de question et la garder dans une variable de type QuestionBank
    private QuestionBank genererQuestions() {
        Question question1 = new Question("Quel est l'ancien nom de la ville de Grenoble (avant l'an 300?",
                Arrays.asList("Cularo", "Gratianopolis", "Grenobopolis", "Lugdunum"),
                0);

        Question question2 = new Question("Combien y a t il de quartiers officiellement à grenoble (découpage en secteur)",
                Arrays.asList("4", "6", "7", "9"),
                1);

        Question question3 = new Question("Qui avait il à la pace du parc paul mistral avant sa transformation pour l'exposition universelle?",
                Arrays.asList("un parc, déjà", "une zone de tir (militaire)", "un terrain vague", "des habitations"),
                1);

        Question question4 = new Question("L'expo universelle de grenoble avait quelle thèmatique ?",
                Arrays.asList("les jeux olympiques", "grenoble ville de demain","la houille blanche et le tourisme",  "l'electricité statique"),
                2);

        Question question5 = new Question("En quelle année se déroule l'expo universelle de Grenoble?",
                Arrays.asList("1923", "1915", "1932", "1925"),
                3);

        Question question6 = new Question("Quelle est la surface de Grenoble en km2",
                Arrays.asList("12", "15", "18", "37"),
                2);

        Question question7 = new Question("Quelle est la densité d'habitant sur Grenoble (nombre d'hab/m2)? Pour Paris 20 700, Pour Rouen 5 150, Pour lyon 10 700",
                Arrays.asList("5 200", "7 900", "8 700", "9 400"),
                2);

        Question question8 = new Question("Combien de personnes habitent Grenoble intramuros?",
                Arrays.asList("160 000", "130 000", "180 000", "150 000"),
                0);

        Question question9 = new Question("Quel est le plus vieux quartier de Grenoble?",
                Arrays.asList("les quais st Laurent", "autour de la rue des antiquaires", "l île Verte", "autour de l'église notre dame"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

}
