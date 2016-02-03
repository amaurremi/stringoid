package cmn;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

final class ao
  implements Runnable
{
  ao(ak paramak, Object paramObject1, Object paramObject2) {}
  
  public final void run()
  {
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(this.c.a(this.a)));
      localObjectOutputStream.writeObject(this.a);
      localObjectOutputStream.writeLong(System.currentTimeMillis());
      localObjectOutputStream.writeObject(this.b);
      localObjectOutputStream.close();
      ak.b(this.c);
      if (ak.c(this.c) <= 0)
      {
        ak.d(this.c);
        ak.e(this.c);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */