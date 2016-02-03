package com.everimaging.fotorsdk.collage.painter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;
import com.everimaging.fotorsdk.collage.params.BackgroundParam;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class b
        implements ICollagePainter {
    private Context a;
    private List<Path> b;
    private BackgroundParam c;
    private Drawable d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private int k = 0;

    public b(Context paramContext) {
        this.a = paramContext;
    }

    private void a() {
        if (this.c == null) {
            return;
        }
        Object localObject2 = this.c.getBackgroundInfo();
        Object localObject1 = this.c.getFeaturePack();
        this.d = null;
        if (((BackgroundInfo) localObject2).isTexture()) {
            Object localObject3 = (h.a) h.a(this.a, (FeaturePack) localObject1);
            localObject1 = new int[2];
            InputStream localInputStream = ((h.a) localObject3).b("s_" + ((BackgroundInfo) localObject2).getResName());
            BitmapDecodeUtils.decodeImageBounds(localInputStream, (int[]) localObject1);
            FotorIOUtils.closeSilently(localInputStream);
            localObject2 = ((h.a) localObject3).b(((BackgroundInfo) localObject2).getResName());
            localObject3 = BitmapDecodeUtils.decodeStream((InputStream) localObject2);
            FotorIOUtils.closeSilently((Closeable) localObject2);
            float f1 = Math.min(localObject1[0] / ((Bitmap) localObject3).getWidth(), localObject1[1] / ((Bitmap) localObject3).getHeight());
            float f2 = Math.min(this.h / this.f, this.i / this.g);
            f1 = f1 * (this.a.getResources().getDisplayMetrics().densityDpi / 320.0F) / f2;
            localObject1 = BitmapUtils.createScaleBitmap((Bitmap) localObject3, f1, f1, true);
            localObject1 = new BitmapDrawable(this.a.getResources(), (Bitmap) localObject1);
            ((BitmapDrawable) localObject1).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.d = ((Drawable) localObject1);
            return;
        }
        this.d = new ColorDrawable(Color.parseColor(((BackgroundInfo) localObject2).getColor().replace("0x", "#")));
    }

    private void a(int paramInt1, int paramInt2) {
        this.e = new Paint();
        this.e.setColor(-3355444);
        this.f = paramInt1;
        this.g = paramInt2;
        a();
    }

    private void a(Canvas paramCanvas) {
        if ((this.j > 0.0F) && (this.b != null)) {
            int m = Color.argb(255, 0, 0, 0);
            float f1 = TypedValue.applyDimension(1, this.j, this.a.getResources().getDisplayMetrics());
            this.e.setShadowLayer(f1, 0.0F, 0.0F, m);
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                paramCanvas.drawPath((Path) localIterator.next(), this.e);
            }
        }
    }

    private void b() {
        this.d = null;
    }

    private void b(Canvas paramCanvas) {
        if (this.d != null) {
            this.d.setBounds(0, 0, this.f, this.g);
            this.d.draw(paramCanvas);
        }
    }

    public void a(float paramFloat, List<Path> paramList) {
        this.j = paramFloat;
        this.b = paramList;
    }

    public void a(int paramInt) {
        this.k = paramInt;
    }

    public void a(Canvas paramCanvas, int paramInt1, int paramInt2) {
        a(paramInt1, paramInt2);
        b(paramCanvas);
        a(paramCanvas);
        b();
    }

    public void a(BackgroundParam paramBackgroundParam, int paramInt1, int paramInt2) {
        this.c = paramBackgroundParam;
        this.h = paramInt1;
        this.i = paramInt2;
    }

    public int d() {
        return this.k;
    }

    public ICollagePainter.PainterType e() {
        return ICollagePainter.PainterType.Canvas;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/painter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */