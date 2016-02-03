package cmn;

import java.io.File;

final class am
  implements Runnable
{
  am(ak paramak, Object paramObject) {}
  
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */