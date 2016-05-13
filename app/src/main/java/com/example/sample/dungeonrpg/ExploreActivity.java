package com.example.sample.dungeonrpg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import Gameplay.Explore.GoDungeon;
import Gameplay.Function.FunctionReset;
import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;
import Object.Character.Player.Hero;
import Object.Dungeon.DungeonBase;


public class ExploreActivity extends AppCompatActivity implements View.OnClickListener {

    //インテント用定数
    public final static String HERO_NAME = "com.example.sample.dungeonrpg.hero.name";
    public final static String JEWEL_COUNT = "com.example.sample.dungeonrpg.jewel.count";
    public final static String FLOOR_COUNT = "com.example.sample.dungeonrpg.floor.count";
    public final static String DISTANCE_COUNT = "com.example.sample.dungeonrpg.floor.count";
    public final static String DUNGEON_NAME = "com.example.sample.dungeonrpg.dungeon.name";
    public final static String DUNGEON_CLEAR = "com.example.sample.dungeonrpg.dungeon.clear";

    //ダンジョンクリア条件
    private int clearJewelCount;

    //インテント
    private Intent intent;
    private Intent recieveIntent;

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

    //プログレスバーHP MP
    private ProgressBar progressBarHp;
    private ProgressBar progressBarMp;

    //ボタンフィールド
    private ImageView goButton;
    private ImageView attackButton;
    private ImageView magicButton;
    private ImageView recoverButton;
    private ImageView scareButton;
    private ImageView escapeButton;

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
        setContentView(R.layout.activity_explore);

        //物語表示板
        storyTellingLog = (LinearLayout) findViewById(R.id.storyTellingLog);

        //スクロールビュー取得
        scrollView = (ScrollView) findViewById(R.id.storyScroll);

        //Context取得
        context = getApplicationContext();

        //プログレスバー
        progressBarHp = (ProgressBar) findViewById(R.id.progressHp);
        progressBarMp = (ProgressBar) findViewById(R.id.progressMp);

        //ボタン
        goButton = (ImageView) findViewById(R.id.go);
        attackButton = (ImageView) findViewById(R.id.attack);
        magicButton = (ImageView) findViewById(R.id.magic);
        recoverButton = (ImageView) findViewById(R.id.recover);
        scareButton = (ImageView) findViewById(R.id.scare);
        escapeButton = (ImageView) findViewById(R.id.escape);

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

        //ボタンの初期設定
        exploreButtonSet();

        //主人公の生成
        h = new Hero("ヨシアキ", 100, 100, 50, 50);


        // 水平プログレスバーの最大値を設定します
        progressBarHp.setMax(h.getMaxHp());
        progressBarHp.setSecondaryProgress(h.getMaxHp());
        progressBarHp.setProgress(h.getHp());
        progressBarMp.setMax(h.getMaxMp());
        progressBarMp.setSecondaryProgress(h.getMaxMp());
        progressBarMp.setProgress(h.getMp());

        //メニューカウント更新
        menuCountSet();

        //インテント受け取り
        recieveIntent = getIntent();

        clearJewelCount = recieveIntent.getIntExtra(MainActivity.CLEAR_JEWEL, 5);

        //ダンジョン生成
        dungeon = new GoDungeon(1);
        goingDungeon = dungeon.dungeonGenerate(h, clearJewelCount);


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

                TextView magicText = new TextView(this);
                magicText.setText("【まほう】");
                messageList.add(magicText);

                //モンスターを攻撃
                messageList.addAll(h.magic(m));

                //HP>0 → 行動 HP<=0 → アイテムドロップ&戦闘終了
                if(Human.getBattleFlag() && !Human.getLackMpFlag()){
                    enemyAction();
                }

                break;



            case R.id.recover :

                TextView recoverText = new TextView(this);
                recoverText.setText("【いのる】");
                messageList.add(recoverText);

                //回復
                messageList.addAll(h.recover());

                if(Human.getBattleFlag() && !Human.getLackMpFlag()){
                    enemyAction();
                }

                break;

            case R.id.scare :


                break;


            case R.id.escape :

                if(Human.getDeadFlag()){
                    //死亡フラグ確認時

                    //Mainに戻るインテント実体化
                    intent = new Intent(this, MainActivity.class);

                    //状態をリセット
                    FunctionReset.resetGame();
                    FunctionReset.resetParam(h, m);
                    exploreButtonSet();
                    Human.setDeadFlag(false);

                    startActivity(intent);

                }else if (Human.getEscapeFlag()){
                    //脱出後

                    //エスケープフラグを無効化
                    Human.setEscapeFlag(false);

                    //Resultに行くインテント実体化
                    intent = new Intent(this, ResultActivity.class);
                    //名前
                    intent.putExtra(HERO_NAME, h.getName());
                    //宝石の数
                    intent.putExtra(JEWEL_COUNT, Human.getCountJewel());
                    //フロアの数
                    intent.putExtra(FLOOR_COUNT, Human.getDungeonFloor());
                    //歩いた距離
                    intent.putExtra(DISTANCE_COUNT, Human.getDistance());

                    startActivity(intent);

                }else{
                    //通常脱出時
                    TextView escapeText = new TextView(this);
                    escapeText.setText("【ぬけだす】");
                    messageList.add(escapeText);
                    messageList.addAll(h.escape(goingDungeon, m));
                    escapeButtonSet();
                }
                break;

        }

        //生死判定
        if(h.getHp() <= 0){
            TextView dead = new TextView(this);
            dead.setText(h.getName() + "はたおれた……" + "\r\n");
            dead.setTag("dead");
            messageList.add(dead);
            escapeButtonSet();
            Human.setDeadFlag(true);
        }

        //ストーリーテキスト表示
        for(int i=0; i < messageList.size(); i++){
            //damageタグ=赤、recoverタグ=青、その他=黒で表示
            if(messageList.get(i).getTag() == "damage"){
                messageList.get(i).setTextColor(Color.parseColor("#880000"));
            }else if(messageList.get(i).getTag() == "recover"){
                messageList.get(i).setTextColor(Color.parseColor("#3A2D6B"));
            }else if(messageList.get(i).getTag() == "dead"){
                messageList.get(i).setTextColor(Color.parseColor("#3E1244"));
            }else {
                messageList.get(i).setTextColor(Color.parseColor("#220000"));
            }
            messageList.get(i).setTextSize(20);
            storyTellingLog.addView(messageList.get(i));
        }


        //メニューカウント更新
        menuCountSet();

        //プログレスバー更新
        progressBarHp.setProgress(h.getHp());
        progressBarMp.setProgress(h.getMp());

        //MP欠如フラグをfalseに戻す
        Human.setLackMpFlag(false);

        //スクロールビューを最下部に移動
        scrollView= (ScrollView)findViewById(R.id.storyScroll);
        scrollView.post(new Runnable()
        {
            public void run()
            {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        //各フラッグ確認 & 背景差し替え
        if(Human.getBattleFlag()){
            scrollView.setBackgroundResource(m.getEnemyImg());
        }else if(Human.getJewelFlag()){
            scrollView.setBackgroundResource(R.drawable.bg_jewel);
            Human.setJewelFlag(false);
        }else if(Human.getNegativeTrapFlag()){
            scrollView.setBackgroundResource(R.drawable.bg_negativetrap);
            Human.setNegativeTrapFlag(false);
        }else if(Human.getPositiveTrapFlag()){
            scrollView.setBackgroundResource(R.drawable.bg_positivetrap);
            Human.setPositiveTrapFlag(false);
        }else{
            scrollView.setBackgroundResource(goingDungeon.getBgImgName());
        }
    }


    private void menuCountSet(){
        menuName.setText("" + h.getName());
        menuName.setTextColor(Color.parseColor("#220000"));
        menuHp.setText("" + String.format("%03d", h.getHp()) + "／" + String.format("%03d", h.getMaxHp()));
        menuHp.setTextColor(Color.parseColor("#220000"));
        menuMp.setText("" + String.format("%03d", h.getMp()) + "／" + String.format("%03d", h.getMaxMp()));
        menuMp.setTextColor(Color.parseColor("#220000"));
        menuJewel.setText("" + String.format("%03d",Human.getCountJewel()) );
        menuJewel.setTextColor(Color.parseColor("#220000"));
        menuFloor.setText(""  + String.format("%03d",Human.getDungeonFloor()));
        menuFloor.setTextColor(Color.parseColor("#220000"));
        menuDistance.setText(""  + String.format("%03d",Human.getDistance()));
        menuDistance.setTextColor(Color.parseColor("#220000"));
    }

    public void enemyAction(){
        //モンスター行動
        if(m.getHp() <= 0){

            //モンスターを倒した場合(HP<=0)
            TextView downEnemy = new TextView(this);
            downEnemy.setText(m.getName() + "を倒した。" + "\r\n");
            messageList.add(downEnemy);
            messageList.addAll(m.dropItem());
            m = null;
            Human.setBattleFlag(false);
            exploreButtonSet();

        }else{

            //HP > 0 なら モンスターの行動
            messageList.addAll(m.action(h));

            //モンスターが逃げた場合
            if(m.getEscapeFlag() == true){
                m = null;
                Human.setBattleFlag(false);
                exploreButtonSet();

            }
        }
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
    public void escapeButtonSet(){
        goButton.setEnabled(false);
        attackButton.setEnabled(false);
        escapeButton.setEnabled(true);
        recoverButton.setEnabled(false);
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

    public static Context getContext(){
        return ExploreActivity.context;
    }



}
