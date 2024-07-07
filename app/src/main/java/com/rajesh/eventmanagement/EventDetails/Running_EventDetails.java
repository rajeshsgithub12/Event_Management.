package com.rajesh.eventmanagement.EventDetails;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rajesh.eventmanagement.Event_Registration_Page;
import com.rajesh.eventmanagement.R;

public class Running_EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_event_details);


        findViewById(R.id.Registration_Now_Btn).setOnClickListener(v->{
            Intent intent = new Intent(Running_EventDetails.this, Event_Registration_Page.class);
            intent.putExtra("Running_Event","Running_Event");

            startActivity(intent);

        });


    }
}