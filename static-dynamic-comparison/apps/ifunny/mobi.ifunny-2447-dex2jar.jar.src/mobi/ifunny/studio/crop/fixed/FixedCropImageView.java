package mobi.ifunny.studio.crop.fixed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import mobi.ifunny.view.PinchImageView;

public class FixedCropImageView
        extends PinchImageView {
    private Drawable a;

    public FixedCropImageView(Context paramContext) {
        super(paramContext);
    }

    public FixedCropImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public FixedCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.a != null) {
            this.a.draw(paramCanvas);
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.a != null) {
            Rect localRect = new Rect(this.g);
            paramInt1 = Math.round(0.02F * Math.min(localRect.width(), localRect.height()));
            localRect.inset(paramInt1, paramInt1);
            this.a.setBounds(localRect);
        }
    }

    public void setCropDrawable(Drawable paramDrawable) {
        this.a = paramDrawable;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/fixed/FixedCropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */