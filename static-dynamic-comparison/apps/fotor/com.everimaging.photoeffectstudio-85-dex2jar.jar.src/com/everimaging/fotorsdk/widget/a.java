package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.color;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.R.drawable;
import com.everimaging.fotorsdk.R.styleable;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

import java.lang.reflect.Field;

public abstract class a
        extends ImageButton {
    protected int A;
    protected int B;
    protected float C;
    protected float D;
    protected float E;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected RectF g;
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected RectF p;
    protected Paint q;
    protected Typeface r;
    protected TextPaint s;
    protected TextPaint t;
    protected Paint u;
    protected CharSequence v;
    protected PaintFlagsDrawFilter w;
    protected boolean x = false;
    protected int y = 0;
    protected int z;

    protected a(Context paramContext) {
        this(paramContext, null);
    }

    protected a(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultNavigateBtnStyle);
    }

    @TargetApi(16)
    protected a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorNavigationButton, paramInt, 0);
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 16) {
        }
        for (paramInt = getMinimumWidth(); ; paramInt = getMinimumWidthR()) {
            if (paramInt <= 0) {
                setMinimumWidth((int) paramContext.getDimension(R.dimen.fotor_main_navigation_btn_width));
            }
            a(paramAttributeSet);
            a();
            return;
        }
    }

    private int c() {
        int i1 = 0;
        if (this.s != null) {
            this.s.setTypeface(this.r);
            i1 = (int) (this.s.measureText(this.v.toString()) + 0.5F) + getPaddingLeft() + getPaddingRight();
        }
        return i1;
    }

    private int getMinimumWidthR() {
        try {
            int i1 = View.class.getDeclaredField("mMinWidth").getInt(this);
            return i1;
        } catch (Exception localException) {
        }
        return 0;
    }

    protected void a() {
        setBackgroundResource(R.drawable.fotor_transparent);
        Resources localResources = getResources();
        this.e = false;
        this.f = false;
        setWillNotDraw(false);
        this.w = new PaintFlagsDrawFilter(0, 3);
        this.g = new RectF();
        this.p = new RectF();
        this.q = new Paint();
        this.q.setColor(this.m);
        this.s = new TextPaint();
        this.s.setAntiAlias(true);
        float f1 = localResources.getDimension(R.dimen.fotor_main_navigation_btn_textsize);
        this.s.setTextSize(f1);
        this.z = localResources.getColor(R.color.fotor_category_download_background);
        this.A = localResources.getColor(R.color.fotor_category_download_stroke_background);
        this.B = localResources.getColor(R.color.fotor_category_download_stroke_progress);
        this.C = localResources.getDimension(R.dimen.fotor_category_download_stroke_size);
        this.D = localResources.getDimension(R.dimen.fotor_category_download_background_size);
        this.E = localResources.getDimension(R.dimen.fotor_category_download_text_size);
        this.t = new TextPaint();
        this.t.setAntiAlias(true);
        this.t.setTextSize(this.E);
        this.t.setColor(-1);
        this.u = new Paint();
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth(this.C);
    }

    public void a(int paramInt) {
        this.x = true;
        this.y = paramInt;
        invalidate();
    }

    protected void a(TypedArray paramTypedArray) {
        setTypeface(paramTypedArray.getString(2));
        setDefaultColor(paramTypedArray.getColor(3, getResources().getColor(R.color.fotor_button_color_default)));
        setPressedColor(paramTypedArray.getColor(4, getResources().getColor(R.color.fotor_button_color_pressed)));
        setDisabledColor(paramTypedArray.getColor(5, getResources().getColor(R.color.fotor_button_color_disabled)));
        setPressedBackground(paramTypedArray.getColor(6, getResources().getColor(R.color.fotor_button_background_color_normal)));
        setButtonName(paramTypedArray.getString(1));
        setIsShowPressedBackground(paramTypedArray.getBoolean(0, false));
        paramTypedArray.recycle();
    }

    protected void a(Canvas paramCanvas) {
        this.t.setTypeface(this.r);
        int i1 = this.y;
        float f1 = this.g.left;
        float f2 = this.g.width() / 2.0F;
        float f3 = this.g.top + this.g.height() / 2.0F;
        Object localObject = new RectF();
        ((RectF) localObject).left = (f1 + f2 - this.D / 2.0F);
        ((RectF) localObject).top = (f3 - this.D / 2.0F);
        ((RectF) localObject).right = (((RectF) localObject).left + this.D);
        ((RectF) localObject).bottom = (((RectF) localObject).top + this.D);
        this.u.setStyle(Paint.Style.FILL);
        this.u.setColor(this.z);
        paramCanvas.drawOval((RectF) localObject, this.u);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(this.A);
        paramCanvas.drawOval((RectF) localObject, this.u);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(this.B);
        paramCanvas.drawArc((RectF) localObject, -90.0F, this.y / 100.0F * 360.0F, false, this.u);
        localObject = new StaticLayout(String.valueOf(i1) + "%", this.t, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        paramCanvas.save();
        paramCanvas.translate(0.0F, f3 - ((StaticLayout) localObject).getHeight() / 2.0F);
        ((StaticLayout) localObject).draw(paramCanvas);
        paramCanvas.restore();
    }

    public void b() {
        this.x = false;
        this.y = 0;
        invalidate();
    }

    protected void b(Canvas paramCanvas) {
        this.s.setTypeface(this.r);
        this.s.setTextAlign(Paint.Align.CENTER);
        float f1 = getHeight();
        float f2 = this.j;
        float f3 = getWidth();
        this.s.ascent();
        paramCanvas.drawText(this.v.toString(), f3 * 0.5F, f1 * f2, this.s);
    }

    protected void drawableStateChanged() {
        this.e = isPressed();
        this.f = isSelected();
        invalidate();
        super.drawableStateChanged();
    }

    public CharSequence getButtonName() {
        return this.v;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.setDrawFilter(this.w);
        int i1 = getWidth();
        int i2 = getHeight();
        float f1;
        float f2;
        if (isEnabled()) {
            if (this.e) {
                if (this.d) {
                    paramCanvas.drawColor(this.l);
                    f1 = i2;
                    f2 = this.k;
                    this.p.left = 0.0F;
                    this.p.right = i1;
                    this.p.top = (i2 - f1 * f2);
                    this.p.bottom = i2;
                    paramCanvas.drawRect(this.p, this.q);
                }
                this.s.setColor(this.m);
            }
        }
        for (; ; ) {
            Drawable localDrawable = getDrawable();
            int i3 = (int) (i2 * this.h + 0.5F);
            f1 = (i1 - i3) / 2.0F;
            f2 = i2 * this.i;
            this.g.left = f1;
            this.g.top = f2;
            this.g.right = (i3 + f1);
            this.g.bottom = (i3 + f2);
            if (localDrawable != null) {
                localDrawable.setBounds(0, 0, i3, i3);
                paramCanvas.save();
                paramCanvas.translate(f1, f2);
                localDrawable.draw(paramCanvas);
                paramCanvas.restore();
            }
            if (this.x) {
                a(paramCanvas);
            }
            if (this.v != null) {
                b(paramCanvas);
            }
            return;
            if (this.f) {
                this.s.setColor(this.m);
            } else {
                this.s.setColor(this.n);
                continue;
                this.s.setColor(this.o);
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.v != null) {
            paramInt1 = getMeasuredWidth();
            paramInt2 = c();
            if (paramInt2 > paramInt1) {
                setMeasuredDimension(paramInt2, getMeasuredHeight());
            }
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.x) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setButtonName(CharSequence paramCharSequence) {
        this.v = paramCharSequence;
        invalidate();
    }

    public void setButtonNameResource(int paramInt) {
        setButtonName(getContext().getString(paramInt));
    }

    public void setDefaultColor(int paramInt) {
        this.n = paramInt;
    }

    public void setDisabledColor(int paramInt) {
        this.o = paramInt;
    }

    public void setIsShowPressedBackground(boolean paramBoolean) {
        this.d = paramBoolean;
    }

    public void setPressedBackground(int paramInt) {
        this.l = paramInt;
    }

    public void setPressedColor(int paramInt) {
        this.m = paramInt;
    }

    public void setTypeface(String paramString) {
        if (paramString != null) {
        }
        try {
            this.r = TypefaceUtils.createFromAssetPath(getContext(), paramString);
            return;
        } catch (Throwable paramString) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */