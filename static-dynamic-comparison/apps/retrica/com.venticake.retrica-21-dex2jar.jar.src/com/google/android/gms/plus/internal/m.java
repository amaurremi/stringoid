package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.hr;

class m
  implements d
{
  private IBinder a;
  
  m(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.google.android.gms.internal.hg a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString)
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
    //   18: ifnull +85 -> 103
    //   21: aload_1
    //   22: invokeinterface 35 1 0
    //   27: astore_1
    //   28: aload 6
    //   30: aload_1
    //   31: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 6
    //   36: iload_2
    //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   40: aload 6
    //   42: iload_3
    //   43: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   46: aload 6
    //   48: iload 4
    //   50: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   53: aload 6
    //   55: aload 5
    //   57: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   64: bipush 16
    //   66: aload 6
    //   68: aload 7
    //   70: iconst_0
    //   71: invokeinterface 51 5 0
    //   76: pop
    //   77: aload 7
    //   79: invokevirtual 54	android/os/Parcel:readException	()V
    //   82: aload 7
    //   84: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   87: invokestatic 63	com/google/android/gms/internal/hg$a:J	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/hg;
    //   90: astore_1
    //   91: aload 7
    //   93: invokevirtual 66	android/os/Parcel:recycle	()V
    //   96: aload 6
    //   98: invokevirtual 66	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: areturn
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -77 -> 28
    //   108: astore_1
    //   109: aload 7
    //   111: invokevirtual 66	android/os/Parcel:recycle	()V
    //   114: aload 6
    //   116: invokevirtual 66	android/os/Parcel:recycle	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	m
    //   0	121	1	paramb	b
    //   0	121	2	paramInt1	int
    //   0	121	3	paramInt2	int
    //   0	121	4	paramInt3	int
    //   0	121	5	paramString	String
    //   3	112	6	localParcel1	Parcel
    //   8	102	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	108	finally
    //   21	28	108	finally
    //   28	91	108	finally
  }
  
  /* Error */
  public void a(com.google.android.gms.internal.ie paramie)
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
    //   26: invokevirtual 73	com/google/android/gms/internal/ie:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   33: iconst_4
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 51 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 54	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 66	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 66	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 66	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 66	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	m
    //   0	75	1	paramie	com.google.android.gms.internal.ie
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
  public void a(b paramb)
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
    //   19: invokeinterface 35 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   34: bipush 8
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 51 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 54	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 66	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 66	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 66	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	m
    //   0	74	1	paramb	b
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
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
    //   46: aload 4
    //   48: ifnull +69 -> 117
    //   51: aload 7
    //   53: iconst_1
    //   54: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   57: aload 4
    //   59: aload 7
    //   61: iconst_0
    //   62: invokevirtual 78	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
    //   65: aload 7
    //   67: aload 5
    //   69: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   72: aload 7
    //   74: aload 6
    //   76: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   83: bipush 14
    //   85: aload 7
    //   87: aload 8
    //   89: iconst_0
    //   90: invokeinterface 51 5 0
    //   95: pop
    //   96: aload 8
    //   98: invokevirtual 54	android/os/Parcel:readException	()V
    //   101: aload 8
    //   103: invokevirtual 66	android/os/Parcel:recycle	()V
    //   106: aload 7
    //   108: invokevirtual 66	android/os/Parcel:recycle	()V
    //   111: return
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -86 -> 28
    //   117: aload 7
    //   119: iconst_0
    //   120: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   123: goto -58 -> 65
    //   126: astore_1
    //   127: aload 8
    //   129: invokevirtual 66	android/os/Parcel:recycle	()V
    //   132: aload 7
    //   134: invokevirtual 66	android/os/Parcel:recycle	()V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	m
    //   0	139	1	paramb	b
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
  
  public void a(b paramb, Uri paramUri, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label128:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
        if (paramb != null)
        {
          paramb = paramb.asBinder();
          localParcel1.writeStrongBinder(paramb);
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
          paramb = null;
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
  public void a(b paramb, com.google.android.gms.internal.ie paramie)
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
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 73	com/google/android/gms/internal/ie:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   50: bipush 45
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 51 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 54	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 66	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 66	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 66	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	m
    //   0	102	1	paramb	b
    //   0	102	2	paramie	com.google.android.gms.internal.ie
    //   3	94	3	localParcel1	Parcel
    //   7	85	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
  
  /* Error */
  public void a(b paramb, String paramString)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 51 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 54	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 66	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 66	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 66	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 66	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	m
    //   0	83	1	paramb	b
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
  public void a(b paramb, String paramString1, String paramString2)
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
    //   22: invokeinterface 35 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: aload_2
    //   37: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 51 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 54	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 66	android/os/Parcel:recycle	()V
    //   77: return
    //   78: aconst_null
    //   79: astore_1
    //   80: goto -52 -> 28
    //   83: astore_1
    //   84: aload 5
    //   86: invokevirtual 66	android/os/Parcel:recycle	()V
    //   89: aload 4
    //   91: invokevirtual 66	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	m
    //   0	96	1	paramb	b
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
  public void a(b paramb, java.util.List<String> paramList)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 90	android/os/Parcel:writeStringList	(Ljava/util/List;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: bipush 34
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 51 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 54	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 66	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 66	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 66	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 66	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	m
    //   0	84	1	paramb	b
    //   0	84	2	paramList	java.util.List<String>
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  public void a(String paramString, hr paramhr1, hr paramhr2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
        localParcel1.writeString(paramString);
        if (paramhr1 != null)
        {
          localParcel1.writeInt(1);
          paramhr1.writeToParcel(localParcel1, 0);
          if (paramhr2 != null)
          {
            localParcel1.writeInt(1);
            paramhr2.writeToParcel(localParcel1, 0);
            this.a.transact(46, localParcel1, localParcel2, 0);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void b(b paramb)
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
    //   19: invokeinterface 35 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   34: bipush 19
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 51 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 54	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 66	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 66	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 66	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	m
    //   0	74	1	paramb	b
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void b(b paramb, String paramString)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: iconst_3
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 51 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 54	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 66	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 66	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 66	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 66	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	m
    //   0	83	1	paramb	b
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
  public void c(b paramb, String paramString)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: bipush 18
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 51 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 54	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 66	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 66	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 66	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 66	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	m
    //   0	84	1	paramb	b
    //   0	84	2	paramString	String
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  public void clearDefaultAccount()
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
  public void d(b paramb, String paramString)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: bipush 40
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 51 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 54	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 66	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 66	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 66	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 66	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	m
    //   0	84	1	paramb	b
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
  public void e(b paramb, String paramString)
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
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/plus/internal/m:a	Landroid/os/IBinder;
    //   40: bipush 44
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 51 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 54	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 66	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 66	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 66	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 66	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	m
    //   0	84	1	paramb	b
    //   0	84	2	paramString	String
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   19	26	72	finally
    //   26	57	72	finally
  }
  
  public String getAccountName()
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
  
  public String jU()
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
  
  public boolean jV()
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
  
  public String jW()
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
  
  public void removeMoment(String paramString)
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */