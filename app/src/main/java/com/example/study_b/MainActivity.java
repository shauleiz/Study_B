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


// MainActivity is the default visual page of the application
public class MainActivity extends AppCompatActivity {




    int counter =0; // Counter
    TextView CounterView; // Window to show counter
    static final String STATE_COUNT = "currentcountervalue";

    MyViewModel myViewModel;




    // OnCreate is called everytime the main activity is created
    // It initializes the UI
    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class 'OnCreate' method then display the activity as defined in the XML file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



// TODO: Put in repo

        final ZonedDateTime t_now1 = ZonedDateTime.now();
        int year1 = t_now1.getYear();
        int hour1 = t_now1.getHour();

        ZonedDateTime target = t_now1.plusHours(2).plusMinutes(10);


       // boolean  ca;
        AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
  //      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
  //          ca = alarmMgr.canScheduleExactAlarms();
    //    }

        // Create/acquire the ViewModel object
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Increment-by-one button
        // Get it from the XML file then define what it does when clicked
        Button Inc_Button = findViewById(R.id.Plus1_button);
        Inc_Button.setOnClickListener(v -> myViewModel.IncCount());

        Button Next_Button  = findViewById(R.id.skip2activ_button_lable);
        Next_Button.setOnClickListener(v -> openNewActivity());

        // If this not the first time this activity was created since the app started
        // then the value of the counter is extracted from the saved instance state
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(STATE_COUNT);
            //myViewModel.mld_count.setValue(savedInstanceState.getInt(STATE_COUNT));
        }


        // Get the counter text view and put the counter value in it
        CounterView =  findViewById(R.id.textViewCounter);
        CounterView.setText(String.valueOf(myViewModel.mld_count.getValue()));

        // Define observer to change in count
        myViewModel.mld_count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer cnt) {
                if (cnt != null) {
                    CounterView.setText(String.valueOf(cnt));
                }
            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("EXTRA01", myViewModel.mld_count.getValue());
        startActivity(intent);
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




/*
    // function that increments counter by 1
    // then displays on TextView widget
    public void Increment()
    {

        counter++;
        CounterView.setText(String.valueOf(counter) );


    }
*/



}



