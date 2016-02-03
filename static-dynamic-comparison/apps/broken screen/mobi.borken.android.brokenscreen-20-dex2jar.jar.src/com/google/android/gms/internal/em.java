package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class em
{
  private static final Object qm = new Object();
  private static String sb;
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (qm)
    {
      if ((sb == null) && (!TextUtils.isEmpty(paramString1))) {
        b(paramContext, paramString1, paramString2);
      }
      paramContext = sb;
      return paramContext;
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, paramString2);
      paramContext = new BigInteger(new byte[1]);
      String[] arrayOfString = paramString1.split(",");
      int i = 0;
      while (i < arrayOfString.length)
      {
        paramString1 = paramContext;
        if (ep.a(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      sb = "err";
      return;
    }
    tmp93_90[0] = paramContext;
    sb = String.format(Locale.US, "%X", tmp93_90);
  }
  
  public static String bK()
  {
    synchronized (qm)
    {
      String str = sb;
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */