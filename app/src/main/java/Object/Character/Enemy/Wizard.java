package Object.Character.Enemy;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.*;


public class Wizard extends Monster {
	
	public Wizard(){
		super("魔法使い", 40, 50, 10, 25, 20, 20, 3, MainActivity.getContext());
	}
	
	public void action(Human h){
		
		//魔法使いの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 30){
			attack(h);
		}else if(enemyAction >= 30 && enemyAction < 90)
			magicAttack(h);
		else{
			if(getHp() <= getMaxHp()/5){
				//逃げる
				escape();
			}
			this.attack(h);
		}
		
	}

	
}
