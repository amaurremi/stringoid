package uk.co.chrisjenx.paralloid;

import android.view.View;

import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

import uk.co.chrisjenx.paralloid.c.c;

public class b<T>
        implements e {
    public static final String a = b.class.getSimpleName();
    protected WeakHashMap<View, d> b;
    protected WeakHashMap<View, uk.co.chrisjenx.paralloid.a.a> c;
    protected a d;
    protected boolean e;
    protected int f = 0;
    protected int g = 0;
    protected final T h;
    private Set<View> i;
    private Iterator<View> j;
    private d k;
    private uk.co.chrisjenx.paralloid.a.a l;
    private View m;

    protected b(T paramT) {
        this.h = paramT;
    }

    private final void a(int paramInt1, int paramInt2) {
        if (this.b == null) {
        }
        for (; ; ) {
            return;
            this.i = this.b.keySet();
            this.j = this.i.iterator();
            while (this.j.hasNext()) {
                this.m = ((View) this.j.next());
                if (this.m != null) {
                    this.k = ((d) this.b.get(this.m));
                    uk.co.chrisjenx.paralloid.d.a.a(this.m, paramInt1, paramInt2, this.k.b, this.k.a);
                }
            }
        }
    }

    private final void b() {
        if (this.b == null) {
            this.b = new WeakHashMap();
        }
    }

    private final void b(int paramInt1, int paramInt2) {
        if (this.c == null) {
        }
        for (; ; ) {
            return;
            this.i = this.c.keySet();
            this.j = this.i.iterator();
            while (this.j.hasNext()) {
                this.m = ((View) this.j.next());
                if (this.m != null) {
                    this.l = ((uk.co.chrisjenx.paralloid.a.a) this.c.get(this.m));
                    uk.co.chrisjenx.paralloid.d.a.a(this.l, paramInt1, paramInt2);
                }
            }
        }
    }

    private final void b(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((this.d != null) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
            this.d.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
        }
    }

    public T a() {
        return (T) this.h;
    }

    protected final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        a(paramInt1, paramInt2);
        b(paramInt1, paramInt2);
        b(a(), paramInt1, paramInt2, paramInt3, paramInt4);
        this.f = paramInt1;
        this.g = paramInt2;
    }

    protected final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4) || (paramBoolean)) {
            a(paramInt1, paramInt2, paramInt3, paramInt4);
        }
    }

    public void a(View paramView, c paramc, float paramFloat) {
        if (paramView == null) {
            return;
        }
        if (paramView == this.h) {
            throw new IllegalArgumentException("You can't parallax yourself, this would end badly, Parallax other Views");
        }
        b();
        this.b.put(paramView, new d(paramFloat, paramc));
        a(this.f, this.g, this.f, this.g, true);
    }

    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((paramObject != a()) || (this.e)) {
            return;
        }
        a(paramInt1, paramInt2, paramInt3, paramInt4, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */