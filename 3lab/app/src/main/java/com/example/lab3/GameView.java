package com.example.lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {
    private Bitmap background;
    private Paint endgameWin;
    private Paint endgameLose;
    private Paint score;
    private Paint score2;

    BugLogic bugLogic;
    Paint style;
    boolean isStop = false;
    String str = "";
    long timer = 0;

    public GameView(Context context) {
        super(context);
        this.bugLogic = new BugLogic(10, this);

        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.wallpaper);
        score = new Paint();
        score.setColor(Color.WHITE);
        score.setTextAlign(Paint.Align.CENTER);
        score.setTextSize(75);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);

        score2 = new Paint();
        score2.setColor(Color.WHITE);
        score2.setTextAlign(Paint.Align.CENTER);
        score2.setTextSize(75);
        score2.setTypeface(Typeface.DEFAULT_BOLD);
        score2.setAntiAlias(true);

        endgameLose = new Paint();
        endgameLose.setColor(Color.WHITE);
        endgameLose.setTextAlign(Paint.Align.CENTER);
        endgameLose.setTextSize(120);
        endgameLose.setTypeface(Typeface.DEFAULT_BOLD);
        endgameLose.setAntiAlias(true);

        endgameWin = new Paint();
        endgameWin.setColor(Color.WHITE);
        endgameWin.setTextAlign(Paint.Align.CENTER);
        endgameWin.setTextSize(120);
        endgameWin.setTypeface(Typeface.DEFAULT_BOLD);
        endgameWin.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isStop){
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawText(str, getWidth() / (float) 2, 200, style);
            if (System.currentTimeMillis() > timer + 4000)
            {
                isStop = false;
                bugLogic.points = 0;
            }
            return;
        }
        if (bugLogic.points < 150 && bugLogic.points >= -20) {
            super.onDraw(canvas);
            bugLogic.update();
            int sc = bugLogic.points;
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawText("Счет: " + sc, getWidth() / (float) 2, 80, score);
            bugLogic.drawBugs(canvas);
        }else if (bugLogic.points>=150)
        {
            super.onDraw(canvas);
            timer = System.currentTimeMillis();
            isStop = true;
            str = "Победа";
            int vv = bugLogic.points;
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawText("Счет: " + vv, getWidth() / (float) 2, 80, score);
            style = endgameWin;

        }else
        {
            super.onDraw(canvas);
            timer = System.currentTimeMillis();
            isStop = true;
            str = "Вы проиграли";
            int gg = bugLogic.points;
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawText("Счет: " + gg, getWidth() / (float) 2, 80, score);

            style = endgameLose;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float eventX = event.getX();
            float eventY = event.getY();
            bugLogic.touchEvent(eventX, eventY);
        }
        return true;
    }
}