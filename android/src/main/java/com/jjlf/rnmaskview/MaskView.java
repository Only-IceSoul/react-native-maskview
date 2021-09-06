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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class MaskView extends ViewGroup {


    MaskView(Context context){
        super(context);
        setClipChildren(false);
        setLayerType(LAYER_TYPE_HARDWARE,null);

    }

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final PorterDuffXfermode mPorterDuffXferMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    @Override
    protected void dispatchDraw(Canvas canvas) {
        View child = getChildAt(0);
        super.dispatchDraw(canvas);
        if(child != null){
            mPaint.setXfermode(mPorterDuffXferMode);
            canvas.saveLayer(0f,0f,getWidth(),getHeight(),mPaint);
            child.draw(canvas);
            canvas.restore();
        }

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
