package com.google.android.gms.internal;

import android.os.IBinder;

class qb
  implements ln
{
  private IBinder a;
  
  qb(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public lk a(com.google.android.gms.dynamic.d paramd, com.google.android.gms.dynamic.c paramc, com.google.android.gms.wallet.fragment.WalletFragmentOptions paramWalletFragmentOptions, ll paramll)
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
    //   21: ifnull +114 -> 135
    //   24: aload_1
    //   25: invokeinterface 35 1 0
    //   30: astore_1
    //   31: aload 6
    //   33: aload_1
    //   34: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload_2
    //   38: ifnull +102 -> 140
    //   41: aload_2
    //   42: invokeinterface 41 1 0
    //   47: astore_1
    //   48: aload 6
    //   50: aload_1
    //   51: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   54: aload_3
    //   55: ifnull +90 -> 145
    //   58: aload 6
    //   60: iconst_1
    //   61: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   64: aload_3
    //   65: aload 6
    //   67: iconst_0
    //   68: invokevirtual 51	com/google/android/gms/wallet/fragment/WalletFragmentOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   71: aload 5
    //   73: astore_1
    //   74: aload 4
    //   76: ifnull +11 -> 87
    //   79: aload 4
    //   81: invokeinterface 54 1 0
    //   86: astore_1
    //   87: aload 6
    //   89: aload_1
    //   90: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   93: aload_0
    //   94: getfield 15	com/google/android/gms/internal/qb:a	Landroid/os/IBinder;
    //   97: iconst_1
    //   98: aload 6
    //   100: aload 7
    //   102: iconst_0
    //   103: invokeinterface 60 5 0
    //   108: pop
    //   109: aload 7
    //   111: invokevirtual 63	android/os/Parcel:readException	()V
    //   114: aload 7
    //   116: invokevirtual 66	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   119: invokestatic 72	com/google/android/gms/internal/lk$a:bo	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/lk;
    //   122: astore_1
    //   123: aload 7
    //   125: invokevirtual 75	android/os/Parcel:recycle	()V
    //   128: aload 6
    //   130: invokevirtual 75	android/os/Parcel:recycle	()V
    //   133: aload_1
    //   134: areturn
    //   135: aconst_null
    //   136: astore_1
    //   137: goto -106 -> 31
    //   140: aconst_null
    //   141: astore_1
    //   142: goto -94 -> 48
    //   145: aload 6
    //   147: iconst_0
    //   148: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   151: goto -80 -> 71
    //   154: astore_1
    //   155: aload 7
    //   157: invokevirtual 75	android/os/Parcel:recycle	()V
    //   160: aload 6
    //   162: invokevirtual 75	android/os/Parcel:recycle	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	qb
    //   0	167	1	paramd	com.google.android.gms.dynamic.d
    //   0	167	2	paramc	com.google.android.gms.dynamic.c
    //   0	167	3	paramWalletFragmentOptions	com.google.android.gms.wallet.fragment.WalletFragmentOptions
    //   0	167	4	paramll	ll
    //   1	71	5	localObject	Object
    //   6	155	6	localParcel1	android.os.Parcel
    //   11	145	7	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	154	finally
    //   24	31	154	finally
    //   31	37	154	finally
    //   41	48	154	finally
    //   48	54	154	finally
    //   58	71	154	finally
    //   79	87	154	finally
    //   87	123	154	finally
    //   145	151	154	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */