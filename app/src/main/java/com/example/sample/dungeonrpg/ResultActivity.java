package com.example.sample.dungeonrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Intent recieveIntent;
    Intent intent;

    TextView resultName;
    TextView resultJewel;
    TextView resultFloor;
    TextView resultDistance;
    Button onceMoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recieveIntent = getIntent();
        resultName = (TextView) findViewById(R.id.resultHeroName);
        resultJewel = (TextView) findViewById(R.id.resultJewelCount);
        resultFloor = (TextView) findViewById(R.id.resultFloorCount);
        resultDistance = (TextView) findViewById(R.id.resultDistanceCount);
        onceMoreButton = (Button) findViewById(R.id.onceMore);

        String name = recieveIntent.getStringExtra(ExploreActivity.HERO_NAME);
        String jewel = String.valueOf(recieveIntent.getIntExtra(ExploreActivity.JEWEL_COUNT, 0));
        String floor = String.valueOf(recieveIntent.getIntExtra(ExploreActivity.FLOOR_COUNT, 0));
        String distance = String.valueOf(recieveIntent.getIntExtra(ExploreActivity.DISTANCE_COUNT, 0));

        resultName.setText("名前:" + name);
        resultJewel.setText("宝石:" + jewel);
        resultFloor.setText("階層:" + floor);
        resultDistance.setText("距離:" + distance);

        onceMoreButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
