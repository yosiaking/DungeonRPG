package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.ExploreActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Goblin extends Monster {

	private int enemyImg = R.drawable.enemy_goblin;
	
	public Goblin(){
		super("ゴブリン", 30, 30, 0, 0, 7, 1, 1, 15, ExploreActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){

		ArrayList<TextView> arrayList = new ArrayList<TextView>();

		//ゴブリンの行動
		int enemyAction = new java.util.Random().nextInt(100);
		if(enemyAction >= 0 && enemyAction < 90){
			arrayList.addAll(attack(h));
		}else{
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
