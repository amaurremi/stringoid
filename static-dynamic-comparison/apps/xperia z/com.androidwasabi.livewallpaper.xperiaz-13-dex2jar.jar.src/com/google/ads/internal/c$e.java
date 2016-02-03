package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.AdSize;
import com.google.ads.l;
import com.google.ads.n;
import com.google.ads.util.i.b;
import java.util.LinkedList;

class c$e
  implements Runnable
{
  private final d b;
  private final WebView c;
  private final LinkedList<String> d;
  private final int e;
  private final boolean f;
  private final String g;
  private final AdSize h;
  
  public c$e(d paramd, WebView paramWebView, LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean, String paramString, AdSize paramAdSize)
  {
    this.b = paramWebView;
    this.c = paramLinkedList;
    this.d = paramInt;
    this.e = paramBoolean;
    this.f = paramString;
    this.g = paramAdSize;
    AdSize localAdSize;
    this.h = localAdSize;
  }
  
  public void run()
  {
    if (this.c != null)
    {
      this.c.stopLoading();
      this.c.destroy();
    }
    this.b.a(this.d);
    this.b.a(this.e);
    this.b.a(this.f);
    this.b.a(this.g);
    if (this.h != null)
    {
      ((h)((n)c.b(this.a).a.a()).g.a()).b(this.h);
      this.b.l().setAdSize(this.h);
    }
    this.b.E();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/c$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */