package uk.co.chrisjenx.paralloid.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public class a
        extends Drawable {
    private final Drawable a;
    private float b;
    private int c;
    private int d;
    private float e;
    private float f;

    public void a(float paramFloat1, float paramFloat2) {
        this.e = (this.b * paramFloat1);
        this.f = (this.b * paramFloat2);
    }

    public void draw(Canvas paramCanvas) {
        paramCanvas.translate(-this.e, -this.f);
        this.a.draw(paramCanvas);
        paramCanvas.translate(this.e, this.f);
    }

    public Drawable.ConstantState getConstantState() {
        return this.a.getConstantState();
    }

    public int getIntrinsicHeight() {
        return 0;
    }

    public int getIntrinsicWidth() {
        return 0;
    }

    public int getMinimumHeight() {
        return 0;
    }

    public int getMinimumWidth() {
        return 0;
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean getPadding(Rect paramRect) {
        return this.a.getPadding(paramRect);
    }

    public int[] getState() {
        return this.a.getState();
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.a.invalidateSelf();
    }

    public boolean isStateful() {
        return this.a.isStateful();
    }

    @TargetApi(11)
    public void jumpToCurrentState() {
        this.a.jumpToCurrentState();
    }

    public Drawable mutate() {
        return this.a.mutate();
    }

    protected void onBoundsChange(Rect paramRect) {
        this.a.setBounds(paramRect.left, paramRect.top, paramRect.left + this.c, paramRect.top + this.d);
    }

    public void setAlpha(int paramInt) {
        this.a.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.a.setColorFilter(paramColorFilter);
    }

    public boolean setState(int[] paramArrayOfInt) {
        super.setState(paramArrayOfInt);
        return this.a.setState(paramArrayOfInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */