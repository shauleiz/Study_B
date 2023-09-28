package com.example.study_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// MainActivity is the default visual page of the application
public class MainActivity extends AppCompatActivity {

    int counter =0; // Counter
    TextView CounterView; // Window to show counter
    static final String STATE_COUNT = "currentcountervalue";



    // OnCreate is called everytime the main activity is created
    // It initializes the UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class 'OnCreate' method then display the activity as defined in the XML file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Increment-by-one button
        // Get it from the XML file then define what it does when clicked
        Button Inc_Button = findViewById(R.id.Plus1_button);
        Inc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Increment();
            }
        });

        // If this not the first time this activity was created since the app started
        // then the value of the counter is extracted from the saved instance state
        if (savedInstanceState != null)
            counter = savedInstanceState.getInt(STATE_COUNT);

        // Get the counter text view and put the counter value in it
        CounterView =  findViewById(R.id.textViewCounter);
        CounterView.setText(String.valueOf(counter));
    }


    // Save counter value in instance state
    // This method is called when the activity is destroyed
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current counter state.
        savedInstanceState.putInt(STATE_COUNT, counter);

        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }



    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    // function that increments counter by 1
    // then displays on TextView widget
    public void Increment()
    {
        counter++;
        CounterView.setText(String.valueOf(counter) );
    }


}



