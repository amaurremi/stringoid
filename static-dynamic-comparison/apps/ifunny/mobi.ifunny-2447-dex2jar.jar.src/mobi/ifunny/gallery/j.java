package mobi.ifunny.gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Map;

import mobi.ifunny.fragment.d;
import mobi.ifunny.gallery.fragment.f;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.Paging;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class j
        extends d {
    private static final String a = j.class.getSimpleName();
    private final IFunnyCache.ListEntry b;
    private Map<String, Bundle> c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private boolean g;

    public j(android.support.v4.app.q paramq, IFunnyCache.ListEntry paramListEntry, Map<String, Bundle> paramMap) {
        super(paramq);
        this.b = paramListEntry;
        this.c = paramMap;
        this.g = false;
    }

    private void a(int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt2 != -1) {
            this.d = paramInt2;
            this.e = -1;
            this.f = -1;
        }
        for (; ; ) {
            super.notifyDataSetChanged();
            return;
            if (paramInt3 != -1) {
                this.d = -1;
                this.e = paramInt3;
                this.f = -1;
            } else if (paramInt1 != -1) {
                this.d = -1;
                this.e = -1;
                this.f = paramInt1;
            } else {
                this.d = -1;
                this.e = -1;
                this.f = -1;
            }
        }
    }

    protected int a(IFunny paramIFunny) {
        return this.b.b(paramIFunny);
    }

    public IFunny a(int paramInt) {
        if ((paramInt >= 0) && (paramInt < getCount())) {
            return this.b.a(paramInt);
        }
        return null;
    }

    public void a(IFunnyList paramIFunnyList) {
        this.b.a(paramIFunnyList);
        a(-1, -1, -1);
    }

    public f b(int paramInt) {
        if ((paramInt >= 0) && (paramInt < a().size())) {
            return (f) a().get(paramInt);
        }
        return null;
    }

    public void b(IFunny paramIFunny) {
        this.g = true;
        int i = a(paramIFunny);
        if (this.b.a(paramIFunny)) {
            a(-1, i, -1);
        }
        this.g = false;
    }

    public void b(IFunnyList paramIFunnyList) {
    }

    public IFunny c(int paramInt) {
        return this.b.b(paramInt);
    }

    public IFunnyCache.ListEntry c() {
        return this.b;
    }

    public IFunnyCache.ListEntry d() {
        return this.b.f();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        if (this.g) {
            b().set(paramInt, null);
        }
    }

    public Paging e() {
        return this.b.b();
    }

    public Paging f() {
        return this.b.c();
    }

    public void g() {
        this.b.a();
        a(-1, -1, Integer.MAX_VALUE);
        a().clear();
        b().clear();
    }

    public int getCount() {
        return this.b.d();
    }

    public Fragment getItem(int paramInt) {
        IFunny localIFunny = a(paramInt);
        Bundle localBundle = null;
        if (this.c != null) {
            localBundle = (Bundle) this.c.get(localIFunny.id);
        }
        return mobi.ifunny.gallery.fragment.q.a(localIFunny, localBundle);
    }

    public int getItemPosition(Object paramObject) {
        int i = a(((f) paramObject).j());
        if (this.d != -1) {
            if ((i >= 0) && (i < this.d)) {
            }
        } else {
            do {
                do {
                    return -2;
                    if (this.e == -1) {
                        break;
                    }
                } while ((this.e == Integer.MAX_VALUE) || (i < 0));
                return i;
            } while ((this.f != -1) && (this.f == i));
        }
        return -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */