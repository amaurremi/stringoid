package com.everimaging.fotor.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class CameraFrameLayout
        extends RelativeLayout {
    public CameraFrameLayout(Context paramContext) {
        super(paramContext);
    }

    public CameraFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public CameraFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if (paramInt1 > paramInt2) {
            paramInt1 = paramInt2;
        }
        for (; ; ) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
            return;
            paramInt2 = paramInt1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */