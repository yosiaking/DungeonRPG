package Gameplay.Explore.Event;

import android.widget.TextView;

import com.example.sample.dungeonrpg.ExploreActivity;

import java.util.ArrayList;

import Object.Character.CreatureType.Human;
import Object.Character.CreatureType.Monster;

public class Battle {

	public static ArrayList<TextView> encountEnemy(Monster m) {

		//コンテキストビュー生成
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		TextView textView = new TextView(ExploreActivity.getContext());

		textView.setText(m.getName() + "が現れた！");
		arrayList.add(textView);

		return arrayList;
	}


	public static ArrayList<TextView> enemyAction(Human h, Monster m){
		ArrayList<TextView> arrayList = new ArrayList<TextView>();
		arrayList.addAll(m.action(h));
		return arrayList;
	}


}