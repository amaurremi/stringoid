package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;

class fl
        extends ek {
    private int A = 0;
    private int B = 1131261513;
    private int C = 50;
    protected float a;
    protected int b = -1;
    protected int c = -1;
    FrameLayout d;
    protected int e = 0;
    private gm f = gm.d;
    private final fz g;
    private final gd h;
    private fy i;
    private FrameLayout j;
    private bt k;
    private boolean l = false;
    private boolean m;
    private final int n;
    private BroadcastReceiver o = new fm(this);
    private ImageView p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private boolean u = false;
    private Context v;
    private int w;
    private int x;
    private double y;
    private int z = 0;

    fl(fy paramfy, fz paramfz, gd paramgd) {
        super(paramfy);
        this.g = paramfz;
        this.h = paramgd;
        this.x = paramfy.e();
        this.w = paramfy.d();
        this.y = paramfy.f();
        this.v = a().getContext();
        if ((this.v instanceof Activity)) {
            i1 = ((Activity) this.v).getRequestedOrientation();
        }
        this.n = i1;
        d();
    }

    private void b(int paramInt) {
        f();
        if (this.u == true) {
            a().a(fw.a(this.b, this.c));
        }
    }

    private void c(boolean paramBoolean) {
        Object localObject = a().getContext();
        try {
            localObject = (Activity) localObject;
            if (paramBoolean) {
            }
            for (int i1 = hu.a(); ; i1 = this.n) {
                ((Activity) localObject).setRequestedOrientation(i1);
                return;
            }
            return;
        } catch (Exception localException) {
            dv.b("MraidDisplayController", "Unable to modify device orientation.");
        }
    }

    private int r() {
        return cf.a(((WindowManager) a().getContext().getSystemService("window")).getDefaultDisplay());
    }

    private void s() {
        Object localObject = (FrameLayout) a(this.e);
        RelativeLayout localRelativeLayout = (RelativeLayout) a(this.z);
        a(false);
        ((FrameLayout) localObject).removeAllViewsInLayout();
        this.j.removeView(localRelativeLayout);
        a().requestLayout();
        localObject = (ViewGroup) this.d.getParent();
        ((ViewGroup) localObject).addView(a(), this.r, new ViewGroup.LayoutParams(this.s, this.t));
        ((ViewGroup) localObject).removeView(this.d);
        ((ViewGroup) localObject).invalidate();
    }

    private void t() {
        ViewGroup localViewGroup = q();
        if (localViewGroup == null) {
            return;
        }
        this.d = new FrameLayout(a().getContext());
        int i2 = localViewGroup.getChildCount();
        int i1 = 0;
        for (; ; ) {
            if ((i1 >= i2) || (localViewGroup.getChildAt(i1) == a())) {
                this.r = i1;
                this.t = o();
                this.s = p();
                localViewGroup.addView(this.d, i1, new ViewGroup.LayoutParams(a().getWidth(), a().getHeight()));
                localViewGroup.removeView(a());
                return;
            }
            i1 += 1;
        }
    }

    private int u() {
        int i2 = 0;
        if (this.j == null) {
            dv.e("MraidDisplayController", "Could not find root view. View ID may not be unique.");
            i1 = this.B;
            this.B = (i1 + 1);
            return i1;
        }
        this.B += 1;
        int i1 = 0;
        if ((i1 < 100) && (i2 == 0)) {
            if (this.j.findViewById(this.B) == null) {
                i2 = 1;
            }
            for (; ; ) {
                i1 += 1;
                break;
                this.B += this.C;
            }
        }
        if (i2 == 0) {
            throw new IllegalArgumentException();
        }
        return this.B;
    }

    private void v() {
        if (this.z != 0) {
            return;
        }
        this.z = u();
        this.e = u();
        this.A = u();
    }

    protected View a(int paramInt) {
        return this.j.findViewById(paramInt);
    }

    protected ViewGroup a(View paramView, int paramInt1, int paramInt2) {
        int i1 = (int) (50.0F * this.a + 0.5F);
        int i2 = paramInt1;
        if (paramInt1 < i1) {
            i2 = i1;
        }
        paramInt1 = paramInt2;
        if (paramInt2 < i1) {
            paramInt1 = i1;
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(a().getContext());
        localRelativeLayout.setId(this.z);
        Object localObject = new View(a().getContext());
        ((View) localObject).setBackgroundColor(0);
        ((View) localObject).setOnTouchListener(new fp(this));
        localRelativeLayout.addView((View) localObject, new RelativeLayout.LayoutParams(-1, -1));
        localObject = new FrameLayout(a().getContext());
        ((FrameLayout) localObject).setId(this.e);
        ((FrameLayout) localObject).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        paramView = new RelativeLayout.LayoutParams(i2, paramInt1);
        paramView.addRule(13);
        localRelativeLayout.addView((View) localObject, paramView);
        return localRelativeLayout;
    }

    protected void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams) {
        this.j.addView(paramViewGroup, paramLayoutParams);
    }

    protected void a(fy paramfy) {
        paramfy.a().requestFocus();
        paramfy.a().setOnKeyListener(new fo(this));
    }

    protected void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if ((this.g == fz.b) || (this.f == gm.c)) {
        }
        for (; ; ) {
            return;
            if (m()) {
                dv.c("MraidDisplayController", "Expansion failed because ad loading is currently in progress.");
                return;
            }
            if ((paramString != null) && (!URLUtil.isValidUrl(paramString))) {
                a().b("expand", "URL passed to expand() was invalid.");
                return;
            }
            if (!n()) {
                a().b("expand", "Root view could not be found.");
                dv.c("MraidDisplayController", "Expansion failed because root view could not be found.");
                return;
            }
            try {
                v();
                b(paramBoolean1);
                c(paramBoolean2);
                t();
                Object localObject2 = a();
                ((fy) localObject2).a(-1, -1);
                Object localObject1 = localObject2;
                if (paramString != null) {
                    localObject1 = (fu) ((fy) localObject2).g();
                    localObject2 = ig.a().a(((fu) localObject1).b);
                    this.i = new fy((bv) localObject1, this.w, this.x, this.y, ((fu) localObject1).b, (WebView) localObject2, fz.b, gd.c, gl.a);
                    this.i.a(new fn(this));
                    this.i.b(paramString);
                    localObject1 = this.i;
                }
                a(a((View) localObject1, (int) (paramInt1 * this.a), (int) (paramInt2 * this.a)), new RelativeLayout.LayoutParams(-1, -1));
                a((fy) localObject1);
                if ((this.h == gd.a) || ((!this.q) && (this.h != gd.b))) {
                    a(true);
                }
                this.f = gm.c;
                a().a(fx.a(this.f));
                if (a().o() != null) {
                    a().o().b(a());
                    return;
                }
            } catch (IllegalArgumentException paramString) {
                a().b("expand", "Could not find available view ID.");
                dv.c("MraidDisplayController", "Expansion failed because available view ID could not be found.");
            }
        }
    }

    protected void a(String paramString, Controller.Dimensions paramDimensions, Controller.PlayerProperties paramPlayerProperties) {
        dv.b("MraidDisplayController", "in playVideo");
        if (this.l) {
            return;
        }
        if (paramPlayerProperties.f()) {
            Bundle localBundle = new Bundle();
            localBundle.putString("url", paramString);
            localBundle.putParcelable("player_dimensions", paramDimensions);
            localBundle.putParcelable("player_properties", paramPlayerProperties);
            try {
                paramString = new Intent(a().getContext(), AdActivity.class);
                paramString.putExtra("adapter", hw.class.getName());
                paramString.putExtras(localBundle);
                a().getContext().startActivity(paramString);
                return;
            } catch (ActivityNotFoundException paramString) {
                dv.c("MraidDisplayController", "Failed to open VideoAction activity");
                return;
            }
        }
        if (this.k == null) {
            this.k = new bt(this.v);
        }
        this.k.a(new Controller.PlayerProperties(), paramString);
        this.k.a(new fr(this));
        paramString = new FrameLayout.LayoutParams(paramDimensions.c, paramDimensions.d);
        paramString.topMargin = paramDimensions.a;
        paramString.bottomMargin = paramDimensions.b;
        this.k.a(paramString);
        paramString = new FrameLayout(a().getContext());
        paramString.setId(this.A);
        paramString.setPadding(paramDimensions.a, paramDimensions.b, 0, 0);
        this.k.a(paramString);
        this.j.addView(paramString, -1, -1);
        this.l = true;
        this.k.a();
    }

    protected void a(boolean paramBoolean) {
        if (this.j == null) {
            return;
        }
        Object localObject1 = (FrameLayout) this.j.findViewById(this.e);
        if (paramBoolean) {
            if (this.p == null) {
                localObject2 = new StateListDrawable();
                BitmapDrawable localBitmapDrawable = cf.a(this.v.getResources(), cn.a().a("amazon_ads_close_button_normal.png"));
                ((StateListDrawable) localObject2).addState(new int[]{-16842919}, localBitmapDrawable);
                localBitmapDrawable = cf.a(this.v.getResources(), cn.a().a("amazon_ads_close_button_pressed.png"));
                ((StateListDrawable) localObject2).addState(new int[]{16842919}, localBitmapDrawable);
                this.p = new ImageButton(a().getContext());
                this.p.setImageDrawable((Drawable) localObject2);
                cf.a(this.p, null);
                this.p.setOnClickListener(new fq(this));
            }
            int i1 = (int) (50.0F * this.a + 0.5F);
            Object localObject2 = new FrameLayout.LayoutParams(i1, i1, 5);
            ((FrameLayout) localObject1).addView(this.p, (ViewGroup.LayoutParams) localObject2);
        }
        for (; ; ) {
            localObject1 = a();
            if (((fy) localObject1).r() == null) {
                break;
            }
            ((fy) localObject1).r().a((fy) localObject1, paramBoolean);
            return;
            ((FrameLayout) localObject1).removeView(this.p);
        }
    }

    protected void b() {
        if (!this.u) {
            this.u = true;
            a().getContext().registerReceiver(this.o, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    protected void b(boolean paramBoolean) {
        this.q = paramBoolean;
        fy localfy = a();
        if (!paramBoolean) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            if (localfy.r() != null) {
                localfy.r().a(localfy, paramBoolean);
            }
            return;
        }
    }

    protected void c() {
        if (this.u == true) {
            this.u = false;
        }
        try {
            a().getContext().unregisterReceiver(this.o);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
        }
    }

    protected void d() {
        this.f = gm.a;
        f();
        b();
    }

    protected void e() {
        a().a(gn.a(true));
    }

    protected void f() {
        int i2 = 0;
        Object localObject = a().getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) ((Context) localObject).getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        this.a = localDisplayMetrics.density;
        if ((localObject instanceof Activity)) {
            localObject = ((Activity) localObject).getWindow();
            Rect localRect = new Rect();
            ((Window) localObject).getDecorView().getWindowVisibleDisplayFrame(localRect);
            i2 = localRect.top;
        }
        for (int i1 = ((Window) localObject).findViewById(16908290).getTop() - i2; ; i1 = 0) {
            int i3 = localDisplayMetrics.widthPixels;
            int i4 = localDisplayMetrics.heightPixels;
            this.b = ((int) (i3 * (160.0D / localDisplayMetrics.densityDpi)));
            this.c = ((int) ((i4 - i2 - i1) * (160.0D / localDisplayMetrics.densityDpi)));
            return;
        }
    }

    public void g() {
        try {
            a().getContext().unregisterReceiver(this.o);
            if (this.i != null) {
                this.i.k();
                this.i = null;
            }
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {
            }
            throw localIllegalArgumentException;
        }
    }

    protected void h() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(fw.a(this.b, this.c));
        localArrayList.add(gn.a(this.m));
        a().a(localArrayList);
        this.f = gm.b;
        a().a(fx.a(this.f));
    }

    protected boolean i() {
        return this.f == gm.c;
    }

    protected void j() {
        if (this.l) {
            this.k.e();
            this.l = false;
        }
        k();
        if (this.f == gm.c) {
            s();
            c(false);
            this.f = gm.b;
            a().a(fx.a(this.f));
        }
        for (; ; ) {
            if (a().p() != null) {
                a().p().a(a(), this.f);
            }
            return;
            if (this.f == gm.b) {
                a().setVisibility(4);
                this.f = gm.d;
                a().a(fx.a(this.f));
            }
        }
    }

    protected void k() {
        a().a().setOnKeyListener(null);
    }

    protected void l() {
        Object localObject;
        if (this.f == gm.c) {
            dv.b("MraidDisplayController", "Ad is currently expanded. Detaching the expanded view and returning ad to its default state.");
            localObject = (RelativeLayout) this.j.findViewById(this.z);
            if (localObject != null) {
                if (!((RelativeLayout) localObject).isShown()) {
                    break label102;
                }
                this.j.removeView((View) localObject);
            }
        }
        for (; ; ) {
            localObject = (ViewGroup) this.d.getParent();
            if (localObject != null) {
                ((ViewGroup) localObject).removeView(this.d);
                c(false);
                this.f = gm.b;
                a().a(fx.a(this.f));
            }
            return;
            label102:
            ((RelativeLayout) localObject).removeAllViews();
        }
    }

    protected boolean m() {
        return ((fu) a().g()).a.c();
    }

    protected boolean n() {
        this.j = ((FrameLayout) a().getRootView().findViewById(16908290));
        return this.j != null;
    }

    protected int o() {
        return a().getHeight();
    }

    protected int p() {
        return a().getWidth();
    }

    protected ViewGroup q() {
        return (ViewGroup) a().getParent();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */