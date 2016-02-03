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

public final class cw
  extends WebView
  implements DownloadListener
{
  private x fU;
  private final cu fV;
  private final Object fx = new Object();
  private final h he;
  private final cx iN;
  private final a iO;
  private bk iP;
  private boolean iQ;
  private boolean iR;
  
  private cw(a parama, x paramx, boolean paramBoolean1, boolean paramBoolean2, h paramh, cu paramcu)
  {
    super(parama);
    this.iO = parama;
    this.fU = paramx;
    this.iQ = paramBoolean1;
    this.he = paramh;
    this.fV = paramcu;
    setBackgroundColor(0);
    paramx = getSettings();
    paramx.setJavaScriptEnabled(true);
    paramx.setSavePassword(false);
    paramx.setSupportMultipleWindows(true);
    paramx.setJavaScriptCanOpenWindowsAutomatically(true);
    co.a(parama, paramcu.iJ, paramx);
    if (Build.VERSION.SDK_INT >= 17)
    {
      cq.a(getContext(), paramx);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label178;
      }
      this.iN = new cz(this, paramBoolean2);
      label126:
      setWebViewClient(this.iN);
      if (Build.VERSION.SDK_INT < 14) {
        break label195;
      }
      setWebChromeClient(new da(this));
    }
    for (;;)
    {
      aG();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      cp.a(getContext(), paramx);
      break;
      label178:
      this.iN = new cx(this, paramBoolean2);
      break label126;
      label195:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new cy(this));
      }
    }
  }
  
  public static cw a(Context paramContext, x paramx, boolean paramBoolean1, boolean paramBoolean2, h paramh, cu paramcu)
  {
    return new cw(new a(paramContext), paramx, paramBoolean1, paramBoolean2, paramh, paramcu);
  }
  
  private void aG()
  {
    for (;;)
    {
      synchronized (this.fx)
      {
        if ((this.iQ) || (this.fU.eG))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            ct.r("Disabling hardware acceleration on an overlay.");
            aH();
            return;
          }
          ct.r("Enabling hardware acceleration on an overlay.");
          aI();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        ct.r("Disabling hardware acceleration on an AdView.");
        aH();
      }
      else
      {
        ct.r("Enabling hardware acceleration on an AdView.");
        aI();
      }
    }
  }
  
  private void aH()
  {
    synchronized (this.fx)
    {
      if ((!this.iR) && (Build.VERSION.SDK_INT >= 11)) {
        cp.c(this);
      }
      this.iR = true;
      return;
    }
  }
  
  private void aI()
  {
    synchronized (this.fx)
    {
      if ((this.iR) && (Build.VERSION.SDK_INT >= 11)) {
        cp.d(this);
      }
      this.iR = false;
      return;
    }
  }
  
  public void a(Context paramContext, x paramx)
  {
    synchronized (this.fx)
    {
      this.iO.setBaseContext(paramContext);
      this.iP = null;
      this.fU = paramx;
      this.iQ = false;
      co.b(this);
      loadUrl("about:blank");
      this.iN.reset();
      return;
    }
  }
  
  public void a(bk parambk)
  {
    synchronized (this.fx)
    {
      this.iP = parambk;
      return;
    }
  }
  
  public void a(x paramx)
  {
    synchronized (this.fx)
    {
      this.fU = paramx;
      requestLayout();
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
      paramString = co.m(paramMap).toString();
      localStringBuilder.append(",");
      localStringBuilder.append(paramString);
      localStringBuilder.append(");");
      ct.u("Dispatching AFMA event: " + localStringBuilder);
      loadUrl(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramString)
    {
      ct.v("Could not convert AFMA event parameters to JSON.");
    }
  }
  
  public void aA()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.fV.iJ);
    a("onshow", localHashMap);
  }
  
  public bk aB()
  {
    synchronized (this.fx)
    {
      bk localbk = this.iP;
      return localbk;
    }
  }
  
  public cx aC()
  {
    return this.iN;
  }
  
  public h aD()
  {
    return this.he;
  }
  
  public cu aE()
  {
    return this.fV;
  }
  
  public boolean aF()
  {
    synchronized (this.fx)
    {
      boolean bool = this.iQ;
      return bool;
    }
  }
  
  public void az()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.fV.iJ);
    a("onhide", localHashMap);
  }
  
  public void l(boolean paramBoolean)
  {
    synchronized (this.fx)
    {
      this.iQ = paramBoolean;
      aG();
      return;
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
      ct.r("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
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
      synchronized (this.fx)
      {
        if ((isInEditMode()) || (this.iQ))
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
        if ((this.fU.widthPixels > paramInt1) || (this.fU.heightPixels > paramInt2))
        {
          ct.v("Not enough space to show ad. Needs " + this.fU.widthPixels + "x" + this.fU.heightPixels + " pixels, but only has " + i + "x" + k + " pixels.");
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
      setMeasuredDimension(this.fU.widthPixels, this.fU.heightPixels);
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
    if (this.he != null) {
      this.he.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    this.iO.setBaseContext(paramContext);
  }
  
  public x y()
  {
    synchronized (this.fx)
    {
      x localx = this.fU;
      return localx;
    }
  }
  
  private static class a
    extends MutableContextWrapper
  {
    private Activity iS;
    private Context iT;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.iT = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        this.iS = paramContext;
        super.setBaseContext(this.iT);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.iS != null)
      {
        this.iS.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.iT.startActivity(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */