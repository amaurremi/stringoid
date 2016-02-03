package com.venticake.retrica.setting;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class a
{
  private static String A = "livePreviewDisabled";
  private static String B = "first_launch_time";
  private static String C = "identifier";
  private static String D = "session_began_time";
  private static String E = "number_of_photos_taken";
  public static String a = null;
  public static String b = null;
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  private static a g = null;
  private static String i = "currentLensID";
  private static String j = "lensLookupInitensity";
  private static String k = "useVignette";
  private static String l = "useBlur";
  private static String m = "frameWidth";
  private static String n = "frameColor";
  private static String o = "cameraSelection";
  private static String p = "frameSelection";
  private static String q = "touchSound";
  private static String r = "geoTag";
  private static String s = "removable_storage";
  private static String t = "watermark_integer";
  private static String u = "watermark_enabled";
  private static String v = "saveAsPreview";
  private static String w = "timer";
  private static String x = "interval";
  private static String y = null;
  private static String z = "toolbar_body_height";
  private SharedPreferences h = null;
  
  public a()
  {
    D();
  }
  
  private void D()
  {
    i(1);
    j(1);
    k(1);
    l(1);
    E();
  }
  
  private void E()
  {
    y = com.venticake.retrica.util.a.a(new byte[] { 121, -125, 86, 97, 70, 111, 11, 31, -64, -126, 87, 39, -32, 21, 61, 22 });
  }
  
  /* Error */
  public static a a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/venticake/retrica/setting/a:g	Lcom/venticake/retrica/setting/a;
    //   6: ifnonnull +20 -> 26
    //   9: new 2	com/venticake/retrica/setting/a
    //   12: dup
    //   13: invokespecial 179	com/venticake/retrica/setting/a:<init>	()V
    //   16: astore_0
    //   17: aload_0
    //   18: putstatic 54	com/venticake/retrica/setting/a:g	Lcom/venticake/retrica/setting/a;
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: getstatic 54	com/venticake/retrica/setting/a:g	Lcom/venticake/retrica/setting/a;
    //   29: astore_0
    //   30: goto -9 -> 21
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	14	0	locala	a
    //   33	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	33	finally
    //   26	30	33	finally
  }
  
  public static String b()
  {
    return com.venticake.retrica.util.a.a(new byte[] { -17, 74, -88, -83, -33, -88, -19, -30, 93, -117, 41, -30, -2, 13, -84, -68, -103, 67, -99, 118, 78, 2, 7, 124, -59, -24, 118, -28, 125, 9, 60, 73, -8, -38, 102, 75, 95, 80, -85, 107, 88, -85, -122, 58, 107, 114, 71, 10, -47, 86, -33, 38, -6, -67, 109, 109, -14, 114, -69, -2, -8, -99, -78, 27, -41, -47, 38, 100, 122, -127, 90, 11, 44, 62, -122, -103, -67, 92, -78, 9, 9, 73, 74, -123, -80, 96, 101, -27, 11, Byte.MAX_VALUE, -114, -97, -103, -30, 6, 53, 55, -72, 87, 42, 117, 113, -126, 111, -61, 28, 82, -11, 57, -117, 49, -88, -107, 42, -100, 39, -53, -34, 25, 71, -118, 89, 33, 35, 79, -82, -36, 35, -8, -112, 4, 125, 80, 46, -118, -103, 39, 75, 36, -41, -108, -4, 110, -86, -68, -96, -53, -89, 74, 60, -2, 110, 51, -28, 80, -25, 45, 18, 36, -78, 7, 54, -66, 103, -34, 75, 81, 97, 7, 119, -66, -70, -29, -63, 76, 42, 48, 80, -84, 104, -113, -28, -31, 125, 102, 61, -16, -38, 31, 65, 92, 32, 87, -88, -110, 24, -5, 123, 50, -69, -104, 103, 52, 112, -37, 66, -39, 86, 17, 33, -51, -88, -44, 87, -6, 125, -51, 18, 90, -75, -41, 90, 92, 88, 9, 91, 116, -98, -2, -98, -84, 50, -79, 21, -47, -65, -28, -94, 45, -32, 30, 72, -59, -17, 37, -43, -118, 20, -54, 39, 14, 9, -32, 91, 76, -118, 25, 67, -37, 3, -6, 77, 50, -121, -93, -12, 15, 77, -77, 41, -55, -87, 113, 80, -65, 13, -5, -80, 25, -36, -11, -46, -114, -44, 45, -88, 108, -50, -78, 27, 71, 108, 109, 120, 4, -35, 82, 48, -75, -125, 116, -14, -16, -106, 25, 5, 110, -110, 57, -57, -14, -45, 122, 92, 39, 24, -61, -41, -93, -61, 96, 43, -78, 45, Byte.MIN_VALUE, -75, 125, 45, 21, -28, 78, -91, -125, 73, -72, -32, 88, 28, 120, 1, -9, 21, Byte.MIN_VALUE, -100, -113, -5, -22, -103, -54, -59, 11, 113, 106, -57, 60, 74, -27, -25, -7, 123, -85, 121, 72, 6, 78, 8, 25, 56, -111, -90, -86, -61, 5, -113, -46, 43, -83, -23, 35, -92, -30, 115, -90, 92, 16, -83, 111, 23, -12, 102, -39, 97, -123, -99, 71, 82, 24, -122, 70, 56 });
  }
  
  public static String c()
  {
    return com.venticake.retrica.util.a.a(new byte[] { -82, -95, -74, -44, -119, -97, 81, 86, 30, 18, -99, -17, -56, -50, 63, 34 });
  }
  
  public static String d()
  {
    return com.venticake.retrica.util.a.a(new byte[] { -70, -98, -79, 100, 58, Byte.MIN_VALUE, -63, 59, 49, -112, 92, 111, -2, 97, -107, 22, 29, -33, 86, 48, 10, -1, 20, 14, -4, -123, 4, -19, 120, -76, -101, -77 });
  }
  
  public static String e()
  {
    return com.venticake.retrica.util.a.a(new byte[] { 93, -121, -96, -101, 51, -106, 105, 84, -89, -6, -71, 86, -70, 82, -6, -78, -5, 50, 72, -103, -127, -75, 125, -99, -113, -76, -31, 30, 59, -106, -107, -48, 6, -87, -45, -3, 122, -122, -87, -67, 48, -93, -71, 91, 37, 90, 17, 66 });
  }
  
  private void i(int paramInt)
  {
    if (paramInt == 5)
    {
      a = com.venticake.retrica.util.a.a(new byte[] { 57, 68, -109, -37, 13, -84, 94, 88, -93, -116, 41, 110, -67, 33, -113, 125, 87, 123, 3, -49, 125, 70, 43, 15, -93, 121, -101, -101, -49, -120, -74, 126 });
      return;
    }
    if (paramInt == 3)
    {
      a = com.venticake.retrica.util.a.a(new byte[] { -14, -87, -8, 50, 24, -81, -93, 99, 31, -99, -37, 102, 75, -76, -62, 82, 78, 85, 80, -96, 8, -74, -111, -3, 70, 26, 64, 109, 123, 15, -118, -34 });
      return;
    }
    a = com.venticake.retrica.util.a.a(new byte[] { -43, 40, 79, -92, -92, 27, 26, 16, -53, 49, -102, -96, -67, 112, 38, 5, -108, -48, 39, 78, -120, 122, 23, -74, -38, -87, -81, -45, 63, -44, 50, -28 });
  }
  
  private void j(int paramInt)
  {
    if (paramInt == 5)
    {
      b = com.venticake.retrica.util.a.a(new byte[] { 68, 40, -51, 126, 54, 58, 20, 105, 99, 67, -83, -82, 126, 50, -92, 18, -54, -50, -45, -18, -111, -23, -119, 28, -83, -106, -77, -91, 60, 53, -24, -18 });
      return;
    }
    b = com.venticake.retrica.util.a.a(new byte[] { 37, 90, -26, -78, 74, -52, 98, 76, 71, 63, -41, -102, -65, -37, 35, 86, -127, 49, 92, 50, 95, -50, -2, 123, -10, -98, 103, -47, 30, 86, 26, 17 });
  }
  
  private void k(int paramInt)
  {
    if (paramInt == 5)
    {
      c = com.venticake.retrica.util.a.a(new byte[] { 76, 32, -63, 78, -42, 65, 120, 73, 124, -83, 35, -111, -43, -9, 69, -74, -8, 36, 52, -19, -102, -19, 41, 98, 66, -49, -10, 48, 49, -81, 27, 28 });
      return;
    }
    c = com.venticake.retrica.util.a.a(new byte[] { -3, -98, 18, -39, -7, -15, 57, 50, 86, 11, -35, 101, -99, -61, 62, -125, 112, 20, -37, -13, -58, -35, 40, -101, -26, -111, -99, -107, -31, 102, -116, 8 });
  }
  
  private void l(int paramInt)
  {
    d = com.venticake.retrica.util.a.a(new byte[] { 38, -27, 75, 11, 114, -38, 34, 102, -35, -120, -108, 49, -20, 31, 116, 49, -101, -106, 119, -117, 9, 20, -11, 62, -25, 70, -72, -17, 109, 48, -1, 57, 116, 39, -82, 38, 93, -30, 2, -12, -112, 55, 77, 68, -74, -34, 119, 26 });
    e = com.venticake.retrica.util.a.a(new byte[] { 38, -27, 75, 11, 114, -38, 34, 102, -35, -120, -108, 49, -20, 31, 116, 49, -27, -52, -55, 72, 70, -1, 11, 60, -114, 29, 43, -40, -47, 0, 23, -50, 11, -31, -37, -94, 32, -67, 65, -76, -7, 47, -46, -47, -8, -2, 67, 98 });
    f = com.venticake.retrica.util.a.a(new byte[] { 38, -27, 75, 11, 114, -38, 34, 102, -35, -120, -108, 49, -20, 31, 116, 49, 40, 126, -6, 82, 122, 97, -9, 107, -108, 78, 77, -30, 103, 80, -70, 88, 108, -70, -53, -72, -65, 40, -123, 64, 20, -6, -106, 100, -63, 115, 125, 91 });
  }
  
  public void A()
  {
    try
    {
      Date localDate = new Date();
      SharedPreferences.Editor localEditor = this.h.edit();
      localEditor.putLong(D, localDate.getTime());
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int B()
  {
    try
    {
      int i1 = this.h.getInt(E, 0);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void C()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.h.edit();
      localEditor.putInt(E, 0);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(float paramFloat)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putFloat(j, paramFloat);
    localEditor.commit();
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(m, paramInt);
    localEditor.commit();
  }
  
  public void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putLong(B, paramLong);
    localEditor.commit();
  }
  
  public void a(Location paramLocation)
  {
    String str = UUID.randomUUID().toString();
    Object localObject = str;
    if (paramLocation != null) {
      localObject = paramLocation.getLongitude() + " " + paramLocation.getLatitude() + " " + str;
    }
    paramLocation = new Random();
    long l1 = paramLocation.nextInt();
    long l2 = ((String)localObject).hashCode();
    paramLocation = new UUID(paramLocation.nextLong(), l1 << 32 | l2 & 0xFFFFFFF);
    localObject = this.h.edit();
    ((SharedPreferences.Editor)localObject).putString(C, paramLocation.toString());
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putString(i, paramString);
    localEditor.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(k, paramBoolean);
    localEditor.commit();
  }
  
  public void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(n, paramInt);
    localEditor.commit();
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(l, paramBoolean);
    localEditor.commit();
  }
  
  public void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(o, paramInt);
    localEditor.commit();
  }
  
  public void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(r, paramBoolean);
    localEditor.commit();
  }
  
  public void d(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(p, paramInt);
    localEditor.commit();
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(u, paramBoolean);
    localEditor.commit();
  }
  
  public void e(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(t, paramInt);
    localEditor.commit();
  }
  
  public void e(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(v, paramBoolean);
    localEditor.commit();
  }
  
  public String f()
  {
    return this.h.getString(i, null);
  }
  
  public void f(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(w, paramInt);
    localEditor.commit();
  }
  
  public void f(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(y, paramBoolean);
    localEditor.commit();
  }
  
  public float g()
  {
    return this.h.getFloat(j, 1.0F);
  }
  
  public void g(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(x, paramInt);
    localEditor.commit();
  }
  
  public void g(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putBoolean(A, paramBoolean);
    localEditor.commit();
  }
  
  public void h(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.h.edit();
    localEditor.putInt(z, paramInt);
    localEditor.commit();
  }
  
  public boolean h()
  {
    return this.h.getBoolean(k, false);
  }
  
  public boolean i()
  {
    return this.h.getBoolean(l, false);
  }
  
  public boolean j()
  {
    boolean bool = false;
    if (this.h.getInt(m, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public int k()
  {
    return this.h.getInt(m, 0);
  }
  
  public int l()
  {
    return this.h.getInt(n, 0);
  }
  
  @TargetApi(9)
  public int m()
  {
    return this.h.getInt(o, 0);
  }
  
  public int n()
  {
    return this.h.getInt(p, 0);
  }
  
  public boolean o()
  {
    return this.h.getBoolean(r, true);
  }
  
  public int p()
  {
    return this.h.getInt(t, 15);
  }
  
  public boolean q()
  {
    return this.h.getBoolean(u, true);
  }
  
  public boolean r()
  {
    return this.h.getBoolean(v, false);
  }
  
  public int s()
  {
    return this.h.getInt(w, 0);
  }
  
  public int t()
  {
    return this.h.getInt(x, 660);
  }
  
  public boolean u()
  {
    return this.h.getBoolean(y, false);
  }
  
  public int v()
  {
    return this.h.getInt(z, 0);
  }
  
  public boolean w()
  {
    return false;
  }
  
  public long x()
  {
    return this.h.getLong(B, 0L);
  }
  
  public UUID y()
  {
    UUID localUUID = null;
    String str = this.h.getString(C, null);
    if (str != null) {
      localUUID = UUID.fromString(str);
    }
    return localUUID;
  }
  
  public long z()
  {
    try
    {
      long l1 = this.h.getLong(D, 0L);
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/setting/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */