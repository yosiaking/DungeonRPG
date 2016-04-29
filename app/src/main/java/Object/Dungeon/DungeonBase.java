package Object.Dungeon;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;

public abstract class DungeonBase extends AppCompatActivity {

	protected Human h;

	//コンストラクタ
	public DungeonBase(Human human){
		this.h = human;
	}

	public abstract ArrayList<TextView> goForwardDungeon();

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
