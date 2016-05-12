package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Object.Character.CreatureType.*;


public class Wizard extends Monster {

	int enemyImg = R.drawable.enemy_wizard;
	
	public Wizard(){
		super("黒魔術師", 40, 40, 10, 10, 8, 20, 3, 20, MainActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){

		ArrayList<TextView> arrayList = new ArrayList<TextView>();

		//魔法使いの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 30){
			arrayList.addAll(attack(h));
		}else if(enemyAction >= 30 && enemyAction < 90)
			arrayList.addAll(magicAttack(h));
		else{
			if(getHp() <= getMaxHp()/5){
				//逃げる
				arrayList.addAll(escape());
			}else{
				arrayList.addAll(attack(h));
			}
		}
		return arrayList;
	}

	public int getEnemyImg(){
		return enemyImg;
	}

	
}
