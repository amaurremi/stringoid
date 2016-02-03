package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class j
  extends i
{
  protected j(Context paramContext, m paramm, qg paramqg)
  {
    super(paramContext, paramm, paramqg);
  }
  
  public static j a(String paramString, Context paramContext)
  {
    mz localmz = new mz();
    a(paramString, paramContext, localmz);
    return new j(paramContext, localmz, new qh(239));
  }
  
  protected void c(Context paramContext)
  {
    super.c(paramContext);
    try
    {
      Object localObject = i(paramContext);
      if (((oz)localObject).b()) {}
      for (long l = 1L;; l = 0L)
      {
        a(28, l);
        localObject = ((oz)localObject).a();
        if (localObject != null)
        {
          a(26, 5L);
          a(24, (String)localObject);
        }
        return;
      }
      return;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      a(24, f(paramContext));
      return;
    }
    catch (IOException paramContext)
    {
      return;
    }
    catch (ow paramContext) {}
  }
  
  /* Error */
  protected void d(Context paramContext)
  {
    // Byte code:
    //   0: lconst_1
    //   1: lstore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 35	com/google/android/gms/internal/i:c	(Landroid/content/Context;)V
    //   7: aload_0
    //   8: bipush 24
    //   10: aload_1
    //   11: invokestatic 60	com/google/android/gms/internal/j:f	(Landroid/content/Context;)Ljava/lang/String;
    //   14: invokevirtual 56	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 39	com/google/android/gms/internal/j:i	(Landroid/content/Context;)Lcom/google/android/gms/internal/oz;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 45	com/google/android/gms/internal/oz:b	()Z
    //   27: ifeq +38 -> 65
    //   30: aload_0
    //   31: bipush 28
    //   33: lload_2
    //   34: invokevirtual 48	com/google/android/gms/internal/j:a	(IJ)V
    //   37: aload_1
    //   38: invokevirtual 51	com/google/android/gms/internal/oz:a	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +34 -> 77
    //   46: aload_0
    //   47: bipush 30
    //   49: aload_1
    //   50: invokevirtual 56	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: bipush 28
    //   58: lconst_1
    //   59: invokevirtual 48	com/google/android/gms/internal/j:a	(IJ)V
    //   62: return
    //   63: astore_1
    //   64: return
    //   65: lconst_0
    //   66: lstore_2
    //   67: goto -37 -> 30
    //   70: astore_1
    //   71: return
    //   72: astore 4
    //   74: goto -57 -> 17
    //   77: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	j
    //   0	78	1	paramContext	Context
    //   1	66	2	l	long
    //   72	1	4	localow	ow
    // Exception table:
    //   from	to	target	type
    //   17	23	54	java/io/IOException
    //   7	17	63	java/io/IOException
    //   23	30	63	java/io/IOException
    //   30	42	63	java/io/IOException
    //   46	53	63	java/io/IOException
    //   55	62	63	java/io/IOException
    //   17	23	70	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   7	17	72	com/google/android/gms/internal/ow
  }
  
  oz i(Context paramContext)
  {
    int i = 0;
    AdvertisingIdClient.Info localInfo;
    try
    {
      localInfo = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      paramContext = localInfo.getId();
      if ((paramContext != null) && (paramContext.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
      {
        byte[] arrayOfByte = new byte[16];
        int j = 0;
        while (i < paramContext.length())
        {
          int k;
          if ((i != 8) && (i != 13) && (i != 18))
          {
            k = i;
            if (i != 23) {}
          }
          else
          {
            k = i + 1;
          }
          arrayOfByte[j] = ((byte)((Character.digit(paramContext.charAt(k), 16) << 4) + Character.digit(paramContext.charAt(k + 1), 16)));
          j += 1;
          i = k + 2;
        }
        paramContext = this.jQ.a(arrayOfByte, true);
      }
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new IOException(paramContext);
    }
    for (;;)
    {
      return new oz(this, paramContext, localInfo.isLimitAdTrackingEnabled());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */