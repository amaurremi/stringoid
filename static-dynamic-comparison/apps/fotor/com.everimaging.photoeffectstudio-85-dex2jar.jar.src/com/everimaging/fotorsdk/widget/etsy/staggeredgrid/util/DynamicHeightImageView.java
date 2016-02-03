package com.everimaging.fotorsdk.widget.etsy.staggeredgrid.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class DynamicHeightImageView
        extends ImageView {
    private double a;

    public DynamicHeightImageView(Context paramContext) {
        super(paramContext);
    }

    public DynamicHeightImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public double getHeightRatio() {
        return this.a;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (this.a > 0.0D) {
            paramInt1 = View.MeasureSpec.getSize(paramInt1);
            setMeasuredDimension(paramInt1, (int) (paramInt1 * this.a));
            return;
        }
        super.onMeasure(paramInt1, paramInt2);
    }

    public void setHeightRatio(double paramDouble) {
        if (paramDouble != this.a) {
            this.a = paramDouble;
            requestLayout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/etsy/staggeredgrid/util/DynamicHeightImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */