package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class al
  implements Iterable
{
  private static final am a = new an();
  private final ArrayList b = new ArrayList();
  private final Context c;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new ao();
      return;
    }
  }
  
  private al(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static al a(Context paramContext)
  {
    return new al(paramContext);
  }
  
  public PendingIntent a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, null);
  }
  
  public PendingIntent a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.b.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
    Intent[] arrayOfIntent = (Intent[])this.b.toArray(new Intent[this.b.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    return a.a(this.c, arrayOfIntent, paramInt1, paramInt2, paramBundle);
  }
  
  public al a(Intent paramIntent)
  {
    this.b.add(paramIntent);
    return this;
  }
  
  public Iterator iterator()
  {
    return this.b.iterator();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */