package com.example.android.myapplication;

import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView =  new TextView(this);
        textView.setText("Wow!");
    textView.setTextColor(Color.RED);

        setContentView(textView);
    }
}
