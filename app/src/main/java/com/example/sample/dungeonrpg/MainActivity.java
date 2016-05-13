package com.example.sample.dungeonrpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b ;
    private Intent intent ;
    private int clearJewelCount;
    public static final String CLEAR_JEWEL = "com.example.sample.dungeonrpg.clear.jewel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.exploreFree);
        b.setOnClickListener(this);

    }

    public void onClick(View v){

        clearJewelCount = 5;
        intent = new Intent(this, ExploreActivity.class);
        intent.putExtra(CLEAR_JEWEL, clearJewelCount);
        startActivity(intent);
    }


}
