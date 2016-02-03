package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

class p
        extends BaseAdapter {
    private int b = -1;

    public p(o paramo) {
        a();
    }

    public u a(int paramInt) {
        ArrayList localArrayList = this.a.c.l();
        int i = o.a(this.a) + paramInt;
        paramInt = i;
        if (this.b >= 0) {
            paramInt = i;
            if (i >= this.b) {
                paramInt = i + 1;
            }
        }
        return (u) localArrayList.get(paramInt);
    }

    void a() {
        u localu = this.a.c.r();
        if (localu != null) {
            ArrayList localArrayList = this.a.c.l();
            int j = localArrayList.size();
            int i = 0;
            while (i < j) {
                if ((u) localArrayList.get(i) == localu) {
                    this.b = i;
                    return;
                }
                i += 1;
            }
        }
        this.b = -1;
    }

    public int getCount() {
        int i = this.a.c.l().size() - o.a(this.a);
        if (this.b < 0) {
            return i;
        }
        return i - 1;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            paramView = this.a.b.inflate(this.a.f, paramViewGroup, false);
        }
        for (; ; ) {
            ((aj) paramView).a(a(paramInt), 0);
            return paramView;
        }
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */