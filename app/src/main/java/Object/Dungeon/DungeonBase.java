package Object.Dungeon;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

public abstract class DungeonBase extends AppCompatActivity {

	protected Human h;

	protected int bgImgName;

	//コンストラクタ
	public DungeonBase(Human human){
		this.h = human;
	}

	public abstract ArrayList<TextView> goForwardDungeon();

	public abstract int getBgImgName();

	//モンスターの出現
	public abstract Monster encountEnemy();


	//奥に進む
	public ArrayList<TextView> goForward(){

		//表示用String配列
		ArrayList<TextView> arrayList;
		arrayList = new ArrayList<TextView>();

		//距離をひとつ進める
		Human.forwardDistance(1);

		//テキスト
		TextView goText = new TextView(MainActivity.getContext());
		goText.setText(h.getName() + "は奥へと進んだ。" + "\r\n");
		arrayList.add(goText);

		//MP1回復
		if(h.getMp() < h.getMaxMp()){
			h.recoverMp(1);	
		}

		return arrayList;
	}

}
