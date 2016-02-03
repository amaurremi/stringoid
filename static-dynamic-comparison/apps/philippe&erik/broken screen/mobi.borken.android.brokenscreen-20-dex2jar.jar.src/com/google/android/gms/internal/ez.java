package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ez
  extends WebViewClient
{
  protected final ey lL;
  private final Object lq = new Object();
  private bb mQ;
  private bg na;
  private be nb;
  private a pL;
  private final HashMap<String, bd> sE = new HashMap();
  private u sF;
  private cj sG;
  private boolean sH = false;
  private boolean sI;
  private cm sJ;
  
  public ez(ey paramey, boolean paramBoolean)
  {
    this.lL = paramey;
    this.sI = paramBoolean;
  }
  
  private static boolean c(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void d(Uri paramUri)
  {
    Object localObject = paramUri.getPath();
    bd localbd = (bd)this.sE.get(localObject);
    if (localbd != null)
    {
      paramUri = ep.b(paramUri);
      if (ev.p(2))
      {
        ev.C("Received GMSG: " + (String)localObject);
        localObject = paramUri.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ev.C("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localbd.b(this.lL, paramUri);
      return;
    }
    ev.C("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public final void a(cf paramcf)
  {
    cj localcj = null;
    boolean bool = this.lL.bZ();
    u localu;
    if ((bool) && (!this.lL.Q().md))
    {
      localu = null;
      if (!bool) {
        break label69;
      }
    }
    for (;;)
    {
      a(new ci(paramcf, localu, localcj, this.sJ, this.lL.bY()));
      return;
      localu = this.sF;
      break;
      label69:
      localcj = this.sG;
    }
  }
  
  protected void a(ci paramci)
  {
    cg.a(this.lL.getContext(), paramci);
  }
  
  public final void a(a parama)
  {
    this.pL = parama;
  }
  
  public void a(u paramu, cj paramcj, bb parambb, cm paramcm, boolean paramBoolean, be parambe)
  {
    a("/appEvent", new ba(parambb));
    a("/canOpenURLs", bc.mS);
    a("/click", bc.mT);
    a("/close", bc.mU);
    a("/customClose", bc.mV);
    a("/httpTrack", bc.mW);
    a("/log", bc.mX);
    a("/open", new bh(parambe));
    a("/touch", bc.mY);
    a("/video", bc.mZ);
    this.sF = paramu;
    this.sG = paramcj;
    this.mQ = parambb;
    this.nb = parambe;
    this.sJ = paramcm;
    r(paramBoolean);
  }
  
  public void a(u paramu, cj paramcj, bb parambb, cm paramcm, boolean paramBoolean, be parambe, bg parambg)
  {
    a(paramu, paramcj, parambb, paramcm, paramBoolean, parambe);
    a("/setInterstitialProperties", new bf(parambg));
    this.na = parambg;
  }
  
  public final void a(String paramString, bd parambd)
  {
    this.sE.put(paramString, parambd);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.lL.bZ()) && (!this.lL.Q().md)) {}
    for (u localu = null;; localu = this.sF)
    {
      a(new ci(localu, this.sG, this.sJ, this.lL, paramBoolean, paramInt, this.lL.bY()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    cj localcj = null;
    boolean bool = this.lL.bZ();
    u localu;
    if ((bool) && (!this.lL.Q().md))
    {
      localu = null;
      if (!bool) {
        break label89;
      }
    }
    for (;;)
    {
      a(new ci(localu, localcj, this.mQ, this.sJ, this.lL, paramBoolean, paramInt, paramString, this.lL.bY(), this.nb));
      return;
      localu = this.sF;
      break;
      label89:
      localcj = this.sG;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.lL.bZ();
    u localu;
    if ((bool) && (!this.lL.Q().md))
    {
      localu = null;
      if (!bool) {
        break label91;
      }
    }
    label91:
    for (cj localcj = null;; localcj = this.sG)
    {
      a(new ci(localu, localcj, this.mQ, this.sJ, this.lL, paramBoolean, paramInt, paramString1, paramString2, this.lL.bY(), this.nb));
      return;
      localu = this.sF;
      break;
    }
  }
  
  public final void aN()
  {
    synchronized (this.lq)
    {
      this.sH = false;
      this.sI = true;
      final cg localcg = this.lL.bV();
      if (localcg != null)
      {
        if (!eu.bR()) {
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              localcg.aN();
            }
          });
        }
      }
      else {
        return;
      }
      localcg.aN();
    }
  }
  
  public boolean ce()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sI;
      return bool;
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    ev.C("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      d(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.pL != null)
    {
      this.pL.a(this.lL);
      this.pL = null;
    }
  }
  
  public final void r(boolean paramBoolean)
  {
    this.sH = paramBoolean;
  }
  
  public final void reset()
  {
    synchronized (this.lq)
    {
      this.sE.clear();
      this.sF = null;
      this.sG = null;
      this.pL = null;
      this.mQ = null;
      this.sH = false;
      this.sI = false;
      this.nb = null;
      this.sJ = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ev.C("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      d(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.sH) && (paramWebView == this.lL) && (c(localUri))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.lL.willNotDraw())
      {
        try
        {
          l locall = this.lL.bX();
          paramWebView = localUri;
          if (locall != null)
          {
            paramWebView = localUri;
            if (locall.a(localUri)) {
              paramWebView = locall.a(localUri, this.lL.getContext());
            }
          }
        }
        catch (m paramWebView)
        {
          for (;;)
          {
            ev.D("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
        }
        a(new cf("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
      else
      {
        ev.D("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ey paramey);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */