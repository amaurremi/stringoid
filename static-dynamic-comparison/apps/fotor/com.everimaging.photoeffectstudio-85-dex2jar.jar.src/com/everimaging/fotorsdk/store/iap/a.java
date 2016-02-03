package com.everimaging.fotorsdk.store.iap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.billing.b;
import com.everimaging.fotorsdk.store.billing.b.a;
import com.everimaging.fotorsdk.store.billing.b.b;
import com.everimaging.fotorsdk.store.billing.b.c;
import com.everimaging.fotorsdk.store.billing.d;
import com.everimaging.fotorsdk.store.billing.e;
import com.everimaging.fotorsdk.store.billing.g;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.entity.ResourceInfo;
import com.everimaging.fotorsdk.store.h;
import com.everimaging.fotorsdk.store.utils.c.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static a c;
    private static boolean d = false;
    private static boolean e = false;
    private b f;
    private d g;
    private List<String> h = new ArrayList();
    private com.everimaging.fotorsdk.store.billing.c i;

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private void a(final c paramc, final d paramd, final com.everimaging.fotorsdk.store.billing.c paramc1) {
        FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo[] arrayOfPurchaseResourceInfo = com.everimaging.fotorsdk.store.utils.c.e();
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < arrayOfPurchaseResourceInfo.length) {
            FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo localPurchaseResourceInfo = arrayOfPurchaseResourceInfo[j];
            if ((com.everimaging.fotorsdk.store.utils.c.e(localPurchaseResourceInfo.type)) && (paramd.a(localPurchaseResourceInfo.productId))) {
                localArrayList.add(new ProductInfo(localPurchaseResourceInfo.type, localPurchaseResourceInfo.id, null, null, 0.0F, null));
            }
            j += 1;
        }
        b.c(new Object[]{"need restore sub packs :" + localArrayList});
        if (localArrayList.size() > 0) {
            com.everimaging.fotorsdk.store.utils.c.a(new c.c() {
                public void a(FotorStoreJsonObjects.ResposeListJsonObject<ResourceInfo> paramAnonymousResposeListJsonObject) {
                    paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                    if ((paramAnonymousResposeListJsonObject != null) && (paramAnonymousResposeListJsonObject.size() > 0)) {
                        paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.iterator();
                        while (paramAnonymousResposeListJsonObject.hasNext()) {
                            FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo localPurchaseResourceInfo = com.everimaging.fotorsdk.store.utils.c.a(((ResourceInfo) paramAnonymousResposeListJsonObject.next()).getId());
                            if ((localPurchaseResourceInfo != null) && (!TextUtils.isEmpty(localPurchaseResourceInfo.productId))) {
                                a.this.b(localPurchaseResourceInfo.productId);
                            }
                        }
                    }
                    if (paramc != null) {
                        paramc.a(paramd, paramc1);
                    }
                }

                public void a(FotorStoreJsonObjects.ResposeListJsonObject<ResourceInfo> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                    if (paramc != null) {
                        paramc.a(paramd, paramc1);
                    }
                }
            }, (ProductInfo[]) localArrayList.toArray(new ProductInfo[localArrayList.size()]));
        }
        while (paramc == null) {
            return;
        }
        paramc.a(paramd, paramc1);
    }

    public static boolean b() {
        return e;
    }

    public List<g> a(List<String> paramList)
            throws IllegalStateException {
        b.c(new Object[]{"query skus details:" + paramList});
        try {
            if (paramList.size() > 20) {
                throw new IllegalStateException("sku details size must <= 20 of per query ");
            }
        } catch (RemoteException paramList) {
            paramList.printStackTrace();
            do {
                return null;
            } while (this.f == null);
            paramList = this.f.a(paramList);
            return paramList;
        } catch (Exception paramList) {
            for (; ; ) {
                paramList.printStackTrace();
            }
        }
    }

    public void a(Activity paramActivity, String paramString, int paramInt, final b paramb) {
        if (this.f == null) {
            b.e(new Object[]{"iabHelper is null,u not initial?"});
            return;
        }
        try {
            this.f.a(paramActivity, paramString, paramInt, new b.a() {
                public void a(com.everimaging.fotorsdk.store.billing.c paramAnonymousc, e paramAnonymouse) {
                    if (paramAnonymousc.b()) {
                        if (a.a(a.this) == null) {
                            a.a(a.this, new d());
                        }
                        a.a(a.this).a(paramAnonymouse);
                    }
                    if (paramb != null) {
                        paramb.a(paramAnonymousc, paramAnonymouse);
                    }
                }
            });
            return;
        } catch (Exception paramActivity) {
            b.e(new Object[]{"exception:" + paramActivity.getMessage()});
        }
    }

    public void a(Context paramContext) {
        a(paramContext, h.a(), null, null);
    }

    public void a(Context paramContext, String paramString, final a parama, final c paramc) {
        b.c(new Object[]{"initial iap manager"});
        if (!d) {
            this.f = new b(paramContext, paramString);
            this.f.a(FotorLoggerFactory.a, a);
            this.f.a(new b.b() {
                public void a(com.everimaging.fotorsdk.store.billing.c paramAnonymousc) {
                    a.d().c(new Object[]{"setup result:" + paramAnonymousc});
                    a.a(a.this, paramAnonymousc);
                    a.a(paramAnonymousc.b());
                    if (a.e()) {
                        a.this.a(paramc);
                    }
                    if (parama != null) {
                        parama.a(paramAnonymousc);
                    }
                }
            });
            d = true;
        }
        while (parama == null) {
            return;
        }
        parama.a(this.i);
    }

    public void a(final c paramc) {
        if (this.f == null) {
            b.e(new Object[]{"iabHelper is null,u not initial?"});
            return;
        }
        try {
            this.f.a(new b.c() {
                public void a(com.everimaging.fotorsdk.store.billing.c paramAnonymousc, d paramAnonymousd) {
                    a.d().c(new Object[]{"query inventory result:" + paramAnonymousc + ",inventory:" + paramAnonymousd});
                    if (paramAnonymousc.b()) {
                        a.a(a.this, paramAnonymousd);
                        a.a(a.this, paramc, paramAnonymousd, paramAnonymousc);
                    }
                    while (paramc == null) {
                        return;
                    }
                    paramc.a(paramAnonymousd, paramAnonymousc);
                }
            });
            return;
        } catch (Exception paramc) {
            b.e(new Object[]{"excpetion:" + paramc.getMessage()});
        }
    }

    public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
        if (this.f == null) {
            b.e(new Object[]{"iabHelper is null,u not initial?"});
            return false;
        }
        return this.f.a(paramInt1, paramInt2, paramIntent);
    }

    public boolean a(String paramString) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.g != null) {
            bool1 = bool2;
            if (this.g.a(paramString)) {
                bool1 = true;
            }
        }
        bool2 = bool1;
        if (!bool1) {
            bool2 = this.h.contains(paramString);
        }
        return bool2;
    }

    public void b(String paramString) {
        if (!this.h.contains(paramString)) {
            this.h.add(paramString);
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.a();
        }
        this.f = null;
        this.g = null;
        d = false;
    }

    public static abstract interface a {
        public abstract void a(com.everimaging.fotorsdk.store.billing.c paramc);
    }

    public static abstract interface b {
        public abstract void a(com.everimaging.fotorsdk.store.billing.c paramc, e parame);
    }

    public static abstract interface c {
        public abstract void a(d paramd, com.everimaging.fotorsdk.store.billing.c paramc);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/iap/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */