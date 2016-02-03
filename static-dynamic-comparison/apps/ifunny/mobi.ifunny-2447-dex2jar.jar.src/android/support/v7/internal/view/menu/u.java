package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.b;
import android.support.v4.view.an;
import android.support.v4.view.n;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class u
        implements b {
    private static String w;
    private static String x;
    private static String y;
    private static String z;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k = 0;
    private q l;
    private am m;
    private Runnable n;
    private MenuItem.OnMenuItemClickListener o;
    private int p = 16;
    private int q = 0;
    private View r;
    private n s;
    private an t;
    private boolean u = false;
    private ContextMenu.ContextMenuInfo v;

    u(q paramq, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
        this.l = paramq;
        this.a = paramInt2;
        this.b = paramInt1;
        this.c = paramInt3;
        this.d = paramInt4;
        this.e = paramCharSequence;
        this.q = paramInt5;
    }

    public b a(int paramInt) {
        Context localContext = this.l.e();
        a(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
        return this;
    }

    public b a(an paraman) {
        this.t = paraman;
        return this;
    }

    public b a(n paramn) {
        if (this.s == paramn) {
        }
        do {
            return this;
            this.r = null;
            if (this.s != null) {
                this.s.a(null);
            }
            this.s = paramn;
            this.l.b(true);
        } while (paramn == null);
        paramn.a(new v(this));
        return this;
    }

    public b a(View paramView) {
        this.r = paramView;
        this.s = null;
        if ((paramView != null) && (paramView.getId() == -1) && (this.a > 0)) {
            paramView.setId(this.a);
        }
        this.l.b(this);
        return this;
    }

    CharSequence a(aj paramaj) {
        if ((paramaj != null) && (paramaj.a())) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    void a(am paramam) {
        this.m = paramam;
        paramam.setHeaderTitle(getTitle());
    }

    void a(ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        this.v = paramContextMenuInfo;
    }

    public void a(boolean paramBoolean) {
        int i2 = this.p;
        if (paramBoolean) {
        }
        for (int i1 = 4; ; i1 = 0) {
            this.p = (i1 | i2 & 0xFFFFFFFB);
            return;
        }
    }

    public boolean a() {
        if ((this.o != null) && (this.o.onMenuItemClick(this))) {
        }
        do {
            do {
                return true;
            } while (this.l.a(this.l.p(), this));
            if (this.n != null) {
                this.n.run();
                return true;
            }
            if (this.g != null) {
                try {
                    this.l.e().startActivity(this.g);
                    return true;
                } catch (ActivityNotFoundException localActivityNotFoundException) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
                }
            }
        } while ((this.s != null) && (this.s.f()));
        return false;
    }

    public int b() {
        return this.d;
    }

    public b b(int paramInt) {
        setShowAsAction(paramInt);
        return this;
    }

    void b(boolean paramBoolean) {
        int i2 = this.p;
        int i3 = this.p;
        if (paramBoolean) {
        }
        for (int i1 = 2; ; i1 = 0) {
            this.p = (i1 | i3 & 0xFFFFFFFD);
            if (i2 != this.p) {
                this.l.b(false);
            }
            return;
        }
    }

    char c() {
        return this.i;
    }

    boolean c(boolean paramBoolean) {
        boolean bool = false;
        int i2 = this.p;
        int i3 = this.p;
        if (paramBoolean) {
        }
        for (int i1 = 0; ; i1 = 8) {
            this.p = (i1 | i3 & 0xFFFFFFF7);
            paramBoolean = bool;
            if (i2 != this.p) {
                paramBoolean = true;
            }
            return paramBoolean;
        }
    }

    public boolean collapseActionView() {
        if ((this.q & 0x8) == 0) {
        }
        do {
            return false;
            if (this.r == null) {
                return true;
            }
        } while ((this.t != null) && (!this.t.b(this)));
        return this.l.d(this);
    }

    String d() {
        char c1 = c();
        if (c1 == 0) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder(w);
        switch (c1) {
            default:
                localStringBuilder.append(c1);
        }
        for (; ; ) {
            return localStringBuilder.toString();
            localStringBuilder.append(x);
            continue;
            localStringBuilder.append(y);
            continue;
            localStringBuilder.append(z);
        }
    }

    public void d(boolean paramBoolean) {
        if (paramBoolean) {
            this.p |= 0x20;
            return;
        }
        this.p &= 0xFFFFFFDF;
    }

    public void e(boolean paramBoolean) {
        this.u = paramBoolean;
        this.l.b(false);
    }

    boolean e() {
        return (this.l.c()) && (c() != 0);
    }

    public boolean expandActionView() {
        if (((this.q & 0x8) == 0) || (this.r == null)) {
        }
        while ((this.t != null) && (!this.t.a(this))) {
            return false;
        }
        return this.l.c(this);
    }

    public boolean f() {
        return (this.p & 0x4) != 0;
    }

    public void g() {
        this.l.b(this);
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
    }

    public View getActionView() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s != null) {
            this.r = this.s.a(this);
            return this.r;
        }
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        if (this.j != null) {
            return this.j;
        }
        if (this.k != 0) {
            Drawable localDrawable = this.l.d().getDrawable(this.k);
            this.k = 0;
            this.j = localDrawable;
            return localDrawable;
        }
        return null;
    }

    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.v;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.m;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        if (this.f != null) {
            return this.f;
        }
        return this.e;
    }

    public boolean h() {
        return this.l.q();
    }

    public boolean hasSubMenu() {
        return this.m != null;
    }

    public boolean i() {
        return (this.p & 0x20) == 32;
    }

    public boolean isActionViewExpanded() {
        return this.u;
    }

    public boolean isCheckable() {
        return (this.p & 0x1) == 1;
    }

    public boolean isChecked() {
        return (this.p & 0x2) == 2;
    }

    public boolean isEnabled() {
        return (this.p & 0x10) != 0;
    }

    public boolean isVisible() {
        if ((this.s != null) && (this.s.c())) {
            if (((this.p & 0x8) != 0) || (!this.s.d())) {
            }
        }
        while ((this.p & 0x8) == 0) {
            return true;
            return false;
        }
        return false;
    }

    public boolean j() {
        return (this.q & 0x1) == 1;
    }

    public boolean k() {
        return (this.q & 0x2) == 2;
    }

    public boolean l() {
        return (this.q & 0x4) == 4;
    }

    public n m() {
        return this.s;
    }

    public boolean n() {
        return ((this.q & 0x8) != 0) && (this.r != null);
    }

    public MenuItem setActionProvider(ActionProvider paramActionProvider) {
        throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
    }

    public MenuItem setAlphabeticShortcut(char paramChar) {
        if (this.i == paramChar) {
            return this;
        }
        this.i = Character.toLowerCase(paramChar);
        this.l.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean paramBoolean) {
        int i2 = this.p;
        int i3 = this.p;
        if (paramBoolean) {
        }
        for (int i1 = 1; ; i1 = 0) {
            this.p = (i1 | i3 & 0xFFFFFFFE);
            if (i2 != this.p) {
                this.l.b(false);
            }
            return this;
        }
    }

    public MenuItem setChecked(boolean paramBoolean) {
        if ((this.p & 0x4) != 0) {
            this.l.a(this);
            return this;
        }
        b(paramBoolean);
        return this;
    }

    public MenuItem setEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (this.p |= 0x10; ; this.p &= 0xFFFFFFEF) {
            this.l.b(false);
            return this;
        }
    }

    public MenuItem setIcon(int paramInt) {
        this.j = null;
        this.k = paramInt;
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable paramDrawable) {
        this.k = 0;
        this.j = paramDrawable;
        this.l.b(false);
        return this;
    }

    public MenuItem setIntent(Intent paramIntent) {
        this.g = paramIntent;
        return this;
    }

    public MenuItem setNumericShortcut(char paramChar) {
        if (this.h == paramChar) {
            return this;
        }
        this.h = paramChar;
        this.l.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
        throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
        this.o = paramOnMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char paramChar1, char paramChar2) {
        this.h = paramChar1;
        this.i = Character.toLowerCase(paramChar2);
        this.l.b(false);
        return this;
    }

    public void setShowAsAction(int paramInt) {
        switch (paramInt & 0x3) {
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.q = paramInt;
        this.l.b(this);
    }

    public MenuItem setTitle(int paramInt) {
        return setTitle(this.l.e().getString(paramInt));
    }

    public MenuItem setTitle(CharSequence paramCharSequence) {
        this.e = paramCharSequence;
        this.l.b(false);
        if (this.m != null) {
            this.m.setHeaderTitle(paramCharSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
        this.f = paramCharSequence;
        if (paramCharSequence == null) {
            paramCharSequence = this.e;
        }
        this.l.b(false);
        return this;
    }

    public MenuItem setVisible(boolean paramBoolean) {
        if (c(paramBoolean)) {
            this.l.a(this);
        }
        return this;
    }

    public String toString() {
        return this.e.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */