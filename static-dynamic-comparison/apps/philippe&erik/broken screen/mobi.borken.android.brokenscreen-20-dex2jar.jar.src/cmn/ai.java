package cmn;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class ai
  extends ag.e
{
  ai(ag paramag)
  {
    super((byte)0);
  }
  
  public final Object call()
  {
    ag.a(this.a).set(true);
    Process.setThreadPriority(10);
    ag localag1 = this.a;
    ag localag2 = this.a;
    Object[] arrayOfObject = this.b;
    return ag.a(localag1, localag2.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */