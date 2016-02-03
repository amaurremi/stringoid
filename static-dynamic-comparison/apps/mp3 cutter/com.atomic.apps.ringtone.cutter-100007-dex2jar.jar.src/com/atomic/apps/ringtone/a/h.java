package com.atomic.apps.ringtone.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class h
{
  private static i[] c = { a.a(), d.a(), f.a(), new l() };
  private static ArrayList d = new ArrayList();
  private static HashMap e = new HashMap();
  protected j a = null;
  protected File b = null;
  
  static
  {
    i[] arrayOfi = c;
    int k = arrayOfi.length;
    int i = 0;
    if (i >= k) {
      return;
    }
    i locali = arrayOfi[i];
    String[] arrayOfString = locali.b();
    int m = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      if (j >= m)
      {
        i += 1;
        break;
      }
      String str = arrayOfString[j];
      d.add(str);
      e.put(str, locali);
      j += 1;
    }
  }
  
  public static h a(String paramString, j paramj)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      throw new FileNotFoundException(paramString);
    }
    paramString = localFile.getName().toLowerCase().split("\\.");
    if (paramString.length < 2) {
      return null;
    }
    paramString = (i)e.get(paramString[(paramString.length - 1)]);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.a();
    paramString.a = paramj;
    paramString.a(localFile);
    return paramString;
  }
  
  public static boolean a(String paramString)
  {
    paramString = paramString.toLowerCase().split("\\.");
    if (paramString.length < 2) {
      return false;
    }
    return e.containsKey(paramString[(paramString.length - 1)]);
  }
  
  public static String[] h()
  {
    return (String[])d.toArray(new String[d.size()]);
  }
  
  public int a(int paramInt)
  {
    return -1;
  }
  
  public void a(File paramFile)
  {
    this.b = paramFile;
  }
  
  public void a(File paramFile, int paramInt1, int paramInt2) {}
  
  public int b()
  {
    return 0;
  }
  
  public int c()
  {
    return 0;
  }
  
  public int[] d()
  {
    return null;
  }
  
  public int e()
  {
    return 0;
  }
  
  public int f()
  {
    return 0;
  }
  
  public String g()
  {
    return "Unknown";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */