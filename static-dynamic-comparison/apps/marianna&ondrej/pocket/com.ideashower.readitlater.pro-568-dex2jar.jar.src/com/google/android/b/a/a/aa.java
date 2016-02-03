package com.google.android.b.a.a;

import android.os.IBinder;

final class aa
  implements y
{
  private IBinder a;
  
  aa(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public final void a(g paramg, int paramInt, String paramString1, String paramString2, String paramString3, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 7
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 8
    //   10: aload 7
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +93 -> 111
    //   21: aload_1
    //   22: invokeinterface 35 1 0
    //   27: astore_1
    //   28: aload 7
    //   30: aload_1
    //   31: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 7
    //   36: iload_2
    //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   40: aload 7
    //   42: aload_3
    //   43: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 7
    //   48: aload 4
    //   50: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   53: aload 7
    //   55: aload 5
    //   57: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload 6
    //   62: ifnull +54 -> 116
    //   65: aload 7
    //   67: iconst_1
    //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   71: aload 6
    //   73: aload 7
    //   75: iconst_0
    //   76: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   79: aload_0
    //   80: getfield 15	com/google/android/b/a/a/aa:a	Landroid/os/IBinder;
    //   83: iconst_1
    //   84: aload 7
    //   86: aload 8
    //   88: iconst_0
    //   89: invokeinterface 57 5 0
    //   94: pop
    //   95: aload 8
    //   97: invokevirtual 60	android/os/Parcel:readException	()V
    //   100: aload 8
    //   102: invokevirtual 63	android/os/Parcel:recycle	()V
    //   105: aload 7
    //   107: invokevirtual 63	android/os/Parcel:recycle	()V
    //   110: return
    //   111: aconst_null
    //   112: astore_1
    //   113: goto -85 -> 28
    //   116: aload 7
    //   118: iconst_0
    //   119: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   122: goto -43 -> 79
    //   125: astore_1
    //   126: aload 8
    //   128: invokevirtual 63	android/os/Parcel:recycle	()V
    //   131: aload 7
    //   133: invokevirtual 63	android/os/Parcel:recycle	()V
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	aa
    //   0	138	1	paramg	g
    //   0	138	2	paramInt	int
    //   0	138	3	paramString1	String
    //   0	138	4	paramString2	String
    //   0	138	5	paramString3	String
    //   0	138	6	paramBundle	android.os.Bundle
    //   3	129	7	localParcel1	android.os.Parcel
    //   8	119	8	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	125	finally
    //   21	28	125	finally
    //   28	60	125	finally
    //   65	79	125	finally
    //   79	100	125	finally
    //   116	122	125	finally
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */