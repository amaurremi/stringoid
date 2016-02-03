package com.google.android.gms.ads.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import com.google.android.gms.common.h;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class a
{
  public a(Date paramDate, com.google.a.b paramb, Set paramSet, boolean paramBoolean, Location paramLocation) {}
  
  public static b a(Context paramContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("Calling this from your main thread can lead to deadlock");
    }
    return a(paramContext, b(paramContext));
  }
  
  /* Error */
  private static b a(Context paramContext, h paramh)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 46	com/google/android/gms/common/h:a	()Landroid/os/IBinder;
    //   4: invokestatic 51	com/google/android/gms/internal/ds:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/dr;
    //   7: astore_2
    //   8: new 53	com/google/android/gms/ads/a/b
    //   11: dup
    //   12: aload_2
    //   13: invokeinterface 58 1 0
    //   18: aload_2
    //   19: iconst_1
    //   20: invokeinterface 61 2 0
    //   25: invokespecial 64	com/google/android/gms/ads/a/b:<init>	(Ljava/lang/String;Z)V
    //   28: astore_2
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 70	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   34: aload_2
    //   35: areturn
    //   36: astore_0
    //   37: ldc 72
    //   39: ldc 74
    //   41: aload_0
    //   42: invokestatic 80	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   45: pop
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: ldc 72
    //   51: ldc 82
    //   53: aload_2
    //   54: invokestatic 80	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: new 84	java/io/IOException
    //   61: dup
    //   62: ldc 86
    //   64: invokespecial 87	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 70	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: new 84	java/io/IOException
    //   80: dup
    //   81: ldc 89
    //   83: invokespecial 87	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore_0
    //   88: ldc 72
    //   90: ldc 74
    //   92: aload_0
    //   93: invokestatic 80	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: goto -23 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	Context
    //   0	100	1	paramh	h
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
  
  private static h b(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      h localh;
      Intent localIntent;
      throw new IOException("Connection failure");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        f.b(paramContext);
        localh = new h();
        localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        if (!paramContext.bindService(localIntent, localh, 1)) {
          break label73;
        }
        return localh;
      }
      catch (d paramContext)
      {
        throw new IOException(paramContext);
      }
      paramContext = paramContext;
      throw new d(9);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/ads/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */