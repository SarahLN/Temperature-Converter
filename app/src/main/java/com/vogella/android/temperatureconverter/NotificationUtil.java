package com.vogella.android.temperatureconverter;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContextWrapper;
import android.graphics.Color;

/**
 * Created by sarah on 2/27/2018.
 */

public class NotificationUtil extends ContextWrapper {
    private NotificationManager mangaer;
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "second";

    public NotificationUtil(Context ctx) {
        super(ctx);

        NotificationChannel chan1 = new NotificationChannel(PRIMARY_CHANNEL, getString(R.string.noti_channel_default), NotificationManager.IMPORTANCE_DEFAULT);
        chan1.setLightColor(Color.BLUE);
        chan1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(chan1);

        NotificationChannel chan2 = new NotificationChannel(SECONDARY_CHANNEL, getString(R.string.noti_channel_second), NotificationManager.IMPORTANCE_HIGH);
        chan2.setLightColor(Color.GREEN);
        chan2.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getManager().createNotificationChannel(chan2);
    }
}

