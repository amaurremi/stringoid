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

import java.util.List;

public class n
        extends k {
    private static final String k = n.class.getSimpleName();
    private static final FotorLoggerFactory.c l = FotorLoggerFactory.a(k, FotorLoggerFactory.LoggerType.CONSOLE);
    PullToRefreshBase.c<GridView> j = new PullToRefreshBase.c() {
        public void a(PullToRefreshBase<GridView> paramAnonymousPullToRefreshBase) {
            if (n.this.g != null) {
                n.this.g.a();
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
            n.a(n.this, paramAnonymousInt1, false);
        }
    };

    public n(j paramj, String paramString) {
        super(paramj, paramString);
    }

    private void a(int paramInt, final boolean paramBoolean) {
        c.a(new c.c() {
            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject) {
                n.this.g();
                if (paramBoolean) {
                    List localList = n.a(n.this).a();
                    if (localList != null) {
                        localList.clear();
                    }
                }
                paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                n.this.a(paramAnonymousResposeListJsonObject, n.this.f, paramBoolean);
            }

            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                n.this.g();
                if (n.a(n.this).getCount() == 0) {
                    n.b(n.this);
                    return;
                }
                n.c(n.this).a();
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
                n.a(n.this, false);
            }
        });
    }

    public void a(PurchasedPack paramPurchasedPack) {
        if (this.n == null) {
            return;
        }
        a(paramPurchasedPack, 6, this.n);
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.n == null) {
        }
        do {
            return;
            paramPurchasedPack = paramPurchasedPack.getPackID();
            paramPurchasedPack = this.n.a(paramPurchasedPack);
        } while ((paramPurchasedPack == null) || (paramPurchasedPack.statusInfo == null));
        paramPurchasedPack.statusInfo.a(paramFloat);
        a(this.m, paramPurchasedPack, this.n);
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.n == null) {
            return;
        }
        a(paramPurchasedPack, 2, this.n);
    }

    public void a(String paramString1, String paramString2) {
        a(paramString2, -1, this.n);
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
                if (n.this.g != null) {
                    paramAnonymousView = new DetailPageInfo();
                    paramAnonymousView.name = paramAnonymousAdapterView.name;
                    paramAnonymousView.count = paramAnonymousAdapterView.count;
                    paramAnonymousView.id = paramAnonymousAdapterView.id;
                    paramAnonymousView.description = paramAnonymousAdapterView.description;
                    paramAnonymousView.detailThumb = paramAnonymousAdapterView.thumb;
                    paramAnonymousView.price = paramAnonymousAdapterView.price;
                    paramAnonymousView.pkgName = paramAnonymousAdapterView.pkgName;
                    paramAnonymousView.type = n.this.f;
                    paramAnonymousView.statusInfo = paramAnonymousAdapterView.statusInfo;
                    n.this.g.a(paramAnonymousView, true);
                }
            }
        });
        this.o = this.a.findViewById(R.id.fotor_store_module_loading);
        this.p = ((LinearLayout) this.a.findViewById(R.id.fotor_store_exception_panel));
        this.q = ((FotorTextView) this.a.findViewById(R.id.fotor_store_retry_button));
        this.q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                n.a(n.this, true);
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
        a(paramPurchasedPack, 3, this.n);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */