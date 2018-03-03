package com.example.mdjubairayeshi.ca2backgroundchangegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button b1;
    ImageView iv;
    GameView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gv = new GameView(this);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        b1 = (Button) findViewById(R.id.but0);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(gv);

            }
        });

    }
}
