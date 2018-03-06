package com.example.mitesh.notifications;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NRActivity extends BroadcastReceiver {

    protected boolean alert;

    @Override
    public void onReceive(Context context, Intent intent) {

       if(intent.getAction().equalsIgnoreCase("on")) {
           alert=true;
           Toast.makeText(context, "on", Toast.LENGTH_SHORT).show();

       }
       else if(intent.getAction().equalsIgnoreCase("off"))
       {
           alert=false;
           Toast.makeText(context, "off", Toast.LENGTH_SHORT).show();
       }
       else if(intent.getAction().equals("hide"))
       {
           NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
           notificationManager.cancel(0);
       }

    }
}
