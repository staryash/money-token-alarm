package com.yash.moneyalarmv3;

import java.util.Random;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmReceiverActivity extends AppCompatActivity {
    Uri uri;
    Ringtone ringtone;
    int x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_receiver);
        Random rand = new Random();
        x = rand.nextInt(20)+1;
        y = rand.nextInt(20)+1;

        TextView equationBox = (TextView) findViewById(R.id.equationBox);
        equationBox.setText(x+" + "+y+" =");

        uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(this, uri);
        ringtone.play();
    }

    void stopAlarm(View view) {
        EditText answerBox = (EditText)findViewById(R.id.answerBox);
        int z = Integer.parseInt(answerBox.getText().toString());
        if(x+y==z){
            Toast.makeText(this,"wow such maths!",Toast.LENGTH_LONG).show();
            ringtone.stop();
        }
        else{
            TextView alarmLabel = (TextView) findViewById(R.id.alarmLabel);
            alarmLabel.setText("cant stop");
            Toast.makeText(this,"do you even math stupid!",Toast.LENGTH_LONG).show();
        }



    }

    void snoozeAlarm(View view) {
        TextView alarmLabel = (TextView) findViewById(R.id.alarmLabel);
        alarmLabel.setText("cant snooze");
    }
}
