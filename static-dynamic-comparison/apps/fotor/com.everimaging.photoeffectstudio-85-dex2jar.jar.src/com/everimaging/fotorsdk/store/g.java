package com.everimaging.fotorsdk.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.everimaging.fotorsdk.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureExternalPack;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.services.b;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.NewPkgNumJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.RecommendPkgJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeDataJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.utils.c.b;
import com.everimaging.fotorsdk.store.utils.c.c;
import com.everimaging.fotorsdk.store.utils.f;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g {
    private static final String i = g.class.getSimpleName();
    private static final FotorLoggerFactory.c j = FotorLoggerFactory.a(i, FotorLoggerFactory.LoggerType.CONSOLE);
    protected Context a;
    protected com.everimaging.fotorsdk.engine.c b;
    protected String c;
    protected FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> d;
    protected boolean e = false;
    protected a f;
    protected boolean g = false;
    protected boolean h;

    public g(com.everimaging.fotorsdk.engine.c paramc, String paramString) {
        this.b = paramc;
        this.c = paramString;
        this.a = this.b.getBaseContext();
        this.h = this.b.l();
        if (this.h) {
            this.b.e().post(new Runnable() {
                public void run() {
                    g.this.b();
                }
            });
        }
    }

    private void a(String paramString) {
        String str2 = "Unknow";
        String str1 = "Unknow";
        if (com.everimaging.fotorsdk.store.utils.c.a(this.c)) {
            str2 = "EDIT_FRAME_STORERECOMMEND";
            str1 = "Frame_Category";
        }
        for (; ; ) {
            a.a(str2, str1, paramString);
            return;
            if (com.everimaging.fotorsdk.store.utils.c.b(this.c)) {
                str2 = "EDIT_FX_STORERECOMMEND";
                str1 = "Effect_Category";
            } else if (com.everimaging.fotorsdk.store.utils.c.d(this.c)) {
                str2 = "EDIT_TEXT_STORERECOMMEND";
                str1 = "Font_Category";
            } else if (com.everimaging.fotorsdk.store.utils.c.c(this.c)) {
                str2 = "EDIT_STICKER_STORERECOMMEND";
                str1 = "Sticker_Category";
            } else if (com.everimaging.fotorsdk.store.utils.c.f(this.c)) {
                str2 = "COLLAGE_CLASSIC_STORERECOMMEND";
                str1 = "Collage_Category";
            } else if (com.everimaging.fotorsdk.store.utils.c.g(this.c)) {
                str2 = "COLLAGE_MAGAZINE_STORERECOMMEND";
                str1 = "Collage_Category";
            } else if (com.everimaging.fotorsdk.store.utils.c.h(this.c)) {
                str2 = "COLLAGE_PATTERN_STORERECOMMEND";
                str1 = "Collage_Category";
            }
        }
    }

    private Intent b(Bitmap paramBitmap, String paramString) {
        Intent localIntent = new Intent(this.a, FotorStoreActivity.class);
        Object localObject = paramString;
        if (paramString == null) {
            localObject = paramString;
            if (paramBitmap != null) {
                String str = Utils.generateJPGFullPath(FotorCommonDirUtils.getTemporaryPath());
                localObject = paramString;
                if (Utils.saveBitmap2Path(str, paramBitmap, 85)) {
                    localObject = str;
                }
            }
        }
        if (localObject != null) {
            localIntent.putExtra("arg_preview_src", (String) localObject);
        }
        localIntent.putExtra("arg_feature_type", this.c);
        return localIntent;
    }

    private void d() {
        String str = "Unknow";
        if (com.everimaging.fotorsdk.store.utils.c.a(this.c)) {
            str = "EDIT_FRAME_STORE";
        }
        for (; ; ) {
            a.a(str);
            return;
            if (com.everimaging.fotorsdk.store.utils.c.b(this.c)) {
                str = "EDIT_FX_STORE";
            } else if (com.everimaging.fotorsdk.store.utils.c.d(this.c)) {
                str = "EDIT_TEXT_STORE";
            } else if (com.everimaging.fotorsdk.store.utils.c.c(this.c)) {
                str = "EDIT_STICKER_STORE";
            } else if (com.everimaging.fotorsdk.store.utils.c.f(this.c)) {
                str = "COLLAGE_CLASSIC_STORE";
            } else if (com.everimaging.fotorsdk.store.utils.c.g(this.c)) {
                str = "COLLAGE_MAGAZINE_STORE";
            } else if (com.everimaging.fotorsdk.store.utils.c.h(this.c)) {
                str = "COLLAGE_PATTERN_STORE";
            }
        }
    }

    private void e() {
        this.e = true;
        if (this.f != null) {
            this.f.i();
        }
    }

    private void f() {
        this.e = false;
        if (this.f != null) {
            this.f.j();
        }
    }

    public void a(Bitmap paramBitmap, String paramString) {
        if ((this.f != null) && (this.f.h())) {
        }
        while (a()) {
            return;
        }
        d();
        if (com.everimaging.fotorsdk.store.utils.c.a()) {
            paramBitmap = b(paramBitmap, paramString);
            this.b.g().startActivityForResult(paramBitmap, 17119);
            this.g = false;
            e();
            return;
        }
        f.b(this.b.g());
    }

    public void a(DetailPageInfo paramDetailPageInfo, Bitmap paramBitmap, String paramString) {
        if ((this.f != null) && (this.f.h())) {
        }
        while (a()) {
            return;
        }
        a(paramDetailPageInfo.pkgName);
        if (com.everimaging.fotorsdk.store.utils.c.a()) {
            paramBitmap = b(paramBitmap, paramString);
            paramBitmap.putExtra("arg_package_info", paramDetailPageInfo);
            this.b.g().startActivityForResult(paramBitmap, 17119);
            this.g = true;
            e();
            return;
        }
        f.b(this.b.g());
    }

    public void a(a parama) {
        this.f = parama;
    }

    public void a(boolean paramBoolean) {
        com.everimaging.fotorsdk.store.utils.c.a(new c.c() {
            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.RecommendPkgJsonObject> paramAnonymousResposeListJsonObject) {
                ArrayList localArrayList = new ArrayList();
                if (paramAnonymousResposeListJsonObject != null) {
                    paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.data;
                    if ((paramAnonymousResposeListJsonObject != null) && (paramAnonymousResposeListJsonObject.size() > 0)) {
                        paramAnonymousResposeListJsonObject = paramAnonymousResposeListJsonObject.iterator();
                        while (paramAnonymousResposeListJsonObject.hasNext()) {
                            FotorStoreJsonObjects.RecommendPkgJsonObject localRecommendPkgJsonObject = (FotorStoreJsonObjects.RecommendPkgJsonObject) paramAnonymousResposeListJsonObject.next();
                            int i = Integer.parseInt(localRecommendPkgJsonObject.type);
                            localArrayList.add(new FeatureExternalPack(localRecommendPkgJsonObject.pkgName, localRecommendPkgJsonObject.id, 0, 0, i, localRecommendPkgJsonObject.price, localRecommendPkgJsonObject.name, localRecommendPkgJsonObject.description, localRecommendPkgJsonObject.highDefault, localRecommendPkgJsonObject.highPressed, "", localRecommendPkgJsonObject.count, localRecommendPkgJsonObject.publishDate, false));
                        }
                        ((PluginService) b.a().b(PluginService.class)).a(Integer.valueOf(g.this.c).intValue(), localArrayList);
                    }
                }
            }

            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.RecommendPkgJsonObject> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
            }
        }, this.a, this.c, paramBoolean);
    }

    public boolean a() {
        return this.e;
    }

    protected void b() {
        com.everimaging.fotorsdk.store.utils.c.a(new c.b() {
            public void a(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> paramAnonymousResposeDataJsonObject) {
                g.this.d = paramAnonymousResposeDataJsonObject;
                if ((g.this.d != null) && (g.this.d.data != null) && (g.this.f != null)) {
                    g.this.f.a(((FotorStoreJsonObjects.NewPkgNumJsonObject) g.this.d.data).num);
                }
            }

            public void a(FotorStoreJsonObjects.ResposeDataJsonObject<FotorStoreJsonObjects.NewPkgNumJsonObject> paramAnonymousResposeDataJsonObject, String paramAnonymousString) {
            }
        }, this.a, this.c, false);
        a(false);
    }

    public void c() {
        if (a()) {
            if ((this.d != null) && (!this.g)) {
                ((FotorStoreJsonObjects.NewPkgNumJsonObject) this.d.data).num = 0;
                com.everimaging.fotorsdk.store.utils.c.a(this.a, this.d);
                if (this.f != null) {
                    this.f.a(0);
                }
            }
            f();
        }
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract boolean h();

        public abstract void i();

        public abstract void j();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */