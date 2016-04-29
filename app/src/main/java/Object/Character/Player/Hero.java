package Object.Character.Player;

import com.example.sample.dungeonrpg.MainActivity;

import Object.Character.CreatureType.Human;

public class Hero extends Human {
	
	//Heroは攻撃10 魔法10固定
	public Hero(String name, int hp, int maxHp, int mp, int maxMp){
		super(name, hp, maxHp, mp, maxMp, 10, 10, MainActivity.getContext());
	}
	
	@Override
	public void escape() {
		// TODO Auto-generated method stub
		
	}
	
}
