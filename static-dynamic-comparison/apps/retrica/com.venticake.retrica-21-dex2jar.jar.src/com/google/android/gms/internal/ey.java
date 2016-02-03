package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ey
  extends WebViewClient
{
  protected final ex lN;
  private final Object ls = new Object();
  private ba mS;
  private bf nc;
  private bd nd;
  private ey.a pN;
  private final HashMap<String, bc> sH = new HashMap();
  private t sI;
  private ci sJ;
  private boolean sK = false;
  private boolean sL;
  private cl sM;
  
  public ey(ex paramex, boolean paramBoolean)
  {
    this.lN = paramex;
    this.sL = paramBoolean;
  }
  
  private static boolean d(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void e(Uri paramUri)
  {
    Object localObject = paramUri.getPath();
    bc localbc = (bc)this.sH.get(localObject);
    if (localbc != null)
    {
      paramUri = eo.c(paramUri);
      if (eu.p(2))
      {
        eu.C("Received GMSG: " + (String)localObject);
        localObject = paramUri.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          eu.C("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localbc.b(this.lN, paramUri);
      return;
    }
    eu.C("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public final void a(ce paramce)
  {
    ci localci = null;
    boolean bool = this.lN.ce();
    t localt;
    if ((bool) && (!this.lN.V().mf))
    {
      localt = null;
      if (!bool) {
        break label69;
      }
    }
    for (;;)
    {
      a(new ch(paramce, localt, localci, this.sM, this.lN.cd()));
      return;
      localt = this.sI;
      break;
      label69:
      localci = this.sJ;
    }
  }
  
  protected void a(ch paramch)
  {
    cf.a(this.lN.getContext(), paramch);
  }
  
  public final void a(ey.a parama)
  {
    this.pN = parama;
  }
  
  public void a(t paramt, ci paramci, ba paramba, cl paramcl, boolean paramBoolean, bd parambd)
  {
    a("/appEvent", new az(paramba));
    a("/canOpenURLs", bb.mU);
    a("/click", bb.mV);
    a("/close", bb.mW);
    a("/customClose", bb.mX);
    a("/httpTrack", bb.mY);
    a("/log", bb.mZ);
    a("/open", new bg(parambd));
    a("/touch", bb.na);
    a("/video", bb.nb);
    this.sI = paramt;
    this.sJ = paramci;
    this.mS = paramba;
    this.nd = parambd;
    this.sM = paramcl;
    r(paramBoolean);
  }
  
  public void a(t paramt, ci paramci, ba paramba, cl paramcl, boolean paramBoolean, bd parambd, bf parambf)
  {
    a(paramt, paramci, paramba, paramcl, paramBoolean, parambd);
    a("/setInterstitialProperties", new be(parambf));
    this.nc = parambf;
  }
  
  public final void a(String paramString, bc parambc)
  {
    this.sH.put(paramString, parambc);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.lN.ce()) && (!this.lN.V().mf)) {}
    for (t localt = null;; localt = this.sI)
    {
      a(new ch(localt, this.sJ, this.sM, this.lN, paramBoolean, paramInt, this.lN.cd()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ci localci = null;
    boolean bool = this.lN.ce();
    t localt;
    if ((bool) && (!this.lN.V().mf))
    {
      localt = null;
      if (!bool) {
        break label89;
      }
    }
    for (;;)
    {
      a(new ch(localt, localci, this.mS, this.sM, this.lN, paramBoolean, paramInt, paramString, this.lN.cd(), this.nd));
      return;
      localt = this.sI;
      break;
      label89:
      localci = this.sJ;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.lN.ce();
    t localt;
    if ((bool) && (!this.lN.V().mf))
    {
      localt = null;
      if (!bool) {
        break label91;
      }
    }
    label91:
    for (ci localci = null;; localci = this.sJ)
    {
      a(new ch(localt, localci, this.mS, this.sM, this.lN, paramBoolean, paramInt, paramString1, paramString2, this.lN.cd(), this.nd));
      return;
      localt = this.sI;
      break;
    }
  }
  
  public final void aS()
  {
    synchronized (this.ls)
    {
      this.sK = false;
      this.sL = true;
      final cf localcf = this.lN.ca();
      if (localcf != null)
      {
        if (!et.bW()) {
          et.sv.post(new Runnable()
          {
            public void run()
            {
              localcf.aS();
            }
          });
        }
      }
      else {
        return;
      }
      localcf.aS();
    }
  }
  
  public boolean cj()
  {
    synchronized (this.ls)
    {
      boolean bool = this.sL;
      return bool;
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    eu.C("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      e(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.pN != null)
    {
      this.pN.a(this.lN);
      this.pN = null;
    }
  }
  
  public final void r(boolean paramBoolean)
  {
    this.sK = paramBoolean;
  }
  
  public final void reset()
  {
    synchronized (this.ls)
    {
      this.sH.clear();
      this.sI = null;
      this.sJ = null;
      this.pN = null;
      this.mS = null;
      this.sK = false;
      this.sL = false;
      this.nd = null;
      this.sM = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    eu.C("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      e(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.sK) && (paramWebView == this.lN) && (d(localUri))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.lN.willNotDraw())
      {
        try
        {
          k localk = this.lN.cc();
          paramWebView = localUri;
          if (localk != null)
          {
            paramWebView = localUri;
            if (localk.b(localUri)) {
              paramWebView = localk.a(localUri, this.lN.getContext());
            }
          }
        }
        catch (l paramWebView)
        {
          for (;;)
          {
            eu.D("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
        }
        a(new ce("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
      else
      {
        eu.D("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */