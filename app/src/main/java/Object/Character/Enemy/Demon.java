package Object.Character.Enemy;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Demon extends Monster {

	public Demon(){
		super("魔人", 100, 70, 25, 25, 20, 20, 10, MainActivity.getContext());
	}
	
	public void action(Human h){
		
		//ドラゴンの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 40){
			attack(h);
		}else if(enemyAction >= 40 && enemyAction < 85)
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
