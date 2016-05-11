package Gameplay.Explore.Event;

import Object.Character.CreatureType.*;
import Gameplay.CharaMake.MakeEnemy;;

public class EncountPattern {
	
	public static Monster encounter(int encountPattern){
		
		Monster m = null;
		int encountNum = new java.util.Random().nextInt(100);
		
		switch(encountPattern){
		//1 スライム100％
		case 1 :
			if(encountNum < 100){
				m = MakeEnemy.makeEnemy("slime");
			}
			break;

		//002 スライム70％ ゴブリン30%
		case 2 :
			if(encountNum < 70){
				m = MakeEnemy.makeEnemy("slime");
				return m;
			}else{
				m = MakeEnemy.makeEnemy("goblin");
			}
			break;

		//3 スライム30％ ゴブリン50% 魔法使い 20%
		case 3 :
			if(encountNum < 30){
				m = MakeEnemy.makeEnemy("slime");
			}else if(encountNum < 80){
					m = MakeEnemy.makeEnemy("goblin");
			}else{
				m = MakeEnemy.makeEnemy("wizard");
			}
			break;
			
		//4 スライム20％ ゴブリン30% 魔法使い40%  ドラゴン10%
		case 4 :
			if(encountNum < 20){
				m = MakeEnemy.makeEnemy("slime");
			}else if(encountNum < 50){
				m = MakeEnemy.makeEnemy("goblin");
			}else if(encountNum < 90){
				m = MakeEnemy.makeEnemy("wizard");
			}else{
				m = MakeEnemy.makeEnemy("dragon");
			}
			break;

		//5 スライム10％ ゴブリン20% 魔法使い20% ドラゴン40% 魔人10%
		case 5 :
			if(encountNum < 10){
				m = MakeEnemy.makeEnemy("slime");
			}else if(encountNum < 30){
				m = MakeEnemy.makeEnemy("goblin");
			}else if(encountNum < 60){
				m = MakeEnemy.makeEnemy("wizard");
			}else if(encountNum < 80){
				m = MakeEnemy.makeEnemy("dragon");
			}else{
				m = MakeEnemy.makeEnemy("demon");
			}
			break;
		
		default :
			m = MakeEnemy.makeEnemy("sample");
			//サンプルモンスター
		}
		
		return m;
	}
	
	
	
	

}
