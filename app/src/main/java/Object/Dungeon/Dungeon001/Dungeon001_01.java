package Object.Dungeon.Dungeon001;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Gameplay.Explore.Event.Event;
import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;
import Object.Dungeon.DungeonBase;

public class Dungeon001_01 extends DungeonBase {
	
	public Dungeon001_01(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}

	//BgImgName
	private int bgImgName = R.drawable.dungeon001;

	//ダンジョンを進む選択時のイベント
	public ArrayList<TextView> goForwardDungeon() {
		// TODO Auto-generated method stub

		//表示用String配列
		ArrayList<TextView> arrayList;
		arrayList = new ArrayList<TextView>();
		//出現モンスター用変数

		//距離 階層 進行
		arrayList.addAll(goForward());


		//イベントの確率計算
		int eventNum = new java.util.Random().nextInt(100);

		if(eventNum >= 0 && eventNum < 40){
		//何も起きない(40%)
		}else if(eventNum >= 40 && eventNum < 65){
		//バトルフラッグtrue(25%)
			Human.setBattleFlag(true);
		}else if(eventNum >=65  && eventNum < 95){
		//宝石を拾う(30%)
			arrayList.addAll(Event.getJewelEvent(h, 1, 2));
		}else if(eventNum >= 95 && eventNum < 97){
		//泉を発見HPMP回復(5%)
			arrayList.addAll(Event.recoverEvent01(h));
		}else if(eventNum >= 97 && eventNum < 100){
			//泉を発見HPMP回復(5%)
			arrayList.addAll(Event.trapEvent02(h));
		}

		//10ごとに階層が上がる(下がる)
		if(Human.getDistance() % 10 == 0){
			TextView floorText = new TextView(MainActivity.getContext());
			floorText.setText(h.getName() + "は、階段を降りた。" + "\r\n");
			arrayList.add(floorText);
			Human.forwardDungeonFloor(1);
		}

		return arrayList;

	}

	//モンスターエンカウント
	//モンスターの出現
	public Monster encountEnemy(){
		Monster m = Event.battleEvent(4);
		return m;
	}

	public int getBgImgName(){
		return bgImgName;
	}
}
