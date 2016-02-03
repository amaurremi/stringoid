package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FotorSquareImageView
        extends ImageView {
    public FotorSquareImageView(Context paramContext) {
        super(paramContext);
    }

    public FotorSquareImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public FotorSquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
        setMeasuredDimension(paramInt1, paramInt1);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt1, paramInt3, paramInt4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorSquareImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */