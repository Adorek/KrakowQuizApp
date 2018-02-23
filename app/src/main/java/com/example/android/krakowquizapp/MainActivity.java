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
    private CheckBox nobelOne;
    private CheckBox nobelTwo;
    private CheckBox nobelThree;
    private CheckBox riverOne;
    private CheckBox riverTwo;
    private CheckBox riverThree;
    private RadioButton citizensTwo;
    private EditText wawelCastle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nobelOne = findViewById(R.id.nobelOne);
        nobelTwo = findViewById(R.id.nobelTwo);
        nobelThree = findViewById(R.id.nobelThree);
        riverOne = findViewById(R.id.riverOne);
        riverTwo = findViewById(R.id.riverTwo);
        riverThree = findViewById(R.id.riverThree);
        citizensTwo = findViewById(R.id.citizensTwo);
        wawelCastle = findViewById(R.id.wawel);
    }

    /**
    This method is called when the check answers button is clicked
     */
    private int countScore() {

        boolean isNobelOne = nobelOne.isChecked();
        boolean isNobelTwo = nobelTwo.isChecked();
        boolean isNobelThree = nobelThree.isChecked();
        boolean isRiverOne = riverOne.isChecked();
        boolean isRiverTwo = riverTwo.isChecked();
        boolean isRiverThree = riverThree.isChecked();
        boolean isCitizensTwo = citizensTwo.isChecked();
        nameOfCastle = wawelCastle.getText().toString().toLowerCase();

        int score = 0;

        if (isNobelOne && !isNobelTwo &&isNobelThree) {
            score = score + 1;
        }
        if (isCitizensTwo) {
            score = score + 1;
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
     * This method checks if EditText is not empty and displays the results of the quiz.
     */
    private void display(int score) {

        if(TextUtils.isEmpty(nameOfCastle)){

            Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();

        }

        else

        Toast.makeText(this, "Congratulations !" + "\nYou've got: " + score + "/4" + "points!", Toast.LENGTH_SHORT).show();
    }

}
