package com.androidapp.akira.nokinbattletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class NormalModeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode_result);
        ArrayList<String> actMenuNameTimesList = (ArrayList<String>)getIntent().getSerializableExtra("resultMenuNumeTimes");

        ArrayAdapter<String> nameTimesList = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, actMenuNameTimesList );

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(nameTimesList);


        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });




        Button top = (Button) findViewById(R.id.top_button);
        top.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Intent のインスタンスを取得する（最初の画面）
                Intent intent = new Intent(NormalModeResultActivity.this, MainActivity.class);

                // NormalModeActivity消す
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // MainActivity を再利用する（onCreate() は呼ばれない）
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                // 遷移先の画面を呼び出す
                startActivity(intent);
            }
        });
    }
}
