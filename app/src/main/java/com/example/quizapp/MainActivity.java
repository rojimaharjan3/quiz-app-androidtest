package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button yes , no ;
    TextView quizQuestion;
    String [] questions = {"java is introduced in 1900" , "print(123) is correct syntax to print in java" , "java has interfaces" , " Java does not support multiple inheritanc?" , "The value of a string variable can be surrounded by single quotes","In Java, it is possible to inherit attributes and methods from one class to another"};
    //question length = 6
    Boolean [] answers ={false , false , true, true , false , true};
    int index = 0; //0,1,2,3,4,5
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        quizQuestion = findViewById(R.id.quiz_question);
        quizQuestion.setText(questions[index]);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to check if array is out of bound or not : not out of bound then enter 'if' loop otherwise 'else' part execute huncha
                if (index <= questions.length - 1) {
                    if (answers[index]) {
                        score++;
                    }

                    //to go to next question
                    index++;

                    //need to check again cause index increase bhayesii aba out of bound huney chances cha
                    if (index <= questions.length - 1) {
                        quizQuestion.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is : " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(MainActivity.this, "restart app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    if(!answers[index]){
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {


                        quizQuestion.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is : " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "restart app to play again", Toast.LENGTH_SHORT).show();
                }

                }

        });


    }
}