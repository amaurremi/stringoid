package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class bp
{
  private static final Object DS = new Object();
  private static String Fk;
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (DS)
    {
      if ((Fk == null) && (!TextUtils.isEmpty(paramString1))) {
        d(paramContext, paramString1, paramString2);
      }
      paramContext = Fk;
      return paramContext;
    }
  }
  
  private static void d(Context paramContext, String paramString1, String paramString2)
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
        if (bw.a(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      Fk = "err";
      return;
    }
    tmp93_90[0] = paramContext;
    Fk = String.format(Locale.US, "%X", tmp93_90);
  }
  
  public static String pL()
  {
    synchronized (DS)
    {
      String str = Fk;
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */