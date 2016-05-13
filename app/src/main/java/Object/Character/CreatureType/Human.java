package Object.Character.CreatureType;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import Gameplay.Function.FunctionReset;
import Object.Character.Origin.Creature;
import Object.Dungeon.DungeonBase;

public abstract class Human extends Creature {
	
	//進んだ距離
	private static int distance = 0;
	//取得した宝石の数
	private static int countJewel = 0;
	//ダンジョン
	private static int dungeonFloor = 1;
	//バトルフラグ
	private static boolean battleFlag = false;
	//MP切れフラグ
	private static boolean lackMpFlag = false;
	//宝石ゲットフラグ
	private static boolean jewelFlag = false;
	//ネガティブトラップフラグ
	private static boolean negativeTrapFlag = false;
	//ポジティブトラップフラグ
	private static boolean positiveTrapFlag = false;
	//死亡フラグ
	private static boolean deadFlag = false;

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
		attackText.setText(getName() + "の攻撃！ " + m.getName() + "に" + (int)attackDamage + "のダメージ！"+ "\r\n");
		humanMessageList.add(attackText);

		return humanMessageList;
	}
	
	//モンスターに攻撃(魔法)
	public ArrayList<TextView> magic(Monster m){
		humanMessageList = new ArrayList<TextView>();
		TextView magicText = new TextView(context);
		if(this.getMp() >= 10) {
			double magicDamage = (double)getMagic() * 3 * ((new java.util.Random().nextDouble()/3) + 1) ;
			m.damageHp((int)magicDamage);
			this.damageMp(10);
			magicText.setText(getName() + "は魔法を唱えた！ " + m.getName() + "に" + (int) magicDamage + "のダメージ！" + "\r\n");
		}else{
			magicText.setText("MPが足りない" + "\r\n");
			Human.setLackMpFlag(true);
		}
		humanMessageList.add(magicText);
		return humanMessageList;
	}
	
	//回復
	public ArrayList<TextView> recover(){

		humanMessageList = new ArrayList<TextView>();
		TextView recoverText = new TextView(context);

		if(this.getMp() >= 15){
			int recoverValue = this.getMaxHp() - new java.util.Random().nextInt(10);
			int recoverValueActual = Math.min(recoverValue, this.getMaxHp() - this.getHp());
			this.recoverHp(recoverValueActual);
			this.damageMp(15);
			recoverText.setText(getName() + "は祈りを捧げた！ "+ getName() + "のHPが" + recoverValueActual + "回復した！"+ "\r\n");
			recoverText.setTag("recover");
		}else{
			recoverText.setText("MPが足りない"+ "\r\n");
			Human.setLackMpFlag(true);
		}
		humanMessageList.add(recoverText);

		return humanMessageList;
	}

	//逃げる
	public ArrayList<TextView> escape(DungeonBase d, Monster m){

		humanMessageList = new ArrayList<TextView>();
		TextView escapeText = new TextView(context);
		escapeText.setText(getName() + "は" + d.getDungeonType() + "をぬけだした"+ "\r\n");
		humanMessageList.add(escapeText);
		FunctionReset.resetGame();
		FunctionReset.resetParam(this, m);
		return humanMessageList;
	}
	

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

	//MP切れフラグセッター
	public static void setLackMpFlag(boolean flag){
		Human.lackMpFlag = flag;
	}

	//MP切れフラグゲッター
	public static boolean getLackMpFlag(){
		return lackMpFlag;
	}

	//宝石ゲットフラグセッター
	public static void setJewelFlag(boolean flag){
		Human.jewelFlag = flag;
	}

	//宝石ゲットフラグゲッター
	public static boolean getJewelFlag(){
		return jewelFlag;
	}

	//ネガティブフラグセッター
	public static void setNegativeTrapFlag(boolean flag){
		Human.negativeTrapFlag = flag;
	}

	//ネガティブフラグゲッター
	public static boolean getNegativeTrapFlag(){
		return negativeTrapFlag;
	}

	//ポジティブフラグゲッター
	public static void setPositiveTrapFlag(boolean flag){
		Human.positiveTrapFlag = flag;
	}

	//ポジティブフラグゲッター
	public static boolean getPositiveTrapFlag(){
		return positiveTrapFlag;
	}

	//死亡フラグセッター
	public static void setDeadFlag(boolean flag){
		Human.deadFlag = flag;
	}

	//死亡フラグゲッター
	public static boolean getDeadFlag(){
		return Human.deadFlag;
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
