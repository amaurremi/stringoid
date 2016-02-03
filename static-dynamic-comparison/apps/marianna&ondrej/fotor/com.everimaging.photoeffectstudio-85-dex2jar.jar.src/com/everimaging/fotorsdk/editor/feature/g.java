package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.xml.d;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.app.FotorAlertDialog;
import com.everimaging.fotorsdk.app.FotorAlertDialog.a;
import com.everimaging.fotorsdk.database.helper.b;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.raw;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.editor.filter.params.EffectsParams;
import com.everimaging.fotorsdk.entity.EffectConfig;
import com.everimaging.fotorsdk.entity.EffectConfig.EffectItem;
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
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils.ResizeMode;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.SimpleStatusMachine;
import com.everimaging.fotorsdk.widget.FotorGuideView;
import com.everimaging.fotorsdk.widget.FotorGuideView.a;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class g
        extends EffectAbtractFeature
        implements FotorGuideView.a {
    private static final String l = g.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private List<EffectInfo> G;
    private b H;
    private FrameLayout I;
    private FotorSliderPanelLayout J;
    private ImageButton K;
    private ImageButton L;
    private ImageButton M;
    private FxEffectFilter N;
    private EffectsParams O;
    private EffectAbtractFeature.EffectPackInfo P;
    private LinkedList<FxEffectFilter> Q;
    private FotorAlertDialog R;
    private a S;
    private Toast T;
    private FotorGuideView U;
    private boolean V = true;
    private boolean W;
    private Handler X;
    private BaseParams[] Y;
    private View.OnClickListener Z = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if ((g.this.n.getCurrentStatus() == 0) && (!g.a(g.this))) {
                g.a(g.this, true);
                if (paramAnonymousView != g.b(g.this)) {
                    break label73;
                }
                g.c(g.this);
            }
            for (; ; ) {
                g.g(g.this).postDelayed(new Runnable() {
                    public void run() {
                        g.a(g.this, false);
                    }
                }, 50L);
                return;
                label73:
                if (paramAnonymousView == g.d(g.this)) {
                    g.e(g.this);
                } else if (paramAnonymousView != g.f(g.this)) {
                }
            }
        }
    };
    private FotorSliderPanelLayout.a aa = new FotorSliderPanelLayout.a() {
        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
        }

        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout, int paramAnonymousInt, boolean paramAnonymousBoolean) {
            if (paramAnonymousBoolean) {
                g.b(g.this, paramAnonymousInt);
                paramAnonymousFotorSliderPanelLayout.setDisplayValue(String.valueOf(paramAnonymousInt));
            }
        }

        public void b(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
            if ((g.this.v.a() == -1) && (g.h(g.this).size() > 1)) {
                g.d().c(new Object[]{"do pre effect filter effects"});
                Bitmap localBitmap = g.a(g.this, g.i(g.this).c());
                g.b(g.this, localBitmap);
            }
            g.a(g.this, paramAnonymousFotorSliderPanelLayout.getSeekBar().getProgress());
        }
    };

    public g(com.everimaging.fotorsdk.editor.c paramc) {
        super(paramc);
    }

    private void L() {
        synchronized (this.Q) {
            m.c(new Object[]{"minusFxEffect:" + this.Q.size() + ","});
            ((FxEffectFilter) this.Q.removeLast()).b();
            this.v.b(-1);
            FxEffectFilter localFxEffectFilter = (FxEffectFilter) this.Q.getLast();
            localFxEffectFilter.e();
            localFxEffectFilter.f().setEffectEntity(null);
            if (this.Q.size() == 1) {
                b(false);
                this.N = localFxEffectFilter;
                this.O = localFxEffectFilter.f();
                this.w = localFxEffectFilter.c();
                this.o.setImageBitmap(this.w);
                b(a(this.N.c()));
                this.L.setEnabled(false);
                this.J.setProgress((int) this.O.getDisplayBlend());
                return;
            }
            localFxEffectFilter = (FxEffectFilter) this.Q.get(this.Q.size() - 2);
        }
    }

    private void M() {
        Bitmap localBitmap;
        FxEffectFilter localFxEffectFilter;
        synchronized (this.Q) {
            if ((this.N == null) || (this.O == null)) {
                throw new IllegalStateException("invalide state current filter is null");
            }
        }
    }

    private void N() {
        if (com.everimaging.fotorsdk.preference.a.f(this.h)) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            localLayoutParams.gravity = 48;
            this.U = new FotorGuideView(this.h);
            this.U.setGuideViewListener(this);
            this.a.b(this.U, localLayoutParams);
            this.a.e().post(new Runnable() {
                public void run() {
                    g.j(g.this).a(R.raw.fotor_guide_effect_config);
                }
            });
        }
    }

    private List<EffectAbtractFeature.EffectPackInfo> O() {
        ArrayList localArrayList = new ArrayList();
        FeatureExternalPack[] arrayOfFeatureExternalPack = this.A.b(2);
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

    private List<EffectAbtractFeature.EffectPackInfo> P() {
        ArrayList localArrayList = new ArrayList();
        FeaturePurchasedPack[] arrayOfFeaturePurchasedPack = this.A.c(2);
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

    private List<EffectAbtractFeature.EffectPackInfo> Q() {
        ArrayList localArrayList = new ArrayList();
        FeatureInternalPack[] arrayOfFeatureInternalPack = this.A.a(this.h, 2);
        m.c(new Object[]{"installedPack size:" + arrayOfFeatureInternalPack.length});
        int i = 0;
        if (i < arrayOfFeatureInternalPack.length) {
            Object localObject = arrayOfFeatureInternalPack[i];
            m.c(new Object[]{"Pack:" + localObject});
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

    private BaseParams[] R() {
        for (; ; ) {
            int i;
            int j;
            synchronized (this.Q) {
                Object localObject1 = (FxEffectFilter) this.Q.getLast();
                i = this.Q.size();
                if ((((FxEffectFilter) localObject1).f() == null) || (((FxEffectFilter) localObject1).f().getEffectEntity() == null) || (((FxEffectFilter) localObject1).f().getEffectEntity().getID() == -1)) {
                    break label181;
                }
                if (((FxEffectFilter) localObject1).f().getBlend() == 0.0F) {
                    break label181;
                    localObject1 = new ArrayList();
                    if (i > 0) {
                        j = 0;
                        if (j < i) {
                            FxEffectFilter localFxEffectFilter = (FxEffectFilter) this.Q.get(j);
                            if ((localFxEffectFilter == null) || (localFxEffectFilter.f() == null) || (localFxEffectFilter.f().getEffectEntity() == null)) {
                                break label188;
                            }
                            ((ArrayList) localObject1).add(localFxEffectFilter.f());
                            break label188;
                        }
                    }
                    localObject1 = (BaseParams[]) ((ArrayList) localObject1).toArray(new BaseParams[((ArrayList) localObject1).size()]);
                    return (BaseParams[]) localObject1;
                }
            }
            continue;
            label181:
            i -= 1;
            continue;
            label188:
            j += 1;
        }
    }

    private boolean S() {
        if (this.S != null) {
            return this.S.cancel(true);
        }
        return false;
    }

    private void T() {
        synchronized (this.Q) {
            FxEffectFilter localFxEffectFilter = (FxEffectFilter) this.Q.getLast();
            if ((localFxEffectFilter.f() != null) && (localFxEffectFilter.f().getEffectEntity() != null)) {
                this.v.a(localFxEffectFilter.f().getEffectEntity());
            }
            return;
        }
    }

    private void U() {
        try {
            com.everimaging.fotorsdk.preference.a.f(this.h, false);
            FragmentActivity localFragmentActivity = this.a.a().q();
            Object localObject = localFragmentActivity.getSupportFragmentManager().findFragmentByTag("Install_Effect");
            m.c(new Object[]{"showing dialog:" + localObject});
            if (localObject != null) {
                m.d(new Object[]{"install dialog is showing will return."});
                return;
            }
            localObject = new Bundle();
            ((Bundle) localObject).putCharSequence("MESSAGE", this.h.getResources().getText(R.string.fotor_fx_effect_no_pack_alert_message));
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
            localFotorAlertDialog.a(localFragmentActivity.getSupportFragmentManager(), "Install_Effect", true);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private Bitmap a(Bitmap paramBitmap)
            throws OutOfMemoryError {
        Bitmap localBitmap = BitmapUtils.resizeBitmap(paramBitmap, this.y, this.z, BitmapUtils.ResizeMode.CENTER_CROP);
        paramBitmap = localBitmap;
        if (localBitmap != null) {
            paramBitmap = localBitmap;
            if (localBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                paramBitmap = BitmapUtils.copy(localBitmap, Bitmap.Config.ARGB_8888);
            }
        }
        return paramBitmap;
    }

    private EffectAbtractFeature.EffectPackInfo a(com.everimaging.fotorsdk.plugins.g paramg) {
        EffectAbtractFeature.EffectPackInfo localEffectPackInfo = new EffectAbtractFeature.EffectPackInfo();
        a(paramg, localEffectPackInfo);
        return localEffectPackInfo;
    }

    private void a(final EffectAbtractFeature.EffectPackInfo paramEffectPackInfo, Bitmap paramBitmap) {
        this.v = new com.everimaging.fotorsdk.editor.adapter.a(this.h, paramEffectPackInfo.d, new EffectThumbLoader.EffectThumbProcessor() {
            public Bitmap processBitmap(EffectInfo paramAnonymousEffectInfo, Bitmap paramAnonymousBitmap) {
                try {
                    g.d().c(new Object[]{"EffectThumbProcessor ->processBitmap"});
                    Object localObject = new EffectsParams();
                    ((EffectsParams) localObject).setEffectEntity(paramAnonymousEffectInfo.effectEntity);
                    Context localContext = g.this.h;
                    paramAnonymousEffectInfo = paramAnonymousBitmap;
                    if (localContext != null) {
                        paramAnonymousEffectInfo = paramAnonymousBitmap;
                    }
                    try {
                        localObject = new FxEffectFilter(g.this, paramAnonymousBitmap, null, (EffectsParams) localObject, FxEffectFilter.Level.SMALL);
                        paramAnonymousEffectInfo = paramAnonymousBitmap;
                        ((FxEffectFilter) localObject).a((com.everimaging.fotorsdk.plugins.g) paramEffectPackInfo.e);
                        paramAnonymousEffectInfo = paramAnonymousBitmap;
                        paramAnonymousBitmap = ((FxEffectFilter) localObject).a();
                        paramAnonymousEffectInfo = paramAnonymousBitmap;
                        ((FxEffectFilter) localObject).b();
                        paramAnonymousEffectInfo = paramAnonymousBitmap;
                    } catch (Exception paramAnonymousBitmap) {
                        for (; ; ) {
                            paramAnonymousBitmap.printStackTrace();
                        }
                    }
                    return paramAnonymousEffectInfo;
                } finally {
                }
            }
        }, paramBitmap);
        this.u.setAdapter(this.v);
        T();
    }

    private void a(EffectInfo paramEffectInfo) {
        boolean bool = S();
        m.c(new Object[]{"cancel pre fx success?:" + bool});
        this.S = new a(true, paramEffectInfo.effectEntity, 100);
        this.S.execute(new Void[0]);
    }

    private void a(com.everimaging.fotorsdk.plugins.g paramg, EffectAbtractFeature.EffectPackInfo paramEffectPackInfo) {
        h.a locala = (h.a) paramg;
        paramEffectPackInfo.b = paramg.a();
        m.c(new Object[]{"packName:" + paramEffectPackInfo.a});
        paramEffectPackInfo.c = EffectAbtractFeature.EffectPackInfo.EffectPackType.NORMAL;
        paramEffectPackInfo.e = paramg;
        Object localObject = locala.b();
        if (localObject == null) {
        }
        do {
            return;
            paramg = (EffectConfig) new GsonBuilder().create().fromJson(new InputStreamReader((InputStream) localObject), EffectConfig.class);
            paramEffectPackInfo.a = paramg.title;
            FotorIOUtils.closeSilently((Closeable) localObject);
        } while ((paramg == null) || (paramg.classes == null) || (paramg.classes.size() == 0));
        localObject = new ArrayList();
        d locald = new d();
        int i = 0;
        if (i < paramg.classes.size()) {
            EffectInfo localEffectInfo = new EffectInfo();
            EffectConfig.EffectItem localEffectItem = (EffectConfig.EffectItem) paramg.classes.get(i);
            InputStream localInputStream = locala.a(localEffectItem.algorithm_file);
            if (localInputStream == null) {
            }
            for (; ; ) {
                i += 1;
                break;
                locald.a(localInputStream);
                FotorIOUtils.closeSilently(localInputStream);
                localEffectInfo.effectEntity = locald.a();
                localEffectInfo.title = localEffectItem.title;
                ((List) localObject).add(localEffectInfo);
            }
        }
        paramEffectPackInfo.d = ((List) localObject);
    }

    private boolean a(Bundle paramBundle) {
        if ((paramBundle != null) && (paramBundle.containsKey("internal_update_plugins"))) {
            paramBundle = (ArrayList) paramBundle.getSerializable("internal_update_plugins");
            m.c(new Object[]{"updateTypes:" + paramBundle});
            if ((paramBundle != null) && (paramBundle.size() > 0)) {
                paramBundle = paramBundle.iterator();
                while (paramBundle.hasNext()) {
                    if (FeaturePack.b.b(((UpdateType) paramBundle.next()).getPluginType())) {
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

    private void b(int paramInt) {
        if ((this.N != null) && (this.O != null)) {
            this.O.setBlend(paramInt);
            this.N.g();
        }
    }

    private void b(Bitmap paramBitmap) {
        if (this.v != null) {
            this.v.a(paramBitmap);
        }
    }

    private void b(boolean paramBoolean) {
        this.K.setEnabled(paramBoolean);
        this.L.setEnabled(paramBoolean);
        this.M.setEnabled(paramBoolean);
        FrameLayout localFrameLayout = this.I;
        if (paramBoolean) {
        }
        for (int i = 0; ; i = 4) {
            localFrameLayout.setVisibility(i);
            return;
        }
    }

    private void c(int paramInt) {
        m.c(new Object[]{"doFxEffectBlendOnStop:" + paramInt});
        b(paramInt);
    }

    public void A() {
        if (this.n.getCurrentStatus() == 2) {
        }
        do {
            return;
            this.n.setStatus(2);
        } while ((this.b == null) || (this.D));
        this.b.a(this, this.w, this.Y);
    }

    public boolean B() {
        S();
        return super.B();
    }

    protected void C() {
        super.C();
        BaseParams[] arrayOfBaseParams = R();
        if (((arrayOfBaseParams == null) || (arrayOfBaseParams.length == 0)) && (!this.D)) {
            this.i = false;
        }
        this.Y = arrayOfBaseParams;
    }

    protected void E() {
        Object localObject2 = "Unknow";
        Object localObject1 = localObject2;
        String str;
        if (this.O != null) {
            localObject1 = localObject2;
            if (this.O.getEffectEntity() != null) {
                localObject2 = "" + this.O.getEffectEntity().getID();
                localObject1 = localObject2;
                if (this.O.getFeaturePack() != null) {
                    str = this.O.getFeaturePack().getPackName();
                }
            }
        }
        for (; ; ) {
            Object localObject3 = "Single_Effect";
            localObject1 = localObject3;
            if (this.Q != null) {
                localObject1 = localObject3;
                if (this.Q.size() >= 2) {
                    if (this.Q.size() != 2) {
                        break label230;
                    }
                    localObject1 = (FxEffectFilter) this.Q.getLast();
                    if ((((FxEffectFilter) localObject1).f() != null) && (((FxEffectFilter) localObject1).f().getEffectEntity() != null) && (((FxEffectFilter) localObject1).f().getEffectEntity().getID() != -1) && (((FxEffectFilter) localObject1).f().getBlend() != 0.0F)) {
                        break label230;
                    }
                }
            }
            label230:
            for (localObject1 = "Single_Effect"; ; localObject1 = "Multi_Effects") {
                localObject3 = new HashMap();
                ((Map) localObject3).put("Effect_Category", str);
                ((Map) localObject3).put("Effect_Class", localObject2);
                ((Map) localObject3).put(localObject1, "1");
                com.everimaging.fotorsdk.a.a("EDIT_FX_APPLY", (Map) localObject3);
                return;
            }
            str = "Unknow";
            localObject2 = localObject1;
        }
    }

    protected void a() {
        super.a();
    }

    protected void a(EffectAbtractFeature.EffectPackInfo paramEffectPackInfo) {
        m.c(new Object[]{"onCategoryItemClick"});
        if (paramEffectPackInfo.c == EffectAbtractFeature.EffectPackInfo.EffectPackType.NORMAL) {
            this.p.setVisibility(8);
            this.t.setVisibility(0);
            if (this.P == paramEffectPackInfo) {
                m.c(new Object[]{"pre categoryinfo == current info"});
            }
        }
        while (paramEffectPackInfo.c != EffectAbtractFeature.EffectPackInfo.EffectPackType.EXTERNAL) {
            return;
            Object localObject = this.x;
            synchronized (this.Q) {
                if (this.Q.size() > 1) {
                    localObject = a(((FxEffectFilter) this.Q.getLast()).d());
                }
                a(paramEffectPackInfo, (Bitmap) localObject);
                this.P = paramEffectPackInfo;
                localObject = "Unknow";
                paramEffectPackInfo = (EffectAbtractFeature.EffectPackInfo) localObject;
                if (this.P != null) {
                    paramEffectPackInfo = (EffectAbtractFeature.EffectPackInfo) localObject;
                    if (!TextUtils.isEmpty(this.P.a)) {
                        paramEffectPackInfo = this.P.a.toString();
                    }
                }
                localObject = new HashMap();
                ((Map) localObject).put("Effect_Category", paramEffectPackInfo);
                com.everimaging.fotorsdk.a.a("EDIT_FX_ITEM_TAP", (Map) localObject);
                return;
            }
        }
        Toast.makeText(this.h, "Coming soon", 0).show();
    }

    protected void a(EffectInfo paramEffectInfo, int paramInt) {
        m.c(new Object[]{"onEffectItemClick :" + paramEffectInfo});
        if (this.V) {
            N();
            this.V = false;
        }
        this.i = true;
        synchronized (this.Q) {
            this.N = ((FxEffectFilter) this.Q.getLast());
            this.N.a((com.everimaging.fotorsdk.plugins.g) this.P.e);
            this.O = this.N.f();
            this.w = this.N.c();
            this.o.setImageBitmap(this.w);
            this.J.setProgress(100);
            a(paramEffectInfo);
            this.v.b(paramInt);
            this.L.setEnabled(true);
            this.I.setVisibility(0);
            return;
        }
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        m.c(new Object[]{"====onUpdate===="});
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
            Fragment localFragment = paramPluginService.getSupportFragmentManager().findFragmentByTag("Update Fx Effect Pack");
            m.c(new Object[]{"showing dialog:" + localFragment});
            if (localFragment != null) {
                m.d(new Object[]{"update alert dialog is showing will return."});
                return;
            }
        } while (!a(paramBundle));
        paramBundle = new Bundle();
        paramBundle.putCharSequence("MESSAGE", this.h.getResources().getString(R.string.fotor_dialog_alert_message_plugin_update).replace("@FeatureName", this.h.getResources().getString(R.string.fotor_plugin_effect)));
        paramBundle.putCharSequence("NEUTRAL_BUTTON_TEXT", paramPluginService.getText(17039370));
        this.R = FotorAlertDialog.a();
        this.R.setArguments(paramBundle);
        this.R.setCancelable(false);
        this.R.a(new FotorAlertDialog.a() {
            public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                g.this.a(true);
            }
        });
        this.R.a(paramPluginService.getSupportFragmentManager(), "Update Fx Effect Pack", true);
    }

    protected void a(List<EffectAbtractFeature.EffectPackInfo> paramList) {
        if (this.E) {
            localObject = new EffectAbtractFeature.EffectPackInfo();
            ((EffectAbtractFeature.EffectPackInfo) localObject).a = this.h.getText(R.string.fotor_store_title);
            ((EffectAbtractFeature.EffectPackInfo) localObject).c = EffectAbtractFeature.EffectPackInfo.EffectPackType.STORE;
            paramList.add(localObject);
        }
        this.C = 0;
        paramList.addAll(O());
        Object localObject = Q();
        this.C += ((List) localObject).size();
        paramList.addAll((Collection) localObject);
        paramList.addAll(P());
    }

    protected void b() {
        if ((this.C <= 0) && (com.everimaging.fotorsdk.preference.a.g(this.h))) {
            U();
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, float paramFloat) {
        super.b(paramPurchasedPack, paramFloat);
        Object localObject = paramPurchasedPack.getPackName();
        paramPurchasedPack = paramPurchasedPack.getPackID();
        int i = (int) (100.0F * paramFloat);
        m.c(new Object[]{"Effect Pkg :" + (String) localObject + " download progress: " + i + "%"});
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
        m.d(new Object[]{"Effect Pkg :" + paramPurchasedPack.getPackName() + " download failed! "});
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
        Object localObject = paramPurchasedPack.getPackName();
        String str = paramPurchasedPack.getPackID();
        m.d(new Object[]{"Effect Pkg :" + (String) localObject + " download success! "});
        localObject = this.s.a(str);
        paramPurchasedPack = new FeatureDownloadedPack(str, paramPurchasedPack.getPackName(), 0, 0, 4, paramString);
        paramPurchasedPack = (com.everimaging.fotorsdk.plugins.c) h.a(this.h, paramPurchasedPack);
        if (localObject != null) {
            a(paramPurchasedPack, (EffectAbtractFeature.EffectPackInfo) localObject);
            ((EffectAbtractFeature.EffectPackInfo) localObject).g = 0;
            ((EffectAbtractFeature.EffectPackInfo) localObject).f = false;
            this.s.notifyDataSetChanged();
            paramPurchasedPack = this.s.b(str);
            if (paramPurchasedPack != null) {
                paramPurchasedPack.a.b();
            }
        }
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_fx_effect_operation_panel, null);
    }

    protected String c() {
        return com.everimaging.fotorsdk.store.utils.c.a;
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
        return 8;
    }

    public void f() {
        super.f();
        Iterator localIterator = this.Q.iterator();
        while (localIterator.hasNext()) {
            ((FxEffectFilter) localIterator.next()).b();
        }
        this.Q = null;
    }

    protected void m() {
        super.m();
        synchronized (this.Q) {
            this.Q.clear();
            Object localObject1 = new EffectsParams();
            localObject1 = new FxEffectFilter(this, this.d, this.w, (EffectsParams) localObject1, FxEffectFilter.Level.MEDIUM);
            this.Q.add(localObject1);
            return;
        }
    }

    public void n() {
        this.a.d(this.U);
        com.everimaging.fotorsdk.preference.a.e(this.h, false);
        this.U = null;
    }

    protected void p() {
        super.p();
        this.a.a(null);
    }

    protected void t() {
        super.t();
        this.G = new ArrayList();
        this.H = new b(this.h);
        this.Q = new LinkedList();
        this.X = new Handler(this.h.getMainLooper());
    }

    protected void u() {
        super.u();
        this.I = ((FrameLayout) LayoutInflater.from(this.h).inflate(R.layout.fotor_feature_fx_effect_operation_tools, null));
        this.J = ((FotorSliderPanelLayout) this.I.findViewById(R.id.fotor_fx_effect_blend_slider));
        this.J.setOnChangedListener(this.aa);
        this.K = ((ImageButton) this.I.findViewById(R.id.fotor_fx_effect_minus));
        this.K.setOnClickListener(this.Z);
        this.L = ((ImageButton) this.I.findViewById(R.id.fotor_fx_effect_add));
        this.L.setOnClickListener(this.Z);
        this.M = ((ImageButton) this.I.findViewById(R.id.fotor_fx_effect_favorites));
        this.M.setOnClickListener(this.Z);
        this.a.a(this.I);
        b(false);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.FX_EFFECTS;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_fx_effects);
    }

    public boolean z() {
        if (this.U != null) {
            this.U.a();
            return true;
        }
        return super.z();
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private EffectEntity b;

        public a(boolean paramBoolean, EffectEntity paramEffectEntity, int paramInt) {
            this.b = paramEffectEntity;
        }

        protected Void a(Void... arg1) {
            synchronized (g.k(g.this)) {
                if ((g.k(g.this) != null) && (g.i(g.this) != null)) {
                    g.this.D = true;
                }
                try {
                    g.k(g.this).setBlend(100.0F);
                    g.k(g.this).setEffectEntity(this.b);
                    g.i(g.this).a();
                    return null;
                } catch (Exception localException) {
                    for (; ; ) {
                        g.d().e(new Object[]{"do fx error:" + localException.getMessage()});
                    }
                }
            }
        }

        protected void a(Void paramVoid) {
            g.this.D = false;
            if ((g.this.G()) && (g.this.n.getCurrentStatus() != 1)) {
                g.this.o.postInvalidate();
                g.this.B.setVisibility(8);
                g.l(g.this).setEnabled(true);
            }
            g.a(g.this, null);
            if (g.this.n.getCurrentStatus() == 2) {
                g.this.C();
                if (g.this.b != null) {
                    if (!g.this.i) {
                        break label146;
                    }
                    g.this.b.a(g.this, g.this.w, g.m(g.this));
                }
            }
            return;
            label146:
            g.this.b.a(g.this);
        }

        protected void b(Void paramVoid) {
            g.d().c(new Object[]{"onCancelled"});
            g.this.D = false;
        }

        protected void onPreExecute() {
            g.this.B.setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */