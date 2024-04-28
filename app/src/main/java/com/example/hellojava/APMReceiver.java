package com.example.hellojava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class APMReceiver extends BroadcastReceiver {

    public int duration;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        String offText = context.getResources().getString(R.string.text_apm_off);
        String onText = context.getResources().getString(R.string.text_apm_on);

        boolean state = intent.getBooleanExtra("state", false);

        if (state == false)
        {
            duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, offText, duration);
            toast.show();
        }
        if (state == true)
        {
            duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, onText, duration);
            toast.show();
        }




    }






}