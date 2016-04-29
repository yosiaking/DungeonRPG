package Object.Character.Enemy;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.*;


public class Dragon extends Monster {
	
	public Dragon(){
		super("ドラゴン", 70, 70, 20, 20, 20, 20, 3, MainActivity.getContext());
	}
	
	public void action(Human h){
		
		//ドラゴンの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 60){
			attack(h);
		}else if(enemyAction >= 60 && enemyAction < 90)
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
