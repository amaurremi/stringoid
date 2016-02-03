package cmn;

import java.io.File;

final class t
  implements Runnable
{
  t(r paramr, Object paramObject) {}
  
  public final void run()
  {
    try
    {
      new File(this.b.a(this.a)).delete();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */