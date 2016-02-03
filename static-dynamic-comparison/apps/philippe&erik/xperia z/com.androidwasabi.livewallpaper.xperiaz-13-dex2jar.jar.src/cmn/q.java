package cmn;

final class q
  implements Runnable
{
  q(k paramk, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */