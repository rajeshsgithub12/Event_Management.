package com.rajesh.eventmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rajesh.eventmanagement.EventDetails.Previous_EventDetails;
import com.rajesh.eventmanagement.EventDetails.Running_EventDetails;
import com.rajesh.eventmanagement.EventDetails.UpComing_EventDetails;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.details_runningEvent_btn).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, Running_EventDetails.class);
            startActivity(intent);

        });



        findViewById(R.id.details_runningEvent_btn).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, UpComing_EventDetails.class);
            startActivity(intent);

        });


        findViewById(R.id.details_PreviousEvent_btn).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, Previous_EventDetails.class);
            startActivity(intent);

        });



    }

}