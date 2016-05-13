package Gameplay.Explore.Event;

import android.widget.TextView;

import com.example.sample.dungeonrpg.ExploreActivity;

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
		TextView battleText = new TextView(ExploreActivity.getContext());

		//エンカウント
		Monster m = EncountPattern.encounter(encountPattern);

		return m;
	}

	public static ArrayList<TextView> nonEvent00(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent01(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は何か不吉な予感がした。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent02(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("奥から風がふいてきた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent03(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("何かの雄叫びが聞こえた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent04(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は大切な人のことを思い出した。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent05(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("何かのうなり声が聞こえた。 しかしそれは"+ h.getName() + "のお腹の音だった。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent06(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は拾った宝石の数を数えた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent07(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "の頬を汗がつたった。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent08(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("どこからか甘いにおいがした。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent09(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は薄暗い道に出た。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent10(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は広い道に出た。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent11(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("近くに魔物の気配を感じる。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent12(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "ひび割れた道を慎重に歩いた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent13(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("あたりは静寂につつまれている。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent14(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "はポケットに手をつっこんだ。 食べかけのクッキーを見つけた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent15(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は剣を手入れした。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent16(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText("水のしたたる音が聞こえる。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}


	public static ArrayList<TextView> nonEvent17(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は深呼吸をした。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}


	public static ArrayList<TextView> nonEvent18(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は背筋に寒気を感じた。"+ "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent19(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "はコンパスを見た。" + "\r\n");
		arrayList.add(t);
		return arrayList;
	}

	public static ArrayList<TextView> nonEvent20(Human h){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView t = new TextView(ExploreActivity.getContext());
		t.setText(h.getName() + "は何かの視線を感じた。" + "\r\n");
		arrayList.add(t);
		return arrayList;
	}


	//湧き水を発見(最大HPの1/5回復)
	public static ArrayList<TextView> recoverEvent01(Human h){

		int recoverValueHp = h.getMaxHp() / 5;
		int recoverValueActual = Math.min(recoverValueHp, h.getMaxHp() - h.getHp());
		h.recoverHp(recoverValueActual);

		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView recover99Text = new TextView(ExploreActivity.getContext());
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
		TextView recover99Text = new TextView(ExploreActivity.getContext());
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
		TextView recover99Text = new TextView(ExploreActivity.getContext());
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
		TextView recover99Text = new TextView(ExploreActivity.getContext());
		recover99Text.setText("新緑の大地を見つけた! " + h.getName() + "のHPが"+ recoverValueActual + "回復した！" + "\r\n");
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
		TextView recover99Text = new TextView(ExploreActivity.getContext());
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
		TextView trap01Text = new TextView(ExploreActivity.getContext());
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
		TextView trap01Text = new TextView(ExploreActivity.getContext());
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
		TextView trap01Text = new TextView(ExploreActivity.getContext());
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
		TextView trap01Text = new TextView(ExploreActivity.getContext());
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
		TextView trap01Text = new TextView(ExploreActivity.getContext());
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
		TextView trap99Text = new TextView(ExploreActivity.getContext());
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
		TextView jewelText = new TextView(ExploreActivity.getContext());
		jewelText.setText("宝石発見！" + h.getName() + "は" + getJewelCount + "個の宝石を手に入れた！" + "\r\n");
		arrayList.add(jewelText);
		Human.setJewelFlag(true);

		return arrayList;
	}

}
