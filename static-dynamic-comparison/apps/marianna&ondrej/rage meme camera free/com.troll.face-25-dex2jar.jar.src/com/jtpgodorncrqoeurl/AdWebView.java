package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

public class AdWebView
  extends WebView
{
  private Context a;
  private RelativeLayout b;
  private AdController c;
  private AdListener d;
  private WebSettings e;
  private JSONObject f;
  private String g;
  private boolean h = false;
  private boolean i = false;
  private ProgressDialog j;
  private int k = 0;
  
  public AdWebView(Activity paramActivity, AdController paramAdController, boolean paramBoolean, AdListener paramAdListener)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.c = paramAdController;
    this.i = paramBoolean;
    this.d = paramAdListener;
    a();
  }
  
  public AdWebView(Activity paramActivity, AdController paramAdController, boolean paramBoolean, AdListener paramAdListener, RelativeLayout paramRelativeLayout)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.c = paramAdController;
    this.i = paramBoolean;
    this.d = paramAdListener;
    this.b = paramRelativeLayout;
    a();
  }
  
  public AdWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a(paramAttributeSet);
  }
  
  public AdWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
  }
  
  private String a(int paramInt)
  {
    try
    {
      Object localObject = BitmapFactory.decodeResource(this.a.getResources(), paramInt);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localObject = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void a()
  {
    this.e = getSettings();
    this.e.setJavaScriptEnabled(true);
    this.e.setJavaScriptCanOpenWindowsAutomatically(true);
    this.e.setDomStorageEnabled(true);
    addJavascriptInterface(new AdJSInterface(this.a, this.c, this.d), "LBOUT");
    if (Build.VERSION.SDK_INT >= 8) {
      this.e.setPluginState(WebSettings.PluginState.ON);
    }
    setWebChromeClient(new aa(this, this.a, this.b));
    setWebViewClient(new ae(this, this.a, this.c, this));
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      this.c = new AdController((Activity)this.a, paramAttributeSet.getAttributeValue(null, "sectionid"));
      a();
    }
  }
  
  public void setLoadingURL(String paramString)
  {
    this.g = paramString;
  }
  
  public void setResults(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
  }
  
  public void showAd()
  {
    this.c.loadAd();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */