package com.appbrain.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
{
  private static d a;
  private final Context b;
  private volatile a c;
  
  private d(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    aq.a().post(new e(this));
  }
  
  static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static String a(IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      paramIBinder.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramIBinder = localParcel2.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  private a b()
  {
    this.b.getPackageManager().getPackageInfo("com.android.vending", 0);
    Object localObject1 = new LinkedBlockingQueue(1);
    g localg = new g(this, (LinkedBlockingQueue)localObject1);
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    if (!this.b.bindService(localIntent, localg, 1)) {
      throw new IOException("Error connecting to Google Play Services");
    }
    try
    {
      localObject1 = (IBinder)((LinkedBlockingQueue)localObject1).take();
      localObject1 = new a(a((IBinder)localObject1), b((IBinder)localObject1));
      return (a)localObject1;
    }
    finally
    {
      this.b.unbindService(localg);
    }
  }
  
  /* Error */
  private static boolean b(IBinder paramIBinder)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 56	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 56	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 58
    //   14: invokevirtual 62	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_3
    //   18: iconst_1
    //   19: invokevirtual 165	android/os/Parcel:writeInt	(I)V
    //   22: aload_0
    //   23: iconst_2
    //   24: aload_3
    //   25: aload 4
    //   27: iconst_0
    //   28: invokeinterface 68 5 0
    //   33: pop
    //   34: aload 4
    //   36: invokevirtual 71	android/os/Parcel:readException	()V
    //   39: aload 4
    //   41: invokevirtual 169	android/os/Parcel:readInt	()I
    //   44: istore_1
    //   45: iload_1
    //   46: ifeq +14 -> 60
    //   49: aload 4
    //   51: invokevirtual 78	android/os/Parcel:recycle	()V
    //   54: aload_3
    //   55: invokevirtual 78	android/os/Parcel:recycle	()V
    //   58: iload_2
    //   59: ireturn
    //   60: iconst_0
    //   61: istore_2
    //   62: goto -13 -> 49
    //   65: astore_0
    //   66: aload 4
    //   68: invokevirtual 78	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 78	android/os/Parcel:recycle	()V
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramIBinder	IBinder
    //   44	2	1	i	int
    //   1	61	2	bool	boolean
    //   5	67	3	localParcel1	Parcel
    //   9	58	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   11	45	65	finally
  }
  
  public final a a()
  {
    return this.c;
  }
  
  static final class a
  {
    private final String a;
    private final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    final String a()
    {
      return this.a;
    }
    
    final boolean b()
    {
      return this.b;
    }
  }
  
  static final class b
  {
    static d.a a(Context paramContext)
    {
      try
      {
        paramContext = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
        paramContext = new d.a(paramContext.getId(), paramContext.isLimitAdTrackingEnabled());
        return paramContext;
      }
      catch (GooglePlayServicesRepairableException paramContext)
      {
        throw new IOException();
      }
      catch (GooglePlayServicesNotAvailableException paramContext)
      {
        throw new IllegalStateException();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */