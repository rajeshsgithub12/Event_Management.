package com.rajesh.eventmanagement.SignUP_SignIN;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utility {

    public static void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("SimpleDateFormat")
    public  static String timestampToString(long timestamp){

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm      dd/MM/yyyy", Locale.getDefault());

        // Create a Date object from the timestamp
        Date date = new Date(timestamp);

        // Format the Date object to a string
        return sdf.format(date);

    }

}

