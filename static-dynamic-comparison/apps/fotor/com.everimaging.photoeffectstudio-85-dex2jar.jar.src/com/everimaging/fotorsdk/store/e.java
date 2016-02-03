package com.everimaging.fotorsdk.store;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.CommonDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.ProductInfo;
import com.everimaging.fotorsdk.store.widget.PurchaseButton;
import com.everimaging.fotorsdk.uil.core.c;
import com.everimaging.fotorsdk.uil.core.c.a;

public class e
        extends FotorStoreAbstractDetailPage {
    private static final String a = e.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private ImageView c;
    private TextView d;
    private TextView e;
    private PurchaseButton f;
    private WebView g;
    private View h;
    private View i;
    private View j;
    private TextView k;
    private View l;
    private c m;
    private View.OnClickListener n = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (paramAnonymousView.getTag() != null) {
                paramAnonymousView = (FotorStoreJsonObjects.CommonDetailsJsonObject) paramAnonymousView.getTag();
                e.this.y.a(new ProductInfo(paramAnonymousView.type, paramAnonymousView.id, paramAnonymousView.pkgName, paramAnonymousView.name, paramAnonymousView.price, null, paramAnonymousView.url), e.this.x.type, true);
            }
        }
    };
    private View.OnClickListener o = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = (FotorStoreJsonObjects.CommonDetailsJsonObject) e.this.w;
            DetailPageInfo localDetailPageInfo = new DetailPageInfo();
            localDetailPageInfo.id = paramAnonymousView.bundleId;
            localDetailPageInfo.type = "1";
            e.this.y.a(localDetailPageInfo, true, FotorStoreAbstractDetailPage.SourceType.STORE, true);
        }
    };

    public e(FotorStoreAbstractDetailPage.a parama, DetailPageInfo paramDetailPageInfo, j paramj, FotorStoreAbstractDetailPage.SourceType paramSourceType, boolean paramBoolean) {
        super(parama, paramDetailPageInfo, paramj, paramSourceType, paramBoolean);
    }

    private void j() {
        this.d.setText(this.x.name);
        this.e.setText(this.x.description);
        a(this.f);
    }

    public void a() {
        if (this.w != null) {
            a(this.f);
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        this.f.a(paramFloat);
    }

    protected void b() {
        this.u = LayoutInflater.from(this.v).inflate(R.layout.fotor_store_common_detail_page, null);
        this.c = ((ImageView) this.u.findViewById(R.id.fotor_store_sticker_font_details_thumb_imageview));
        this.d = ((TextView) this.u.findViewById(R.id.fotor_store_sticker_font_details_pkg_name));
        this.e = ((TextView) this.u.findViewById(R.id.fotor_store_sticker_font_details_pkg_description));
        this.f = ((PurchaseButton) this.u.findViewById(R.id.fotor_store_sticker_font_details_buy));
        this.g = ((WebView) this.u.findViewById(R.id.fotor_store_sticker_font_details_preview_webview));
        this.h = this.u.findViewById(R.id.fotor_store_detail_webview_exception);
        this.i = this.h.findViewById(R.id.fotor_store_details_retry_button);
        this.i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                e.this.a(true);
            }
        });
        this.j = this.u.findViewById(R.id.fotor_store_detail_webview_loading);
        this.k = ((TextView) this.u.findViewById(R.id.fotor_store_details_promotion_textview));
        this.l = this.u.findViewById(R.id.fotor_store_promotion_layer);
        this.m = new c.a().a(R.color.fotor_transparent).b(R.color.fotor_transparent).c(R.color.fotor_transparent).a(true).b(true).a(Bitmap.Config.RGB_565).a();
        j();
    }

    public void b(PurchasedPack paramPurchasedPack) {
        a(this.f, 6);
    }

    protected void c() {
        this.g.setVisibility(8);
        this.j.setVisibility(0);
        this.h.setVisibility(8);
    }

    public void c(PurchasedPack paramPurchasedPack) {
        a(this.f, 2);
    }

    protected void d() {
        super.d();
        this.j.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void d(PurchasedPack paramPurchasedPack) {
        a(this.f, 3);
    }

    protected void e() {
        FotorStoreJsonObjects.CommonDetailsJsonObject localCommonDetailsJsonObject = (FotorStoreJsonObjects.CommonDetailsJsonObject) this.w;
        if ((this.C) && (!TextUtils.isEmpty(localCommonDetailsJsonObject.promotionMsg))) {
            this.k.setText(localCommonDetailsJsonObject.promotionMsg);
            this.l.setVisibility(0);
        }
        com.everimaging.fotorsdk.uil.core.d.a().a(com.everimaging.fotorsdk.store.utils.d.b(localCommonDetailsJsonObject.detailThumb), this.c, this.m);
        final String str = com.everimaging.fotorsdk.store.utils.d.b(localCommonDetailsJsonObject.previewImg);
        this.g.getSettings().setJavaScriptEnabled(true);
        this.g.setWebViewClient(new WebViewClient() {
            private boolean c;

            public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
                int i = 8;
                int j = 0;
                e.i().c(new Object[]{"onPageFinished url:" + paramAnonymousString});
                e.a(e.this).setVisibility(8);
                if ((str != null) && (str.equals(paramAnonymousString))) {
                    paramAnonymousWebView = e.b(e.this);
                    if (this.c) {
                        i = 0;
                    }
                    paramAnonymousWebView.setVisibility(i);
                    paramAnonymousWebView = e.c(e.this);
                    i = j;
                    if (this.c) {
                        i = 4;
                    }
                    paramAnonymousWebView.setVisibility(i);
                }
            }

            public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                e.i().c(new Object[]{"onPageStarted url" + paramAnonymousString});
                e.b(e.this).setVisibility(8);
                e.a(e.this).setVisibility(0);
            }

            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {
                e.i().e(new Object[]{"onReceivedError failingUrl:" + paramAnonymousString2 + "requestUrl:" + str});
                if ((str != null) && (str.equals(paramAnonymousString2))) {
                    this.c = true;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                return true;
            }
        });
        this.g.loadUrl(str);
        if (!TextUtils.isEmpty(localCommonDetailsJsonObject.name)) {
            this.x.name = localCommonDetailsJsonObject.name;
        }
        if (!TextUtils.isEmpty(localCommonDetailsJsonObject.description)) {
            this.x.description = localCommonDetailsJsonObject.description;
        }
        j();
        this.f.setTag(localCommonDetailsJsonObject);
        this.f.setOnClickListener(this.n);
        this.l.setOnClickListener(this.o);
    }

    public void f() {
        super.f();
        a(this.f);
    }

    protected void g() {
        a(this.f);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */