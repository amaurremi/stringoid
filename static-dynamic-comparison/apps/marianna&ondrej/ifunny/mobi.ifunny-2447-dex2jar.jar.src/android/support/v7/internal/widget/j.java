package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.b.a.b;
import android.support.v7.c.c;
import android.support.v7.internal.view.menu.ag;
import android.support.v7.internal.view.menu.am;
import android.support.v7.internal.view.menu.q;
import android.support.v7.internal.view.menu.u;
import android.view.View;
import android.widget.LinearLayout;

class j
        implements ag {
    q a;
    u b;

    private j(ActionBarView paramActionBarView) {
    }

    public void a(Context paramContext, q paramq) {
        if ((this.a != null) && (this.b != null)) {
            this.a.d(this.b);
        }
        this.a = paramq;
    }

    public void a(q paramq, boolean paramBoolean) {
    }

    public boolean a(am paramam) {
        return false;
    }

    public boolean a(q paramq, u paramu) {
        this.c.g = paramu.getActionView();
        ActionBarView.e(this.c).a(ActionBarView.d(this.c).getConstantState().newDrawable(this.c.getResources()));
        this.b = paramu;
        if (this.c.g.getParent() != this.c) {
            this.c.addView(this.c.g);
        }
        if (ActionBarView.e(this.c).getParent() != this.c) {
            this.c.addView(ActionBarView.e(this.c));
        }
        ActionBarView.f(this.c).setVisibility(8);
        if (ActionBarView.g(this.c) != null) {
            ActionBarView.g(this.c).setVisibility(8);
        }
        if (ActionBarView.h(this.c) != null) {
            ActionBarView.h(this.c).setVisibility(8);
        }
        if (ActionBarView.i(this.c) != null) {
            ActionBarView.i(this.c).setVisibility(8);
        }
        if (ActionBarView.j(this.c) != null) {
            ActionBarView.j(this.c).setVisibility(8);
        }
        this.c.requestLayout();
        paramu.e(true);
        if ((this.c.g instanceof c)) {
            ((c) this.c.g).onActionViewExpanded();
        }
        return true;
    }

    public boolean b(q paramq, u paramu) {
        if ((this.c.g instanceof c)) {
            ((c) this.c.g).onActionViewCollapsed();
        }
        this.c.removeView(this.c.g);
        this.c.removeView(ActionBarView.e(this.c));
        this.c.g = null;
        if ((ActionBarView.k(this.c) & 0x2) != 0) {
            ActionBarView.f(this.c).setVisibility(0);
        }
        if ((ActionBarView.k(this.c) & 0x8) != 0) {
            if (ActionBarView.g(this.c) != null) {
                break label245;
            }
            ActionBarView.l(this.c);
        }
        for (; ; ) {
            if ((ActionBarView.h(this.c) != null) && (ActionBarView.m(this.c) == 2)) {
                ActionBarView.h(this.c).setVisibility(0);
            }
            if ((ActionBarView.i(this.c) != null) && (ActionBarView.m(this.c) == 1)) {
                ActionBarView.i(this.c).setVisibility(0);
            }
            if ((ActionBarView.j(this.c) != null) && ((ActionBarView.k(this.c) & 0x10) != 0)) {
                ActionBarView.j(this.c).setVisibility(0);
            }
            ActionBarView.e(this.c).a(null);
            this.b = null;
            this.c.requestLayout();
            paramu.e(false);
            return true;
            label245:
            ActionBarView.g(this.c).setVisibility(0);
        }
    }

    public void c(boolean paramBoolean) {
        if (this.b != null) {
            if (this.a == null) {
                break label74;
            }
            int j = this.a.size();
            i = 0;
            if (i >= j) {
                break label74;
            }
            if ((b) this.a.getItem(i) != this.b) {
                break label67;
            }
        }
        label67:
        label74:
        for (int i = 1; ; i = 0) {
            if (i == 0) {
                b(this.a, this.b);
            }
            return;
            i += 1;
            break;
        }
    }

    public boolean g() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */