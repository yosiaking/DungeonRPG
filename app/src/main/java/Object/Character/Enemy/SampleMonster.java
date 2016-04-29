package Object.Character.Enemy;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.*;


public class SampleMonster extends Monster {
	
	//コンストラクタ(String 名前, int HP, int MaxHP, int MP, int MaxMp, int Power, int magic int JewelCount)
	public SampleMonster(){
		super("サンプルモンスター", 1, 1, 1, 1, 1, 1, 1, MainActivity.getContext());
	}
	
	public void action(Human h){
		
	}

}
