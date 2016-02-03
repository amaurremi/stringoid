package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class bn
  implements bl
{
  private IBinder a;
  
  bn(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(bi parambi)
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 51 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   34: bipush 8
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 35 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 38	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 44	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 44	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 44	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 44	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bn
    //   0	74	1	parambi	bi
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void a(bi parambi, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 6
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 7
    //   10: aload 6
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +75 -> 93
    //   21: aload_1
    //   22: invokeinterface 51 1 0
    //   27: astore_1
    //   28: aload 6
    //   30: aload_1
    //   31: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 6
    //   36: iload_2
    //   37: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   40: aload 6
    //   42: iload_3
    //   43: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   46: aload 6
    //   48: iload 4
    //   50: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   53: aload 6
    //   55: aload 5
    //   57: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   64: bipush 16
    //   66: aload 6
    //   68: aload 7
    //   70: iconst_0
    //   71: invokeinterface 35 5 0
    //   76: pop
    //   77: aload 7
    //   79: invokevirtual 38	android/os/Parcel:readException	()V
    //   82: aload 7
    //   84: invokevirtual 44	android/os/Parcel:recycle	()V
    //   87: aload 6
    //   89: invokevirtual 44	android/os/Parcel:recycle	()V
    //   92: return
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -67 -> 28
    //   98: astore_1
    //   99: aload 7
    //   101: invokevirtual 44	android/os/Parcel:recycle	()V
    //   104: aload 6
    //   106: invokevirtual 44	android/os/Parcel:recycle	()V
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	bn
    //   0	111	1	parambi	bi
    //   0	111	2	paramInt1	int
    //   0	111	3	paramInt2	int
    //   0	111	4	paramInt3	int
    //   0	111	5	paramString	String
    //   3	102	6	localParcel1	Parcel
    //   8	92	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	98	finally
    //   21	28	98	finally
    //   28	82	98	finally
  }
  
  /* Error */
  public void a(bi parambi, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
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
    //   18: ifnull +94 -> 112
    //   21: aload_1
    //   22: invokeinterface 51 1 0
    //   27: astore_1
    //   28: aload 7
    //   30: aload_1
    //   31: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 7
    //   36: iload_2
    //   37: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   40: aload 7
    //   42: aload_3
    //   43: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 4
    //   48: ifnull +69 -> 117
    //   51: aload 7
    //   53: iconst_1
    //   54: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   57: aload 4
    //   59: aload 7
    //   61: iconst_0
    //   62: invokevirtual 69	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
    //   65: aload 7
    //   67: aload 5
    //   69: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   72: aload 7
    //   74: aload 6
    //   76: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   83: bipush 14
    //   85: aload 7
    //   87: aload 8
    //   89: iconst_0
    //   90: invokeinterface 35 5 0
    //   95: pop
    //   96: aload 8
    //   98: invokevirtual 38	android/os/Parcel:readException	()V
    //   101: aload 8
    //   103: invokevirtual 44	android/os/Parcel:recycle	()V
    //   106: aload 7
    //   108: invokevirtual 44	android/os/Parcel:recycle	()V
    //   111: return
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -86 -> 28
    //   117: aload 7
    //   119: iconst_0
    //   120: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   123: goto -58 -> 65
    //   126: astore_1
    //   127: aload 8
    //   129: invokevirtual 44	android/os/Parcel:recycle	()V
    //   132: aload 7
    //   134: invokevirtual 44	android/os/Parcel:recycle	()V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	bn
    //   0	139	1	parambi	bi
    //   0	139	2	paramInt	int
    //   0	139	3	paramString1	String
    //   0	139	4	paramUri	Uri
    //   0	139	5	paramString2	String
    //   0	139	6	paramString3	String
    //   3	130	7	localParcel1	Parcel
    //   8	120	8	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	126	finally
    //   21	28	126	finally
    //   28	46	126	finally
    //   51	65	126	finally
    //   65	101	126	finally
    //   117	123	126	finally
  }
  
  public void a(bi parambi, Uri paramUri, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label128:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
        if (parambi != null)
        {
          parambi = parambi.asBinder();
          localParcel1.writeStrongBinder(parambi);
          if (paramUri != null)
          {
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
            if (paramBundle == null) {
              break label128;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          parambi = null;
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
  
  /* Error */
  public void a(bi parambi, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +50 -> 66
    //   19: aload_1
    //   20: invokeinterface 51 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 35 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 38	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 44	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 44	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 44	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 44	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	bn
    //   0	83	1	parambi	bi
    //   0	83	2	paramString	String
    //   3	75	3	localParcel1	Parcel
    //   7	66	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	71	finally
    //   19	26	71	finally
    //   26	56	71	finally
  }
  
  /* Error */
  public void a(bi parambi, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +60 -> 78
    //   21: aload_1
    //   22: invokeinterface 51 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: aload_2
    //   37: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 35 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 38	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 44	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 44	android/os/Parcel:recycle	()V
    //   77: return
    //   78: aconst_null
    //   79: astore_1
    //   80: goto -52 -> 28
    //   83: astore_1
    //   84: aload 5
    //   86: invokevirtual 44	android/os/Parcel:recycle	()V
    //   89: aload 4
    //   91: invokevirtual 44	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	bn
    //   0	96	1	parambi	bi
    //   0	96	2	paramString1	String
    //   0	96	3	paramString2	String
    //   3	87	4	localParcel1	Parcel
    //   8	77	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	83	finally
    //   21	28	83	finally
    //   28	67	83	finally
  }
  
  /* Error */
  public void a(bi parambi, java.util.List paramList)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_1
    //   20: invokeinterface 51 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 80	android/os/Parcel:writeStringList	(Ljava/util/List;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   40: bipush 34
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 35 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 38	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 44	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	bn
    //   0	84	1	parambi	bi
    //   0	84	2	paramList	java.util.List
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  /* Error */
  public void a(ec paramec)
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
    //   20: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 84	com/google/android/gms/internal/ec:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   33: iconst_4
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 35 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 38	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 44	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 44	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 44	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	bn
    //   0	75	1	paramec	ec
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
      localParcel1.writeString(paramString);
      this.a.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
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
  
  /* Error */
  public void b(bi parambi)
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 51 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   34: bipush 19
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 35 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 38	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 44	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 44	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 44	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 44	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bn
    //   0	74	1	parambi	bi
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void b(bi parambi, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +50 -> 66
    //   19: aload_1
    //   20: invokeinterface 51 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   40: iconst_3
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 35 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 38	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 44	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 44	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 44	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 44	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	bn
    //   0	83	1	parambi	bi
    //   0	83	2	paramString	String
    //   3	75	3	localParcel1	Parcel
    //   7	66	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	71	finally
    //   19	26	71	finally
    //   26	56	71	finally
  }
  
  public String c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
      this.a.transact(41, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void c(bi parambi, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_1
    //   20: invokeinterface 51 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   40: bipush 18
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 35 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 38	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 44	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	bn
    //   0	84	1	parambi	bi
    //   0	84	2	paramString	String
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  /* Error */
  public void d(bi parambi, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_1
    //   20: invokeinterface 51 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/internal/bn:a	Landroid/os/IBinder;
    //   40: bipush 40
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 35 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 38	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 44	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	bn
    //   0	84	1	parambi	bi
    //   0	84	2	paramString	String
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  public boolean d()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
      this.a.transact(42, localParcel1, localParcel2, 0);
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
  
  public String e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
      this.a.transact(43, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */