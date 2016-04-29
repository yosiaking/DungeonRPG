package com.example.sample.dungeonrpg;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import Gameplay.Explore.GoDungeon001;
import Object.Character.CreatureType.Human;
import Object.Character.Player.Hero;
import Object.Dungeon.DungeonBase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //スクロールビュー
    private ScrollView scrollView;

    //メッセージarray
    private ArrayList<TextView> messageList;

    //レイアウト変数
    private LinearLayout storyTellingLog;

    //ダンジョン生成
    private GoDungeon001 dungeon;
    private DungeonBase dungeon001;

    //バトルフラグ
    private static boolean battleFlag;

    //ヒーロー生成
    private Hero h;

    //ボタン変数
    private Button goButton;
    private Button attackButton;
    private Button magicButton;
    private Button recoverButton;
    private Button escapeButton;

    //メニュー変数
    private TextView menuName;
    private TextView menuHp;
    private TextView menuMp;
    private TextView menuJewel;
    private TextView menuFloor;
    private TextView menuDistance;


    //Context変数
    private static Context context;

    //レイアウトパラメータ
    private final ViewGroup.LayoutParams WCWC = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private final ViewGroup.LayoutParams MPMP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private final ViewGroup.LayoutParams WCMP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private final ViewGroup.LayoutParams MPWC = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //バトルフラグ
        battleFlag = false;

        //物語表示板
        storyTellingLog = (LinearLayout) findViewById(R.id.storyTellingLog);

        //Context取得
        context = getApplicationContext();

        //ボタン
        goButton = (Button) findViewById(R.id.go);
        attackButton = (Button) findViewById(R.id.attack);
        magicButton = (Button) findViewById(R.id.magic);
        recoverButton = (Button) findViewById(R.id.recover);
        escapeButton = (Button) findViewById(R.id.escape);

        //クリックリスナー
        goButton.setOnClickListener(this);
        attackButton.setOnClickListener(this);
        magicButton.setOnClickListener(this);
        recoverButton.setOnClickListener(this);
        escapeButton.setOnClickListener(this);

        //メニューカウント取得
        menuName = (TextView) findViewById(R.id.heroName);
        menuHp = (TextView) findViewById(R.id.heroHp);
        menuMp = (TextView) findViewById(R.id.heroMp);
        menuJewel = (TextView) findViewById(R.id.jewelCount);
        menuFloor = (TextView) findViewById(R.id.floorCount);
        menuDistance = (TextView) findViewById(R.id.distanceCount);

        //音声


        //ボタンの初期設定
        exploreButtonSet();

        //主人公の生成
        h = new Hero("ヨシアキ", 100, 100, 50, 50);

        //メニューカウント更新
        menuCountSet();

//        //ダンジョン生成
        dungeon = new GoDungeon001();
        dungeon001 = dungeon.dungeonGenerate(h, 1);
    }


    //戦闘中ボタンセット
    public void battleButtonSet(){
        goButton.setEnabled(false);
        attackButton.setEnabled(true);
        escapeButton.setEnabled(false);
        recoverButton.setEnabled(true);
        magicButton.setEnabled(true);
    }

    //探索中ボタンセット
    public void exploreButtonSet(){
        goButton.setEnabled(true);
        attackButton.setEnabled(false);
        escapeButton.setEnabled(true);
        recoverButton.setEnabled(true);
        magicButton.setEnabled(false);
    }

    //ボタンすべて非表示
    public void allButtonNoSet(){
        goButton.setEnabled(false);
        attackButton.setEnabled(false);
        escapeButton.setEnabled(false);
        recoverButton.setEnabled(false);
        magicButton.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go :

                //ストーリーメッセージ インスタンス化
                messageList = new ArrayList<TextView>();
                TextView goText = new TextView(this);
                goText.setText("【すすむ】");
                messageList.add(goText);

                //進行
                messageList.addAll(dungeon001.goForwardDungeon());

                for(int i=0; i < messageList.size(); i++){
                    //damageタグを持つTextViewは赤で表示
                    if(messageList.get(i).getTag() == "damage"){
                        messageList.get(i).setTextColor(Color.parseColor("#ff6666"));
                    }else if(messageList.get(i).getTag() == "recover"){
                        messageList.get(i).setTextColor(Color.parseColor("#6666ff"));
                    }else {
                        messageList.get(i).setTextColor(Color.parseColor("#555555"));
                    }
                    storyTellingLog.addView(messageList.get(i));
                }

                break;


            case R.id.attack :

                break;


            case R.id.escape :

                break;

            case R.id.recover :


                break;


            case R.id.magic :

                break;

        }

        //メニューカウント更新
        menuCountSet();

        //スクロールビューを最下部に移動
        scrollView= (ScrollView)findViewById(R.id.storyScroll);
        scrollView.post(new Runnable()
        {
            public void run()
            {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

    }


    private void menuCountSet(){
        menuName.setText("" + h.getName());
        menuHp.setText("" + h.getHp() + "/" + h.getMaxHp());
        menuMp.setText("" + h.getMp() + "/" + h.getMaxMp());
        menuJewel.setText("" + Human.getCountJewel());
        menuFloor.setText("" + Human.getDungeonFloor());
        menuDistance.setText("" + Human.getDistance());
    }

    public static Context getContext(){
        return MainActivity.context;
    }

    public static void setBattleFlag(boolean battleFlag){
        MainActivity.battleFlag = battleFlag;
    }

}
