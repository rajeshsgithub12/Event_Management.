package com.rajesh.eventmanagement.EventDetails;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rajesh.eventmanagement.Event_Registration_Page;
import com.rajesh.eventmanagement.R;

public class Previous_EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_event_details);



        findViewById(R.id.Registration_Now_Btn).setOnClickListener(v->{
            Intent intent = new Intent(Previous_EventDetails.this, Event_Registration_Page.class);
            intent.putExtra("Previous_Event","Previous_Event");

            startActivity(intent);

        });


    }
}