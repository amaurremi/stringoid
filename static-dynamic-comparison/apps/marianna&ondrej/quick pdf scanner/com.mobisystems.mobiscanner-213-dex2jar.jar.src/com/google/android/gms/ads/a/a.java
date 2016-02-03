package com.google.android.gms.ads.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import com.google.android.gms.internal.dc;
import java.io.IOException;

public final class a
{
  /* Error */
  static a a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 20	com/google/android/gms/common/e:ml	()Landroid/os/IBinder;
    //   4: invokestatic 26	com/google/android/gms/internal/gt$a:G	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/gt;
    //   7: astore_2
    //   8: new 6	com/google/android/gms/ads/a/a$a
    //   11: dup
    //   12: aload_2
    //   13: invokeinterface 32 1 0
    //   18: aload_2
    //   19: iconst_1
    //   20: invokeinterface 36 2 0
    //   25: invokespecial 40	com/google/android/gms/ads/a/a$a:<init>	(Ljava/lang/String;Z)V
    //   28: astore_2
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 46	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   34: aload_2
    //   35: areturn
    //   36: astore_0
    //   37: ldc 48
    //   39: ldc 50
    //   41: aload_0
    //   42: invokestatic 56	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   45: pop
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: ldc 48
    //   51: ldc 58
    //   53: aload_2
    //   54: invokestatic 56	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: new 60	java/io/IOException
    //   61: dup
    //   62: ldc 62
    //   64: invokespecial 65	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 46	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: new 60	java/io/IOException
    //   80: dup
    //   81: ldc 67
    //   83: invokespecial 65	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore_0
    //   88: ldc 48
    //   90: ldc 50
    //   92: aload_0
    //   93: invokestatic 56	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: goto -23 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	Context
    //   0	100	1	parame	e
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
  
  private static e m(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      e locale;
      Intent localIntent;
      throw new IOException("Connection failure");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        d.v(paramContext);
        locale = new e();
        localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        if (!paramContext.bindService(localIntent, locale, 1)) {
          break label73;
        }
        return locale;
      }
      catch (GooglePlayServicesNotAvailableException paramContext)
      {
        throw new IOException(paramContext);
      }
      paramContext = paramContext;
      throw new GooglePlayServicesNotAvailableException(9);
    }
  }
  
  public static a n(Context paramContext)
  {
    dc.aI("Calling this from your main thread can lead to deadlock");
    return a(paramContext, m(paramContext));
  }
  
  public static final class a
  {
    private final String lO;
    private final boolean lP;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.lO = paramString;
      this.lP = paramBoolean;
    }
    
    public String getId()
    {
      return this.lO;
    }
    
    public boolean kv()
    {
      return this.lP;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/ads/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */