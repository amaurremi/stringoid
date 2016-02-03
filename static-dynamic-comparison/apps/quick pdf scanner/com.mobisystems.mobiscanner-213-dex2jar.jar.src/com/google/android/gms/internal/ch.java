package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ch
  extends WebViewClient
{
  protected final dd CB;
  private final HashMap<String, s> FV = new HashMap();
  private gu FW;
  private as FX;
  private a FY;
  private boolean FZ = false;
  private boolean Ga;
  private at Gb;
  private q xJ;
  private final Object xV = new Object();
  
  public ch(dd paramdd, boolean paramBoolean)
  {
    this.CB = paramdd;
    this.Ga = paramBoolean;
  }
  
  private void a(bq parambq)
  {
    bo.a(this.CB.getContext(), parambq);
  }
  
  private static boolean b(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void c(Uri paramUri)
  {
    String str = paramUri.getPath();
    s locals = (s)this.FV.get(str);
    if (locals != null)
    {
      HashMap localHashMap = new HashMap();
      Object localObject = new UrlQuerySanitizer();
      ((UrlQuerySanitizer)localObject).setAllowUnregisteredParamaters(true);
      ((UrlQuerySanitizer)localObject).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      ((UrlQuerySanitizer)localObject).parseUrl(paramUri.toString());
      paramUri = ((UrlQuerySanitizer)localObject).getParameterList().iterator();
      while (paramUri.hasNext())
      {
        localObject = (UrlQuerySanitizer.ParameterValuePair)paramUri.next();
        localHashMap.put(((UrlQuerySanitizer.ParameterValuePair)localObject).mParameter, ((UrlQuerySanitizer.ParameterValuePair)localObject).mValue);
      }
      if (ce.cB(2))
      {
        ce.C("Received GMSG: " + str);
        paramUri = localHashMap.keySet().iterator();
        while (paramUri.hasNext())
        {
          str = (String)paramUri.next();
          ce.C("  " + str + ": " + (String)localHashMap.get(str));
        }
      }
      locals.a(this.CB, localHashMap);
      return;
    }
    ce.D("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public final void F(boolean paramBoolean)
  {
    this.FZ = paramBoolean;
  }
  
  public final void a(bn parambn)
  {
    as localas = null;
    boolean bool = this.CB.qa();
    gu localgu;
    if ((bool) && (!this.CB.oO().xa))
    {
      localgu = null;
      if (!bool) {
        break label69;
      }
    }
    for (;;)
    {
      a(new bq(parambn, localgu, localas, this.Gb, this.CB.pZ()));
      return;
      localgu = this.FW;
      break;
      label69:
      localas = this.FX;
    }
  }
  
  public final void a(a parama)
  {
    this.FY = parama;
  }
  
  public void a(gu paramgu, as paramas, q paramq, at paramat, boolean paramBoolean)
  {
    a("/appEvent", new o(paramq));
    a("/canOpenURLs", r.xK);
    a("/click", r.xL);
    a("/close", r.xM);
    a("/customClose", r.xN);
    a("/httpTrack", r.xO);
    a("/log", r.xP);
    a("/open", r.xQ);
    a("/touch", r.xR);
    a("/video", r.xS);
    this.FW = paramgu;
    this.FX = paramas;
    this.xJ = paramq;
    this.Gb = paramat;
    F(paramBoolean);
  }
  
  public final void a(String paramString, s params)
  {
    this.FV.put(paramString, params);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.CB.qa()) && (!this.CB.oO().xa)) {}
    for (gu localgu = null;; localgu = this.FW)
    {
      a(new bq(localgu, this.FX, this.Gb, this.CB, paramBoolean, paramInt, this.CB.pZ()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    as localas = null;
    boolean bool = this.CB.qa();
    gu localgu;
    if ((bool) && (!this.CB.oO().xa))
    {
      localgu = null;
      if (!bool) {
        break label85;
      }
    }
    for (;;)
    {
      a(new bq(localgu, localas, this.xJ, this.Gb, this.CB, paramBoolean, paramInt, paramString, this.CB.pZ()));
      return;
      localgu = this.FW;
      break;
      label85:
      localas = this.FX;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    as localas = null;
    boolean bool = this.CB.qa();
    gu localgu;
    if ((bool) && (!this.CB.oO().xa))
    {
      localgu = null;
      if (!bool) {
        break label87;
      }
    }
    for (;;)
    {
      a(new bq(localgu, localas, this.xJ, this.Gb, this.CB, paramBoolean, paramInt, paramString1, paramString2, this.CB.pZ()));
      return;
      localgu = this.FW;
      break;
      label87:
      localas = this.FX;
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.FY != null)
    {
      this.FY.a(this.CB);
      this.FY = null;
    }
  }
  
  public final void pl()
  {
    synchronized (this.xV)
    {
      this.FZ = false;
      this.Ga = true;
      final bo localbo = this.CB.pW();
      if (localbo != null)
      {
        if (!cb.pR()) {
          cb.Fw.post(new Runnable()
          {
            public void run()
            {
              localbo.pl();
            }
          });
        }
      }
      else {
        return;
      }
      localbo.pl();
    }
  }
  
  public boolean qe()
  {
    synchronized (this.xV)
    {
      boolean bool = this.Ga;
      return bool;
    }
  }
  
  public final void reset()
  {
    synchronized (this.xV)
    {
      this.FV.clear();
      this.FW = null;
      this.FX = null;
      this.FY = null;
      this.xJ = null;
      this.FZ = false;
      this.Ga = false;
      this.Gb = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ce.C("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      c(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.FZ) && (paramWebView == this.CB) && (b(localUri))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.CB.willNotDraw())
      {
        try
        {
          gn localgn = this.CB.pY();
          paramWebView = localUri;
          if (localgn != null)
          {
            paramWebView = localUri;
            if (localgn.e(localUri)) {
              paramWebView = localgn.a(localUri, this.CB.getContext());
            }
          }
        }
        catch (m paramWebView)
        {
          for (;;)
          {
            ce.D("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
        }
        a(new bn("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
      else
      {
        ce.D("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(dd paramdd);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */