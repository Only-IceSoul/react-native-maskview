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

    private Bitmap mBitmap;
    private final Canvas mCanvas = new Canvas();
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final PorterDuffXfermode mPorterDuffXferMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(mBitmap != null){
//            mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            mBitmap.eraseColor(Color.TRANSPARENT);
            View child = getChildAt(0);
            child.draw(mCanvas);
            mPaint.setXfermode(mPorterDuffXferMode);
            canvas.drawBitmap(mBitmap,0f,0f,mPaint);
            mPaint.setXfermode(null);

        }
    }



    @SuppressLint("MissingSuperCall")
    @Override
    public void onDescendantInvalidated(@NonNull View child, @NonNull View target) {
//        super.onDescendantInvalidated(child, target);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(mBitmap == null){
            mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
            mCanvas.setBitmap(mBitmap);

        }else{
            if(mBitmap.getWidth() != w || mBitmap.getHeight() != h){
                mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
                mCanvas.setBitmap(mBitmap);

            }
        }
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
