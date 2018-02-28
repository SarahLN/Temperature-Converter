package com.vogella.android.temperatureconverter;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

/**
 * Created by sarah on 2/27/2018.
 */

public class NotificationUtil extends ContextWrapper {
    private NotificationManager mangaer;
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "second";

    /**
     * Registers notification channels, which can be used later by individual notifications.
     *
     * @param ctx The application context
     */
    public NotificationUtil(Context ctx) {
        super(ctx);

        NotificationChannel chan1 = new NotificationChannel(PRIMARY_CHANNEL, getString(R.string.noti_channel_default), NotificationManager.IMPORTANCE_DEFAULT);
        chan1.setLightColor(Color.BLUE);
        chan1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getMangaer().createNotificationChannel(chan1);

        NotificationChannel chan2 = new NotificationChannel(SECONDARY_CHANNEL, getString(R.string.noti_channel_second), NotificationManager.IMPORTANCE_HIGH);
        chan2.setLightColor(Color.GREEN);
        chan2.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getMangaer().createNotificationChannel(chan2);
    }

    /**
     * Get a notification of type 1
     *
     * Provide the builder rather than the notification it's self as useful for making notification
     * changes.
     *
     * @param title the title of the notification
     * @param body the body text for the notification
     * @return the builder as it keeps a reference to the notification (since API 24)
     */
    public Notification.Builder getNotification1(String title, String body) {
        return new Notification.Builder(getApplicationContext(), PRIMARY_CHANNEL).setContentTitle(title).setContentText(body).setSmallIcon(getSmallIcon()).setAutoCancel(true);
    }

    /**
     * Build notification for secondary channel.
     *
     * @param title Title for notification.
     * @param body Message for notification.
     * @return A Notification.Builder configured with the selected channel and details
     */
    public Notification.Builder getNotification2(String title, String body) {
        return new Notification.Builder(getApplicationContext(), SECONDARY_CHANNEL).setContentTitle(title).setContentText(body).setSmallIcon(getSmallIcon()).setAutoCancel(true);
    }

    public void notify(int id, Notification.Builder notification) {
        getMangaer().notify(id, notification.build());
    }

    /**
     * Get the small icon for this app
     *
     * @return The small icon resource id
     */
    private int getSmallIcon() {
        return android.R.drawable.stat_notify_chat;
    }

    private NotificationManager getMangaer() {
        if (self.manager == null) {
            self.manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return self.manager;
    }
}

