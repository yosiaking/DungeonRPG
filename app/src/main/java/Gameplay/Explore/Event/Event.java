package Gameplay.Explore.Event;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

public class Event {

	//モンスター出現
	public static void encountEnemy(){
		Human.setBattleFlag(true);
	}

	//モンスターとのバトル
	public static Monster battleEvent(int encountPattern){

		//表示用String配列
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView battleText = new TextView(MainActivity.getContext());

		//エンカウント
		Monster m = EncountPattern.encounter(encountPattern);

		return m;
	}


	//湧き水を発見(最大HPの1/5回復)
	public static ArrayList<TextView> recoverEvent01(Human h){

		int recoverValueHp = h.getMaxHp() / 5;
		int recoverValueActual = Math.min(recoverValueHp, h.getMaxHp() - h.getHp());
		h.recoverHp(recoverValueActual);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("湧き水を発見！ "+ h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);
		Human.setPositiveTrapFlag(true);

		return arrayList;
	}

	//食物庫を発見(最大HPの1/4回復)
	public static ArrayList<TextView> recoverEvent02(Human h){

		int recoverValueHp = h.getMaxHp() / 4;
		int recoverValueActual = Math.min(recoverValueHp, h.getMaxHp() - h.getHp());
		h.recoverHp(recoverValueActual);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("食物庫を発見！ "+ h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);
		Human.setPositiveTrapFlag(true);

		return arrayList;
	}


	//泉を発見(最大HPの1/3回復)
	public static ArrayList<TextView> recoverEvent03(Human h){

		int recoverValueHp = h.getMaxHp() / 3;
		int recoverValueActual = Math.min(recoverValueHp, h.getMaxHp() - h.getHp());
		h.recoverHp(recoverValueActual);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("泉を発見！ "+ h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);
		Human.setPositiveTrapFlag(true);

		return arrayList;
	}

	//新緑の大地を見つけた。(最大HPの1/2回復)
	public static ArrayList<TextView> recoverEvent04(Human h){

		int recoverValueHp = h.getMaxHp() / 2;
		int recoverValueActual = Math.min(recoverValueHp, h.getMaxHp() - h.getHp());
		h.recoverHp(recoverValueActual);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("新緑の大地を見つけた! "+ h.getName() + "は、身体を休めた。 "+ h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);
		Human.setPositiveTrapFlag(true);

		return arrayList;
	}

	
	//神の息吹を感じた。(HPMP全回復)
	public static ArrayList<TextView> recoverEvent99(Human h){
		h.setHp(h.getMaxHp());
		h.setMp(h.getMaxMp());

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("神の息吹を感じた。 "+ h.getName() + "のHPとMPが全回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);
		Human.setPositiveTrapFlag(true);

		return arrayList;
	}


	//トラップ(つまずいた) 現HPの1/5ダメージ
	public static ArrayList<TextView> trapEvent01(Human h){
		int damage = h.getHp() / 5;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("石につまずいた！ " + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}



	//トラップ(落盤) ダメージ:現HPの1/4ダメージ
	public static ArrayList<TextView> trapEvent02(Human h){
		int damage = h.getHp() / 4;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("落盤！ " + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}

	//トラップ(古の罠にかかった!) ダメージ:現HPの1/3ダメージ
	public static ArrayList<TextView> trapEvent03(Human h){
		int damage = h.getHp() / 3;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("古の罠にかかった! " + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}


	//トラップ(悪魔のささやきが聞こえる。) ダメージ:現HPの1/2ダメージ
	public static ArrayList<TextView> trapEvent04(Human h){
		int damage = h.getHp() / 2;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("悪魔のささやきが聞こえる。 " + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}


	//トラップ(毒の霧) ダメージ:1〜最大HPの半分
	public static ArrayList<TextView> trapEvent98(Human h){
		int damage = new java.util.Random().nextInt(h.getMaxHp()/2) + 1;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("毒の霧があたりに立ち込めた! " + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}
	
	//トラップ(大爆発) 残りHPを1に
	public static ArrayList<TextView> trapEvent99(Human h){
		int damage = h.getHp() - 1;
		h.damageHp(damage);

		//表示用String配列
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap99Text = new TextView(MainActivity.getContext());
		trap99Text.setText("大爆発！" + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap99Text.setTag("damage");
		arrayList.add(trap99Text);
		Human.setNegativeTrapFlag(true);

		return arrayList;
	}
	
	
	//宝石発見 (引数2:最小値 引数3:+の個数)
	public static ArrayList<TextView> getJewelEvent(Human h, int minNum, int plusNum){
		int getJewelCount = new java.util.Random().nextInt(plusNum) + minNum ;
		Human.obtainJewel(getJewelCount);

		//表示用String配列
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView jewelText = new TextView(MainActivity.getContext());
		jewelText.setText("宝石発見！" + h.getName() + "は" + getJewelCount + "個の宝石を手に入れた！" + "\r\n");
		arrayList.add(jewelText);
		Human.setJewelFlag(true);

		return arrayList;
	}

}
