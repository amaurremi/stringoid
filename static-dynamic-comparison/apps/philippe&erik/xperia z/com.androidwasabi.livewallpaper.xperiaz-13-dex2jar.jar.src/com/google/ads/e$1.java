package com.google.ads;

class e$1
  implements Runnable
{
  e$1(e parame, c paramc, AdRequest paramAdRequest) {}
  
  public void run()
  {
    e.a(this.c, this.a, this.b);
    synchronized (e.a(this.c))
    {
      e.a(this.c, null);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */