package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

class qd
  implements lp
{
  private IBinder a;
  
  qd(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        localParcel1.writeInt(paramInt);
        if (paramFullWallet != null)
        {
          localParcel1.writeInt(1);
          paramFullWallet.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        localParcel1.writeInt(paramInt);
        if (paramMaskedWallet != null)
        {
          localParcel1.writeInt(1);
          paramMaskedWallet.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 25
    //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 5
    //   22: iload_1
    //   23: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   26: iload_2
    //   27: ifeq +61 -> 88
    //   30: iload 4
    //   32: istore_1
    //   33: aload 5
    //   35: iload_1
    //   36: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   39: aload_3
    //   40: ifnull +53 -> 93
    //   43: aload 5
    //   45: iconst_1
    //   46: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   49: aload_3
    //   50: aload 5
    //   52: iconst_0
    //   53: invokevirtual 42	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   56: aload_0
    //   57: getfield 15	com/google/android/gms/internal/qd:a	Landroid/os/IBinder;
    //   60: iconst_3
    //   61: aload 5
    //   63: aload 6
    //   65: iconst_0
    //   66: invokeinterface 48 5 0
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 51	android/os/Parcel:readException	()V
    //   77: aload 6
    //   79: invokevirtual 54	android/os/Parcel:recycle	()V
    //   82: aload 5
    //   84: invokevirtual 54	android/os/Parcel:recycle	()V
    //   87: return
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -57 -> 33
    //   93: aload 5
    //   95: iconst_0
    //   96: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   99: goto -43 -> 56
    //   102: astore_3
    //   103: aload 6
    //   105: invokevirtual 54	android/os/Parcel:recycle	()V
    //   108: aload 5
    //   110: invokevirtual 54	android/os/Parcel:recycle	()V
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	qd
    //   0	115	1	paramInt	int
    //   0	115	2	paramBoolean	boolean
    //   0	115	3	paramBundle	Bundle
    //   1	30	4	i	int
    //   6	103	5	localParcel1	Parcel
    //   11	93	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	26	102	finally
    //   33	39	102	finally
    //   43	56	102	finally
    //   56	77	102	finally
    //   93	99	102	finally
  }
  
  public void a(Status paramStatus, li paramli, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        if (paramStatus != null)
        {
          localParcel1.writeInt(1);
          paramStatus.writeToParcel(localParcel1, 0);
          if (paramli != null)
          {
            localParcel1.writeInt(1);
            paramli.writeToParcel(localParcel1, 0);
            if (paramBundle == null) {
              break label131;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label131:
      localParcel1.writeInt(0);
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void i(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +44 -> 65
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 42	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	com/google/android/gms/internal/qd:a	Landroid/os/IBinder;
    //   39: iconst_4
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 48 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 51	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 54	android/os/Parcel:recycle	()V
    //   60: aload_3
    //   61: invokevirtual 54	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   70: goto -35 -> 35
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 54	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 54	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	qd
    //   0	85	1	paramInt	int
    //   0	85	2	paramBundle	Bundle
    //   3	77	3	localParcel1	Parcel
    //   7	68	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	73	finally
    //   24	35	73	finally
    //   35	55	73	finally
    //   65	70	73	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */