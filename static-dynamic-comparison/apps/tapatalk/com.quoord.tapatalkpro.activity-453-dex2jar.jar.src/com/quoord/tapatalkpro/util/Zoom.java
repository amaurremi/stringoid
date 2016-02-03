package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;

public class Zoom
        extends View {
    private Drawable image;
    private int zoomControler = 20;

    public Zoom(Context paramContext) {
        super(paramContext);
        setFocusable(true);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.image.setBounds(getWidth() / 2 - this.zoomControler, getHeight() / 2 - this.zoomControler, getWidth() / 2 + this.zoomControler, getHeight() / 2 + this.zoomControler);
        this.image.draw(paramCanvas);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 19) {
            this.zoomControler += 10;
        }
        if (paramInt == 20) {
            this.zoomControler -= 10;
        }
        if (this.zoomControler < 10) {
            this.zoomControler = 10;
        }
        invalidate();
        return true;
    }

    public void setImage(Drawable paramDrawable) {
        this.image = paramDrawable;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/Zoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */