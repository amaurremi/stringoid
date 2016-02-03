package android.support.v7.a;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.view.View;

import java.util.ArrayList;

class x
        extends a {
    final Activity a;
    final b b;
    final ActionBar c;
    ab d;
    private ArrayList e = new ArrayList();

    public x(Activity paramActivity, b paramb) {
        this(paramActivity, paramb, true);
    }

    x(Activity paramActivity, b paramb, boolean paramBoolean) {
        this.a = paramActivity;
        this.b = paramb;
        this.c = paramActivity.getActionBar();
        if ((paramBoolean) && ((d() & 0x4) != 0)) {
            d(true);
        }
    }

    public int a() {
        return this.c.getSelectedNavigationIndex();
    }

    public void a(int paramInt) {
        this.c.setCustomView(paramInt);
    }

    public void a(e parame) {
        this.c.addTab(((y) parame).a);
    }

    public void a(CharSequence paramCharSequence) {
        this.c.setTitle(paramCharSequence);
    }

    public void a(boolean paramBoolean) {
        this.c.setDisplayHomeAsUpEnabled(paramBoolean);
    }

    public View b() {
        return this.c.getCustomView();
    }

    public void b(int paramInt) {
        this.c.setSelectedNavigationItem(paramInt);
    }

    public void b(boolean paramBoolean) {
        this.c.setDisplayShowTitleEnabled(paramBoolean);
    }

    public CharSequence c() {
        return this.c.getTitle();
    }

    public void c(int paramInt) {
        this.c.setNavigationMode(paramInt);
    }

    public void c(boolean paramBoolean) {
        this.c.setDisplayShowCustomEnabled(paramBoolean);
    }

    public int d() {
        return this.c.getDisplayOptions();
    }

    public void d(boolean paramBoolean) {
        this.c.setHomeButtonEnabled(paramBoolean);
    }

    public e e() {
        ActionBar.Tab localTab = this.c.newTab();
        y localy = new y(this, localTab);
        localTab.setTag(localy);
        return localy;
    }

    public void f() {
        this.c.show();
    }

    public void g() {
        this.c.hide();
    }

    public boolean h() {
        return this.c.isShowing();
    }

    public Context i() {
        return this.c.getThemedContext();
    }

    ab j() {
        if (this.d == null) {
            this.d = this.b.f().a().a();
        }
        return this.d;
    }

    void k() {
        if ((this.d != null) && (!this.d.e())) {
            this.d.b();
        }
        this.d = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */