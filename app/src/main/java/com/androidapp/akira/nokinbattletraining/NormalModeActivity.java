package com.androidapp.akira.nokinbattletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NormalModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);




        final ArrayList<Integer> remainingHpList = new ArrayList<>();
        final ArrayList<String>  actMenuNameList = new ArrayList<>();
        final Random random = new Random();
        final Button resultButton = (Button) findViewById(R.id.result_button);


        Button start = (Button) findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                TextView maximumHp = (TextView) findViewById(R.id.maximum_hp);
                TextView remainingHp = (TextView) findViewById(R.id.remaining_hp);
                Button startButton = (Button) findViewById(R.id.start_button);



                TextView FirstTimes = (TextView) findViewById(R.id.numberOfTimes);



                if (maximumHp.getText().equals("-")) {
                    Random random = new Random();
                    int randomHp;
                    randomHp = random.nextInt(30)+ 40;

//                    maximumHp.setText("/" + randomHp);
                    maximumHp.setText(String.valueOf(randomHp));

                    remainingHp.setText(String.valueOf(randomHp));


                } else {
                    int remainingsecondHp = Integer.valueOf(remainingHp.getText().toString());

                    int randomSecondHp = remainingsecondHp - remainingHpList.get(remainingHpList.size() - 1);

//                     randomSecondHp[0] = Integer.valueOf(FirstTimes.getText().toString());


                    //HP0の処理
                    if (randomSecondHp <= 0){

                        final int finalHp = 0;

                        remainingHp.setText(String.valueOf(finalHp));

                        startButton.setText("クリア！");

                        //スタートボタンが使用できなくなる
                        startButton.setEnabled(false);

                        //結果へボタンが使用可能に
                        resultButton.setEnabled(true);



                    } else {//Hp0以上の処理
                        remainingHp.setText(String.valueOf(randomSecondHp));
                    }

                }





                TextView FirstMenu = (TextView) findViewById(R.id.menu_name);


                if (Integer.valueOf(remainingHp.getText().toString()) == 0){
                    FirstMenu.setText("YOU");
                    FirstTimes.setText("WIN");

                } else {
                    //メニューの設定
//                    TextView FirstMenu = (TextView) findViewById(R.id.menu_name);

                    String[] menuName = new String[4];

                    menuName[0] = "腕立て伏せ";
                    menuName[1] = "腹筋";
                    menuName[2] = "スクワット";
                    menuName[3] = "懸垂";

                    int randomFirstMenuName = random.nextInt(4);

                    FirstMenu.setText(menuName[randomFirstMenuName]);

                    actMenuNameList.add(menuName[randomFirstMenuName]);


                    //メニュー回数の設定
                    final int randomFirstTimes = random.nextInt(10)+ 10;

                    FirstTimes.setText(String.valueOf(randomFirstTimes));


                    remainingHpList.add(randomFirstTimes);
                }
            }

//            }//0以下の時戻る
        });





        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });





        //結果へボタンが通常使用不可
        resultButton.setEnabled(false);
        resultButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(NormalModeActivity.this, NormalModeResultActivity.class);


                ArrayList<String> actMenuNameTimesList = new ArrayList<>();

                for(int i=0; i<actMenuNameList.size(); i++){


                    actMenuNameTimesList.add((i + 1) + "." + actMenuNameList.get(i) + "：" + remainingHpList.get(i) + "回");

                    System.out.println(actMenuNameList.get(i) + remainingHpList.get(i));

                }

                intent.putExtra("resultMenuNumeTimes", actMenuNameTimesList);


                startActivity(intent);
            }

        });
    }
}
