package com.everimaging.fotorsdk.uil.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;

public class c
        implements a {
    protected final int a;
    protected final int b;

    public c(int paramInt) {
        this(paramInt, 0);
    }

    public c(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.b = paramInt2;
    }

    public void a(Bitmap paramBitmap, com.everimaging.fotorsdk.uil.core.imageaware.a parama, LoadedFrom paramLoadedFrom) {
        if (!(parama instanceof com.everimaging.fotorsdk.uil.core.imageaware.c)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        parama.a(new a(paramBitmap, this.a, this.b));
    }

    protected static class a
            extends Drawable {
        protected final float a;
        protected final int b;
        protected final RectF c = new RectF();
        protected final BitmapShader d;
        protected final Paint e;

        a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
            this.a = paramInt1;
            this.b = paramInt2;
            this.d = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.e = new Paint();
            this.e.setAntiAlias(true);
            this.e.setShader(this.d);
        }

        public void draw(Canvas paramCanvas) {
            paramCanvas.drawRoundRect(this.c, this.a, this.a, this.e);
        }

        public int getOpacity() {
            return -3;
        }

        protected void onBoundsChange(Rect paramRect) {
            super.onBoundsChange(paramRect);
            this.c.set(this.b, this.b, paramRect.width() - this.b, paramRect.height() - this.b);
        }

        public void setAlpha(int paramInt) {
            this.e.setAlpha(paramInt);
        }

        public void setColorFilter(ColorFilter paramColorFilter) {
            this.e.setColorFilter(paramColorFilter);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/display/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */