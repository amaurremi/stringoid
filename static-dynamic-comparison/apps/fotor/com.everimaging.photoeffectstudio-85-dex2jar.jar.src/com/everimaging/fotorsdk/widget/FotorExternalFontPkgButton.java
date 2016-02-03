package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.everimaging.fotorsdk.R.color;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.R.drawable;
import com.everimaging.fotorsdk.R.string;
import com.everimaging.fotorsdk.uil.core.assist.g;
import com.everimaging.fotorsdk.uil.core.c;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.uil.core.d;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

public class FotorExternalFontPkgButton
        extends ImageButton {
    protected boolean a = false;
    protected int b = 0;
    protected TextPaint c;
    protected Paint d;
    protected int e;
    protected int f;
    protected int g;
    protected float h;
    protected float i;
    private Typeface j;
    private Drawable k;
    private String l;
    private String m;
    private BitmapDrawable n;
    private BitmapDrawable o;
    private int p;
    private Drawable q;
    private Drawable r;
    private Drawable s;
    private c t;

    public FotorExternalFontPkgButton(Context paramContext) {
        this(paramContext, null);
    }

    public FotorExternalFontPkgButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorExternalFontPkgButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        d();
    }

    private void a(Canvas paramCanvas) {
        float f1 = Math.min(getWidth(), getHeight()) - this.h;
        Object localObject = new RectF();
        ((RectF) localObject).left = ((getWidth() - f1) / 2.0F);
        ((RectF) localObject).top = ((getHeight() - f1) / 2.0F);
        ((RectF) localObject).right = (((RectF) localObject).left + f1);
        ((RectF) localObject).bottom = (f1 + ((RectF) localObject).top);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(this.e);
        paramCanvas.drawOval((RectF) localObject, this.d);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(this.f);
        paramCanvas.drawOval((RectF) localObject, this.d);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(this.g);
        paramCanvas.drawArc((RectF) localObject, -90.0F, this.b / 100.0F * 360.0F, false, this.d);
        int i1 = this.b;
        f1 = ((RectF) localObject).height() / 2.0F;
        localObject = new StaticLayout(String.valueOf(i1) + "%", this.c, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        paramCanvas.save();
        paramCanvas.translate(0.0F, f1 - ((StaticLayout) localObject).getHeight() / 2.0F);
        ((StaticLayout) localObject).draw(paramCanvas);
        paramCanvas.restore();
    }

    private void c() {
        if ((this.n != null) && (this.o != null)) {
            if ((this.n.getBitmap() == null) || (this.o.getBitmap() == null)) {
                setImageDrawable(this.k);
            }
        } else {
            return;
        }
        StateListDrawable localStateListDrawable = new StateListDrawable();
        BitmapDrawable localBitmapDrawable = this.o;
        localStateListDrawable.addState(new int[]{16842919}, localBitmapDrawable);
        localBitmapDrawable = this.n;
        localStateListDrawable.addState(new int[0], localBitmapDrawable);
        setImageDrawable(localStateListDrawable);
    }

    private void d() {
        Resources localResources = getResources();
        this.p = 0;
        this.k = localResources.getDrawable(R.drawable.fotor_external_recommend_pkg_default_bg);
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options) localObject).inScaled = true;
        ((BitmapFactory.Options) localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
        ((BitmapFactory.Options) localObject).inDither = false;
        ((BitmapFactory.Options) localObject).inJustDecodeBounds = false;
        ((BitmapFactory.Options) localObject).inPurgeable = false;
        ((BitmapFactory.Options) localObject).inInputShareable = false;
        ((BitmapFactory.Options) localObject).inTempStorage = new byte['䀀'];
        ((BitmapFactory.Options) localObject).inDensity = 320;
        ((BitmapFactory.Options) localObject).inTargetDensity = DeviceUtils.getDensity();
        this.t = new c.a().a(R.drawable.fotor_external_recommend_pkg_default_bg).b(R.drawable.fotor_external_recommend_pkg_default_bg).c(R.drawable.fotor_external_recommend_pkg_default_bg).a(true).b(true).a((BitmapFactory.Options) localObject).a();
        this.q = localResources.getDrawable(R.drawable.fotor_external_btn_new_indicator);
        this.r = localResources.getDrawable(R.drawable.fotor_external_btn_recommend_indicator);
        this.s = localResources.getDrawable(R.drawable.fotor_external_btn_download_indicator);
        this.c = new TextPaint();
        this.c.setAntiAlias(true);
        float f1 = localResources.getDimension(R.dimen.fotor_category_download_text_size);
        this.c.setTextSize(f1);
        this.c.setColor(-1);
        localObject = localResources.getString(R.string.fotor_font_roboto_light);
        this.j = TypefaceUtils.createFromAssetPath(getContext(), (String) localObject);
        this.c.setTypeface(this.j);
        this.e = localResources.getColor(R.color.fotor_category_download_background);
        this.f = localResources.getColor(R.color.fotor_category_download_stroke_background);
        this.g = localResources.getColor(R.color.fotor_category_download_stroke_progress);
        this.h = localResources.getDimension(R.dimen.fotor_category_download_stroke_size);
        this.i = localResources.getDimension(R.dimen.fotor_category_download_text_size);
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(this.h);
    }

    public void a(int paramInt) {
        this.a = true;
        this.b = paramInt;
        invalidate();
    }

    public void a(String paramString1, String paramString2) {
        this.l = paramString1;
        this.m = paramString2;
        setImageDrawable(this.k);
        this.n = null;
        this.o = null;
        paramString1 = d.a();
        paramString1.a(this.l, this.t, new g() {
            public void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {
                FotorExternalFontPkgButton.a(FotorExternalFontPkgButton.this, new BitmapDrawable(FotorExternalFontPkgButton.this.getResources(), paramAnonymousBitmap));
                FotorExternalFontPkgButton.a(FotorExternalFontPkgButton.this);
            }
        });
        paramString1.a(this.m, this.t, new g() {
            public void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {
                FotorExternalFontPkgButton.b(FotorExternalFontPkgButton.this, new BitmapDrawable(FotorExternalFontPkgButton.this.getResources(), paramAnonymousBitmap));
                FotorExternalFontPkgButton.a(FotorExternalFontPkgButton.this);
            }
        });
    }

    public boolean a() {
        return this.p == 1;
    }

    public void b() {
        this.a = false;
        this.b = 0;
        invalidate();
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Object localObject = getDrawable();
        int i1;
        int i2;
        if ((localObject != null) && (localObject != this.k) && (this.p != 0) && (!this.a)) {
            if (this.p != 1) {
                break label191;
            }
            float f1 = this.q.getIntrinsicWidth() / 2.0F;
            i1 = ((Drawable) localObject).getIntrinsicWidth();
            float f2 = getWidth();
            float f3 = (getWidth() - i1) / 4.0F;
            i1 = this.q.getIntrinsicWidth();
            i2 = this.q.getIntrinsicHeight();
            localObject = new Rect();
            ((Rect) localObject).left = ((int) (f2 - f3 - i1 / 2.0F));
            ((Rect) localObject).top = ((int) f1);
            ((Rect) localObject).right = (((Rect) localObject).left + i1);
            ((Rect) localObject).bottom = (((Rect) localObject).top + i2);
            this.q.setBounds((Rect) localObject);
            this.q.draw(paramCanvas);
        }
        for (; ; ) {
            if (this.a) {
                a(paramCanvas);
            }
            return;
            label191:
            if (this.p == 3) {
                i1 = this.r.getIntrinsicWidth();
                i2 = this.r.getIntrinsicHeight();
                localObject = new Rect();
                ((Rect) localObject).left = (getWidth() - i1);
                ((Rect) localObject).top = 0;
                ((Rect) localObject).right = getWidth();
                ((Rect) localObject).bottom = i2;
                this.r.setBounds((Rect) localObject);
                this.r.draw(paramCanvas);
            } else if (this.p == 2) {
                i1 = this.s.getIntrinsicWidth();
                i2 = this.s.getIntrinsicHeight();
                localObject = new Rect();
                ((Rect) localObject).left = (getWidth() - i1);
                ((Rect) localObject).top = 0;
                ((Rect) localObject).right = getWidth();
                ((Rect) localObject).bottom = i2;
                this.s.setBounds((Rect) localObject);
                this.s.draw(paramCanvas);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.a) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setShowIndicator(int paramInt) {
        this.p = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorExternalFontPkgButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */