package Gameplay.CharaMake;

import Object.Character.CreatureType.Human;
import Object.Character.Player.Hero;

public class MakePlayer {
	
	public Human charaMake(){
		
		//メンバ変数
		String name;
		int hp;
		int maxHp;
		int mp;
		int maxMp;
		
		//名前入力
		while(true){
			System.out.println("主人公の名前を入力してください。");
			name = new java.util.Scanner(System.in).nextLine();
			System.out.println("「" + name + "」でお間違いないですか？");
			System.out.println("yes→ 1、no→ 2 ");
			int nameAnswer = new java.util.Scanner(System.in).nextInt();
			if(nameAnswer == 1){
				break;
			}
		}
		
		//HP&MP入力
		while(true){
			System.out.println("生命力150をHPに振り分けてください。");
			hp = new java.util.Scanner(System.in).nextInt();
			//バリデーション
			if(hp < 1){
				System.out.println("1以上で入力してください。");
				continue;
			}else if(hp > 150){
				System.out.println("150以下で入力してください。");
				continue;
			}
			//mpの計算
			mp = 150 -hp;
			//確認
			System.out.println("HP:" + hp + "MP:" + mp + "でお間違いないですか？");
			System.out.println("yes→ 1  no→ 2 ");
			int okAnswer = new java.util.Scanner(System.in).nextInt();
			if(okAnswer == 1){
				break;
			}
		}
		
		Hero h = new Hero(name, hp, hp, mp, mp);
		return h;
	}
}
