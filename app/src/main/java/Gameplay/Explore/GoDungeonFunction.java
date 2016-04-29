package Gameplay.Explore;

import Object.Character.CreatureType.Human;
import Object.Dungeon.Dungeon001.Dungeon001_01;
import Object.Dungeon.DungeonBase;

public class GoDungeonFunction {
	
	
	public void goDungeon(Human h){
			
		//ダンジョンインスタンス;
		DungeonBase dungeon = null;
		//脱出フラグ
		boolean exitFlag = false;

		//探索ループ
		while(true){
			
			dungeon = dungeonGenerate(h, h.getDungeonFloor());

			System.out.println("操作を入力してください。");
			System.out.println("1:すすむ  2:かいふく  3:じょうたい  4:たんけんをやめる");
			int commandNum = new java.util.Scanner(System.in).nextInt();
			
			switch(commandNum){
			case 1 :
				dungeon.goForward();
				break;
			case 2 :
				//かいふく
				if(h.getMp() >= 7){
					h.recover(h);	
				}else{
					System.out.println(h.getName() + "は祈りを捧げた！");
					System.out.println("しかし、MPが足りない！");
				}
				break;
			case 3 :
				//HP/MaxHp  MP/MaxMp  進んだ距離  洞窟◯階  宝石の数
				System.out.println("HP : " + h.getHp() + "/" + h.getMaxHp());
				System.out.println("MP : " + h.getMp() + "/" + h.getMaxMp());
				System.out.println("距離 : " + Human.getDistance());
				System.out.println("階層 : " + Human.getDungeonFloor());
				System.out.println("宝石 : " + Human.getCountJewel());
				break;
			case 4 :
				//脱出フラグON
				exitFlag = true;
				break;
				
			default :
				System.out.println("正しい値を入力してください。");
			}
			
			//脱出フラグがtrueなら探索終了
			if(exitFlag){
				System.out.println("脱出しました。");
			}
			
			//トラップなどでダメージを受けた場合のゲームオーバー処理
			if(h.getHp() <= 0){
				System.out.println(h.getName() + "は、倒れた……。");
			}
			
		}		
		
	}
	
	public DungeonBase dungeonGenerate(Human h, int floor){
		DungeonBase d = null;
		d = new Dungeon001_01(h);
		return d;
	}
	
}
