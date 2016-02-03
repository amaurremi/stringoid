package com.everimaging.fotorsdk.services;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.DownloadPackConfigInfo;
import com.everimaging.fotorsdk.plugins.FeatureBindPack;
import com.everimaging.fotorsdk.plugins.FeatureDownloadedPack;
import com.everimaging.fotorsdk.plugins.FeatureExternalPack;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack.b;
import com.everimaging.fotorsdk.plugins.FeaturePurchasedPack;
import com.everimaging.fotorsdk.plugins.UpdateType;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;
import com.everimaging.fotorsdk.utils.Utils;
import com.google.gson.Gson;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class PluginService
        extends BaseService {
    private static final String b = PluginService.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    private final Object d = new Object();
    private final Object e = new Object();
    private final Object f = new Object();
    private List<FeatureInternalPack> g = new ArrayList();
    private List<FeatureInternalPack> h = new ArrayList();
    private List<FeatureInternalPack> i = new ArrayList();
    private List<FeatureInternalPack> j = new ArrayList();
    private List<FeatureInternalPack> k = new ArrayList();
    private List<FeatureInternalPack> l = new ArrayList();
    private List<FeatureInternalPack> m = new ArrayList();
    private SparseArray<ArrayList<FeatureExternalPack>> n = new SparseArray();
    private SparseArray<ArrayList<FeatureExternalPack>> o = new SparseArray();
    private Map<String, FeaturePurchasedPack> p = new LinkedHashMap();
    private Map<String, FeatureDownloadedPack> q = new LinkedHashMap();
    private Map<String, FeatureInternalPack> r = new HashMap();
    private List<f> s = new ArrayList();
    private List<e> t = new ArrayList();
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private SparseBooleanArray y = new SparseBooleanArray();

    public PluginService(Context paramContext) {
        super(paramContext);
        if (this.x) {
            e();
        }
        f();
    }

    private static FeatureDownloadedPack a(File paramFile, int paramInt) {
        DownloadPackConfigInfo localDownloadPackConfigInfo = null;
        String[] arrayOfString = paramFile.list();
        Object localObject = localDownloadPackConfigInfo;
        int i1;
        if (arrayOfString != null) {
            int i2 = arrayOfString.length;
            i1 = 0;
            localObject = localDownloadPackConfigInfo;
            if (i1 < i2) {
                localObject = arrayOfString[i1];
                if (!((String) localObject).equals("config.json")) {
                    break label149;
                }
            }
        }
        for (; ; ) {
            try {
                localObject = new FileReader(new File(paramFile, (String) localObject));
                localDownloadPackConfigInfo = (DownloadPackConfigInfo) new Gson().fromJson((Reader) localObject, DownloadPackConfigInfo.class);
                FotorIOUtils.closeSilently((Closeable) localObject);
                if (localDownloadPackConfigInfo == null) {
                    break label156;
                }
                paramFile = new FeatureDownloadedPack(localDownloadPackConfigInfo.getPackage_key(), localDownloadPackConfigInfo.getTitle(), Integer.parseInt(localDownloadPackConfigInfo.getVersion()), Integer.parseInt(localDownloadPackConfigInfo.getVersion()), paramInt, paramFile.getAbsolutePath());
                localObject = paramFile;
                return (FeatureDownloadedPack) localObject;
            } catch (Exception paramFile) {
                paramFile.printStackTrace();
                return null;
            }
            label149:
            i1 += 1;
            break;
            label156:
            paramFile = null;
        }
    }

    public static List<FeatureInternalPack> a(Context paramContext) {
        long l1 = System.currentTimeMillis();
        c.f(new Object[]{"fetchInstalledPlugins"});
        Object localObject1 = PackageManagerUtils.fetchInstalledApplications(paramContext);
        ArrayList localArrayList = new ArrayList();
        localObject1 = ((List) localObject1).iterator();
        Object localObject2;
        String str;
        int[] arrayOfInt;
        PackageInfo localPackageInfo;
        Resources localResources;
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = new ApplicationInfo((ApplicationInfo) ((Iterator) localObject1).next());
            str = ((ApplicationInfo) localObject2).packageName;
            localObject2 = ((ApplicationInfo) localObject2).name;
            arrayOfInt = new int[1];
            if (FeaturePack.b.a(paramContext, str, arrayOfInt, new int[1], new int[1])) {
                localPackageInfo = PackageManagerUtils.getPackageInfo(paramContext, str, 0);
                localResources = PackageManagerUtils.getApplicationResource(paramContext, str);
                if (localResources == null) {
                    break label307;
                }
                i1 = localResources.getIdentifier("fotor_pulgin_version", "integer", str);
                if (i1 == 0) {
                    break label307;
                }
            }
        }
        label307:
        for (int i1 = localResources.getInteger(i1); ; i1 = 0) {
            if (localPackageInfo != null) {
            }
            for (int i2 = localPackageInfo.versionCode; ; i2 = 0) {
                localObject2 = new FeatureInternalPack(str, (String) localObject2, i2, i1, arrayOfInt[0]);
                c.b(new Object[]{"adding: " + str + ", " + ((FeatureInternalPack) localObject2).getPackageVersionCode()});
                localArrayList.add(localObject2);
                break;
            }
            long l2 = System.currentTimeMillis();
            c.b(new Object[]{"completed fetchInstalledPlugins in " + (l2 - l1)});
            a(localArrayList, paramContext);
            return localArrayList;
        }
    }

    private void a(FeatureInternalPack paramFeatureInternalPack, boolean paramBoolean) {
        int i1 = paramFeatureInternalPack.getPluginType();
        String str = paramFeatureInternalPack.getPackID();
        if (this.r.containsKey(str)) {
            c.d(new Object[]{"packID:" + str + " was added"});
        }
        label163:
        label198:
        label233:
        label268:
        label303:
        do {
            return;
            c.b(new Object[]{"handlePackage: " + paramFeatureInternalPack.toString()});
            if (FeaturePack.b.a(i1)) {
                if (!paramBoolean) {
                    break;
                }
                this.i.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
            if (FeaturePack.b.b(i1)) {
                if (!paramBoolean) {
                    break label366;
                }
                this.g.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
            if (FeaturePack.b.c(i1)) {
                if (!paramBoolean) {
                    break label380;
                }
                this.h.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
            if (FeaturePack.b.d(i1)) {
                if (!paramBoolean) {
                    break label394;
                }
                this.j.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
            if (FeaturePack.b.e(i1)) {
                if (!paramBoolean) {
                    break label408;
                }
                this.k.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
            if (FeaturePack.b.f(i1)) {
                if (!paramBoolean) {
                    break label422;
                }
                this.l.add(0, paramFeatureInternalPack);
                this.r.put(str, paramFeatureInternalPack);
            }
        } while (!FeaturePack.b.g(i1));
        if (paramBoolean) {
            this.m.add(0, paramFeatureInternalPack);
        }
        for (; ; ) {
            this.r.put(str, paramFeatureInternalPack);
            return;
            this.i.add(paramFeatureInternalPack);
            break;
            label366:
            this.g.add(paramFeatureInternalPack);
            break label163;
            label380:
            this.h.add(paramFeatureInternalPack);
            break label198;
            label394:
            this.j.add(paramFeatureInternalPack);
            break label233;
            label408:
            this.k.add(paramFeatureInternalPack);
            break label268;
            label422:
            this.l.add(paramFeatureInternalPack);
            break label303;
            this.m.add(paramFeatureInternalPack);
        }
    }

    private void a(d paramd) {
        c.c(new Object[]{"update plugins"});
        boolean bool = this.u;
        long l1 = System.currentTimeMillis();
        synchronized (this.d) {
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.r.clear();
            Iterator localIterator = paramd.a.iterator();
            if (localIterator.hasNext()) {
                a((FeatureInternalPack) localIterator.next(), false);
            }
        }
        this.u = true;
        if (bool) {
            a(paramd.b);
        }
        long l2 = System.currentTimeMillis();
        c.c(new Object[]{"update plugins speed:", Long.valueOf(l2 - l1)});
    }

    private static void a(List<FeatureInternalPack> paramList, Context paramContext) {
        a(paramList, paramContext, "border_config", 4);
        a(paramList, paramContext, "fx_config", 2);
        a(paramList, paramContext, "stickers_config", 3);
        a(paramList, paramContext, "fonts_config", 6);
        a(paramList, paramContext, "collage_template_config", 7);
        a(paramList, paramContext, "collage_poster_config", 8);
        a(paramList, paramContext, "collage_background_config", 9);
    }

    private static void a(List<FeatureInternalPack> paramList, Context paramContext, String paramString, int paramInt) {
        for (; ; ) {
            int i1;
            try {
                String[] arrayOfString = paramContext.getAssets().list(paramString);
                i1 = 0;
                int i2 = arrayOfString.length;
                if (i1 < i2) {
                    Object localObject = arrayOfString[i1];
                    try {
                        localObject = paramContext.getAssets().open(paramString + File.separator + (String) localObject + "/config.json");
                        String str = Utils.readStringFromInputStream((InputStream) localObject);
                        FotorIOUtils.closeSilently((Closeable) localObject);
                        if (TextUtils.isEmpty(str)) {
                            break label183;
                        }
                        localObject = new JSONObject(str).getString("title");
                        paramList.add(new FeatureBindPack(paramContext.getPackageName(), (String) localObject, 0, 0, paramInt));
                    } catch (Exception localException) {
                    }
                }
                return;
            } catch (Exception paramList) {
                c.e(new Object[]{"load item error:" + paramList.getMessage()});
            }
            label183:
            i1 += 1;
        }
    }

    public static Map<String, FeatureDownloadedPack> b(Context paramContext) {
        long l1 = System.currentTimeMillis();
        c.f(new Object[]{"fetchDownloadedPlugins"});
        paramContext = new String[7];
        paramContext[0] = FotorCommonDirUtils.getDownloadBorderPath();
        paramContext[1] = FotorCommonDirUtils.getDownloadEffectPath();
        paramContext[2] = FotorCommonDirUtils.getDownloadFontPath();
        paramContext[3] = FotorCommonDirUtils.getDownloadStickerPath();
        paramContext[4] = FotorCommonDirUtils.getDownloadCollageClassicPath();
        paramContext[5] = FotorCommonDirUtils.getDownloadCollageMagazinePath();
        paramContext[6] = FotorCommonDirUtils.getDownloadCollagePatternPath();
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        if (new File(FotorCommonDirUtils.getDownloadPath()).exists()) {
            int i1 = 0;
            while (i1 < paramContext.length) {
                File localFile1 = new File(paramContext[i1]);
                if (localFile1.exists()) {
                    String[] arrayOfString = localFile1.list();
                    if (arrayOfString != null) {
                        int i4 = arrayOfString.length;
                        int i2 = 0;
                        if (i2 < i4) {
                            File localFile2 = new File(localFile1, arrayOfString[i2]);
                            Object localObject = a(localFile2, new int[]{4, 2, 6, 3, 7, 8, 9}[i1]);
                            if (localObject != null) {
                                localLinkedHashMap.put(((FeatureDownloadedPack) localObject).getPackID(), localObject);
                            }
                            for (; ; ) {
                                i2 += 1;
                                break;
                                localObject = localFile2.list();
                                if (localObject != null) {
                                    int i5 = localObject.length;
                                    int i3 = 0;
                                    while (i3 < i5) {
                                        new File(localFile2, localObject[i3]).delete();
                                        i3 += 1;
                                    }
                                }
                            }
                        }
                    }
                }
                i1 += 1;
            }
        }
        long l2 = System.currentTimeMillis();
        c.b(new Object[]{"completed fetchDownloadedPlugins in " + (l2 - l1)});
        return localLinkedHashMap;
    }

    private void b(Bundle paramBundle) {
        if (paramBundle == null) {
            return;
        }
        String str1 = paramBundle.getString("APPLICATION_CONTEXT");
        int i1 = paramBundle.getInt("PLUGIN_TYPE");
        String str2 = paramBundle.getString("PACKAGE_NAME");
        paramBundle = paramBundle.getString("ACTION");
        c.f(new Object[]{"printBundle ==============="});
        c.b(new Object[]{"context:    " + str1});
        c.b(new Object[]{"package:    " + str2});
        c.b(new Object[]{"action:     " + paramBundle});
        c.b(new Object[]{"pluginType: " + i1});
        c.b(new Object[]{"==========================="});
    }

    private List<FeatureInternalPack> c(Context paramContext) {
        ArrayList localArrayList = new ArrayList();
        Object localObject = PurchasedPack.getAllPurchasePack(paramContext);
        while (!this.v) {
            Utils.sleep(10);
        }
        if ((localObject != null) && (((List) localObject).size() > 0)) {
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                PurchasedPack localPurchasedPack = (PurchasedPack) ((Iterator) localObject).next();
                FeaturePurchasedPack localFeaturePurchasedPack = new FeaturePurchasedPack(localPurchasedPack.getPackID(), localPurchasedPack.getResourceId(), 0, 0, Integer.valueOf(localPurchasedPack.getType()).intValue(), 0.0F, localPurchasedPack.getPackName(), null, localPurchasedPack.getHighDefault(), localPurchasedPack.getHighPressed(), localPurchasedPack.getResourceUrl(), 0, null);
                if (this.q.containsKey(localPurchasedPack.getPackID())) {
                    localFeaturePurchasedPack.setDownloadPack((FeatureDownloadedPack) this.q.get(localPurchasedPack.getPackID()));
                }
                localArrayList.add(localFeaturePurchasedPack);
            }
        }
        a(localArrayList, paramContext);
        return localArrayList;
    }

    private List<FeatureInternalPack> e(int paramInt) {
        if (paramInt == 2) {
            return this.g;
        }
        if (paramInt == 4) {
            return this.h;
        }
        if (paramInt == 3) {
            return this.i;
        }
        if (paramInt == 6) {
            return this.j;
        }
        if (paramInt == 7) {
            return this.k;
        }
        if (paramInt == 8) {
            return this.l;
        }
        if (paramInt == 9) {
            return this.m;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.g);
        localArrayList.addAll(this.h);
        localArrayList.addAll(this.i);
        localArrayList.addAll(this.j);
        localArrayList.addAll(this.k);
        localArrayList.addAll(this.l);
        localArrayList.addAll(this.m);
        return localArrayList;
    }

    private void e() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.effects.analog", 51, 0, 0, 2, 0.0F, "Analog", "Make your photos stand out and demand attention!", "images/store_icon/effect/High_default/edit_two_menu_effects_style_1default.png", "images/store_icon/effect/High_pressed/edit_two_menu_effects_style_1pressed.png", "", 9, "1399599480"));
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.effects.lomo", 52, 0, 0, 2, 0.0F, "Lomo", "Take it back to a simpler photo time!", "images/store_icon/effect/High_default/edit_two_menu_effects_style_2default.png", "images/store_icon/effect/High_pressed/edit_two_menu_effects_style_2pressed.png", "", 9, "0"));
        this.o.put(2, localArrayList);
        localArrayList = new ArrayList();
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.borders.simple", 71, 0, 0, 4, 0.0F, "Simple", "These simple and elegant frames are just what you’re looking for!", "images/store_icon/frame/High_default/edit_two_menu_frames_style_1default.png", "images/store_icon/frame/High_pressed/edit_two_menu_frames_style_1pressed.png", "", 5, "0"));
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.borders.styled", 73, 0, 0, 4, 0.0F, "Styled", "Try an edgier look with these cool frames!", "images/store_icon/frame/High_default/edit_two_menu_frames_style_3default.png", "images/store_icon/frame/High_pressed/edit_two_menu_frames_style_3pressed.png", "", 5, "0"));
        this.o.put(4, localArrayList);
        localArrayList = new ArrayList();
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.stickers.love", 81, 0, 0, 3, 0.0F, "Love", "Show your true feelings with these lovey-dovey stickers!", "images/store_icon/sticker/High_default/edit_two_menu_stickers_style_1default.png", "images/store_icon/sticker/High_pressed/edit_two_menu_stickers_style_1pressed.png", "", 16, "0"));
        localArrayList.add(new FeatureExternalPack("com.everimaging.fotorsdk.plugins.stickers.decoration", 82, 0, 0, 3, 0.0F, "Decoration", "Hats, glasses, and other fun things to add to your photos!", "images/store_icon/sticker/High_default/edit_two_menu_stickers_style_2default.png", "images/store_icon/sticker/High_pressed/edit_two_menu_stickers_style_2pressed.png", "", 16, "0"));
        this.o.put(3, localArrayList);
    }

    private ArrayList<FeatureExternalPack> f(int paramInt) {
        ArrayList localArrayList2 = (ArrayList) this.n.get(paramInt);
        ArrayList localArrayList1;
        if (localArrayList2 != null) {
            localArrayList1 = localArrayList2;
            if (localArrayList2.size() != 0) {
            }
        } else {
            localArrayList1 = (ArrayList) this.o.get(paramInt);
        }
        return localArrayList1;
    }

    private void f() {
        ThreadPoolService localThreadPoolService = (ThreadPoolService) b.a().b(ThreadPoolService.class);
        if (localThreadPoolService != null) {
            a local1 = new a() {
                public void a(Bundle paramAnonymousBundle) {
                    PluginService.d().c(new Object[]{"fetchBuildInPacks->onFutureDone"});
                    PluginService.a(PluginService.this, true);
                }
            };
            localThreadPoolService.a(new a(), local1, null);
            return;
        }
        c.e(new Object[]{"failed to retrieve ThreadPoolService"});
        this.v = true;
    }

    public void a(int paramInt, ArrayList<FeatureExternalPack> paramArrayList) {
        synchronized (this.n) {
            this.n.put(paramInt, paramArrayList);
            this.y.put(paramInt, true);
            return;
        }
    }

    protected void a(Bundle paramBundle) {
        c.c(new Object[]{"dispatchUpdate"});
        Object localObject2 = new ArrayList(this.s.size());
        synchronized (this.s) {
            Iterator localIterator = this.s.iterator();
            if (localIterator.hasNext()) {
                ((List) localObject2).add((f) localIterator.next());
            }
        }
        ???=((List) localObject2).iterator();
        while (((Iterator) ? ??).hasNext())
        {
            localObject2 = (f) ((Iterator) ? ??).next();
            if (localObject2 != null) {
                ((f) localObject2).a(this, paramBundle);
            }
        }
    }

    public void a(Bundle paramBundle, b paramb, Handler paramHandler) {
        paramHandler = (ThreadPoolService) b.a().b(ThreadPoolService.class);
        if ((paramHandler != null) && (this.x)) {
            a local2 = new a() {
                public void a(PluginService.d paramAnonymousd) {
                    PluginService.d().c(new Object[]{"updateInstalledPlugins->onFutureDone"});
                    PluginService.a(PluginService.this, paramAnonymousd);
                }
            };
            if (paramBundle == null) {
            }
            for (paramb = new c(); ; paramb = new g()) {
                paramHandler.a(paramb, local2, paramBundle);
                return;
                if (this.w) {
                    throw new IllegalStateException("Is not apk mode,so you just manual call PluginService addPurchasedPack method to update plugins.");
                }
            }
        }
        c.e(new Object[]{"failed to retrieve ThreadPoolService or store disabled"});
        this.u = true;
    }

    public void a(e parame) {
        synchronized (this.t) {
            if (!this.t.contains(parame)) {
                this.t.add(parame);
            }
            return;
        }
    }

    public void a(f paramf) {
        synchronized (this.s) {
            if (!this.s.contains(paramf)) {
                this.s.add(paramf);
            }
            return;
        }
    }

    public void a(PurchasedPack paramPurchasedPack) {
        paramPurchasedPack = new FeaturePurchasedPack(paramPurchasedPack.getPackID(), paramPurchasedPack.getResourceId(), 0, 0, Integer.valueOf(paramPurchasedPack.getType()).intValue(), 0.0F, paramPurchasedPack.getPackName(), null, paramPurchasedPack.getHighDefault(), paramPurchasedPack.getHighPressed(), paramPurchasedPack.getResourceUrl(), 0, null);
        a(paramPurchasedPack, true);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("internal_update_is_inapp_mode", true);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new UpdateType(paramPurchasedPack.getPackageName(), paramPurchasedPack.getPluginType(), paramPurchasedPack.getPackName(), paramPurchasedPack.getPackageVersionCode(), "fotor.android.intent.ACTION_PLUGIN_ADDED"));
        localBundle.putSerializable("internal_update_plugins", localArrayList);
        a(localBundle);
    }

    public void a(PurchasedPack paramPurchasedPack, String paramString) {
        String str = paramPurchasedPack.getPackID();
        paramPurchasedPack = paramPurchasedPack.getPackName();
        Object localObject = (FeaturePurchasedPack) this.p.get(str);
        if (localObject != null) {
            paramPurchasedPack = new FeatureDownloadedPack(str, paramPurchasedPack, 0, 0, ((FeaturePurchasedPack) localObject).getPluginType(), paramString);
            ((FeaturePurchasedPack) localObject).setDownloadPack(paramPurchasedPack);
        }
        for (; ; ) {
            if (paramPurchasedPack != null) {
                this.q.put(str, paramPurchasedPack);
            }
            return;
            localObject = (FeatureInternalPack) this.r.get(str);
            if (localObject != null) {
                paramPurchasedPack = new FeatureDownloadedPack(str, paramPurchasedPack, 0, 0, ((FeatureInternalPack) localObject).getPluginType(), paramString);
                ((FeaturePurchasedPack) localObject).setDownloadPack(paramPurchasedPack);
            } else {
                paramPurchasedPack = null;
            }
        }
    }

    public void a(boolean paramBoolean) {
        this.x = paramBoolean;
    }

    public boolean a(int paramInt) {
        return this.y.get(paramInt);
    }

    public boolean a(String paramString) {
        return this.r.containsKey(paramString);
    }

    public FeatureInternalPack[] a(Context paramContext, int paramInt) {
        paramContext = e(paramInt);
        if (paramContext == null) {
            return new FeatureInternalPack[0];
        }
        return (FeatureInternalPack[]) paramContext.toArray(new FeatureInternalPack[paramContext.size()]);
    }

    public void b(e parame) {
        synchronized (this.t) {
            if (this.t.contains(parame)) {
                this.t.remove(parame);
            }
            return;
        }
    }

    public void b(f paramf) {
        synchronized (this.s) {
            if (this.s.contains(paramf)) {
                this.s.remove(paramf);
            }
            return;
        }
    }

    public boolean b() {
        return this.u;
    }

    public FeatureExternalPack[] b(int paramInt) {
        for (; ; ) {
            synchronized (this.e) {
                ArrayList localArrayList = f(paramInt);
                if (localArrayList == null) {
                    break label123;
                }
                localArrayList = (ArrayList) localArrayList.clone();
                if ((localArrayList == null) || (localArrayList.size() <= 0)) {
                    break label118;
                }
                ???=localArrayList.iterator();
                if (((Iterator) ? ??).hasNext())
                {
                    FeatureExternalPack localFeatureExternalPack = (FeatureExternalPack) ((Iterator) ? ??).next();
                    if ((localFeatureExternalPack.getPluginType() == paramInt) && (!this.r.containsKey(localFeatureExternalPack.getPackID()))) {
                        continue;
                    }
                    ((Iterator) ? ??).remove();
                }
            }
            return (FeatureExternalPack[]) ((ArrayList) localObject1).toArray(new FeatureExternalPack[((ArrayList) localObject1).size()]);
            label118:
            return new FeatureExternalPack[0];
            label123:
            Object localObject2 = null;
        }
    }

    public boolean c() {
        return this.v;
    }

    public FeaturePurchasedPack[] c(int paramInt) {
        synchronized (this.f) {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = this.p.values().iterator();
            if (localIterator.hasNext()) {
                localArrayList.add((FeaturePurchasedPack) localIterator.next());
            }
        }
        if ((localObject2 != null) && (((ArrayList) localObject2).size() > 0)) {
            ???=((ArrayList) localObject2).iterator();
            while (((Iterator) ? ??).hasNext()){
                if (((FeaturePurchasedPack) ((Iterator) ? ? ?).next()).getPluginType() != paramInt){
                    ((Iterator) ? ??).remove();
                }
            }
            return (FeaturePurchasedPack[]) ((ArrayList) localObject2).toArray(new FeaturePurchasedPack[((ArrayList) localObject2).size()]);
        }
        return new FeaturePurchasedPack[0];
    }

    public List<FeatureInternalPack> d(int paramInt) {
        c.c(new Object[]{"getInstalledAvailable type:" + paramInt});
        Object localObject = e(paramInt);
        ArrayList localArrayList = new ArrayList();
        if (this.w) {
            localArrayList.addAll((Collection) localObject);
        }
        for (; ; ) {
            localArrayList.addAll(this.q.values());
            return localArrayList;
            if ((localObject != null) && (((List) localObject).size() > 0)) {
                localObject = ((List) localObject).iterator();
                while (((Iterator) localObject).hasNext()) {
                    FeatureInternalPack localFeatureInternalPack = (FeatureInternalPack) ((Iterator) localObject).next();
                    if ((localFeatureInternalPack instanceof FeatureBindPack)) {
                        localArrayList.add(localFeatureInternalPack);
                    }
                }
            }
        }
    }

    class a
            extends ThreadPoolService.a<Bundle, Bundle> {
        a() {
        }

        protected Bundle a(Context paramContext, Bundle paramBundle) {
            PluginService.d().c(new Object[]{"begin fetch build-in plugin"});
            if (!PluginService.b(PluginService.this)) {
                PluginService.a(PluginService.this, PluginService.b(PluginService.this.a));
            }
            PluginService.d().c(new Object[]{"completion fetch build-in plugin"});
            return null;
        }
    }

    public static abstract interface b {
    }

    class c
            extends ThreadPoolService.a<Bundle, PluginService.d> {
        c() {
        }

        protected PluginService.d a(Context paramContext, Bundle paramBundle) {
            PluginService.d().c(new Object[]{"fetch the plugin task"});
            if (PluginService.a(PluginService.this)) {
            }
            for (paramContext = PluginService.a(PluginService.this.a); ; paramContext = PluginService.a(PluginService.this, paramContext)) {
                paramBundle = new ArrayList();
                Iterator localIterator = paramContext.iterator();
                while (localIterator.hasNext()) {
                    FeatureInternalPack localFeatureInternalPack = (FeatureInternalPack) localIterator.next();
                    paramBundle.add(new UpdateType(localFeatureInternalPack.getPackageName(), localFeatureInternalPack.getPluginType(), localFeatureInternalPack.getPackName(), localFeatureInternalPack.getPackageVersionCode(), "fotor.android.intent.ACTION_PLUGIN_ADDED"));
                }
            }
            paramContext = new PluginService.d(PluginService.this, paramContext);
            paramContext.b.putSerializable("internal_update_plugins", paramBundle);
            return paramContext;
        }
    }

    public final class d {
        public final List<FeatureInternalPack> a;
        public final Bundle b = new Bundle();

        public d() {
            List localList;
            this.a = localList;
        }
    }

    public static abstract interface e {
    }

    public static abstract interface f {
        public abstract void a(PluginService paramPluginService, Bundle paramBundle);
    }

    class g
            extends ThreadPoolService.a<Bundle, PluginService.d> {
        g() {
        }

        protected PluginService.d a(Context paramContext, Bundle paramBundle) {
            long l1 = System.currentTimeMillis();
            ArrayList localArrayList = new ArrayList();
            List localList = PluginService.a(paramContext);
            int i;
            String str1;
            String str2;
            int j;
            String str3;
            if (paramBundle != null) {
                PluginService.a(PluginService.this, paramBundle);
                String str4 = paramBundle.getString("APPLICATION_CONTEXT");
                i = paramBundle.getInt("PLUGIN_TYPE");
                str1 = paramBundle.getString("PACKAGE_NAME");
                str2 = paramBundle.getString("ACTION");
                j = paramBundle.getInt("PACKAGE_VERSION");
                str3 = paramBundle.getString("PACKAGE_NAME");
                if ((paramContext.getPackageName().equals(str4)) && (!paramContext.getPackageName().equals(str1))) {
                    paramBundle = null;
                    if (!"fotor.android.intent.ACTION_PLUGIN_ADDED".equals(str2)) {
                        break label284;
                    }
                    paramBundle = new UpdateType(str1, i, str3, j, str2);
                }
            }
            for (; ; ) {
                try {
                    paramContext = paramContext.getPackageManager().getResourcesForApplication(str1);
                    paramContext = paramContext.getString(paramContext.getIdentifier("pack_name", "string", str1));
                    PluginService.d().c(new Object[]{"plugin add name:" + paramContext});
                    paramContext = paramBundle;
                } catch (PackageManager.NameNotFoundException paramContext) {
                    long l2;
                    paramContext.printStackTrace();
                    paramContext = paramBundle;
                    continue;
                }
                if (paramContext != null) {
                    localArrayList.add(paramContext);
                }
                paramContext = new PluginService.d(PluginService.this, localList);
                paramContext.b.putSerializable("internal_update_plugins", localArrayList);
                l2 = System.currentTimeMillis();
                PluginService.d().b(new Object[]{"completed in " + (l2 - l1)});
                return paramContext;
                label284:
                if ("fotor.android.intent.ACTION_PLUGIN_REPLACED".equals(str2)) {
                    paramContext = new UpdateType(str1, i, str3, j, str2);
                } else {
                    paramContext = paramBundle;
                    if ("fotor.android.intent.ACTION_PLUGIN_REMOVED".equals(str2)) {
                        paramContext = new UpdateType(str1, i, str3, 0, str2);
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/services/PluginService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */