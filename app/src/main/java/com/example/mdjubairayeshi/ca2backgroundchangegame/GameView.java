package com.example.mdjubairayeshi.ca2backgroundchangegame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Md Jubair Ayeshi on 02-11-2017.
 */

public class GameView extends SurfaceView {
    SurfaceHolder sh;


    Bitmap background[] = new Bitmap[3];
    int x = 0;
    MyThread mt;


    GameView(Context c) {
        super(c);

        sh = getHolder();
        mt = new MyThread(this);
        sh.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                Canvas c = sh.lockCanvas();
                onDraw(c);
                sh.unlockCanvasAndPost(c);
                mt.isrunning(true);
                mt.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        background[0] = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background[1] = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
        background[2] = BitmapFactory.decodeResource(getResources(), R.drawable.background1);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Rect r1 = new Rect(0, 0, background[x].getWidth(), background[x].getHeight());
        Rect r2 = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.drawBitmap(background[x], r1, r2, null);


        x = x + 1;
        if (x == 3) {
            x = 0;
        }
    }

}
