package Gameplay.Explore;

import Object.Character.CreatureType.Human;
import Object.Dungeon.Dungeon001.Dungeon001_01;
import Object.Dungeon.DungeonBase;

//どの階層がどのダンジョンクラスになるかを操作

public class GoDungeon001 extends GoDungeonFunction implements GenerateDungeon{
	
	public DungeonBase dungeonGenerate(Human h, int floor){
		DungeonBase d = null;
		if(floor <= 1){
			d = new Dungeon001_01(h);
		}else if(floor <= 10){
			d = new Dungeon001_01(h);
		}else{
			d = new Dungeon001_01(h);
		}
		return d;
	}
}