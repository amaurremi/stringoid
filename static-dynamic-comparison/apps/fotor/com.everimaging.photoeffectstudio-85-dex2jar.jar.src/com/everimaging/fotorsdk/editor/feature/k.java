package com.everimaging.fotorsdk.editor.feature;

import com.everimaging.fotorsdk.plugins.FeaturePurchasedPack;
import com.everimaging.fotorsdk.store.c.a;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.g;

public abstract class k
        extends a
        implements c.a {
    protected boolean E;
    protected g F;

    public k(com.everimaging.fotorsdk.editor.c paramc) {
        super(paramc);
        this.E = paramc.l();
        this.F = new g(paramc, c());
    }

    public void K() {
        this.F.c();
    }

    protected void a(FeaturePurchasedPack paramFeaturePurchasedPack) {
        PurchasedPack localPurchasedPack = new PurchasedPack();
        localPurchasedPack.setHighDefault(paramFeaturePurchasedPack.getIconUrlDefault());
        localPurchasedPack.setHighPressed(paramFeaturePurchasedPack.getIconUrlPressed());
        localPurchasedPack.setPackName(paramFeaturePurchasedPack.getPackName());
        localPurchasedPack.setResourceId(paramFeaturePurchasedPack.getId());
        localPurchasedPack.setResourceUrl(paramFeaturePurchasedPack.getZipUrl());
        localPurchasedPack.setType(c());
        com.everimaging.fotorsdk.store.c.a().a(localPurchasedPack);
    }

    public void a(PurchasedPack paramPurchasedPack) {
        if (c().equals(paramPurchasedPack.getType())) {
            d(paramPurchasedPack);
        }
    }

    public final void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (c().equals(paramPurchasedPack.getType())) {
            b(paramPurchasedPack, paramFloat);
        }
    }

    public final void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (c().equals(paramPurchasedPack.getType())) {
            b(paramPurchasedPack, paramInt);
        }
    }

    public final void a(PurchasedPack paramPurchasedPack, String paramString) {
        if (c().equals(paramPurchasedPack.getType())) {
            b(paramPurchasedPack, paramString);
        }
    }

    public void b(PurchasedPack paramPurchasedPack) {
        if (c().equals(paramPurchasedPack.getType())) {
            c(paramPurchasedPack);
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, float paramFloat) {
    }

    protected void b(PurchasedPack paramPurchasedPack, int paramInt) {
    }

    protected void b(PurchasedPack paramPurchasedPack, String paramString) {
    }

    protected abstract String c();

    protected void c(PurchasedPack paramPurchasedPack) {
    }

    protected void d(PurchasedPack paramPurchasedPack) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */