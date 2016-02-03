package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
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

public class ey
  extends WebView
  implements DownloadListener
{
  private final WindowManager lA;
  private final Object lq = new Object();
  private am nD;
  private final ew nE;
  private final l py;
  private boolean sA;
  private boolean sB;
  private boolean sC;
  private final ez sx;
  private final a sy;
  private cg sz;
  
  private ey(a parama, am paramam, boolean paramBoolean1, boolean paramBoolean2, l paraml, ew paramew)
  {
    super(parama);
    this.sy = parama;
    this.nD = paramam;
    this.sA = paramBoolean1;
    this.py = paraml;
    this.nE = paramew;
    this.lA = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramam = getSettings();
    paramam.setJavaScriptEnabled(true);
    paramam.setSavePassword(false);
    paramam.setSupportMultipleWindows(true);
    paramam.setJavaScriptCanOpenWindowsAutomatically(true);
    ep.a(parama, paramew.st, paramam);
    if (Build.VERSION.SDK_INT >= 17)
    {
      es.a(getContext(), paramam);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label194;
      }
      this.sx = new fb(this, paramBoolean2);
      label142:
      setWebViewClient(this.sx);
      if (Build.VERSION.SDK_INT < 14) {
        break label211;
      }
      setWebChromeClient(new fc(this));
    }
    for (;;)
    {
      cb();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      er.a(getContext(), paramam);
      break;
      label194:
      this.sx = new ez(this, paramBoolean2);
      break label142;
      label211:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new fa(this));
      }
    }
  }
  
  public static ey a(Context paramContext, am paramam, boolean paramBoolean1, boolean paramBoolean2, l paraml, ew paramew)
  {
    return new ey(new a(paramContext), paramam, paramBoolean1, paramBoolean2, paraml, paramew);
  }
  
  private void cb()
  {
    for (;;)
    {
      synchronized (this.lq)
      {
        if ((this.sA) || (this.nD.md))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            ev.z("Disabling hardware acceleration on an overlay.");
            cc();
            return;
          }
          ev.z("Enabling hardware acceleration on an overlay.");
          cd();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        ev.z("Disabling hardware acceleration on an AdView.");
        cc();
      }
      else
      {
        ev.z("Enabling hardware acceleration on an AdView.");
        cd();
      }
    }
  }
  
  private void cc()
  {
    synchronized (this.lq)
    {
      if ((!this.sB) && (Build.VERSION.SDK_INT >= 11)) {
        er.d(this);
      }
      this.sB = true;
      return;
    }
  }
  
  private void cd()
  {
    synchronized (this.lq)
    {
      if ((this.sB) && (Build.VERSION.SDK_INT >= 11)) {
        er.e(this);
      }
      this.sB = false;
      return;
    }
  }
  
  protected void E(String paramString)
  {
    synchronized (this.lq)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      ev.D("The webview is destroyed. Ignoring action.");
    }
  }
  
  public am Q()
  {
    synchronized (this.lq)
    {
      am localam = this.nD;
      return localam;
    }
  }
  
  public void a(Context paramContext, am paramam)
  {
    synchronized (this.lq)
    {
      this.sy.setBaseContext(paramContext);
      this.sz = null;
      this.nD = paramam;
      this.sA = false;
      ep.b(this);
      loadUrl("about:blank");
      this.sx.reset();
      return;
    }
  }
  
  public void a(am paramam)
  {
    synchronized (this.lq)
    {
      this.nD = paramam;
      requestLayout();
      return;
    }
  }
  
  public void a(cg paramcg)
  {
    synchronized (this.lq)
    {
      this.sz = paramcg;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = ep.o(paramMap);
      b(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      ev.D("Could not convert parameters to JSON.");
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
    ev.C("Dispatching AFMA event: " + localObject);
    E(((StringBuilder)localObject).toString());
  }
  
  public void bS()
  {
    if (!bW().ce()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = this.lA.getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    int j = ep.m(getContext());
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
      ev.b("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void bT()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nE.st);
    a("onhide", localHashMap);
  }
  
  public void bU()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nE.st);
    a("onshow", localHashMap);
  }
  
  public cg bV()
  {
    synchronized (this.lq)
    {
      cg localcg = this.sz;
      return localcg;
    }
  }
  
  public ez bW()
  {
    return this.sx;
  }
  
  public l bX()
  {
    return this.py;
  }
  
  public ew bY()
  {
    return this.nE;
  }
  
  public boolean bZ()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sA;
      return bool;
    }
  }
  
  public Context ca()
  {
    return this.sy.ca();
  }
  
  public void destroy()
  {
    synchronized (this.lq)
    {
      super.destroy();
      this.sC = true;
      return;
    }
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sC;
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
      ev.z("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
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
      synchronized (this.lq)
      {
        if ((isInEditMode()) || (this.sA))
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
        if ((this.nD.widthPixels > paramInt1) || (this.nD.heightPixels > paramInt2))
        {
          float f = this.sy.getResources().getDisplayMetrics().density;
          ev.D("Not enough space to show ad. Needs " + (int)(this.nD.widthPixels / f) + "x" + (int)(this.nD.heightPixels / f) + " dp, but only has " + (int)(i / f) + "x" + (int)(k / f) + " dp.");
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
      setMeasuredDimension(this.nD.widthPixels, this.nD.heightPixels);
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
    if (this.py != null) {
      this.py.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void q(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      this.sA = paramBoolean;
      cb();
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.sy.setBaseContext(paramContext);
  }
  
  private static class a
    extends MutableContextWrapper
  {
    private Context lx;
    private Activity sD;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Context ca()
    {
      return this.sD;
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.lx = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        this.sD = paramContext;
        super.setBaseContext(this.lx);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.sD != null)
      {
        this.sD.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.lx.startActivity(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */