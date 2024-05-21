package com.example.exercise7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView2;
    private RatingBar ratingBar;
    private Button clickButton;
    private Button clearButton;
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        ratingBar = findViewById(R.id.ratingBar);
        clickButton = findViewById(R.id.clickButton);
        clearButton = findViewById(R.id.clearButton);
        closeButton = findViewById(R.id.closeButton);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (ratingBar.getRating() >= 3){
                    textView2.setTextColor(Color.GREEN);
                }
                else {
                    textView2.setTextColor(Color.RED);
                }
                textView2.setText("Your rating is: " + rating);
            }
        });


        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Rate: " + ratingBar.getRating(),Toast.LENGTH_SHORT).show();

            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ratingBar.setRating(0);

                textView2.setText("");
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
