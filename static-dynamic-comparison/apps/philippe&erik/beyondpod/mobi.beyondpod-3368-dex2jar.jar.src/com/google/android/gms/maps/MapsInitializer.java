package com.google.android.gms.maps;

public final class MapsInitializer
{
  /* Error */
  public static int initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 21	com/google/android/gms/internal/eg:f	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokestatic 27	com/google/android/gms/maps/internal/q:u	(Landroid/content/Context;)Lcom/google/android/gms/maps/internal/c;
    //   9: astore_0
    //   10: aload_0
    //   11: invokeinterface 33 1 0
    //   16: invokestatic 39	com/google/android/gms/maps/CameraUpdateFactory:a	(Lcom/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate;)V
    //   19: aload_0
    //   20: invokeinterface 43 1 0
    //   25: invokestatic 48	com/google/android/gms/maps/model/BitmapDescriptorFactory:a	(Lcom/google/android/gms/maps/model/internal/a;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_0
    //   31: aload_0
    //   32: getfield 52	com/google/android/gms/common/GooglePlayServicesNotAvailableException:errorCode	I
    //   35: ireturn
    //   36: astore_0
    //   37: new 54	com/google/android/gms/maps/model/RuntimeRemoteException
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 57	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   5	10	30	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   10	28	36	android/os/RemoteException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */