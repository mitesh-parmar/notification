package com.example.mitesh.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncn=findViewById(R.id.btncn);
        btncn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();


            }
        });
    }


    private void createNotification(){



        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentOn = new Intent(this, NRActivity.class);
        intentOn.setAction("ON");
        intentOn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntentOn = PendingIntent.getBroadcast(this, 0, intentOn, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent intentOff = new Intent(this, NRActivity.class);
        intentOff.setAction("OFF");
        intentOff.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntentOff = PendingIntent.getBroadcast(this, 1, intentOff, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent intenthide = new Intent(this, NRActivity.class);
        intenthide.setAction("hide");
        intenthide.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntenthide = PendingIntent.getBroadcast(this, 2, intenthide, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Action actionon= new Notification.Action.Builder(Icon.createWithResource(this,R.mipmap.ic_launcher),"ON",pendingIntentOn).build();
        Notification.Action actionoff= new Notification.Action.Builder(Icon.createWithResource(this,R.mipmap.ic_launcher),"OFF",pendingIntentOff).build();
        Notification.Action actionhide= new Notification.Action.Builder(Icon.createWithResource(this,R.mipmap.ic_launcher),"HIDE",pendingIntenthide).build();

        Notification notification=new Notification.Builder(this)
                .setContentTitle("to allow sms alert")
                .setContentText("")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(actionon)
                .addAction(actionoff)
                .addAction(actionhide)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notification.flags=Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0,notification);
    }

}
