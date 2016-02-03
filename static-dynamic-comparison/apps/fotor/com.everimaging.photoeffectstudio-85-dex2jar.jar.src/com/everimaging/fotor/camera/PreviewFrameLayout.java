package com.everimaging.fotor.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

public class PreviewFrameLayout
        extends RelativeLayout {
    private static final String a = PreviewFrameLayout.class.getSimpleName();
    private LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private double c;

    public PreviewFrameLayout(Context paramContext) {
        super(paramContext);
        a();
    }

    public PreviewFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    public PreviewFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    void a() {
        setAspectRatio(1.3333333333333333D);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if (i > paramInt1 * this.c) {
        }
        for (paramInt2 = (int) (paramInt1 * this.c + 0.5D); ; paramInt2 = i) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
            return;
            paramInt1 = (int) (i / this.c + 0.5D);
        }
    }

    public void setAspectRatio(double paramDouble) {
        this.b.c(new Object[]{"setAspectRatio before:" + paramDouble});
        if (paramDouble <= 0.0D) {
            throw new IllegalArgumentException();
        }
        double d = paramDouble;
        if (((Activity) getContext()).getRequestedOrientation() == 1) {
            d = 1.0D / paramDouble;
        }
        this.b.c(new Object[]{"setAspectRatio  after:" + d});
        if (this.c != d) {
            this.c = d;
            requestLayout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/PreviewFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */