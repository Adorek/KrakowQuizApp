package com.example.android.krakowquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String nameOfCastle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
    This method is called when the check answers button is clicked
     */
    private int countScore() {

        CheckBox  nobelOne = (CheckBox) findViewById(R.id.nobelOne);
        boolean isNobelOne = nobelOne.isChecked();

        CheckBox  nobelTwo = (CheckBox) findViewById(R.id.nobelTwo);
        boolean isNobelTwo = nobelTwo.isChecked();

        CheckBox  nobelThree = (CheckBox) findViewById(R.id.nobelThree);
        boolean isNobelThree = nobelThree.isChecked();

        CheckBox  riverOne = (CheckBox) findViewById(R.id.riverOne);
        boolean isRiverOne = riverOne.isChecked();

        CheckBox  riverTwo = (CheckBox) findViewById(R.id.riverTwo);
        boolean isRiverTwo = riverTwo.isChecked();

        CheckBox  riverThree = (CheckBox) findViewById(R.id.riverThree);
        boolean isRiverThree = riverThree.isChecked();

        RadioButton citizensOne = (RadioButton) findViewById(R.id.citizensOne);
        boolean isCitizensOne = citizensOne.isChecked();

        RadioButton citizensTwo = (RadioButton) findViewById(R.id.citizensTwo);
        boolean isCitizensTwo = citizensTwo.isChecked();

        RadioButton citizensThree = (RadioButton) findViewById(R.id.citizensThree);
        boolean isCitizensThree = citizensThree.isChecked();

        EditText wawelCastle = (EditText) findViewById(R.id.wawel);
        nameOfCastle = wawelCastle.getText().toString().toLowerCase();

        int score = 0;

        if (isNobelOne && !isNobelTwo &&isNobelThree) {
            score = score + 1;
        }

        if (isCitizensTwo) {
            score = score + 1;
        }
        if(TextUtils.isEmpty(nameOfCastle)){

            Toast.makeText(this, "You did not enter an answer", Toast.LENGTH_SHORT).show();
            score = score;
        }
        if (nameOfCastle.matches("wawel")) {

            score = score + 1;
        }
        if (isRiverOne && isRiverTwo &&!isRiverThree) {
            score = score  + 1;
        }
        return score;
    }

    /**
     * This method calculates the score of the quiz.
     */
    public void showResult(View view) {
        score = countScore();
        display(score);
    }

    /**
     * This method displays the score of the quiz.
     */
    private void display(int score) {

            TextView scoreTextView = (TextView) findViewById(R.id.quiz_score);
            scoreTextView.setText("Congratulations !" + "\nYou've got: " + score + "/4" + "points!");
        }


}
