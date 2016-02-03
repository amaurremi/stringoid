package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class cl
{
  private static final Object hC = new Object();
  private static String iw;
  
  public static String as()
  {
    synchronized (hC)
    {
      String str = iw;
      return str;
    }
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (hC)
    {
      if ((iw == null) && (!TextUtils.isEmpty(paramString1))) {
        c(paramContext, paramString1, paramString2);
      }
      paramContext = iw;
      return paramContext;
    }
  }
  
  private static void c(Context paramContext, String paramString1, String paramString2)
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
        if (co.a(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      iw = "err";
      return;
    }
    tmp93_90[0] = paramContext;
    iw = String.format(Locale.US, "%X", tmp93_90);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */