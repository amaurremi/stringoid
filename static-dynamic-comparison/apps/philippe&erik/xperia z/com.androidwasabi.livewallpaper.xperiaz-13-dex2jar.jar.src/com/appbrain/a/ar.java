package com.appbrain.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import cmn.a;
import cmn.aa;
import cmn.z;
import com.appbrain.b.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class ar
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
      int j = (int)(z.a(((PackageInfo)paramList.get(i)).packageName) & 0xFFFFFFFFFFFFFFFF);
      new StringBuilder().append(((PackageInfo)paramList.get(i)).packageName).append(": ").append(j).toString();
      arrayOfInt[i] = j;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static ar b()
  {
    return new ar();
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
    if ((aq.d() == null) || ((paramString != null) && (aq.d().contains(paramString))))
    {
      l = aq.e().a(paramPackageInfo);
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
      h localh = h.a((OutputStream)localObject1);
      localh.c(5);
      Collections.sort(this.b, new au(this));
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
      localh.c(localObject2.length);
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        new StringBuilder("Vector: ").append(k).toString();
        localh.d(k);
        i += 1;
      }
      localh.a();
      localObject1 = aa.b(((ByteArrayOutputStream)localObject1).toByteArray());
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */