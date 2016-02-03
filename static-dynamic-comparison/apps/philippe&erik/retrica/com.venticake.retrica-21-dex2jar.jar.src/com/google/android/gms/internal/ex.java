package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

public class ex
  extends WebView
  implements DownloadListener
{
  private final WindowManager lC;
  private final Object ls = new Object();
  private al nF;
  private final ev nG;
  private final k pA;
  private final ey sA;
  private final nd sB;
  private cf sC;
  private boolean sD;
  private boolean sE;
  private boolean sF;
  
  private ex(nd paramnd, al paramal, boolean paramBoolean1, boolean paramBoolean2, k paramk, ev paramev)
  {
    super(paramnd);
    this.sB = paramnd;
    this.nF = paramal;
    this.sD = paramBoolean1;
    this.pA = paramk;
    this.nG = paramev;
    this.lC = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramal = getSettings();
    paramal.setJavaScriptEnabled(true);
    paramal.setSavePassword(false);
    paramal.setSupportMultipleWindows(true);
    paramal.setJavaScriptCanOpenWindowsAutomatically(true);
    eo.a(paramnd, paramev.sw, paramal);
    if (Build.VERSION.SDK_INT >= 17)
    {
      er.a(getContext(), paramal);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label194;
      }
      this.sA = new fa(this, paramBoolean2);
      label142:
      setWebViewClient(this.sA);
      if (Build.VERSION.SDK_INT < 14) {
        break label211;
      }
      setWebChromeClient(new fb(this));
    }
    for (;;)
    {
      cg();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      eq.a(getContext(), paramal);
      break;
      label194:
      this.sA = new ey(this, paramBoolean2);
      break label142;
      label211:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new ez(this));
      }
    }
  }
  
  public static ex a(Context paramContext, al paramal, boolean paramBoolean1, boolean paramBoolean2, k paramk, ev paramev)
  {
    return new ex(new nd(paramContext), paramal, paramBoolean1, paramBoolean2, paramk, paramev);
  }
  
  private void cg()
  {
    for (;;)
    {
      synchronized (this.ls)
      {
        if ((this.sD) || (this.nF.mf))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            eu.z("Disabling hardware acceleration on an overlay.");
            ch();
            return;
          }
          eu.z("Enabling hardware acceleration on an overlay.");
          ci();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        eu.z("Disabling hardware acceleration on an AdView.");
        ch();
      }
      else
      {
        eu.z("Enabling hardware acceleration on an AdView.");
        ci();
      }
    }
  }
  
  private void ch()
  {
    synchronized (this.ls)
    {
      if ((!this.sE) && (Build.VERSION.SDK_INT >= 11)) {
        eq.d(this);
      }
      this.sE = true;
      return;
    }
  }
  
  private void ci()
  {
    synchronized (this.ls)
    {
      if ((this.sE) && (Build.VERSION.SDK_INT >= 11)) {
        eq.e(this);
      }
      this.sE = false;
      return;
    }
  }
  
  protected void E(String paramString)
  {
    synchronized (this.ls)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      eu.D("The webview is destroyed. Ignoring action.");
    }
  }
  
  public al V()
  {
    synchronized (this.ls)
    {
      al localal = this.nF;
      return localal;
    }
  }
  
  public void a(Context paramContext, al paramal)
  {
    synchronized (this.ls)
    {
      this.sB.setBaseContext(paramContext);
      this.sC = null;
      this.nF = paramal;
      this.sD = false;
      eo.b(this);
      loadUrl("about:blank");
      this.sA.reset();
      return;
    }
  }
  
  public void a(al paramal)
  {
    synchronized (this.ls)
    {
      this.nF = paramal;
      requestLayout();
      return;
    }
  }
  
  public void a(cf paramcf)
  {
    synchronized (this.ls)
    {
      this.sC = paramcf;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = eo.o(paramMap);
      b(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      eu.D("Could not convert parameters to JSON.");
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
    E(((StringBuilder)localObject).toString());
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
    eu.C("Dispatching AFMA event: " + localObject);
    E(((StringBuilder)localObject).toString());
  }
  
  public void bX()
  {
    if (!cb().cj()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = this.lC.getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    int j = eo.p(getContext());
    float f = 160.0F / localDisplayMetrics.densityDpi;
    int i = (int)(localDisplayMetrics.widthPixels * f);
    j = (int)((localDisplayMetrics.heightPixels - j) * f);
    try
    {
      b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", j).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      return;
    }
    catch (JSONException localJSONException)
    {
      eu.b("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void bY()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nG.sw);
    a("onhide", localHashMap);
  }
  
  public void bZ()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nG.sw);
    a("onshow", localHashMap);
  }
  
  public cf ca()
  {
    synchronized (this.ls)
    {
      cf localcf = this.sC;
      return localcf;
    }
  }
  
  public ey cb()
  {
    return this.sA;
  }
  
  public k cc()
  {
    return this.pA;
  }
  
  public ev cd()
  {
    return this.nG;
  }
  
  public boolean ce()
  {
    synchronized (this.ls)
    {
      boolean bool = this.sD;
      return bool;
    }
  }
  
  public Context cf()
  {
    return this.sB.a();
  }
  
  public void destroy()
  {
    synchronized (this.ls)
    {
      super.destroy();
      this.sF = true;
      return;
    }
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.ls)
    {
      boolean bool = this.sF;
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
      eu.z("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
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
      synchronized (this.ls)
      {
        if ((isInEditMode()) || (this.sD))
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
        int n = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.getSize(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        k = View.MeasureSpec.getSize(paramInt2);
        if (n == Integer.MIN_VALUE) {
          break label280;
        }
        if (n != 1073741824) {
          break label273;
        }
        break label280;
        if ((this.nF.widthPixels > paramInt1) || (this.nF.heightPixels > paramInt2))
        {
          float f = this.sB.getResources().getDisplayMetrics().density;
          eu.D("Not enough space to show ad. Needs " + (int)(this.nF.widthPixels / f) + "x" + (int)(this.nF.heightPixels / f) + " dp, but only has " + (int)(i / f) + "x" + (int)(k / f) + " dp.");
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
      setMeasuredDimension(this.nF.widthPixels, this.nF.heightPixels);
      continue;
      label273:
      paramInt1 = Integer.MAX_VALUE;
      break label283;
      label280:
      paramInt1 = i;
      label283:
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
    if (this.pA != null) {
      this.pA.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void q(boolean paramBoolean)
  {
    synchronized (this.ls)
    {
      this.sD = paramBoolean;
      cg();
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.sB.setBaseContext(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */