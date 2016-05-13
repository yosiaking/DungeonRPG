package Object.Dungeon;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sample.dungeonrpg.MainActivity;

import java.util.ArrayList;

import Gameplay.Explore.Event.Event;
import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

public abstract class DungeonBase extends AppCompatActivity {

	protected Human h;

	protected int bgImgName;

	protected String dungeonName;

	protected String dungeonType;

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


	public void setDungeonName(String name){
		this.dungeonName = name;
	}

	//ゲッターダンジョンネーム
	public String getDungeonName()
	{
		return this.dungeonName;
	}

	public void setDungeonType(String type){
		this.dungeonName = type;
	}

	//ゲッターダンジョンクラス
	public String getDungeonType(){
		return this.dungeonType;
	}

	public ArrayList<TextView> noEvent(Human h){

		ArrayList<TextView> a;
		int r = new java.util.Random().nextInt(100) + 1;

		if (r <= 2){
			a = Event.nonEvent01(h);
		}else if(r <= 4){
			a = Event.nonEvent02(h);
		}else if(r <= 6){
			a = Event.nonEvent03(h);
		}else if(r <= 8){
			a = Event.nonEvent04(h);
		}else if(r <= 10){
			a = Event.nonEvent05(h);
		}else if(r <= 12){
			a = Event.nonEvent06(h);
		}else if(r <= 14){
			a = Event.nonEvent07(h);
		}else if(r <= 16){
			a = Event.nonEvent08(h);
		}else if(r <= 18){
			a = Event.nonEvent09(h);
		}else if(r <= 20){
			a = Event.nonEvent10(h);
		}else if(r <= 22){
			a = Event.nonEvent11(h);
		}else if(r <= 24){
			a = Event.nonEvent12(h);
		}else if(r <= 26){
			a = Event.nonEvent13(h);
		}else if(r <= 28){
			a = Event.nonEvent14(h);
		}else if(r <= 30){
			a = Event.nonEvent15(h);
		}else if(r <= 32){
			a = Event.nonEvent16(h);
		}else if(r <= 34){
			a = Event.nonEvent17(h);
		}else if(r <= 36){
			a = Event.nonEvent18(h);
		}else if(r <= 38){
			a = Event.nonEvent19(h);
		}else if(r <= 40){
			a = Event.nonEvent20(h);
		}else{
			a = Event.nonEvent00(h);
		}

		return a;

	}

}
