package Gameplay.Explore.Event;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

public class Event {


	//モンスター出現&バトル
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
		recover99Text.setText("湧き水を発見！"+ h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);

		return arrayList;
	}
	
	//泉発見(HPMP全回復)
	public static ArrayList<TextView> recoverEvent99(Human h){
		h.setHp(h.getMaxHp());
		h.setMp(h.getMaxMp());

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(MainActivity.getContext());
		recover99Text.setText("泉を発見！"+ h.getName() + "のHPとMPが全回復した！" + "\r\n");
		recover99Text.setTag("recover");
		arrayList.add(recover99Text);

		return arrayList;
	}


	//トラップ(つまずいた) ダメージ:1〜5
	public static ArrayList<TextView> trapEvent01(Human h){
		int damage = new java.util.Random().nextInt(5) + 1;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("石につまずいた！" + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);

		return arrayList;
	}



	//トラップ(落盤) ダメージ:1〜最大HPの半分+1
	public static ArrayList<TextView> trapEvent02(Human h){
		int damage = new java.util.Random().nextInt(h.getMaxHp()/2) + 1;
		h.damageHp(damage);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap01Text = new TextView(MainActivity.getContext());
		trap01Text.setText("落盤！" + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap01Text.setTag("damage");
		arrayList.add(trap01Text);

		return arrayList;
	}
	
	//トラップ(大爆発) 死亡
	public static ArrayList<TextView> trapEvent99(Human h){
		int damage = h.getMaxHp();
		h.damageHp(damage);

		//表示用String配列
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView trap99Text = new TextView(MainActivity.getContext());
		trap99Text.setText("大爆発！" + h.getName() + "は" + damage  + "のダメージを受けた！" + "\r\n");
		trap99Text.setTag("damage");
		arrayList.add(trap99Text);

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
		return arrayList;
	}

}
