package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public final class AdvertisingIdClient
{
  /* Error */
  static AdvertisingIdClient.Info a(Context paramContext, a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 23	com/google/android/gms/common/a:ew	()Landroid/os/IBinder;
    //   4: invokestatic 29	com/google/android/gms/internal/s$a:b	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   7: astore_2
    //   8: new 31	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   11: dup
    //   12: aload_2
    //   13: invokeinterface 37 1 0
    //   18: aload_2
    //   19: iconst_1
    //   20: invokeinterface 40 2 0
    //   25: invokespecial 43	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   28: astore_2
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 49	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   34: aload_2
    //   35: areturn
    //   36: astore_0
    //   37: ldc 51
    //   39: ldc 53
    //   41: aload_0
    //   42: invokestatic 59	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   45: pop
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: ldc 51
    //   51: ldc 61
    //   53: aload_2
    //   54: invokestatic 59	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: new 63	java/io/IOException
    //   61: dup
    //   62: ldc 65
    //   64: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 49	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: new 63	java/io/IOException
    //   80: dup
    //   81: ldc 70
    //   83: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore_0
    //   88: ldc 51
    //   90: ldc 53
    //   92: aload_0
    //   93: invokestatic 59	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: goto -23 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	Context
    //   0	100	1	parama	a
    //   7	40	2	localObject1	Object
    //   48	6	2	localRemoteException	android.os.RemoteException
    //   68	7	2	localObject2	Object
    //   76	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   29	34	36	java/lang/IllegalArgumentException
    //   0	29	48	android/os/RemoteException
    //   0	29	68	finally
    //   49	68	68	finally
    //   77	87	68	finally
    //   0	29	76	java/lang/InterruptedException
    //   69	74	87	java/lang/IllegalArgumentException
  }
  
  public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context paramContext)
  {
    hm.az("Calling this from your main thread can lead to deadlock");
    return a(paramContext, j(paramContext));
  }
  
  static a j(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      a locala;
      Intent localIntent;
      throw new IOException("Connection failure");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        GooglePlayServicesUtil.z(paramContext);
        locala = new a();
        localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        if (!paramContext.bindService(localIntent, locala, 1)) {
          break label73;
        }
        return locala;
      }
      catch (GooglePlayServicesNotAvailableException paramContext)
      {
        throw new IOException(paramContext);
      }
      paramContext = paramContext;
      throw new GooglePlayServicesNotAvailableException(9);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/identifier/AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */