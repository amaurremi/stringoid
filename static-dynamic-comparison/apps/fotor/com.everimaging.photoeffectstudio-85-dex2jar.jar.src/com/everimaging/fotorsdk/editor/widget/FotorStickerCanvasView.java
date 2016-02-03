package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.utils.BitmapUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FotorStickerCanvasView
        extends FrameLayout
        implements a.b {
    private LinkedList<a> a;
    private a b = null;
    private PaintFlagsDrawFilter c;
    private Context d;
    private RectF e;
    private float f;
    private float g;
    private boolean h = false;
    private boolean i = false;
    private a.a j;
    private a k;

    public FotorStickerCanvasView(Context paramContext) {
        this(paramContext, null);
    }

    public FotorStickerCanvasView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorStickerCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    @SuppressLint({"NewApi"})
    private void a(Context paramContext) {
        this.d = paramContext;
        this.c = new PaintFlagsDrawFilter(0, 3);
        this.a = new LinkedList();
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void c() {
        if (this.i) {
            if ((this.b == null) || (this.j == null)) {
                break label60;
            }
            float f1 = this.j.a(AnimationUtils.currentAnimationTimeMillis());
            this.b.a(f1);
            if (this.j.b()) {
                b();
            }
        } else {
            return;
        }
        invalidate();
        return;
        label60:
        b();
    }

    public void a() {
        this.h = true;
        this.i = true;
    }

    public void a(Bitmap paramBitmap) {
        Object localObject = paramBitmap;
        if (!paramBitmap.isMutable()) {
            localObject = BitmapUtils.createBitmap(paramBitmap);
        }
        paramBitmap = new Canvas((Bitmap) localObject);
        paramBitmap.setDrawFilter(this.c);
        localObject = this.a.iterator();
        while (((Iterator) localObject).hasNext()) {
            ((a) ((Iterator) localObject).next()).a(paramBitmap, this.f, this.g);
        }
    }

    public void a(RectF paramRectF, float paramFloat1, float paramFloat2) {
        this.e = new RectF(paramRectF);
        this.f = paramFloat1;
        this.g = paramFloat2;
    }

    public void a(a.a parama) {
        this.j = parama;
        this.j.a();
        a();
        invalidate();
    }

    public void a(a parama) {
        this.a.remove(parama);
        this.b = null;
    }

    public void b() {
        this.h = false;
        this.i = false;
    }

    public void b(RectF paramRectF, float paramFloat1, float paramFloat2) {
        a(paramRectF, paramFloat1, paramFloat2);
        int m = this.a.size() - 1;
        while (m >= 0) {
            ((a) this.a.get(m)).b(paramRectF);
            m -= 1;
        }
        invalidate();
    }

    public void b(a parama) {
        this.b = parama;
        if (this.k != null) {
            this.k.a(parama);
        }
    }

    public void c(a parama) {
        this.b = null;
    }

    public void d(a parama) {
    }

    public void e(a parama) {
        if (parama != null) {
            parama = (c) parama;
            parama.a(this);
            parama.a(this.e);
            parama.a(this.a.size(), 10);
            this.a.add(parama);
            if (this.b != null) {
                this.b.a(false);
            }
            this.b = parama;
            b(this.b);
            invalidate();
        }
    }

    public List<a> getAdornItemsList() {
        return this.a;
    }

    public a getCurrentItem() {
        return this.b;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        paramCanvas.setDrawFilter(this.c);
        c();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((a) localIterator.next()).a(paramCanvas);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.h) {
            return true;
        }
        int n;
        int m;
        if (this.k != null) {
            if ((paramMotionEvent.getAction() & 0xFF) == 0) {
                this.k.b();
            }
        } else {
            n = this.a.size();
            m = n - 1;
        }
        for (; ; ) {
            if (m < 0) {
                break label141;
            }
            if (((a) this.a.get(m)).a(paramMotionEvent)) {
                if ((paramMotionEvent.getAction() == 0) && (m != n - 1)) {
                    paramMotionEvent = (a) this.a.remove(m);
                    this.a.addLast(paramMotionEvent);
                }
                invalidate();
                return true;
                if ((paramMotionEvent.getAction() & 0xFF) != 1) {
                    break;
                }
                this.k.d();
                break;
            }
            m -= 1;
        }
        label141:
        if ((this.k != null) && (this.b == null)) {
            this.k.n();
        }
        invalidate();
        return true;
    }

    public void setCurrentItemAlpha(int paramInt) {
        if (this.b != null) {
            ((c) this.b).b(paramInt);
            invalidate();
        }
    }

    public void setCurrentItemColor(int paramInt) {
        if (this.b != null) {
            ((c) this.b).a(paramInt);
            invalidate();
        }
    }

    public void setStickerCanvasListener(a parama) {
        this.k = parama;
    }

    public static abstract interface a {
        public abstract void a(a parama);

        public abstract void b();

        public abstract void d();

        public abstract void n();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorStickerCanvasView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */