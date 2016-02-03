package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.List;

public abstract interface hr
  extends IInterface
{
  public abstract void a(ey paramey)
    throws RemoteException;
  
  public abstract void a(ho paramho)
    throws RemoteException;
  
  public abstract void a(ho paramho, int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws RemoteException;
  
  public abstract void a(ho paramho, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void a(ho paramho, Uri paramUri, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(ho paramho, String paramString)
    throws RemoteException;
  
  public abstract void a(ho paramho, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void a(ho paramho, List<String> paramList)
    throws RemoteException;
  
  public abstract void b(ho paramho)
    throws RemoteException;
  
  public abstract void b(ho paramho, String paramString)
    throws RemoteException;
  
  public abstract void c(ho paramho, String paramString)
    throws RemoteException;
  
  public abstract void clearDefaultAccount()
    throws RemoteException;
  
  public abstract void d(ho paramho, String paramString)
    throws RemoteException;
  
  public abstract void e(ho paramho, String paramString)
    throws RemoteException;
  
  public abstract String eO()
    throws RemoteException;
  
  public abstract boolean eP()
    throws RemoteException;
  
  public abstract String eQ()
    throws RemoteException;
  
  public abstract String getAccountName()
    throws RemoteException;
  
  public abstract void removeMoment(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements hr
  {
    public static hr ax(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
      if ((localIInterface != null) && ((localIInterface instanceof hr))) {
        return (hr)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Uri localUri = null;
      ho localho;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = ey.CREATOR.x(paramParcel1);; paramParcel1 = null)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        paramParcel1 = getAccountName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        clearDefaultAccount();
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(ho.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localho = ho.a.au(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          localUri = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label454;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a(localho, localUri, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localUri = null;
          break;
        }
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localho = ho.a.au(paramParcel1.readStrongBinder());
        paramInt1 = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localUri = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        a(localho, paramInt1, str, localUri, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        removeMoment(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        c(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(ho.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        d(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        paramParcel1 = eO();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        boolean bool = eP();
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 43: 
        label454:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        paramParcel1 = eQ();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      e(ho.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements hr
    {
      private IBinder dU;
      
      a(IBinder paramIBinder)
      {
        this.dU = paramIBinder;
      }
      
      /* Error */
      public void a(ey paramey)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/internal/ey:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   33: iconst_4
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 50 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 53	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 56	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 56	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 56	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	paramey	ey
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
      public void a(ho paramho)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 64 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   34: bipush 8
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramho	ho
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void a(ho paramho, int paramInt1, int paramInt2, int paramInt3, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +75 -> 93
        //   21: aload_1
        //   22: invokeinterface 64 1 0
        //   27: astore_1
        //   28: aload 6
        //   30: aload_1
        //   31: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 6
        //   36: iload_2
        //   37: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   40: aload 6
        //   42: iload_3
        //   43: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   46: aload 6
        //   48: iload 4
        //   50: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   53: aload 6
        //   55: aload 5
        //   57: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   60: aload_0
        //   61: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   64: bipush 16
        //   66: aload 6
        //   68: aload 7
        //   70: iconst_0
        //   71: invokeinterface 50 5 0
        //   76: pop
        //   77: aload 7
        //   79: invokevirtual 53	android/os/Parcel:readException	()V
        //   82: aload 7
        //   84: invokevirtual 56	android/os/Parcel:recycle	()V
        //   87: aload 6
        //   89: invokevirtual 56	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore_1
        //   95: goto -67 -> 28
        //   98: astore_1
        //   99: aload 7
        //   101: invokevirtual 56	android/os/Parcel:recycle	()V
        //   104: aload 6
        //   106: invokevirtual 56	android/os/Parcel:recycle	()V
        //   109: aload_1
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	a
        //   0	111	1	paramho	ho
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
      public void a(ho paramho, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 7
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 8
        //   10: aload 7
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +94 -> 112
        //   21: aload_1
        //   22: invokeinterface 64 1 0
        //   27: astore_1
        //   28: aload 7
        //   30: aload_1
        //   31: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 7
        //   36: iload_2
        //   37: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   40: aload 7
        //   42: aload_3
        //   43: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   46: aload 4
        //   48: ifnull +69 -> 117
        //   51: aload 7
        //   53: iconst_1
        //   54: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   57: aload 4
        //   59: aload 7
        //   61: iconst_0
        //   62: invokevirtual 75	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
        //   65: aload 7
        //   67: aload 5
        //   69: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   72: aload 7
        //   74: aload 6
        //   76: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   83: bipush 14
        //   85: aload 7
        //   87: aload 8
        //   89: iconst_0
        //   90: invokeinterface 50 5 0
        //   95: pop
        //   96: aload 8
        //   98: invokevirtual 53	android/os/Parcel:readException	()V
        //   101: aload 8
        //   103: invokevirtual 56	android/os/Parcel:recycle	()V
        //   106: aload 7
        //   108: invokevirtual 56	android/os/Parcel:recycle	()V
        //   111: return
        //   112: aconst_null
        //   113: astore_1
        //   114: goto -86 -> 28
        //   117: aload 7
        //   119: iconst_0
        //   120: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   123: goto -58 -> 65
        //   126: astore_1
        //   127: aload 8
        //   129: invokevirtual 56	android/os/Parcel:recycle	()V
        //   132: aload 7
        //   134: invokevirtual 56	android/os/Parcel:recycle	()V
        //   137: aload_1
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	a
        //   0	139	1	paramho	ho
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
      
      public void a(ho paramho, Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label128:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (paramho != null)
            {
              paramho = paramho.asBinder();
              localParcel1.writeStrongBinder(paramho);
              if (paramUri != null)
              {
                localParcel1.writeInt(1);
                paramUri.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label128;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.dU.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramho = null;
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
      public void a(ho paramho, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: iconst_1
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 50 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 53	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 56	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 56	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 56	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramho	ho
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
      public void a(ho paramho, String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +60 -> 78
        //   21: aload_1
        //   22: invokeinterface 64 1 0
        //   27: astore_1
        //   28: aload 4
        //   30: aload_1
        //   31: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 4
        //   36: aload_2
        //   37: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 4
        //   42: aload_3
        //   43: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   50: iconst_2
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 50 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 53	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 56	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aconst_null
        //   79: astore_1
        //   80: goto -52 -> 28
        //   83: astore_1
        //   84: aload 5
        //   86: invokevirtual 56	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 56	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramho	ho
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
      public void a(ho paramho, List<String> paramList)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 86	android/os/Parcel:writeStringList	(Ljava/util/List;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 34
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramho	ho
        //   0	84	2	paramList	List<String>
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	72	finally
        //   19	26	72	finally
        //   26	57	72	finally
      }
      
      public IBinder asBinder()
      {
        return this.dU;
      }
      
      /* Error */
      public void b(ho paramho)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 64 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   34: bipush 19
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramho	ho
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void b(ho paramho, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: iconst_3
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 50 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 53	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 56	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 56	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 56	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramho	ho
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
      public void c(ho paramho, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 18
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramho	ho
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
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.dU.transact(6, localParcel1, localParcel2, 0);
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
      public void d(ho paramho, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 40
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramho	ho
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
      public void e(ho paramho, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 64 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/hr$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 44
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramho	ho
        //   0	84	2	paramString	String
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	72	finally
        //   19	26	72	finally
        //   26	57	72	finally
      }
      
      public String eO()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.dU.transact(41, localParcel1, localParcel2, 0);
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
      
      public boolean eP()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.dU.transact(42, localParcel1, localParcel2, 0);
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
      
      public String eQ()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.dU.transact(43, localParcel1, localParcel2, 0);
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
      
      public String getAccountName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.dU.transact(5, localParcel1, localParcel2, 0);
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
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          localParcel1.writeString(paramString);
          this.dU.transact(17, localParcel1, localParcel2, 0);
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
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */