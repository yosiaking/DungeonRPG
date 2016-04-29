package Object.Character.Origin;

public abstract class Creature {
	
	private String name;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int power;
	private int magic;
	
	//コンストラクタ
	public Creature(String name, int hp, int maxHp, int mp, int maxMp, int power, int magic){
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.maxMp = maxMp;
		this.power = power;
		this.magic = magic;
	}
	
	
	//ゲッターName
	public String getName(){
		return this.name;
	}
	//セッターName
	public void setName(String name){
		this.name = name;
	}
	
	
	//ゲッターHP
	public int getHp(){
		return this.hp;
	}
	//セッターHP
	public void setHp(int hp){
		this.hp = hp;
	}
	//ダメージHP
	public void damageHp(int damage){
		this.hp -= damage;
	}
	//リカバーHP
	public void recoverHp(int recover){
		this.hp += recover;
	}
	//ゲッターmaxHp
	public int getMaxHp(){
		return this.maxHp;
	}
	//セッターmaxHp
	public void setMaxHp(int maxHp){
		this.maxHp = maxHp;
	}
	
	
	//ゲッターMp
	public int getMp(){
		return this.mp;
	}
	//セッターMp
	public void setMp(int mp){
		this.mp = mp;
	}
	//消費MP
	public void damageMp(int damage){
		this.mp -= damage;
	}
	//リカバーMP
	public void recoverMp(int recover){
		this.mp += recover;
	}
	//ゲッターmaxMp
	public int getMaxMp(){
		return this.maxMp;
	}
	//セッターmaxMp
	public void setMaxmp(int maxMp){
		this.maxMp = maxMp;
	}
	
	
	//ゲッターpower
	public int getPower(){
		return this.power;
	}
	//セッターpower
	public void setPower(int power){
		this.power = power;
	}
	
	//ゲッターmagic
	public int getMagic(){
		return this.magic;
	}
	//セッターmagic
	public void setMagic(int magic){
		this.power = magic;
	}
	

}
