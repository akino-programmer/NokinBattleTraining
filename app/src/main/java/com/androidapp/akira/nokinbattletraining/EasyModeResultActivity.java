package com.androidapp.akira.nokinbattletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class EasyModeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode_result);


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
                Intent intent = new Intent(EasyModeResultActivity.this, MainActivity.class);

                // EasyModeActivity消す
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // MainActivity を再利用する（onCreate() は呼ばれない）
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                // 遷移先の画面を呼び出す
                startActivity(intent);
        }
        });



        Twitter twitter = new TwitterFactory().getInstance();
           //Twitterオブジェクト作成

        twitter.setOAuthConsumer("consumer key","consumer secret");
           //Twitterオブジェクトにアプリケーションのconsumer keyとconsumer secretをセットする

        AccessToken accessToken = new AccessToken(
                        "Access token", // 自分のAccess token
                        "Access token key"); // 自分のAccess token secret

        twitter.setOAuthAccessToken(accessToken);
           //自分のアクセストークンを作成し、Twitterオブジェクトにセットする。

        User user = twitter.verifyCredentials();
          //Userオブジェクトを作成

        System.out.println(user.getId());//自分のアカウントのIDの取得（数字のID）

        System.out.println(user.getName());//自分のアカウントの名前を取得

        System.out.println(user.getScreenName());//自分のアカウントのUserNameを取得（アルファベットのみの名前）

        System.out.println(user.getLocation());//自分のアカウントのプロフィールの場所を取得

        System.out.println(user.getDescription());//自分のアカウントのプロフィールの説明を取得

        System.out.println(user.getProfileImageURL());//自分のアカウントのプロフィール画像のURLを取得

        System.out.println(user.getURL());//自分のアカウントのプロフィールのURLを取得する

        System.out.println(user.isProtected());//自分のアカウントに鍵がついてるか取得する

        System.out.println(user.getFollowersCount());//自分のアカウントのフォロワー数を取得する

        System.out.println(user.getFriendsCount());//自分のアカウントのフォロー数を取得する

        System.out.println(user.getCreatedAt());//自分のアカウントの登録日を取得する

        System.out.println(user.getFavouritesCount());//自分のアカウントのお気に入り数を取得する

        System.out.println(user.getProfileBannerURL());//自分のアカウントのバナー画像を取得する

        System.out.println(user.getStatusesCount()); //呟きの数を取得

        System.out.println(user.getListedCount());//追加されているリストの数を取得する

        System.exit(0);







    }
}
