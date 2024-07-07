package com.rajesh.eventmanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rajesh.eventmanagement.SignUP_SignIN.SignUp;

public class Welcome extends AppCompatActivity {

    Button Start;
     Animation Top_anim, Bottom_anim, Left_anim;
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Start = findViewById(R.id.Start);
        Top_anim = AnimationUtils.loadAnimation(this,R.anim.topanim);
        Bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottomanim);
        Left_anim = AnimationUtils.loadAnimation(this,R.anim.leftanim);

        Start.setAnimation(Bottom_anim);


        if (currentUser != null){
            startActivity(new Intent(Welcome.this,MainActivity.class));
            finish();
        }


        Start.setOnClickListener(v->{
            if (currentUser == null){
                startActivity(new Intent(Welcome.this, SignUp.class));
                finish();
            }else{
                startActivity(new Intent(Welcome.this, MainActivity.class));
                finish();
            }


        });


    }
    @Override
    public void onBackPressed() {


        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_warning)
                .setTitle("App Closing!")
                .setMessage("Do you really want exit from App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Exit the app or perform necessary actions
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Dismiss the dialog and continue
                        dialog.dismiss();

                    }
                })
                .show();

    }
}