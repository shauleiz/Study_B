package com.example.study_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    TextView CounterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int counter = extras.getInt("EXTRA01", 0);

            // Get the counter text view and put the counter value in it
            CounterView = findViewById(R.id.textViewSecond);
            CounterView.setText(String.valueOf(counter));
        }
    }
}
