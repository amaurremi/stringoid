package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import java.io.IOException;

public final class AdvertisingIdClient
{
  private static a g(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
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
        GooglePlayServicesUtil.m(paramContext);
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
  
  /* Error */
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, java.lang.IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 87	com/google/android/gms/internal/eg:O	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: invokestatic 89	com/google/android/gms/ads/identifier/AdvertisingIdClient:g	(Landroid/content/Context;)Lcom/google/android/gms/common/a;
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 93	com/google/android/gms/common/a:bg	()Landroid/os/IBinder;
    //   14: invokestatic 99	com/google/android/gms/internal/p$a:b	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/p;
    //   17: astore_2
    //   18: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   21: dup
    //   22: aload_2
    //   23: invokeinterface 105 1 0
    //   28: aload_2
    //   29: iconst_1
    //   30: invokeinterface 109 2 0
    //   35: invokespecial 112	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   38: astore_2
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 116	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: ldc 118
    //   49: ldc 120
    //   51: aload_2
    //   52: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   55: pop
    //   56: new 16	java/io/IOException
    //   59: dup
    //   60: ldc -128
    //   62: invokespecial 71	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: astore_2
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 116	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   72: aload_2
    //   73: athrow
    //   74: astore_2
    //   75: new 16	java/io/IOException
    //   78: dup
    //   79: ldc -126
    //   81: invokespecial 71	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   9	60	1	locala	a
    //   17	28	2	localObject1	Object
    //   46	6	2	localRemoteException	android.os.RemoteException
    //   66	7	2	localObject2	Object
    //   74	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   10	39	46	android/os/RemoteException
    //   10	39	66	finally
    //   47	66	66	finally
    //   75	85	66	finally
    //   10	39	74	java/lang/InterruptedException
  }
  
  public static final class Info
  {
    private final String eb;
    private final boolean ec;
    
    Info(String paramString, boolean paramBoolean)
    {
      this.eb = paramString;
      this.ec = paramBoolean;
    }
    
    public String getId()
    {
      return this.eb;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.ec;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/identifier/AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */