package mobi.ifunny.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

class e
        extends BaseAdapter
        implements ListAdapter {
    private final BaseAdapter b;
    private boolean c = true;
    private boolean d = true;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private LayoutInflater k;
    private DataSetObserver l;
    private View.OnClickListener m = new f(this);

    public e(DynamicListView paramDynamicListView, Context paramContext, BaseAdapter paramBaseAdapter) {
        this.b = paramBaseAdapter;
        this.l = new g(this, paramDynamicListView);
        this.f = -1;
        this.i = false;
        paramBaseAdapter.registerDataSetObserver(this.l);
        this.k = LayoutInflater.from(paramContext);
    }

    private boolean a(int paramInt) {
        return (b(paramInt)) || (c(paramInt));
    }

    private boolean b(int paramInt) {
        boolean bool = true;
        if (this.c) {
            bool = false;
        }
        do {
            do {
                return bool;
                if (!this.d) {
                    break;
                }
            } while (paramInt >= this.b.getCount());
            return false;
        } while (paramInt >= this.b.getCount() + 1);
        return false;
    }

    private boolean c(int paramInt) {
        if (this.d) {
        }
        while (paramInt != 0) {
            return false;
        }
        return true;
    }

    private int d(int paramInt) {
        if (this.d) {
            return paramInt;
        }
        return paramInt - 1;
    }

    private void e(int paramInt) {
        if ((!this.c) && (DynamicListView.g(this.a) + paramInt + 1 >= getCount())) {
            n();
        }
        if ((!this.d) && (paramInt - DynamicListView.h(this.a) <= 0)) {
            m();
        }
    }

    private void g() {
        a(this.e);
    }

    private void h() {
        b(this.g);
    }

    private int i() {
        if (DynamicListView.d(this.a)) {
            return k();
        }
        return l();
    }

    private int j() {
        if (DynamicListView.e(this.a)) {
            return k();
        }
        return l();
    }

    private int k() {
        return this.b.getViewTypeCount();
    }

    private int l() {
        return this.b.getViewTypeCount() + 1;
    }

    private void m() {
        if ((!this.j) && (DynamicListView.e(this.a))) {
            if (DynamicListView.b(this.a) != null) {
                DynamicListView.b(this.a).P();
            }
            this.j = true;
        }
    }

    private void n() {
        if ((!this.i) && (DynamicListView.d(this.a))) {
            if (DynamicListView.b(this.a) != null) {
                DynamicListView.b(this.a).O();
            }
            this.i = true;
        }
    }

    public void a(boolean paramBoolean) {
        if (this.c != paramBoolean) {
            this.i = false;
            this.c = paramBoolean;
            notifyDataSetChanged();
        }
        this.f = -1;
    }

    public boolean a() {
        return this.f >= 0;
    }

    public boolean areAllItemsEnabled() {
        return (this.b != null) && (this.b.areAllItemsEnabled());
    }

    public void b(boolean paramBoolean) {
        if (this.d != paramBoolean) {
            this.i = false;
            this.d = paramBoolean;
            notifyDataSetChanged();
        }
        this.h = -1;
    }

    public boolean b() {
        return this.f >= 0;
    }

    public void c() {
        if (this.i) {
            this.i = false;
            notifyDataSetChanged();
        }
    }

    public void d() {
        if (this.j) {
            this.j = false;
            notifyDataSetChanged();
        }
    }

    public boolean e() {
        return this.d;
    }

    public void f() {
        this.b.unregisterDataSetObserver(this.l);
    }

    public int getCount() {
        int i1 = 0;
        int i2 = this.b.getCount();
        if (i2 == 0) {
            return 0;
        }
        int n;
        if (this.c) {
            n = 0;
            if (!this.d) {
                break label43;
            }
        }
        for (; ; ) {
            return i2 + (n + i1);
            n = 1;
            break;
            label43:
            i1 = 1;
        }
    }

    public Object getItem(int paramInt) {
        if (a(paramInt)) {
            return null;
        }
        return this.b.getItem(d(paramInt));
    }

    public long getItemId(int paramInt) {
        if (a(paramInt)) {
            return paramInt;
        }
        return this.b.getItemId(d(paramInt));
    }

    public int getItemViewType(int paramInt) {
        if (b(paramInt)) {
            return i();
        }
        if (c(paramInt)) {
            return j();
        }
        return this.b.getItemViewType(d(paramInt));
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        boolean bool1 = c(paramInt);
        boolean bool2 = b(paramInt);
        if ((this.c) && (bool2)) {
            if (this.f > 0) {
                this.f -= 1;
                e(paramInt);
                if (!bool2) {
                    break label209;
                }
                if (!DynamicListView.d(this.a)) {
                    break label147;
                }
                paramViewGroup = paramView;
                if (paramView == null) {
                    paramViewGroup = this.k.inflate(DynamicListView.f(this.a), null);
                }
            }
        }
        label147:
        label209:
        do {
            return paramViewGroup;
            if (this.f != 0) {
                break;
            }
            g();
            break;
            if ((!this.d) || (!bool1)) {
                break;
            }
            if (this.h > 0) {
                this.h -= 1;
                break;
            }
            if (this.h != 0) {
                break;
            }
            h();
            break;
            localc = DynamicListView.c(this.a).a(0);
            localView = localc.c();
            paramView = localView;
            if (localView == null) {
                paramView = localc.a(this.k, paramViewGroup);
                paramView.setTag(Integer.valueOf(0));
                paramView.setOnClickListener(this.m);
            }
            localc.a();
            return paramView;
            if (!bool1) {
                break label308;
            }
            if (!DynamicListView.e(this.a)) {
                break label246;
            }
            paramViewGroup = paramView;
        } while (paramView != null);
        return this.k.inflate(DynamicListView.f(this.a), null);
        label246:
        c localc = DynamicListView.c(this.a).a(1);
        View localView = localc.c();
        paramView = localView;
        if (localView == null) {
            paramView = localc.a(this.k, paramViewGroup);
            paramView.setTag(Integer.valueOf(1));
            paramView.setOnClickListener(this.m);
        }
        localc.a();
        return paramView;
        label308:
        return this.b.getView(d(paramInt), paramView, paramViewGroup);
    }

    public int getViewTypeCount() {
        return this.b.getViewTypeCount() + 2;
    }

    public boolean hasStableIds() {
        return this.b.hasStableIds();
    }

    public boolean isEmpty() {
        return (this.b == null) || ((this.c) && (this.b.isEmpty()) && (this.d));
    }

    public boolean isEnabled(int paramInt) {
        if (b(paramInt)) {
            if (DynamicListView.d(this.a)) {
            }
        }
        do {
            return true;
            return false;
            if (!c(paramInt)) {
                break;
            }
        } while (!DynamicListView.e(this.a));
        return false;
        return this.b.isEnabled(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */