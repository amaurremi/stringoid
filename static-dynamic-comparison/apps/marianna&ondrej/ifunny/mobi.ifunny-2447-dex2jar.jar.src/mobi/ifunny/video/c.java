package mobi.ifunny.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c
        extends Drawable
        implements Animatable {
    private static final String m = c.class.getSimpleName();
    private HandlerThread A;
    private Handler B;
    private final Object C;
    protected long a;
    protected b b;
    protected int[] c;
    protected g d;
    protected l e;
    protected e f;
    protected i g;
    protected j h;
    protected h i;
    protected k j;
    protected d k;
    protected f l;
    private File n;
    private boolean o;
    private final Matrix p;
    private float q;
    private Paint r;
    private boolean s;
    private Canvas t;
    private BitmapShader u;
    private Paint v;
    private RectF w;
    private AtomicBoolean x;
    private AtomicBoolean y;
    private Handler z;

    public c(File paramFile, Rect paramRect) {
        this.n = paramFile;
        this.o = true;
        this.q = 1.0F;
        this.p = new Matrix();
        this.y = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.b = a(paramFile.getAbsolutePath(), paramRect);
        if (this.b == null) {
            throw new IllegalStateException("cannot init video drawable");
        }
        try {
            this.C = new Object();
            this.c = this.b.allocBuffer();
            this.r = new Paint();
            this.r.setFilterBitmap(true);
            this.d = new g(this);
            this.e = new l(this);
            this.f = new e(this);
            this.g = new i(this);
            this.h = new j(this);
            this.j = new k(this);
            this.i = new h(this);
            this.k = new d(this);
            this.z = new Handler(Looper.getMainLooper());
            this.l = new f(this);
            e();
            return;
        } catch (Exception paramFile) {
            d();
            throw new IllegalStateException(paramFile);
        }
    }

    private void e() {
        if (this.A != null) {
            f();
        }
        this.A = new HandlerThread(m.class.getSimpleName() + toString(), 5);
        this.A.setDaemon(true);
        this.A.start();
        this.B = new Handler(this.A.getLooper());
        this.x.set(true);
        this.B.post(this.l);
    }

    private void f() {
        if ((this.A == null) || (!this.x.get())) {
            return;
        }
        this.x.set(false);
        this.y.set(false);
        this.A.quit();
    }

    private void g() {
        this.B.removeCallbacks(this.e);
        this.B.removeCallbacks(this.f);
        this.z.removeCallbacks(this.d);
    }

    private void h() {
        g();
        this.B.removeCallbacks(this.j);
        this.B.removeCallbacks(this.h);
        this.B.removeCallbacks(this.i);
        this.B.removeCallbacks(this.g);
        this.B.removeCallbacks(this.l);
    }

    private void i() {
        if (this.b != null) {
            this.b.destroyCodec();
            this.b = null;
        }
    }

    protected abstract b a(String paramString, Rect paramRect);

    public void a() {
        if ((this.x.get()) || (this.a != 0L)) {
        }
        this.y.set(false);
        this.B.post(this.h);
    }

    public void a(float paramFloat) {
        this.q = paramFloat;
    }

    public void a(boolean paramBoolean) {
        if (this.s != paramBoolean) {
            if (!paramBoolean) {
                break label113;
            }
            Bitmap localBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.t = new Canvas(localBitmap);
            this.u = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.v = new Paint();
            this.v.setAntiAlias(true);
            this.v.setFilterBitmap(true);
            this.v.setShader(this.u);
        }
        for (this.w = new RectF(); ; this.w = null) {
            this.s = paramBoolean;
            return;
            label113:
            this.t = null;
            this.u = null;
            this.v = null;
        }
    }

    public void b() {
        if (!this.x.get()) {
        }
        this.y.set(true);
        this.B.post(this.i);
    }

    public void b(boolean paramBoolean) {
        this.o = paramBoolean;
    }

    public void c() {
        if (!this.x.get()) {
        }
        this.B.post(this.g);
    }

    public void d() {
        if (this.b == null) {
            return;
        }
        if (this.x.get()) {
            h();
        }
        for (; ; ) {
            synchronized (this.C) {
                this.C.notify();
                this.B.post(this.k);
                if ((!this.o) || (this.n.delete())) {
                    break;
                }
                Log.e(m, "Cannot delete " + this.n);
                return;
            }
            i();
        }
    }

    public void draw(Canvas paramCanvas) {
        int i1 = this.b.getWidth();
        int i2 = this.b.getHeight();
        if (this.s) {
            this.t.drawBitmap(this.c, 0, i1, 0.0F, 0.0F, i1, i2, false, this.r);
            paramCanvas.drawRoundRect(this.w, 8.0F, 8.0F, this.v);
            return;
        }
        paramCanvas.save();
        paramCanvas.concat(this.p);
        paramCanvas.drawBitmap(this.c, 0, i1, 0.0F, 0.0F, i1, i2, false, this.r);
        paramCanvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.b.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.b.getWidth();
    }

    public int getOpacity() {
        return -1;
    }

    public boolean isRunning() {
        return this.y.get();
    }

    protected void onBoundsChange(Rect paramRect) {
        super.onBoundsChange(paramRect);
        float f1 = paramRect.width() / this.b.getWidth();
        float f2 = paramRect.height() / this.b.getHeight();
        int i1 = (int) ((paramRect.width() - this.b.getWidth() * f1) * 0.5F + 0.5F);
        int i2 = (int) ((paramRect.height() - this.b.getHeight() * f2) * 0.5F + 0.5F);
        this.p.reset();
        this.p.setScale(f1, f2);
        this.p.postTranslate(i1, i2);
        if (this.s) {
            this.u.setLocalMatrix(this.p);
            this.w.set(paramRect);
        }
    }

    public void setAlpha(int paramInt) {
        this.r.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.r.setColorFilter(paramColorFilter);
    }

    public void start() {
        if (!this.x.get()) {
            e();
        }
        this.B.removeCallbacks(this.j);
        this.B.removeCallbacks(this.l);
        synchronized (this.C) {
            this.C.notify();
            a();
            return;
        }
    }

    public void stop() {
        b();
        this.B.post(this.j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */