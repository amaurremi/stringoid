package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

class af
        extends BaseAdapter {
    private q b;
    private int c = -1;

    public af(ae paramae, q paramq) {
        this.b = paramq;
        a();
    }

    public u a(int paramInt) {
        if (ae.a(this.a)) {
        }
        for (ArrayList localArrayList = this.b.l(); ; localArrayList = this.b.i()) {
            int i = paramInt;
            if (this.c >= 0) {
                i = paramInt;
                if (paramInt >= this.c) {
                    i = paramInt + 1;
                }
            }
            return (u) localArrayList.get(i);
        }
    }

    void a() {
        u localu = ae.c(this.a).r();
        if (localu != null) {
            ArrayList localArrayList = ae.c(this.a).l();
            int j = localArrayList.size();
            int i = 0;
            while (i < j) {
                if ((u) localArrayList.get(i) == localu) {
                    this.c = i;
                    return;
                }
                i += 1;
            }
        }
        this.c = -1;
    }

    public int getCount() {
        if (ae.a(this.a)) {
        }
        for (ArrayList localArrayList = this.b.l(); this.c < 0; localArrayList = this.b.i()) {
            return localArrayList.size();
        }
        return localArrayList.size() - 1;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            paramView = ae.b(this.a).inflate(ae.b, paramViewGroup, false);
        }
        for (; ; ) {
            paramViewGroup = (aj) paramView;
            if (this.a.c) {
                ((ListMenuItemView) paramView).setForceShowIcon(true);
            }
            paramViewGroup.a(a(paramInt), 0);
            return paramView;
        }
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */