package com.yash.moneyalarmv3;

import android.media.Ringtone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AlarmReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_receiver);
    }

    void stopAlarm(View view){
        TextView alarmLabel = (TextView) findViewById(R.id.alarmLabel);
        alarmLabel.setText("cant stop");
    }

    void snoozeAlarm(View view){
        TextView alarmLabel = (TextView) findViewById(R.id.alarmLabel);
        alarmLabel.setText("cant snooze");
    }
}
