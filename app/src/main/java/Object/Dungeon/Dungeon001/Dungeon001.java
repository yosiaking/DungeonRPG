package Object.Dungeon.Dungeon001;

import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;
import com.example.sample.dungeonrpg.R;

import java.util.ArrayList;

import Gameplay.Explore.Event.Event;
import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;
import Object.Dungeon.DungeonType.Cave;

public class Dungeon001 extends Cave {
	
	public Dungeon001(Human human) {
		super(human);
		super.dungeonName = "はじまりの洞窟";
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

		if(eventNum < 40){
			//何も起きない(40%)
			arrayList.addAll(noEvent(h));

		}else if(eventNum < 65){
			//モンスターとのエンカウント(20%)
			Event.encountEnemy();

		}else if(eventNum < 85){
			//宝石を拾う(20%)
			arrayList.addAll(getJewel(h));

		}else if(eventNum < 92){
			//回復イベント
			arrayList.addAll(getPositiveTrap(h));

		}else if(eventNum < 100){
			//トラップイベント
			arrayList.addAll(getNegativeTrap(h));
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



	//階層ごとのモンスターエンカウント
	public Monster encountEnemy(){
		Monster m;
		if(Human.getDungeonFloor() == 1){
			m = Event.battleEvent(1);
		}else if(Human.getDungeonFloor() == 2){
			m = Event.battleEvent(2);
		}else if(Human.getDungeonFloor() == 3){
			m = Event.battleEvent(3);
		}else if(Human.getDungeonFloor() == 4){
			m = Event.battleEvent(4);
		}else{
			m = Event.battleEvent(5);
		}
		return m;
	}


	//階層ごとの宝石個数
	public ArrayList<TextView> getJewel(Human h){
		ArrayList<TextView> a;

		if(Human.getDungeonFloor() == 1){
			a = Event.getJewelEvent(h, 1, 1);

		}else if(Human.getDungeonFloor() == 2){
			a = Event.getJewelEvent(h, 1, 2);

		}else if(Human.getDungeonFloor() == 3){
			a = Event.getJewelEvent(h, 2, 2);

		}else if(Human.getDungeonFloor() == 4){
			a = Event.getJewelEvent(h, 3, 1);

		}else{
			a = Event.getJewelEvent(h, 3, 2);
		}
		return a;
	}


	//階層ごとのポジティブトラップ
	public ArrayList<TextView> getPositiveTrap(Human h){
		ArrayList<TextView> a;

		if(Human.getDungeonFloor() == 1){
			a = Event.recoverEvent01(h);

		}else if(Human.getDungeonFloor() == 2){
			a = Event.recoverEvent02(h);

		}else if(Human.getDungeonFloor() == 3){
			a = Event.recoverEvent03(h);

		}else if(Human.getDungeonFloor() == 4){
			a = Event.recoverEvent04(h);

		}else{
			a = Event.recoverEvent99(h);
		}
		return a;
	}


	//階層ごとのネガティブトラップ
	public ArrayList<TextView> getNegativeTrap(Human h){
		ArrayList<TextView> a;

		if(Human.getDungeonFloor() == 1){
			a = Event.trapEvent01(h);

		}else if(Human.getDungeonFloor() == 2){
			a = Event.trapEvent02(h);

		}else if(Human.getDungeonFloor() == 3){
			a = Event.trapEvent03(h);

		}else if(Human.getDungeonFloor() == 4){
			a = Event.trapEvent04(h);

		}else{
			a = Event.trapEvent99(h);
		}
		return a;
	}


	//



	public int getBgImgName(){
		return bgImgName;
	}


}
