package Gameplay.Function;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

/**
 * Created by apple on 2016/05/12.
 */
public class FunctionReset {

    public static void resetGame(){
        Human.setBattleFlag(false);
        Human.setCountJewel(0);
        Human.setDistance(0);
        Human.setDungeonFloor(1);
        Human.setLackMpFlag(false);
        Human.setBattleFlag(false);
    }

    public static void resetParam(Human h, Monster m){
        h.setMaxHp(100);
        h.setMaxmp(50);
        h.setHp(h.getMaxHp());
        h.setMp(h.getMaxMp());
        m = null;
    }

}
