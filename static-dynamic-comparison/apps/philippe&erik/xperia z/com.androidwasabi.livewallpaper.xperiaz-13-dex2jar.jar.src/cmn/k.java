package cmn;

import java.util.LinkedList;
import java.util.concurrent.Executor;

final class k
  implements Executor
{
  final LinkedList a = new LinkedList();
  Runnable b;
  
  protected final void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.a.poll();
      this.b = localRunnable;
      if (localRunnable != null) {
        g.a.execute(this.b);
      }
      return;
    }
    finally {}
  }
  
  public final void execute(Runnable paramRunnable)
  {
    try
    {
      this.a.offer(new q(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */