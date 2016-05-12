package Gameplay.Explore;

import Object.Character.CreatureType.Human;
import Object.Dungeon.Dungeon001.Dungeon001;
import Object.Dungeon.DungeonBase;

//どの階層がどのダンジョンクラスになるかを操作

public class GoDungeon extends GoDungeonFunction implements GenerateDungeon{

	int dungeonNum;

	public GoDungeon(int dungeonNum){
		this.dungeonNum = dungeonNum;
	}

	public DungeonBase dungeonGenerate(Human h){

		DungeonBase d = null;
		switch(this.dungeonNum){
			case 1 :
				d = new Dungeon001(h);
				break;
		}

		return d;
	}
}