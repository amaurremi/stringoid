package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import cmn.a;
import cmn.aa;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aq
{
  private static final a a = ;
  private static Set b;
  private static AtomicBoolean c = new AtomicBoolean(false);
  private static volatile long d = 0L;
  
  static
  {
    HashSet localHashSet = new HashSet();
    b = localHashSet;
    localHashSet.add("com.android.vending");
    b.add("com.google.android.feedback");
  }
  
  public static long a()
  {
    return aw.a().d().getLong("pref_ola", 0L);
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l < d) {
      d = l;
    }
    if ((l > d + 3600000L) && (c.compareAndSet(false, true)))
    {
      d = l;
      new Thread(new at(paramContext)).start();
    }
  }
  
  public static byte[] b()
  {
    Object localObject = aw.a().d().getString("pref_tv", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = aa.b((String)localObject);
      return (byte[])localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public static byte[] c()
  {
    Object localObject = aw.a().d().getString("pref_aav", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = aa.b((String)localObject);
      return (byte[])localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */