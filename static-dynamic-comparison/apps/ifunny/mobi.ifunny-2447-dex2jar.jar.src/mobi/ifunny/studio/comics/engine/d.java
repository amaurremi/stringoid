package mobi.ifunny.studio.comics.engine;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PointF;
import android.graphics.RectF;

public class d
        implements Cloneable {
    private PointF a;
    private int b;
    private int c;
    private Path d = new Path();
    private PointF e;
    private boolean f;
    private boolean g;

    public d() {
        this.d.setFillType(Path.FillType.WINDING);
        this.f = false;
    }

    public PointF a() {
        return this.e;
    }

    public void a(int paramInt) {
        this.b = paramInt;
    }

    public void a(Matrix paramMatrix) {
        float[] arrayOfFloat = new float[2];
        this.d.transform(paramMatrix);
        arrayOfFloat[0] = this.e.x;
        arrayOfFloat[1] = this.e.y;
        paramMatrix.mapPoints(arrayOfFloat);
        this.e.x = arrayOfFloat[0];
        this.e.y = arrayOfFloat[1];
    }

    public void a(PointF paramPointF) {
        if (!this.f) {
            this.d.moveTo(paramPointF.x, paramPointF.y);
            this.e = new PointF(paramPointF.x, paramPointF.y);
            this.f = true;
        }
        for (; ; ) {
            this.a = new PointF(paramPointF.x, paramPointF.y);
            return;
            this.d.quadTo(this.a.x, this.a.y, (paramPointF.x + this.a.x) / 2.0F, (paramPointF.y + this.a.y) / 2.0F);
        }
    }

    public void a(boolean paramBoolean) {
        this.g = paramBoolean;
    }

    public boolean a(RectF paramRectF) {
        if (!this.f) {
            return false;
        }
        paramRectF.set(100000.0F, 100000.0F, -100000.0F, -100000.0F);
        if (!this.d.isEmpty()) {
            this.d.computeBounds(paramRectF, true);
        }
        if (this.e.x < paramRectF.left) {
            paramRectF.left = this.e.x;
        }
        if (this.e.x > paramRectF.right) {
            paramRectF.right = this.e.x;
        }
        if (this.e.y < paramRectF.top) {
            paramRectF.top = this.e.y;
        }
        if (this.e.y > paramRectF.bottom) {
            paramRectF.bottom = this.e.y;
        }
        float f1 = d() / 2;
        paramRectF.inset(-f1, -f1);
        return true;
    }

    public void b(int paramInt) {
        this.c = paramInt;
    }

    public boolean b() {
        return this.g;
    }

    public int c() {
        return this.b;
    }

    public Object clone() {
        d locald = (d) super.clone();
        locald.d = new Path(this.d);
        locald.a = new PointF(this.a.x, this.a.y);
        locald.e = new PointF(this.e.x, this.e.y);
        return locald;
    }

    public int d() {
        return this.c;
    }

    public Path e() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */