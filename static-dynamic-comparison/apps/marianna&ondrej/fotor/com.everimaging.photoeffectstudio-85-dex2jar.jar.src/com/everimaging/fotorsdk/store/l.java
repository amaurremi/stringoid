package com.everimaging.fotorsdk.store;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
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

import java.util.ArrayList;
import java.util.List;

public class l
        extends k {
    private static final String k = l.class.getSimpleName();
    private static final FotorLoggerFactory.c l = FotorLoggerFactory.a(k, FotorLoggerFactory.LoggerType.CONSOLE);
    PullToRefreshBase.c<GridView> j = new PullToRefreshBase.c() {
        public void a(PullToRefreshBase<GridView> paramAnonymousPullToRefreshBase) {
            if (l.this.g != null) {
                l.this.g.a();
            }
        }
    };
    private PullToRefreshGridView m;
    private com.everimaging.fotorsdk.store.adapter.a n;
    private View o;
    private LinearLayout p;
    private FotorTextView q;
    private com.everimaging.fotorsdk.store.utils.a r = new com.everimaging.fotorsdk.store.utils.a(4, 16) {
        public void a(int paramAnonymousInt1, int paramAnonymousInt2) {
            l.a(l.this, paramAnonymousInt1, false);
        }
    };

    public l(j paramj, String paramString) {
        super(paramj, paramString);
    }

    private void a(int paramInt, final boolean paramBoolean) {
        c.a(new c.c() {
            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject) {
                l.this.g();
                if (paramBoolean) {
                    List localList = l.a(l.this).a();
                    if (localList != null) {
                        localList.clear();
                    }
                }
                paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                l.this.a(paramAnonymousResposeListJsonObject, l.this.f, paramBoolean);
            }

            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                l.this.g();
                if (l.a(l.this).getCount() == 0) {
                    l.b(l.this);
                    return;
                }
                l.c(l.this).a();
            }
        }, this.c, this.f, paramInt, 16, paramBoolean, com.everimaging.fotorsdk.store.iap.a.b());
    }

    private void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList) {
        List localList = this.n.a();
        if (localList != null) {
            localList.addAll(paramList);
            this.n.a(localList);
            return;
        }
        this.n.a(paramList);
        this.m.setOnScrollListener(this.r);
        this.m.setOnRefreshListener(this.j);
    }

    private void a(boolean paramBoolean) {
        i();
        a(1, paramBoolean);
    }

    private void b(String paramString) {
        a(paramString, -1, this.n);
    }

    private void i() {
        this.o.setVisibility(0);
        this.p.setVisibility(4);
        this.m.setVisibility(4);
    }

    private void j() {
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(0);
    }

    protected void a() {
        this.h.post(new Runnable() {
            public void run() {
                l.a(l.this, false);
            }
        });
    }

    public void a(PurchasedPack paramPurchasedPack) {
        if (this.n == null) {
            return;
        }
        b(paramPurchasedPack.getPackID());
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.n == null) {
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.n == null) {
            return;
        }
        b(paramPurchasedPack.getPackID());
    }

    protected void a(FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject, ArrayList<String> paramArrayList) {
        paramResPackageJsonObject.statusInfo = StatusAssistant.a(paramResPackageJsonObject, paramArrayList, this);
    }

    protected void a(String paramString, int paramInt, com.everimaging.fotorsdk.store.adapter.a parama) {
        paramString = parama.b(paramString);
        if (paramString != null) {
            a(paramString, this.b.a(paramString.type));
            if (parama.c(paramString.getPackID()) != null) {
                parama.notifyDataSetChanged();
                return;
            }
            l.c(new Object[]{"current item is resued"});
            return;
        }
        l.c(new Object[]{"current item is invalid"});
    }

    public void a(String paramString1, String paramString2) {
        b(paramString2);
    }

    protected void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, String paramString) {
        super.a(paramList, paramString);
        this.o.setVisibility(8);
        this.m.setVisibility(0);
        if ((paramList != null) && (paramList.size() > 0)) {
            b(paramList, this.f);
            a(paramList);
            this.p.setVisibility(4);
        }
        while (this.n.getCount() != 0) {
            return;
        }
        j();
    }

    protected void b() {
        this.a = LayoutInflater.from(this.c).inflate(R.layout.fotor_store_feature_page, null);
        this.m = ((PullToRefreshGridView) this.a.findViewById(R.id.fotor_store_grid_view));
        this.m.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        this.m.setScrollingWhileRefreshingEnabled(false);
        this.n = new com.everimaging.fotorsdk.store.adapter.a(this.c, this.f, this.i);
        this.m.setAdapter(this.n);
        this.m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                paramAnonymousAdapterView = (FotorStoreJsonObjects.ResPackageJsonObject) paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
                if (l.this.g != null) {
                    paramAnonymousView = new DetailPageInfo();
                    paramAnonymousView.name = paramAnonymousAdapterView.name;
                    paramAnonymousView.count = paramAnonymousAdapterView.count;
                    paramAnonymousView.id = paramAnonymousAdapterView.id;
                    paramAnonymousView.description = paramAnonymousAdapterView.description;
                    paramAnonymousView.detailThumb = paramAnonymousAdapterView.thumb;
                    paramAnonymousView.price = paramAnonymousAdapterView.price;
                    paramAnonymousView.pkgName = paramAnonymousAdapterView.pkgName;
                    paramAnonymousView.type = l.this.f;
                    paramAnonymousView.statusInfo = paramAnonymousAdapterView.statusInfo;
                    l.this.g.a(paramAnonymousView, false);
                }
            }
        });
        this.o = this.a.findViewById(R.id.fotor_store_module_loading);
        this.p = ((LinearLayout) this.a.findViewById(R.id.fotor_store_exception_panel));
        this.q = ((FotorTextView) this.a.findViewById(R.id.fotor_store_retry_button));
        this.q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                l.a(l.this, true);
            }
        });
    }

    protected void c() {
        if (this.n == null) {
            return;
        }
        b(this.n.a(), this.f);
        this.n.notifyDataSetChanged();
    }

    public void c(PurchasedPack paramPurchasedPack) {
        if (this.n == null) {
            return;
        }
        b(paramPurchasedPack.getPackID());
    }

    public void e() {
        List localList = this.n.a();
        if (localList != null) {
            b(localList, this.f);
            this.n.notifyDataSetChanged();
        }
    }

    public void f() {
        super.f();
        a(1, true);
    }

    public void g() {
        this.m.j();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */