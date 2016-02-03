package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.b.h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class o
        implements ag, AdapterView.OnItemClickListener {
    Context a;
    LayoutInflater b;
    q c;
    ExpandedMenuView d;
    int e;
    int f;
    p g;
    private int h;
    private ah i;

    public o(int paramInt1, int paramInt2) {
        this.f = paramInt1;
        this.e = paramInt2;
    }

    public ai a(ViewGroup paramViewGroup) {
        if (this.g == null) {
            this.g = new p(this);
        }
        if (!this.g.isEmpty()) {
            if (this.d == null) {
                this.d = ((ExpandedMenuView) this.b.inflate(h.abc_expanded_menu_layout, paramViewGroup, false));
                this.d.setAdapter(this.g);
                this.d.setOnItemClickListener(this);
            }
            return this.d;
        }
        return null;
    }

    public ListAdapter a() {
        if (this.g == null) {
            this.g = new p(this);
        }
        return this.g;
    }

    public void a(Context paramContext, q paramq) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(paramContext, this.e);
            this.b = LayoutInflater.from(this.a);
        }
        for (; ; ) {
            this.c = paramq;
            if (this.g != null) {
                this.g.notifyDataSetChanged();
            }
            return;
            if (this.a != null) {
                this.a = paramContext;
                if (this.b == null) {
                    this.b = LayoutInflater.from(this.a);
                }
            }
        }
    }

    public void a(ah paramah) {
        this.i = paramah;
    }

    public void a(q paramq, boolean paramBoolean) {
        if (this.i != null) {
            this.i.a(paramq, paramBoolean);
        }
    }

    public boolean a(am paramam) {
        if (!paramam.hasVisibleItems()) {
            return false;
        }
        new t(paramam).a(null);
        if (this.i != null) {
            this.i.b(paramam);
        }
        return true;
    }

    public boolean a(q paramq, u paramu) {
        return false;
    }

    public boolean b(q paramq, u paramu) {
        return false;
    }

    public void c(boolean paramBoolean) {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    public boolean g() {
        return false;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        this.c.a(this.g.a(paramInt), 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */