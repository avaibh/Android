package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreForTeamA = 0, scoreForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);
    }
    public void addThreeForTeamA(View V){
        displayForTeamA(scoreForTeamA += 3);
    }

    public void addTwoForTeamA(View V){
        displayForTeamA(scoreForTeamA += 2);
    }

    public void addOneForTeamA(View V) {
        displayForTeamA(scoreForTeamA += 1);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View V){
        displayForTeamB(scoreForTeamB += 3);
    }

    public void addTwoForTeamB(View V){
        displayForTeamB(scoreForTeamB += 2);
    }

    public void addOneForTeamB(View V) {
        displayForTeamB(scoreForTeamB += 1);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetBoard(View V) {
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);
    }
}
