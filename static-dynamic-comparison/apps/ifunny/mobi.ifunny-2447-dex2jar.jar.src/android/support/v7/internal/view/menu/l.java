package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class l
        implements ag {
    private ah a;
    private int b;
    protected Context c;
    protected Context d;
    protected q e;
    protected LayoutInflater f;
    protected LayoutInflater g;
    protected ai h;
    private int i;
    private int j;

    public l(Context paramContext, int paramInt1, int paramInt2) {
        this.c = paramContext;
        this.f = LayoutInflater.from(paramContext);
        this.b = paramInt1;
        this.i = paramInt2;
    }

    public ai a(ViewGroup paramViewGroup) {
        if (this.h == null) {
            this.h = ((ai) this.f.inflate(this.b, paramViewGroup, false));
            this.h.a(this.e);
            c(true);
        }
        return this.h;
    }

    public View a(u paramu, View paramView, ViewGroup paramViewGroup) {
        if ((paramView instanceof aj)) {
        }
        for (paramView = (aj) paramView; ; paramView = b(paramViewGroup)) {
            a(paramu, paramView);
            return (View) paramView;
        }
    }

    public void a(Context paramContext, q paramq) {
        this.d = paramContext;
        this.g = LayoutInflater.from(this.d);
        this.e = paramq;
    }

    public void a(ah paramah) {
        this.a = paramah;
    }

    public void a(q paramq, boolean paramBoolean) {
        if (this.a != null) {
            this.a.a(paramq, paramBoolean);
        }
    }

    public abstract void a(u paramu, aj paramaj);

    protected void a(View paramView, int paramInt) {
        ViewGroup localViewGroup = (ViewGroup) paramView.getParent();
        if (localViewGroup != null) {
            localViewGroup.removeView(paramView);
        }
        ((ViewGroup) this.h).addView(paramView, paramInt);
    }

    public boolean a(int paramInt, u paramu) {
        return true;
    }

    public boolean a(am paramam) {
        if (this.a != null) {
            return this.a.b(paramam);
        }
        return false;
    }

    public boolean a(q paramq, u paramu) {
        return false;
    }

    protected boolean a(ViewGroup paramViewGroup, int paramInt) {
        paramViewGroup.removeViewAt(paramInt);
        return true;
    }

    public aj b(ViewGroup paramViewGroup) {
        return (aj) this.f.inflate(this.i, paramViewGroup, false);
    }

    public void b(int paramInt) {
        this.j = paramInt;
    }

    public boolean b(q paramq, u paramu) {
        return false;
    }

    public void c(boolean paramBoolean) {
        ViewGroup localViewGroup = (ViewGroup) this.h;
        if (localViewGroup == null) {
        }
        label193:
        label199:
        for (; ; ) {
            return;
            int m;
            if (this.e != null) {
                this.e.j();
                ArrayList localArrayList = this.e.i();
                int i1 = localArrayList.size();
                int n = 0;
                int k = 0;
                m = k;
                if (n < i1) {
                    u localu2 = (u) localArrayList.get(n);
                    if (!a(k, localu2)) {
                        break label193;
                    }
                    View localView1 = localViewGroup.getChildAt(k);
                    if ((localView1 instanceof aj)) {
                    }
                    for (u localu1 = ((aj) localView1).getItemData(); ; localu1 = null) {
                        View localView2 = a(localu2, localView1, localViewGroup);
                        if (localu2 != localu1) {
                            localView2.setPressed(false);
                        }
                        if (localView2 != localView1) {
                            a(localView2, k);
                        }
                        k += 1;
                        n += 1;
                        break;
                    }
                }
            }
            for (; ; ) {
                if (m >= localViewGroup.getChildCount()) {
                    break label199;
                }
                if (!a(localViewGroup, m)) {
                    m += 1;
                    continue;
                    break;
                    m = 0;
                }
            }
        }
    }

    public boolean g() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */