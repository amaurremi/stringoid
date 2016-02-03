package com.everimaging.fotor.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class CameraContainer
        extends RelativeLayout {
    private a a;
    private View b;

    public CameraContainer(Context paramContext) {
        super(paramContext);
    }

    public CameraContainer(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public CameraContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        if ((paramMotionEvent.getAction() == 0) && (this.b != null)) {
            Rect localRect = new Rect();
            this.b.getDrawingRect(localRect);
            int[] arrayOfInt = new int[2];
            this.b.getLocationOnScreen(arrayOfInt);
            localRect.offset(arrayOfInt[0], arrayOfInt[1]);
            if (!localRect.contains((int) paramMotionEvent.getX(), (int) paramMotionEvent.getY())) {
                if (this.a != null) {
                    this.a.onTouchOutside(this.b);
                }
                return true;
            }
        }
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    public void setDummyPopupView(View paramView) {
        this.b = paramView;
    }

    public void setTouchOutsideListener(a parama) {
        this.a = parama;
    }

    public static abstract interface a {
        public abstract void onTouchOutside(View paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/CameraContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */