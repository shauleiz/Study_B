package com.example.study_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// MainActivity is the default visual page of the application
public class MainActivity extends AppCompatActivity {

    int counter =0; // Counter
    TextView CounterView; // Window to show counter


    // OnCreate is called everytime the main activity is created
    // It initializes the UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class 'OnCreate' method then display the activity as defined in the XML file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Increment-by-one button
        // Get it from the XML file then define what it does when clicked
        Button Inc_Button = (Button) findViewById(R.id.Plus1_button);
        Inc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Increment();
            }
        });

        CounterView = (TextView) findViewById(R.id.textViewCounter);
        CounterView.setText(String.valueOf(counter));
    }


    // function that increments counter by 1
    public void Increment()
    {
        counter++;
        CounterView.setText(String.valueOf(counter) );
    }


}



