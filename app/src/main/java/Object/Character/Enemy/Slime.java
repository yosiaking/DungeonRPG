package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;


public class Slime extends Monster {

	private int	enemyImg = R.drawable.enemy_slime;

	public Slime(){
		super("スライム", 20, 20, 0, 0, 3, 1, 1, 10,  MainActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){


		ArrayList<TextView> arrayList = new ArrayList<TextView>();

		//スライムの行動
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

	public ArrayList<TextView> test(){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView test = new TextView(MainActivity.getContext());
		test.setText("test");
		arrayList.add(test);
		return arrayList;
	}

	public int getEnemyImg(){
		return enemyImg;
	}
	
}
