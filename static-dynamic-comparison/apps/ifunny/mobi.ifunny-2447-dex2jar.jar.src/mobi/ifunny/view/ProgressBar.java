package mobi.ifunny.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

import mobi.ifunny.j;

public class ProgressBar
        extends View {
    private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
    private int b = 1;
    private Drawable c;
    private Drawable d;
    private Paint e;
    private Paint f;
    private Bitmap g;
    private Canvas h;
    private Bitmap i;
    private Canvas j;
    private int k;
    private RectF l;
    private int m;
    private int n;
    private AtomicBoolean o;
    private v p;
    private w q = new w(this, null);

    public ProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, v.b, paramAttributeSet);
    }

    public ProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext, v.b, paramAttributeSet);
    }

    private void a() {
        removeCallbacks(this.q);
        if (this.p == v.b) {
            this.n = 0;
            this.m = 25;
            b();
            post(this.q);
            return;
        }
        this.m = 0;
    }

    private void a(Context paramContext, v paramv, AttributeSet paramAttributeSet) {
        this.p = paramv;
        this.o = new AtomicBoolean(false);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_ProgressBar);
        this.b = paramContext.getInt(0, this.b);
        paramContext.recycle();
        switch (this.b) {
            default:
                this.k = getResources().getDimensionPixelSize(2131427477);
        }
        for (int i1 = getResources().getDimensionPixelSize(2131427475); ; i1 = getResources().getDimensionPixelSize(2131427476)) {
            this.e = new Paint(3);
            this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f = new Paint(3);
            paramContext = Bitmap.createBitmap(this.k, this.k, a);
            paramv = new Canvas(paramContext);
            paramAttributeSet = new Paint(3);
            paramAttributeSet.setColor(getResources().getColor(2131361859));
            paramv.drawCircle(this.k / 2, this.k / 2, this.k / 2, paramAttributeSet);
            paramAttributeSet.setColor(0);
            paramAttributeSet.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paramv.drawCircle(this.k / 2, this.k / 2, i1 / 2, paramAttributeSet);
            this.c = new BitmapDrawable(getResources(), paramContext);
            paramContext = Bitmap.createBitmap(this.k, this.k, a);
            paramv = new Canvas(paramContext);
            paramAttributeSet = new Paint(3);
            paramAttributeSet.setColor(getResources().getColor(2131361860));
            paramv.drawCircle(this.k / 2, this.k / 2, this.k / 2, paramAttributeSet);
            paramAttributeSet.setColor(0);
            paramAttributeSet.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paramv.drawCircle(this.k / 2, this.k / 2, i1 / 2, paramAttributeSet);
            this.d = new BitmapDrawable(getResources(), paramContext);
            paramContext = new Rect(0, 0, this.k, this.k);
            this.l = new RectF(paramContext);
            this.c.setBounds(paramContext);
            this.d.setBounds(paramContext);
            this.g = Bitmap.createBitmap(this.k, this.k, a);
            this.h = new Canvas(this.g);
            this.i = Bitmap.createBitmap(this.k, this.k, a);
            this.j = new Canvas(this.i);
            requestLayout();
            a();
            return;
            this.k = getResources().getDimensionPixelSize(2131427478);
        }
    }

    private void a(Canvas paramCanvas) {
        this.d.draw(this.j);
        this.j.drawBitmap(this.g, 0.0F, 0.0F, this.e);
        paramCanvas.drawBitmap(this.i, 0.0F, 0.0F, this.f);
    }

    private void b() {
        this.h.drawArc(this.l, 270.0F, this.m * 360 / 100, true, this.f);
    }

    private void c() {
        removeCallbacks(this.q);
        Handler localHandler = getHandler();
        if (localHandler != null) {
            localHandler.removeCallbacks(this.q);
        }
    }

    public v getMode() {
        return this.p;
    }

    public int getPercent() {
        return this.m;
    }

    protected int getSuggestedMinimumHeight() {
        return this.k;
    }

    protected int getSuggestedMinimumWidth() {
        return this.k;
    }

    protected void onDetachedFromWindow() {
        this.o.set(true);
        c();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas paramCanvas) {
        if (this.p == v.a) {
            this.h.drawColor(0, PorterDuff.Mode.CLEAR);
            b();
        }
        this.j.drawColor(0, PorterDuff.Mode.CLEAR);
        this.c.draw(paramCanvas);
        if (this.p == v.b) {
            paramCanvas.save();
            paramCanvas.rotate(this.n, this.k / 2, this.k / 2);
            a(paramCanvas);
            paramCanvas.restore();
            return;
        }
        a(paramCanvas);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        setMeasuredDimension(resolveSize(this.k, paramInt1), resolveSize(this.k, paramInt2));
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        super.onWindowVisibilityChanged(paramInt);
        if (paramInt == 0) {
            if ((this.p == v.b) && (getVisibility() == 0)) {
                post(this.q);
            }
            return;
        }
        c();
    }

    public void setMode(v paramv) {
        this.p = paramv;
        a();
    }

    public void setPercent(int paramInt) {
        this.m = paramInt;
        invalidate();
    }

    public void setVisibility(int paramInt) {
        super.setVisibility(paramInt);
        if (paramInt == 0) {
            if ((this.p == v.b) && (getWindowVisibility() == 0)) {
                post(this.q);
            }
            return;
        }
        c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/ProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */