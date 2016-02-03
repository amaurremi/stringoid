package com.everimaging.fotorsdk.store.utils;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.q;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.AdvsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.BundleDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.CommonDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.DetailsBaseJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.NewPkgNumJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.RecommendPkgJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeBaseJsonObject.PageInfoJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeDataJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.entity.ResourceInfo;
import com.everimaging.fotorsdk.store.iap.a;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;

public class c {
    public static final String a = Integer.toString(2);
    public static final String b = Integer.toString(3);
    public static final String c = Integer.toString(4);
    public static final String d = Integer.toString(6);
    public static final String e = Integer.toString(7);
    public static final String f = Integer.toString(8);
    public static final String g = Integer.toString(9);
    public static final String h = e + "," + f + "," + g;
    private static final String i = c.class.getSimpleName();
    private static final FotorLoggerFactory.c j = FotorLoggerFactory.a(i, FotorLoggerFactory.LoggerType.CONSOLE);
    private static FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.AdvsJsonObject> k;
    private static FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> l;
    private static SparseArray<FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo> m = new SparseArray();
    private static HashMap<String, FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.ResPackageJsonObject>> n = new HashMap();
    private static HashMap<String, FotorStoreJsonObjects.ResposeDataJsonObject<? extends FotorStoreJsonObjects.DetailsBaseJsonObject>> o = new HashMap();
    private static HashMap<String, FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject>> p = new HashMap();
    private static HashMap<String, FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.RecommendPkgJsonObject>> q = new HashMap();
    private static boolean r = false;

    public static FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo a(int paramInt) {
        return (FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) m.get(paramInt);
    }

    private static FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> a(Context paramContext, String paramString) {
        paramContext = b.a(paramContext, "Store", "Modules_New_Pkg_Num_" + paramString);
        if (paramContext != null) {
            try {
                paramString = new String(paramContext);
                paramContext = new FotorStoreJsonObjects.ResposeDataJsonObject();
                paramString.printStackTrace();
            } catch (Exception paramString) {
                try {
                    paramContext.parseFromJsonStr(paramString, FotorStoreJsonObjects.NewPkgNumJsonObject.class);
                    return paramContext;
                } catch (Exception paramString) {
                    for (; ; ) {
                    }
                }
                paramString = paramString;
                paramContext = null;
            }
            return paramContext;
        } else {
            paramContext = new FotorStoreJsonObjects.ResposeDataJsonObject();
            paramContext.data = new FotorStoreJsonObjects.NewPkgNumJsonObject();
            ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramContext.data).datetime = 0;
            ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramContext.data).num = 0;
            ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramContext.data).type = paramString;
            return paramContext;
        }
    }

    public static void a(Context paramContext, FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> paramResposeDataJsonObject) {
        if ((paramResposeDataJsonObject != null) && (paramResposeDataJsonObject.data != null)) {
            String str = ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramResposeDataJsonObject.data).type;
            p.put(str, paramResposeDataJsonObject);
            e(paramContext, paramResposeDataJsonObject);
        }
    }

    public static void a(final a parama, Context paramContext, String paramString1, final String paramString2, boolean paramBoolean) {
        j.c(new Object[]{"fetchDetailsResposeData type:" + paramString1 + ",id:" + paramString2 + ",refresh:" + paramBoolean});
        if (parama == null) {
            return;
        }
        final String str = "fetchResourceDetailByType_" + paramString1 + "_" + paramString2;
        if (((paramBoolean) || (k(paramString2))) && (!d.c(str))) {
            paramContext = PackageManagerUtils.getApikey(paramContext);
            l locall = new l();
            locall.a("appkey", paramContext);
            locall.a("versionCode", "1.0.6");
            locall.a("type", paramString1);
            locall.a("id", paramString2);
            locall.a("platform", "1");
            d.a(str, true);
            d.a("fetchResourceDetailByType", locall, new q() {
                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                    paramAnonymousArrayOfHeader = null;
                    c.f().c(new Object[]{"Details Respose :" + paramAnonymousString});
                    FotorStoreJsonObjects.ResposeDataJsonObject localResposeDataJsonObject;
                    if (this.a.equals("1")) {
                        localResposeDataJsonObject = new FotorStoreJsonObjects.ResposeDataJsonObject();
                        paramAnonymousArrayOfHeader = FotorStoreJsonObjects.BundleDetailsJsonObject.class;
                    }
                    for (; ; ) {
                        if (localResposeDataJsonObject != null) {
                        }
                        try {
                            localResposeDataJsonObject.parseFromJsonStr(paramAnonymousString, paramAnonymousArrayOfHeader);
                            if ((localResposeDataJsonObject.status == true) && (localResposeDataJsonObject.data != null)) {
                                ((FotorStoreJsonObjects.DetailsBaseJsonObject) localResposeDataJsonObject.data).type = this.a;
                                c.h().put(paramString2, localResposeDataJsonObject);
                            }
                            parama.a((FotorStoreJsonObjects.ResposeDataJsonObject) c.h().get(paramString2));
                            d.a(str, false);
                            return;
                            if ((this.a.equals(c.a)) || (this.a.equals(c.c))) {
                                localResposeDataJsonObject = new FotorStoreJsonObjects.ResposeDataJsonObject();
                                paramAnonymousArrayOfHeader = FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject.class;
                            } else if ((this.a.equals(c.b)) || (this.a.equals(c.d))) {
                                localResposeDataJsonObject = new FotorStoreJsonObjects.ResposeDataJsonObject();
                                paramAnonymousArrayOfHeader = FotorStoreJsonObjects.CommonDetailsJsonObject.class;
                            } else if ((this.a.equals(c.e)) || (this.a.equals(c.f)) || (this.a.equals(c.g))) {
                                localResposeDataJsonObject = new FotorStoreJsonObjects.ResposeDataJsonObject();
                                paramAnonymousArrayOfHeader = FotorStoreJsonObjects.CommonDetailsJsonObject.class;
                            }
                        } catch (Exception paramAnonymousArrayOfHeader) {
                            for (; ; ) {
                            }
                            localResposeDataJsonObject = null;
                        }
                    }
                }

                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                    c.f().e(new Object[]{"Details Respose : " + paramAnonymousString});
                    c.f().e(new Object[]{"Details Error msg: " + paramAnonymousThrowable.getMessage()});
                    parama.a((FotorStoreJsonObjects.ResposeDataJsonObject) c.h().get(paramString2), paramAnonymousString);
                    d.a(str, false);
                }
            });
            return;
        }
        new Handler(paramContext.getMainLooper()).post(new Runnable() {
            public void run() {
                this.a.a((FotorStoreJsonObjects.ResposeDataJsonObject) c.h().get(paramString2));
            }
        });
    }

    public static void a(final b<FotorStoreJsonObjects.NewPkgNumJsonObject> paramb, final Context paramContext, final String paramString, boolean paramBoolean) {
        if (paramb == null) {
            return;
        }
        final String str1 = "resourcePkgNumByType_" + paramString;
        FotorStoreJsonObjects.ResposeDataJsonObject localResposeDataJsonObject = a(paramContext, paramString);
        if ((localResposeDataJsonObject != null) && (localResposeDataJsonObject.data != null)) {
        }
        for (int i1 = ((FotorStoreJsonObjects.NewPkgNumJsonObject) localResposeDataJsonObject.data).datetime; ; i1 = 0) {
            if (((paramBoolean) || (l(paramString))) && (!d.c(str1))) {
                String str2 = PackageManagerUtils.getApikey(paramContext);
                l locall = new l();
                locall.a("appkey", str2);
                locall.a("type", paramString);
                locall.a("timestamp", i1);
                locall.a("versionCode", "1.0.6");
                locall.a("platform", "1");
                if (!a.b()) {
                }
                for (paramBoolean = true; ; paramBoolean = false) {
                    locall.a("free", String.valueOf(paramBoolean));
                    d.a(str1, true);
                    d.a("resourcePkgNumByType", locall, new q() {
                        public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                            c.f().c(new Object[]{"New Pkg Num Respose :" + paramAnonymousString});
                            paramAnonymousArrayOfHeader = new FotorStoreJsonObjects.ResposeDataJsonObject();
                            try {
                                paramAnonymousArrayOfHeader.parseFromJsonStr(paramAnonymousString, FotorStoreJsonObjects.NewPkgNumJsonObject.class);
                                if ((paramAnonymousArrayOfHeader.status == true) && (paramAnonymousArrayOfHeader.data != null)) {
                                    if ((((FotorStoreJsonObjects.NewPkgNumJsonObject) paramAnonymousArrayOfHeader.data).datetime > ((FotorStoreJsonObjects.NewPkgNumJsonObject) this.a.data).datetime) && (((FotorStoreJsonObjects.NewPkgNumJsonObject) paramAnonymousArrayOfHeader.data).num > 0)) {
                                        ((FotorStoreJsonObjects.NewPkgNumJsonObject) this.a.data).num = ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramAnonymousArrayOfHeader.data).num;
                                        c.b(paramContext, this.a);
                                    }
                                    c.k().put(paramString, paramAnonymousArrayOfHeader);
                                }
                                for (; ; ) {
                                    paramAnonymousArrayOfHeader = this.a;
                                    if (c.k().containsKey(paramString)) {
                                        paramAnonymousArrayOfHeader = (FotorStoreJsonObjects.ResposeDataJsonObject) c.k().get(paramString);
                                    }
                                    paramb.a(paramAnonymousArrayOfHeader);
                                    d.a(str1, false);
                                    return;
                                    if (this.a != null) {
                                        c.k().put(paramString, this.a);
                                    }
                                }
                            } catch (Exception paramAnonymousString) {
                                for (; ; ) {
                                }
                            }
                        }

                        public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                            c.f().e(new Object[]{"New Pkg Num Respose : " + paramAnonymousString});
                            c.f().e(new Object[]{"New Pkg Num Error msg: " + paramAnonymousThrowable.getMessage()});
                            paramAnonymousArrayOfHeader = null;
                            if (this.a != null) {
                                c.k().put(paramString, this.a);
                            }
                            if (c.k().containsKey(paramString)) {
                                paramAnonymousArrayOfHeader = (FotorStoreJsonObjects.ResposeDataJsonObject) c.k().get(paramString);
                            }
                            paramb.a(paramAnonymousArrayOfHeader, paramAnonymousString);
                            d.a(str1, false);
                        }
                    });
                    return;
                }
            }
            if (p.containsKey(paramString)) {
            }
            for (paramContext = (FotorStoreJsonObjects.ResposeDataJsonObject) p.get(paramString); ; paramContext = localResposeDataJsonObject) {
                paramb.a(paramContext);
                return;
            }
        }
    }

    public static void a(final b<FotorStoreJsonObjects.ModulesJsonObject> paramb, Context paramContext, boolean paramBoolean) {
        j.c(new Object[]{"####### init store modules datas ########"});
        if (((n()) || (paramBoolean)) && (!d.c("fetchModulesByAppkey"))) {
            String str = PackageManagerUtils.getApikey(paramContext);
            l locall = new l();
            locall.a("appkey", str);
            locall.a("versionCode", "1.0.6");
            d.a("fetchModulesByAppkey", true);
            d.a("fetchModulesByAppkey", locall, new q() {
                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                    c.f().c(new Object[]{"Modules Respose :" + paramAnonymousString});
                    paramAnonymousArrayOfHeader = new FotorStoreJsonObjects.ResposeDataJsonObject();
                    try {
                        paramAnonymousArrayOfHeader.parseFromJsonStr(paramAnonymousString, FotorStoreJsonObjects.ModulesJsonObject.class);
                        if ((paramAnonymousArrayOfHeader.status == true) && (paramAnonymousArrayOfHeader.data != null)) {
                            c.a(paramAnonymousArrayOfHeader);
                            c.c(this.a, c.l());
                            if ((paramAnonymousArrayOfHeader.status != true) || (paramAnonymousArrayOfHeader.data == null)) {
                                break label142;
                            }
                            c.a(true);
                        }
                        for (; ; ) {
                            d.a("fetchModulesByAppkey", false);
                            if (paramb != null) {
                                paramb.a(paramAnonymousArrayOfHeader);
                            }
                            return;
                            if (c.l() != null) {
                                break;
                            }
                            c.a(c.a(this.a));
                            break;
                            label142:
                            if ((c.l() != null) && (c.l().status == true) && (c.l() != null)) {
                                c.a(true);
                            }
                        }
                    } catch (Exception paramAnonymousString) {
                        for (; ; ) {
                        }
                    }
                }

                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                    c.f().e(new Object[]{"Modules Respose : " + paramAnonymousString});
                    c.f().e(new Object[]{"Modules Error msg: " + paramAnonymousThrowable.getMessage()});
                    if (c.l() == null) {
                        c.a(c.a(this.a));
                    }
                    if ((c.l() != null) && (c.l().status == true) && (c.l().data != null)) {
                        c.a(true);
                    }
                    d.a("fetchModulesByAppkey", false);
                    if (paramb != null) {
                        paramb.a(c.l(), paramAnonymousString);
                    }
                }
            });
        }
    }

    public static void a(final c<FotorStoreJsonObjects.ResPackageJsonObject> paramc, Context paramContext, String paramString, final int paramInt1, final int paramInt2, final boolean paramBoolean1, boolean paramBoolean2) {
        if (paramc == null) {
            return;
        }
        final Object localObject = "fetchResourcePkgByType_" + paramString + "_" + String.valueOf(paramInt1);
        if (((paramBoolean1) || (!a(paramString, paramInt1, paramInt2))) && (!d.c((String) localObject))) {
            paramContext = PackageManagerUtils.getApikey(paramContext);
            l locall = new l();
            locall.a("appkey", paramContext);
            locall.a("versionCode", "1.0.6");
            locall.a("type", paramString);
            locall.a("pageInfo.index", String.valueOf(paramInt1));
            locall.a("pageInfo.size", String.valueOf(paramInt2));
            locall.a("platform", "1");
            if (!paramBoolean2) {
            }
            for (paramBoolean2 = true; ; paramBoolean2 = false) {
                locall.a("free", String.valueOf(paramBoolean2));
                d.a((String) localObject, true);
                d.a("fetchResourcePkgByType", locall, new q() {
                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                        c.f().c(new Object[]{"ResPkgs Respose :" + paramAnonymousString});
                        Object localObject = new FotorStoreJsonObjects.ResposeListJsonObject();
                        try {
                            ((FotorStoreJsonObjects.ResposeListJsonObject) localObject).parseFromJsonStr(paramAnonymousString, FotorStoreJsonObjects.ResPackageJsonObject.class);
                            paramAnonymousArrayOfHeader = null;
                            if (c.j().containsKey(this.a)) {
                                paramAnonymousArrayOfHeader = (FotorStoreJsonObjects.ResposeListJsonObject) c.j().get(this.a);
                            }
                            if (((FotorStoreJsonObjects.ResposeListJsonObject) localObject).status == true) {
                                if ((paramAnonymousArrayOfHeader == null) || (paramAnonymousArrayOfHeader.data == null) || (paramAnonymousArrayOfHeader.pageinfo == null) || (paramBoolean1)) {
                                    paramAnonymousString = (String) localObject;
                                }
                                for (; ; ) {
                                    c.j().put(this.a, paramAnonymousString);
                                    paramAnonymousArrayOfHeader = paramAnonymousString;
                                    paramAnonymousString = new FotorStoreJsonObjects.ResposeListJsonObject();
                                    paramAnonymousString.status = true;
                                    int i = (paramInt1 - 1) * paramInt2;
                                    int j = paramInt2;
                                    localObject = new ArrayList();
                                    if ((paramAnonymousArrayOfHeader == null) || (paramAnonymousArrayOfHeader.data == null)) {
                                        break;
                                    }
                                    paramAnonymousInt = i;
                                    while ((paramAnonymousInt <= j + i - 1) && (paramAnonymousInt < paramAnonymousArrayOfHeader.data.size())) {
                                        ((List) localObject).add((FotorStoreJsonObjects.ResPackageJsonObject) paramAnonymousArrayOfHeader.data.get(paramAnonymousInt));
                                        paramAnonymousInt += 1;
                                    }
                                    paramAnonymousString = paramAnonymousArrayOfHeader;
                                    if (((FotorStoreJsonObjects.ResposeListJsonObject) localObject).data != null) {
                                        paramAnonymousArrayOfHeader.data.addAll(((FotorStoreJsonObjects.ResposeListJsonObject) localObject).data);
                                        paramAnonymousString = paramAnonymousArrayOfHeader;
                                    }
                                }
                                paramAnonymousString.data = ((List) localObject);
                                paramc.a(paramAnonymousString);
                                d.a(localObject, false);
                                return;
                            }
                        } catch (Exception paramAnonymousArrayOfHeader) {
                            for (; ; ) {
                            }
                        }
                    }

                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                        c.f().e(new Object[]{"ResPkgs Respose : " + paramAnonymousString});
                        c.f().e(new Object[]{"ResPkgs Error msg: " + paramAnonymousThrowable.getMessage()});
                        paramAnonymousArrayOfHeader = null;
                        if (c.j().containsKey(this.a)) {
                            paramAnonymousArrayOfHeader = (FotorStoreJsonObjects.ResposeListJsonObject) c.j().get(this.a);
                        }
                        paramc.a(paramAnonymousArrayOfHeader, paramAnonymousString);
                        d.a(localObject, false);
                    }
                });
                return;
            }
        }
        if (n.containsKey(paramString)) {
        }
        for (paramContext = (FotorStoreJsonObjects.ResposeListJsonObject) n.get(paramString); ; paramContext = null) {
            paramString = new FotorStoreJsonObjects.ResposeListJsonObject();
            if ((paramContext != null) && (paramContext.data != null) && (paramContext.pageinfo != null)) {
                paramString.status = true;
                paramString.pageinfo = new FotorStoreJsonObjects.ResposeBaseJsonObject.PageInfoJsonObject();
                paramString.pageinfo.index = String.valueOf(paramInt1);
                paramString.pageinfo.size = String.valueOf(paramInt2);
                paramString.pageinfo.num = paramContext.pageinfo.num;
                int i1 = (paramInt1 - 1) * paramInt2;
                localObject = new ArrayList();
                paramInt1 = i1;
                while ((paramInt1 <= i1 + paramInt2 - 1) && (paramInt1 < paramContext.data.size())) {
                    ((List) localObject).add((FotorStoreJsonObjects.ResPackageJsonObject) paramContext.data.get(paramInt1));
                    paramInt1 += 1;
                }
                paramString.data = ((List) localObject);
            }
            paramc.a(paramString);
            return;
        }
    }

    public static void a(final c<FotorStoreJsonObjects.RecommendPkgJsonObject> paramc, Context paramContext, String paramString, boolean paramBoolean) {
        if (paramc == null) {
            return;
        }
        final String str = "fetchRecommendResource_" + paramString;
        if (((paramBoolean) || (m(paramString))) && (!d.c(str))) {
            paramContext = PackageManagerUtils.getApikey(paramContext);
            l locall = new l();
            locall.a("appkey", paramContext);
            locall.a("type", paramString);
            locall.a("versionCode", "1.0.6");
            locall.a("platform", "1");
            if (!a.b()) {
            }
            for (paramBoolean = true; ; paramBoolean = false) {
                locall.a("free", String.valueOf(paramBoolean));
                d.a(str, true);
                d.a("fetchRecommendResource", locall, new q() {
                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                        c.f().c(new Object[]{"Recommend Pkgs Respose :" + paramAnonymousString});
                        paramAnonymousArrayOfHeader = new FotorStoreJsonObjects.ResposeListJsonObject();
                        try {
                            paramAnonymousArrayOfHeader.parseFromJsonStr(paramAnonymousString, FotorStoreJsonObjects.RecommendPkgJsonObject.class);
                            if ((paramAnonymousArrayOfHeader.status == true) && (paramAnonymousArrayOfHeader.data != null)) {
                                c.g().put(this.a, paramAnonymousArrayOfHeader);
                            }
                            paramc.a((FotorStoreJsonObjects.ResposeListJsonObject) c.g().get(this.a));
                            d.a(str, false);
                            return;
                        } catch (Exception paramAnonymousString) {
                            for (; ; ) {
                            }
                        }
                    }

                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                        c.f().e(new Object[]{"Recommend Pkgs Respose : " + paramAnonymousString});
                        c.f().e(new Object[]{"Recommend Pkgs Error msg: " + paramAnonymousThrowable.getMessage()});
                        paramc.a((FotorStoreJsonObjects.ResposeListJsonObject) c.g().get(this.a), paramAnonymousString);
                        d.a(str, false);
                    }
                });
                return;
            }
        }
        paramc.a((FotorStoreJsonObjects.ResposeListJsonObject) q.get(paramString));
    }

    public static void a(c<FotorStoreJsonObjects.AdvsJsonObject> paramc, Context paramContext, boolean paramBoolean) {
        if (paramc == null) {
            return;
        }
        if (((paramBoolean) || (m())) && (!d.c("advertisement"))) {
            paramContext = PackageManagerUtils.getApikey(paramContext);
            l locall = new l();
            locall.a("appkey", paramContext);
            locall.a("versionCode", "1.0.6");
            locall.a("platform", "1");
            if (!a.b()) {
            }
            for (paramBoolean = true; ; paramBoolean = false) {
                locall.a("free", String.valueOf(paramBoolean));
                d.a("advertisement", true);
                d.a("advertisement", locall, new q() {
                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                        c.f().c(new Object[]{"Advs Respose :" + paramAnonymousString});
                        paramAnonymousArrayOfHeader = new FotorStoreJsonObjects.ResposeListJsonObject();
                        try {
                            paramAnonymousArrayOfHeader.parseFromJsonStr(paramAnonymousString, FotorStoreJsonObjects.AdvsJsonObject.class);
                            if ((paramAnonymousArrayOfHeader.status == true) && (paramAnonymousArrayOfHeader.data != null)) {
                                c.a(paramAnonymousArrayOfHeader);
                            }
                            this.a.a(c.i());
                            d.a("advertisement", false);
                            return;
                        } catch (Exception paramAnonymousString) {
                            for (; ; ) {
                            }
                        }
                    }

                    public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                        c.f().e(new Object[]{"Advs Respose : " + paramAnonymousString});
                        c.f().e(new Object[]{"Advs Error msg: " + paramAnonymousThrowable.getMessage()});
                        this.a.a(c.i(), paramAnonymousString);
                        d.a("advertisement", false);
                    }
                });
                return;
            }
        }
        paramc.a(k);
    }

    public static void a(c<ResourceInfo> paramc, ProductInfo... paramVarArgs) {
        l locall = new l();
        JsonArray localJsonArray = new JsonArray();
        int i2 = paramVarArgs.length;
        int i1 = 0;
        while (i1 < i2) {
            ProductInfo localProductInfo = paramVarArgs[i1];
            JsonObject localJsonObject = new JsonObject();
            localJsonObject.addProperty("id", Integer.valueOf(localProductInfo.getResourceId()));
            localJsonObject.addProperty("type", localProductInfo.getType());
            localJsonArray.add(localJsonObject);
            i1 += 1;
        }
        locall.b("data", localJsonArray.toString());
        locall.a("platform", "1");
        locall.a("versionCode", "1.0.6");
        d.a("getResourceInfoList_" + paramVarArgs.hashCode(), true);
        d.a("getResourceInfoList", locall, new q() {
            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                c.f().c(new Object[]{"fetch resource info success :" + paramAnonymousString});
                paramAnonymousArrayOfHeader = new FotorStoreJsonObjects.ResposeListJsonObject();
                try {
                    paramAnonymousArrayOfHeader.parseFromJsonStr(paramAnonymousString, ResourceInfo.class);
                    if ((paramAnonymousArrayOfHeader.status) && (paramAnonymousArrayOfHeader.data != null)) {
                        this.a.a(paramAnonymousArrayOfHeader);
                        return;
                    }
                    this.a.a(paramAnonymousArrayOfHeader, null);
                    return;
                } catch (Exception paramAnonymousString) {
                    for (; ; ) {
                    }
                }
            }

            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                c.f().c(new Object[]{"fetch resource info error"});
                this.a.a(null, paramAnonymousString);
            }
        });
    }

    public static void a(boolean paramBoolean) {
        try {
            r = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static boolean a() {
        try {
            boolean bool = r;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static boolean a(String paramString) {
        return c.equals(paramString);
    }

    private static boolean a(String paramString, int paramInt1, int paramInt2) {
        if (j(paramString)) {
            return false;
        }
        FotorStoreJsonObjects.ResposeListJsonObject localResposeListJsonObject = null;
        if (n.containsKey(paramString)) {
            localResposeListJsonObject = (FotorStoreJsonObjects.ResposeListJsonObject) n.get(paramString);
        }
        if (localResposeListJsonObject.data == null) {
            return true;
        }
        int i2 = localResposeListJsonObject.data.size();
        int i1 = localResposeListJsonObject.pageinfo.num;
        paramInt1 = paramInt2 * paramInt1;
        if (paramInt1 > i1) {
            paramInt1 = i1;
        }
        for (; ; ) {
            if (paramInt1 <= i2) {
            }
            for (boolean bool = true; ; bool = false) {
                return bool;
            }
        }
    }

    private static FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> b(Context paramContext) {
        j.c(new Object[]{"get store modules info from storage "});
        paramContext = b.a(paramContext, "Store", "Modules_Info");
        if (paramContext != null) {
        }
        for (; ; ) {
            try {
                String str = new String(paramContext);
                paramContext = new FotorStoreJsonObjects.ResposeDataJsonObject();
                localException1.printStackTrace();
            } catch (Exception localException1) {
                try {
                    paramContext.parseFromJsonStr(str, FotorStoreJsonObjects.ModulesJsonObject.class);
                    b(paramContext);
                    return paramContext;
                } catch (Exception localException2) {
                    for (; ; ) {
                    }
                }
                localException1 = localException1;
                paramContext = null;
            }
            continue;
            paramContext = null;
        }
    }

    public static void b() {
        n.clear();
        o.clear();
    }

    private static void b(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramResposeDataJsonObject) {
        j.c(new Object[]{"copy resources cache to mResourceInfos,clear pre caches"});
        synchronized (m) {
            m.clear();
            if ((paramResposeDataJsonObject != null) && (paramResposeDataJsonObject.data != null) && (((FotorStoreJsonObjects.ModulesJsonObject) paramResposeDataJsonObject.data).resources != null) && (((FotorStoreJsonObjects.ModulesJsonObject) paramResposeDataJsonObject.data).resources.size() > 0)) {
                paramResposeDataJsonObject = ((FotorStoreJsonObjects.ModulesJsonObject) paramResposeDataJsonObject.data).resources.iterator();
                if (paramResposeDataJsonObject.hasNext()) {
                    FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo localPurchaseResourceInfo = (FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) paramResposeDataJsonObject.next();
                    m.put(localPurchaseResourceInfo.id, localPurchaseResourceInfo);
                }
            }
        }
    }

    public static boolean b(String paramString) {
        return a.equals(paramString);
    }

    public static FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> c() {
        return l;
    }

    public static boolean c(String paramString) {
        return b.equals(paramString);
    }

    private static void d(Context paramContext, FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramResposeDataJsonObject) {
        b(paramResposeDataJsonObject);
        if (paramResposeDataJsonObject != null) {
            b.a(paramContext, "Store", "Modules_Info", paramResposeDataJsonObject.toJsonStr(FotorStoreJsonObjects.ModulesJsonObject.class).getBytes());
        }
    }

    public static boolean d() {
        return false;
    }

    public static boolean d(String paramString) {
        return d.equals(paramString);
    }

    private static void e(Context paramContext, FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> paramResposeDataJsonObject) {
        if (paramResposeDataJsonObject != null) {
            String str = ((FotorStoreJsonObjects.NewPkgNumJsonObject) paramResposeDataJsonObject.data).type;
            paramResposeDataJsonObject = paramResposeDataJsonObject.toJsonStr(FotorStoreJsonObjects.NewPkgNumJsonObject.class);
            b.a(paramContext, "Store", "Modules_New_Pkg_Num_" + str, paramResposeDataJsonObject.getBytes());
        }
    }

    public static boolean e(String paramString) {
        return "1".equals(paramString);
    }

    public static FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo[] e() {
        FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo[] arrayOfPurchaseResourceInfo = new FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo[m.size()];
        int i1 = 0;
        while (i1 < arrayOfPurchaseResourceInfo.length) {
            arrayOfPurchaseResourceInfo[i1] = ((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) m.valueAt(i1));
            i1 += 1;
        }
        return arrayOfPurchaseResourceInfo;
    }

    public static boolean f(String paramString) {
        return e.equals(paramString);
    }

    public static boolean g(String paramString) {
        return f.equals(paramString);
    }

    public static boolean h(String paramString) {
        return g.equals(paramString);
    }

    public static boolean i(String paramString) {
        return (h.equals(paramString)) || (paramString.contains(e)) || (paramString.contains(f)) || (paramString.contains(g));
    }

    private static boolean j(String paramString) {
        FotorStoreJsonObjects.ResposeListJsonObject localResposeListJsonObject = null;
        if (n.containsKey(paramString)) {
            localResposeListJsonObject = (FotorStoreJsonObjects.ResposeListJsonObject) n.get(paramString);
        }
        return localResposeListJsonObject == null;
    }

    private static boolean k(String paramString) {
        FotorStoreJsonObjects.ResposeDataJsonObject localResposeDataJsonObject = null;
        if (o.containsKey(paramString)) {
            localResposeDataJsonObject = (FotorStoreJsonObjects.ResposeDataJsonObject) o.get(paramString);
        }
        return localResposeDataJsonObject == null;
    }

    private static boolean l(String paramString) {
        FotorStoreJsonObjects.ResposeDataJsonObject localResposeDataJsonObject = null;
        if (p.containsKey(paramString)) {
            localResposeDataJsonObject = (FotorStoreJsonObjects.ResposeDataJsonObject) p.get(paramString);
        }
        return localResposeDataJsonObject == null;
    }

    private static boolean m() {
        boolean bool = false;
        if (k == null) {
            bool = true;
        }
        return bool;
    }

    private static boolean m(String paramString) {
        FotorStoreJsonObjects.ResposeListJsonObject localResposeListJsonObject = null;
        if (q.containsKey(paramString)) {
            localResposeListJsonObject = (FotorStoreJsonObjects.ResposeListJsonObject) q.get(paramString);
        }
        return localResposeListJsonObject == null;
    }

    private static boolean n() {
        boolean bool = false;
        if (l == null) {
            bool = true;
        }
        return bool;
    }

    public static abstract interface a {
        public abstract void a(FotorStoreJsonObjects.ResposeDataJsonObject<? extends FotorStoreJsonObjects.DetailsBaseJsonObject> paramResposeDataJsonObject);

        public abstract void a(FotorStoreJsonObjects.ResposeDataJsonObject<? extends FotorStoreJsonObjects.DetailsBaseJsonObject> paramResposeDataJsonObject, String paramString);
    }

    public static abstract interface b<T> {
        public abstract void a(FotorStoreJsonObjects.ResposeDataJsonObject<T> paramResposeDataJsonObject);

        public abstract void a(FotorStoreJsonObjects.ResposeDataJsonObject<T> paramResposeDataJsonObject, String paramString);
    }

    public static abstract interface c<T> {
        public abstract void a(FotorStoreJsonObjects.ResposeListJsonObject<T> paramResposeListJsonObject);

        public abstract void a(FotorStoreJsonObjects.ResposeListJsonObject<T> paramResposeListJsonObject, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */