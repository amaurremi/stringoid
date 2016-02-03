package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v8.renderscript.Float2;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSFrameBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity.Category;
import com.everimaging.fotorsdk.app.FotorAlertDialog;
import com.everimaging.fotorsdk.app.FotorAlertDialog.a;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.editor.filter.params.EffectsParams;
import com.everimaging.fotorsdk.entity.BorderConfig;
import com.everimaging.fotorsdk.entity.BorderConfig.BorderItem;
import com.everimaging.fotorsdk.entity.BorderInfo;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureDownloadedPack;
import com.everimaging.fotorsdk.plugins.FeatureExternalPack;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.FeaturePack.b;
import com.everimaging.fotorsdk.plugins.FeaturePurchasedPack;
import com.everimaging.fotorsdk.plugins.UpdateType;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.plugins.h.b;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.utils.f;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.SimpleStatusMachine;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
        extends EffectAbtractFeature {
    private static final String G = e.class.getSimpleName();
    private static final FotorLoggerFactory.c H = FotorLoggerFactory.a(G, FotorLoggerFactory.LoggerType.CONSOLE);
    private List<EffectInfo> I;
    private com.everimaging.fotorsdk.database.helper.a J;
    private EffectAbtractFeature.EffectPackInfo K;
    private FotorAlertDialog L;
    private a M;
    protected FxEffectFilter l;
    protected EffectsParams m;

    public e(com.everimaging.fotorsdk.editor.c paramc) {
        super(paramc);
    }

    private List<EffectAbtractFeature.EffectPackInfo> L() {
        ArrayList localArrayList = new ArrayList();
        FeaturePurchasedPack[] arrayOfFeaturePurchasedPack = this.A.c(4);
        int i = 0;
        if (i < arrayOfFeaturePurchasedPack.length) {
            Object localObject1 = arrayOfFeaturePurchasedPack[i];
            Object localObject2 = ((FeaturePurchasedPack) localObject1).getDownloadPack();
            if (localObject2 != null) {
                localArrayList.add(a((com.everimaging.fotorsdk.plugins.c) h.a(this.h, (FeaturePack) localObject2)));
                this.C += 1;
            }
            for (; ; ) {
                i += 1;
                break;
                localObject1 = h.a(this.h, (FeaturePack) localObject1);
                localObject2 = new EffectAbtractFeature.EffectPackInfo();
                ((EffectAbtractFeature.EffectPackInfo) localObject2).c = EffectAbtractFeature.EffectPackInfo.EffectPackType.PURCHASED;
                ((EffectAbtractFeature.EffectPackInfo) localObject2).a = ((h.b) localObject1).b_();
                ((EffectAbtractFeature.EffectPackInfo) localObject2).e = ((h.b) localObject1);
                ((EffectAbtractFeature.EffectPackInfo) localObject2).b = ((h.b) localObject1).a();
                int j = com.everimaging.fotorsdk.store.c.a().a(((h.b) localObject1).g());
                if (j >= 0) {
                    ((EffectAbtractFeature.EffectPackInfo) localObject2).f = true;
                    ((EffectAbtractFeature.EffectPackInfo) localObject2).g = j;
                }
                localArrayList.add(localObject2);
            }
        }
        return localArrayList;
    }

    private List<EffectAbtractFeature.EffectPackInfo> M() {
        ArrayList localArrayList = new ArrayList();
        FeatureInternalPack[] arrayOfFeatureInternalPack = this.A.a(this.h, 4);
        H.c(new Object[]{"installedPack size:" + arrayOfFeatureInternalPack.length});
        int i = 0;
        if (i < arrayOfFeatureInternalPack.length) {
            Object localObject = arrayOfFeatureInternalPack[i];
            H.c(new Object[]{"Pack:" + localObject});
            if ((localObject instanceof FeaturePurchasedPack)) {
            }
            for (localObject = b((FeaturePurchasedPack) localObject); ; localObject = a((com.everimaging.fotorsdk.plugins.g) h.a(this.h, (FeaturePack) localObject))) {
                if (localObject != null) {
                    localArrayList.add(localObject);
                }
                i += 1;
                break;
            }
        }
        return localArrayList;
    }

    private boolean N() {
        if (this.M != null) {
            return this.M.cancel(true);
        }
        return false;
    }

    private void O() {
        if ((this.m.getEffectEntity() == null) || (this.m.getEffectEntity().getID() == -1)) {
            this.v.b(0);
            return;
        }
        this.v.a(this.m.getEffectEntity());
    }

    private void P() {
        try {
            com.everimaging.fotorsdk.preference.a.g(this.h, false);
            FragmentActivity localFragmentActivity = this.a.a().q();
            Object localObject = localFragmentActivity.getSupportFragmentManager().findFragmentByTag("Install_Frame");
            H.c(new Object[]{"showing dialog:" + localObject});
            if (localObject != null) {
                H.d(new Object[]{"install dialog is showing will return."});
                return;
            }
            localObject = new Bundle();
            ((Bundle) localObject).putCharSequence("MESSAGE", this.h.getResources().getText(R.string.fotor_frame_no_pack_alert_message));
            ((Bundle) localObject).putCharSequence("POSITIVE_BUTTON_TEXT", localFragmentActivity.getText(17039370));
            FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
            localFotorAlertDialog.setArguments((Bundle) localObject);
            localFotorAlertDialog.a(new FotorAlertDialog.a() {
                public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                }

                public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                }

                public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                }
            });
            localFotorAlertDialog.a(localFragmentActivity.getSupportFragmentManager(), "Install_Frame", true);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private EffectAbtractFeature.EffectPackInfo a(com.everimaging.fotorsdk.plugins.g paramg) {
        EffectAbtractFeature.EffectPackInfo localEffectPackInfo = new EffectAbtractFeature.EffectPackInfo();
        a(paramg, localEffectPackInfo);
        return localEffectPackInfo;
    }

    private void a(final EffectAbtractFeature.EffectPackInfo paramEffectPackInfo, Bitmap paramBitmap) {
        this.p.setVisibility(8);
        this.t.setVisibility(0);
        this.v = new com.everimaging.fotorsdk.editor.adapter.a(this.h, paramEffectPackInfo.d, new EffectThumbLoader.EffectThumbProcessor() {
            public Bitmap processBitmap(EffectInfo paramAnonymousEffectInfo, Bitmap paramAnonymousBitmap) {
                for (; ; ) {
                    try {
                        e.d().c(new Object[]{"EffectThumbProcessor ->processBitmap"});
                        Object localObject = new EffectsParams();
                        ((EffectsParams) localObject).setEffectEntity(paramAnonymousEffectInfo.effectEntity);
                        if ((paramAnonymousEffectInfo.effectEntity.getmFilters() != null) && (paramAnonymousEffectInfo.effectEntity.getmFilters().size() > 0)) {
                            localRSFrameBaseFilterParams = (RSFrameBaseFilterParams) ((BaseFilterEntity) paramAnonymousEffectInfo.effectEntity.getmFilters().get(0)).getParams();
                            if (localRSFrameBaseFilterParams != null) {
                                localRSFrameBaseFilterParams.setThickness(((BorderInfo) paramAnonymousEffectInfo).thumbnailThickness);
                            }
                            paramAnonymousBitmap = new FxEffectFilter(e.this, paramAnonymousBitmap, null, (EffectsParams) localObject, FxEffectFilter.Level.SMALL);
                            paramAnonymousBitmap.a((com.everimaging.fotorsdk.plugins.g) paramEffectPackInfo.e);
                            localObject = paramAnonymousBitmap.a();
                            paramAnonymousBitmap.b();
                            if (localRSFrameBaseFilterParams != null) {
                                localRSFrameBaseFilterParams.setThickness(((BorderInfo) paramAnonymousEffectInfo).originalThickness);
                            }
                            return (Bitmap) localObject;
                        }
                    } finally {
                    }
                    RSFrameBaseFilterParams localRSFrameBaseFilterParams = null;
                }
            }
        }, paramBitmap);
        this.u.setAdapter(this.v);
        O();
    }

    private void a(EffectInfo paramEffectInfo) {
        boolean bool = N();
        H.c(new Object[]{"killCurrentTask success:" + bool});
        this.M = new a(paramEffectInfo);
        this.M.execute(new Void[0]);
        if ((paramEffectInfo.effectEntity != null) && (paramEffectInfo.effectEntity.getID() != -1)) {
            this.i = true;
            return;
        }
        this.i = false;
    }

    private void a(com.everimaging.fotorsdk.plugins.g paramg, EffectAbtractFeature.EffectPackInfo paramEffectPackInfo) {
        Object localObject1 = (h.a) paramg;
        paramEffectPackInfo.b = paramg.a();
        H.c(new Object[]{"packName:" + paramEffectPackInfo.a});
        paramEffectPackInfo.c = EffectAbtractFeature.EffectPackInfo.EffectPackType.NORMAL;
        paramEffectPackInfo.e = paramg;
        paramg = ((h.a) localObject1).b();
        if (paramg == null) {
        }
        do {
            return;
            localObject3 = (BorderConfig) new GsonBuilder().create().fromJson(new InputStreamReader(paramg), BorderConfig.class);
            paramEffectPackInfo.a = ((BorderConfig) localObject3).title;
            FotorIOUtils.closeSilently(paramg);
        }
        while ((localObject3 == null) || (((BorderConfig) localObject3).classes == null) || (((BorderConfig) localObject3).classes.size() == 0));
        paramg = new ArrayList();
        Object localObject2 = new com.everimaging.fotorsdk.algorithms.xml.c();
        Object localObject3 = ((BorderConfig) localObject3).classes.iterator();
        while (((Iterator) localObject3).hasNext()) {
            BorderConfig.BorderItem localBorderItem = (BorderConfig.BorderItem) ((Iterator) localObject3).next();
            BorderInfo localBorderInfo = new BorderInfo();
            Object localObject4 = ((h.a) localObject1).a(localBorderItem.algorithm_file);
            if (localObject4 != null) {
                ((com.everimaging.fotorsdk.algorithms.xml.c) localObject2).a((InputStream) localObject4);
                FotorIOUtils.closeSilently((Closeable) localObject4);
                localObject4 = ((com.everimaging.fotorsdk.algorithms.xml.c) localObject2).a();
                localBorderInfo.effectEntity = ((EffectEntity) localObject4);
                float f1 = Float.parseFloat(localBorderItem.sThickness);
                H.c(new Object[]{"name:" + localBorderItem.algorithm_file + ",thumbThickness:" + f1});
                localBorderInfo.thumbnailThickness = new Float2(f1, f1);
                float f2 = Float.parseFloat(localBorderItem.mThickness);
                H.c(new Object[]{"name:" + localBorderItem.algorithm_file + ",mediumThickness:" + f1});
                localBorderInfo.mediumThickness = new Float2(f2, f2);
                if ((localObject4 != null) && (((EffectEntity) localObject4).getCategory() == EffectEntity.Category.FRAME)) {
                    localBorderInfo.originalThickness = ((RSFrameBaseFilterParams) ((BaseFilterEntity) ((EffectEntity) localObject4).getmFilters().get(0)).getParams()).getThickness();
                }
                paramg.add(localBorderInfo);
            }
        }
        if (paramg.size() > 0) {
            localObject1 = new BorderInfo();
            localObject2 = new EffectEntity();
            ((EffectEntity) localObject2).setName(this.h.getString(R.string.fotor_original));
            ((BorderInfo) localObject1).effectEntity = ((EffectEntity) localObject2);
            paramg.add(0, localObject1);
        }
        paramEffectPackInfo.d = paramg;
    }

    private boolean a(Bundle paramBundle) {
        if ((paramBundle != null) && (paramBundle.containsKey("internal_update_plugins"))) {
            paramBundle = (ArrayList) paramBundle.getSerializable("internal_update_plugins");
            if ((paramBundle != null) && (paramBundle.size() > 0)) {
                paramBundle = paramBundle.iterator();
                while (paramBundle.hasNext()) {
                    if (FeaturePack.b.c(((UpdateType) paramBundle.next()).getPluginType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private EffectAbtractFeature.EffectPackInfo b(FeaturePurchasedPack paramFeaturePurchasedPack) {
        EffectAbtractFeature.EffectPackInfo localEffectPackInfo = new EffectAbtractFeature.EffectPackInfo();
        FeatureDownloadedPack localFeatureDownloadedPack = paramFeaturePurchasedPack.getDownloadPack();
        if (localFeatureDownloadedPack != null) {
            paramFeaturePurchasedPack = a((com.everimaging.fotorsdk.plugins.c) h.a(this.h, localFeatureDownloadedPack));
        }
        int i;
        do {
            return paramFeaturePurchasedPack;
            paramFeaturePurchasedPack = h.a(this.h, paramFeaturePurchasedPack);
            localEffectPackInfo.c = EffectAbtractFeature.EffectPackInfo.EffectPackType.PURCHASED;
            localEffectPackInfo.a = paramFeaturePurchasedPack.b_();
            localEffectPackInfo.e = paramFeaturePurchasedPack;
            localEffectPackInfo.b = paramFeaturePurchasedPack.a();
            i = com.everimaging.fotorsdk.store.c.a().a(paramFeaturePurchasedPack.g());
            paramFeaturePurchasedPack = localEffectPackInfo;
        } while (i < 0);
        localEffectPackInfo.f = true;
        localEffectPackInfo.g = i;
        return localEffectPackInfo;
    }

    private List<EffectAbtractFeature.EffectPackInfo> n() {
        ArrayList localArrayList = new ArrayList();
        FeatureExternalPack[] arrayOfFeatureExternalPack = this.A.b(4);
        int i = 0;
        while (i < arrayOfFeatureExternalPack.length) {
            Object localObject = arrayOfFeatureExternalPack[i];
            localObject = h.a(this.h, (FeaturePack) localObject);
            EffectAbtractFeature.EffectPackInfo localEffectPackInfo = new EffectAbtractFeature.EffectPackInfo();
            localEffectPackInfo.c = EffectAbtractFeature.EffectPackInfo.EffectPackType.EXTERNAL;
            localEffectPackInfo.a = ((h.b) localObject).b_();
            localEffectPackInfo.e = ((h.b) localObject);
            localArrayList.add(localEffectPackInfo);
            i += 1;
        }
        return localArrayList;
    }

    public void A() {
        if (this.n.getCurrentStatus() == 2) {
        }
        do {
            return;
            this.n.setStatus(2);
        } while ((this.b == null) || (this.D));
        this.b.a(this, this.w, new BaseParams[]{this.m});
    }

    public boolean B() {
        N();
        return super.B();
    }

    protected void C() {
        super.C();
        synchronized (this.m) {
            if (((this.m == null) || (this.m.getEffectEntity() == null)) && (!this.D)) {
                this.i = false;
            }
            return;
        }
    }

    protected void E() {
        Object localObject2 = "Unknow";
        String str2 = "Unknow";
        String str1 = str2;
        Object localObject1 = localObject2;
        if (this.m != null) {
            str1 = str2;
            localObject1 = localObject2;
            if (this.m.getEffectEntity() != null) {
                str2 = "" + this.m.getEffectEntity().getID();
                str1 = str2;
                localObject1 = localObject2;
                if (this.m.getFeaturePack() != null) {
                    localObject1 = this.m.getFeaturePack().getPackName();
                    str1 = str2;
                }
            }
        }
        localObject2 = new HashMap();
        ((Map) localObject2).put("Frame_Category", localObject1);
        ((Map) localObject2).put("Frame_Class", str1);
        com.everimaging.fotorsdk.a.a("EDIT_FRAME_APPLY", (Map) localObject2);
    }

    protected void a() {
        super.a();
    }

    protected void a(EffectAbtractFeature.EffectPackInfo paramEffectPackInfo) {
        H.c(new Object[]{"onCategoryItemClick"});
        if (paramEffectPackInfo.c == EffectAbtractFeature.EffectPackInfo.EffectPackType.NORMAL) {
            this.p.setVisibility(8);
            this.t.setVisibility(0);
            if (this.K == paramEffectPackInfo) {
                H.c(new Object[]{"pre categoryinfo == current info"});
            }
        }
        while (paramEffectPackInfo.c != EffectAbtractFeature.EffectPackInfo.EffectPackType.EXTERNAL) {
            return;
            this.l.a((com.everimaging.fotorsdk.plugins.g) paramEffectPackInfo.e);
            a(paramEffectPackInfo, this.x);
            this.K = paramEffectPackInfo;
            Object localObject = "Unknow";
            paramEffectPackInfo = (EffectAbtractFeature.EffectPackInfo) localObject;
            if (this.K != null) {
                paramEffectPackInfo = (EffectAbtractFeature.EffectPackInfo) localObject;
                if (!TextUtils.isEmpty(this.K.a)) {
                    paramEffectPackInfo = this.K.a.toString();
                }
            }
            localObject = new HashMap();
            ((Map) localObject).put("Frame_Category", paramEffectPackInfo);
            com.everimaging.fotorsdk.a.a("EDIT_FRAME_ITEM_TAP", (Map) localObject);
            return;
        }
        Toast.makeText(this.h, "Coming soon", 0).show();
    }

    protected void a(EffectInfo paramEffectInfo, int paramInt) {
        H.c(new Object[]{"onEffectItemClick :" + paramEffectInfo});
        a(paramEffectInfo);
        this.v.b(paramInt);
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        H.c(new Object[]{"====onUpdate===="});
        if (G()) {
            if ((paramBundle == null) || (!paramBundle.containsKey("internal_update_is_inapp_mode"))) {
                break label68;
            }
            paramPluginService = new ArrayList();
            a(paramPluginService);
            if (this.s != null) {
                this.s.a(paramPluginService);
            }
        }
        label68:
        do {
            do {
                return;
            } while (this.F.a());
            paramPluginService = this.a.a().q();
            Fragment localFragment = paramPluginService.getSupportFragmentManager().findFragmentByTag("Update Border Pack");
            H.c(new Object[]{"showing dialog:" + localFragment});
            if (localFragment != null) {
                H.d(new Object[]{"update alert dialog is showing will return."});
                return;
            }
        } while (!a(paramBundle));
        this.L = FotorAlertDialog.a();
        paramBundle = new Bundle();
        paramBundle.putCharSequence("MESSAGE", this.h.getResources().getString(R.string.fotor_dialog_alert_message_plugin_update).replace("@FeatureName", this.h.getResources().getString(R.string.fotor_plugin_border)));
        paramBundle.putCharSequence("NEUTRAL_BUTTON_TEXT", paramPluginService.getText(17039370));
        this.L.setArguments(paramBundle);
        this.L.setCancelable(false);
        this.L.a(new FotorAlertDialog.a() {
            public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                e.this.a(true);
            }
        });
        this.L.a(paramPluginService.getSupportFragmentManager(), "Update Border Pack", true);
    }

    protected void a(List<EffectAbtractFeature.EffectPackInfo> paramList) {
        if (this.E) {
            localObject = new EffectAbtractFeature.EffectPackInfo();
            ((EffectAbtractFeature.EffectPackInfo) localObject).a = this.h.getText(R.string.fotor_store_title);
            ((EffectAbtractFeature.EffectPackInfo) localObject).c = EffectAbtractFeature.EffectPackInfo.EffectPackType.STORE;
            paramList.add(localObject);
        }
        this.C = 0;
        paramList.addAll(n());
        Object localObject = M();
        this.C += ((List) localObject).size();
        paramList.addAll((Collection) localObject);
        paramList.addAll(L());
    }

    protected void b() {
        if ((this.C <= 0) && (com.everimaging.fotorsdk.preference.a.h(this.h))) {
            P();
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, float paramFloat) {
        super.b(paramPurchasedPack, paramFloat);
        Object localObject = paramPurchasedPack.getPackName();
        paramPurchasedPack = paramPurchasedPack.getPackID();
        int i = (int) (100.0F * paramFloat);
        H.c(new Object[]{"Effect Pkg :" + (String) localObject + " download progress: " + i + "%"});
        localObject = this.s.a(paramPurchasedPack);
        if (localObject != null) {
            ((EffectAbtractFeature.EffectPackInfo) localObject).f = true;
            ((EffectAbtractFeature.EffectPackInfo) localObject).g = i;
            paramPurchasedPack = this.s.b(paramPurchasedPack);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a.a(i);
            }
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, int paramInt) {
        super.b(paramPurchasedPack, paramInt);
        String str = paramPurchasedPack.getPackID();
        H.d(new Object[]{"Border Pkg :" + paramPurchasedPack.getPackName() + " download failed! "});
        paramPurchasedPack = this.s.a(str);
        if (paramPurchasedPack != null) {
            paramPurchasedPack.f = false;
            paramPurchasedPack.g = 0;
            paramPurchasedPack = this.s.b(str);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a.b();
            }
        }
        if (!this.F.a()) {
            f.a(paramInt, this.h, this.a.g().getSupportFragmentManager());
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, String paramString) {
        super.b(paramPurchasedPack, paramString);
        String str = paramPurchasedPack.getPackID();
        H.d(new Object[]{"Border Pkg :" + paramPurchasedPack.getPackName() + " download success! "});
        EffectAbtractFeature.EffectPackInfo localEffectPackInfo = this.s.a(str);
        paramPurchasedPack = new FeatureDownloadedPack(str, paramPurchasedPack.getPackName(), 0, 0, 4, paramString);
        paramPurchasedPack = (com.everimaging.fotorsdk.plugins.c) h.a(this.h, paramPurchasedPack);
        if (localEffectPackInfo != null) {
            a(paramPurchasedPack, localEffectPackInfo);
            localEffectPackInfo.g = 0;
            localEffectPackInfo.f = false;
            this.s.notifyDataSetChanged();
            paramPurchasedPack = this.s.b(str);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a.b();
            }
        }
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_border_effect_operation_panel, null);
    }

    protected String c() {
        return com.everimaging.fotorsdk.store.utils.c.c;
    }

    protected void c(PurchasedPack paramPurchasedPack) {
        super.c(paramPurchasedPack);
        paramPurchasedPack = paramPurchasedPack.getPackID();
        EffectAbtractFeature.EffectPackInfo localEffectPackInfo = this.s.a(paramPurchasedPack);
        if (localEffectPackInfo != null) {
            localEffectPackInfo.f = true;
            localEffectPackInfo.g = 0;
            paramPurchasedPack = this.s.b(paramPurchasedPack);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a.a(0);
            }
        }
    }

    protected int e() {
        return 16;
    }

    public void f() {
        this.m = null;
        if (this.l != null) {
            this.l.b();
        }
        this.l = null;
        super.f();
    }

    protected void m() {
        super.m();
        this.m = new EffectsParams();
        this.l = new FxEffectFilter(this, this.d, this.w, this.m, FxEffectFilter.Level.MEDIUM);
    }

    protected void t() {
        super.t();
        this.I = new ArrayList();
        this.J = new com.everimaging.fotorsdk.database.helper.a(this.h);
    }

    protected void u() {
        super.u();
        this.u.setDividerWidth((int) this.h.getResources().getDimension(R.dimen.fotor_border_effect_listview_divider_width));
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.BORDER;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_border);
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private BorderInfo b;

        public a(EffectInfo paramEffectInfo) {
            this.b = ((BorderInfo) paramEffectInfo);
        }

        protected Void a(Void... paramVarArgs) {
            if (e.this.G()) {
                for (; ; ) {
                    synchronized (e.this.m) {
                        if ((e.this.m != null) && (e.this.l != null)) {
                            e.this.D = true;
                            EffectEntity localEffectEntity = this.b.effectEntity;
                            if ((localEffectEntity.getmFilters() == null) || (localEffectEntity.getmFilters().size() <= 0)) {
                                break label156;
                            }
                            paramVarArgs = (RSFrameBaseFilterParams) ((BaseFilterEntity) localEffectEntity.getmFilters().get(0)).getParams();
                            if (paramVarArgs != null) {
                                paramVarArgs.setThickness(this.b.mediumThickness);
                            }
                            e.this.m.setEffectEntity(localEffectEntity);
                            e.this.l.a();
                            if (paramVarArgs != null) {
                                paramVarArgs.setThickness(this.b.originalThickness);
                            }
                        }
                        return null;
                    }
                    label156:
                    paramVarArgs = null;
                }
            }
            return null;
        }

        protected void a(Void paramVoid) {
            e.this.D = false;
            if ((e.this.G()) && (e.this.n.getCurrentStatus() != 1)) {
                e.this.o.postInvalidate();
                e.this.o.f();
                e.this.B.setVisibility(8);
            }
            e.a(e.this, null);
            if (e.this.n.getCurrentStatus() == 2) {
                e.this.C();
                if (e.this.b != null) {
                    if (!e.this.i) {
                        break label152;
                    }
                    e.this.b.a(e.this, e.this.w, new BaseParams[]{e.this.m});
                }
            }
            return;
            label152:
            e.this.b.a(e.this);
        }

        protected void b(Void paramVoid) {
            e.this.D = false;
        }

        protected void onPreExecute() {
            e.this.B.setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */