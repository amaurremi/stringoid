package com.everimaging.fotorsdk.store;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.ProductInfo;

import java.util.ArrayList;

public abstract interface j {
    public abstract ArrayList<String> a(String paramString);

    public abstract void a(DetailPageInfo paramDetailPageInfo, boolean paramBoolean1, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean2);

    public abstract void a(ProductInfo paramProductInfo, String paramString, boolean paramBoolean);

    public abstract boolean b(String paramString);

    public abstract String d();

    public abstract String e();

    public abstract FragmentActivity f();

    public abstract RenderScript g();

    public abstract d h();

    public abstract Uri i();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */