package com.google.android.gms.maps.internal;

import android.os.IBinder;

class ab
  implements IProjectionDelegate
{
  private IBinder a;
  
  ab(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.LatLng fromScreenLocation(com.google.android.gms.dynamic.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +65 -> 83
    //   21: aload_1
    //   22: invokeinterface 36 1 0
    //   27: astore_1
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 39	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   33: aload_0
    //   34: getfield 15	com/google/android/gms/maps/internal/ab:a	Landroid/os/IBinder;
    //   37: iconst_1
    //   38: aload_3
    //   39: aload 4
    //   41: iconst_0
    //   42: invokeinterface 45 5 0
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 48	android/os/Parcel:readException	()V
    //   53: aload_2
    //   54: astore_1
    //   55: aload 4
    //   57: invokevirtual 52	android/os/Parcel:readInt	()I
    //   60: ifeq +12 -> 72
    //   63: getstatic 58	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/LatLngCreator;
    //   66: aload 4
    //   68: invokevirtual 64	com/google/android/gms/maps/model/LatLngCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 67	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 67	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: areturn
    //   83: aconst_null
    //   84: astore_1
    //   85: goto -57 -> 28
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 67	android/os/Parcel:recycle	()V
    //   94: aload_3
    //   95: invokevirtual 67	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ab
    //   0	100	1	paramd	com.google.android.gms.dynamic.d
    //   1	53	2	localObject	Object
    //   5	90	3	localParcel1	android.os.Parcel
    //   9	81	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   11	17	88	finally
    //   21	28	88	finally
    //   28	53	88	finally
    //   55	72	88	finally
  }
  
  /* Error */
  public com.google.android.gms.maps.model.VisibleRegion getVisibleRegion()
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/google/android/gms/maps/internal/ab:a	Landroid/os/IBinder;
    //   18: iconst_3
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 45 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 48	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 52	android/os/Parcel:readInt	()I
    //   36: ifeq +21 -> 57
    //   39: getstatic 74	com/google/android/gms/maps/model/VisibleRegion:CREATOR	Lcom/google/android/gms/maps/model/VisibleRegionCreator;
    //   42: aload_3
    //   43: invokevirtual 79	com/google/android/gms/maps/model/VisibleRegionCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/VisibleRegion;
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 67	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 67	android/os/Parcel:recycle	()V
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -12 -> 47
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 67	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 67	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ab
    //   46	13	1	localVisibleRegion	com.google.android.gms.maps.model.VisibleRegion
    //   62	10	1	localObject	Object
    //   3	65	2	localParcel1	android.os.Parcel
    //   7	57	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	47	62	finally
  }
  
  /* Error */
  public com.google.android.gms.dynamic.d toScreenLocation(com.google.android.gms.maps.model.LatLng paramLatLng)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +50 -> 65
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 85	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 89	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/maps/internal/ab:a	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 45 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 48	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 92	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   51: invokestatic 98	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 67	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: invokevirtual 67	android/os/Parcel:recycle	()V
    //   63: aload_1
    //   64: areturn
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 85	android/os/Parcel:writeInt	(I)V
    //   70: goto -41 -> 29
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 67	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 67	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ab
    //   0	84	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	76	2	localParcel1	android.os.Parcel
    //   7	68	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	73	finally
    //   18	29	73	finally
    //   29	55	73	finally
    //   65	70	73	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */