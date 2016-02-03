package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class MagzineImageView
        extends ImageView {
    private float a;

    public MagzineImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public float getWidthRatio() {
        return this.a;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (this.a > 0.0F) {
            paramInt1 = View.MeasureSpec.getSize(paramInt2);
            setMeasuredDimension((int) (paramInt1 * this.a), paramInt1);
            return;
        }
        super.onMeasure(paramInt1, paramInt2);
    }

    public void setWidthRatio(float paramFloat) {
        if (this.a != paramFloat) {
            this.a = paramFloat;
            requestLayout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/MagzineImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */