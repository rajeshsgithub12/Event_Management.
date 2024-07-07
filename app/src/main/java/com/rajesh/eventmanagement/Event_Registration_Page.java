package com.rajesh.eventmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class Event_Registration_Page extends AppCompatActivity {
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button register_btn;
    TextView regis_done_txt;

    EditText GameType, Name, your_position, mobile_number;
    String Running_Event, UpComing_Event, Previous_Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_registation_page);

        FindViewById();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        // sharedPreferences
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // get data from intent
        Intent intent = getIntent();
        UpComing_Event = intent.getStringExtra("UpComing_Event");
        Running_Event = intent.getStringExtra("Running_Event");
        Previous_Event = intent.getStringExtra("Previous_Event");

        // Check if intent extras are not null before using equals
        if ("Running_Event".equals(Running_Event)) {
            handleRegistration("register_complete_running");
        } else if ("Previous_Event".equals(Previous_Event)) {
            handleRegistration("register_complete_previous");
        } else if ("UpComing_Event".equals(UpComing_Event)) {
            handleRegistration("register_complete_upcoming");
        }

        register_btn.setOnClickListener(v -> {
            String game_type = GameType.getText().toString();
            String name = Name.getText().toString();
            String yourPosition = your_position.getText().toString();
            String mobileNumber = mobile_number.getText().toString();

            boolean isValidated = validateData(game_type, name, yourPosition, mobileNumber);

            if (!isValidated) {
                return;
            }

            if ("Running_Event".equals(Running_Event)) {
                completeRegistration("register_complete_running");
            } else if ("Previous_Event".equals(Previous_Event)) {
                completeRegistration("register_complete_previous");
            } else if ("UpComing_Event".equals(UpComing_Event)) {
                completeRegistration("register_complete_upcoming");
            }
        });
    }

    private void handleRegistration(String key) {
        String data_from_event = sharedPreferences.getString(key, "");
        if ("register_complete".equals(data_from_event)) {
            register_btn.setVisibility(View.GONE);
            regis_done_txt.setVisibility(View.VISIBLE);
        }
    }

    private void completeRegistration(String key) {
        Toast.makeText(this, "Registration Completed", Toast.LENGTH_SHORT).show();
        editor.putString(key, "register_complete");
        editor.apply();
        register_btn.setVisibility(View.GONE);
        regis_done_txt.setVisibility(View.VISIBLE);
    }

    boolean validateData(String game_type, String name, String yourPosition, String mobileNumber) {
        if (game_type.isEmpty()) {
            GameType.setError("Please Enter Game Type");
            return false;
        }

        if (name.isEmpty()) {
            Name.setError("Please Enter Name");
            return false;
        }

        if (yourPosition.isEmpty()) {
            your_position.setError("Please Enter Your Position");
            return false;
        }

        if (mobileNumber.isEmpty()) {
            mobile_number.setError("Please Enter Mobile Number");
            return false;
        }

        return true;
    }

    private void FindViewById() {
        toolbar = findViewById(R.id.toolbar);
        register_btn = findViewById(R.id.register_btn);
        regis_done_txt = findViewById(R.id.regis_done_txt);
        mobile_number = findViewById(R.id.mobile_number);
        GameType = findViewById(R.id.GameType);
        Name = findViewById(R.id.Name);
        your_position = findViewById(R.id.your_position);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
