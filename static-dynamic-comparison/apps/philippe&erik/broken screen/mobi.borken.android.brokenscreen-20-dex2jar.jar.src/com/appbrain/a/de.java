package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import cmn.a;
import cmn.j;
import cmn.k;
import com.appbrain.b.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class de
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
    return aa.a().e().getLong("pref_ola", 0L);
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
      new Thread(new dg(paramContext)).start();
    }
  }
  
  public static byte[] b()
  {
    Object localObject = aa.a().e().getString("pref_tv", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = k.b((String)localObject);
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
    Object localObject = aa.a().e().getString("pref_aav", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = k.b((String)localObject);
      return (byte[])localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public static final class a
  {
    private long a;
    private List b = Collections.synchronizedList(new ArrayList());
    private final long c = System.currentTimeMillis() - 2592000000L;
    
    private static int[] a(List paramList)
    {
      int[] arrayOfInt = new int[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        int j = (int)(j.a(((PackageInfo)paramList.get(i)).packageName) & 0xFFFFFFFFFFFFFFFF);
        new StringBuilder().append(((PackageInfo)paramList.get(i)).packageName).append(": ").append(j);
        arrayOfInt[i] = j;
        i += 1;
      }
      return arrayOfInt;
    }
    
    public static a b()
    {
      return new a();
    }
    
    final long a()
    {
      return this.a;
    }
    
    public final void a(long paramLong)
    {
      this.b.clear();
      this.a = paramLong;
    }
    
    public final void a(PackageInfo paramPackageInfo, String paramString)
    {
      long l;
      if ((de.d() == null) || ((paramString != null) && (de.d().contains(paramString))))
      {
        l = de.e().a(paramPackageInfo);
        if (l > this.c) {
          this.b.add(paramPackageInfo);
        }
        if ((l > 0L) && (l < this.a)) {
          if ((paramPackageInfo.applicationInfo != null) && ((paramPackageInfo.applicationInfo.flags & 0x1) == 0)) {
            break label101;
          }
        }
      }
      label101:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          this.a = l;
        }
        return;
      }
    }
    
    public final String c()
    {
      try
      {
        Object localObject1 = new ByteArrayOutputStream(128);
        e locale = e.a((OutputStream)localObject1);
        locale.c(5);
        Collections.sort(this.b, new dh(this));
        if (this.b.size() > 16)
        {
          this.b = this.b.subList(0, 16);
          i = 0;
          while (i < this.b.size())
          {
            localObject2 = ((PackageInfo)this.b.get(i)).packageName;
            i += 1;
          }
        }
        Object localObject2 = a(this.b);
        locale.c(localObject2.length);
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          locale.d(localObject2[i]);
          i += 1;
        }
        locale.a();
        localObject1 = k.b(((ByteArrayOutputStream)localObject1).toByteArray());
        return (String)localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return "";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */