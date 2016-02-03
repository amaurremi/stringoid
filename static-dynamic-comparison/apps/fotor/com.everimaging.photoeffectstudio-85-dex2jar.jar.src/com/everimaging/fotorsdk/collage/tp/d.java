package com.everimaging.fotorsdk.collage.tp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory;
import com.everimaging.fotorsdk.collage.i;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.services.PluginService.e;
import com.everimaging.fotorsdk.services.PluginService.f;
import com.everimaging.fotorsdk.store.c.a;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.widget.FotorCustomViewPager;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;
import com.everimaging.fotorsdk.widget.lib.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
        extends i
        implements View.OnClickListener, BaseVFragment.c, PluginService.e, PluginService.f, c.a {
    private static final String d = d.class.getSimpleName();
    private static FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);
    private List<BaseVFragment> f = null;
    private FotorCustomViewPager g;
    private b h;
    private TabPageIndicator i;
    private PluginService j = (PluginService) this.a.a(PluginService.class);
    private a k;
    private FotorTitleBackButton l;
    private View m;

    public d(com.everimaging.fotorsdk.collage.f paramf) {
        super(paramf);
        this.j.a(this);
        this.j.a(this);
        com.everimaging.fotorsdk.store.c.a().a(this);
    }

    private void h() {
        this.f = new ArrayList();
        Object localObject = new a(this.a);
        ((a) localObject).a(this.j);
        ((a) localObject).a(this);
        this.f.add(localObject);
        localObject = new c(this.a);
        ((c) localObject).a(this);
        ((c) localObject).a(this.j);
        this.f.add(localObject);
        this.h = new b(this.f);
        this.g.setAdapter(this.h);
        this.i.setViewPager(this.g);
    }

    public void a(TemplateParam paramTemplateParam, TemplateCategory paramTemplateCategory) {
        if (this.k != null) {
            this.k.a(this, paramTemplateParam, paramTemplateCategory);
        }
    }

    public void a(a parama) {
        this.k = parama;
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if (localBaseVFragment != null) {
                    localBaseVFragment.a(paramPluginService, paramBundle);
                }
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if ((localBaseVFragment != null) && (localBaseVFragment.g().equals(paramPurchasedPack.getType()))) {
                    localBaseVFragment.a(paramPurchasedPack);
                }
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if ((localBaseVFragment != null) && (localBaseVFragment.g().equals(paramPurchasedPack.getType()))) {
                    localBaseVFragment.a(paramPurchasedPack, paramFloat);
                }
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if ((localBaseVFragment != null) && (localBaseVFragment.g().equals(paramPurchasedPack.getType()))) {
                    localBaseVFragment.a(paramPurchasedPack, paramInt);
                }
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, String paramString) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if ((localBaseVFragment != null) && (localBaseVFragment.g().equals(paramPurchasedPack.getType()))) {
                    localBaseVFragment.a(paramPurchasedPack, paramString);
                }
            }
        }
    }

    public void a(boolean paramBoolean) {
        View localView = this.m;
        if (paramBoolean) {
        }
        for (int n = 0; ; n = 8) {
            localView.setVisibility(n);
            return;
        }
    }

    public boolean a() {
        if (this.k != null) {
            this.k.a(this);
        }
        return true;
    }

    public void b(PurchasedPack paramPurchasedPack) {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if ((localBaseVFragment != null) && (localBaseVFragment.g().equals(paramPurchasedPack.getType()))) {
                    localBaseVFragment.b(paramPurchasedPack);
                }
            }
        }
    }

    protected void c() {
        this.c = LayoutInflater.from(this.b).inflate(R.layout.fotor_collage_template_picker_page, null);
        this.i = ((TabPageIndicator) this.c.findViewById(R.id.fotor_collage_template_indicator));
        this.g = ((FotorCustomViewPager) this.c.findViewById(R.id.fotor_collage_template_picker_viewpager));
        this.g.setPagingEnable(false);
        this.l = ((FotorTitleBackButton) this.c.findViewById(R.id.fotor_collage_template_picker_title));
        this.l.setOnClickListener(this);
        this.m = this.c.findViewById(R.id.fotor_collage_template_event_lock_view);
        this.m.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        a(false);
        h();
    }

    public void d() {
        super.d();
        a(false);
        e.c(new Object[]{"onAttached"});
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if (localBaseVFragment != null) {
                    localBaseVFragment.c();
                }
            }
        }
    }

    public void e() {
        super.e();
        a(false);
        e.c(new Object[]{"onDetached"});
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                BaseVFragment localBaseVFragment = (BaseVFragment) localIterator.next();
                if (localBaseVFragment != null) {
                    localBaseVFragment.d();
                }
            }
        }
    }

    public void f() {
        super.f();
        this.j.b(this);
        this.j.b(this);
        com.everimaging.fotorsdk.store.c.a().b(this);
        this.g.setAdapter(null);
        this.h = null;
    }

    public void g() {
        if (this.f != null) {
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                ((BaseVFragment) localIterator.next()).f();
            }
        }
    }

    public void onClick(View paramView) {
        if ((paramView == this.l) && (this.k != null)) {
            this.k.a(this);
        }
    }

    public static abstract interface a {
        public abstract void a(d paramd);

        public abstract void a(d paramd, TemplateParam paramTemplateParam, TemplateCategory paramTemplateCategory);
    }

    private class b
            extends f {
        private List<BaseVFragment> b = null;

        public b() {
            List localList;
            this.b = localList;
        }

        public e a(int paramInt) {
            return (e) this.b.get(paramInt);
        }

        public int getCount() {
            return this.b.size();
        }

        public CharSequence getPageTitle(int paramInt) {
            return d.a(d.this).getText(((BaseVFragment) this.b.get(paramInt)).a());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */