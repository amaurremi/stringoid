package cmn;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

final class v
  implements Runnable
{
  v(r paramr, Object paramObject1, Object paramObject2) {}
  
  public final void run()
  {
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(this.c.a(this.a)));
      localObjectOutputStream.writeObject(this.a);
      localObjectOutputStream.writeLong(System.currentTimeMillis());
      localObjectOutputStream.writeObject(this.b);
      localObjectOutputStream.close();
      r.b(this.c);
      if (r.c(this.c) <= 0)
      {
        r.d(this.c);
        r.e(this.c);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */