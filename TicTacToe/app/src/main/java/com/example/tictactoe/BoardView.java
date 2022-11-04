package com.example.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import org.jetbrains.annotations.Nullable;

public class BoardView extends View {
    private static final int LINE_THICK = 5;
    private static final int ELEMENT_MARGIN = 50;
    private static final int ELEMENT_STROKE_WIDTH = 15;
    private int width, height, elementWidth, elementHeight;
    private Paint gridPaint, oPaint, xPaint;
    private GameEngine gameEngine;
    private MainActivity activity;

    public BoardView(Context context) {
        super(context);
    }

    public BoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        gridPaint = new Paint();
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(ELEMENT_STROKE_WIDTH);
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.BLUE);
    }

    public void setMainActivity(MainActivity a) {
        activity = a;
    }

    public void setGameEngine(GameEngine g) {
        gameEngine = g;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = View.MeasureSpec.getSize(widthMeasureSpec);
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        elementWidth = (width - LINE_THICK) / 3;
        elementHeight = (height - LINE_THICK) / 3;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
        drawBoard(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!gameEngine.isEnded() && event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) (event.getX() / elementWidth);
            int y = (int) (event.getY() / elementHeight);
            char win = gameEngine.play(x, y);
            invalidate();

            if (win != ' ') {
                activity.gameEnded(win);
            } else {
                //computer plays...
                win = gameEngine.computer();
                invalidate();

                if (win != ' ') {
                    activity.gameEnded(win);
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void drawBoard(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                drawElement(canvas, gameEngine.getElement(i, j), i, j);
            }
        }
    }

    private void drawGrid(Canvas canvas) {
        for (int i = 0; i < 2; i++) {
            // vertical lines
            float left = elementWidth * (i + 1);
            float right = left + LINE_THICK;
            float top = 0;
            float bottom = height;

            canvas.drawRect(left, top, right, bottom, gridPaint);

            //horizintal lines
            float left2 = 0;
            float right2 = width;
            float top2 = elementHeight * (i + 1);
            float bottom2 = top2 + LINE_THICK;

            canvas.drawRect(left2, top2, right2, bottom2, gridPaint);
        }
    }

    private void drawElement(Canvas canvas, char c, int x, int y) {
        if (c == 'O') {
            float cx = (elementWidth * x) + elementWidth / 2;
            float cy = (elementHeight * y) + elementHeight / 2;

            canvas.drawCircle(cx, cy, Math.min(elementWidth, elementHeight) / 2 - ELEMENT_MARGIN * 2, oPaint);
        } else if (c == 'X') {
            float startX = (elementWidth * x) + ELEMENT_MARGIN;
            float startY = (elementHeight * y) + ELEMENT_MARGIN;
            float endX = startX + elementWidth - ELEMENT_MARGIN * 2;
            float endY = startY + elementHeight - ELEMENT_MARGIN;

            canvas.drawLine(startX, startY, endX, endY, xPaint);

            float startX2 = (elementWidth * (x + 1)) - ELEMENT_MARGIN;
            float startY2 = (elementHeight * y) + ELEMENT_MARGIN;
            float endX2 = startX2 - elementWidth + ELEMENT_MARGIN * 2;
            float endY2 = startY2 + elementHeight - ELEMENT_MARGIN;

            canvas.drawLine(startX2, startY2, endX2, endY2, xPaint);
        }
    }
}