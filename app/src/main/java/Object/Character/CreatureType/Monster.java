package Object.Character.CreatureType;

import android.content.Context;
import android.widget.TextView;

import com.example.sample.dungeonrpg.ExploreActivity;

import java.util.ArrayList;

import Object.Character.Origin.Creature;

public abstract class Monster extends Creature {

	private boolean escapeFlag = false;

	//落とす宝石の数
	protected int jewel;

	//宝石を落とす確率
	protected int dropRate;

	protected Context context;

	protected ArrayList<TextView> monsterMessageList;

	//コンストラクタ
	public Monster(String name, int hp, int maxHp, int mp, int maxMp, int power, int magic, int jewel, int dropRate, Context c){
		super(name, hp, maxHp, mp, maxMp, power, magic);
		this.jewel = jewel;
		this.context = c;
		this.dropRate = dropRate;
	}
	
	//敵の行動
	public abstract ArrayList<TextView> action(Human h);

	//出現画像
	public abstract int getEnemyImg();
	
	//攻撃
	public ArrayList<TextView> attack(Human h){

		monsterMessageList = new ArrayList<TextView>();
		TextView attackText = new TextView(ExploreActivity.getContext());

		//ダメージ値確定
		int damage = attackDamage();
		//ダメージ
		h.damageHp(damage);

		//テキストをビューに追加
		attackText.setText(this.getName() + "の攻撃！ " + h.getName() + "に" + damage + "のダメージ！" + "\r\n");
		attackText.setTag("damage");
		monsterMessageList.add(attackText);
		return monsterMessageList;
	}

	
	//魔法攻撃
	public ArrayList<TextView> magicAttack(Human h){

		monsterMessageList = new ArrayList<TextView>();
		TextView magicText = new TextView(ExploreActivity.getContext());

		if(this.getMp() >= 5){
			//ダメージ値確定
			int damage = magicDamage();
			h.damageHp(damage);
			magicText.setText(this.getName() + "は魔法を唱えた！ " + h.getName() + "に" + damage + "のダメージ！" + "\r\n");
			magicText.setTag("damage");
		}else{
			magicText.setText(this.getName() + "は魔法を唱えた！ しかし、MPが足りない！" + "\r\n");
		}
		monsterMessageList.add(magicText);
		return monsterMessageList;
	}
	
	
	//逃げる
	public ArrayList<TextView> escape(){
		monsterMessageList = new ArrayList<TextView>();
		TextView escapeText = new TextView(ExploreActivity.getContext());
		escapeText.setText(this.getName() + "は逃げ出した！" + "\r\n");
		this.escapeFlag = true;
		monsterMessageList.add(escapeText);
		return monsterMessageList;
	}
	
	//アイテムドロップ
	public ArrayList<TextView> dropItem() {
		monsterMessageList = new ArrayList<TextView>();
		TextView jewelText = new TextView(ExploreActivity.getContext());

		int dropRateCount = new java.util.Random().nextInt(100);
		if(dropRateCount - getDropRate() < 0){
			jewelText.setText(getName() + "は、" + this.jewel  + "個の宝石を落とした。" + "\r\n");
			Human.obtainJewel(this.jewel);
		}
		monsterMessageList.add(jewelText);
		return monsterMessageList;
	}
	
	//物理ダメージ計算のメソッド
	private int attackDamage(){
		//基本ダメージ倍率 1〜1.333・・・
		double magnification = new java.util.Random().nextDouble() / 3 + 1;
		double damage =  this.getPower() * magnification;
		return (int)damage;
	}
	
	//魔法ダメージ計算のメソッド
	private int magicDamage(){
		//基本ダメージ倍率 2〜2.333・・・
			double magnification = new java.util.Random().nextDouble() / 3 + 1;
			double damage =  this.getMagic() * 2 * magnification;
			this.damageMp(5);
			return (int)damage;
	}
	
	//ゲッターescapeFlag
	public boolean getEscapeFlag(){
		return this.escapeFlag;
	}
	
	
	//ゲッター宝石
	public int getJewel(){
		return this.jewel;
	}

	//ゲッタードロップ確率
	public int getDropRate(){
		return this.dropRate;
	}

}
