package com.pocket.e;

import android.content.ComponentName;
import android.content.Intent;
import com.ideashower.readitlater.a.g;
import com.pocket.p.o;

public abstract class b
{
  private static boolean a = false;
  private static boolean b = false;
  
  public static boolean a()
  {
    if (a) {
      return b;
    }
    a = true;
    b = b();
    return b;
  }
  
  private static boolean b()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.kobo.launcher", "com.kobo.launcher.sync.PocketEventReceiver"));
    return o.c(g.c(), localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */