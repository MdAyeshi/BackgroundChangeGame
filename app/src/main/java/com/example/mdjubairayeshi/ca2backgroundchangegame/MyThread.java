package com.example.mdjubairayeshi.ca2backgroundchangegame;

import android.annotation.SuppressLint;
import android.graphics.Canvas;

/**
 * Created by Md Jubair Ayeshi on 02-11-2017.
 */

public class MyThread extends Thread {

    boolean flag = false;
    GameView gameView;

    MyThread(GameView gv) {
        gameView = gv;
    }

    void isrunning(boolean flag) {
        this.flag = flag;
    }


    @SuppressLint("WrongCall")
    @Override
    public void run() {

        while (flag) {
            Canvas c = null;
            try {

                Thread.sleep(2000);
                synchronized (gameView.getHolder()) {
                    c = gameView.getHolder().lockCanvas();
                    gameView.onDraw(c);

                }
            } catch (Exception e) {
            } finally {
                gameView.getHolder().unlockCanvasAndPost(c);
            }


        }
    }
}
