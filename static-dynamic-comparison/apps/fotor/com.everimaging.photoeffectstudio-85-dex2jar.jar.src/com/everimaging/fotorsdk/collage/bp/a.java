package com.everimaging.fotorsdk.collage.bp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.drawable;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;
import com.everimaging.fotorsdk.collage.entity.BackgroundPackInfo;
import com.everimaging.fotorsdk.collage.entity.ui.BackgroundCategory;
import com.everimaging.fotorsdk.collage.entity.ui.BackgroundCategory.BackgroundPackType;
import com.everimaging.fotorsdk.collage.i;
import com.everimaging.fotorsdk.collage.params.BackgroundParam;
import com.everimaging.fotorsdk.collage.tp.e;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureDownloadedPack;
import com.everimaging.fotorsdk.plugins.FeatureExternalPack;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePurchasedPack;
import com.everimaging.fotorsdk.plugins.d;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.plugins.h.b;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.Utils;
import com.everimaging.fotorsdk.widget.FotorExternalPkgButton;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
        extends i
        implements ViewPager.OnPageChangeListener, View.OnClickListener, b.b, com.everimaging.fotorsdk.store.g.a {
    private static final String d = a.class.getSimpleName();
    private static final FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);
    private e f;
    private b g;
    private FotorTitleBackButton h;
    private ViewPager i;
    private c j;
    private a k;
    private HListView l;
    private View m;
    private int n;
    private d o;
    private PluginService p;
    private int q;
    private int r;
    private boolean s = false;
    private BackgroundParam t;
    private View u;
    private com.everimaging.fotorsdk.store.g v;
    private View.OnClickListener w = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            int i = ((Integer) paramAnonymousView.getTag()).intValue();
            Object localObject = a.h(a.this).b(i);
            if ((localObject != null) && (((BackgroundCategory) localObject).b() != null)) {
                switch (a .3.a[localObject.b().ordinal()])
                {
                }
            }
            do {
                do {
                    do {
                        return;
                    } while (a.o(a.this) == null);
                    a.o(a.this).a(null, null);
                    return;
                    paramAnonymousView = ((d) ((BackgroundCategory) localObject).c()).f();
                    localObject = new DetailPageInfo();
                    ((DetailPageInfo) localObject).id = paramAnonymousView.getId();
                    ((DetailPageInfo) localObject).count = paramAnonymousView.getItemsCount();
                    ((DetailPageInfo) localObject).description = paramAnonymousView.getDescription();
                    ((DetailPageInfo) localObject).name = paramAnonymousView.getName();
                    ((DetailPageInfo) localObject).pkgName = paramAnonymousView.getPackageName();
                    ((DetailPageInfo) localObject).price = paramAnonymousView.getPrice();
                } while (a.o(a.this) == null);
                a.o(a.this).a((DetailPageInfo) localObject, null, null);
                return;
                localObject = ((BackgroundCategory) localObject).c().g();
                paramAnonymousView = (FotorExternalPkgButton) paramAnonymousView;
                if (paramAnonymousView.c()) {
                    com.everimaging.fotorsdk.preference.a.a(a.p(a.this), (String) localObject, false);
                    paramAnonymousView.setShowIndicator(0);
                }
                i -= a.h(a.this).getCount() - a.q(a.this);
            } while ((i < 0) || (i >= a.g(a.this).getChildCount()));
            a.g(a.this).setCurrentItem(i);
        }
    };

    public a(com.everimaging.fotorsdk.collage.f paramf) {
        super(paramf);
        this.b = paramf.getBaseContext();
        this.p = ((PluginService) paramf.a(PluginService.class));
    }

    private BackgroundCategory a(FeaturePurchasedPack paramFeaturePurchasedPack) {
        BackgroundCategory localBackgroundCategory = new BackgroundCategory();
        FeatureDownloadedPack localFeatureDownloadedPack = paramFeaturePurchasedPack.getDownloadPack();
        if (localFeatureDownloadedPack != null) {
            paramFeaturePurchasedPack = a((com.everimaging.fotorsdk.plugins.c) h.a(this.b, localFeatureDownloadedPack));
        }
        int i1;
        do {
            return paramFeaturePurchasedPack;
            paramFeaturePurchasedPack = h.a(this.b, paramFeaturePurchasedPack);
            localBackgroundCategory.a(BackgroundCategory.BackgroundPackType.PURCHASED);
            localBackgroundCategory.a(paramFeaturePurchasedPack.b_());
            localBackgroundCategory.a(paramFeaturePurchasedPack.a());
            localBackgroundCategory.a(paramFeaturePurchasedPack);
            i1 = com.everimaging.fotorsdk.store.c.a().a(paramFeaturePurchasedPack.g());
            paramFeaturePurchasedPack = localBackgroundCategory;
        } while (i1 < 0);
        localBackgroundCategory.a(true);
        localBackgroundCategory.a(i1);
        return localBackgroundCategory;
    }

    private BackgroundCategory a(com.everimaging.fotorsdk.plugins.g paramg) {
        BackgroundCategory localBackgroundCategory = new BackgroundCategory();
        a(paramg, localBackgroundCategory);
        return localBackgroundCategory;
    }

    private void a(com.everimaging.fotorsdk.plugins.g paramg, BackgroundCategory paramBackgroundCategory) {
        Object localObject = (h.a) paramg;
        paramBackgroundCategory.a(paramg.a());
        e.c(new Object[]{"packName:" + paramBackgroundCategory.a()});
        paramBackgroundCategory.a(BackgroundCategory.BackgroundPackType.NORMAL);
        paramBackgroundCategory.a(paramg);
        paramg = ((h.a) localObject).b();
        if (paramg == null) {
        }
        do {
            return;
            localObject = (BackgroundPackInfo) new GsonBuilder().create().fromJson(new InputStreamReader(paramg), BackgroundPackInfo.class);
            FotorIOUtils.closeSilently(paramg);
        }
        while ((localObject == null) || (((BackgroundPackInfo) localObject).getClasses() == null) || (((BackgroundPackInfo) localObject).getClasses().size() == 0));
        paramBackgroundCategory.a(((BackgroundPackInfo) localObject).getTitle());
        paramg = new ArrayList();
        localObject = ((BackgroundPackInfo) localObject).getClasses().iterator();
        while (((Iterator) localObject).hasNext()) {
            BackgroundInfo localBackgroundInfo = (BackgroundInfo) ((Iterator) localObject).next();
            com.everimaging.fotorsdk.collage.entity.ui.a locala = new com.everimaging.fotorsdk.collage.entity.ui.a();
            locala.a(localBackgroundInfo);
            paramg.add(locala);
        }
        paramBackgroundCategory.a(paramg);
    }

    private void b(int paramInt) {
        if ((this.k != null) && (this.k.getCount() > 0)) {
            paramInt = this.k.getCount() - this.q + paramInt;
            if ((paramInt >= 0) && (paramInt < this.k.getCount())) {
                this.k.a(paramInt);
            }
        }
    }

    private void l() {
        if (this.o != null) {
            this.o.cancel(true);
        }
        this.o = new d();
        this.o.execute(new Void[0]);
    }

    private List<BackgroundCategory> m() {
        ArrayList localArrayList = new ArrayList();
        FeatureInternalPack[] arrayOfFeatureInternalPack = this.p.a(this.b, 9);
        int i1 = 0;
        if (i1 < arrayOfFeatureInternalPack.length) {
            Object localObject = arrayOfFeatureInternalPack[i1];
            if ((localObject instanceof FeaturePurchasedPack)) {
            }
            for (localObject = a((FeaturePurchasedPack) localObject); ; localObject = a((com.everimaging.fotorsdk.plugins.g) h.a(this.b, (FeaturePack) localObject))) {
                localArrayList.add(localObject);
                i1 += 1;
                break;
            }
        }
        return localArrayList;
    }

    public void a(int paramInt) {
        this.r = paramInt;
        if (this.k != null) {
            this.k.notifyDataSetChanged();
        }
    }

    public void a(b paramb) {
        this.g = paramb;
    }

    public void a(e parame) {
        this.f = parame;
    }

    public void a(BackgroundParam paramBackgroundParam) {
        this.t = paramBackgroundParam;
        if (this.f != null) {
            this.f.a(this, paramBackgroundParam);
        }
    }

    public void a(boolean paramBoolean) {
        View localView = this.u;
        if (paramBoolean) {
        }
        for (int i1 = 0; ; i1 = 8) {
            localView.setVisibility(i1);
            return;
        }
    }

    public boolean a() {
        if (this.f != null) {
            this.f.a(this);
        }
        return true;
    }

    public void b(b paramb) {
        a(paramb);
    }

    protected void c() {
        this.c = LayoutInflater.from(this.b).inflate(R.layout.fotor_collage_background_picker, null);
        this.h = ((FotorTitleBackButton) this.c.findViewById(R.id.fotor_collage_background_picker_title));
        this.h.setOnClickListener(this);
        this.i = ((ViewPager) this.c.findViewById(R.id.fotor_collage_background_picker_viewpager));
        this.i.setOnPageChangeListener(this);
        this.l = ((HListView) this.c.findViewById(R.id.fotor_collage_background_packs_listview));
        this.m = this.c.findViewById(R.id.fotor_collage_background_picker_loading_container);
        this.n = ((DeviceUtils.getScreenWidth() - this.b.getResources().getDimensionPixelSize(R.dimen.fotor_collage_background_grid_h_spacing) * 3) / 2);
        this.u = this.c.findViewById(R.id.fotor_collage_background_picker_event_lock_view);
        this.u.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        a(false);
        l();
    }

    public void d() {
        super.d();
        a(false);
        if (this.o == null) {
            Bitmap localBitmap = null;
            if (this.g != null) {
                localBitmap = this.g.a(this.n, this.n);
            }
            if ((localBitmap != null) || (this.j != null)) {
                this.j.a(localBitmap);
            }
        }
    }

    public void e() {
        super.e();
        a(false);
    }

    public void g() {
        if (this.v != null) {
            this.v.c();
        }
    }

    public boolean h() {
        return false;
    }

    public void i() {
        this.s = true;
    }

    public void j() {
        this.s = false;
    }

    public void onClick(View paramView) {
        if ((paramView == this.h) && (this.f != null)) {
            this.f.a(this);
        }
    }

    public void onPageScrollStateChanged(int paramInt) {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    }

    public void onPageSelected(int paramInt) {
        e.c(new Object[]{"onPageSelected:" + paramInt});
        b(paramInt);
    }

    class a
            extends BaseAdapter {
        protected SparseBooleanArray a;
        private List<BackgroundCategory> c;
        private LayoutInflater d;

        public a() {
            List localList;
            this.c = localList;
            this.d = LayoutInflater.from(a.k(a.this));
            this.a = new SparseBooleanArray();
        }

        public void a(int paramInt) {
            this.a.clear();
            if (paramInt >= 0) {
                this.a.put(paramInt, true);
            }
            notifyDataSetChanged();
        }

        public BackgroundCategory b(int paramInt) {
            return (BackgroundCategory) this.c.get(paramInt);
        }

        public int getCount() {
            return this.c.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public int getItemViewType(int paramInt) {
            if (((BackgroundCategory) this.c.get(paramInt)).b() == BackgroundCategory.BackgroundPackType.STORE) {
                return 0;
            }
            return 1;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            BackgroundCategory localBackgroundCategory = (BackgroundCategory) this.c.get(paramInt);
            int i = getItemViewType(paramInt);
            label67:
            Object localObject1;
            Object localObject2;
            if (paramView == null) {
                if (i == 0) {
                    paramView = this.d.inflate(R.layout.fotor_feature_store_button, null);
                    paramViewGroup = new a(null);
                    paramViewGroup.a = ((FotorNavigationButton) paramView.findViewById(R.id.fotor_navigation_button));
                    if (localBackgroundCategory.b() != BackgroundCategory.BackgroundPackType.EXTERNAL) {
                        break label221;
                    }
                    localObject1 = (d) localBackgroundCategory.c();
                    localObject2 = (FotorExternalPkgButton) paramViewGroup.a;
                    ((FotorExternalPkgButton) localObject2).a(((d) localObject1).d(), ((d) localObject1).e());
                    if (!((d) localObject1).c()) {
                        break label215;
                    }
                    i = 2;
                    label123:
                    ((FotorExternalPkgButton) localObject2).setShowIndicator(i);
                }
            }
            for (; ; ) {
                paramViewGroup.a.setButtonName(localBackgroundCategory.a());
                paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                paramViewGroup.a.setSelected(this.a.get(paramInt));
                paramViewGroup.a.setOnClickListener(a.n(a.this));
                paramView.setTag(paramViewGroup);
                return paramView;
                paramView = this.d.inflate(R.layout.fotor_collage_pack_category_item, null);
                break;
                paramViewGroup = (a) paramView.getTag();
                break label67;
                label215:
                i = 3;
                break label123;
                label221:
                if (localBackgroundCategory.b() == BackgroundCategory.BackgroundPackType.NORMAL) {
                    localObject1 = (com.everimaging.fotorsdk.plugins.g) localBackgroundCategory.c();
                    paramViewGroup.a.setImageDrawable(((com.everimaging.fotorsdk.plugins.g) localObject1).c());
                    int j = 0;
                    localObject2 = localBackgroundCategory.c().g();
                    i = j;
                    if (!(localObject1 instanceof com.everimaging.fotorsdk.plugins.g.a)) {
                        i = j;
                        if (com.everimaging.fotorsdk.preference.a.b(a.l(a.this), (String) localObject2)) {
                            i = 1;
                        }
                    }
                    ((FotorExternalPkgButton) paramViewGroup.a).setShowIndicator(i);
                } else if (localBackgroundCategory.b() == BackgroundCategory.BackgroundPackType.STORE) {
                    paramViewGroup.a.setImageResource(R.drawable.fotor_store_button_icon);
                    if ((paramViewGroup.a instanceof com.everimaging.fotorsdk.store.widget.a)) {
                        ((com.everimaging.fotorsdk.store.widget.a) paramViewGroup.a).setNewNum(a.m(a.this));
                    }
                }
            }
        }

        public int getViewTypeCount() {
            return 2;
        }

        private class a {
            FotorNavigationButton a;

            private a() {
            }
        }
    }

    public static abstract interface b {
        public abstract Bitmap a(int paramInt1, int paramInt2);
    }

    class c
            extends com.everimaging.fotorsdk.collage.tp.f {
        List<BackgroundCategory> a;
        private Bitmap d;

        public c(Bitmap paramBitmap) {
            this.a = paramBitmap;
            Bitmap localBitmap;
            this.d = localBitmap;
        }

        public e a(int paramInt) {
            Object localObject = (BackgroundCategory) this.a.get(paramInt);
            localObject = new b(a.j(a.this), (BackgroundCategory) localObject, this.d);
            ((b) localObject).a(a.this);
            return (e) localObject;
        }

        public void a(Bitmap paramBitmap) {
            if (paramBitmap != null) {
                this.d = paramBitmap;
                notifyDataSetChanged();
            }
        }

        public int getCount() {
            return this.a.size();
        }

        public int getItemPosition(Object paramObject) {
            ((b) paramObject).a(this.d);
            return super.getItemPosition(paramObject);
        }
    }

    class d
            extends FotorAsyncTask<Void, Void, List<BackgroundCategory>> {
        d() {
        }

        protected List<BackgroundCategory> a(Void... paramVarArgs) {
            int j = 0;
            publishProgress(new Void[0]);
            int i;
            for (; ; ) {
                i = j;
                if (a.a(a.this).b()) {
                    break;
                }
                Utils.sleep(50);
                a.k().b(new Object[]{"waiting for plugin service"});
            }
            do {
                if (a.a(a.this).a(9)) {
                    break;
                }
                j = i + 1;
                Utils.sleep(10);
                i = j;
            } while (j <= 300);
            paramVarArgs = new ArrayList();
            List localList = a.b(a.this);
            a.a(a.this, localList.size());
            paramVarArgs.addAll(localList);
            return paramVarArgs;
        }

        protected void a(List<BackgroundCategory> paramList) {
            a.c(a.this).setVisibility(8);
            a.a(a.this, null);
            if (a.d(a.this) != null) {
            }
            for (Bitmap localBitmap = a.d(a.this).a(a.e(a.this), a.e(a.this)); ; localBitmap = null) {
                if (localBitmap == null) {
                }
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = paramList.iterator();
                while (localIterator.hasNext()) {
                    BackgroundCategory localBackgroundCategory = (BackgroundCategory) localIterator.next();
                    if ((localBackgroundCategory.b() != BackgroundCategory.BackgroundPackType.STORE) && (localBackgroundCategory.b() != BackgroundCategory.BackgroundPackType.EXTERNAL)) {
                        localArrayList.add(localBackgroundCategory);
                    }
                }
                a.a(a.this, new a.c(a.this, localArrayList, localBitmap));
                a.g(a.this).setAdapter(a.f(a.this));
                a.a(a.this, new a.a(a.this, paramList));
                a.i(a.this).setAdapter(a.h(a.this));
                a.g(a.this).setCurrentItem(0);
                a.b(a.this, 0);
                return;
            }
        }

        protected void b(Void... paramVarArgs) {
            a.c(a.this).setVisibility(0);
        }

        protected void onCancelled() {
            a.c(a.this).setVisibility(8);
        }
    }

    public static abstract interface e {
        public abstract void a(a parama);

        public abstract void a(a parama, BackgroundParam paramBackgroundParam);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/bp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */