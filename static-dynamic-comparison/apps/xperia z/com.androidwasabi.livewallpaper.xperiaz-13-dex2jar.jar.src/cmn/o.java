package cmn;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class o
  extends m
{
  o(g paramg)
  {
    super((byte)0);
  }
  
  public final Object call()
  {
    g.a(this.b).set(true);
    Process.setThreadPriority(10);
    g localg1 = this.b;
    g localg2 = this.b;
    Object[] arrayOfObject = this.a;
    return g.a(localg1, localg2.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */