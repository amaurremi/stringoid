package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

public class CountdownDrawable
        extends CircleDrawable
        implements TextDrawable {
    private final Paint a = new Paint();
    private String b = "";
    private final float c;
    private Rect d;

    public CountdownDrawable(Context paramContext) {
        this.c = Dips.dipsToFloatPixels(18.0F, paramContext);
        this.a.setTextSize(this.c);
        this.a.setAntiAlias(true);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextAlign(Paint.Align.LEFT);
        this.d = new Rect();
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        String str = String.valueOf(this.b);
        this.a.getTextBounds(str, 0, str.length(), this.d);
        int i = b();
        int j = this.d.width() / 2;
        int k = c();
        int m = this.d.height() / 2;
        paramCanvas.drawText(str, i - j, k + m, this.a);
    }

    public void updateText(String paramString) {
        if (!this.b.equals(paramString)) {
            this.b = paramString;
            invalidateSelf();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/resource/CountdownDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */