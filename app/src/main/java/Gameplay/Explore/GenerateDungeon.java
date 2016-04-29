package Gameplay.Explore;

import Object.Character.CreatureType.Human;
import Object.Dungeon.DungeonBase;

public interface GenerateDungeon {
	
	public DungeonBase dungeonGenerate(Human h, int floor);
}
