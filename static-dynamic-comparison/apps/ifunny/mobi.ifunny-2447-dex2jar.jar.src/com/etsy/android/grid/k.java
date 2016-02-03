package com.etsy.android.grid;

import android.support.v4.d.n;
import android.support.v4.view.bd;
import android.view.View;
import android.widget.AbsListView.RecyclerListener;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

class k {
    private AbsListView.RecyclerListener b;
    private int c;
    private View[] d = new View[0];
    private ArrayList<View>[] e;
    private int f;
    private ArrayList<View> g;
    private ArrayList<View> h;
    private n<View> i;

    k(ExtendableListView paramExtendableListView) {
    }

    private void f() {
        int n = 0;
        int i1 = this.d.length;
        int i2 = this.f;
        ArrayList[] arrayOfArrayList = this.e;
        int j = 0;
        int k;
        while (j < i2) {
            ArrayList localArrayList = arrayOfArrayList[j];
            int i3 = localArrayList.size();
            k = i3 - 1;
            int m = 0;
            while (m < i3 - i1) {
                ExtendableListView.e(this.a, (View) localArrayList.remove(k), false);
                m += 1;
                k -= 1;
            }
            j += 1;
        }
        if (this.i != null) {
            for (j = n; j < this.i.b(); j = k + 1) {
                k = j;
                if (!bd.b((View) this.i.f(j))) {
                    this.i.d(j);
                    k = j - 1;
                }
            }
        }
    }

    public void a() {
        int m = 0;
        ArrayList localArrayList;
        int k;
        if (this.f == 1) {
            localArrayList = this.g;
            k = localArrayList.size();
            j = 0;
            while (j < k) {
                ((View) localArrayList.get(j)).forceLayout();
                j += 1;
            }
        }
        int n = this.f;
        int j = 0;
        while (j < n) {
            localArrayList = this.e[j];
            int i1 = localArrayList.size();
            k = 0;
            while (k < i1) {
                ((View) localArrayList.get(k)).forceLayout();
                k += 1;
            }
            j += 1;
        }
        if (this.i != null) {
            k = this.i.b();
            j = m;
            while (j < k) {
                ((View) this.i.f(j)).forceLayout();
                j += 1;
            }
        }
    }

    public void a(int paramInt) {
        if (paramInt < 1) {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
        int j = 0;
        while (j < paramInt) {
            arrayOfArrayList[j] = new ArrayList();
            j += 1;
        }
        this.f = paramInt;
        this.g = arrayOfArrayList[0];
        this.e = arrayOfArrayList;
    }

    void a(int paramInt1, int paramInt2) {
        if (this.d.length < paramInt1) {
            this.d = new View[paramInt1];
        }
        this.c = paramInt2;
        View[] arrayOfView = this.d;
        paramInt2 = 0;
        while (paramInt2 < paramInt1) {
            View localView = this.a.getChildAt(paramInt2);
            h localh = (h) localView.getLayoutParams();
            if ((localh != null) && (localh.d != -2)) {
                arrayOfView[paramInt2] = localView;
            }
            paramInt2 += 1;
        }
    }

    void a(View paramView, int paramInt) {
        h localh = (h) paramView.getLayoutParams();
        if (localh == null) {
        }
        for (; ; ) {
            return;
            localh.b = paramInt;
            int j = localh.d;
            boolean bool = bd.b(paramView);
            if ((!b(j)) || (bool)) {
                if ((j != -2) || (bool)) {
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add(paramView);
                }
                if (bool) {
                    if (this.i == null) {
                        this.i = new n();
                    }
                    this.i.b(paramInt, paramView);
                }
            } else {
                if (this.f == 1) {
                    this.g.add(paramView);
                }
                while (this.b != null) {
                    this.b.onMovedToScrapHeap(paramView);
                    return;
                    this.e[j].add(paramView);
                }
            }
        }
    }

    void a(List<View> paramList) {
        if (this.f == 1) {
            paramList.addAll(this.g);
        }
        for (; ; ) {
            return;
            int k = this.f;
            ArrayList[] arrayOfArrayList = this.e;
            int j = 0;
            while (j < k) {
                paramList.addAll(arrayOfArrayList[j]);
                j += 1;
            }
        }
    }

    void b() {
        ArrayList localArrayList;
        int k;
        if (this.f == 1) {
            localArrayList = this.g;
            k = localArrayList.size();
            j = 0;
            while (j < k) {
                ExtendableListView.a(this.a, (View) localArrayList.remove(k - 1 - j), false);
                j += 1;
            }
        }
        int m = this.f;
        int j = 0;
        while (j < m) {
            localArrayList = this.e[j];
            int n = localArrayList.size();
            k = 0;
            while (k < n) {
                ExtendableListView.b(this.a, (View) localArrayList.remove(n - 1 - k), false);
                k += 1;
            }
            j += 1;
        }
        if (this.i != null) {
            this.i.c();
        }
    }

    public boolean b(int paramInt) {
        return paramInt >= 0;
    }

    View c(int paramInt) {
        paramInt -= this.c;
        View[] arrayOfView = this.d;
        if ((paramInt >= 0) && (paramInt < arrayOfView.length)) {
            View localView = arrayOfView[paramInt];
            arrayOfView[paramInt] = null;
            return localView;
        }
        return null;
    }

    void c() {
        if (this.i != null) {
            this.i.c();
        }
    }

    View d(int paramInt) {
        if (this.f == 1) {
            return ExtendableListView.a(this.g, paramInt);
        }
        int j = this.a.a.getItemViewType(paramInt);
        if ((j >= 0) && (j < this.e.length)) {
            return ExtendableListView.a(this.e[j], paramInt);
        }
        return null;
    }

    void d() {
        if (this.h == null) {
            return;
        }
        int k = this.h.size();
        int j = 0;
        while (j < k) {
            ExtendableListView.c(this.a, (View) this.h.get(j), false);
            j += 1;
        }
        this.h.clear();
    }

    void e() {
        View[] arrayOfView = this.d;
        int j;
        int k;
        label25:
        Object localObject1;
        int m;
        label37:
        View localView;
        Object localObject2;
        int n;
        if (this.f > 1) {
            j = 1;
            if (this.b == null) {
                break label183;
            }
            k = 1;
            localObject1 = this.g;
            m = arrayOfView.length - 1;
            if (m < 0) {
                break label246;
            }
            localView = arrayOfView[m];
            localObject2 = localObject1;
            if (localView != null) {
                localObject2 = (h) localView.getLayoutParams();
                arrayOfView[m] = null;
                boolean bool = bd.b(localView);
                n = ((h) localObject2).d;
                if ((b(n)) && (!bool)) {
                    break label188;
                }
                if ((n != -2) || (bool)) {
                    ExtendableListView.d(this.a, localView, false);
                }
                localObject2 = localObject1;
                if (bool) {
                    if (this.i == null) {
                        this.i = new n();
                    }
                    this.i.b(this.c + m, localView);
                    localObject2 = localObject1;
                }
            }
        }
        for (; ; ) {
            m -= 1;
            localObject1 = localObject2;
            break label37;
            j = 0;
            break;
            label183:
            k = 0;
            break label25;
            label188:
            if (j != 0) {
                localObject1 = this.e[n];
            }
            ((h) localObject2).b = (this.c + m);
            ((ArrayList) localObject1).add(localView);
            localObject2 = localObject1;
            if (k != 0) {
                this.b.onMovedToScrapHeap(localView);
                localObject2 = localObject1;
            }
        }
        label246:
        f();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */