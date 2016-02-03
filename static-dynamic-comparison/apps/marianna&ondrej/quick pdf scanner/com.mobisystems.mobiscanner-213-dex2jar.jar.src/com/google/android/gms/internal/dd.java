package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class dd
  extends WebView
  implements DownloadListener
{
  private ab Cd;
  private final db Ce;
  private final gn Do;
  private final ch FO;
  private final a FP;
  private bo FQ;
  private boolean FR;
  private boolean FS;
  private final Object xV = new Object();
  
  private dd(a parama, ab paramab, boolean paramBoolean1, boolean paramBoolean2, gn paramgn, db paramdb)
  {
    super(parama);
    this.FP = parama;
    this.Cd = paramab;
    this.FR = paramBoolean1;
    this.Do = paramgn;
    this.Ce = paramdb;
    setBackgroundColor(0);
    paramab = getSettings();
    paramab.setJavaScriptEnabled(true);
    paramab.setSavePassword(false);
    paramab.setSupportMultipleWindows(true);
    paramab.setJavaScriptCanOpenWindowsAutomatically(true);
    bw.a(parama, paramdb.FK, paramab);
    if (Build.VERSION.SDK_INT >= 17)
    {
      by.a(getContext(), paramab);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label178;
      }
      this.FO = new cj(this, paramBoolean2);
      label126:
      setWebViewClient(this.FO);
      if (Build.VERSION.SDK_INT < 14) {
        break label195;
      }
      setWebChromeClient(new ck(this));
    }
    for (;;)
    {
      qb();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      bx.a(getContext(), paramab);
      break;
      label178:
      this.FO = new ch(this, paramBoolean2);
      break label126;
      label195:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new ci(this));
      }
    }
  }
  
  public static dd a(Context paramContext, ab paramab, boolean paramBoolean1, boolean paramBoolean2, gn paramgn, db paramdb)
  {
    return new dd(new a(paramContext), paramab, paramBoolean1, paramBoolean2, paramgn, paramdb);
  }
  
  private void qb()
  {
    for (;;)
    {
      synchronized (this.xV)
      {
        if ((this.FR) || (this.Cd.xa))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            ce.aG("Disabling hardware acceleration on an overlay.");
            qc();
            return;
          }
          ce.aG("Enabling hardware acceleration on an overlay.");
          qd();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        ce.aG("Disabling hardware acceleration on an AdView.");
        qc();
      }
      else
      {
        ce.aG("Enabling hardware acceleration on an AdView.");
        qd();
      }
    }
  }
  
  private void qc()
  {
    synchronized (this.xV)
    {
      if ((!this.FS) && (Build.VERSION.SDK_INT >= 11)) {
        bx.J(this);
      }
      this.FS = true;
      return;
    }
  }
  
  private void qd()
  {
    synchronized (this.xV)
    {
      if ((this.FS) && (Build.VERSION.SDK_INT >= 11)) {
        bx.K(this);
      }
      this.FS = false;
      return;
    }
  }
  
  public void E(boolean paramBoolean)
  {
    synchronized (this.xV)
    {
      this.FR = paramBoolean;
      qb();
      return;
    }
  }
  
  public void a(Context paramContext, ab paramab)
  {
    synchronized (this.xV)
    {
      this.FP.setBaseContext(paramContext);
      this.FQ = null;
      this.Cd = paramab;
      this.FR = false;
      bw.b(this);
      loadUrl("about:blank");
      this.FO.reset();
      return;
    }
  }
  
  public void a(ab paramab)
  {
    synchronized (this.xV)
    {
      this.Cd = paramab;
      requestLayout();
      return;
    }
  }
  
  public void a(bo parambo)
  {
    synchronized (this.xV)
    {
      this.FQ = parambo;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:AFMA_ReceiveMessage('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    if (paramMap != null) {}
    try
    {
      paramString = bw.B(paramMap).toString();
      localStringBuilder.append(",");
      localStringBuilder.append(paramString);
      localStringBuilder.append(");");
      ce.C("Dispatching AFMA event: " + localStringBuilder);
      loadUrl(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramString)
    {
      ce.D("Could not convert AFMA event parameters to JSON.");
    }
  }
  
  public ab oO()
  {
    synchronized (this.xV)
    {
      ab localab = this.Cd;
      return localab;
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
      ce.aG("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
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
      synchronized (this.xV)
      {
        if ((isInEditMode()) || (this.FR))
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
        if ((this.Cd.widthPixels > paramInt1) || (this.Cd.heightPixels > paramInt2))
        {
          ce.D("Not enough space to show ad. Needs " + this.Cd.widthPixels + "x" + this.Cd.heightPixels + " pixels, but only has " + i + "x" + k + " pixels.");
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
      setMeasuredDimension(this.Cd.widthPixels, this.Cd.heightPixels);
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
    if (this.Do != null) {
      this.Do.i(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void pU()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.Ce.FK);
    a("onhide", localHashMap);
  }
  
  public void pV()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.Ce.FK);
    a("onshow", localHashMap);
  }
  
  public bo pW()
  {
    synchronized (this.xV)
    {
      bo localbo = this.FQ;
      return localbo;
    }
  }
  
  public ch pX()
  {
    return this.FO;
  }
  
  public gn pY()
  {
    return this.Do;
  }
  
  public db pZ()
  {
    return this.Ce;
  }
  
  public boolean qa()
  {
    synchronized (this.xV)
    {
      boolean bool = this.FR;
      return bool;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.FP.setBaseContext(paramContext);
  }
  
  private static class a
    extends MutableContextWrapper
  {
    private Activity FT;
    private Context FU;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.FU = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        this.FT = paramContext;
        super.setBaseContext(this.FU);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.FT != null)
      {
        this.FT.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.FU.startActivity(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */