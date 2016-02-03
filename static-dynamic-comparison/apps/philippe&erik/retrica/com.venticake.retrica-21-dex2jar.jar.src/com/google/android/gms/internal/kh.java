package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

class kh
  implements bu
{
  private IBinder a;
  
  kh(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(d paramd, ai paramai, String paramString, bv parambv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 25
    //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +93 -> 114
    //   24: aload_1
    //   25: invokeinterface 35 1 0
    //   30: astore_1
    //   31: aload 6
    //   33: aload_1
    //   34: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload_2
    //   38: ifnull +81 -> 119
    //   41: aload 6
    //   43: iconst_1
    //   44: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   47: aload_2
    //   48: aload 6
    //   50: iconst_0
    //   51: invokevirtual 48	com/google/android/gms/internal/ai:writeToParcel	(Landroid/os/Parcel;I)V
    //   54: aload 6
    //   56: aload_3
    //   57: invokevirtual 51	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload 5
    //   62: astore_1
    //   63: aload 4
    //   65: ifnull +11 -> 76
    //   68: aload 4
    //   70: invokeinterface 54 1 0
    //   75: astore_1
    //   76: aload 6
    //   78: aload_1
    //   79: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   82: aload_0
    //   83: getfield 15	com/google/android/gms/internal/kh:a	Landroid/os/IBinder;
    //   86: iconst_3
    //   87: aload 6
    //   89: aload 7
    //   91: iconst_0
    //   92: invokeinterface 60 5 0
    //   97: pop
    //   98: aload 7
    //   100: invokevirtual 63	android/os/Parcel:readException	()V
    //   103: aload 7
    //   105: invokevirtual 66	android/os/Parcel:recycle	()V
    //   108: aload 6
    //   110: invokevirtual 66	android/os/Parcel:recycle	()V
    //   113: return
    //   114: aconst_null
    //   115: astore_1
    //   116: goto -85 -> 31
    //   119: aload 6
    //   121: iconst_0
    //   122: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   125: goto -71 -> 54
    //   128: astore_1
    //   129: aload 7
    //   131: invokevirtual 66	android/os/Parcel:recycle	()V
    //   134: aload 6
    //   136: invokevirtual 66	android/os/Parcel:recycle	()V
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	kh
    //   0	141	1	paramd	d
    //   0	141	2	paramai	ai
    //   0	141	3	paramString	String
    //   0	141	4	parambv	bv
    //   1	60	5	localObject	Object
    //   6	129	6	localParcel1	Parcel
    //   11	119	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	128	finally
    //   24	31	128	finally
    //   31	37	128	finally
    //   41	54	128	finally
    //   54	60	128	finally
    //   68	76	128	finally
    //   76	103	128	finally
    //   119	125	128	finally
  }
  
  /* Error */
  public void a(d paramd, ai paramai, String paramString1, String paramString2, bv parambv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 7
    //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 8
    //   13: aload 7
    //   15: ldc 25
    //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +101 -> 122
    //   24: aload_1
    //   25: invokeinterface 35 1 0
    //   30: astore_1
    //   31: aload 7
    //   33: aload_1
    //   34: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload_2
    //   38: ifnull +89 -> 127
    //   41: aload 7
    //   43: iconst_1
    //   44: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   47: aload_2
    //   48: aload 7
    //   50: iconst_0
    //   51: invokevirtual 48	com/google/android/gms/internal/ai:writeToParcel	(Landroid/os/Parcel;I)V
    //   54: aload 7
    //   56: aload_3
    //   57: invokevirtual 51	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload 7
    //   62: aload 4
    //   64: invokevirtual 51	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   67: aload 6
    //   69: astore_1
    //   70: aload 5
    //   72: ifnull +11 -> 83
    //   75: aload 5
    //   77: invokeinterface 54 1 0
    //   82: astore_1
    //   83: aload 7
    //   85: aload_1
    //   86: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   89: aload_0
    //   90: getfield 15	com/google/android/gms/internal/kh:a	Landroid/os/IBinder;
    //   93: bipush 7
    //   95: aload 7
    //   97: aload 8
    //   99: iconst_0
    //   100: invokeinterface 60 5 0
    //   105: pop
    //   106: aload 8
    //   108: invokevirtual 63	android/os/Parcel:readException	()V
    //   111: aload 8
    //   113: invokevirtual 66	android/os/Parcel:recycle	()V
    //   116: aload 7
    //   118: invokevirtual 66	android/os/Parcel:recycle	()V
    //   121: return
    //   122: aconst_null
    //   123: astore_1
    //   124: goto -93 -> 31
    //   127: aload 7
    //   129: iconst_0
    //   130: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   133: goto -79 -> 54
    //   136: astore_1
    //   137: aload 8
    //   139: invokevirtual 66	android/os/Parcel:recycle	()V
    //   142: aload 7
    //   144: invokevirtual 66	android/os/Parcel:recycle	()V
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	kh
    //   0	149	1	paramd	d
    //   0	149	2	paramai	ai
    //   0	149	3	paramString1	String
    //   0	149	4	paramString2	String
    //   0	149	5	parambv	bv
    //   1	67	6	localObject	Object
    //   6	137	7	localParcel1	Parcel
    //   11	127	8	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	136	finally
    //   24	31	136	finally
    //   31	37	136	finally
    //   41	54	136	finally
    //   54	67	136	finally
    //   75	83	136	finally
    //   83	111	136	finally
    //   127	133	136	finally
  }
  
  public void a(d paramd, al paramal, ai paramai, String paramString, bv parambv)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label159:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (paramd != null)
        {
          paramd = paramd.asBinder();
          localParcel1.writeStrongBinder(paramd);
          if (paramal != null)
          {
            localParcel1.writeInt(1);
            paramal.writeToParcel(localParcel1, 0);
            if (paramai == null) {
              break label159;
            }
            localParcel1.writeInt(1);
            paramai.writeToParcel(localParcel1, 0);
            localParcel1.writeString(paramString);
            paramd = (d)localObject;
            if (parambv != null) {
              paramd = parambv.asBinder();
            }
            localParcel1.writeStrongBinder(paramd);
            this.a.transact(1, localParcel1, localParcel2, 0);
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
  
  public void a(d paramd, al paramal, ai paramai, String paramString1, String paramString2, bv parambv)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label167:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (paramd != null)
        {
          paramd = paramd.asBinder();
          localParcel1.writeStrongBinder(paramd);
          if (paramal != null)
          {
            localParcel1.writeInt(1);
            paramal.writeToParcel(localParcel1, 0);
            if (paramai == null) {
              break label167;
            }
            localParcel1.writeInt(1);
            paramai.writeToParcel(localParcel1, 0);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            paramd = (d)localObject;
            if (parambv != null) {
              paramd = parambv.asBinder();
            }
            localParcel1.writeStrongBinder(paramd);
            this.a.transact(6, localParcel1, localParcel2, 0);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void destroy()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
  
  public d getView()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      d locald = d.a.ag(localParcel2.readStrongBinder());
      return locald;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void pause()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
  
  public void resume()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
  
  public void showInterstitial()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */