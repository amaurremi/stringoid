package com.appbrain.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appbrain.e;
import com.appbrain.e.am;
import com.appbrain.e.an;
import com.appbrain.e.ap;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public final class x
  implements com.appbrain.f
{
  private static String i = null;
  private static final com.appbrain.f.f j = new com.appbrain.f.f(new com.appbrain.f.b());
  protected ap a = ap.a;
  private WebView b;
  private ViewGroup c;
  private String d;
  private String e;
  private final Activity f;
  private ProgressDialog g;
  private ag h;
  
  public x(Activity paramActivity)
  {
    this.f = paramActivity;
    this.h = new o(paramActivity);
  }
  
  private String a(am paramam)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d != null)
    {
      localStringBuilder.append(this.d);
      if (this.d.contains("?")) {}
    }
    for (;;)
    {
      byte[] arrayOfByte;
      if (k != 0)
      {
        localStringBuilder.append("?");
        arrayOfByte = j.a(this.h.a(paramam, "ow")).b();
        paramam = new ByteArrayOutputStream();
      }
      try
      {
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramam);
        localGZIPOutputStream.write(arrayOfByte);
        localGZIPOutputStream.flush();
        localGZIPOutputStream.close();
        paramam = cmn.aa.b(paramam.toByteArray());
        localStringBuilder.append("data=");
        localStringBuilder.append(paramam);
        return localStringBuilder.toString();
        k = 0;
        continue;
        localStringBuilder.append(this.e + aw.a().a("offer_url", "/offerwall/"));
        continue;
        localStringBuilder.append("&");
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(String paramString)
  {
    i = paramString;
  }
  
  public final void a() {}
  
  public final void a(Bundle paramBundle)
  {
    e.a(this.f);
    this.e = ao.a().e();
    this.a = ap.a(this.f.getIntent().getIntExtra("src", -1));
    if (aw.a().c())
    {
      this.f.finish();
      return;
    }
    this.f.requestWindowFeature(1);
    paramBundle = this.f;
    this.b = new WebView(this.f);
    aa.a(this.f, this.b);
    this.b.setWebChromeClient(new y(this));
    this.b.setWebViewClient(new z(this));
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
    int k = 16842873;
    if (Build.VERSION.SDK_INT >= 4) {
      k = 16843400;
    }
    ProgressBar localProgressBar = new ProgressBar(this.f, null, k);
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
    this.d = (this.e + aw.a().a("offer_url", "/offerwall/"));
    paramBundle.setContentView((View)localObject);
    this.g.show();
    paramBundle = am.t();
    localObject = b.a(this.f.getIntent());
    paramBundle.a(((b)localObject).b);
    paramBundle.b(((b)localObject).a);
    if ((this.a != null) && (this.a != ap.a)) {
      paramBundle.a(this.a);
    }
    for (;;)
    {
      k = this.f.getIntent().getIntExtra("bt", -1);
      if (k != -1) {
        paramBundle.c(k);
      }
      if (this.f.getIntent().hasExtra("bo")) {
        paramBundle.a(this.f.getIntent().getBooleanExtra("bo", false));
      }
      if (i != null)
      {
        paramBundle.a(i);
        i = null;
      }
      paramBundle = a(paramBundle.d());
      this.b.loadUrl(paramBundle);
      ao.a().f();
      return;
      if (this.a != null) {
        paramBundle.a(this.a);
      } else {
        paramBundle.a(ap.a);
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
  
  public final void b() {}
  
  public final void b(Bundle paramBundle) {}
  
  public final boolean c()
  {
    return (this.a == ap.i) || (this.a == ap.b);
  }
  
  public final void d()
  {
    if (this.b != null) {
      this.b.getSettings().setJavaScriptEnabled(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */