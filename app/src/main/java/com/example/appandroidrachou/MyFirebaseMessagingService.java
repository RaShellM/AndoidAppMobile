package com.example.appandroidrachou;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CANAL = "MyNotifCanal";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String myMessage = remoteMessage.getNotification().getBody();

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("FireBaseMessage", "From: Rachel, ici c'est notre notification " + myMessage);

        //afficher la novit
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this,CANAL);
        notifBuilder.setContentTitle("nouvelle notification");
        notifBuilder.setContentText(myMessage);
        notifBuilder.setSmallIcon(R.drawable.dog);
        //envoie des notifications
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notifBuilder.build());
    }





}
