package com.studyjams.s1.sj29.huzhou;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.widget.TextView;

public class WelcomeActivity extends ActionBarActivity {
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        tView = (TextView) findViewById(R.id.tv_time);
        //5s后启动到主界面
        new CountDownTimer(5000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                tView.setText(millisUntilFinished/1000 + "S");

            }

            @Override
            public void onFinish() {
                tView.setText("Go->");
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();
    }
}
