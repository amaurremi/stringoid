package com.jiubang.pla.internal;

class b
  implements Runnable
{
  b(PLA_AbsListView paramPLA_AbsListView) {}
  
  public void run()
  {
    if (this.a.n)
    {
      this.a.n = false;
      PLA_AbsListView.a(this.a, false);
      if ((this.a.getPersistentDrawingCache() & 0x2) == 0) {
        PLA_AbsListView.b(this.a, false);
      }
      if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
        this.a.invalidate();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */