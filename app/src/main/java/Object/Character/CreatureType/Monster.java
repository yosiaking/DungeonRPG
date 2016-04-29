package Object.Character.CreatureType;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import Object.Character.Origin.Creature;

public abstract class Monster extends Creature {

	private boolean escapeFlag = false;
	private int jewel;

	protected Context context;

	protected ArrayList<TextView> monsterMessageList;

	//コンストラクタ
	public Monster(String name, int hp, int maxHp, int mp, int maxMp, int power, int magic, int jewel, Context c){
		super(name, hp, maxHp, mp, maxMp, power, magic);
		this.jewel = jewel;
		this.context = c;
	}
	
	//敵の行動
	public abstract void action(Human h);
	
	//攻撃
	public void attack(Human h){
		System.out.println(this.getName() + "の攻撃！");
		System.out.println(h.getName() + "に" + attackDamage() + "のダメージ！");
		h.damageHp(attackDamage());
	};

	
	//魔法攻撃
	public void magicAttack(Human h){
		System.out.println(this.getName() + "は魔法を唱えた！");
		if(this.getMp()<5){
			System.out.println("しかし、MPが足りない！");
		}else{
			System.out.println(h.getName() + "に" + attackDamage() + "のダメージ！");
			h.damageHp(attackDamage());
		}
	};
	
	
	//逃げる
	public void escape(){
		System.out.println(this.getName() + "は逃げ出した！");
		this.escapeFlag = true;
	}
	
	//アイテムドロップ 基本ドロップ率 10%で持っている宝石を落とす
	public void dropItem() {
		// TODO Auto-generated method stub
		int dropRate = new java.util.Random().nextInt(100);
		if(dropRate > 0 && dropRate < 10){
			System.out.println(getName() + "は、" + this.jewel  + "個の宝石を落とした。");
			Human.obtainJewel(this.jewel);
		}
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
}
