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

import Gameplay.Explore.GoDungeon;
import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;
import Object.Character.Player.Hero;
import Object.Dungeon.DungeonBase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //メッセージarray
    private ArrayList<TextView> messageList;

    //レイアウト変数
    private LinearLayout storyTellingLog;

    //ダンジョン生成
    private GoDungeon dungeon;
    private DungeonBase goingDungeon;

    //ヒーロー生成
    private Hero h;

    //モンスター生成
    private Monster m;


    //ボタンフィールド
    private Button goButton;
    private Button attackButton;
    private Button magicButton;
    private Button recoverButton;
    private Button scareButton;
    private Button escapeButton;

    //メニューフィールド
    private TextView menuName;
    private TextView menuHp;
    private TextView menuMp;
    private TextView menuJewel;
    private TextView menuFloor;
    private TextView menuDistance;


    //Contextフィールド
    private static Context context;

    //ScrollViewフィールド
    public static ScrollView scrollView;

    //レイアウトパラメータ
    private final ViewGroup.LayoutParams WCWC = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private final ViewGroup.LayoutParams MPMP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private final ViewGroup.LayoutParams WCMP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private final ViewGroup.LayoutParams MPWC = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //物語表示板
        storyTellingLog = (LinearLayout) findViewById(R.id.storyTellingLog);

        //スクロールビュー取得
        scrollView = (ScrollView) findViewById(R.id.storyScroll);

        //Context取得
        context = getApplicationContext();

        //ボタン
        goButton = (Button) findViewById(R.id.go);
        attackButton = (Button) findViewById(R.id.attack);
        magicButton = (Button) findViewById(R.id.magic);
        recoverButton = (Button) findViewById(R.id.recover);
        scareButton = (Button ) findViewById(R.id.scare);
        escapeButton = (Button) findViewById(R.id.escape);

        //クリックリスナー
        goButton.setOnClickListener(this);
        attackButton.setOnClickListener(this);
        magicButton.setOnClickListener(this);
        recoverButton.setOnClickListener(this);
        scareButton.setOnClickListener(this);
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
        dungeon = new GoDungeon(1);
        goingDungeon = dungeon.dungeonGenerate(h);
    }


    //戦闘中ボタンセット
    public void battleButtonSet(){
        goButton.setEnabled(false);
        attackButton.setEnabled(true);
        escapeButton.setEnabled(false);
        recoverButton.setEnabled(true);
        scareButton.setEnabled(true);
        magicButton.setEnabled(true);
    }

    //探索中ボタンセット
    public void exploreButtonSet(){
        goButton.setEnabled(true);
        attackButton.setEnabled(false);
        escapeButton.setEnabled(true);
        recoverButton.setEnabled(true);
        scareButton.setEnabled(false);
        magicButton.setEnabled(false);
    }

    //ボタンすべて非表示
    public void allButtonNoSet(){
        goButton.setEnabled(false);
        attackButton.setEnabled(false);
        escapeButton.setEnabled(false);
        recoverButton.setEnabled(false);
        scareButton.setEnabled(false);
        magicButton.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        //ストーリーメッセージ インスタンス化
        messageList = new ArrayList<TextView>();

        switch (v.getId()){
            case R.id.go :

                TextView goText = new TextView(this);
                goText.setText("【すすむ】");
                messageList.add(goText);

                //進行
                messageList.addAll(goingDungeon.goForwardDungeon());

                //バトルフラッグオン
                //モンスターエンカウント&戦闘用ボタン配置
                if(Human.getBattleFlag() == true){
                    m = goingDungeon.encountEnemy();
                    battleButtonSet();

                    TextView encountEnemy = new TextView(this);
                    encountEnemy.setText(m.getName() + "が現れた!" + "\r\n");
                    messageList.add(encountEnemy);
                }

                break;


            case R.id.attack :

                TextView attackText = new TextView(this);
                attackText.setText("【たたかう】");
                messageList.add(attackText);

                //モンスターを攻撃
                messageList.addAll(h.attack(m));

                //HP>0 → 行動 HP<=0 → アイテムドロップ&戦闘終了
                enemyAction();

                break;


            case R.id.magic :

                break;



            case R.id.recover :

                TextView recoverText = new TextView(this);
                recoverText.setText("【いのる】");
                messageList.add(recoverText);

                //回復
                messageList.addAll(h.recover());

                if(Human.getBattleFlag()){
                    enemyAction();
                }

                break;

            case R.id.scare :

                break;

            case R.id.escape :

                break;


        }

        //ストーリーテキスト表示
        for(int i=0; i < messageList.size(); i++){
            //damageタグ=赤、recoverタグ=青、その他=黒で表示
            if(messageList.get(i).getTag() == "damage"){
                messageList.get(i).setTextColor(Color.parseColor("#880000"));
            }else if(messageList.get(i).getTag() == "recover"){
                messageList.get(i).setTextColor(Color.parseColor("#4444cc"));
            }else {
                messageList.get(i).setTextColor(Color.parseColor("#220000"));
            }
            storyTellingLog.addView(messageList.get(i));
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
        menuName.setTextColor(Color.parseColor("#220000"));
        menuHp.setText("" + h.getHp() + "/" + h.getMaxHp());
        menuHp.setTextColor(Color.parseColor("#220000"));
        menuMp.setText("" + h.getMp() + "/" + h.getMaxMp());
        menuMp.setTextColor(Color.parseColor("#220000"));
        menuJewel.setText("" + Human.getCountJewel());
        menuJewel.setTextColor(Color.parseColor("#220000"));
        menuFloor.setText("" + Human.getDungeonFloor());
        menuFloor.setTextColor(Color.parseColor("#220000"));
        menuDistance.setText("" + Human.getDistance());
        menuDistance.setTextColor(Color.parseColor("#220000"));
    }

    public static Context getContext(){
        return MainActivity.context;
    }



    public void enemyAction(){
        //モンスター行動
        if(m.getHp() >= 0){
            //true なら モンスターの行動
            messageList.addAll(m.action(h));

            //モンスターが逃げた場合
            if(m.getEscapeFlag() == true){
                m = null;
                Human.setBattleFlag(false);
                scrollView.setBackgroundResource(goingDungeon.getBgImgName());
                exploreButtonSet();
            }

        }else{
            //モンスターを倒した場合(HP<=0)
            TextView downEnemy = new TextView(this);
            downEnemy.setText(m.getName() + "を倒した。" + "\r\n");
            messageList.add(downEnemy);
            messageList.addAll(m.dropItem());
            m = null;
            Human.setBattleFlag(false);
            scrollView.setBackgroundResource(goingDungeon.getBgImgName());
            exploreButtonSet();

        }
    }

}
