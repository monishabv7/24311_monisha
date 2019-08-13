package com.example.mynotesapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Your Time is up!!!!!", Toast.LENGTH_LONG).show();

        showNotification(context, "ALARM IS RINGING");
    }

    private void showNotification(Context context, String message)
    {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(message)
                .setContentTitle("You have a new Reminder")
                .setContentText(message)
                .addAction(R.mipmap.ic_launcher_round, "Time is up", pendingIntent)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationmanager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        notificationmanager.notify(0, builder.build());
    }
}
