package com.appbrain.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.al;
import cmn.k;
import com.appbrain.AppBrain;
import com.appbrain.AppBrainActivity.a;
import com.appbrain.e.j.f;
import com.appbrain.e.j.f.a;
import com.appbrain.e.j.h;
import com.appbrain.f.d;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public final class ce
  extends AppBrainActivity.a
{
  private static final d i = new d(new com.appbrain.f.b());
  protected j.h a = j.h.a;
  private WebView b;
  private ViewGroup c;
  private String d;
  private String e;
  private final Activity f;
  private ProgressDialog g;
  private cl h;
  
  public ce(Activity paramActivity)
  {
    this.f = paramActivity;
    this.h = new b(paramActivity);
  }
  
  private String a(j.f paramf)
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d != null)
    {
      localStringBuilder.append(this.d);
      if (this.d.contains("?")) {}
    }
    for (;;)
    {
      byte[] arrayOfByte;
      if (j != 0)
      {
        localStringBuilder.append("?");
        arrayOfByte = i.a(this.h.a(paramf, "ow")).b();
        paramf = new ByteArrayOutputStream();
      }
      try
      {
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramf);
        localGZIPOutputStream.write(arrayOfByte);
        localGZIPOutputStream.flush();
        localGZIPOutputStream.close();
        paramf = k.b(paramf.toByteArray());
        localStringBuilder.append("data=");
        localStringBuilder.append(paramf);
        return localStringBuilder.toString();
        j = 0;
        continue;
        localStringBuilder.append(this.e + aa.a().a("offer_url", "/offerwall/"));
        continue;
        localStringBuilder.append("&");
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    AppBrain.init(this.f);
    this.e = cz.a().e();
    this.a = j.h.a(this.f.getIntent().getIntExtra("src", -1));
    if (aa.a().c())
    {
      this.f.finish();
      return;
    }
    this.f.requestWindowFeature(1);
    paramBundle = this.f;
    this.b = new WebView(this.f);
    cg.a(this.f, this.b);
    this.b.setWebChromeClient(new a());
    this.b.setWebViewClient(new cf(this));
    this.b.setVerticalScrollBarEnabled(true);
    this.b.setHorizontalScrollBarEnabled(false);
    Object localObject = new FrameLayout(this.f);
    ((FrameLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject).addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    LinearLayout localLinearLayout = new LinearLayout(this.f);
    ((LinearLayout)localLinearLayout).setOrientation(0);
    ((LinearLayout)localLinearLayout).setGravity(1);
    TextView localTextView = new TextView(this.f);
    localTextView.setText("Loading...");
    localTextView.setTextColor(-12303292);
    localTextView.setPadding(10, 0, 0, 0);
    localTextView.setTextSize(18.0F);
    int j = 16842873;
    if (Build.VERSION.SDK_INT >= 4) {
      j = 16843400;
    }
    ProgressBar localProgressBar = new ProgressBar(this.f, null, j);
    localProgressBar.setIndeterminate(true);
    localLinearLayout.addView(localProgressBar);
    localLinearLayout.addView(localTextView);
    localLinearLayout.setPadding(20, 40, 0, 0);
    this.c = localLinearLayout;
    this.c.setVisibility(8);
    this.g = new ProgressDialog(this.f);
    this.g.setMessage("Loading apps...");
    this.g.setIndeterminate(true);
    this.g.setCancelable(true);
    ((FrameLayout)localObject).addView(this.c);
    this.d = (this.e + aa.a().a("offer_url", "/offerwall/"));
    paramBundle.setContentView((View)localObject);
    this.g.show();
    paramBundle = j.f.t();
    localObject = a.a.a(this.f.getIntent());
    paramBundle.a(((a.a)localObject).b);
    paramBundle.b(((a.a)localObject).a);
    if ((this.a != null) && (this.a != j.h.a)) {
      paramBundle.a(this.a);
    }
    for (;;)
    {
      j = this.f.getIntent().getIntExtra("bt", -1);
      if (j != -1) {
        paramBundle.c(j);
      }
      if (this.f.getIntent().hasExtra("bo")) {
        paramBundle.a(this.f.getIntent().getBooleanExtra("bo", false));
      }
      localObject = this.f.getIntent().getStringExtra("ca");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle.a((String)localObject);
      }
      paramBundle = a(paramBundle.d());
      this.b.loadUrl(paramBundle);
      cz.a().f();
      return;
      if (this.a != null) {
        paramBundle.a(this.a);
      } else {
        paramBundle.a(j.h.a);
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    if ((paramInt == 4) && (this.b != null) && (this.b.canGoBack()))
    {
      this.b.goBack();
      return true;
    }
    return false;
  }
  
  public final boolean d()
  {
    return (this.a == j.h.i) || (this.a == j.h.b);
  }
  
  public final void f()
  {
    if (this.b != null) {
      this.b.getSettings().setJavaScriptEnabled(false);
    }
  }
  
  final class a
    extends WebChromeClient
  {
    a() {}
    
    public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      paramJsResult.confirm();
      return true;
    }
    
    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if ((paramInt > 20) && (ce.d(ce.this).getVisibility() != 8)) {
        ce.d(ce.this).setVisibility(8);
      }
      if ((paramInt > 20) && (ce.e(ce.this).isShowing())) {
        al.a(ce.e(ce.this));
      }
      super.onProgressChanged(paramWebView, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */