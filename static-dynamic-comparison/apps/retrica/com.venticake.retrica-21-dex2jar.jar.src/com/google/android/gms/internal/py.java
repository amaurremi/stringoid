package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

class py
  implements lk
{
  private IBinder a;
  
  py(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(d paramd, WalletFragmentOptions paramWalletFragmentOptions, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label127:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (paramd != null)
        {
          paramd = paramd.asBinder();
          localParcel1.writeStrongBinder(paramd);
          if (paramWalletFragmentOptions != null)
          {
            localParcel1.writeInt(1);
            paramWalletFragmentOptions.writeToParcel(localParcel1, 0);
            if (paramBundle == null) {
              break label127;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public int getState()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
      this.a.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void initialize(com.google.android.gms.wallet.fragment.WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 73	com/google/android/gms/wallet/fragment/WalletFragmentInitParams:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   33: bipush 10
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 57 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 60	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 63	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 63	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 63	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	py
    //   0	76	1	paramWalletFragmentInitParams	com.google.android.gms.wallet.fragment.WalletFragmentInitParams
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: iload_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload 4
    //   25: iload_2
    //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   29: aload_3
    //   30: ifnull +49 -> 79
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 78	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   50: bipush 9
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: invokeinterface 57 5 0
    //   62: pop
    //   63: aload 5
    //   65: invokevirtual 60	android/os/Parcel:readException	()V
    //   68: aload 5
    //   70: invokevirtual 63	android/os/Parcel:recycle	()V
    //   73: aload 4
    //   75: invokevirtual 63	android/os/Parcel:recycle	()V
    //   78: return
    //   79: aload 4
    //   81: iconst_0
    //   82: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   85: goto -39 -> 46
    //   88: astore_3
    //   89: aload 5
    //   91: invokevirtual 63	android/os/Parcel:recycle	()V
    //   94: aload 4
    //   96: invokevirtual 63	android/os/Parcel:recycle	()V
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	py
    //   0	101	1	paramInt1	int
    //   0	101	2	paramInt2	int
    //   0	101	3	paramIntent	android.content.Intent
    //   3	92	4	localParcel1	Parcel
    //   8	82	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	29	88	finally
    //   33	46	88	finally
    //   46	68	88	finally
    //   79	85	88	finally
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 57 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 60	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 63	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 63	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 63	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 63	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	py
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
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 25
    //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +95 -> 116
    //   24: aload_1
    //   25: invokeinterface 35 1 0
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 4
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: invokeinterface 35 1 0
    //   50: astore_1
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   57: aload_3
    //   58: ifnull +63 -> 121
    //   61: aload 5
    //   63: iconst_1
    //   64: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   67: aload_3
    //   68: aload 5
    //   70: iconst_0
    //   71: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   74: aload_0
    //   75: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   78: iconst_3
    //   79: aload 5
    //   81: aload 6
    //   83: iconst_0
    //   84: invokeinterface 57 5 0
    //   89: pop
    //   90: aload 6
    //   92: invokevirtual 60	android/os/Parcel:readException	()V
    //   95: aload 6
    //   97: invokevirtual 85	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   100: invokestatic 91	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
    //   103: astore_1
    //   104: aload 6
    //   106: invokevirtual 63	android/os/Parcel:recycle	()V
    //   109: aload 5
    //   111: invokevirtual 63	android/os/Parcel:recycle	()V
    //   114: aload_1
    //   115: areturn
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -87 -> 31
    //   121: aload 5
    //   123: iconst_0
    //   124: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   127: goto -53 -> 74
    //   130: astore_1
    //   131: aload 6
    //   133: invokevirtual 63	android/os/Parcel:recycle	()V
    //   136: aload 5
    //   138: invokevirtual 63	android/os/Parcel:recycle	()V
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	py
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
  
  public void onPause()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +54 -> 69
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   33: bipush 8
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 57 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 60	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 68	android/os/Parcel:readInt	()I
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 98	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   60: aload_3
    //   61: invokevirtual 63	android/os/Parcel:recycle	()V
    //   64: aload_2
    //   65: invokevirtual 63	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   74: goto -45 -> 29
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 63	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 63	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	py
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
  
  public void onStart()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
  
  public void onStop()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
  
  public void setEnabled(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(12, localParcel1, localParcel2, 0);
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
  public void updateMaskedWallet(com.google.android.gms.wallet.MaskedWallet paramMaskedWallet)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 107	com/google/android/gms/wallet/MaskedWallet:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   33: bipush 14
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 57 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 60	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 63	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 63	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 63	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	py
    //   0	76	1	paramMaskedWallet	com.google.android.gms.wallet.MaskedWallet
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void updateMaskedWalletRequest(com.google.android.gms.wallet.MaskedWalletRequest paramMaskedWalletRequest)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 112	com/google/android/gms/wallet/MaskedWalletRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/py:a	Landroid/os/IBinder;
    //   33: bipush 11
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 57 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 60	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 63	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 63	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 63	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	py
    //   0	76	1	paramMaskedWalletRequest	com.google.android.gms.wallet.MaskedWalletRequest
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/py.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */