package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.Iterator;

public final class g
        extends h {
    private ArrayList<h> c = new ArrayList();

    public g() {
        super(j.a);
        e(0);
    }

    private void a(h paramh, int paramInt1, int paramInt2) {
        h localh = (h) this.c.get(paramInt2);
        this.c.set(paramInt2, paramh);
        this.c.set(paramInt1, localh);
    }

    protected void a(Canvas paramCanvas) {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            h localh = (h) localIterator.next();
            localh.d(x());
            localh.b(paramCanvas);
            localh.y();
        }
    }

    public void a(RectF paramRectF) {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            h localh = (h) localIterator.next();
            PointF localPointF = new PointF(paramRectF.left, paramRectF.top);
            if (localh.o()) {
                localh.b(localPointF);
                localh.a(paramRectF.width(), paramRectF.height());
            }
        }
    }

    public void a(h paramh) {
        this.c.remove(paramh);
    }

    public void a(h paramh, RectF paramRectF) {
        this.c.add(paramh);
        if ((paramh.o()) && (paramRectF != null)) {
            paramh.b(new PointF(paramRectF.left, paramRectF.top));
            paramh.a(paramRectF.width(), paramRectF.height());
        }
    }

    public boolean a() {
        return this.c.isEmpty();
    }

    public void b(h paramh) {
        if (this.c.size() > 1) {
            this.c.remove(paramh);
            this.c.add(paramh);
        }
    }

    public ArrayList<h> c() {
        return this.c;
    }

    public void c(h paramh) {
        if (this.c.size() > 0) {
            this.c.remove(paramh);
            this.c.add(0, paramh);
        }
    }

    public Object clone() {
        g localg = (g) super.clone();
        localg.c = new ArrayList(this.c);
        return localg;
    }

    public void d(h paramh) {
        int i = this.c.size();
        if (i > 1) {
            int j = this.c.indexOf(paramh);
            if (j < i - 1) {
                a(paramh, j, j + 1);
            }
        }
    }

    public void e(h paramh) {
        if (this.c.size() > 1) {
            int i = this.c.indexOf(paramh);
            if (i > 0) {
                a(paramh, i, i - 1);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */