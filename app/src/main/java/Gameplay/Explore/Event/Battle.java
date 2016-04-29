package Gameplay.Explore.Event;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Monster;

public class Battle {

	public static ArrayList<TextView> encountEnemy(Monster m) {

		//コンテキストビュー生成
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView textView = new TextView(MainActivity.getContext());

		textView.setText(m.getName() + "が現れた！");
		arrayList.add(textView);

		return arrayList;
	}



}

//		boolean battleFlag = true;
//
//		while(battleFlag){
//			int battleCommand = new java.util.Scanner(System.in).nextInt();
//
//			if(battleCommand >= 1 && battleCommand <= 4 ){
//				switch(battleCommand){
//				case 1 :
//					//物理攻撃
//					h.attack(m);
//					break;
//				case 2 :
//					//魔法攻撃
//					if(h.getMp() >= 5){
//						h.magic(m);
//						break;
//					}else{
//						System.out.println("MPが足りない！");
//						continue;
//					}
//				case 3 :
//					//かいふく
//					if(h.getMp() >= 7){
//						h.recover(h);
//						break;
//					}else{
//						System.out.println("MPが足りない！");
//						continue;
//					}
//
//				case 4 :
//					//じょうたい
//					System.out.println("HP : " + h.getHp() + "/" + h.getMaxHp());
//					System.out.println("MP : " + h.getMp() + "/" + h.getMaxMp());
//					System.out.println("距離 : " + Human.getDistance());
//					System.out.println("階層 : " + Human.getDungeonFloor());
//					System.out.println("宝石 : " + Human.getCountJewel());
//					continue;
//				}
//
//			}else{
//				System.out.println("正しい値を入力してください。");
//				continue;
//			}
//
//
//			//敵を倒した
//			if(m.getHp()<=0){
//				System.out.println(m.getName() + "を倒した。");
//				m.dropItem();
//				battleFlag = false;
//			}else{
//				m.action(h);
//				//敵が逃げて戦闘終了
//				if(m.getEscapeFlag()){
//					System.out.println(m.getName() + "は逃げ出した。");
//					battleFlag = false;
//				}
//			}
//
//			if(h.getHp() <= 0){
//			//HPなくなる→ゲームオーバー
//				battleFlag = false;
//			}
//
//
//		}
//	}
//}
