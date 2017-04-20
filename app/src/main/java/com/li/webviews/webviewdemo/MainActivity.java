package com.li.webviews.webviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn01;
    private Button btn02;
    private Button btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnClick();
    }


    private void initView() {

        btn01 = (Button) findViewById(R.id.test_01);
        btn02 = (Button) findViewById(R.id.test_02);
        btnProgress = (Button) findViewById(R.id.progressBtn);
    }

    private void setOnClick() {

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Web1Activity.class);
                startActivity(intent);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Web2Activity.class);
                startActivity(intent);
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProgressWebActivity.class);
                startActivity(intent);
            }
        });

    }
}
