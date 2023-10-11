package com.example.study_b;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.time.ZonedDateTime;


// MainActivity is an activity - The default visual page of the application
public class MainActivity extends AppCompatActivity {

    TextView CounterView; // Window to show counter

    // ViewModel object of class MyViewModel
    // Holds all UI variables related to this activity
    MyViewModel myViewModel;




    // OnCreate is called everytime the main activity is created
    // Initialization of activity is done here
    @RequiresApi(api = Build.VERSION_CODES.P) // Minimum API level is 'P' (Android 9)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class 'OnCreate' method then display the activity as defined in the XML file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create/acquire the ViewModel object of class myViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Increment-by-one button
        // Get it from the XML file then define what it does when clicked
        Button Inc_Button = findViewById(R.id.Plus1_button);
        Inc_Button.setOnClickListener(v -> myViewModel.IncCount());

        // 'Next' button
        // Click on it and the app is moving to another activity
        Button Next_Button  = findViewById(R.id.skip2activ_button_lable);
        Next_Button.setOnClickListener(v -> openNewActivity());



        // Get the counter text view and put the current counter value in it
        // The counter value is a public member (mld_count) of the ViewModel
        CounterView =  findViewById(R.id.textViewCounter);
        CounterView.setText(String.valueOf(myViewModel.mld_count.getValue()));

        // Define observer for value of counter (myViewModel.mld_count)
        // It attaches this activity (this) as an observer
        myViewModel.mld_count.observe(this, new Observer<Integer>() {
            // If value of myViewModel.mld_count changes then OnChanged is called
            // with  myViewModel.mld_count as parameter (cnt)
            // Then OnChanged updates text in CounterView
            @Override
            public void onChanged(Integer cnt) {
                if (cnt != null) {
                    CounterView.setText(String.valueOf(cnt));
                }
            }
        });

    }

    // Called when button 'Next' is clicked
    // Creates an intent with target activity (SecondActivity)
    // Adds an extra parameter of type "EXTRA01" with value = ewModel.mld_count
    // then start activity
    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("EXTRA01", myViewModel.mld_count.getValue());
        startActivity(intent);
    }

}



