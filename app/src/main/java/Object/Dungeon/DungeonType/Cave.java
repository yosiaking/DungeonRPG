package Object.Dungeon.DungeonType;

import android.widget.TextView;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;
import Object.Dungeon.DungeonBase;

/**
 * Created by apple on 2016/05/12.
 */
public abstract class  Cave extends DungeonBase {

    private String dungeonType = "どうくつ";

    public Cave(Human human) {
        super(human);
    }

    public abstract ArrayList<TextView> goForwardDungeon();

    public abstract int getBgImgName();

    //モンスターの出現
    public abstract Monster encountEnemy();
}
