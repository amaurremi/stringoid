package com.everimaging.fotorsdk.store;

import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.BundleDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.widget.PurchaseButton;
import com.everimaging.fotorsdk.uil.core.c;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.widget.FotorTextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
        extends FotorStoreAbstractDetailPage
        implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String a = a.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private ImageView c;
    private FotorTextView d;
    private FotorTextView e;
    private PurchaseButton f;
    private GridView g;
    private View h;
    private View i;
    private View j;
    private c k = new c.a().a(R.color.fotor_transparent).b(R.color.fotor_transparent).c(R.color.fotor_transparent).a(true).b(true).a(Bitmap.Config.RGB_565).a();
    private com.everimaging.fotorsdk.store.adapter.a l;

    public a(FotorStoreAbstractDetailPage.a parama, DetailPageInfo paramDetailPageInfo, j paramj, FotorStoreAbstractDetailPage.SourceType paramSourceType) {
        super(parama, paramDetailPageInfo, paramj, paramSourceType, false);
    }

    private void a(GridView paramGridView, FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject, com.everimaging.fotorsdk.store.adapter.a parama) {
        try {
            int m = paramGridView.getFirstVisiblePosition();
            int n = parama.a(paramResPackageJsonObject);
            paramResPackageJsonObject = paramGridView.getChildAt(n - m);
            paramGridView.getAdapter().getView(n, paramResPackageJsonObject, paramGridView);
            return;
        } catch (Exception paramGridView) {
            b.e(new Object[]{"update progress error:" + paramGridView.getMessage()});
        }
    }

    private void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.l == null) {
            return;
        }
        paramPurchasedPack = paramPurchasedPack.getPackID();
        FotorStoreJsonObjects.ResPackageJsonObject localResPackageJsonObject = this.l.a(paramPurchasedPack);
        if (localResPackageJsonObject != null) {
            StatusAssistant.StatusInfo localStatusInfo = localResPackageJsonObject.statusInfo;
            if ((paramInt >= 0) && (localStatusInfo != null)) {
                localStatusInfo.a(paramInt);
                if (this.l.c(paramPurchasedPack) == null) {
                    break label99;
                }
                this.l.notifyDataSetChanged();
            }
        }
        for (; ; ) {
            a(this.f);
            return;
            localResPackageJsonObject.statusInfo = StatusAssistant.a(localResPackageJsonObject, this.y.a(localResPackageJsonObject.type), this);
            break;
            label99:
            b.c(new Object[]{"current item is resued"});
            continue;
            b.c(new Object[]{"current item is invalid"});
        }
    }

    private void a(FotorStoreJsonObjects.BundleDetailsJsonObject paramBundleDetailsJsonObject) {
        Object localObject = paramBundleDetailsJsonObject.resources;
        if ((localObject != null) && (((List) localObject).size() > 0)) {
            paramBundleDetailsJsonObject = this.y.a(this.x.type);
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                FotorStoreJsonObjects.ResPackageJsonObject localResPackageJsonObject = (FotorStoreJsonObjects.ResPackageJsonObject) ((Iterator) localObject).next();
                localResPackageJsonObject.statusInfo = StatusAssistant.a(localResPackageJsonObject, paramBundleDetailsJsonObject, this);
            }
        }
    }

    private void i() {
        this.d.setText(this.x.name);
        this.e.setText(this.x.description);
        a(this.f);
    }

    private void j() {
        a(this.f);
        if (this.w != null) {
            a((FotorStoreJsonObjects.BundleDetailsJsonObject) this.w);
            if (this.l != null) {
                this.l.notifyDataSetChanged();
            }
        }
    }

    public void a() {
        j();
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        b.c(new Object[]{"onDownloadProgress"});
        if (this.l == null) {
        }
        do {
            return;
            paramPurchasedPack = paramPurchasedPack.getPackID();
            paramPurchasedPack = this.l.a(paramPurchasedPack);
        } while ((paramPurchasedPack == null) || (paramPurchasedPack.statusInfo == null));
        paramPurchasedPack.statusInfo.a(paramFloat);
        a(this.g, paramPurchasedPack, this.l);
    }

    protected void a(PurchaseButton paramPurchaseButton) {
        if ((paramPurchaseButton == null) || (this.x == null)) {
        }
        do {
            return;
            Object localObject = this.y.a(this.x.type);
            if (this.w != null) {
                localObject = StatusAssistant.a((FotorStoreJsonObjects.BundleDetailsJsonObject) this.w, (ArrayList) localObject, this);
                this.x.statusInfo = ((StatusAssistant.StatusInfo) localObject);
            }
        } while (this.x.statusInfo == null);
        b(paramPurchaseButton);
    }

    public boolean a(PurchasedPack paramPurchasedPack) {
        if (this.w == null) {
            return super.a(paramPurchasedPack);
        }
        paramPurchasedPack = paramPurchasedPack.getPackID();
        Object localObject = ((FotorStoreJsonObjects.BundleDetailsJsonObject) this.w).resources;
        if ((localObject != null) && (((List) localObject).size() > 0)) {
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                if (paramPurchasedPack.equals(((FotorStoreJsonObjects.ResPackageJsonObject) ((Iterator) localObject).next()).getPackID())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void b() {
        this.u = LayoutInflater.from(this.v).inflate(R.layout.fotor_store_bundle_detail_page, null);
        this.c = ((ImageView) this.u.findViewById(R.id.fotor_store_bundle_detail_thumb_imageview));
        this.d = ((FotorTextView) this.u.findViewById(R.id.fotor_store_bundle_detail_pkg_name));
        this.e = ((FotorTextView) this.u.findViewById(R.id.fotor_store_bundle_detail_pkg_description));
        this.f = ((PurchaseButton) this.u.findViewById(R.id.fotor_store_bundle_detail_buy));
        this.f.setOnClickListener(this);
        this.g = ((GridView) this.u.findViewById(R.id.fotor_store_bundle_detail_grid_view));
        this.g.setOnItemClickListener(this);
        this.h = this.u.findViewById(R.id.fotor_store_bundle_detail_exception);
        this.i = this.h.findViewById(R.id.fotor_store_details_retry_button);
        this.i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                a.this.a(true);
            }
        });
        this.j = this.u.findViewById(R.id.fotor_store_bundle_detail_loading);
        i();
    }

    public void b(PurchasedPack paramPurchasedPack) {
        a(paramPurchasedPack, 6);
    }

    protected void b(PurchaseButton paramPurchaseButton) {
        StatusAssistant.a(this.v, this.x.statusInfo, paramPurchaseButton, true);
    }

    protected void c() {
        super.c();
        this.j.setVisibility(0);
        this.h.setVisibility(8);
    }

    public void c(PurchasedPack paramPurchasedPack) {
        b.c(new Object[]{"onDownloadFailed"});
        a(paramPurchasedPack, 2);
    }

    protected void d() {
        super.d();
        this.j.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void d(PurchasedPack paramPurchasedPack) {
        b.c(new Object[]{"onDownloadFinished"});
        a(paramPurchasedPack, 3);
    }

    protected void e() {
        b.c(new Object[]{"onDataLoadCompleted"});
        this.j.setVisibility(8);
        this.h.setVisibility(8);
        FotorStoreJsonObjects.BundleDetailsJsonObject localBundleDetailsJsonObject = (FotorStoreJsonObjects.BundleDetailsJsonObject) this.w;
        List localList = localBundleDetailsJsonObject.resources;
        if ((localList != null) && (localList.size() > 0)) {
            a(localBundleDetailsJsonObject);
            this.l = new com.everimaging.fotorsdk.store.adapter.a(this.v, this.x.type, this);
            this.l.a(localList);
            this.g.setAdapter(this.l);
        }
        com.everimaging.fotorsdk.uil.core.d.a().a(com.everimaging.fotorsdk.store.utils.d.b(localBundleDetailsJsonObject.detailThumb), this.c, this.k);
        if (!TextUtils.isEmpty(localBundleDetailsJsonObject.name)) {
            this.x.name = localBundleDetailsJsonObject.name;
        }
        if (!TextUtils.isEmpty(localBundleDetailsJsonObject.description)) {
            this.x.description = localBundleDetailsJsonObject.description;
        }
        i();
    }

    public void f() {
        super.f();
        j();
    }

    protected void g() {
        j();
    }

    public void onClick(View paramView) {
        if ((paramView == this.f) && (this.w != null)) {
            paramView = (FotorStoreJsonObjects.BundleDetailsJsonObject) this.w;
            b.c(new Object[]{"you click pack:" + paramView.name});
            this.y.a(new ProductInfo(paramView.type, paramView.id, null, paramView.name, paramView.price, paramView.resources), paramView.type, false);
        }
        while (paramView.getTag() == null) {
            return;
        }
        paramView = (FotorStoreJsonObjects.ResPackageJsonObject) paramView.getTag();
        b.c(new Object[]{"you click pack:" + paramView.name});
        this.y.a(new ProductInfo(paramView.type, paramView.id, paramView.pkgName, paramView.name, paramView.price, null), paramView.type, false);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = (FotorStoreJsonObjects.ResPackageJsonObject) paramAdapterView.getAdapter().getItem(paramInt);
        paramView = new DetailPageInfo();
        paramView.name = paramAdapterView.name;
        paramView.count = paramAdapterView.count;
        paramView.id = paramAdapterView.id;
        paramView.description = paramAdapterView.description;
        paramView.detailThumb = paramAdapterView.thumb;
        paramView.price = paramAdapterView.price;
        paramView.pkgName = paramAdapterView.pkgName;
        paramView.type = paramAdapterView.type;
        paramView.statusInfo = paramAdapterView.statusInfo;
        this.y.a(paramView, true, FotorStoreAbstractDetailPage.SourceType.STORE, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */