package com.everimaging.fotorsdk.store;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.billing.g;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.utils.c;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class k
        implements StatusAssistant.a {
    private static final String j = k.class.getSimpleName();
    private static final FotorLoggerFactory.c k = FotorLoggerFactory.a(j, FotorLoggerFactory.LoggerType.CONSOLE);
    protected View a;
    protected j b;
    protected FragmentActivity c;
    protected b d;
    protected HashMap<String, List<FotorStoreJsonObjects.ResPackageJsonObject>> e;
    protected String f;
    protected a g;
    protected Handler h;
    protected View.OnClickListener i;

    public k(j paramj, String paramString) {
        this.b = paramj;
        this.c = this.b.f();
        this.f = paramString;
        this.h = new Handler(this.c.getMainLooper());
        this.e = new HashMap();
        i();
        b();
        a();
    }

    private void i() {
        this.i = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (paramAnonymousView.getTag() != null) {
                    paramAnonymousView = (FotorStoreJsonObjects.ResPackageJsonObject) paramAnonymousView.getTag();
                    k.this.b.a(new ProductInfo(paramAnonymousView.type, paramAnonymousView.id, paramAnonymousView.pkgName, paramAnonymousView.name, paramAnonymousView.price, paramAnonymousView.resources), paramAnonymousView.type, false);
                }
            }
        };
    }

    protected List<FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo> a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, boolean paramBoolean) {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo localPurchaseResourceInfo = c.a(((FotorStoreJsonObjects.ResPackageJsonObject) paramList.next()).id);
            if ((localPurchaseResourceInfo != null) && (!TextUtils.isEmpty(localPurchaseResourceInfo.productId)) && ((TextUtils.isEmpty(localPurchaseResourceInfo.realPrice)) || (paramBoolean))) {
                localArrayList.add(localPurchaseResourceInfo);
            }
        }
        return localArrayList;
    }

    protected abstract void a();

    public abstract void a(PurchasedPack paramPurchasedPack);

    public abstract void a(PurchasedPack paramPurchasedPack, float paramFloat);

    public abstract void a(PurchasedPack paramPurchasedPack, int paramInt);

    protected void a(PurchasedPack paramPurchasedPack, int paramInt, com.everimaging.fotorsdk.store.adapter.a parama) {
        String str = paramPurchasedPack.getPackID();
        k.c(new Object[]{"update specify item status:" + paramPurchasedPack + ",status:" + paramInt});
        a(str, paramInt, parama);
    }

    protected void a(FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject, ArrayList<String> paramArrayList) {
        paramResPackageJsonObject.statusInfo = StatusAssistant.a(paramResPackageJsonObject, paramArrayList, this);
    }

    public void a(a parama) {
        this.g = parama;
    }

    protected void a(PullToRefreshGridView paramPullToRefreshGridView, FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject, com.everimaging.fotorsdk.store.adapter.a parama) {
        try {
            int m = ((GridView) paramPullToRefreshGridView.getRefreshableView()).getFirstVisiblePosition();
            int n = parama.a(paramResPackageJsonObject);
            paramResPackageJsonObject = ((GridView) paramPullToRefreshGridView.getRefreshableView()).getChildAt(n - m);
            ((GridView) paramPullToRefreshGridView.getRefreshableView()).getAdapter().getView(n, paramResPackageJsonObject, (ViewGroup) paramPullToRefreshGridView.getRefreshableView());
            return;
        } catch (Exception paramPullToRefreshGridView) {
            k.e(new Object[]{"update progress error:" + paramPullToRefreshGridView.getMessage()});
        }
    }

    protected void a(String paramString, int paramInt, com.everimaging.fotorsdk.store.adapter.a parama) {
        if (parama == null) {
            return;
        }
        FotorStoreJsonObjects.ResPackageJsonObject localResPackageJsonObject = parama.a(paramString);
        if (localResPackageJsonObject != null) {
            StatusAssistant.StatusInfo localStatusInfo = localResPackageJsonObject.statusInfo;
            if ((paramInt >= 0) && (localStatusInfo != null)) {
                localStatusInfo.a(paramInt);
            }
            while (parama.c(paramString) != null) {
                parama.notifyDataSetChanged();
                return;
                a(localResPackageJsonObject, this.b.a(localResPackageJsonObject.type));
            }
            k.c(new Object[]{"current item is resued"});
            return;
        }
        k.c(new Object[]{"current item is invalid"});
    }

    public abstract void a(String paramString1, String paramString2);

    protected void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, String paramString) {
    }

    protected void a(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, String paramString, boolean paramBoolean) {
        if ((paramList != null) && (paramList.size() > 0)) {
            this.e.put(paramString, paramList);
            if ((com.everimaging.fotorsdk.store.iap.a.b()) && (!c.d())) {
                List localList = a(paramList, paramBoolean);
                if (localList.size() > 0) {
                    if (this.d != null) {
                        this.d.cancel(true);
                        k.d(new Object[]{"update price task is running i'll cancel this task."});
                    }
                    this.d = new b(paramList, localList, paramString);
                    this.d.executeOnExecutor(FotorAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
            }
        }
        a(paramList, paramString);
    }

    public boolean a(String paramString) {
        return this.b.b(paramString);
    }

    protected abstract void b();

    public void b(PurchasedPack paramPurchasedPack) {
    }

    protected void b(List<FotorStoreJsonObjects.ResPackageJsonObject> paramList, String paramString) {
        if (paramList == null) {
        }
        for (; ; ) {
            return;
            paramString = this.b.a(paramString);
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                a((FotorStoreJsonObjects.ResPackageJsonObject) paramList.next(), paramString);
            }
        }
    }

    protected abstract void c();

    public abstract void c(PurchasedPack paramPurchasedPack);

    public View d() {
        return this.a;
    }

    public abstract void e();

    public void f() {
        if (this.d != null) {
            this.d.cancel(true);
        }
        this.d = null;
    }

    public abstract void g();

    public static abstract interface a {
        public abstract void a();

        public abstract void a(DetailPageInfo paramDetailPageInfo, boolean paramBoolean);
    }

    protected class b
            extends FotorAsyncTask<Void, Void, Boolean> {
        List<FotorStoreJsonObjects.ResPackageJsonObject> a;
        List<FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo> b;
        String c;

        public b(List<FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo> paramList, String paramString) {
            this.a = paramList;
            this.b = paramString;
            String str;
            this.c = str;
        }

        protected Boolean a(Void... paramVarArgs) {
            return Boolean.valueOf(a(this.b));
        }

        protected void a(Boolean paramBoolean) {
            k.this.d = null;
            if (paramBoolean.booleanValue()) {
                k.this.c();
            }
        }

        protected boolean a(List<FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo> paramList) {
            k.h().c(new Object[]{"update price information begin"});
            Object localObject1 = new ArrayList();
            Object localObject2 = paramList.iterator();
            Object localObject3;
            while (((Iterator) localObject2).hasNext()) {
                localObject3 = (FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) ((Iterator) localObject2).next();
                if (!TextUtils.isEmpty(((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject3).productId)) {
                    ((List) localObject1).add(((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject3).productId);
                }
            }
            k.h().c(new Object[]{"fetch sku details from In-app billing service."});
            localObject1 = com.everimaging.fotorsdk.store.iap.a.a().a((List) localObject1);
            k.h().c(new Object[]{"skudetails:" + localObject1});
            if ((localObject1 != null) && (((List) localObject1).size() > 0)) {
                paramList = paramList.iterator();
                boolean bool1 = false;
                for (; ; ) {
                    bool2 = bool1;
                    if (!paramList.hasNext()) {
                        break;
                    }
                    localObject2 = (FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) paramList.next();
                    localObject3 = ((List) localObject1).iterator();
                    while (((Iterator) localObject3).hasNext()) {
                        g localg = (g) ((Iterator) localObject3).next();
                        if ((!TextUtils.isEmpty(((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject2).productId)) && (((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject2).productId.equals(localg.a()))) {
                            k.h().c(new Object[]{"fetch sku real price success:" + ((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject2).productId});
                            ((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject2).realPrice = localg.b();
                            bool1 = true;
                        }
                    }
                }
            }
            boolean bool2 = false;
            k.h().c(new Object[]{"completion update price information"});
            return bool2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */