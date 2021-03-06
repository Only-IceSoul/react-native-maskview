package com.jjlf.rnmaskview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class MaskView extends ViewGroup {

    private final Paint mPaintMask = new Paint(Paint.ANTI_ALIAS_FLAG);
    public static final PorterDuffXfermode dstIn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final PorterDuffXfermode dstOut = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    MaskView(Context context){
        super(context);
        setLayerType(LAYER_TYPE_HARDWARE,null);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        View child = getChildAt(0);
        super.dispatchDraw(canvas);
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1){
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

    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onDescendantInvalidated(@NonNull View child, @NonNull View target) {
//        super.onDescendantInvalidated(child, target);
        invalidate();
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
