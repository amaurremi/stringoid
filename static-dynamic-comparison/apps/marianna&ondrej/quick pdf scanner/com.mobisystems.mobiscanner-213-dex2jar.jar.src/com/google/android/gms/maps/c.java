package com.google.android.gms.maps;

public final class c
{
  /* Error */
  public static int P(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	com/google/android/gms/internal/dc:N	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokestatic 22	com/google/android/gms/maps/a/x:Q	(Landroid/content/Context;)Lcom/google/android/gms/maps/a/j;
    //   9: astore_0
    //   10: aload_0
    //   11: invokeinterface 28 1 0
    //   16: invokestatic 34	com/google/android/gms/maps/a:a	(Lcom/google/android/gms/maps/a/a;)V
    //   19: aload_0
    //   20: invokeinterface 38 1 0
    //   25: invokestatic 43	com/google/android/gms/maps/model/b:a	(Lcom/google/android/gms/maps/model/a/b;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_0
    //   31: aload_0
    //   32: getfield 47	com/google/android/gms/common/GooglePlayServicesNotAvailableException:errorCode	I
    //   35: ireturn
    //   36: astore_0
    //   37: new 49	com/google/android/gms/maps/model/RuntimeRemoteException
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 53	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */