package com.everimaging.fotorsdk.imagepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import com.everimaging.fotorsdk.collage.R.color;
import com.everimaging.fotorsdk.collage.R.drawable;

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
        this.b.setColor(paramContext.getResources().getColor(R.color.fotor_image_picker_grid_item_mask_pressed_color));
        this.c = ((NinePatchDrawable) getResources().getDrawable(R.drawable.fotor_image_picker_grid_item_frame));
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
        this.c.setBounds(0, 0, getWidth(), getHeight());
        this.c.draw(paramCanvas);
        if ((!this.a) || (isPressed())) {
            paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/AlbumImageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */