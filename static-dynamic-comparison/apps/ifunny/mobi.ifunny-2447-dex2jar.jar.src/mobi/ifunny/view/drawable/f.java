package mobi.ifunny.view.drawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import mobi.ifunny.util.a.d;
import mobi.ifunny.util.a.e;

public class f
        extends Drawable {
    private static final String g = f.class.getSimpleName();
    protected d a;
    protected Rect b;
    protected Rect c;
    protected final ArrayList<Rect> d;
    protected final ArrayList<RectF> e;
    protected Paint f;
    private Paint h;
    private int i;
    private boolean j;
    private Matrix k = new Matrix();
    private RectF l = new RectF();

    public f(d paramd) {
        this(paramd, false);
    }

    public f(d paramd, boolean paramBoolean) {
        this.b = new Rect(0, 0, paramd.a, paramd.b);
        this.c = new Rect();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setFilterBitmap(true);
        this.f.setDither(false);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(-1);
        if (paramBoolean) {
            this.f.setColorFilter(new LightingColorFilter(-1, -16119286));
        }
        this.h = new Paint();
        a(0);
        a(paramd);
    }

    public final void a(int paramInt) {
        this.i = paramInt;
        this.h.setColor(paramInt);
        invalidateSelf();
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.c.left = paramInt1;
        this.c.right = paramInt2;
        this.c.top = paramInt3;
        this.c.bottom = paramInt4;
        f();
    }

    public void a(Rect paramRect) {
        a(paramRect.left, paramRect.right, paramRect.top, paramRect.bottom);
        invalidateSelf();
    }

    public final void a(d paramd) {
        this.a = paramd;
        f();
        invalidateSelf();
    }

    public void b(boolean paramBoolean) {
        this.j = paramBoolean;
    }

    public Bitmap c() {
        if (this.a.b()) {
            return null;
        }
        Rect localRect = getBounds();
        setBounds(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
        Bitmap localBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(localBitmap));
        setBounds(localRect);
        return localBitmap;
    }

    public Bitmap d() {
        if (this.a.b()) {
            return null;
        }
        if ((this.a.c() == 1) && (((e) this.a.c.get(0)).b.equals(this.b)) && (getBounds().equals(this.b))) {
            return ((e) this.a.c.get(0)).a;
        }
        Bitmap localBitmap = Bitmap.createBitmap(this.b.width(), this.b.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Rect localRect = new Rect(this.c);
        a(0, 0, 0, 0);
        draw(localCanvas);
        a(localRect);
        return localBitmap;
    }

    public void draw(Canvas paramCanvas) {
        if (this.i != 0) {
            paramCanvas.drawRect(getBounds(), this.h);
        }
        int i1 = this.a.c();
        int m;
        int n;
        label38:
        Object localObject2;
        Object localObject1;
        RectF localRectF;
        if (i1 == 1) {
            m = 1;
            n = 0;
            if (n >= i1) {
                return;
            }
            localObject2 = (e) this.a.c.get(n);
            localObject1 = (Rect) this.d.get(n);
            localRectF = (RectF) this.e.get(n);
            if ((!((Rect) localObject1).isEmpty()) && (!localRectF.isEmpty())) {
                break label114;
            }
        }
        for (; ; ) {
            n += 1;
            break label38;
            m = 0;
            break;
            label114:
            localObject2 = ((e) localObject2).a;
            if ((this.j) && (m != 0)) {
                this.l.set((Rect) localObject1);
                this.k.setRectToRect(this.l, localRectF, Matrix.ScaleToFit.CENTER);
                localObject1 = new BitmapShader((Bitmap) localObject2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                ((BitmapShader) localObject1).setLocalMatrix(this.k);
                this.f.setShader((Shader) localObject1);
                paramCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, this.f);
                this.f.setShader(null);
            } else {
                paramCanvas.drawBitmap((Bitmap) localObject2, (Rect) localObject1, localRectF, this.f);
            }
        }
    }

    public d e() {
        return this.a;
    }

    protected void f() {
        Rect localRect1 = getBounds();
        if ((localRect1 == null) || (localRect1.width() == 0) || (localRect1.height() == 0)) {
        }
        for (; ; ) {
            return;
            this.e.clear();
            this.d.clear();
            float f1 = localRect1.width() / getIntrinsicWidth();
            float f2 = localRect1.height() / getIntrinsicHeight();
            int n = this.a.c();
            int m = 0;
            while (m < n) {
                Object localObject2 = (e) this.a.c.get(m);
                Object localObject1 = ((e) localObject2).a;
                localObject2 = ((e) localObject2).b;
                int i1 = Math.max(0, this.c.left - ((Rect) localObject2).left);
                int i2 = Math.max(0, ((Rect) localObject2).right - (this.b.right - this.c.right));
                int i3 = Math.max(0, this.c.top - ((Rect) localObject2).top);
                int i4 = Math.max(0, ((Rect) localObject2).bottom - (this.b.bottom - this.c.bottom));
                Rect localRect2 = new Rect();
                localRect2.set(0, 0, ((Bitmap) localObject1).getWidth(), ((Bitmap) localObject1).getHeight());
                localRect2.left += i1;
                localRect2.top += i3;
                localRect2.right -= i2;
                localRect2.bottom -= i4;
                this.d.add(localRect2);
                localObject1 = new RectF();
                float f3 = localRect1.left;
                ((RectF) localObject1).left = ((i1 + (((Rect) localObject2).left - this.c.left)) * f1 + f3);
                ((RectF) localObject1).right = (localRect1.left - (i2 + (this.c.left - ((Rect) localObject2).right)) * f1);
                ((RectF) localObject1).top = (localRect1.top + (((Rect) localObject2).top - this.c.top + i3) * f2);
                ((RectF) localObject1).bottom = (localRect1.top - (this.c.top - ((Rect) localObject2).bottom + i4) * f2);
                this.e.add(localObject1);
                m += 1;
            }
        }
    }

    public int g() {
        return this.b.width();
    }

    public int getIntrinsicHeight() {
        return this.b.height() - this.c.top - this.c.bottom;
    }

    public int getIntrinsicWidth() {
        return this.b.width() - this.c.left - this.c.right;
    }

    public int getOpacity() {
        return -1;
    }

    public int h() {
        return this.b.height();
    }

    public Drawable mutate() {
        if (this.f.getColorFilter() != null) {
        }
        for (boolean bool = true; ; bool = false) {
            f localf = new f(this.a, bool);
            localf.a(this.c.left, this.c.right, this.c.top, this.c.bottom);
            localf.a(this.i);
            localf.setBounds(getBounds());
            return localf;
        }
    }

    public void setAlpha(int paramInt) {
        this.f.setAlpha(paramInt);
    }

    public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        Rect localRect = getBounds();
        if ((paramInt1 == localRect.left) && (paramInt3 == localRect.right) && (paramInt2 == localRect.top) && (paramInt4 == localRect.bottom)) {
        }
        for (int m = 1; ; m = 0) {
            super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
            if (m == 0) {
                f();
            }
            return;
        }
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.f.setColorFilter(paramColorFilter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */