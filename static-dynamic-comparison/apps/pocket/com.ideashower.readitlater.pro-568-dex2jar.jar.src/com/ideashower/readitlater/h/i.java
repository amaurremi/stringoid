package com.ideashower.readitlater.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.node.ObjectNode;

public class i
{
  private static SharedPreferences a;
  private static SharedPreferences b;
  
  public static float a(c paramc)
  {
    return a(paramc.c).getFloat(paramc.b(), paramc.a);
  }
  
  public static int a(d paramd)
  {
    return a(paramd.c).getInt(paramd.b(), paramd.a);
  }
  
  public static int a(d paramd, int paramInt)
  {
    paramInt = a(paramd) + 1;
    b().a(paramd, paramInt).a();
    return paramInt;
  }
  
  public static long a(e parame)
  {
    return a(parame.c).getLong(parame.b(), parame.a);
  }
  
  private static SharedPreferences a(g paramg)
  {
    if (paramg == g.b) {
      return b;
    }
    return a;
  }
  
  public static String a(h paramh)
  {
    return a(paramh.c).getString(paramh.b(), paramh.a);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = a(g.a).getString(paramString1, paramString2);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.ideashower.readitlater.util.e.a(localThrowable);
      b().a(paramString1, g.a).a();
    }
    return paramString2;
  }
  
  public static ObjectNode a(h paramh, ObjectNode paramObjectNode)
  {
    paramh = com.ideashower.readitlater.util.l.a(a(paramh));
    if (paramh != null) {
      paramObjectNode = paramh;
    }
    return paramObjectNode;
  }
  
  public static void a()
  {
    b = com.ideashower.readitlater.a.g.c().getSharedPreferences("pocketAppPrefs", 0);
    a = PreferenceManager.getDefaultSharedPreferences(com.ideashower.readitlater.a.g.c());
    h();
  }
  
  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a(g.b).registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    a(g.a).registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static void a(b paramb, boolean paramBoolean)
  {
    b().a(paramb, paramBoolean).a();
  }
  
  public static void a(e parame, long paramLong)
  {
    b().a(parame, paramLong).a();
  }
  
  public static void a(h paramh, String paramString)
  {
    b().a(paramh, paramString).a();
  }
  
  private static void a(l paraml, b paramb, SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    String str1 = paramb.b;
    Iterator localIterator = paramSharedPreferences.getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (str2.startsWith(str1))
      {
        boolean bool = paramSharedPreferences.getBoolean(str2, false);
        paramEditor.remove(str2);
        paraml.a(paramb, bool);
      }
    }
  }
  
  private static void a(l paraml, f paramf, SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor)
  {
    if ((paramf instanceof h)) {
      paraml.a((h)paramf, paramSharedPreferences.getString(paramf.b(), ((h)paramf).a));
    }
    for (;;)
    {
      paramEditor.remove(paramf.b());
      return;
      if ((paramf instanceof b)) {
        paraml.a((b)paramf, paramSharedPreferences.getBoolean(paramf.b(), ((b)paramf).a));
      } else if ((paramf instanceof d)) {
        paraml.a((d)paramf, paramSharedPreferences.getInt(paramf.b(), ((d)paramf).a));
      } else if ((paramf instanceof e)) {
        paraml.a((e)paramf, paramSharedPreferences.getLong(paramf.b(), ((e)paramf).a));
      } else if ((paramf instanceof c)) {
        paraml.a((c)paramf, paramSharedPreferences.getFloat(paramf.b(), ((c)paramf).a));
      }
    }
  }
  
  public static boolean a(b paramb)
  {
    return a(paramb.c).getBoolean(paramb.b(), paramb.a);
  }
  
  public static boolean a(f paramf)
  {
    return a(paramf.c).contains(paramf.b());
  }
  
  public static l b()
  {
    if (com.ideashower.readitlater.util.a.b()) {
      return new j(a, b);
    }
    return new k(a, b);
  }
  
  public static void b(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a(g.b).unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    a(g.a).unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static void b(d paramd, int paramInt)
  {
    b().a(paramd, paramInt).a();
  }
  
  public static void b(f paramf)
  {
    String str1 = paramf.b;
    paramf = paramf.c;
    Object localObject = a(paramf).getAll().keySet();
    l locall = b();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = (String)((Iterator)localObject).next();
      if (str2.startsWith(str1)) {
        locall.a(str2, paramf);
      }
    }
    locall.a();
  }
  
  public static boolean b(b paramb)
  {
    boolean bool = true;
    if (!a(paramb))
    {
      b().a(paramb, true).a();
      bool = false;
    }
    return bool;
  }
  
  public static boolean c()
  {
    return a(a.B);
  }
  
  public static boolean d()
  {
    return a(a.D);
  }
  
  public static boolean e()
  {
    return a(a.C);
  }
  
  public static void f()
  {
    a(g.a).edit().clear().commit();
  }
  
  public static boolean g()
  {
    return (com.ideashower.readitlater.a.g.y()) && (a(a.cm));
  }
  
  private static void h()
  {
    SharedPreferences localSharedPreferences = a(g.a);
    if (!localSharedPreferences.contains("previousAppVersion")) {}
    int i;
    do
    {
      return;
      i = localSharedPreferences.getInt("previousAppVersion", 0);
    } while ((i == 0) || (com.ideashower.readitlater.a.g.b().j() <= i) || (i >= 165));
    l locall = b();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    a(locall, a.ak, localSharedPreferences, localEditor);
    a(locall, a.be, localSharedPreferences, localEditor);
    a(locall, a.aj, localSharedPreferences, localEditor);
    a(locall, a.W, localSharedPreferences, localEditor);
    a(locall, a.Y, localSharedPreferences, localEditor);
    a(locall, a.x, localSharedPreferences, localEditor);
    a(locall, a.af, localSharedPreferences, localEditor);
    a(locall, a.Z, localSharedPreferences, localEditor);
    a(locall, a.aE, localSharedPreferences, localEditor);
    a(locall, a.ae, localSharedPreferences, localEditor);
    a(locall, a.X, localSharedPreferences, localEditor);
    a(locall, a.bc, localSharedPreferences, localEditor);
    a(locall, a.bd, localSharedPreferences, localEditor);
    a(locall, a.aY, localSharedPreferences, localEditor);
    a(locall, a.aX, localSharedPreferences, localEditor);
    a(locall, a.bg, localSharedPreferences, localEditor);
    a(locall, a.aD, localSharedPreferences, localEditor);
    a(locall, a.aS, localSharedPreferences, localEditor);
    a(locall, a.aa, localSharedPreferences, localEditor);
    a(locall, a.bf, localSharedPreferences, localEditor);
    locall.a();
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */