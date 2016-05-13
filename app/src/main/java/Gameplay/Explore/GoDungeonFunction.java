package Gameplay.Explore;

import Object.Character.CreatureType.Human;
import Object.Dungeon.Dungeon001.Dungeon001;
import Object.Dungeon.DungeonBase;

public class GoDungeonFunction {
	
	
	public void goDungeon(Human h){
			
		//ダンジョンインスタンス;
		DungeonBase dungeon = null;
		//脱出フラグ
		boolean exitFlag = false;
//
	}
	
	public DungeonBase dungeonGenerate(Human h, int floor, int clearJewelCount){
		DungeonBase d = null;
		d = new Dungeon001(h, clearJewelCount);
		return d;
	}
	
}
