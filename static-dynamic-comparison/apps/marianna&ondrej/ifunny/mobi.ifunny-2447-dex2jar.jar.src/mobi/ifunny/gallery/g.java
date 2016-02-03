package mobi.ifunny.gallery;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import mobi.ifunny.rest.content.Feed;

public abstract class g<D, T extends Feed<D>>
        extends BaseAdapter {
    private T a;
    protected List<h<D>> d;

    protected g(T paramT) {
        this.a = paramT;
        this.d = new ArrayList();
    }

    protected int a(D paramD) {
        return 0;
    }

    public View a(int paramInt, h<D> paramh, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    protected Collection<h<D>> a(Collection<D> paramCollection) {
        ArrayList localArrayList = new ArrayList(paramCollection.size());
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            Object localObject = paramCollection.next();
            localArrayList.add(new h(localObject, a(localObject)));
        }
        return localArrayList;
    }

    public void a(int paramInt, D paramD) {
        a(paramInt, new h(paramD, a(paramD)));
    }

    public void a(int paramInt, h<D> paramh) {
        this.d.set(paramInt, paramh);
        this.a.getList().set(paramInt, paramh.a);
        notifyDataSetChanged();
    }

    public void a(D paramD, int paramInt) {
        a(new h(paramD, a(paramD)), paramInt);
    }

    public void a(List<D> paramList, List<Integer> paramList1) {
        int i = 0;
        while (i < paramList.size()) {
            Object localObject = paramList.get(i);
            int j = ((Integer) paramList1.get(i)).intValue();
            if (j >= 0) {
                this.d.set(j, new h(localObject, a(localObject)));
                this.a.getList().set(j, localObject);
            }
            i += 1;
        }
        notifyDataSetChanged();
    }

    public void a(h<D> paramh) {
        a(paramh, this.d.size());
    }

    public void a(h<D> paramh, int paramInt) {
        this.d.add(paramInt, paramh);
        this.a.getList().add(paramInt, paramh.a);
        notifyDataSetChanged();
    }

    public void a(T paramT) {
        this.a = paramT;
        this.d.clear();
        int j = paramT.getList().size();
        int i = 0;
        while (i < j) {
            Object localObject = paramT.getList().get(i);
            localObject = new h(localObject, a(localObject));
            this.d.add(localObject);
            i += 1;
        }
        notifyDataSetChanged();
    }

    public void b(D paramD) {
        a(new h(paramD, a(paramD)));
    }

    public void b(Collection<D> paramCollection) {
        this.d.removeAll(a(paramCollection));
        this.a.getList().removeAll(paramCollection);
        notifyDataSetChanged();
    }

    public void b(h<D> paramh) {
        if (this.d.remove(paramh)) {
            this.a.getList().remove(paramh.a);
            notifyDataSetChanged();
        }
    }

    public void b(T paramT) {
        if (this.a == null) {
            this.a = paramT;
        }
        for (; ; ) {
            int j = paramT.getList().size();
            int i = 0;
            while (i < j) {
                Object localObject = paramT.getList().get(i);
                localObject = new h(localObject, a(localObject));
                this.d.add(localObject);
                i += 1;
            }
            this.a.updateNext(paramT);
        }
        notifyDataSetChanged();
    }

    public abstract View c(int paramInt, h<D> paramh, View paramView, ViewGroup paramViewGroup);

    public h<D> c(int paramInt) {
        if (paramInt >= getCount()) {
            return null;
        }
        return (h) this.d.get(paramInt);
    }

    public void c(D paramD) {
        b(new h(paramD, a(paramD)));
    }

    public void c(T paramT) {
        if (this.a == null) {
            this.a = paramT;
        }
        for (; ; ) {
            int j = paramT.getList().size();
            int i = 0;
            while (i < j) {
                Object localObject = paramT.getList().get(i);
                localObject = new h(localObject, a(localObject));
                this.d.add(i, localObject);
                i += 1;
            }
            this.a.updatePrev(paramT);
        }
        notifyDataSetChanged();
    }

    public void d(int paramInt) {
        this.d.remove(paramInt);
        this.a.getList().remove(paramInt);
        notifyDataSetChanged();
    }

    public void e() {
        if ((this.a == null) || (this.d == null)) {
            return;
        }
        this.a.clear();
        this.d.clear();
        this.a = null;
        notifyDataSetChanged();
    }

    public T f() {
        return this.a;
    }

    public void g() {
    }

    public int getCount() {
        return this.d.size();
    }

    public int getItemViewType(int paramInt) {
        return c(paramInt).b;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        h localh = c(paramInt);
        if (localh.b == 0) {
            return c(paramInt, localh, paramView, paramViewGroup);
        }
        return a(paramInt, localh, paramView, paramViewGroup);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */