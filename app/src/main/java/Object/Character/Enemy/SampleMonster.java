package Object.Character.Enemy;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.*;


public class SampleMonster extends Monster {

	int sample;

	//コンストラクタ(String 名前, int HP, int MaxHP, int MP, int MaxMp, int Power, int magic int JewelCount)
	public SampleMonster(){
		super("サンプルモンスター", 1, 1, 1, 1, 1, 1, 1, 1, MainActivity.getContext());
	}
	
	public ArrayList<TextView> action(Human h){
		ArrayList<TextView> sampleList = new ArrayList<TextView>();
		TextView sampleText = new TextView(MainActivity.getContext());
		sampleList.add(sampleText);
		return sampleList;
	}

	public int getEnemyImg(){
		return sample;
	}

}
