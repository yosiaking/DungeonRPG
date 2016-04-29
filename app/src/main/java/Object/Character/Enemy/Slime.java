package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Slime extends Monster {
	
	public Slime(){
		super("スライム", 20, 20, 0, 0, 3, 1, 1, MainActivity.getContext());
	}
	
	public void action(Human h){

		monsterMessageList = new ArrayList<TextView>();


		//スライムの行動
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
