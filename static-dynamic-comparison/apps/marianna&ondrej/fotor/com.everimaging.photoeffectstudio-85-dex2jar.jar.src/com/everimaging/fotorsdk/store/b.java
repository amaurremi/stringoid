package com.everimaging.fotorsdk.store;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v8.renderscript.RenderScript;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.filter.FxEffectFilter;
import com.everimaging.fotorsdk.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.http.f;
import com.everimaging.fotorsdk.http.k;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureDownloadedPack;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.utils.e;
import com.everimaging.fotorsdk.store.widget.PurchaseButton;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils.ResizeMode;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorZipUtils;
import com.everimaging.fotorsdk.utils.ImageSize;
import com.everimaging.fotorsdk.utils.LoadImageTask;
import com.everimaging.fotorsdk.utils.LoadImageTask.OnLoadImageListener;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView.c;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.http.Header;

public abstract class b
        extends FotorStoreAbstractDetailPage
        implements a.a, LoadImageTask.OnLoadImageListener {
    protected static final String a = b.class.getSimpleName();
    protected static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private LoadImageTask D;
    private c E;
    private View F;
    private View G;
    private View H;
    private View.OnClickListener I;
    private View.OnClickListener J;
    private k K;
    private e L;
    private TextView M;
    private View N;
    private View O;
    protected FotorImageView c;
    protected HListView d;
    protected TextView e;
    protected TextView f;
    protected PurchaseButton g;
    protected ProgressBar h;
    protected Bitmap i;
    protected Bitmap j;
    protected Bitmap k;
    protected int l;
    protected int m;
    protected com.everimaging.fotorsdk.plugins.c n;
    protected com.everimaging.fotorsdk.store.adapter.b o;
    protected List<EffectInfo> p;
    protected FxEffectFilter q;
    protected EffectsParams r;
    protected b s;
    protected AdapterView.c t;

    public b(FotorStoreAbstractDetailPage.a parama, DetailPageInfo paramDetailPageInfo, j paramj, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean) {
        super(parama, paramDetailPageInfo, paramj, paramSourceType, paramBoolean);
    }

    private void a(EffectInfo paramEffectInfo) {
        boolean bool = t();
        b.c(new Object[]{"killCurrentTask success:" + bool});
        this.s = new b(paramEffectInfo.effectEntity);
        this.s.execute(new Void[0]);
    }

    private void b(String paramString) {
        if (this.D != null) {
            this.D.setOnLoadListener(null);
            this.D = null;
        }
        if (paramString == null) {
        }
        for (paramString = this.y.i(); ; paramString = Uri.fromFile(new File(paramString))) {
            this.D = new LoadImageTask(this.v, paramString, 0);
            this.D.setOnLoadListener(this);
            this.D.execute(new Void[0]);
            return;
        }
    }

    private void c(String paramString) {
        int i1 = 0;
        b.c(new Object[]{"Unzip error!Clean error directory"});
        paramString = new File(paramString);
        if (paramString.exists()) {
            String[] arrayOfString = paramString.list();
            if (i1 < arrayOfString.length) {
                File localFile = new File(paramString, arrayOfString[i1]);
                if (localFile.isDirectory()) {
                    c(localFile.getAbsolutePath());
                }
                for (; ; ) {
                    i1 += 1;
                    break;
                    localFile.delete();
                }
            }
            paramString.delete();
        }
    }

    private void s() {
        this.e.setText(this.x.name);
        this.f.setText(this.x.description);
        a(this.g);
    }

    private boolean t() {
        if (this.s != null) {
            return this.s.cancel(true);
        }
        return false;
    }

    private void u() {
        this.t = new AdapterView.c() {
            public void a(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                int i = paramAnonymousInt - b.this.d.getHeaderViewsCount();
                if ((i >= 0) && (i < b.this.o.getCount())) {
                    paramAnonymousAdapterView = b.this.o.a(i);
                    if (!b.this.o.c(i)) {
                    }
                } else {
                    return;
                }
                paramAnonymousInt = b.this.d.getFirstVisiblePosition();
                int j = b.this.d.getLastVisiblePosition();
                if (Math.abs(i - paramAnonymousInt) > Math.abs(i - j)) {
                    paramAnonymousInt = 1;
                    if (paramAnonymousInt == 0) {
                        break label182;
                    }
                    if (i >= b.this.o.getCount() - 1) {
                        break label167;
                    }
                    b.this.d.c(i + 1);
                }
                for (; ; ) {
                    b.this.o.b(i);
                    b.a(b.this, paramAnonymousAdapterView);
                    return;
                    paramAnonymousInt = 0;
                    break;
                    label167:
                    b.this.d.c(i);
                    continue;
                    label182:
                    if (i > 0) {
                        b.this.d.c(i - 1);
                    } else {
                        b.this.d.c(i);
                    }
                }
            }
        };
    }

    protected abstract Bitmap a(EffectInfo paramEffectInfo, Bitmap paramBitmap);

    public void a() {
        a(this.g);
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        this.g.a(paramFloat);
    }

    protected void a(String paramString1, String paramString2, boolean paramBoolean) {
        paramString2 = new FeatureDownloadedPack(this.v.getPackageName(), null, 0, 0, i(), paramString1);
        this.n = ((com.everimaging.fotorsdk.plugins.c) h.a(this.v, paramString2));
        if (this.E != null) {
            this.E.cancel(true);
        }
        this.E = new c(paramString1, paramBoolean);
        this.E.execute(new Void[0]);
    }

    protected void b() {
        this.u = LayoutInflater.from(this.v).inflate(R.layout.fotor_store_effect_border_detail_page, null);
        this.H = this.u.findViewById(R.id.fotor_store_details_image_container);
        this.c = ((FotorImageView) this.u.findViewById(R.id.fotor_store_effect_imageView));
        this.c.setTouchable(false);
        this.d = ((HListView) this.u.findViewById(R.id.fotor_store_effect_border_details_preview_listview));
        this.d.setChoiceMode(1);
        this.d.setDividerWidth(this.v.getResources().getDimensionPixelSize(R.dimen.fotor_store_details_effect_border_divider_width));
        this.e = ((TextView) this.u.findViewById(R.id.fotor_store_effect_border_details_pkg_name));
        this.f = ((TextView) this.u.findViewById(R.id.fotor_store_effect_border_details_pkg_description));
        this.g = ((PurchaseButton) this.u.findViewById(R.id.fotor_store_effect_border_details_purchase_button));
        this.h = ((ProgressBar) this.u.findViewById(R.id.fotor_progress_bar));
        this.h.setVisibility(8);
        this.F = this.u.findViewById(R.id.fotor_store_effect_loading_view);
        this.G = this.u.findViewById(R.id.fotor_store_effect_trail_panel_loading);
        b(this.y.d());
        this.I = new a(null);
        this.J = new d(null);
        this.M = ((TextView) this.u.findViewById(R.id.fotor_store_details_promotion_textview));
        this.N = this.u.findViewById(R.id.fotor_store_promotion_layer);
        this.O = this.u.findViewById(R.id.fotor_store_detail_exception);
        this.O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                b.this.a(true);
            }
        });
        s();
    }

    public void b(PurchasedPack paramPurchasedPack) {
        a(this.g, 6);
    }

    protected void c() {
        this.G.setVisibility(0);
        this.O.setVisibility(8);
    }

    public void c(PurchasedPack paramPurchasedPack) {
        a(this.g, 2);
    }

    protected void d() {
        super.d();
        this.G.setVisibility(8);
        this.O.setVisibility(0);
    }

    public void d(PurchasedPack paramPurchasedPack) {
        a(this.g, 3);
    }

    protected void e() {
        FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject localEffectsBoredersDetailsJsonObject = (FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject) this.w;
        if ((this.C) && (!TextUtils.isEmpty(localEffectsBoredersDetailsJsonObject.promotionMsg))) {
            this.M.setText(localEffectsBoredersDetailsJsonObject.promotionMsg);
            this.N.setVisibility(0);
        }
        if (!TextUtils.isEmpty(localEffectsBoredersDetailsJsonObject.name)) {
            this.x.name = localEffectsBoredersDetailsJsonObject.name;
        }
        if (!TextUtils.isEmpty(localEffectsBoredersDetailsJsonObject.description)) {
            this.x.description = localEffectsBoredersDetailsJsonObject.description;
        }
        s();
        this.g.setTag(localEffectsBoredersDetailsJsonObject);
        this.g.setOnClickListener(this.I);
        this.N.setOnClickListener(this.J);
        j();
    }

    public void f() {
        super.f();
        a(this.g);
    }

    protected void g() {
        a(this.g);
    }

    public Context getContext() {
        return this.v;
    }

    public RenderScript getRenderScript() {
        return this.y.g();
    }

    public com.everimaging.fotorsdk.algorithms.filter.d getScript_BaseFilter() {
        return this.y.h();
    }

    public void h() {
        super.h();
        if (this.K != null) {
            this.K.a(true);
        }
        if (this.L != null) {
            this.L.cancel(true);
        }
        this.K = null;
        this.L = null;
    }

    protected int i() {
        int i1 = 0;
        if (com.everimaging.fotorsdk.store.utils.c.b(this.x.type)) {
            i1 = 2;
        }
        while (!com.everimaging.fotorsdk.store.utils.c.a(this.x.type)) {
            return i1;
        }
        return 4;
    }

    protected void j() {
        final FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject localEffectsBoredersDetailsJsonObject = (FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject) this.w;
        String str1 = localEffectsBoredersDetailsJsonObject.trialUrl;
        final String str2 = e.a(this.y.e(), e.a(localEffectsBoredersDetailsJsonObject.type), localEffectsBoredersDetailsJsonObject.name);
        if (new File(str2).exists()) {
            a(str2, localEffectsBoredersDetailsJsonObject.name, true);
        }
        while ((str1 == null) || (str1.isEmpty())) {
            return;
        }
        this.K = com.everimaging.fotorsdk.store.utils.d.b(str1, null, new f(new String[]{".*"}) {
            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte) {
                b.a(b.this, null);
                paramAnonymousArrayOfHeader = new ByteArrayInputStream(paramAnonymousArrayOfByte);
                b.a(b.this, new b.e(b.this, str2, paramAnonymousArrayOfHeader, localEffectsBoredersDetailsJsonObject.name));
                b.a(b.this).execute(new Void[0]);
            }

            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable) {
                b.a(b.this, null);
                b.b.e(new Object[]{"Download trail res failed : " + paramAnonymousThrowable.getMessage()});
                b.this.d();
            }
        });
    }

    protected abstract List<EffectInfo> k();

    public void onLoadComplete(Bitmap paramBitmap, Drawable paramDrawable, ImageSize paramImageSize) {
        this.i = paramBitmap;
        b.c(new Object[]{"load bitmap src:" + this.i});
        this.c.setImageBitmap(paramBitmap);
        this.H.setBackgroundDrawable(paramDrawable);
        this.c.setVisibility(0);
        this.F.setVisibility(8);
        if (this.i == null) {
            try {
                paramBitmap = BitmapDecodeUtils.decodeStream(this.v.getResources().openRawResource(R.raw.fotor_sample_test));
                this.i = paramBitmap;
                if (paramBitmap == null) {
                    throw new IllegalStateException("sample bitmap is not found.");
                }
            } catch (Exception paramBitmap) {
            }
        }
        if (this.i != null) {
            if ((this.j != null) && (!this.j.isRecycled())) {
                this.j.recycle();
            }
            this.j = BitmapUtils.copy(this.i, this.i.getConfig());
            this.c.setImageBitmap(this.j);
            this.l = this.v.getResources().getDimensionPixelSize(R.dimen.fotor_store_details_effect_border_listview_height);
            this.m = this.l;
            this.k = BitmapUtils.resizeBitmap(this.i, this.l, this.m, BitmapUtils.ResizeMode.CENTER_CROP);
            b.c(new Object[]{"thumbnail image:" + this.k});
            if ((this.k != null) && (this.k.getConfig() != Bitmap.Config.ARGB_8888)) {
                paramBitmap = BitmapUtils.copy(this.k, Bitmap.Config.ARGB_8888);
                if (this.k != null) {
                    this.k.recycle();
                }
                this.k = paramBitmap;
            }
            this.r = new EffectsParams();
            this.q = new FxEffectFilter(this, this.i, this.j, this.r, FxEffectFilter.Level.MEDIUM);
        }
    }

    public void onLoadError(String paramString) {
        this.c.setVisibility(0);
        this.F.setVisibility(8);
    }

    public void onLoadStart() {
        this.c.setVisibility(4);
        this.F.setVisibility(0);
    }

    private class a
            implements View.OnClickListener {
        private a() {
        }

        public void onClick(View paramView) {
            if (paramView.getTag() != null) {
                paramView = (FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject) paramView.getTag();
                b.this.y.a(new ProductInfo(paramView.type, paramView.id, paramView.pkgName, paramView.name, paramView.price, null, paramView.url), b.this.x.type, true);
            }
        }
    }

    protected class b
            extends FotorAsyncTask<Void, Void, Void> {
        private EffectEntity b;

        public b(EffectEntity paramEffectEntity) {
            this.b = paramEffectEntity;
        }

        protected Void a(Void... arg1) {
            if ((b.this.r != null) && (b.this.q != null)) {
                synchronized (b.this.r) {
                    b.this.q.a(b.this.n);
                    b.this.r.setEffectEntity(this.b);
                    b.this.q.c();
                }
            }
            return null;
        }

        protected void a(Void paramVoid) {
            b.this.c.invalidate();
            b.this.h.setVisibility(8);
            b.this.s = null;
        }

        protected void b(Void paramVoid) {
            b.this.h.setVisibility(8);
            b.this.s = null;
        }

        protected void onPreExecute() {
            b.this.h.setVisibility(0);
        }
    }

    private class c
            extends FotorAsyncTask<Void, Void, List<EffectInfo>> {
        private String b;
        private boolean c;

        public c(String paramString, boolean paramBoolean) {
            this.b = paramString;
        }

        protected List<EffectInfo> a(Void... paramVarArgs) {
            return b.this.k();
        }

        protected void a(List<EffectInfo> paramList) {
            b.b(b.this).setVisibility(8);
            if ((paramList != null) && (!paramList.isEmpty())) {
                b.this.o = new com.everimaging.fotorsdk.store.adapter.b(b.this.v, b.this.p, new EffectThumbLoader.EffectThumbProcessor() {
                    public Bitmap processBitmap(EffectInfo paramAnonymousEffectInfo, Bitmap paramAnonymousBitmap) {
                        if (paramAnonymousBitmap == null) {
                        }
                        for (; ; ) {
                            try {
                                b.b.e(new Object[]{"process thumbnail source is null"});
                                paramAnonymousEffectInfo = null;
                                return paramAnonymousEffectInfo;
                            } finally {
                            }
                            paramAnonymousEffectInfo = b.this.a(paramAnonymousEffectInfo, paramAnonymousBitmap);
                        }
                    }
                }, b.this.k);
                b.this.d.setAdapter(b.this.o);
                b.c(b.this);
                b.this.d.setOnItemClickListener(b.this.t);
                return;
            }
            b.a(b.this, this.b);
            if (this.c) {
                b.this.j();
                return;
            }
            b.this.d();
        }

        protected void onCancelled() {
            b.b(b.this).setVisibility(8);
        }

        protected void onPreExecute() {
            b.b(b.this).setVisibility(0);
            b.this.d.setAdapter(null);
        }
    }

    private class d
            implements View.OnClickListener {
        private d() {
        }

        public void onClick(View paramView) {
            paramView = (FotorStoreJsonObjects.EffectsBoredersDetailsJsonObject) b.this.w;
            DetailPageInfo localDetailPageInfo = new DetailPageInfo();
            localDetailPageInfo.id = paramView.bundleId;
            localDetailPageInfo.type = "1";
            b.this.y.a(localDetailPageInfo, true, FotorStoreAbstractDetailPage.SourceType.STORE, true);
        }
    }

    private class e
            extends FotorAsyncTask<Void, Void, Integer> {
        private InputStream b;
        private String c;
        private String d;

        public e(String paramString1, InputStream paramInputStream, String paramString2) {
            this.c = paramString1;
            this.b = paramInputStream;
            this.d = paramString2;
        }

        protected Integer a(Void... paramVarArgs) {
            if (this.b != null) {
                paramVarArgs = new ZipInputStream(this.b);
                return Integer.valueOf(FotorZipUtils.UnzipStream(this.c, paramVarArgs));
            }
            return Integer.valueOf(-1);
        }

        protected void a(Integer paramInteger) {
            b.a(b.this, null);
            if (paramInteger.intValue() == 0) {
                b.this.a(this.c, this.d, false);
                return;
            }
            b.a(b.this, this.c);
            b.this.d();
        }

        protected void onCancelled() {
            b.a(b.this, null);
            b.b(b.this).setVisibility(8);
        }

        protected void onPreExecute() {
            b.b(b.this).setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */