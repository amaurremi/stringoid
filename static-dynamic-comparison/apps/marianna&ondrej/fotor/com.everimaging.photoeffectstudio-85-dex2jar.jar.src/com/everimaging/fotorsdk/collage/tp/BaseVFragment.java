package com.everimaging.fotorsdk.collage.tp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.everimaging.fotorsdk.collage.R.drawable;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.entity.TemplateInfo;
import com.everimaging.fotorsdk.collage.entity.TemplatePackInfo;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory.TemplatePackType;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
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
import com.everimaging.fotorsdk.plugins.i;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.Utils;
import com.everimaging.fotorsdk.widget.FotorCustomViewPager;
import com.everimaging.fotorsdk.widget.FotorExternalPkgButton;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseVFragment
        extends e
        implements ViewPager.OnPageChangeListener, com.everimaging.fotorsdk.store.g.a {
    private static final String o = BaseVFragment.class.getSimpleName();
    private static final FotorLoggerFactory.c p = FotorLoggerFactory.a(o, FotorLoggerFactory.LoggerType.CONSOLE);
    protected FotorCustomViewPager a;
    protected HListView b;
    protected e c;
    protected View d;
    protected View e;
    protected PluginService f;
    protected List<TemplateCategory> g;
    protected c h;
    protected com.everimaging.fotorsdk.store.g i = new com.everimaging.fotorsdk.store.g(this.m, g());
    protected int j;
    protected boolean k = false;
    protected String l = "";

    public BaseVFragment(com.everimaging.fotorsdk.collage.f paramf) {
        super(paramf);
        this.i.a(this);
    }

    private TemplateCategory b(FeaturePurchasedPack paramFeaturePurchasedPack) {
        TemplateCategory localTemplateCategory = new TemplateCategory();
        FeatureDownloadedPack localFeatureDownloadedPack = paramFeaturePurchasedPack.getDownloadPack();
        if (localFeatureDownloadedPack != null) {
            paramFeaturePurchasedPack = a((com.everimaging.fotorsdk.plugins.c) h.a(this.n, localFeatureDownloadedPack));
        }
        int m;
        do {
            return paramFeaturePurchasedPack;
            paramFeaturePurchasedPack = h.a(this.n, paramFeaturePurchasedPack);
            localTemplateCategory.a(TemplateCategory.TemplatePackType.PURCHASED);
            localTemplateCategory.a(paramFeaturePurchasedPack.b_());
            localTemplateCategory.a(paramFeaturePurchasedPack.a());
            localTemplateCategory.a(paramFeaturePurchasedPack);
            m = com.everimaging.fotorsdk.store.c.a().a(paramFeaturePurchasedPack.g());
            paramFeaturePurchasedPack = localTemplateCategory;
        } while (m < 0);
        localTemplateCategory.a(true);
        localTemplateCategory.a(m);
        return localTemplateCategory;
    }

    private void m() {
        p.c(new Object[]{"loadDatas"});
        a(true);
    }

    public abstract int a();

    public View a(LayoutInflater paramLayoutInflater) {
        paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_collage_template_picker_base_fragment, null);
        this.a = ((FotorCustomViewPager) paramLayoutInflater.findViewById(R.id.fotor_collage_template_picker_category_viewpager));
        this.a.setPagingEnable(true);
        this.b = ((HListView) paramLayoutInflater.findViewById(R.id.fotor_collage_template_category_listview));
        this.e = paramLayoutInflater.findViewById(R.id.fotor_collage_template_category_loading_container);
        this.d = paramLayoutInflater.findViewById(R.id.fotor_collage_template_viewpager_loading_container);
        this.d.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        p.c(new Object[]{"onCraeteView:" + this.g});
        m();
        return paramLayoutInflater;
    }

    protected TemplateCategory a(com.everimaging.fotorsdk.plugins.g paramg) {
        TemplateCategory localTemplateCategory = new TemplateCategory();
        a(paramg, localTemplateCategory);
        return localTemplateCategory;
    }

    protected List<TemplateCategory> a(Context paramContext, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        if (this.f != null) {
            FeatureExternalPack[] arrayOfFeatureExternalPack = this.f.b(paramInt);
            int m = arrayOfFeatureExternalPack.length;
            paramInt = 0;
            while (paramInt < m) {
                Object localObject = arrayOfFeatureExternalPack[paramInt];
                TemplateCategory localTemplateCategory = new TemplateCategory();
                localTemplateCategory.a(TemplateCategory.TemplatePackType.EXTERNAL);
                localObject = h.a(paramContext, (FeaturePack) localObject);
                localTemplateCategory.a(((h.b) localObject).b_());
                localTemplateCategory.a((h.b) localObject);
                localArrayList.add(localTemplateCategory);
                paramInt += 1;
            }
        }
        return localArrayList;
    }

    protected List<TemplateCategory> a(Context paramContext, String paramString, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        FeatureInternalPack[] arrayOfFeatureInternalPack = this.f.a(paramContext, paramInt);
        paramInt = 0;
        if (paramInt < arrayOfFeatureInternalPack.length) {
            paramString = arrayOfFeatureInternalPack[paramInt];
            if ((paramString instanceof FeaturePurchasedPack)) {
            }
            for (paramString = b((FeaturePurchasedPack) paramString); ; paramString = a((com.everimaging.fotorsdk.plugins.g) h.a(paramContext, paramString))) {
                localArrayList.add(paramString);
                paramInt += 1;
                break;
            }
        }
        return localArrayList;
    }

    public void a(int paramInt) {
        this.j = paramInt;
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }

    protected abstract void a(Context paramContext, List<TemplateCategory> paramList);

    public void a(c paramc) {
        this.h = paramc;
    }

    protected void a(FeaturePurchasedPack paramFeaturePurchasedPack) {
        PurchasedPack localPurchasedPack = new PurchasedPack();
        localPurchasedPack.setHighDefault(paramFeaturePurchasedPack.getIconUrlDefault());
        localPurchasedPack.setHighPressed(paramFeaturePurchasedPack.getIconUrlPressed());
        localPurchasedPack.setPackName(paramFeaturePurchasedPack.getPackName());
        localPurchasedPack.setResourceId(paramFeaturePurchasedPack.getId());
        localPurchasedPack.setResourceUrl(paramFeaturePurchasedPack.getZipUrl());
        localPurchasedPack.setType(g());
        com.everimaging.fotorsdk.store.c.a().a(localPurchasedPack);
    }

    protected void a(com.everimaging.fotorsdk.plugins.g paramg, TemplateCategory paramTemplateCategory) {
        h.a locala = (h.a) paramg;
        paramTemplateCategory.a(TemplateCategory.TemplatePackType.NORMAL);
        paramTemplateCategory.a(paramg);
        paramTemplateCategory.a(paramg.a());
        paramg = locala.b();
        if (paramg == null) {
            return;
        }
        Gson localGson = new GsonBuilder().create();
        TemplatePackInfo localTemplatePackInfo = (TemplatePackInfo) localGson.fromJson(new InputStreamReader(paramg), TemplatePackInfo.class);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localTemplatePackInfo.getTemplateInfos().iterator();
        while (localIterator.hasNext()) {
            Object localObject2 = (TemplateInfo) localIterator.next();
            Object localObject1 = locala.a(((TemplateInfo) localObject2).getTemplate_file());
            p.c(new Object[]{"load file:" + ((TemplateInfo) localObject2).getTemplate_file()});
            localObject2 = (Template) localGson.fromJson(new InputStreamReader((InputStream) localObject1), Template.class);
            FotorIOUtils.closeSilently((Closeable) localObject1);
            localObject1 = new com.everimaging.fotorsdk.collage.entity.ui.b();
            ((com.everimaging.fotorsdk.collage.entity.ui.b) localObject1).a((Template) localObject2);
            localArrayList.add(localObject1);
        }
        paramTemplateCategory.a(localArrayList);
        paramTemplateCategory.a(localTemplatePackInfo.getTitle());
        FotorIOUtils.closeSilently(paramg);
    }

    public void a(PluginService paramPluginService) {
        this.f = paramPluginService;
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        if ((this.k) && (paramBundle != null) && (paramBundle.containsKey("internal_update_is_inapp_mode"))) {
            paramPluginService = new ArrayList();
            a(this.n, paramPluginService);
            if (this.c != null) {
                this.c.a(paramPluginService);
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack) {
        if (this.k) {
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.k) {
            String str = paramPurchasedPack.getPackID();
            int m = (int) (100.0F * paramFloat);
            p.c(new Object[]{"Template Pkg :" + paramPurchasedPack.getPackName() + " download progress: " + m + "%"});
            paramPurchasedPack = this.c.b(str);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a(true);
                paramPurchasedPack.a(m);
                paramPurchasedPack = this.c.c(str);
                if (paramPurchasedPack != null) {
                    paramPurchasedPack.a.a(m);
                }
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.k) {
            String str = paramPurchasedPack.getPackID();
            p.d(new Object[]{"Template Pkg :" + paramPurchasedPack.getPackName() + " download failed! "});
            paramPurchasedPack = this.c.b(str);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a(false);
                paramPurchasedPack.a(0);
                paramPurchasedPack = this.c.c(str);
                if (paramPurchasedPack != null) {
                    paramPurchasedPack.a.b();
                }
            }
            if (!this.i.a()) {
                com.everimaging.fotorsdk.store.utils.f.a(paramInt, this.n, this.m.g().getSupportFragmentManager());
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, String paramString) {
        if (this.k) {
            String str = paramPurchasedPack.getPackID();
            p.d(new Object[]{"Template Pkg :" + paramPurchasedPack.getPackName() + " download success! "});
            paramPurchasedPack = new FeatureDownloadedPack(str, paramPurchasedPack.getPackName(), 0, 0, k(), paramString);
            paramPurchasedPack = (com.everimaging.fotorsdk.plugins.c) h.a(this.n, paramPurchasedPack);
            paramString = this.c.b(str);
            if (paramString != null) {
                a(paramPurchasedPack, paramString);
                paramString.a(0);
                paramString.a(false);
                this.c.notifyDataSetChanged();
                paramPurchasedPack = this.c.c(str);
                if (paramPurchasedPack != null) {
                    paramPurchasedPack.a.b();
                }
            }
            a(this.g);
            if (!TextUtils.isEmpty(this.l)) {
                a(this.l);
            }
        }
    }

    protected void a(String paramString) {
        if (this.a.getAdapter() != null) {
            this.l = paramString;
            this.c.a(paramString);
            int m = ((d) this.a.getAdapter()).a(paramString);
            if (m >= 0) {
                this.a.setCurrentItem(m);
            }
        }
    }

    public void a(List<TemplateCategory> paramList) {
    }

    protected void a(boolean paramBoolean) {
        if (paramBoolean) {
            this.b.setAdapter(null);
        }
        new b(null).execute(new Void[0]);
    }

    public void b() {
        super.b();
    }

    protected void b(int paramInt) {
        Object localObject;
        if (this.a.getAdapter() != null) {
            localObject = (d) this.a.getAdapter();
            if ((this.c != null) && (this.c.getCount() > 0)) {
                localObject = ((d) localObject).a(paramInt);
                if (localObject != null) {
                    break label49;
                }
            }
        }
        label49:
        do {
            return;
            localObject = ((TemplateCategory) localObject).e();
        } while (localObject == null);
        a(((h.b) localObject).g());
    }

    public void b(PurchasedPack paramPurchasedPack) {
        if (this.k) {
            paramPurchasedPack = paramPurchasedPack.getPackID();
            TemplateCategory localTemplateCategory = this.c.b(paramPurchasedPack);
            if (localTemplateCategory != null) {
                localTemplateCategory.a(true);
                localTemplateCategory.a(0);
                paramPurchasedPack = this.c.c(paramPurchasedPack);
                if (paramPurchasedPack != null) {
                    paramPurchasedPack.a.a(0);
                }
            }
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        super.e();
    }

    public void f() {
        this.i.c();
    }

    protected abstract String g();

    public boolean h() {
        return false;
    }

    public void i() {
    }

    public void j() {
    }

    protected abstract int k();

    public void onPageScrollStateChanged(int paramInt) {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    }

    public void onPageSelected(int paramInt) {
        b(paramInt);
    }

    abstract class a
            extends e
            implements AdapterView.OnItemClickListener {
        protected TemplateCategory a;
        protected b b;
        protected BaseVFragment.c c;
        protected int d;

        public a(com.everimaging.fotorsdk.collage.f paramf, TemplateCategory paramTemplateCategory, int paramInt) {
            super();
            this.a = paramTemplateCategory;
            this.d = paramInt;
        }

        public String a() {
            return this.a.e().g();
        }

        public void a(int paramInt) {
            this.d = paramInt;
        }

        public void a(BaseVFragment.c paramc) {
            this.c = paramc;
        }

        public int c() {
            return this.d;
        }

        public abstract void d();

        public abstract void f();

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            paramAdapterView = this.b.a(paramInt);
            if ((paramAdapterView != null) && (this.a != null)) {
                paramView = new TemplateParam();
                paramView.setFeaturePack(((com.everimaging.fotorsdk.plugins.g) this.a.e()).d().copy());
                paramView.setTemplate(new Template(paramAdapterView.a()));
                if (this.c != null) {
                    this.c.a(paramView, this.a);
                }
            }
        }
    }

    private class b
            extends FotorAsyncTask<Void, Void, List<TemplateCategory>> {
        private b() {
        }

        protected List<TemplateCategory> a(Void... paramVarArgs) {
            if ((BaseVFragment.this.m.l()) && (BaseVFragment.this.f != null)) {
                while (!BaseVFragment.this.f.b()) {
                    Utils.sleep(50);
                    BaseVFragment.l().b(new Object[]{"waiting for plugin service"});
                }
                int i = 0;
                int j;
                do {
                    if (BaseVFragment.this.f.a(BaseVFragment.this.k())) {
                        break;
                    }
                    j = i + 1;
                    Utils.sleep(10);
                    i = j;
                } while (j <= 200);
            }
            while (!BaseVFragment.this.f.c()) {
                Utils.sleep(50);
                BaseVFragment.l().b(new Object[]{"waiting for plugin service init build-in and downloaded list"});
            }
            paramVarArgs = new ArrayList();
            BaseVFragment.this.a(BaseVFragment.this.n, paramVarArgs);
            return paramVarArgs;
        }

        protected void a(List<TemplateCategory> paramList) {
            BaseVFragment.this.e.setVisibility(8);
            BaseVFragment.this.d.setVisibility(8);
            BaseVFragment.this.g = paramList;
            if ((paramList != null) && (paramList.size() > 0)) {
                BaseVFragment.this.c = new BaseVFragment.e(BaseVFragment.this, BaseVFragment.this.n, BaseVFragment.this.g);
                BaseVFragment.this.b.setAdapter(BaseVFragment.this.c);
                BaseVFragment.l().c(new Object[]{"->header view size:" + BaseVFragment.this.b.getHeaderViewsCount()});
            }
            BaseVFragment.this.a(BaseVFragment.this.g);
            if ((BaseVFragment.this.a != null) && (BaseVFragment.this.a.getAdapter() != null)) {
                BaseVFragment.this.a.setOnPageChangeListener(BaseVFragment.this);
                BaseVFragment.this.b(0);
            }
            BaseVFragment.this.k = true;
        }

        protected void b(Void... paramVarArgs) {
            BaseVFragment.this.e.setVisibility(0);
            BaseVFragment.this.d.setVisibility(0);
        }

        protected void onCancelled() {
            BaseVFragment.this.e.setVisibility(8);
            BaseVFragment.this.d.setVisibility(8);
        }

        protected void onPreExecute() {
        }
    }

    public static abstract interface c {
        public abstract void a(TemplateParam paramTemplateParam, TemplateCategory paramTemplateCategory);
    }

    protected abstract class d
            extends PagerAdapter {
        protected HashMap<String, BaseVFragment.a> a = new HashMap();
        private List<TemplateCategory> c = new ArrayList();
        private HashMap<String, Integer> d = new HashMap();

        public d() {
            List localList;
            b(localList);
        }

        private void a() {
            this.d.clear();
            int i = 0;
            while (i < this.c.size()) {
                this.d.put(((TemplateCategory) this.c.get(i)).e().g(), Integer.valueOf(i));
                i += 1;
            }
        }

        private void b(List<TemplateCategory> paramList) {
            if (paramList != null) {
                paramList = paramList.iterator();
                while (paramList.hasNext()) {
                    TemplateCategory localTemplateCategory = (TemplateCategory) paramList.next();
                    if (localTemplateCategory.b() == TemplateCategory.TemplatePackType.NORMAL) {
                        this.c.add(localTemplateCategory);
                    }
                }
                a();
            }
        }

        public int a(String paramString) {
            paramString = (Integer) this.d.get(paramString);
            if (paramString != null) {
                return paramString.intValue();
            }
            return -1;
        }

        public TemplateCategory a(int paramInt) {
            return (TemplateCategory) this.c.get(paramInt);
        }

        public void a(List<TemplateCategory> paramList) {
            this.c.clear();
            b(paramList);
            notifyDataSetChanged();
        }

        public abstract BaseVFragment.a b(int paramInt);

        public TemplateCategory c(int paramInt) {
            return (TemplateCategory) this.c.get(paramInt);
        }

        public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
            if (paramObject != null) {
                paramObject = (BaseVFragment.a) paramObject;
                ((BaseVFragment.a) paramObject).d();
                paramViewGroup.removeView(((BaseVFragment.a) paramObject).n());
                ((BaseVFragment.a) paramObject).e();
            }
        }

        public int getCount() {
            return this.c.size();
        }

        public int getItemPosition(Object paramObject) {
            if (paramObject != null) {
                paramObject = (BaseVFragment.a) paramObject;
                String str = ((BaseVFragment.a) paramObject).a();
                if (((BaseVFragment.a) paramObject).c() != a(str)) {
                }
            } else {
                return -1;
            }
            return -2;
        }

        public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
            String str = c(paramInt).a().toString();
            Object localObject2 = (BaseVFragment.a) this.a.get(str);
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = b(paramInt);
                this.a.put(str, localObject1);
            }
            ((BaseVFragment.a) localObject1).a(paramInt);
            localObject2 = ((BaseVFragment.a) localObject1).n();
            if (((View) localObject2).getParent() != null) {
                paramViewGroup.removeView((View) localObject2);
            }
            paramViewGroup.addView((View) localObject2);
            ((BaseVFragment.a) localObject1).b();
            ((BaseVFragment.a) localObject1).f();
            return localObject1;
        }

        public boolean isViewFromObject(View paramView, Object paramObject) {
            return ((BaseVFragment.a) paramObject).n() == paramView;
        }
    }

    protected class e
            extends BaseAdapter
            implements View.OnClickListener {
        private LayoutInflater b;
        private Context c;
        private List<TemplateCategory> d;
        private Map<String, a> e;
        private Map<String, TemplateCategory> f;
        private HashMap<String, Boolean> g;

        public e(List<TemplateCategory> paramList) {
            this.c = paramList;
            this.b = ((LayoutInflater) this.c.getSystemService("layout_inflater"));
            this.g = new HashMap();
            this.e = new LinkedHashMap();
            this.f = new LinkedHashMap();
            List localList;
            b(localList);
        }

        private void a() {
            this.f.clear();
            if ((this.d != null) && (this.d.size() > 0)) {
                Iterator localIterator = this.d.iterator();
                while (localIterator.hasNext()) {
                    TemplateCategory localTemplateCategory = (TemplateCategory) localIterator.next();
                    if (localTemplateCategory.b() != TemplateCategory.TemplatePackType.STORE) {
                        String str = localTemplateCategory.e().g();
                        this.f.put(str, localTemplateCategory);
                    }
                }
            }
            this.e.clear();
        }

        private void b(List<TemplateCategory> paramList) {
            if (this.d != null) {
                this.d.clear();
                this.d.addAll(paramList);
            }
            for (; ; ) {
                a();
                return;
                this.d = paramList;
            }
        }

        public TemplateCategory a(int paramInt) {
            return (TemplateCategory) this.d.get(paramInt);
        }

        public void a(String paramString) {
            this.g.clear();
            this.g.put(paramString, Boolean.valueOf(true));
            notifyDataSetChanged();
        }

        public void a(List<TemplateCategory> paramList) {
            b(paramList);
            notifyDataSetChanged();
        }

        public TemplateCategory b(String paramString) {
            TemplateCategory localTemplateCategory = null;
            if (this.f != null) {
                localTemplateCategory = (TemplateCategory) this.f.get(paramString);
            }
            return localTemplateCategory;
        }

        public a c(String paramString) {
            a locala2 = (a) this.e.get(paramString);
            a locala1 = locala2;
            if (locala2 != null) {
                locala1 = locala2;
                if (!paramString.equals(locala2.b)) {
                    locala1 = null;
                }
            }
            return locala1;
        }

        public int getCount() {
            return this.d.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public int getItemViewType(int paramInt) {
            if (((TemplateCategory) this.d.get(paramInt)).b() == TemplateCategory.TemplatePackType.STORE) {
                return 0;
            }
            return 1;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            int j = 2;
            int i = 0;
            TemplateCategory localTemplateCategory = (TemplateCategory) this.d.get(paramInt);
            int k = getItemViewType(paramInt);
            label73:
            Object localObject1;
            Object localObject2;
            label139:
            label145:
            label185:
            String str;
            if (paramView == null) {
                if (k == 0) {
                    paramView = this.b.inflate(R.layout.fotor_feature_store_button, null);
                    paramViewGroup = new a(null);
                    paramViewGroup.a = ((FotorNavigationButton) paramView.findViewById(R.id.fotor_navigation_button));
                    paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                    if (localTemplateCategory.b() != TemplateCategory.TemplatePackType.EXTERNAL) {
                        break label402;
                    }
                    localObject1 = (d) localTemplateCategory.e();
                    localObject2 = (FotorExternalPkgButton) paramViewGroup.a;
                    ((FotorExternalPkgButton) localObject2).a(((d) localObject1).d(), ((d) localObject1).e());
                    if (!((d) localObject1).c()) {
                        break label397;
                    }
                    paramInt = 2;
                    ((FotorExternalPkgButton) localObject2).setShowIndicator(paramInt);
                    paramViewGroup.a.setButtonName(localTemplateCategory.a());
                    paramViewGroup.a.setOnClickListener(this);
                    if (!localTemplateCategory.f()) {
                        break label570;
                    }
                    paramViewGroup.a.a(localTemplateCategory.g());
                    if (localTemplateCategory.b() != TemplateCategory.TemplatePackType.STORE) {
                        str = localTemplateCategory.e().g();
                        localObject2 = (a) this.e.get(str);
                        localObject1 = localObject2;
                        if (localObject2 == null) {
                            this.e.put(str, paramViewGroup);
                            localObject1 = paramViewGroup;
                        }
                        ((a) localObject1).b = str;
                        if (localTemplateCategory.b() == TemplateCategory.TemplatePackType.NORMAL) {
                            localObject1 = (Boolean) this.g.get(str);
                            if (localObject1 == null) {
                                break label588;
                            }
                        }
                    }
                }
            }
            label397:
            label402:
            label570:
            label583:
            label588:
            for (boolean bool = ((Boolean) localObject1).booleanValue(); ; bool = false) {
                paramViewGroup.a.setSelected(bool);
                if (!((com.everimaging.fotorsdk.plugins.g) localTemplateCategory.e() instanceof com.everimaging.fotorsdk.plugins.g.a)) {
                    if (!com.everimaging.fotorsdk.preference.a.b(this.c, str)) {
                        break label583;
                    }
                }
                for (paramInt = 1; ; paramInt = 0) {
                    if ((bool) && (paramInt == 1)) {
                        com.everimaging.fotorsdk.preference.a.a(this.c, str, false);
                        paramInt = i;
                    }
                    for (; ; ) {
                        ((FotorExternalPkgButton) paramViewGroup.a).setShowIndicator(paramInt);
                        paramView.setTag(paramViewGroup);
                        return paramView;
                        paramView = this.b.inflate(R.layout.fotor_collage_pack_category_item, null);
                        break;
                        paramViewGroup = (a) paramView.getTag();
                        break label73;
                        paramInt = 3;
                        break label139;
                        if (localTemplateCategory.b() == TemplateCategory.TemplatePackType.NORMAL) {
                            localObject1 = (FotorExternalPkgButton) paramViewGroup.a;
                            ((FotorExternalPkgButton) localObject1).setImageDrawable(((com.everimaging.fotorsdk.plugins.g) localTemplateCategory.e()).c());
                            ((FotorExternalPkgButton) localObject1).setShowIndicator(0);
                            break label145;
                        }
                        if (localTemplateCategory.b() == TemplateCategory.TemplatePackType.STORE) {
                            paramViewGroup.a.setImageResource(R.drawable.fotor_store_button_icon);
                            if (!(paramViewGroup.a instanceof com.everimaging.fotorsdk.store.widget.a)) {
                                break label145;
                            }
                            ((com.everimaging.fotorsdk.store.widget.a) paramViewGroup.a).setNewNum(BaseVFragment.this.j);
                            break label145;
                        }
                        if (localTemplateCategory.b() != TemplateCategory.TemplatePackType.PURCHASED) {
                            break label145;
                        }
                        localObject1 = (i) localTemplateCategory.e();
                        localObject2 = (FotorExternalPkgButton) paramViewGroup.a;
                        ((FotorExternalPkgButton) localObject2).a(((i) localObject1).d(), ((i) localObject1).e());
                        if (((i) localObject1).c()) {
                        }
                        for (paramInt = j; ; paramInt = 3) {
                            ((FotorExternalPkgButton) localObject2).setShowIndicator(paramInt);
                            break;
                        }
                        paramViewGroup.a.b();
                        break label185;
                    }
                }
            }
        }

        public int getViewTypeCount() {
            return 2;
        }

        public void onClick(View paramView) {
            Object localObject;
            if (paramView.getTag() != null) {
                int i = Integer.parseInt(paramView.getTag().toString());
                localObject = BaseVFragment.this.c.a(i);
            }
            switch (BaseVFragment .2.a[localObject.b().ordinal()])
            {
                case 2:
                default:
                case 1:
                case 3:
                    do {
                        return;
                        paramView = ((d) ((TemplateCategory) localObject).e()).f();
                        localObject = new DetailPageInfo();
                        ((DetailPageInfo) localObject).id = paramView.getId();
                        ((DetailPageInfo) localObject).count = paramView.getItemsCount();
                        ((DetailPageInfo) localObject).description = paramView.getDescription();
                        ((DetailPageInfo) localObject).name = paramView.getName();
                        ((DetailPageInfo) localObject).pkgName = paramView.getPackageName();
                        ((DetailPageInfo) localObject).price = paramView.getPrice();
                        BaseVFragment.this.i.a((DetailPageInfo) localObject, null, null);
                        return;
                        paramView = ((i) ((TemplateCategory) localObject).e()).f();
                    } while (((TemplateCategory) localObject).f());
                    a locala = BaseVFragment.this.c.c(((TemplateCategory) localObject).c());
                    if (locala != null) {
                        locala.a.a(0);
                    }
                    ((TemplateCategory) localObject).a(true);
                    ((TemplateCategory) localObject).a(0);
                    BaseVFragment.this.a(paramView);
                    return;
                case 4:
                    localObject = ((TemplateCategory) localObject).e().g();
                    paramView = (FotorExternalPkgButton) paramView;
                    if (paramView.c()) {
                        com.everimaging.fotorsdk.preference.a.a(this.c, (String) localObject, false);
                        paramView.setShowIndicator(0);
                    }
                    BaseVFragment.this.a((String) localObject);
                    return;
            }
            BaseVFragment.this.i.a(null, null);
        }

        private class a {
            FotorNavigationButton a;
            String b;

            private a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/BaseVFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */