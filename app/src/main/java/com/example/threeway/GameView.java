package com.example.threeway;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {
    private Board board;

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public Board getBoard() {
        return board;
    }


    private void init(AttributeSet attrs, int defStyle) {
        board = new Board(getContext());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        board.draw(canvas);

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
    }

    public void move(String direction){
        Board bd = getBoard();
        boolean valid = bd.onMove(direction);
        boolean space = bd.space();
        if(valid && space) {
            bd.randomize();
        }
        space = bd.space();
        if(!space){
            boolean result = bd.moveCheck();
            if(!result){
                bd.failState();
            }
        }
        invalidate();
    }
}
