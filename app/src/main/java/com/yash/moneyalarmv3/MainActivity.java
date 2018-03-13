package com.yash.moneyalarmv3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        tokenNoView.setText(String.valueOf(currentToken()));
    }

    void increaseToken(int inc) {
        int tokenNumber = inc + currentToken();
        setToken(tokenNumber);

    }

    void consumeToken() {
        int tokenNumber = currentToken() -1;
        setToken(tokenNumber);

    }

    int currentToken() {
        return alarmPref.getInt("tokenNo", 5);
    }

    void setToken(int tokenNumber){
        prefEditor = alarmPref.edit();
        prefEditor.putInt("tokenNo",tokenNumber);
        prefEditor.apply();
        TextView tokenNoView = (TextView) findViewById(R.id.tokenNoDisplay);
        tokenNoView.setText(String.valueOf(currentToken()));
    }


}
