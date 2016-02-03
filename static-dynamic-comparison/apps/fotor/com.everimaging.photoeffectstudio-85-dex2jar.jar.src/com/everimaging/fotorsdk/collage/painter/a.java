package com.everimaging.fotorsdk.collage.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.collage.entity.Attachment;
import com.everimaging.fotorsdk.collage.entity.Attachment.ColorDrawableType;
import com.everimaging.fotorsdk.plugins.g;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

import java.io.Closeable;
import java.io.InputStream;

public class a
        implements ICollagePainter {
    private Context a;
    private Attachment b;
    private float c = 1.0F;
    private h.a d;
    private StaticLayout e;
    private Typeface f;
    private int g;
    private BitmapDrawable h;
    private RectF i;
    private int j = 0;
    private boolean k = false;

    public a(Context paramContext, Attachment paramAttachment, h.a parama, float paramFloat) {
        this.a = paramContext;
        this.b = paramAttachment;
        this.d = parama;
        this.c = paramFloat;
        g();
    }

    private void b(Canvas paramCanvas, boolean paramBoolean) {
        int m = this.b.getAngle();
        int n = this.e.getWidth();
        int i1 = this.e.getHeight();
        paramCanvas.save();
        if (!paramBoolean) {
            paramCanvas.translate(this.i.left, this.i.top);
        }
        if (m == 90) {
            paramCanvas.translate(i1, 0.0F);
        }
        for (; ; ) {
            paramCanvas.rotate(m, 0.0F, 0.0F);
            this.e.draw(paramCanvas);
            paramCanvas.restore();
            return;
            if (m == 180) {
                paramCanvas.translate(n, i1);
            } else if (m == 270) {
                paramCanvas.translate(0.0F, n);
            }
        }
    }

    private void c(Canvas paramCanvas, boolean paramBoolean) {
        paramCanvas.save();
        Attachment.ColorDrawableType localColorDrawableType = this.b.getColorDrawableType();
        float f5 = this.b.getStrokeWidth() * this.c;
        float f1 = f5 / 2.0F;
        RectF localRectF = new RectF();
        localRectF.left = 0.0F;
        localRectF.top = 0.0F;
        localRectF.right = this.i.width();
        localRectF.bottom = this.i.height();
        if (localColorDrawableType == Attachment.ColorDrawableType.Stroke) {
            localRectF.inset(f1, f1);
        }
        float f4 = this.i.left;
        float f3 = this.i.top;
        float f2 = f3;
        f1 = f4;
        if (paramBoolean) {
            f1 = f4 - (int) f4;
            f2 = f3 - (int) f3;
        }
        paramCanvas.translate(f1, f2);
        Paint localPaint = new Paint();
        localPaint.setColor(this.g);
        localPaint.setAntiAlias(true);
        localPaint.setFilterBitmap(true);
        if (localColorDrawableType == Attachment.ColorDrawableType.Stroke) {
            localPaint.setStyle(Paint.Style.STROKE);
            localPaint.setStrokeWidth(f5);
        }
        paramCanvas.drawRect(localRectF, localPaint);
        paramCanvas.restore();
    }

    private void d(Canvas paramCanvas, boolean paramBoolean) {
        if (this.h == null) {
            return;
        }
        paramCanvas.save();
        float f4 = this.i.left;
        float f3 = this.i.top;
        float f2 = f3;
        float f1 = f4;
        if (paramBoolean) {
            f1 = f4 - (int) f4;
            f2 = f3 - (int) f3;
        }
        Object localObject = new Rect();
        ((Rect) localObject).left = 0;
        ((Rect) localObject).top = 0;
        ((Rect) localObject).right = this.h.getIntrinsicWidth();
        ((Rect) localObject).bottom = this.h.getIntrinsicHeight();
        f3 = Math.min(this.i.width() / ((Rect) localObject).width(), this.i.height() / ((Rect) localObject).height());
        this.h.setBounds((Rect) localObject);
        localObject = new Matrix();
        ((Matrix) localObject).postScale(f3, f3);
        ((Matrix) localObject).postTranslate(f1, f2);
        paramCanvas.concat((Matrix) localObject);
        this.h.draw(paramCanvas);
        paramCanvas.restore();
    }

    private void f() {
        switch (1. a[this.b.getType().ordinal()])
        {
            default:
                return;
            case 1:
                i();
                return;
            case 2:
                h();
                return;
        }
        k();
    }

    private void g() {
        this.i = new RectF();
        String str = this.a.getString(R.string.fotor_font_roboto_light);
        this.f = TypefaceUtils.createFromAssetPath(this.a, str);
        f();
    }

    private void h() {
        Object localObject = new Rect(this.b.getRect());
        float f1 = (int) (((Rect) localObject).left * this.c);
        float f2 = (int) (((Rect) localObject).top * this.c);
        try {
            if ((this.b.getSource() != null) && (!this.b.getSource().isEmpty())) {
                localObject = new int[2];
                InputStream localInputStream = this.d.a(this.b.getSource());
                BitmapDecodeUtils.decodeImageBounds(localInputStream, (int[]) localObject);
                FotorIOUtils.closeSilently(localInputStream);
                float f3 = localObject[0];
                float f4 = this.c;
                float f5 = localObject[1];
                float f6 = this.c;
                this.i.left = f1;
                this.i.top = f2;
                this.i.right = (f1 + f3 * f4);
                this.i.bottom = (f2 + f5 * f6);
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void i() {
        Object localObject = new Rect(this.b.getRect());
        int m = ((Rect) localObject).width();
        int n = ((Rect) localObject).height();
        this.i.left = (((Rect) localObject).left * this.c);
        this.i.top = (((Rect) localObject).top * this.c);
        localObject = this.i;
        float f1 = this.i.left;
        ((RectF) localObject).right = (m * this.c + f1);
        this.i.bottom = (this.i.top + n * this.c);
        this.g = Color.parseColor(this.b.getColor());
    }

    private void j() {
        Object localObject = new RectF(this.b.getRect());
        float f1 = ((RectF) localObject).left * this.c;
        float f2 = ((RectF) localObject).top * this.c;
        try {
            if ((this.b.getSource() != null) && (!this.b.getSource().isEmpty())) {
                localObject = this.d.a(this.b.getSource());
                Bitmap localBitmap = BitmapDecodeUtils.decodeStream((InputStream) localObject);
                FotorIOUtils.closeSilently((Closeable) localObject);
                if (localBitmap != null) {
                    float f3 = localBitmap.getWidth();
                    float f4 = this.c;
                    float f5 = localBitmap.getHeight();
                    float f6 = this.c;
                    this.h = new BitmapDrawable(this.a.getResources(), localBitmap);
                    this.h.setAntiAlias(true);
                    this.h.setFilterBitmap(true);
                    this.i.left = f1;
                    this.i.top = f2;
                    this.i.right = (f1 + f3 * f4);
                    this.i.bottom = (f2 + f5 * f6);
                }
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void k() {
        Object localObject1 = new RectF(this.b.getRect());
        float f1 = ((RectF) localObject1).left;
        float f2 = this.c;
        float f3 = ((RectF) localObject1).top;
        float f4 = this.c;
        if ((this.b.getColor() != null) && (!this.b.getColor().isEmpty())) {
        }
        for (int m = Color.parseColor(this.b.getColor()); ; m = -16777216) {
            Object localObject2 = this.f;
            localObject1 = localObject2;
            if (this.b.getTypeface() != null) {
                localObject1 = localObject2;
                if (!this.b.getTypeface().isEmpty()) {
                    localObject1 = (g) this.d;
                    localObject1 = TypefaceUtils.createFromAsset(((g) localObject1).i(), ((g) localObject1).a_(), this.b.getTypeface());
                }
            }
            float f5 = this.b.getTextSize();
            float f6 = this.c;
            localObject2 = new TextPaint();
            ((TextPaint) localObject2).setAntiAlias(true);
            ((TextPaint) localObject2).setTextSize(f6 * f5);
            ((TextPaint) localObject2).setColor(m);
            ((TextPaint) localObject2).setLinearText(true);
            ((TextPaint) localObject2).setSubpixelText(true);
            if (localObject1 != null) {
                ((TextPaint) localObject2).setTypeface((Typeface) localObject1);
            }
            f5 = ((TextPaint) localObject2).measureText(this.b.getText());
            this.e = new StaticLayout(this.b.getText(), (TextPaint) localObject2, (int) (f5 + 1.0F), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            m = this.e.getWidth();
            int i1 = this.e.getHeight();
            int i3 = this.b.getAngle();
            int i2;
            int n;
            if (i3 != 90) {
                i2 = i1;
                n = m;
                if (i3 != 270) {
                }
            } else {
                n = i1;
                i2 = m;
            }
            this.i.left = (f1 * f2);
            this.i.top = (f3 * f4);
            localObject1 = this.i;
            f1 = this.i.left;
            ((RectF) localObject1).right = (n + f1);
            localObject1 = this.i;
            f1 = this.i.top;
            ((RectF) localObject1).bottom = (i2 + f1);
            return;
        }
    }

    public RectF a() {
        return new RectF(this.i);
    }

    public void a(int paramInt) {
        this.j = paramInt;
    }

    public void a(Canvas paramCanvas, boolean paramBoolean) {
        if (!this.k) {
            b();
        }
        switch (1. a[this.b.getType().ordinal()])
        {
            default:
                return;
            case 1:
                c(paramCanvas, paramBoolean);
                return;
            case 2:
                d(paramCanvas, paramBoolean);
                return;
        }
        b(paramCanvas, paramBoolean);
    }

    public void b() {
        switch (1. a[this.b.getType().ordinal()])
        {
        }
        for (; ; ) {
            this.k = true;
            return;
            j();
        }
    }

    public void c() {
        this.h = null;
        this.k = false;
    }

    public int d() {
        return this.j;
    }

    public ICollagePainter.PainterType e() {
        return ICollagePainter.PainterType.Attachment;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/painter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */