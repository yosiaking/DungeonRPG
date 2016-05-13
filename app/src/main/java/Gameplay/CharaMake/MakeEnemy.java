package Gameplay.CharaMake;

import Object.Character.CreatureType.Monster;
import Object.Character.Enemy.Demon;
import Object.Character.Enemy.Dragon;
import Object.Character.Enemy.Goblin;
import Object.Character.Enemy.SampleMonster;
import Object.Character.Enemy.Slime;
import Object.Character.Enemy.Wizard;

public class MakeEnemy {
	
	public static Monster makeEnemy(String monsterName){
		Monster m;
		switch(monsterName){
		//スライム
			case "slime" :
				m = new Slime();
				break;
		//ゴブリン
			case "goblin" :
				m = new Goblin();
				break;
		//魔法使い
			case "wizard" :
				m = new Wizard();
				break;
		//ドラゴン
			case "dragon" :
				m = new Dragon();
				break;
		//魔人
			case "demon" :
				m = new Demon();
				break;
		//サンプルモンスター(default)
			default :
				m = new SampleMonster();
		}

		return m;
	}
}
