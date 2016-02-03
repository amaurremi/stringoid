package com.android.a;

class i
  implements Runnable
{
  private final p b;
  private final t c;
  private final Runnable d;
  
  public i(g paramg, p paramp, t paramt, Runnable paramRunnable)
  {
    this.b = paramp;
    this.c = paramt;
    this.d = paramRunnable;
  }
  
  public void run()
  {
    if (this.b.h()) {
      this.b.b("canceled-at-delivery");
    }
    label97:
    label107:
    for (;;)
    {
      return;
      if (this.c.a())
      {
        this.b.b(this.c.a);
        if (!this.c.d) {
          break label97;
        }
        this.b.a("intermediate-response");
      }
      for (;;)
      {
        if (this.d == null) {
          break label107;
        }
        this.d.run();
        return;
        this.b.b(this.c.c);
        break;
        this.b.b("done");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */