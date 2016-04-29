package Object.Character.Enemy;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.*;


public class Goblin extends Monster {
	
	public Goblin(){
		super("ゴブリン", 30, 30, 0, 0, 7, 1, 1, MainActivity.getContext());
	}
	
	public void action(Human h){
		
		//ゴブリンの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 90){
			attack(h);
		}else{
			if(getHp() <= getMaxHp()/5){
				//逃げる
				escape();
			}
			this.attack(h);
		}
		
		

	}
	
}
