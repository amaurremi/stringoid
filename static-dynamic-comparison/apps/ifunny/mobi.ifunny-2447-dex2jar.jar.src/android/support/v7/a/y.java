package android.support.v7.a;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.view.View;

class y
        extends e
        implements ActionBar.TabListener {
    final ActionBar.Tab a;
    private CharSequence c;
    private f d;

    public y(x paramx, ActionBar.Tab paramTab) {
        this.a = paramTab;
    }

    public int a() {
        return this.a.getPosition();
    }

    public e a(int paramInt) {
        this.a.setText(paramInt);
        return this;
    }

    public e a(f paramf) {
        this.d = paramf;
        ActionBar.Tab localTab = this.a;
        if (paramf != null) {
        }
        for (paramf = this; ; paramf = null) {
            localTab.setTabListener(paramf);
            return this;
        }
    }

    public Drawable b() {
        return this.a.getIcon();
    }

    public CharSequence c() {
        return this.a.getText();
    }

    public View d() {
        return this.a.getCustomView();
    }

    public void e() {
        this.a.select();
    }

    public CharSequence f() {
        return this.c;
    }

    public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        f localf = this.d;
        if (paramFragmentTransaction != null) {
        }
        for (paramTab = this.b.j(); ; paramTab = null) {
            localf.c(this, paramTab);
            this.b.k();
            return;
        }
    }

    public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        f localf = this.d;
        if (paramFragmentTransaction != null) {
        }
        for (paramTab = this.b.j(); ; paramTab = null) {
            localf.a(this, paramTab);
            this.b.k();
            return;
        }
    }

    public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        f localf = this.d;
        if (paramFragmentTransaction != null) {
        }
        for (paramTab = this.b.j(); ; paramTab = null) {
            localf.b(this, paramTab);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */