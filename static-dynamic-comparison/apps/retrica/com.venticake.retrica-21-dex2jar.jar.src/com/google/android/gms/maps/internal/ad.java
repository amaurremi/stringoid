package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

class ad
  implements IStreetViewPanoramaFragmentDelegate
{
  private IBinder a;
  
  ad(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public IStreetViewPanoramaDelegate getStreetViewPanorama()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = IStreetViewPanoramaDelegate.a.aT(localParcel2.readStrongBinder());
      return localIStreetViewPanoramaDelegate;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isReady()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
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
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 71	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/maps/internal/ad:a	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 38 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 41	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 53	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 53	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 53	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 53	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ad
    //   0	75	1	paramBundle	Bundle
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +95 -> 116
    //   24: aload_1
    //   25: invokeinterface 77 1 0
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 80	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 4
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: invokeinterface 77 1 0
    //   50: astore_1
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 80	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   57: aload_3
    //   58: ifnull +63 -> 121
    //   61: aload 5
    //   63: iconst_1
    //   64: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   67: aload_3
    //   68: aload 5
    //   70: iconst_0
    //   71: invokevirtual 71	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   74: aload_0
    //   75: getfield 15	com/google/android/gms/maps/internal/ad:a	Landroid/os/IBinder;
    //   78: iconst_4
    //   79: aload 5
    //   81: aload 6
    //   83: iconst_0
    //   84: invokeinterface 38 5 0
    //   89: pop
    //   90: aload 6
    //   92: invokevirtual 41	android/os/Parcel:readException	()V
    //   95: aload 6
    //   97: invokevirtual 44	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   100: invokestatic 86	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
    //   103: astore_1
    //   104: aload 6
    //   106: invokevirtual 53	android/os/Parcel:recycle	()V
    //   109: aload 5
    //   111: invokevirtual 53	android/os/Parcel:recycle	()V
    //   114: aload_1
    //   115: areturn
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -87 -> 31
    //   121: aload 5
    //   123: iconst_0
    //   124: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   127: goto -53 -> 74
    //   130: astore_1
    //   131: aload 6
    //   133: invokevirtual 53	android/os/Parcel:recycle	()V
    //   136: aload 5
    //   138: invokevirtual 53	android/os/Parcel:recycle	()V
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ad
    //   0	143	1	paramd1	d
    //   0	143	2	paramd2	d
    //   0	143	3	paramBundle	Bundle
    //   1	37	4	localObject	Object
    //   6	131	5	localParcel1	Parcel
    //   11	121	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	130	finally
    //   24	31	130	finally
    //   31	37	130	finally
    //   44	51	130	finally
    //   51	57	130	finally
    //   61	74	130	finally
    //   74	104	130	finally
    //   121	127	130	finally
  }
  
  public void onDestroy()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onDestroyView()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onInflate(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label127:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (paramd != null)
        {
          paramd = paramd.asBinder();
          localParcel1.writeStrongBinder(paramd);
          if (paramStreetViewPanoramaOptions != null)
          {
            localParcel1.writeInt(1);
            paramStreetViewPanoramaOptions.writeToParcel(localParcel1, 0);
            if (paramBundle == null) {
              break label127;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          paramd = null;
          continue;
        }
        localParcel1.writeInt(0);
        continue;
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void onLowMemory()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onPause()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onResume()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void onSaveInstanceState(Bundle paramBundle)
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
    //   15: ifnull +54 -> 69
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 71	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/maps/internal/ad:a	Landroid/os/IBinder;
    //   33: bipush 10
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 38 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 41	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 59	android/os/Parcel:readInt	()I
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 101	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   60: aload_3
    //   61: invokevirtual 53	android/os/Parcel:recycle	()V
    //   64: aload_2
    //   65: invokevirtual 53	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 65	android/os/Parcel:writeInt	(I)V
    //   74: goto -45 -> 29
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 53	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 53	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ad
    //   0	88	1	paramBundle	Bundle
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	77	finally
    //   18	29	77	finally
    //   29	60	77	finally
    //   69	74	77	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */