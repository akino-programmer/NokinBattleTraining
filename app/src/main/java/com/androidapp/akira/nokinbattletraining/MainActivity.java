package com.androidapp.akira.nokinbattletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //ツールバー非表示とした
        // ツールバーをアクションバーとしてセット
//        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
//
//        toolbar.setTitle("の〜きん✖︎コロナクエスト！");
//
//        setSupportActionBar(toolbar);

//        toolbar.setNavigationIcon(R.drawable.size.);
//        // アイコンを指定
//        toolbar.setNavigationIcon(R.drawable.coronamonsterlogo);

        Button modeEasy = (Button) findViewById(R.id.easy_mode_button);
        modeEasy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, EasyModeActivity.class);
                startActivity(intent);
            }

        });

        Button modeNormal = (Button) findViewById(R.id.normal_mode_button);
        modeNormal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, NormalModeActivity.class);
                startActivity(intent);
            }

        });

        Button modeHard = (Button) findViewById(R.id.hard_mode_button);
        modeHard.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, HardModeActivity.class);
                startActivity(intent);
            }

        });


    }
}
