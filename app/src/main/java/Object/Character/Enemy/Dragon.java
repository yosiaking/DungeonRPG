package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Dragon extends Monster {

	private int enemyImg = R.drawable.enemy_dragon;


	public Dragon(){
		super("ドラゴン", 70, 70, 20, 20, 20, 20, 5, 30, MainActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){

		ArrayList<TextView> arrayList = new ArrayList<TextView>();

		//ドラゴンの行動
		int enemyAction = new java.util.Random().nextInt(100);

		if(enemyAction >= 0 && enemyAction < 60){
			arrayList.addAll(attack(h));
		}else if(enemyAction >= 60 && enemyAction < 90)
			arrayList.addAll(magicAttack(h));
		else{
			if(getHp() <= getMaxHp() / 5){
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
