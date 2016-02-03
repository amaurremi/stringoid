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

public class cx
  extends WebViewClient
{
  private al fm;
  private final Object fx = new Object();
  protected final cw gv;
  private final HashMap<String, an> iU = new HashMap();
  private q iV;
  private bn iW;
  private a iX;
  private boolean iY = false;
  private boolean iZ;
  private bq ja;
  
  public cx(cw paramcw, boolean paramBoolean)
  {
    this.gv = paramcw;
    this.iZ = paramBoolean;
  }
  
  private void a(bm parambm)
  {
    bk.a(this.gv.getContext(), parambm);
  }
  
  private static boolean b(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void c(Uri paramUri)
  {
    String str = paramUri.getPath();
    an localan = (an)this.iU.get(str);
    if (localan != null)
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
      if (ct.n(2))
      {
        ct.u("Received GMSG: " + str);
        paramUri = localHashMap.keySet().iterator();
        while (paramUri.hasNext())
        {
          str = (String)paramUri.next();
          ct.u("  " + str + ": " + (String)localHashMap.get(str));
        }
      }
      localan.a(this.gv, localHashMap);
      return;
    }
    ct.v("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public final void Y()
  {
    synchronized (this.fx)
    {
      this.iY = false;
      this.iZ = true;
      final bk localbk = this.gv.aB();
      if (localbk != null)
      {
        if (!cs.ay()) {
          cs.iI.post(new Runnable()
          {
            public void run()
            {
              localbk.Y();
            }
          });
        }
      }
      else {
        return;
      }
      localbk.Y();
    }
  }
  
  public final void a(bj parambj)
  {
    bn localbn = null;
    boolean bool = this.gv.aF();
    q localq;
    if ((bool) && (!this.gv.y().eG))
    {
      localq = null;
      if (!bool) {
        break label69;
      }
    }
    for (;;)
    {
      a(new bm(parambj, localq, localbn, this.ja, this.gv.aE()));
      return;
      localq = this.iV;
      break;
      label69:
      localbn = this.iW;
    }
  }
  
  public final void a(a parama)
  {
    this.iX = parama;
  }
  
  public void a(q paramq, bn parambn, al paramal, bq parambq, boolean paramBoolean)
  {
    a("/appEvent", new ak(paramal));
    a("/canOpenURLs", am.fn);
    a("/click", am.fo);
    a("/close", am.fp);
    a("/customClose", am.fq);
    a("/httpTrack", am.fr);
    a("/log", am.fs);
    a("/open", am.ft);
    a("/touch", am.fu);
    a("/video", am.fv);
    this.iV = paramq;
    this.iW = parambn;
    this.fm = paramal;
    this.ja = parambq;
    m(paramBoolean);
  }
  
  public final void a(String paramString, an paraman)
  {
    this.iU.put(paramString, paraman);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.gv.aF()) && (!this.gv.y().eG)) {}
    for (q localq = null;; localq = this.iV)
    {
      a(new bm(localq, this.iW, this.ja, this.gv, paramBoolean, paramInt, this.gv.aE()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    bn localbn = null;
    boolean bool = this.gv.aF();
    q localq;
    if ((bool) && (!this.gv.y().eG))
    {
      localq = null;
      if (!bool) {
        break label85;
      }
    }
    for (;;)
    {
      a(new bm(localq, localbn, this.fm, this.ja, this.gv, paramBoolean, paramInt, paramString, this.gv.aE()));
      return;
      localq = this.iV;
      break;
      label85:
      localbn = this.iW;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    bn localbn = null;
    boolean bool = this.gv.aF();
    q localq;
    if ((bool) && (!this.gv.y().eG))
    {
      localq = null;
      if (!bool) {
        break label87;
      }
    }
    for (;;)
    {
      a(new bm(localq, localbn, this.fm, this.ja, this.gv, paramBoolean, paramInt, paramString1, paramString2, this.gv.aE()));
      return;
      localq = this.iV;
      break;
      label87:
      localbn = this.iW;
    }
  }
  
  public boolean aJ()
  {
    synchronized (this.fx)
    {
      boolean bool = this.iZ;
      return bool;
    }
  }
  
  public final void m(boolean paramBoolean)
  {
    this.iY = paramBoolean;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.iX != null)
    {
      this.iX.a(this.gv);
      this.iX = null;
    }
  }
  
  public final void reset()
  {
    synchronized (this.fx)
    {
      this.iU.clear();
      this.iV = null;
      this.iW = null;
      this.iX = null;
      this.fm = null;
      this.iY = false;
      this.iZ = false;
      this.ja = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ct.u("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      c(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.iY) && (paramWebView == this.gv) && (b(localUri))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.gv.willNotDraw())
      {
        try
        {
          h localh = this.gv.aD();
          paramWebView = localUri;
          if (localh != null)
          {
            paramWebView = localUri;
            if (localh.a(localUri)) {
              paramWebView = localh.a(localUri, this.gv.getContext());
            }
          }
        }
        catch (i paramWebView)
        {
          for (;;)
          {
            ct.v("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
        }
        a(new bj("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
      else
      {
        ct.v("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(cw paramcw);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */