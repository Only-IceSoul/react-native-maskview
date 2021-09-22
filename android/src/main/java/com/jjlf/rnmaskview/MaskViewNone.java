package com.jjlf.rnmaskview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;



public class MaskViewNone extends ViewGroup {

    private final Paint mPaintMask = new Paint(Paint.ANTI_ALIAS_FLAG);
    public static final PorterDuffXfermode dstIn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final PorterDuffXfermode dstOut = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    private int mBgColor  =  Color.TRANSPARENT;
    MaskViewNone(Context context){
        super(context);

    }
    public void setBgColor(int c){
        if(mBgColor != c){
            mBgColor = c;
            invalidate();
        }
    }
    @Override
    protected void dispatchDraw(Canvas canvas) {
        View child = getChildAt(0);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.saveLayer(0f,0f,getWidth(),getHeight(),null);
        canvas.drawColor(mBgColor);
        super.dispatchDraw(canvas);
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1 ){
            mPaintMask.setXfermode(dstOut);
            canvas.saveLayer(0f,0f,getWidth(),getHeight(),mPaintMask);
            canvas.drawColor(Color.BLACK);
            mPaintMask.setXfermode(dstOut);
            int clip = canvas.saveLayer(0f,0f,getWidth(),getHeight(),mPaintMask);
            child.setVisibility(View.VISIBLE);
            child.draw(canvas);
            child.setVisibility(View.INVISIBLE);
            canvas.restoreToCount(clip);
        }else{
            mPaintMask.setXfermode(dstIn);
            canvas.saveLayer(0f,0f,getWidth(),getHeight(),mPaintMask);
            child.setVisibility(View.VISIBLE);
            child.draw(canvas);
            child.setVisibility(View.INVISIBLE);
        }
        canvas.restore();
        canvas.restore();

    }


    @Override
    public void addView(View child, int index, LayoutParams params) {
        super.addView(child, index, params);
        if(index == 0){
            child.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
