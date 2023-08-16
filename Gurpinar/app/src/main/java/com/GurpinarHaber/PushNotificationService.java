package com.GurpinarHaber;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {

    @SuppressLint("NewApi")
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        String title = message.getNotification().getTitle();
        String text = message.getNotification().getBody();
        String CHANNEL_ID = "MESSAGE";

         NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,"Message Notification", NotificationManager.IMPORTANCE_HIGH);
         getSystemService(NotificationManager.class).createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(this,CHANNEL_ID)
                .setContentTitle(title)
                        .setContentText(text)
                                        .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(1,builder.build());






        super.onMessageReceived(message);

    }
}
