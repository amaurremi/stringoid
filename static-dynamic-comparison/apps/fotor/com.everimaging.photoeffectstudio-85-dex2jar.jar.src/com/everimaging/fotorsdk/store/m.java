package com.everimaging.fotorsdk.store;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.utils.c;
import com.everimaging.fotorsdk.store.utils.c.c;
import com.everimaging.fotorsdk.widget.FotorTextView;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.c;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshGridView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class m
        extends k {
    private static final String j = m.class.getSimpleName();
    private static final FotorLoggerFactory.c k = FotorLoggerFactory.a(j, FotorLoggerFactory.LoggerType.CONSOLE);
    private static final String[] p = {c.e, c.f};
    private HashMap<String, a> l;
    private LinearLayout m;
    private View n;
    private View o;

    public m(j paramj, String paramString) {
        super(paramj, paramString);
    }

    protected void a() {
        this.h.post(new Runnable() {
            public void run() {
                int i = 0;
                while (i < m.i().length) {
                    String str = m.i()[i];
                    ((m.a) m.a(m.this).get(str)).a(false);
                    i += 1;
                }
            }
        });
    }

    public void a(PurchasedPack paramPurchasedPack) {
        Object localObject = paramPurchasedPack.getType();
        localObject = (a) this.l.get(localObject);
        if (localObject != null) {
            ((a) localObject).b(paramPurchasedPack);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        Object localObject = paramPurchasedPack.getType();
        localObject = (a) this.l.get(localObject);
        if (localObject != null) {
            ((a) localObject).a(paramPurchasedPack, paramFloat);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        Object localObject = paramPurchasedPack.getType();
        localObject = (a) this.l.get(localObject);
        if (localObject != null) {
            ((a) localObject).a(paramPurchasedPack, paramInt);
        }
    }

    public void a(String paramString1, String paramString2) {
        paramString1 = (a) this.l.get(paramString1);
        if (paramString1 != null) {
            paramString1.a(paramString2);
        }
    }

    protected void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, String paramString) {
        super.a(paramList, paramString);
        paramString = (a) this.l.get(paramString);
        if (paramString != null) {
            paramString.b(paramList);
        }
    }

    protected void b() {
        this.a = LayoutInflater.from(this.c).inflate(R.layout.fotor_store_collage_feature_page, null);
        this.m = ((LinearLayout) this.a.findViewById(R.id.fotor_store_collage_main_container));
        this.l = new HashMap();
        int i1 = this.c.getResources().getDimensionPixelSize(R.dimen.fotor_store_collage_title_btn_height);
        int i = 0;
        if (i < p.length) {
            Object localObject = p[i];
            a locala = new a((String) localObject);
            this.l.put(localObject, locala);
            localObject = new LinearLayout.LayoutParams(-1, i1);
            this.m.addView(locala.b(), (ViewGroup.LayoutParams) localObject);
            localObject = new LinearLayout.LayoutParams(-1, 0, 1.0F);
            this.m.addView(locala.a(), (ViewGroup.LayoutParams) localObject);
            if (i == 0) {
                this.o = locala.b();
                this.n = locala.a();
                this.o.setSelected(true);
            }
            for (; ; ) {
                i += 1;
                break;
                locala.a().setVisibility(8);
            }
        }
    }

    public void b(PurchasedPack paramPurchasedPack) {
        Object localObject = paramPurchasedPack.getType();
        localObject = (a) this.l.get(localObject);
        if (localObject != null) {
            ((a) localObject).a(paramPurchasedPack);
        }
    }

    public void b(String paramString) {
        paramString = (a) this.l.get(paramString);
        if (paramString != null) {
            if (this.n != null) {
                this.n.setVisibility(8);
            }
            if (this.o != null) {
                this.o.setSelected(false);
            }
            this.n = paramString.a();
            this.n.setVisibility(0);
            this.o = paramString.b();
            this.o.setSelected(true);
        }
    }

    protected void c() {
        Iterator localIterator = this.l.values().iterator();
        while (localIterator.hasNext()) {
            ((a) localIterator.next()).f();
        }
    }

    public void c(PurchasedPack paramPurchasedPack) {
        Object localObject = paramPurchasedPack.getType();
        localObject = (a) this.l.get(localObject);
        if (localObject != null) {
            ((a) localObject).c(paramPurchasedPack);
        }
    }

    public void e() {
        int i = 0;
        while (i < p.length) {
            String str = p[i];
            ((a) this.l.get(str)).d();
            i += 1;
        }
    }

    public void f() {
        super.f();
        int i = 0;
        while (i < p.length) {
            String str = p[i];
            ((a) this.l.get(str)).c();
            i += 1;
        }
    }

    public void g() {
        int i = 0;
        while (i < p.length) {
            String str = p[i];
            ((a) this.l.get(str)).e();
            i += 1;
        }
    }

    private class a {
        private String b;
        private View c;
        private View d;
        private TextView e;
        private PullToRefreshGridView f;
        private View g;
        private LinearLayout h;
        private FotorTextView i;
        private com.everimaging.fotorsdk.store.adapter.a j;
        private View.OnClickListener k = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (paramAnonymousView != m.b(m.this)) {
                    paramAnonymousView = paramAnonymousView.getTag().toString();
                    m.this.b(paramAnonymousView);
                }
            }
        };
        private PullToRefreshBase.c<GridView> l = new PullToRefreshBase.c() {
            public void a(PullToRefreshBase<GridView> paramAnonymousPullToRefreshBase) {
                if (m.this.g != null) {
                    m.this.g.a();
                }
            }
        };
        private com.everimaging.fotorsdk.store.utils.a m = new com.everimaging.fotorsdk.store.utils.a(4, 16) {
            public void a(int paramAnonymousInt1, int paramAnonymousInt2) {
                m.a.a(m.a.this, paramAnonymousInt1, false);
            }
        };

        public a(String paramString) {
            this.b = paramString;
            g();
        }

        private void a(int paramInt, final boolean paramBoolean) {
            c.a(new c.c() {
                public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject) {
                    m.a.this.e();
                    if (paramBoolean) {
                        List localList = m.a.b(m.a.this).a();
                        if (localList != null) {
                            localList.clear();
                        }
                    }
                    paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                    m.this.a(paramAnonymousResposeListJsonObject, m.a.a(m.a.this), paramBoolean);
                }

                public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                    m.a.this.e();
                    if (m.a.b(m.a.this).getCount() == 0) {
                        m.a.c(m.a.this);
                        return;
                    }
                    m.a.d(m.a.this).a();
                }
            }, m.this.c, this.b, paramInt, 16, paramBoolean, com.everimaging.fotorsdk.store.iap.a.b());
        }

        private void g() {
            LayoutInflater localLayoutInflater = LayoutInflater.from(m.this.c);
            this.d = localLayoutInflater.inflate(R.layout.fotor_store_collage_module_title, null);
            this.d.setTag(this.b);
            this.d.setOnClickListener(this.k);
            this.e = ((TextView) this.d.findViewById(R.id.fotor_collage_module_title_textview));
            this.e.setText(h());
            this.c = localLayoutInflater.inflate(R.layout.fotor_store_collage_submodule_layout, null);
            this.f = ((PullToRefreshGridView) this.c.findViewById(R.id.fotor_store_grid_view));
            this.f.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
            this.f.setScrollingWhileRefreshingEnabled(false);
            this.j = new com.everimaging.fotorsdk.store.adapter.a(m.this.c, this.b, m.this.i);
            this.f.setAdapter(this.j);
            this.f.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    paramAnonymousAdapterView = (FotorStoreJsonObjects.ResPackageJsonObject) paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
                    if (m.this.g != null) {
                        paramAnonymousView = new DetailPageInfo();
                        paramAnonymousView.name = paramAnonymousAdapterView.name;
                        paramAnonymousView.count = paramAnonymousAdapterView.count;
                        paramAnonymousView.id = paramAnonymousAdapterView.id;
                        paramAnonymousView.description = paramAnonymousAdapterView.description;
                        paramAnonymousView.detailThumb = paramAnonymousAdapterView.thumb;
                        paramAnonymousView.price = paramAnonymousAdapterView.price;
                        paramAnonymousView.pkgName = paramAnonymousAdapterView.pkgName;
                        paramAnonymousView.type = m.a.a(m.a.this);
                        paramAnonymousView.statusInfo = paramAnonymousAdapterView.statusInfo;
                        m.this.g.a(paramAnonymousView, true);
                    }
                }
            });
            this.g = this.c.findViewById(R.id.fotor_store_module_loading);
            this.h = ((LinearLayout) this.c.findViewById(R.id.fotor_store_exception_panel));
            this.i = ((FotorTextView) this.c.findViewById(R.id.fotor_store_retry_button));
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    m.a.this.a(true);
                }
            });
        }

        private String h() {
            String str = "";
            if (c.f(this.b)) {
                str = m.this.c.getString(R.string.fotor_store_title_collage_classic);
            }
            do {
                return str;
                if (c.g(this.b)) {
                    return m.this.c.getString(R.string.fotor_store_title_collage_magazine);
                }
            } while (!c.h(this.b));
            return m.this.c.getString(R.string.fotor_store_title_collage_pattern);
        }

        private void i() {
            this.g.setVisibility(0);
            this.h.setVisibility(4);
            this.f.setVisibility(4);
        }

        private void j() {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
        }

        public View a() {
            return this.c;
        }

        public void a(PurchasedPack paramPurchasedPack) {
        }

        public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
            if (this.j == null) {
            }
            do {
                return;
                paramPurchasedPack = paramPurchasedPack.getPackID();
                paramPurchasedPack = this.j.a(paramPurchasedPack);
            } while ((paramPurchasedPack == null) || (paramPurchasedPack.statusInfo == null));
            paramPurchasedPack.statusInfo.a(paramFloat);
            m.this.a(this.f, paramPurchasedPack, this.j);
        }

        public void a(PurchasedPack paramPurchasedPack, int paramInt) {
            if (this.j == null) {
                return;
            }
            m.this.a(paramPurchasedPack, 2, this.j);
        }

        public void a(String paramString) {
            m.this.a(paramString, -1, this.j);
        }

        public void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList) {
            List localList = this.j.a();
            if (localList != null) {
                localList.addAll(paramList);
                this.j.a(localList);
                return;
            }
            this.j.a(paramList);
            this.f.setOnRefreshListener(this.l);
            this.f.setOnScrollListener(this.m);
        }

        public void a(boolean paramBoolean) {
            i();
            a(1, paramBoolean);
        }

        public View b() {
            return this.d;
        }

        public void b(PurchasedPack paramPurchasedPack) {
            if (this.j == null) {
                return;
            }
            m.this.a(paramPurchasedPack, 6, this.j);
        }

        public void b(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList) {
            this.g.setVisibility(8);
            this.f.setVisibility(0);
            if ((paramList != null) && (paramList.size() > 0)) {
                m.this.b(paramList, this.b);
                a(paramList);
                this.h.setVisibility(4);
            }
            while (this.j.getCount() != 0) {
                return;
            }
            j();
        }

        public void c() {
            a(1, true);
        }

        public void c(PurchasedPack paramPurchasedPack) {
            if (this.j == null) {
                return;
            }
            m.this.a(paramPurchasedPack, 3, this.j);
        }

        public void d() {
            List localList = this.j.a();
            if (localList != null) {
                m.this.b(localList, this.b);
                this.j.notifyDataSetChanged();
            }
        }

        public void e() {
            this.f.j();
        }

        public void f() {
            if (this.j == null) {
                return;
            }
            m.this.b(this.j.a(), this.b);
            this.j.notifyDataSetChanged();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */