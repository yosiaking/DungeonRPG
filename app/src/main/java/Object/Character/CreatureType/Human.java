package Object.Character.CreatureType;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import Object.Character.Origin.Creature;

public abstract class Human extends Creature {
	
	//進んだ距離
	private static int distance = 0;
	//取得した宝石の数
	private static int countJewel = 0;
	//ダンジョン
	private static int dungeonFloor = 1;
	//バトルフラッグ
	private static boolean battleFlag = false;
	//コンテキスト
	private Context context;

	private ArrayList<TextView> humanMessageList;

	//コンストラクタ
	public Human(String name, int hp, int maxHp, int mp, int maxMp, int power, int magic, Context c){
		super(name, hp, maxHp, mp, maxMp, power, magic);
		context = c;
	}
	
	//モンスターに攻撃(打撃)
	public ArrayList<TextView> attack(Monster m){

		//ダメージ計算
		double attackDamage = (double) getPower() * ((new java.util.Random().nextDouble() / 3) + 1) ;
		m.damageHp((int)attackDamage);

		//return用文言
		humanMessageList = new ArrayList<TextView>();
		TextView attackText = new TextView(context);
		attackText.setText(getName() + "の攻撃！ " + m.getName() + "に" + (int)attackDamage + "のダメージ！");
		humanMessageList.add(attackText);

		return humanMessageList;
	}
	
	//モンスターに攻撃(魔法)
	public ArrayList<TextView> magic(Monster m){
		double magicDamage = (double)getMagic() * 2 * ((new java.util.Random().nextDouble()/3) + 1) ;
		m.damageHp((int)magicDamage);
		this.damageMp(5);

		humanMessageList = new ArrayList<TextView>();
		TextView magicText = new TextView(context);
		magicText.setText(getName() + "は魔法を唱えた！\n" + m.getName() + "に" + (int)magicDamage + "のダメージ！");
		humanMessageList.add(magicText);

		return humanMessageList;
	}
	
	//回復
	public ArrayList<TextView> recover(){

		humanMessageList = new ArrayList<TextView>();
		TextView recoverText = new TextView(context);

		if(this.getMp() >= 7){
			int recoverValue = this.getMaxHp() - new java.util.Random().nextInt(10);
			int recoverValueActual = Math.min(recoverValue, this.getMaxHp() - this.getHp());
			this.recoverHp(recoverValueActual);
			this.damageMp(7);
			recoverText.setText(getName() + "は祈りを捧げた！"+ getName() + "のHPが" + recoverValueActual + "回復した！"+ "\r\n");
		}else{
			recoverText.setText(getName() + "は祈りを捧げた！ しかし、MPが足りない");
		}
		recoverText.setTag("recover");
		humanMessageList.add(recoverText);

		return humanMessageList;
	}

	//逃げる
	public abstract void escape();
	

	//ゲッター距離
	public static int getDistance(){
		return Human.distance;
	}
	//セッター距離
	public static void setDistance(int distance){
		Human.distance = distance;
	}
	//進む距離
	public static void forwardDistance(int distance){
		Human.distance += distance;
	}
	
	//ゲッター宝石
	public static int getCountJewel(){
		return Human.countJewel;
	}
	//セッター宝石
	public static void setCountJewel(int jewel){
		Human.countJewel = jewel;
	}
	//宝石取得
	public static void obtainJewel(int jewel){
		Human.countJewel += jewel;
	}
	
	//ゲッター階層
	public static int getDungeonFloor(){
		return Human.dungeonFloor;
	}
	//セッター階層
	public static void setDungeonFloor(int floor){
		Human.dungeonFloor = floor;
	}
	//進む階層
	public static void forwardDungeonFloor(int forwardFloor){
		Human.dungeonFloor += forwardFloor;
	}

	//バトルフラッグセッター
	public static void setBattleFlag(boolean flagOnOff){
		Human.battleFlag = flagOnOff;
	}

	//バトルフラッグゲッター
	public static boolean getBattleFlag(){
		return Human.battleFlag;
	}

	//リセット
	public static void reset(){
		//進んだ距離初期化
		distance = 0;
		//取得した宝石の数初期化
		countJewel = 0;
		//ダンジョン初期化
		dungeonFloor = 1;
	}


}
