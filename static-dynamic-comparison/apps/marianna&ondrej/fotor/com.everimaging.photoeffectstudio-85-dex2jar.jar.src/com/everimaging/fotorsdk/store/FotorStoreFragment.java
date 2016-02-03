package com.everimaging.fotorsdk.store;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v8.renderscript.RenderScript;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack.b;
import com.everimaging.fotorsdk.plugins.UpdateType;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.services.PluginService.f;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.AdvsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.PurchasablePackBaseJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeDataJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.entity.ResourceInfo;
import com.everimaging.fotorsdk.store.iap.a.b;
import com.everimaging.fotorsdk.store.iap.a.c;
import com.everimaging.fotorsdk.store.utils.c.b;
import com.everimaging.fotorsdk.store.utils.c.c;
import com.everimaging.fotorsdk.store.widget.FotorStackViewFlipper;
import com.everimaging.fotorsdk.store.widget.FotorStackViewFlipper.a;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.widget.FotorTextButton;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;
import com.everimaging.fotorsdk.widget.lib.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FotorStoreFragment
        extends FotorStoreBaseFragment
        implements ViewPager.OnPageChangeListener, View.OnClickListener, PluginService.f, FotorStoreAbstractDetailPage.a, FotorStoreBannerController.c, c.a, j {
    public static final String b = FotorStoreFragment.class.getSimpleName();
    private static final String c = FotorStoreFragment.class.getSimpleName();
    private static final FotorLoggerFactory.c d = FotorLoggerFactory.a(c, FotorLoggerFactory.LoggerType.CONSOLE);
    private static HashMap<String, k> e = new HashMap();
    private String f;
    private ViewPager g;
    private a h;
    private FotorStackViewFlipper i;
    private FotorTitleBackButton j;
    private FotorStackViewFlipper k;
    private FotorStoreAbstractDetailPage l;
    private List<FotorStoreAbstractDetailPage> m;
    private TabPageIndicator n;
    private FotorStoreBannerController o;
    private String p;
    private b q;
    private boolean r;
    private PluginService s;
    private FotorTextButton t;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private k.a x = new k.a() {
        public void a() {
            FotorStoreFragment.c(FotorStoreFragment.this);
        }

        public void a(DetailPageInfo paramAnonymousDetailPageInfo, boolean paramAnonymousBoolean) {
            FotorStoreFragment.this.a(paramAnonymousDetailPageInfo, true, FotorStoreAbstractDetailPage.SourceType.STORE, paramAnonymousBoolean);
        }
    };
    private View.OnClickListener y = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if ((paramAnonymousView == FotorStoreFragment.d(FotorStoreFragment.this)) && (FotorStoreFragment.e(FotorStoreFragment.this) != null)) {
                FotorStoreFragment.e(FotorStoreFragment.this).a();
            }
        }
    };
    private View.OnClickListener z = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (FotorStoreFragment.f(FotorStoreFragment.this) != null) {
                FotorStoreFragment.f(FotorStoreFragment.this).m();
            }
            if ((!FotorStoreFragment.g(FotorStoreFragment.this)) || (FotorStoreFragment.h(FotorStoreFragment.this).size() > 1)) {
                FotorStoreFragment.i(FotorStoreFragment.this);
            }
            while (FotorStoreFragment.e(FotorStoreFragment.this) == null) {
                return;
            }
            FotorStoreFragment.e(FotorStoreFragment.this).a();
        }
    };

    public FotorStoreFragment() {
        e = new HashMap();
        this.r = false;
        this.m = new ArrayList();
    }

    private int a(List<FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo> paramList, String paramString) {
        int i2 = -1;
        int i1 = 0;
        if (i1 < paramList.size()) {
            FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo localModuleInfo = (FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) paramList.get(i1);
            if (com.everimaging.fotorsdk.store.utils.c.i(localModuleInfo.type)) {
                if ((com.everimaging.fotorsdk.store.utils.c.f(paramString)) || (com.everimaging.fotorsdk.store.utils.c.g(paramString)) || (com.everimaging.fotorsdk.store.utils.c.h(paramString)) || (com.everimaging.fotorsdk.store.utils.c.i(paramString))) {
                    i2 = i1;
                }
            }
            for (; ; ) {
                i1 += 1;
                break;
                if (localModuleInfo.type.equals(paramString)) {
                    i2 = i1;
                }
            }
        }
        return i2;
    }

    private void a(FotorStoreAbstractDetailPage paramFotorStoreAbstractDetailPage, boolean paramBoolean) {
        if (this.u) {
        }
        while ((com.everimaging.fotorsdk.store.utils.c.e(paramFotorStoreAbstractDetailPage.q())) && ((!com.everimaging.fotorsdk.store.iap.a.b()) || (com.everimaging.fotorsdk.store.utils.c.d()))) {
            return;
        }
        this.m.add(paramFotorStoreAbstractDetailPage);
        this.l = paramFotorStoreAbstractDetailPage;
        paramFotorStoreAbstractDetailPage = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -1);
        this.k.setFlipperAnimListener(null);
        if (paramBoolean) {
            this.k.setInAnimation(getActivity(), R.anim.fotor_view_move_left_in_animation);
            this.k.setOutAnimation(getActivity(), R.anim.fotor_view_move_left_out_animation);
            this.k.setFlipperAnimListener(new FotorStackViewFlipper.a() {
                public void a(FotorStackViewFlipper paramAnonymousFotorStackViewFlipper) {
                    FotorStoreFragment.a(FotorStoreFragment.this, true);
                }

                public void b(FotorStackViewFlipper paramAnonymousFotorStackViewFlipper) {
                    FotorStoreFragment.a(FotorStoreFragment.this, false);
                }
            });
        }
        for (; ; ) {
            this.l.n().setOnClickListener(this.z);
            this.l.f();
            this.k.a(this.l.l(), paramFotorStoreAbstractDetailPage);
            this.i.a(this.l.n(), localLayoutParams);
            this.t.setVisibility(8);
            com.everimaging.fotorsdk.engine.d.a(this.a, 0);
            return;
            this.k.setInAnimation(null);
            this.k.setOutAnimation(null);
        }
    }

    private void a(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramResposeDataJsonObject) {
        if ((this.h != null) && (this.g != null)) {
        }
        for (String str = this.h.a(this.g.getCurrentItem()); ; str = "") {
            if ((paramResposeDataJsonObject.status == true) && (paramResposeDataJsonObject.data != null)) {
                Iterator localIterator = e.values().iterator();
                while (localIterator.hasNext()) {
                    ((k) localIterator.next()).f();
                }
                a(str, paramResposeDataJsonObject);
            }
            return;
        }
    }

    private void a(ProductInfo paramProductInfo) {
        final ProgressDialog localProgressDialog = new ProgressDialog(this.a);
        localProgressDialog.setCancelable(false);
        com.everimaging.fotorsdk.store.utils.c.a(new c.c() {
            public void a(FotorStoreJsonObjects.ResposeListJsonObject<ResourceInfo> paramAnonymousResposeListJsonObject) {
                paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                FotorStoreFragment.a(FotorStoreFragment.this, paramAnonymousResposeListJsonObject);
                localProgressDialog.dismiss();
            }

            public void a(FotorStoreJsonObjects.ResposeListJsonObject<ResourceInfo> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                localProgressDialog.dismiss();
                com.everimaging.fotorsdk.store.utils.f.a(FotorStoreFragment.this.getActivity());
            }
        }, new ProductInfo[]{paramProductInfo});
        localProgressDialog.show();
    }

    private void a(String paramString, FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramResposeDataJsonObject) {
        paramResposeDataJsonObject = (FotorStoreJsonObjects.ModulesJsonObject) paramResposeDataJsonObject.data;
        int i1;
        if ((com.everimaging.fotorsdk.store.utils.c.d()) || (!com.everimaging.fotorsdk.store.iap.a.b())) {
            i1 = a(paramResposeDataJsonObject.modules, "1");
            if (i1 >= 0) {
                paramResposeDataJsonObject.modules.remove(i1);
            }
        }
        this.h.a(paramResposeDataJsonObject);
        if (this.h.getCount() > 0) {
            this.n.a();
            i1 = a(paramResposeDataJsonObject.modules, paramString);
            if (i1 > 0) {
                this.g.setCurrentItem(i1, false);
                a(paramResposeDataJsonObject.modules, i1, paramString);
            }
        } else {
            return;
        }
        this.g.setCurrentItem(0, false);
    }

    private void a(String paramString1, String paramString2, boolean paramBoolean) {
        String str = "Unknow";
        HashMap localHashMap;
        if (com.everimaging.fotorsdk.store.utils.c.a(paramString1)) {
            str = "STORE_FRAME_PURCHASE";
            localHashMap = new HashMap();
            if (!paramBoolean) {
                break label171;
            }
        }
        label171:
        for (paramString1 = "DETAIL"; ; paramString1 = "MAIN") {
            localHashMap.put("entrypoint", paramString1);
            localHashMap.put("name", paramString2);
            com.everimaging.fotorsdk.a.a(str, localHashMap);
            return;
            if (com.everimaging.fotorsdk.store.utils.c.b(paramString1)) {
                str = "STORE_FX_PURCHASE";
                break;
            }
            if (com.everimaging.fotorsdk.store.utils.c.d(paramString1)) {
                str = "STORE_FONT_PURCHASE";
                break;
            }
            if (com.everimaging.fotorsdk.store.utils.c.c(paramString1)) {
                str = "STORE_STICKER_PURCHASE";
                break;
            }
            if (com.everimaging.fotorsdk.store.utils.c.f(paramString1)) {
                str = "STORE_COLLAGE_CLASSIC_PURCHASE";
                break;
            }
            if (com.everimaging.fotorsdk.store.utils.c.g(paramString1)) {
                str = "STORE_COLLAGE_MAGAZINE_PURCHASE";
                break;
            }
            if (com.everimaging.fotorsdk.store.utils.c.h(paramString1)) {
                str = "STORE_COLLAGE_PATTERN_PURCHASE";
                break;
            }
            if (!com.everimaging.fotorsdk.store.utils.c.e(paramString1)) {
                break;
            }
            str = "STORE_BUNDLE_PURCHASE";
            break;
        }
    }

    private void a(List<ResourceInfo> paramList) {
        d.c(new Object[]{"download product:" + paramList});
        ArrayList localArrayList = a("-1");
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            PurchasedPack localPurchasedPack = ((ResourceInfo) paramList.next()).buildPurchasedPack();
            String str = localPurchasedPack.getPackID();
            int i1 = c.a().a(str);
            if ((!localArrayList.contains(localPurchasedPack.getPackID())) && (i1 < 0)) {
                PurchasedPack.insert(this.a, localPurchasedPack);
                this.s.a(localPurchasedPack);
                c.a().a(localPurchasedPack);
            }
        }
    }

    private void a(List<FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo> paramList, int paramInt, String paramString) {
        String str = ((FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) paramList.get(paramInt)).type;
        if (com.everimaging.fotorsdk.store.utils.c.i(str)) {
            m localm = (m) e.get(str);
            paramList = localm;
            if (localm == null) {
                paramList = new m(this, str);
                e.put(str, paramList);
            }
            paramList.b(paramString);
        }
    }

    public static FotorStoreFragment c() {
        return new FotorStoreFragment();
    }

    private k c(PurchasedPack paramPurchasedPack) {
        String str = paramPurchasedPack.getType();
        if ((!com.everimaging.fotorsdk.store.utils.c.f(str)) && (!com.everimaging.fotorsdk.store.utils.c.g(str))) {
            paramPurchasedPack = str;
            if (!com.everimaging.fotorsdk.store.utils.c.h(str)) {
            }
        } else {
            paramPurchasedPack = com.everimaging.fotorsdk.store.utils.c.h;
        }
        return (k) e.get(paramPurchasedPack);
    }

    private void c(boolean paramBoolean) {
        FotorTextButton localFotorTextButton = this.t;
        if ((paramBoolean) && (this.l == null)) {
        }
        for (int i1 = 0; ; i1 = 8) {
            localFotorTextButton.setVisibility(i1);
            return;
        }
    }

    private boolean c(String paramString) {
        return this.s.a(paramString);
    }

    private void l() {
        if (this.l == null) {
        }
        do {
            do {
                return;
            } while ((this.l == null) || (this.i == null) || (this.k == null));
            this.l = null;
            if (this.m.size() > 0) {
                Iterator localIterator = this.m.iterator();
                while (localIterator.hasNext()) {
                    FotorStoreAbstractDetailPage localFotorStoreAbstractDetailPage = (FotorStoreAbstractDetailPage) localIterator.next();
                    this.i.removeView(localFotorStoreAbstractDetailPage.n());
                    this.k.removeView(localFotorStoreAbstractDetailPage.l());
                    localFotorStoreAbstractDetailPage.h();
                }
            }
            this.m.clear();
            this.i.setDisplayedChild(0);
            this.k.setDisplayedChild(0);
        } while (getView() == null);
        getView().invalidate();
    }

    private void m() {
        if (this.l == null) {
        }
        while (this.u) {
            return;
        }
        final Object localObject = this.l;
        this.l = null;
        if (this.m.size() > 0) {
            this.m.remove(this.m.size() - 1);
            if (this.m.size() > 0) {
                this.l = ((FotorStoreAbstractDetailPage) this.m.get(this.m.size() - 1));
                this.l.f();
            }
        }
        this.i.a(((FotorStoreAbstractDetailPage) localObject).n());
        this.k.setInAnimation(getActivity(), R.anim.fotor_view_move_right_in_animation);
        this.k.setOutAnimation(getActivity(), R.anim.fotor_view_move_right_out_animation);
        this.k.setFlipperAnimListener(new FotorStackViewFlipper.a() {
            public void a(FotorStackViewFlipper paramAnonymousFotorStackViewFlipper) {
                FotorStoreFragment.a(FotorStoreFragment.this, true);
            }

            public void b(FotorStackViewFlipper paramAnonymousFotorStackViewFlipper) {
                if (localObject != null) {
                    localObject.h();
                }
                FotorStoreFragment.b(FotorStoreFragment.this).setFlipperAnimListener(null);
                FotorStoreFragment.b(FotorStoreFragment.this, com.everimaging.fotorsdk.store.iap.a.b());
                FotorStoreFragment.a(FotorStoreFragment.this, false);
            }
        });
        this.k.a(((FotorStoreAbstractDetailPage) localObject).l());
        if (getView() != null) {
            getView().invalidate();
        }
        localObject = this.a;
        if (this.l == null) {
        }
        for (int i1 = 128; ; i1 = 0) {
            com.everimaging.fotorsdk.engine.d.a((Context) localObject, i1);
            return;
        }
    }

    private void n() {
        Iterator localIterator = e.values().iterator();
        while (localIterator.hasNext()) {
            ((k) localIterator.next()).g();
        }
    }

    private void o() {
        d.c(new Object[]{"request refresh store moudle infos"});
        this.o.c();
        com.everimaging.fotorsdk.store.utils.c.b();
        com.everimaging.fotorsdk.store.utils.c.a(new c.b() {
            public void a(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramAnonymousResposeDataJsonObject) {
                FotorStoreFragment.a(FotorStoreFragment.this, paramAnonymousResposeDataJsonObject);
            }

            public void a(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.ModulesJsonObject> paramAnonymousResposeDataJsonObject, String paramAnonymousString) {
                FotorStoreFragment.j(FotorStoreFragment.this);
            }
        }, getActivity(), true);
    }

    private void p() {
        d.c(new Object[]{"restore all purchase items."});
        final ProgressDialog localProgressDialog = new ProgressDialog(this.a);
        localProgressDialog.setMessage(this.a.getText(R.string.fotor_store_restoring_message));
        com.everimaging.fotorsdk.store.iap.a.a().a(new a.c() {
            public void a(com.everimaging.fotorsdk.store.billing.d paramAnonymousd, com.everimaging.fotorsdk.store.billing.c paramAnonymousc) {
                if (localProgressDialog.isShowing()) {
                    if (paramAnonymousc.b()) {
                        paramAnonymousd = FotorStoreFragment.j().values().iterator();
                        while (paramAnonymousd.hasNext()) {
                            paramAnonymousc = (k) paramAnonymousd.next();
                            if (paramAnonymousc != null) {
                                paramAnonymousc.e();
                            }
                        }
                    }
                    FotorStoreFragment.k().e(new Object[]{"query inventory failured"});
                    localProgressDialog.dismiss();
                    return;
                }
                FotorStoreFragment.k().d(new Object[]{"dialog was caceled by user."});
            }
        });
        localProgressDialog.show();
    }

    protected String a() {
        return b;
    }

    public ArrayList<String> a(String paramString) {
        ArrayList localArrayList = new ArrayList();
        int i1 = -1;
        if (com.everimaging.fotorsdk.store.utils.c.b(paramString)) {
            i1 = 2;
        }
        while (this.s != null) {
            paramString = this.s.d(i1).iterator();
            while (paramString.hasNext()) {
                localArrayList.add(((FeatureInternalPack) paramString.next()).getPackID());
            }
            if (com.everimaging.fotorsdk.store.utils.c.d(paramString)) {
                i1 = 6;
            } else if (com.everimaging.fotorsdk.store.utils.c.c(paramString)) {
                i1 = 3;
            } else if (com.everimaging.fotorsdk.store.utils.c.f(paramString)) {
                i1 = 7;
            } else if (com.everimaging.fotorsdk.store.utils.c.g(paramString)) {
                i1 = 8;
            } else if (com.everimaging.fotorsdk.store.utils.c.h(paramString)) {
                i1 = 9;
            } else if (com.everimaging.fotorsdk.store.utils.c.a(paramString)) {
                i1 = 4;
            } else if (com.everimaging.fotorsdk.store.utils.c.e(paramString)) {
                i1 = Integer.valueOf("1").intValue();
            }
        }
        return localArrayList;
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        if ((paramBundle != null) && (paramBundle.containsKey("internal_update_plugins"))) {
            paramPluginService = (ArrayList) paramBundle.getSerializable("internal_update_plugins");
            d.c(new Object[]{"updateTypes:" + paramPluginService});
            if ((paramPluginService == null) || (paramPluginService.size() <= 0)) {
                break label287;
            }
            paramPluginService = paramPluginService.iterator();
            if (!paramPluginService.hasNext()) {
                break label287;
            }
            paramPluginService = (UpdateType) paramPluginService.next();
            if (!FeaturePack.b.a(paramPluginService.getPluginType())) {
                break label185;
            }
            paramPluginService = com.everimaging.fotorsdk.store.utils.c.b;
        }
        for (; ; ) {
            if ((paramPluginService != null) && (!paramPluginService.isEmpty())) {
                if (e.containsKey(paramPluginService)) {
                    ((k) e.get(paramPluginService)).e();
                }
                if (e.containsKey("1")) {
                    ((l) e.get("1")).e();
                }
                if (this.l != null) {
                    this.l.a();
                }
            }
            return;
            label185:
            if (FeaturePack.b.c(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.c;
            } else if (FeaturePack.b.b(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.a;
            } else if (FeaturePack.b.d(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.d;
            } else if (FeaturePack.b.e(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.h;
            } else if (FeaturePack.b.f(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.h;
            } else if (FeaturePack.b.g(paramPluginService.getPluginType())) {
                paramPluginService = com.everimaging.fotorsdk.store.utils.c.h;
            } else {
                label287:
                paramPluginService = null;
            }
        }
    }

    public void a(b paramb) {
        this.q = paramb;
    }

    public void a(PurchasedPack paramPurchasedPack) {
        d.c(new Object[]{"download start:" + paramPurchasedPack});
        k localk = c(paramPurchasedPack);
        if (localk != null) {
            localk.b(paramPurchasedPack);
        }
        localk = (k) e.get("1");
        if (localk != null) {
            localk.b(paramPurchasedPack);
        }
        if ((this.l != null) && (this.l.a(paramPurchasedPack))) {
            this.l.e(paramPurchasedPack);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        d.c(new Object[]{"download progress:" + paramPurchasedPack, "progress=" + paramFloat});
        k localk = c(paramPurchasedPack);
        if (localk != null) {
            localk.a(paramPurchasedPack, paramFloat);
        }
        localk = (k) e.get("1");
        if (localk != null) {
            localk.a(paramPurchasedPack, paramFloat);
        }
        if ((this.l != null) && (this.l.a(paramPurchasedPack))) {
            this.l.a(paramPurchasedPack, paramFloat);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        d.c(new Object[]{"download failed:" + paramPurchasedPack});
        k localk = c(paramPurchasedPack);
        if (localk != null) {
            localk.a(paramPurchasedPack, paramInt);
        }
        localk = (k) e.get("1");
        if (localk != null) {
            localk.a(paramPurchasedPack, paramInt);
        }
        if ((this.l != null) && (this.l.a(paramPurchasedPack))) {
            this.l.c(paramPurchasedPack);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, String paramString) {
        d.c(new Object[]{"download finished:" + paramPurchasedPack});
        paramString = c(paramPurchasedPack);
        if (paramString != null) {
            paramString.c(paramPurchasedPack);
        }
        paramString = (k) e.get("1");
        if (paramString != null) {
            paramString.c(paramPurchasedPack);
        }
        if ((this.l != null) && (this.l.a(paramPurchasedPack))) {
            this.l.d(paramPurchasedPack);
        }
    }

    public void a(DetailPageInfo paramDetailPageInfo, boolean paramBoolean1, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean2) {
        String str = paramDetailPageInfo.type;
        Object localObject = null;
        if ((com.everimaging.fotorsdk.store.utils.c.c(str)) || (com.everimaging.fotorsdk.store.utils.c.d(str))) {
            localObject = new e(this, paramDetailPageInfo, this, paramSourceType, paramBoolean2);
        }
        for (; ; ) {
            if (localObject != null) {
                a((FotorStoreAbstractDetailPage) localObject, paramBoolean1);
            }
            return;
            if (com.everimaging.fotorsdk.store.utils.c.b(str)) {
                localObject = new f(this, paramDetailPageInfo, this, paramSourceType, paramBoolean2);
            } else if (com.everimaging.fotorsdk.store.utils.c.a(str)) {
                localObject = new d(this, paramDetailPageInfo, this, paramSourceType, paramBoolean2);
            } else if ((com.everimaging.fotorsdk.store.utils.c.f(str)) || (com.everimaging.fotorsdk.store.utils.c.g(str)) || (com.everimaging.fotorsdk.store.utils.c.h(str))) {
                localObject = new e(this, paramDetailPageInfo, this, paramSourceType, paramBoolean2);
            } else if (com.everimaging.fotorsdk.store.utils.c.e(str)) {
                localObject = new a(this, paramDetailPageInfo, this, paramSourceType);
            }
        }
    }

    public void a(FotorStoreJsonObjects.AdvsJsonObject paramAdvsJsonObject) {
        Object localObject2 = paramAdvsJsonObject.url;
        Object localObject1;
        if ((localObject2 != null) && (!((String) localObject2).isEmpty())) {
            localObject1 = localObject2;
            if (!((String) localObject2).startsWith("http://")) {
                localObject1 = localObject2;
                if (!((String) localObject2).startsWith("https://")) {
                    localObject1 = "http://" + (String) localObject2;
                }
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) localObject1)));
        }
        for (; ; ) {
            if (paramAdvsJsonObject != null) {
                localObject1 = new HashMap();
                ((Map) localObject1).put("package_id", String.valueOf(paramAdvsJsonObject.id));
                ((Map) localObject1).put("url", paramAdvsJsonObject.url);
                com.everimaging.fotorsdk.a.a("STORE_BANNER", (Map) localObject1);
            }
            return;
            localObject1 = paramAdvsJsonObject.type;
            localObject2 = String.valueOf(paramAdvsJsonObject.resourceId);
            if ((localObject1 != null) && (!((String) localObject1).isEmpty()) && (localObject2 != null) && (!((String) localObject2).isEmpty())) {
                localObject2 = new DetailPageInfo();
                ((DetailPageInfo) localObject2).type = ((String) localObject1);
                ((DetailPageInfo) localObject2).id = paramAdvsJsonObject.resourceId;
                ((DetailPageInfo) localObject2).description = paramAdvsJsonObject.description;
                ((DetailPageInfo) localObject2).name = paramAdvsJsonObject.name;
                a((DetailPageInfo) localObject2, true, FotorStoreAbstractDetailPage.SourceType.ADV, true);
            }
        }
    }

    public void a(final ProductInfo paramProductInfo, String paramString, boolean paramBoolean) {
        int i2 = 0;
        final Object localObject1;
        Object localObject2;
        if (com.everimaging.fotorsdk.store.utils.c.d()) {
            localObject1 = "market://details?id=" + paramProductInfo.getPackageName();
            localObject2 = new Intent("android.intent.action.VIEW");
            ((Intent) localObject2).setData(Uri.parse((String) localObject1));
            startActivity((Intent) localObject2);
        }
        for (; ; ) {
            a(paramString, paramProductInfo.getName(), paramBoolean);
            return;
            localObject1 = com.everimaging.fotorsdk.store.utils.c.a(paramProductInfo.getResourceId());
            if (((!paramProductInfo.isFree()) || (localObject1 != null)) && (!b(paramProductInfo.getPackID()))) {
                break;
            }
            d.c(new Object[]{"product is free ,query download link direct"});
            a(paramProductInfo);
        }
        if ((com.everimaging.fotorsdk.store.iap.a.b()) && (localObject1 != null)) {
            i1 = i2;
            if (com.everimaging.fotorsdk.store.utils.c.e(paramProductInfo.getType())) {
                i1 = i2;
                if (paramProductInfo.getSubPacks() != null) {
                    localObject2 = a("1");
                    StatusAssistant.a local9 = new StatusAssistant.a() {
                        public boolean a(String paramAnonymousString) {
                            return FotorStoreFragment.a(FotorStoreFragment.this, paramAnonymousString);
                        }
                    };
                    Iterator localIterator = paramProductInfo.getSubPacks().iterator();
                    do {
                        if (!localIterator.hasNext()) {
                            break;
                        }
                    }
                    while (!StatusAssistant.a((FotorStoreJsonObjects.PurchasablePackBaseJsonObject) localIterator.next(), (ArrayList) localObject2, local9).b());
                }
            }
        }
        for (int i1 = 1; ; i1 = 0) {
            if (i1 == 0) {
            }
            for (i1 = 1; ; i1 = 0) {
                if ((!com.everimaging.fotorsdk.store.iap.a.a().a(((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject1).productId)) && (!b(paramProductInfo.getPackID())) && (i1 == 0)) {
                    break label286;
                }
                a(paramProductInfo);
                break;
            }
            label286:
            com.everimaging.fotorsdk.store.iap.a.a().a(getActivity(), ((FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo) localObject1).productId, 1, new a.b() {
                public void a(com.everimaging.fotorsdk.store.billing.c paramAnonymousc, com.everimaging.fotorsdk.store.billing.e paramAnonymouse) {
                    FotorStoreFragment.k().c(new Object[]{"purchase finished:" + paramAnonymousc + ",purchase info:" + paramAnonymouse});
                    if ((paramAnonymousc.c()) || ((paramAnonymousc.b()) && (paramAnonymouse != null) && (paramAnonymouse.b().equals(localObject1.productId)))) {
                        FotorStoreFragment.a(FotorStoreFragment.this, paramProductInfo);
                    }
                }
            });
            break;
            d.e(new Object[]{"Iab available:" + com.everimaging.fotorsdk.store.iap.a.b(), "resourceInfo:" + localObject1});
            break;
        }
    }

    public void a(String paramString1, String paramString2) {
        d.c(new Object[]{"onUpdateLatestPrice:storeType:" + paramString1, "packID:" + paramString2});
        if (com.everimaging.fotorsdk.store.utils.c.i(paramString1)) {
        }
        for (Object localObject = com.everimaging.fotorsdk.store.utils.c.h; ; localObject = paramString1) {
            localObject = (k) e.get(localObject);
            if (localObject != null) {
                ((k) localObject).a(paramString1, paramString2);
            }
            return;
        }
    }

    public void a(boolean paramBoolean) {
        if (!this.v) {
            this.w = true;
            return;
        }
        l();
        e.clear();
        Object localObject = getArguments();
        String str1;
        label71:
        String str2;
        if (localObject != null) {
            if (((Bundle) localObject).containsKey("arg_preview_src")) {
                this.p = ((Bundle) localObject).getString("arg_preview_src");
            }
            if (((Bundle) localObject).containsKey("arg_feature_type")) {
                str1 = ((Bundle) localObject).getString("arg_feature_type");
                if (((Bundle) localObject).containsKey("arg_package_info")) {
                    DetailPageInfo localDetailPageInfo = (DetailPageInfo) ((Bundle) localObject).getParcelable("arg_package_info");
                    localObject = localDetailPageInfo;
                    str2 = str1;
                    if (localDetailPageInfo != null) {
                        this.r = true;
                        str2 = str1;
                        localObject = localDetailPageInfo;
                    }
                }
            }
        }
        for (; ; ) {
            if (this.r) {
                ((DetailPageInfo) localObject).type = str2;
                a((DetailPageInfo) localObject, false, FotorStoreAbstractDetailPage.SourceType.RECOMMEND, true);
            }
            while (this.t != null) {
                c(paramBoolean);
                return;
                this.h = new a(getChildFragmentManager());
                this.g.setAdapter(this.h);
                this.n.setViewPager(this.g);
                a(str2, com.everimaging.fotorsdk.store.utils.c.c());
                this.o.c();
            }
            break;
            localObject = null;
            str2 = str1;
            continue;
            str1 = "";
            break label71;
            str2 = "";
            localObject = null;
        }
    }

    public void b(PurchasedPack paramPurchasedPack) {
        d.c(new Object[]{"prepare start download:" + paramPurchasedPack});
        k localk = c(paramPurchasedPack);
        if (localk != null) {
            localk.a(paramPurchasedPack);
        }
        localk = (k) e.get("1");
        if (localk != null) {
            localk.a(paramPurchasedPack);
        }
        if ((this.l != null) && (this.l.a(paramPurchasedPack))) {
            this.l.b(paramPurchasedPack);
        }
    }

    public void b(boolean paramBoolean) {
        if (paramBoolean) {
            Iterator localIterator = e.values().iterator();
            while (localIterator.hasNext()) {
                k localk = (k) localIterator.next();
                if (localk != null) {
                    localk.e();
                }
            }
            if (this.l != null) {
                this.l.a();
            }
        }
    }

    public boolean b() {
        boolean bool = true;
        if (this.l != null) {
            if ((this.r) && (this.m.size() == 1)) {
                this.l.m();
            }
        } else {
            if (this.q != null) {
                this.q.a();
            }
            bool = super.b();
        }
        while (this.l.m()) {
            return bool;
        }
        m();
        return true;
    }

    public boolean b(String paramString) {
        return c(paramString);
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.f;
    }

    public FragmentActivity f() {
        return getActivity();
    }

    public RenderScript g() {
        return this.q.c();
    }

    public com.everimaging.fotorsdk.algorithms.filter.d h() {
        return this.q.d();
    }

    public Uri i() {
        Resources localResources = getResources();
        return Uri.parse("android.resource://" + localResources.getResourcePackageName(R.raw.fotor_sample_test) + "/raw/fotor_sample_test");
    }

    public void onClick(View paramView) {
        if (paramView == this.t) {
            p();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        c.a().a(this);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.f = FotorCommonDirUtils.getWorkspacePath();
        paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_store_main, paramViewGroup, false);
        paramLayoutInflater.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        this.t = ((FotorTextButton) paramLayoutInflater.findViewById(R.id.fotor_store_restore));
        this.t.setOnClickListener(this);
        c(com.everimaging.fotorsdk.store.iap.a.b());
        this.k = ((FotorStackViewFlipper) paramLayoutInflater.findViewById(R.id.fotor_store_main_container));
        this.i = ((FotorStackViewFlipper) paramLayoutInflater.findViewById(R.id.fotor_store_header_text_container));
        this.j = ((FotorTitleBackButton) paramLayoutInflater.findViewById(R.id.fotor_store_title));
        this.j.setOnClickListener(this.y);
        this.n = ((TabPageIndicator) paramLayoutInflater.findViewById(R.id.fotor_store_tabindicator));
        this.g = ((ViewPager) paramLayoutInflater.findViewById(R.id.fotor_store_viewpager));
        this.g.setOnPageChangeListener(this);
        this.o = new FotorStoreBannerController(getActivity(), getChildFragmentManager());
        this.o.a(this);
        paramViewGroup = (FrameLayout) paramLayoutInflater.findViewById(R.id.fotor_store_ads_layout);
        paramViewGroup.removeAllViews();
        paramViewGroup.addView(this.o.b());
        if (this.q != null) {
            this.s = this.q.b();
            this.s.a(this);
            this.s.a(true);
        }
        this.v = true;
        if (this.w) {
            a(com.everimaging.fotorsdk.store.iap.a.b());
            this.w = false;
        }
        return paramLayoutInflater;
    }

    public void onDestroy() {
        if (e != null) {
            e.clear();
        }
        if (this.s != null) {
            this.s.b(this);
        }
        if (this.o != null) {
            this.o.a();
        }
        c.a().b(this);
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onPageScrollStateChanged(int paramInt) {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    }

    public void onPageSelected(int paramInt) {
        if ((this.g != null) && (this.h != null) && (this.h.getPageTitle(paramInt) != null)) {
            com.everimaging.fotorsdk.a.a("Store_Module_Tab", this.h.getPageTitle(paramInt).toString());
        }
    }

    public void onPause() {
        super.onPause();
        com.everimaging.fotorsdk.engine.d.a(this.a, 0);
    }

    public void onResume() {
        super.onResume();
        Context localContext = this.a;
        if (this.l == null) {
        }
        for (int i1 = 128; ; i1 = 0) {
            com.everimaging.fotorsdk.engine.d.a(localContext, i1);
            return;
        }
    }

    public static class FotorStoreFeatureFragment
            extends Fragment {
        private k a = null;
        private String b;

        public String a() {
            return this.b;
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            this.b = getArguments().getString("Module_Type");
            this.a = ((k) FotorStoreFragment.j().get(this.b));
            if (this.a == null) {
                return null;
            }
            paramLayoutInflater = this.a.d().getParent();
            if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
                ((ViewGroup) paramLayoutInflater).removeView(this.a.d());
            }
            return this.a.d();
        }

        public void onDestroy() {
            super.onDestroy();
        }

        public void onDetach() {
            super.onDetach();
        }
    }

    public class a
            extends FragmentStatePagerAdapter {
        private FotorStoreJsonObjects.ModulesJsonObject b;

        public a(FragmentManager paramFragmentManager) {
            super();
        }

        public String a(int paramInt) {
            if ((this.b != null) && (this.b.modules != null) && (paramInt >= 0) && (paramInt < this.b.modules.size())) {
                return ((FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) this.b.modules.get(paramInt)).type;
            }
            return "";
        }

        public void a(FotorStoreJsonObjects.ModulesJsonObject paramModulesJsonObject) {
            this.b = paramModulesJsonObject;
            notifyDataSetChanged();
        }

        public int getCount() {
            int j = 0;
            int i = j;
            if (this.b != null) {
                i = j;
                if (this.b.modules != null) {
                    i = this.b.modules.size();
                }
            }
            return i;
        }

        public Fragment getItem(int paramInt) {
            FotorStoreFragment.FotorStoreFeatureFragment localFotorStoreFeatureFragment = new FotorStoreFragment.FotorStoreFeatureFragment();
            Object localObject = new Bundle();
            String str = ((FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) this.b.modules.get(paramInt)).type;
            ((Bundle) localObject).putString("Module_Type", str);
            localFotorStoreFeatureFragment.setArguments((Bundle) localObject);
            k localk = (k) FotorStoreFragment.j().get(str);
            localObject = localk;
            if (localk == null) {
                if (!com.everimaging.fotorsdk.store.utils.c.i(str)) {
                    break label116;
                }
                localObject = new m(FotorStoreFragment.this, str);
            }
            for (; ; ) {
                FotorStoreFragment.j().put(str, localObject);
                ((k) localObject).a(FotorStoreFragment.a(FotorStoreFragment.this));
                return localFotorStoreFeatureFragment;
                label116:
                if (com.everimaging.fotorsdk.store.utils.c.e(str)) {
                    localObject = new l(FotorStoreFragment.this, str);
                } else {
                    localObject = new n(FotorStoreFragment.this, str);
                }
            }
        }

        public int getItemPosition(Object paramObject) {
            paramObject = ((FotorStoreFragment.FotorStoreFeatureFragment) paramObject).a();
            int i = 0;
            if (i < this.b.modules.size()) {
                if (((FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) this.b.modules.get(i)).type != paramObject) {
                }
            }
            for (; ; ) {
                if (i >= 0) {
                    return i;
                    i += 1;
                    break;
                }
                return -2;
                i = -1;
            }
        }

        public CharSequence getPageTitle(int paramInt) {
            String str2 = ((FotorStoreJsonObjects.ModulesJsonObject.ModuleInfo) this.b.modules.get(paramInt)).type;
            String str1 = "";
            Resources localResources = FotorStoreFragment.this.getResources();
            if (com.everimaging.fotorsdk.store.utils.c.c(str2)) {
                str1 = localResources.getString(R.string.fotor_store_title_stickers);
            }
            for (; ; ) {
                return str1.toUpperCase(Locale.getDefault());
                if (com.everimaging.fotorsdk.store.utils.c.d(str2)) {
                    str1 = localResources.getString(R.string.fotor_store_title_fonts);
                } else if (com.everimaging.fotorsdk.store.utils.c.a(str2)) {
                    str1 = localResources.getString(R.string.fotor_store_title_frames);
                } else if (com.everimaging.fotorsdk.store.utils.c.b(str2)) {
                    str1 = localResources.getString(R.string.fotor_store_title_effects);
                } else if (com.everimaging.fotorsdk.store.utils.c.e(str2)) {
                    str1 = localResources.getString(R.string.fotor_store_title_bundle);
                } else if (com.everimaging.fotorsdk.store.utils.c.i(str2)) {
                    str1 = localResources.getString(R.string.fotor_store_title_collages);
                }
            }
        }
    }

    public static abstract interface b {
        public abstract void a();

        public abstract PluginService b();

        public abstract RenderScript c();

        public abstract com.everimaging.fotorsdk.algorithms.filter.d d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/FotorStoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */