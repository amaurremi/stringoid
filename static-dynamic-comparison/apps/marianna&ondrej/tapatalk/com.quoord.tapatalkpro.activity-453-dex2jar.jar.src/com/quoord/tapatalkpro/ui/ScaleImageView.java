package com.quoord.tapatalkpro.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.adapter.forum.ViewPagerAdapter;

@SuppressLint({"WrongCall"})
public class ScaleImageView
        extends ImageView {
    DisplayMetrics dm;
    ViewPagerAdapter mAdapter;
    float minScaleR;

    public ScaleImageView(Context paramContext) {
        super(paramContext);
        initial();
    }

    public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initial();
    }

    public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initial();
    }

    protected void center(boolean paramBoolean1, boolean paramBoolean2, Matrix paramMatrix) {
        Matrix localMatrix = new Matrix();
        localMatrix.set(paramMatrix);
        float f2;
        int i;
        if (this.minScaleR == 0.0F) {
            this.minScaleR = Math.min(((LinearLayout) getParent()).getMeasuredWidth() / ((BitmapDrawable) getDrawable()).getBitmap().getWidth(), ((LinearLayout) getParent()).getMeasuredHeight() / ((BitmapDrawable) getDrawable()).getBitmap().getHeight());
            if (this.minScaleR > 2.0F) {
                this.minScaleR = 2.0F;
            }
            Object localObject = new float[9];
            paramMatrix.getValues((float[]) localObject);
            if (localObject[0] < this.minScaleR) {
                paramMatrix.setScale(this.minScaleR, this.minScaleR);
            }
            f1 = ((BitmapDrawable) getDrawable()).getBitmap().getWidth();
            localObject = new RectF(0.0F, 0.0F, this.minScaleR * f1, ((BitmapDrawable) getDrawable()).getBitmap().getHeight() * this.minScaleR);
            localMatrix.mapRect((RectF) localObject);
            float f5 = ((RectF) localObject).height();
            float f4 = ((RectF) localObject).width();
            f1 = 0.0F;
            float f3 = 0.0F;
            f2 = f3;
            if (paramBoolean2) {
                i = this.dm.heightPixels;
                f2 = f3;
                if (f5 < i) {
                    f2 = (i - f5) / 2.0F;
                }
            }
            if (paramBoolean1) {
                i = this.dm.widthPixels;
                if (f4 < i) {
                    f1 = (i - f4) / 2.0F;
                }
            } else {
                paramMatrix.postTranslate(f1, f2);
            }
        }
        label449:
        label495:
        do {
            for (; ; ) {
                return;
                f1 = 0.0F;
                break;
                paramMatrix = new RectF(0.0F, 0.0F, ((BitmapDrawable) getDrawable()).getBitmap().getWidth(), ((BitmapDrawable) getDrawable()).getBitmap().getHeight());
                localMatrix.mapRect(paramMatrix);
                f2 = paramMatrix.height();
                f1 = paramMatrix.width();
                if (paramBoolean2) {
                    i = ((View) getParent()).getHeight();
                    if (f2 >= i) {
                        break label449;
                    }
                    f2 = (i - f2) / 2.0F;
                    f2 = paramMatrix.top;
                }
                while (paramBoolean1) {
                    i = this.dm.widthPixels;
                    if (f1 >= i) {
                        break label495;
                    }
                    f1 = new Float((i - f1) / 2.0F - paramMatrix.left).intValue();
                    return;
                    if (paramMatrix.top > 0.0F) {
                        f2 = -paramMatrix.top;
                    } else if (paramMatrix.bottom < i) {
                        f2 = getMeasuredHeight();
                        f2 = paramMatrix.bottom;
                    }
                }
            }
            if (paramMatrix.left > 0.0F) {
                f1 = -paramMatrix.left;
                return;
            }
        } while (paramMatrix.right >= i);
        float f1 = i;
        f1 = paramMatrix.right;
    }

    public void draw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        center(true, true, getImageMatrix());
    }

    public void initial() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.dm = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }

    public void setAdapter(ViewPagerAdapter paramViewPagerAdapter) {
        this.mAdapter = paramViewPagerAdapter;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ScaleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */