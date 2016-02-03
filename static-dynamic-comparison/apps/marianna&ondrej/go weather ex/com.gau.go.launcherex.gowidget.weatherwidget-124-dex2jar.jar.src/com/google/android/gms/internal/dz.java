package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dz
  extends WebView
  implements DownloadListener
{
  private final Object li = new Object();
  private final WindowManager ls;
  private ak nq;
  private final dx nr;
  private final l oJ;
  private final ea ru;
  private final a rv;
  private cc rw;
  private boolean rx;
  private boolean ry;
  
  private dz(a parama, ak paramak, boolean paramBoolean1, boolean paramBoolean2, l paraml, dx paramdx)
  {
    super(parama);
    this.rv = parama;
    this.nq = paramak;
    this.rx = paramBoolean1;
    this.oJ = paraml;
    this.nr = paramdx;
    this.ls = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramak = getSettings();
    paramak.setJavaScriptEnabled(true);
    paramak.setSavePassword(false);
    paramak.setSupportMultipleWindows(true);
    paramak.setJavaScriptCanOpenWindowsAutomatically(true);
    dq.a(parama, paramdx.rq, paramak);
    if (Build.VERSION.SDK_INT >= 17)
    {
      dt.a(getContext(), paramak);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label194;
      }
      this.ru = new ec(this, paramBoolean2);
      label142:
      setWebViewClient(this.ru);
      if (Build.VERSION.SDK_INT < 14) {
        break label211;
      }
      setWebChromeClient(new ed(this));
    }
    for (;;)
    {
      bM();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      ds.a(getContext(), paramak);
      break;
      label194:
      this.ru = new ea(this, paramBoolean2);
      break label142;
      label211:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new eb(this));
      }
    }
  }
  
  public static dz a(Context paramContext, ak paramak, boolean paramBoolean1, boolean paramBoolean2, l paraml, dx paramdx)
  {
    return new dz(new a(paramContext), paramak, paramBoolean1, paramBoolean2, paraml, paramdx);
  }
  
  private void bM()
  {
    for (;;)
    {
      synchronized (this.li)
      {
        if ((this.rx) || (this.nq.lT))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            dw.v("Disabling hardware acceleration on an overlay.");
            bN();
            return;
          }
          dw.v("Enabling hardware acceleration on an overlay.");
          bO();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        dw.v("Disabling hardware acceleration on an AdView.");
        bN();
      }
      else
      {
        dw.v("Enabling hardware acceleration on an AdView.");
        bO();
      }
    }
  }
  
  private void bN()
  {
    synchronized (this.li)
    {
      if ((!this.ry) && (Build.VERSION.SDK_INT >= 11)) {
        ds.d(this);
      }
      this.ry = true;
      return;
    }
  }
  
  private void bO()
  {
    synchronized (this.li)
    {
      if ((this.ry) && (Build.VERSION.SDK_INT >= 11)) {
        ds.e(this);
      }
      this.ry = false;
      return;
    }
  }
  
  public ak R()
  {
    synchronized (this.li)
    {
      ak localak = this.nq;
      return localak;
    }
  }
  
  public void a(Context paramContext, ak paramak)
  {
    synchronized (this.li)
    {
      this.rv.setBaseContext(paramContext);
      this.rw = null;
      this.nq = paramak;
      this.rx = false;
      dq.b(this);
      loadUrl("about:blank");
      this.ru.reset();
      return;
    }
  }
  
  public void a(ak paramak)
  {
    synchronized (this.li)
    {
      this.nq = paramak;
      requestLayout();
      return;
    }
  }
  
  public void a(cc paramcc)
  {
    synchronized (this.li)
    {
      this.rw = paramcc;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = dq.p(paramMap);
      b(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      dw.z("Could not convert parameters to JSON.");
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = ((JSONObject)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("javascript:" + paramString + "(");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(");");
    loadUrl(((StringBuilder)localObject).toString());
  }
  
  public void b(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = ((JSONObject)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("javascript:AFMA_ReceiveMessage('");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("'");
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(");");
    dw.y("Dispatching AFMA event: " + localObject);
    loadUrl(((StringBuilder)localObject).toString());
  }
  
  public void bE()
  {
    if (!bI().bP()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = this.ls.getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    try
    {
      b("onScreenInfoChanged", new JSONObject().put("width", localDisplayMetrics.widthPixels).put("height", localDisplayMetrics.heightPixels).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      return;
    }
    catch (JSONException localJSONException)
    {
      dw.b("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void bF()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nr.rq);
    a("onhide", localHashMap);
  }
  
  public void bG()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nr.rq);
    a("onshow", localHashMap);
  }
  
  public cc bH()
  {
    synchronized (this.li)
    {
      cc localcc = this.rw;
      return localcc;
    }
  }
  
  public ea bI()
  {
    return this.ru;
  }
  
  public l bJ()
  {
    return this.oJ;
  }
  
  public dx bK()
  {
    return this.nr;
  }
  
  public boolean bL()
  {
    synchronized (this.li)
    {
      boolean bool = this.rx;
      return bool;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      getContext().startActivity(paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      dw.v("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    for (;;)
    {
      int i;
      int m;
      int k;
      synchronized (this.li)
      {
        if ((isInEditMode()) || (this.rx))
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
        int n = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.getSize(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        k = View.MeasureSpec.getSize(paramInt2);
        if (n == Integer.MIN_VALUE) {
          break label248;
        }
        if (n != 1073741824) {
          break label241;
        }
        break label248;
        if ((this.nq.widthPixels > paramInt1) || (this.nq.heightPixels > paramInt2))
        {
          dw.z("Not enough space to show ad. Needs " + this.nq.widthPixels + "x" + this.nq.heightPixels + " pixels, but only has " + i + "x" + k + " pixels.");
          if (getVisibility() != 8) {
            setVisibility(4);
          }
          setMeasuredDimension(0, 0);
          return;
        }
      }
      if (getVisibility() != 8) {
        setVisibility(0);
      }
      setMeasuredDimension(this.nq.widthPixels, this.nq.heightPixels);
      continue;
      label241:
      paramInt1 = Integer.MAX_VALUE;
      break label250;
      label248:
      paramInt1 = i;
      label250:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = j;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = k;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.oJ != null) {
      this.oJ.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void p(boolean paramBoolean)
  {
    synchronized (this.li)
    {
      this.rx = paramBoolean;
      bM();
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.rv.setBaseContext(paramContext);
  }
  
  private static class a
    extends MutableContextWrapper
  {
    private Context lp;
    private Activity rz;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.lp = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        this.rz = paramContext;
        super.setBaseContext(this.lp);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.rz != null)
      {
        this.rz.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.lp.startActivity(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */