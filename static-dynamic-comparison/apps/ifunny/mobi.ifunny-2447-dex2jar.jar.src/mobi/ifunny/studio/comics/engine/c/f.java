package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mobi.ifunny.studio.comics.engine.d;

public class f
        implements Cloneable {
    private List<d> a;
    private RectF b;
    private PointF c;

    public f() {
    }

    public f(List<d> paramList, RectF paramRectF1, PointF paramPointF, RectF paramRectF2, float paramFloat1, float paramFloat2, boolean paramBoolean) {
        this.a = paramList;
        this.b = paramRectF1;
        this.c = paramPointF;
    }

    public List<d> a() {
        return this.a;
    }

    public void a(Matrix paramMatrix) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            d locald = (d) localIterator.next();
            RectF localRectF = new RectF();
            locald.e().computeBounds(localRectF, true);
            locald.a(paramMatrix);
            locald.e().computeBounds(localRectF, true);
        }
    }

    public void a(RectF paramRectF) {
        this.b = paramRectF;
    }

    public d b() {
        if ((this.a == null) || (this.a.size() == 0)) {
            return null;
        }
        return (d) this.a.get(this.a.size() - 1);
    }

    public Object clone() {
        f localf = (f) super.clone();
        if (this.b != null) {
            localf.b = new RectF(this.b);
        }
        if (this.c != null) {
            localf.c = new PointF(this.c.x, this.c.y);
        }
        if (this.a != null) {
            int j = this.a.size();
            localf.a = new ArrayList();
            int i = 0;
            while (i < j) {
                localf.a.add((d) ((d) this.a.get(i)).clone());
                i += 1;
            }
        }
        return localf;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */