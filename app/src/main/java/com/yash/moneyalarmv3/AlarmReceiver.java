package com.yash.moneyalarmv3;


import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Intent AlarmDisplayIntent = new Intent(context, AlarmReceiverActivity.class);
        context.startActivity(AlarmDisplayIntent);
    }
}
