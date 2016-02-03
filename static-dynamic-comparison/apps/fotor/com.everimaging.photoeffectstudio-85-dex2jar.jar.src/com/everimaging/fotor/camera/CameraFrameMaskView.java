package com.everimaging.fotor.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CameraFrameMaskView
        extends RelativeLayout {
    private ImageView a;
    private Paint b;

    public CameraFrameMaskView(Context paramContext) {
        super(paramContext);
        a();
    }

    public CameraFrameMaskView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    private void a() {
        this.b = new Paint();
        this.b.setColor(getResources().getColor(2131493041));
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903082, this, true);
        this.a = ((ImageView) findViewById(2131558512));
        setWillNotDraw(false);
    }

    public Rect getFrameBounds() {
        int[] arrayOfInt = new int[2];
        this.a.getLocationInWindow(arrayOfInt);
        Rect localRect = new Rect();
        localRect.top = (this.a.getTop() + arrayOfInt[1]);
        int i = this.a.getLeft();
        localRect.left = (arrayOfInt[0] + i);
        localRect.bottom = (localRect.top + this.a.getHeight());
        localRect.right = (localRect.left + this.a.getWidth());
        return localRect;
    }

    protected void onDraw(Canvas paramCanvas) {
        int[] arrayOfInt1 = new int[2];
        this.a.getLocationInWindow(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        getLocationInWindow(arrayOfInt2);
        int i = arrayOfInt1[1] - arrayOfInt2[1];
        int j = arrayOfInt1[0] - arrayOfInt2[0];
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), i, this.b);
        paramCanvas.drawRect(0.0F, i, j, this.a.getHeight() + i, this.b);
        paramCanvas.drawRect(0.0F, this.a.getHeight() + i, getWidth(), getHeight(), this.b);
        paramCanvas.drawRect(this.a.getWidth() + j, i, getWidth(), this.a.getHeight() + i, this.b);
        super.onDraw(paramCanvas);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraFrameMaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */