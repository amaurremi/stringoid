package com.everimaging.fotor.discovery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class DiscoveryImageView
        extends ImageView {
    private double a = 1.0D;

    public DiscoveryImageView(Context paramContext) {
        super(paramContext);
    }

    public DiscoveryImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public DiscoveryImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/widget/DiscoveryImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */