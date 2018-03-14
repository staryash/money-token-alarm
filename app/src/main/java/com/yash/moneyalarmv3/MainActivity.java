package com.yash.moneyalarmv3;

import java.util.Calendar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences alarmPref;
    SharedPreferences.Editor prefEditor;
    TextView tokenNoView;
    //problem hai?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmPref = this.getPreferences(this.MODE_PRIVATE);

        tokenNoView = (TextView)findViewById(R.id.tokenNoDisplay);
        tokenNoView.setText(String.valueOf(getToken()));
    }

    void increaseToken(View view) {
        int tokenNumber = 5 + getToken();
        setToken(tokenNumber);

    }

    void consumeToken(View view) {
        int tokenNumber = getToken() -1;
        setToken(tokenNumber);

    }

    int getToken() {
        return alarmPref.getInt("tokenNo", 5);
    }

    void setToken(int tokenNumber){
        prefEditor = alarmPref.edit();
        prefEditor.putInt("tokenNo",tokenNumber);
        prefEditor.apply();
        TextView tokenNoView = (TextView) findViewById(R.id.tokenNoDisplay);
        tokenNoView.setText(String.valueOf(getToken()));
    }

    void createAlarm(View view){
        //taking time inputs
        EditText hrsInput = (EditText)findViewById(R.id.hrsInput);
        EditText minInput = (EditText)findViewById(R.id.minInput);
        int hrs = Integer.parseInt(hrsInput.getText().toString())%24;
        int min = Integer.parseInt(minInput.getText().toString())%60;
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, hrs);
        alarmTime.set(Calendar.MINUTE, min);

        Toast.makeText(this,"creating alarm for "+hrs+":"+min,Toast.LENGTH_LONG).show();

        //creating alarm below
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), pendingIntent);

    }

    void deleteAlarm(View view){

    }


}
