package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Demon extends Monster {

	private int enemyImg = R.drawable.enemy_wizard;

	public Demon(){
		super("魔人", 100, 70, 25, 25, 20, 20, 10, MainActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){

		ArrayList<TextView> arrayList = new ArrayList<TextView>();

		//魔人の行動の確率計算
		int enemyAction = new java.util.Random().nextInt(100);

		//行動内容
		if(enemyAction >= 0 && enemyAction < 40){
			arrayList.addAll(attack(h));
		}else if(enemyAction >= 40 && enemyAction < 85)
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
