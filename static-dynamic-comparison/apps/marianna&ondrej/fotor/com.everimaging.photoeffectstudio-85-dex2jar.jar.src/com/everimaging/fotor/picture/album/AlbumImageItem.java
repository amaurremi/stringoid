package com.everimaging.fotor.picture.album;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Checkable;
import android.widget.ImageView;

public class AlbumImageItem
        extends ImageView
        implements Checkable {
    private boolean a = false;
    private Paint b;
    private NinePatchDrawable c;

    public AlbumImageItem(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public AlbumImageItem(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext);
    }

    public AlbumImageItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    private void a(Context paramContext) {
        setFocusable(true);
        this.b = new Paint(1);
        this.b.setColor(paramContext.getResources().getColor(2131493069));
        this.c = ((NinePatchDrawable) getResources().getDrawable(2130837596));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public boolean isChecked() {
        return this.a;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        try {
            this.c.setBounds(0, 0, getWidth(), getHeight());
            this.c.draw(paramCanvas);
            if (!this.a) {
            }
        } catch (Exception localException1) {
            try {
                Drawable localDrawable = getResources().getDrawable(2130837691);
                localDrawable.setBounds(getWidth() - localDrawable.getIntrinsicWidth(), getHeight() - localDrawable.getIntrinsicHeight(), getWidth(), getHeight());
                localDrawable.draw(paramCanvas);
                if (isPressed()) {
                    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
                }
                return;
                localException1 = localException1;
                Log.e("View", "error :" + localException1.getMessage());
            } catch (Exception localException2) {
                for (; ; ) {
                    Log.e("View", "error :" + localException2.getMessage());
                }
            }
        }
    }

    public void setChecked(boolean paramBoolean) {
        this.a = paramBoolean;
        invalidate();
    }

    public void toggle() {
        if (!this.a) {
        }
        for (boolean bool = true; ; bool = false) {
            setChecked(bool);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/AlbumImageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */