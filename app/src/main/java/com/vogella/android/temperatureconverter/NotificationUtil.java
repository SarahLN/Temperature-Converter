package com.vogella.android.temperatureconverter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContextWrapper;

/**
 * Created by sarah on 2/27/2018.
 */

public class NotificationUtil extends ContextWrapper {
    private NotificationManager mangaer;
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "second";

    public NotificationUtil(Context ctx) {
        super(ctx);

        //NotificationChannel chan1 = new NotificationChannel(PRIMARY_CHANNEL, getString(R.string.))
    }
}

