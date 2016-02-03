package com.pocket.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.a.g;

public abstract class a
{
  public static void a()
  {
    a(1);
  }
  
  private static void a(int paramInt)
  {
    if (!e()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("com.pocket.broadcast.extra.event", paramInt);
    localIntent.setComponent(new ComponentName("com.kobo.launcher", "com.kobo.launcher.sync.PocketEventReceiver"));
    g.c().sendBroadcast(localIntent);
  }
  
  public static void b()
  {
    a(3);
  }
  
  public static void c()
  {
    a(2);
  }
  
  public static void d()
  {
    a(4);
  }
  
  private static boolean e()
  {
    return b.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */