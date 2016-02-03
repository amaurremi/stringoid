package com.pocket.tts;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.a.c.k;

public class f
{
  private static String a(Locale paramLocale)
  {
    try
    {
      String str = paramLocale.getISO3Country();
      return str;
    }
    catch (Exception localException)
    {
      e.a(localException);
    }
    return paramLocale.getCountry();
  }
  
  public static Locale a(Locale paramLocale, ArrayList paramArrayList)
  {
    Object localObject = paramArrayList.iterator();
    Locale localLocale;
    while (((Iterator)localObject).hasNext())
    {
      localLocale = (Locale)((Iterator)localObject).next();
      if (a(paramLocale, localLocale, true, true, true)) {
        return localLocale;
      }
    }
    localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localLocale = (Locale)((Iterator)localObject).next();
      if (a(paramLocale, localLocale, true, true, false)) {
        return localLocale;
      }
    }
    localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localLocale = (Locale)((Iterator)localObject).next();
      if (a(paramLocale, localLocale, true, false, false)) {
        return localLocale;
      }
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (Locale)paramArrayList.next();
      if (a(paramLocale, (Locale)localObject, false, true, false)) {
        return (Locale)localObject;
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = g.c();
    }
    paramContext = localContext.getResources().getConfiguration().locale.getLanguage();
    return (k.b(paramContext, "en")) || (k.b(paramContext, "de")) || (k.b(paramContext, "es")) || (k.b(paramContext, "fr")) || (k.b(paramContext, "it")) || (k.b(paramContext, "ja")) || (k.b(paramContext, "ru")) || (k.b(paramContext, "pl")) || (k.b(paramContext, "pt")) || (k.b(paramContext, "nl")) || (k.b(paramContext, "zh")) || (k.b(paramContext, "ko"));
  }
  
  public static boolean a(Locale paramLocale1, Locale paramLocale2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
      throw new RuntimeException("no flags set");
    }
    if ((paramBoolean1) && (!b(paramLocale1).equals(b(paramLocale2)))) {}
    while (((paramBoolean2) && (!a(paramLocale1).equals(a(paramLocale2)))) || ((paramBoolean3) && (!paramLocale1.getVariant().equals(paramLocale2.getVariant())))) {
      return false;
    }
    return true;
  }
  
  private static String b(Locale paramLocale)
  {
    try
    {
      String str = paramLocale.getISO3Language();
      return str;
    }
    catch (Exception localException)
    {
      e.a(localException);
    }
    return paramLocale.getLanguage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */